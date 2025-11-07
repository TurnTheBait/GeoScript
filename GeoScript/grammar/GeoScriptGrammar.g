grammar GeoScriptGrammar;

options { language=Java; output=AST; }

@header {
  import java.util.Map;
  import java.util.HashMap;
}


@members {
  Map<String,String> colorTable = new HashMap<String,String>();
  boolean canvasDefined = false;
}

prog        : (statement)+ EOF ;
statement   : canvasStmt | colorDef | shapeStmt ;

canvasStmt
  : 'CANVAS' '(' width=INT ',' height=INT ')' ';'
    {
      canvasDefined = true;
      System.out.println("Canvas created: " + $width.text + "x" + $height.text);
    }
  ;

colorDef
  : 'DEF' ID '=' HEX_COLOR ';'
    { colorTable.put($ID.text, $HEX_COLOR.text); }
  ;

shapeStmt   : rectStmt | circleStmt | lineStmt ;

rectStmt
  : 'RECT' 'AT' '(' INT ',' INT ')' 'SIZE' '(' INT ',' INT ')'
    ('FILL' (ID|HEX_COLOR))? ('STROKE' (ID|HEX_COLOR))? ';'
    { if(!canvasDefined) System.err.println("Error: Canvas not defined before RECT."); }
  ;

circleStmt
  : 'CIRCLE' 'AT' '(' INT ',' INT ')' 'RADIUS' INT
    ('FILL' (ID|HEX_COLOR))? ('STROKE' (ID|HEX_COLOR))? ';'
    { if(!canvasDefined) System.err.println("Error: Canvas not defined before CIRCLE."); }
  ;

lineStmt
  : 'LINE' 'FROM' '(' INT ',' INT ')' 'TO' '(' INT ',' INT ')' 'STROKE' (ID|HEX_COLOR) ';'
    { if(!canvasDefined) System.err.println("Error: Canvas not defined before LINE."); }
  ;

HEX_COLOR : '#' (('A'..'F')|('a'..'f')|('0'..'9'))+ ;
ID        : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT       : ('0'..'9')+ ;
WS        : (' '|'\t'|'\r'|'\n')+ { $channel=HIDDEN; } ;
