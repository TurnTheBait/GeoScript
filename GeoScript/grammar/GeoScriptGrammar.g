grammar GeoScriptGrammar;

options {
  language = Java;
  k = 1;
}

@header {
  package myCompilerPackage;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import java.io.FileWriter;
  import java.io.IOException;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;
}

@members {
  public static class SemanticHandler {
    public Map<String,String> colors = new HashMap<String,String>();
    public Map<String,Integer> vars = new HashMap<String,Integer>();
    public boolean canvasDefined = false;
    public int canvasW = 800;
    public int canvasH = 600;
    
    private StringBuilder svgContent = new StringBuilder();

    public void defineColor(String id, String hex) {
      colors.put(id, hex);
    }

    public void checkColor(String name, Token tk) {
      if (name == null || name.startsWith("#")) return;
      if (!colors.containsKey(name))
        System.err.println("Warning: color '" + name + "' not defined at line " + tk.getLine());
    }

    public void defineVar(String id, int value) {
      vars.put(id, value);
    }

    public int getVarValue(String id) {
      if (!vars.containsKey(id)) return 0;
      return vars.get(id);
    }

    public void setVar(String id, int value) {
      vars.put(id, value);
    }

    public void setCanvas(int w, int h) {
      canvasDefined = true;
      canvasW = w;
      canvasH = h;
    }

    public void addSvgElement(String element) {
      svgContent.append(element).append("\n");
    }

    public void exportSVG(String filename) {
      StringBuilder sb = new StringBuilder();
      sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"").append(canvasW).append("\" height=\"").append(canvasH).append("\">\n");
      sb.append("<rect width=\"").append(canvasW).append("\" height=\"").append(canvasH).append("\" fill=\"white\"/>\n");
      sb.append(svgContent.toString());
      sb.append("</svg>");
      try {
        FileWriter fw = new FileWriter(filename);
        fw.write(sb.toString());
        fw.close();
        System.out.println("SVG exported to: " + filename);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  SemanticHandler sem = new SemanticHandler();

  public static interface Expr { int eval(SemanticHandler sem); }
  public static interface Command { void execute(SemanticHandler sem); }

  public static class ConstExpr implements Expr {
    int v;
    public ConstExpr(int v){ this.v = v; }
    public int eval(SemanticHandler s){ return v; }
  }

  public static class VarExpr implements Expr {
    String id;
    public VarExpr(String id){ this.id = id; }
    public int eval(SemanticHandler s){ return s.getVarValue(id); }
  }

  public static class BinExpr implements Expr {
    Expr left; Expr right; String op;
    public BinExpr(Expr l, String op, Expr r){ left=l; this.op=op; right=r; }
    public int eval(SemanticHandler s){
      int L = left.eval(s);
      int R = right.eval(s);
      if (op.equals("+")) return L+R;
      if (op.equals("-")) return L-R;
      if (op.equals("*")) return L*R;
      if (op.equals("/")) return R==0 ? 0 : L/R;
      if (op.equals("==")) return (L == R) ? 1 : 0;
      if (op.equals("!=")) return (L != R) ? 1 : 0;
      if (op.equals("<")) return (L < R) ? 1 : 0;
      if (op.equals(">")) return (L > R) ? 1 : 0;
      return 0;
    }
  }

  public static class VarDeclCommand implements Command {
    String id; Expr expr;
    public VarDeclCommand(String id, Expr e){ this.id=id; expr=e; }
    public void execute(SemanticHandler sem){ sem.defineVar(id, expr.eval(sem)); }
  }

  public static class AssignCommand implements Command {
    String id; Expr expr;
    public AssignCommand(String id, Expr e){ this.id=id; expr=e; }
    public void execute(SemanticHandler sem){ sem.setVar(id, expr.eval(sem)); }
  }

  public static class IfCommand implements Command {
    Expr cond; List<Command> thenBody; List<Command> elseBody;
    public IfCommand(Expr c, List<Command> t, List<Command> e){ cond=c; thenBody=t; elseBody=e; }
    public void execute(SemanticHandler sem){
      if (cond.eval(sem) != 0) {
        for(Command c: thenBody) c.execute(sem);
      } else if (elseBody != null) {
        for(Command c: elseBody) c.execute(sem);
      }
    }
  }

  public static class WhileCommand implements Command {
    Expr cond; List<Command> body;
    public WhileCommand(Expr c, List<Command> b){ cond=c; body=b; }
    public void execute(SemanticHandler sem){
      while (cond.eval(sem) != 0) {
        for(Command c: body) c.execute(sem);
      }
    }
  }

  public static class ForCommand implements Command {
    Command init; Expr cond; Command incr; List<Command> body;
    public ForCommand(Command init, Expr cond, Command incr, List<Command> body){
      this.init=init; this.cond=cond; this.incr=incr; this.body=body;
    }
    public void execute(SemanticHandler sem){
      if (init != null) init.execute(sem);
      while (cond.eval(sem) != 0) {
        for (Command c: body) c.execute(sem);
        if (incr != null) incr.execute(sem);
      }
    }
  }

  public static class ShapeCommand implements Command {
    String kind;
    Expr[] exprs;
    String fill; String stroke; Token fillToken; Token strokeToken;

    public ShapeCommand(String kind, Expr[] exprs, String fill, Token fillToken, String stroke, Token strokeToken){
      this.kind = kind; this.exprs = exprs; 
      this.fill = fill; this.fillToken = fillToken; 
      this.stroke = stroke; this.strokeToken = strokeToken;
    }

    public void execute(SemanticHandler sem){
      if (!sem.canvasDefined && !kind.equals("TEXT")) return; 
      if (fill != null && !fill.startsWith("#") && !kind.equals("TEXT")) sem.checkColor(fill, fillToken);
      if (stroke != null && !stroke.startsWith("#")) sem.checkColor(stroke, strokeToken);

      int[] nums = new int[exprs.length];
      for(int i=0; i<exprs.length; i++) nums[i] = exprs[i].eval(sem);

      String style = "";
      StringBuilder sb = new StringBuilder();
      if (fill != null && !kind.equals("TEXT")) {
         String c = fill.startsWith("#") ? fill : sem.colors.get(fill);
         sb.append(" fill=\"").append(c != null ? c : "none").append("\"");
      } else if (!kind.equals("TEXT")) {
         sb.append(" fill=\"none\"");
      }
      if (stroke != null) {
         String c = stroke.startsWith("#") ? stroke : sem.colors.get(stroke);
         sb.append(" stroke=\"").append(c != null ? c : "black").append("\" stroke-width=\"2\"");
      } else {
         sb.append(" stroke=\"none\"");
      }
      style = sb.toString();

      String svg = "";
      if (kind.equals("RECT")) {
        svg = "<rect x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" width=\"" + nums[2] + "\" height=\"" + nums[3] + "\" " + style + " />";
      } 
      else if (kind.equals("CIRCLE")) {
        svg = "<circle cx=\"" + nums[0] + "\" cy=\"" + nums[1] + "\" r=\"" + nums[2] + "\" " + style + " />";
      }
      else if (kind.equals("LINE")) {
        svg = "<line x1=\"" + nums[0] + "\" y1=\"" + nums[1] + "\" x2=\"" + nums[2] + "\" y2=\"" + nums[3] + "\" " + style + " />";
      }
      else if (kind.equals("SQUARE")) {
        svg = "<rect x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" width=\"" + nums[2] + "\" height=\"" + nums[2] + "\" " + style + " />";
      }
      else if (kind.equals("ELLIPSE")) {
        svg = "<ellipse cx=\"" + nums[0] + "\" cy=\"" + nums[1] + "\" rx=\"" + nums[2] + "\" ry=\"" + nums[3] + "\" " + style + " />";
      }
      else if (kind.equals("TRIANGLE")) {
         svg = "<polygon points=\"" + nums[0] + "," + nums[1] + " " + nums[2] + "," + nums[3] + " " + nums[4] + "," + nums[5] + "\" " + style + " />";
      }
      else if (kind.equals("POLYGON")) {
        StringBuilder pts = new StringBuilder();
        for(int i=0; i<nums.length; i+=2) pts.append(nums[i]).append(",").append(nums[i+1]).append(" ");
        svg = "<polygon points=\"" + pts.toString().trim() + "\" " + style + " />";
      }
      else if (kind.equals("TEXT")) {
        String textColor = "black";
        if (stroke != null) {
            String c = stroke.startsWith("#") ? stroke : sem.colors.get(stroke);
            if (c != null) textColor = c;
        }
        svg = "<text x=\"" + nums[0] + "\" y=\"" + nums[1] + "\" fill=\"" + textColor + "\">" + fill + "</text>";
      }
      
      sem.addSvgElement(svg);
    }
  }

  List<Command> program = new ArrayList<Command>();

  Expr makeConst(int v){ return new ConstExpr(v); }
  Expr makeVarExpr(String id){ return new VarExpr(id); }
  Expr makeBin(Expr l, String op, Expr r){ return new BinExpr(l,op,r); }
  Command makeVarDecl(String id, Expr e){ return new VarDeclCommand(id,e); }
  Command makeAssign(String id, Expr e){ return new AssignCommand(id,e); }

  @Override
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    String hdr = "Line " + e.line + ":" + e.charPositionInLine;
    String msg = getErrorMessage(e, tokenNames);
    System.err.println("Syntax error " + hdr + ": " + msg);
  }
}

prog
  : (s=statement { if ($s.cmd != null) program.add($s.cmd); })* EOF
    {
      for (Command c : program) {
        c.execute(sem);
      }
      sem.exportSVG("output.svg");
    }
  ;

statement returns [Command cmd]
  : canvasStmt       { $cmd = null; }
  | colorDef         { $cmd = null; }
  | varDeclStmt      { $cmd = $varDeclStmt.cmd; }
  | assignStmt       { $cmd = $assignStmt.cmd; }
  | ifStmt           { $cmd = $ifStmt.cmd; }
  | whileStmt        { $cmd = $whileStmt.cmd; }
  | forStmt          { $cmd = $forStmt.cmd; }
  | transformStmt    { $cmd = null; }
  | shapeStmt        { $cmd = $shapeStmt.cmd; }
  | COMMENTLINE      { $cmd = null; }
  ;

canvasStmt
  : 'CANVAS' '(' w=INT ',' h=INT ')' ';'
    { sem.setCanvas(Integer.parseInt($w.getText()), Integer.parseInt($h.getText())); }
  ;

colorDef
  : 'DEF' id=ID '=' hex=HEX_COLOR ';'
    { sem.defineColor($id.getText(), $hex.getText()); }
  ;

varDeclStmt returns [Command cmd]
  : 'VAR' id=ID '=' e=expr ';'
    { $cmd = makeVarDecl($id.getText(), $e.expr); }
  ;

assignStmt returns [Command cmd]
  : id=ID '=' e=expr ';'
    { $cmd = makeAssign($id.getText(), $e.expr); }
  ;

ifStmt returns [Command cmd]
@init {
  List<Command> thenList = new ArrayList<Command>();
  List<Command> elseList = new ArrayList<Command>();
}
  : 'IF' '(' cond=expr ')' 'THEN' '{' 
       (s=statement { if ($s.cmd != null) thenList.add($s.cmd); })* '}' 
    ( 'ELSE' '{' 
       (s2=statement { if ($s2.cmd != null) elseList.add($s2.cmd); })* '}' )?
    {
      $cmd = new IfCommand($cond.expr, thenList, elseList.isEmpty() ? null : elseList);
    }
  ;

whileStmt returns [Command cmd]
@init {
  List<Command> loopBody = new ArrayList<Command>();
}
  : 'WHILE' '(' cond=expr ')' '{' 
       (s=statement { if ($s.cmd != null) loopBody.add($s.cmd); })* '}'
    {
      $cmd = new WhileCommand($cond.expr, loopBody);
    }
  ;

forStmt returns [Command cmd]
@init {
  List<Command> loopBody = new ArrayList<Command>();
}
  : 'FOR' '(' 
      init=forInitHeader ';' 
      cond=expr ';' 
      incr=forIncrHeader 
    ')' '{' 
       (s=statement { if ($s.cmd != null) loopBody.add($s.cmd); })* '}'
    {
      $cmd = new ForCommand($init.cmd, $cond.expr, $incr.cmd, loopBody);
    }
  ;

forInitHeader returns [Command cmd]
  : 'VAR' id=ID '=' e=expr { $cmd = makeVarDecl($id.getText(), $e.expr); }
  | c=assignSimple { $cmd = $c.cmd; }
  | { $cmd = null; }
  ;

forIncrHeader returns [Command cmd]
  : c=assignSimple { $cmd = $c.cmd; }
  | { $cmd = null; }
  ;

transformStmt
  : 'ROTATE' a=INT ';'
  | 'TRANSLATE' '(' x=expr ',' y=expr ')' ';'
  | 'SCALE' '(' sx=expr ',' sy=expr ')' ';'
  ;

shapeStmt returns [Command cmd]
  : 'RECT' 'AT' '(' x=expr ',' y=expr ')' 'SIZE' '(' w=expr ',' h=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $x.expr, $y.expr, $w.expr, $h.expr };
      $cmd = new ShapeCommand("RECT", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'CIRCLE' 'AT' '(' x=expr ',' y=expr ')' 'RADIUS' r=expr ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $x.expr, $y.expr, $r.expr };
      $cmd = new ShapeCommand("CIRCLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'LINE' 'FROM' '(' x1=expr ',' y1=expr ')' 'TO' '(' x2=expr ',' y2=expr ')' 'STROKE' st=(ID|HEX_COLOR) ';'
    {
      Expr[] ex = new Expr[]{ $x1.expr, $y1.expr, $x2.expr, $y2.expr };
      $cmd = new ShapeCommand("LINE", ex, null, null, (st!=null?st.getText():null), st);
    }
  | 'SQUARE' 'AT' '(' x=expr ',' y=expr ')' 'SIZE' sz=expr ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $x.expr, $y.expr, $sz.expr };
      $cmd = new ShapeCommand("SQUARE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'TRIANGLE' 'AT' '(' x=expr ',' y=expr ')' 'POINTS' '(' p1x=expr ',' p1y=expr ',' p2x=expr ',' p2y=expr ',' p3x=expr ',' p3y=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $p1x.expr, $p1y.expr, $p2x.expr, $p2y.expr, $p3x.expr, $p3y.expr };
      $cmd = new ShapeCommand("TRIANGLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'ELLIPSE' 'AT' '(' x=expr ',' y=expr ')' 'RADII' '(' rx=expr ',' ry=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $x.expr, $y.expr, $rx.expr, $ry.expr };
      $cmd = new ShapeCommand("ELLIPSE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'POLYGON' 'POINTS' '(' pts=pointList ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = $pts.list.toArray(new Expr[0]);
      $cmd = new ShapeCommand("POLYGON", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'TEXT' '(' str=STRING ',' x=expr ',' y=expr ')' ( 'COLOR' c=(ID|HEX_COLOR) )? ';'
    {
      Expr[] ex = new Expr[]{ $x.expr, $y.expr };
      String text = $str.getText();
      if (text.length()>=2) text = text.substring(1,text.length()-1);
      $cmd = new ShapeCommand("TEXT", ex, text, null, (c!=null?c.getText():null), c);
    }
  ;

pointList returns [List<Expr> list]
@init { $list = new ArrayList<Expr>(); }
  : a=expr { $list.add($a.expr); } ',' b=expr { $list.add($b.expr); }
    ( ',' c=expr { $list.add($c.expr); } ',' d=expr { $list.add($d.expr); } )*
  ;

expr returns [Expr expr]
  : a=addExpr { $expr = $a.expr; }
    ( op=('<'|'>'|'=='|'!=') b=addExpr { $expr = makeBin($expr, $op.text, $b.expr); } )*
  ;

addExpr returns [Expr expr]
  : a=term { $expr = $a.expr; }
    ( '+' b=term { $expr = makeBin($expr, "+", $b.expr); }
    | '-' b2=term { $expr = makeBin($expr, "-", $b2.expr); }
    )*
  ;

term returns [Expr expr]
  : f=factor { $expr = $f.expr; }
    ( '*' g=factor { $expr = makeBin($expr, "*", $g.expr); }
    | '/' g2=factor { $expr = makeBin($expr, "/", $g2.expr); }
    )*
  ;

factor returns [Expr expr]
  : n=INT { $expr = makeConst(Integer.parseInt($n.getText())); }
  | id=ID { $expr = makeVarExpr($id.getText()); }
  | '(' e=expr ')' { $expr = $e.expr; }
  ;

assignSimple returns [Command cmd]
  : id=ID '=' e=expr
    { $cmd = makeAssign($id.getText(), $e.expr); }
  ;

HEX_COLOR : '#' ( '0'..'9' | 'A'..'F' | 'a'..'f' )+ ;
ID        : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT       : ('0'..'9')+ ;
STRING    : '"' ( '\\' . | ~('"' | '\r' | '\n') )* '"' ;

COMMENT     : '/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; } ;
COMMENTLINE : '//' ~('\n'|'\r')* { $channel = HIDDEN; } ;
WS          : ( ' ' | '\t' | '\r' | '\n' )+ { $channel=HIDDEN; } ;