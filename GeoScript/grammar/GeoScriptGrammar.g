grammar GeoScript;

options {
  language = Java;
  k = 1;
  output = AST;
}

@header {
  package myCompilerPackage;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;
}

@members {
  // -------------------------
  // Semantic handler
  // -------------------------
  public static class SemanticHandler {
    public Map<String,String> colors = new HashMap<String,String>();
    public Map<String,Integer> vars = new HashMap<String,Integer>();
    public boolean canvasDefined = false;
    public int canvasW = 0;
    public int canvasH = 0;

    public void defineColor(String id, String hex) {
      colors.put(id, hex);
      System.out.println("Defined color " + id + " = " + hex);
    }
    public void checkColor(String name, Token tk) {
      if (name == null) return;
      if (name.startsWith("#")) return;
      if (!colors.containsKey(name))
        System.err.println("Warning: color '" + name + "' not defined at line " + tk.getLine());
    }

    public void defineVar(String id, int value) {
      vars.put(id, value);
      System.out.println("VAR " + id + " = " + value);
    }
    public boolean isVarDefined(String id) { return vars.containsKey(id); }
    public int getVarValue(String id) {
      if (!vars.containsKey(id)) {
        System.err.println("Warning: variable '" + id + "' undefined (0 default)");
        return 0;
      }
      return vars.get(id);
    }

    public void setVar(String id, int value) {
      if (!vars.containsKey(id))
        System.err.println("Warning: assigning undeclared variable '" + id + "'");
      vars.put(id, value);
    }

    public void setCanvas(int w, int h) {
      canvasDefined = true;
      canvasW = w;
      canvasH = h;
      System.out.println("Canvas set to " + w + "x" + h);
    }
  } // end SemanticHandler

  // interpreter state
  SemanticHandler sem = new SemanticHandler();

  // Program as list of commands
  public static interface Expr { int eval(SemanticHandler sem); }
  public static interface Command { void execute(SemanticHandler sem); }

  // Expr implementations
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
      if (op.equals("/")) {
        if (R==0) { System.err.println("Div0"); return 0; }
        return L/R;
      }
      return 0;
    }
  }

  // Command implementations
  public static class VarDeclCommand implements Command {
    String id; Expr expr;
    public VarDeclCommand(String id, Expr e){ this.id=id; expr=e; }
    public void execute(SemanticHandler sem){ int v = expr.eval(sem); sem.defineVar(id, v); }
  }
  public static class AssignCommand implements Command {
    String id; Expr expr;
    public AssignCommand(String id, Expr e){ this.id=id; expr=e; }
    public void execute(SemanticHandler sem){ int v = expr.eval(sem); sem.setVar(id, v); }
  }
  public static class IfCommand implements Command {
    Expr cond; List<Command> thenBody; List<Command> elseBody;
    public IfCommand(Expr c, List<Command> t, List<Command> e){ cond=c; thenBody=t; elseBody=e; }
    public void execute(SemanticHandler sem){
      boolean r = cond.eval(sem) != 0;
      System.out.println("IF evaluated: " + r);
      if (r) {
        for(Command c: thenBody) c.execute(sem);
      } else {
        if (elseBody != null) for(Command c: elseBody) c.execute(sem);
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

  // Generic shape command (prints and does semantic checks)
  public static class ShapeCommand implements Command {
    String kind;
    int[] nums; // coordinates or sizes (evaluated at creation)
    String fill; String stroke; Token fillToken; Token strokeToken;
    public ShapeCommand(String kind, int[] nums, String fill, Token fillToken, String stroke, Token strokeToken){
      this.kind = kind; this.nums = nums; this.fill = fill; this.fillToken = fillToken; this.stroke = stroke; this.strokeToken = strokeToken;
    }
    public void execute(SemanticHandler sem){
      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before " + kind);
      if (fill != null && !fill.startsWith("#")) sem.checkColor(fill, fillToken);
      if (stroke != null && !stroke.startsWith("#")) sem.checkColor(stroke, strokeToken);
      // Print a compact description (customize per kind)
      if (kind.equals("RECT")) System.out.println("RECT at ("+nums[0]+","+nums[1]+") size ("+nums[2]+","+nums[3]+")");
      else if (kind.equals("CIRCLE")) System.out.println("CIRCLE at ("+nums[0]+","+nums[1]+") r="+nums[2]);
      else if (kind.equals("LINE")) System.out.println("LINE from ("+nums[0]+","+nums[1]+") to ("+nums[2]+","+nums[3]+")");
      else if (kind.equals("SQUARE")) System.out.println("SQUARE at ("+nums[0]+","+nums[1]+") size "+nums[2]);
      else if (kind.equals("TRIANGLE")) System.out.println("TRIANGLE at ("+nums[0]+","+nums[1]+") points ("+nums[2]+","+nums[3]+","+nums[4]+","+nums[5]+")");
      else if (kind.equals("ELLIPSE")) System.out.println("ELLIPSE ("+nums[0]+","+nums[1]+") radii ("+nums[2]+","+nums[3]+")");
      else if (kind.equals("POLYGON")) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++){ if (i>0) sb.append(","); sb.append(nums[i]); }
        System.out.println("POLYGON points "+sb.toString());
      }
      else if (kind.equals("TEXT")) System.out.println("TEXT at ("+nums[0]+","+nums[1]+") text: "+(fill==null?"":fill)); // reuse fill for string text here
    }
  }

  // Program container
  List<Command> program = new ArrayList<Command>();

  // Helpers to build Exprs/Commands
  Expr makeConst(int v){ return new ConstExpr(v); }
  Expr makeVarExpr(String id){ return new VarExpr(id); }
  Expr makeBin(Expr l, String op, Expr r){ return new BinExpr(l,op,r); }

  Command makeVarDecl(String id, Expr e){ return new VarDeclCommand(id,e); }
  Command makeAssign(String id, Expr e){ return new AssignCommand(id,e); }

  void addCommand(Command c){ program.add(c); }

  @Override
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    String hdr = "Line " + e.line + ":" + e.charPositionInLine;
    String msg = getErrorMessage(e, tokenNames);
    Token tk = input.LT(1);
    System.err.println("Syntax error " + hdr + " at token '" + tk.getText() + "': " + msg);
  }
} // end @members

// -------------------------
// Grammar rules
// -------------------------

prog
  : (s=statement { if ($s.cmd != null) program.add($s.cmd); })* EOF
    {
      // execute program after parsing
      for (Command c : program) {
        c.execute(sem);
      }
    }
  ;

// We'll give statement a return value (a Command)
statement returns [Command cmd]
  : canvasStmt       { $cmd = null; }               // canvas handled immediately by sem in action
  | colorDef         { $cmd = null; }
  | varDeclStmt      { $cmd = $varDeclStmt.cmd; }
  | assignStmt       { $cmd = $assignStmt.cmd; }
  | ifStmt           { $cmd = $ifStmt.cmd; }
  | whileStmt        { $cmd = $whileStmt.cmd; }
  | forStmt          { $cmd = $forStmt.cmd; }
  | transformStmt    { $cmd = null; } // transforms simply print
  | shapeStmt        { $cmd = $shapeStmt.cmd; }
  | COMMENTLINE      { $cmd = null; }
  ;

//
// Canvas
//
canvasStmt
  : 'CANVAS' '(' w=INT ',' h=INT ')' ';'
    { sem.setCanvas(Integer.parseInt($w.getText()), Integer.parseInt($h.getText())); }
  ;

//
// Colors
//
colorDef
  : 'DEF' id=ID '=' hex=HEX_COLOR ';'
    { sem.defineColor($id.getText(), $hex.getText()); }
  ;

//
// Variable declaration as statement (returns Command)
//
varDeclStmt returns [Command cmd]
  : 'VAR' id=ID '=' e=expr ';'
    { $cmd = makeVarDecl($id.getText(), $e.expr); }
  ;

assignStmt returns [Command cmd]
  : id=ID '=' e=expr ';'
    { $cmd = makeAssign($id.getText(), $e.expr); }
  ;

//
// IF
//
ifStmt returns [Command cmd]
  : 'IF' '(' cond=expr ')' 'THEN' '{' thenSt+=statement* '}' ( 'ELSE' '{' elseSt+=statement* '}' )?
    {
      List<Command> thenBody = new ArrayList<Command>();
      for(Object o : $thenSt) { statement_return st = (statement_return)o; if (st.cmd!=null) thenBody.add(st.cmd); }
      List<Command> elseBody = null;
      if ($elseSt != null) {
        elseBody = new ArrayList<Command>();
        for(Object o : $elseSt) { statement_return st = (statement_return)o; if (st.cmd!=null) elseBody.add(st.cmd); }
      }
      $cmd = new IfCommand($cond.expr, thenBody, elseBody);
    }
  ;

//
// WHILE
//
whileStmt returns [Command cmd]
  : 'WHILE' '(' cond=expr ')' '{' body+=statement* '}'
    {
      List<Command> b = new ArrayList<Command>();
      for(Object o : $body) { statement_return st = (statement_return)o; if (st.cmd!=null) b.add(st.cmd); }
      $cmd = new WhileCommand($cond.expr, b);
    }
  ;

//
// FOR (we parse init/cond/incr inline and generate a ForCommand)
//
forStmt returns [Command cmd]
  : 'FOR' '('
      ( 'VAR' forInitId=ID '=' forInitExpr=expr ';' { /* var init */ }
      | forInitAssign=assignSimple ';' { /* assign init */ }
      | ';' { /* empty init */ }
      )
      cond=expr ';'
      ( incrAssign=assignSimple | ';' )
    ')' '{' body+=statement* '}'
    {
      // build init command
      Command initCmd = null;
      if ($forInitId != null) {
        initCmd = makeVarDecl($forInitId.getText(), $forInitExpr.expr);
      } else if ($forInitAssign != null) {
        initCmd = $forInitAssign.cmd;
      }
      // incr
      Command incrCmd = null;
      if ($incrAssign != null) incrCmd = $incrAssign.cmd;

      List<Command> b = new ArrayList<Command>();
      for(Object o : $body) { statement_return st = (statement_return)o; if (st.cmd!=null) b.add(st.cmd); }

      $cmd = new ForCommand(initCmd, $cond.expr, incrCmd, b);
    }
  ;

//
// Transformations (just print; no command created)
//
transformStmt
  : 'ROTATE' a=INT ';'      { System.out.println("ROTATE " + $a.getText()); }
  | 'TRANSLATE' '(' x=expr ',' y=expr ')' ';' { System.out.println("TRANSLATE ("+$x.expr.eval(sem)+","+ $y.expr.eval(sem)+")"); }
  | 'SCALE' '(' sx=expr ',' sy=expr ')' ';'   { System.out.println("SCALE ("+$sx.expr.eval(sem)+","+ $sy.expr.eval(sem)+")"); }
  ;

//
// Shape statements create ShapeCommand objects
//
shapeStmt returns [Command cmd]
  : 'RECT' 'AT' '(' x=expr ',' y=expr ')' 'SIZE' '(' w=expr ',' h=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' s=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem), $w.expr.eval(sem), $h.expr.eval(sem) };
      String fillStr = (f!=null?f.getText():null);
      String strokeStr = (s!=null?s.getText():null);
      $cmd = new ShapeCommand("RECT", nums, fillStr, f, strokeStr, s);
    }
  | 'CIRCLE' 'AT' '(' x=expr ',' y=expr ')' 'RADIUS' r=expr ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' s=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem), $r.expr.eval(sem) };
      String fillStr = (f!=null?f.getText():null);
      String strokeStr = (s!=null?s.getText():null);
      $cmd = new ShapeCommand("CIRCLE", nums, fillStr, f, strokeStr, s);
    }
  | 'LINE' 'FROM' '(' x1=expr ',' y1=expr ')' 'TO' '(' x2=expr ',' y2=expr ')' 'STROKE' s=(ID|HEX_COLOR) ';'
    {
      int[] nums = new int[]{ $x1.expr.eval(sem), $y1.expr.eval(sem), $x2.expr.eval(sem), $y2.expr.eval(sem) };
      $cmd = new ShapeCommand("LINE", nums, null, null, (s!=null?s.getText():null), s);
    }
  | 'SQUARE' 'AT' '(' x=expr ',' y=expr ')' 'SIZE' s=expr ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem), $s.expr.eval(sem) };
      $cmd = new ShapeCommand("SQUARE", nums, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'TRIANGLE' 'AT' '(' x=expr ',' y=expr ')' 'POINTS' '(' x2=expr ',' y2=expr ',' x3=expr ',' y3=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem), $x2.expr.eval(sem), $y2.expr.eval(sem), $x3.expr.eval(sem), $y3.expr.eval(sem) };
      $cmd = new ShapeCommand("TRIANGLE", nums, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'ELLIPSE' 'AT' '(' x=expr ',' y=expr ')' 'RADII' '(' rx=expr ',' ry=expr ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem), $rx.expr.eval(sem), $ry.expr.eval(sem) };
      $cmd = new ShapeCommand("ELLIPSE", nums, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'POLYGON' 'POINTS' '(' pts=pointList ')' ( 'FILL' f=(ID|HEX_COLOR) )? ( 'STROKE' st=(ID|HEX_COLOR) )? ';'
    {
      // pts.text is comma-separated integers
      String[] parts = $pts.text.split(",");
      int[] nums = new int[parts.length];
      for (int i=0;i<parts.length;i++) nums[i] = Integer.parseInt(parts[i]);
      $cmd = new ShapeCommand("POLYGON", nums, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
    }
  | 'TEXT' '(' str=STRING ',' x=expr ',' y=expr ')' ( 'COLOR' c=(ID|HEX_COLOR) )? ';'
    {
      int[] nums = new int[]{ $x.expr.eval(sem), $y.expr.eval(sem) };
      // use fill slot to store the literal text (strip quotes)
      String text = $str.getText();
      if (text.length()>=2) text = text.substring(1,text.length()-1);
      $cmd = new ShapeCommand("TEXT", nums, text, null, (c!=null?c.getText():null), c);
    }
  ;

pointList returns [String text]
  : a=expr ',' b=expr ( ',' c=expr ',' d=expr { if ($text==null) $text = $a.expr.eval(sem) + "," + $b.expr.eval(sem) + "," + $c.expr.eval(sem) + "," + $d.expr.eval(sem); else $text += ","+$c.expr.eval(sem)+ "," + $d.expr.eval(sem); } )*
    { if ($text==null) $text = $a.expr.eval(sem) + "," + $b.expr.eval(sem); }
  ;

//
// Expressions produce Expr objects (deferred evaluation)
//
expr returns [Expr expr]
  : a=term { $expr = $a.expr; }
    ( '+' b=term { $expr = makeBin($expr, "+", $b.expr); }
    | '-' b2=term { $expr = makeBin($expr, "-", $b2.expr); }
    )*
  ;

term returns [Expr expr]
  : f=factor { $expr = $f.expr; }
    ( '*' g=factor { $expr = makeBin($expr, "*", $g.expr); }
    | '/' g2=factor { $expr = makeBin($expr, "/", $g2.expr); }
    | '%' g3=factor { $expr = makeBin($expr, "%", $g3.expr); }
    )*
  ;

factor returns [Expr expr]
  : n=INT { $expr = makeConst(Integer.parseInt($n.getText())); }
  | id=ID { $expr = makeVarExpr($id.getText()); }
  | '(' e=expr ')' { $expr = $e.expr; }
  ;

//
// Simple assign used in for header (returns Command)
//
fragment_assign returns [Command cmd]
  : id=ID '=' e=expr
    { $cmd = makeAssign($id.getText(), $e.expr); }
  ;

assignSimple returns [Command cmd]
  : id=ID '=' e=expr
    { $cmd = makeAssign($id.getText(), $e.expr); }
  ;

//
// Tokens & lexical rules
//
HEX_COLOR : '#' ( '0'..'9' | 'A'..'F' | 'a'..'f' )+ ;
ID        : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT       : ('0'..'9')+ ;
STRING
  : '"' ( '\\' . | ~('"' | '\r' | '\n') )* '"' ;

COMMENT
  : '/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; } ;
COMMENTLINE : '//' ~('\n'|'\r')* { $channel = HIDDEN; } ;
WS        : ( ' ' | '\t' | '\r' | '\n' )+ { $channel=HIDDEN; } ;