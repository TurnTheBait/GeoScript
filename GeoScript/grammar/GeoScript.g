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
  
  import myPackage.SemanticHandler;
  import myPackage.SemanticHandler.*; 
}

@members {
  public SemanticHandler sem = new SemanticHandler();
  
  public List<Command> programList = new ArrayList<Command>();

  @Override
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    String hdr = "Line " + e.line + ":" + e.charPositionInLine;
    String msg = getErrorMessage(e, tokenNames);
    System.err.println("Syntax error " + hdr + ": " + msg);
  }
}

// --- REGOLE DEL PARSER ---

prog
  : (s=statement { if ($s.cmd != null) programList.add($s.cmd); })* EOF
    {
      for (Command c : programList) {
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
    { $cmd = new VarDeclCommand($id.getText(), $e.expr); }
  ;

assignStmt returns [Command cmd]
  : id=ID '=' e=expr ';'
    { $cmd = new AssignCommand($id.getText(), $e.expr); }
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
  : 'VAR' id=ID '=' e=expr { $cmd = new VarDeclCommand($id.getText(), $e.expr); }
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

// ESPRESSIONI
expr returns [Expr expr]
  : a=addExpr { $expr = $a.expr; }
    ( op=('<'|'>'|'=='|'!=') b=addExpr { $expr = new BinExpr($expr, $op.text, $b.expr); } )*
  ;

addExpr returns [Expr expr]
  : a=term { $expr = $a.expr; }
    ( '+' b=term { $expr = new BinExpr($expr, "+", $b.expr); }
    | '-' b2=term { $expr = new BinExpr($expr, "-", $b2.expr); }
    )*
  ;

term returns [Expr expr]
  : f=factor { $expr = $f.expr; }
    ( '*' g=factor { $expr = new BinExpr($expr, "*", $g.expr); }
    | '/' g2=factor { $expr = new BinExpr($expr, "/", $g2.expr); }
    | m=MOD g3=factor { $expr = new BinExpr($expr, $m.text, $g3.expr); }
    )*
  ;

factor returns [Expr expr]
  : n=INT { $expr = new ConstExpr(Integer.parseInt($n.getText())); }
  | id=ID { $expr = new VarExpr($id.getText()); }
  | '(' e=expr ')' { $expr = $e.expr; }
  ;

assignSimple returns [Command cmd]
  : id=ID '=' e=expr
    { $cmd = new AssignCommand($id.getText(), $e.expr); }
  ;

// --- LEXER RULES ---

HEX_COLOR : '#' ( '0'..'9' | 'A'..'F' | 'a'..'f' )+ ;
ID        : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT       : ('0'..'9')+ ;
STRING    : '"' ( '\\' . | ~('"' | '\r' | '\n') )* '"' ;
MOD         : '%' ;
COMMENT     : '/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; } ;
COMMENTLINE : '//' ~('\n'|'\r')* { $channel = HIDDEN; } ;
WS          : ( ' ' | '\t' | '\r' | '\n' )+ { $channel=HIDDEN; } ;
