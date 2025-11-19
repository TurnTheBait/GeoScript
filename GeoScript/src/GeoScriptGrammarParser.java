
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import java.io.FileWriter;
  import java.io.IOException;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GeoScriptGrammarParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "COMMENTLINE", "HEX_COLOR", 
		"ID", "INT", "STRING", "WS", "'!='", "'('", "')'", "'*'", "'+'", "','", 
		"'-'", "'/'", "';'", "'<'", "'='", "'=='", "'>'", "'AT'", "'CANVAS'", 
		"'CIRCLE'", "'COLOR'", "'DEF'", "'ELLIPSE'", "'ELSE'", "'FILL'", "'FOR'", 
		"'FROM'", "'IF'", "'LINE'", "'POINTS'", "'POLYGON'", "'RADII'", "'RADIUS'", 
		"'RECT'", "'ROTATE'", "'SCALE'", "'SIZE'", "'SQUARE'", "'STROKE'", "'TEXT'", 
		"'THEN'", "'TO'", "'TRANSLATE'", "'TRIANGLE'", "'VAR'", "'WHILE'", "'{'", 
		"'}'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int COMMENT=4;
	public static final int COMMENTLINE=5;
	public static final int HEX_COLOR=6;
	public static final int ID=7;
	public static final int INT=8;
	public static final int STRING=9;
	public static final int WS=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public GeoScriptGrammarParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public GeoScriptGrammarParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return GeoScriptGrammarParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g"; }


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



	// $ANTLR start "prog"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:251:1: prog : (s= statement )* EOF ;
	public final void prog() throws RecognitionException {
		Command s =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:252:3: ( (s= statement )* EOF )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:252:5: (s= statement )* EOF
			{
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:252:5: (s= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COMMENTLINE||LA1_0==ID||(LA1_0 >= 25 && LA1_0 <= 26)||(LA1_0 >= 28 && LA1_0 <= 29)||LA1_0==32||(LA1_0 >= 34 && LA1_0 <= 35)||LA1_0==37||(LA1_0 >= 40 && LA1_0 <= 42)||LA1_0==44||LA1_0==46||(LA1_0 >= 49 && LA1_0 <= 52)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:252:6: s= statement
					{
					pushFollow(FOLLOW_statement_in_prog50);
					s=statement();
					state._fsp--;

					 if (s != null) program.add(s); 
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prog56); 

			      for (Command c : program) {
			        c.execute(sem);
			      }
			      sem.exportSVG("output.svg");
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "statement"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:261:1: statement returns [Command cmd] : ( canvasStmt | colorDef | varDeclStmt | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE );
	public final Command statement() throws RecognitionException {
		Command cmd = null;


		Command varDeclStmt1 =null;
		Command assignStmt2 =null;
		Command ifStmt3 =null;
		Command whileStmt4 =null;
		Command forStmt5 =null;
		Command shapeStmt6 =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:262:3: ( canvasStmt | colorDef | varDeclStmt | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE )
			int alt2=10;
			switch ( input.LA(1) ) {
			case 25:
				{
				alt2=1;
				}
				break;
			case 28:
				{
				alt2=2;
				}
				break;
			case 51:
				{
				alt2=3;
				}
				break;
			case ID:
				{
				alt2=4;
				}
				break;
			case 34:
				{
				alt2=5;
				}
				break;
			case 52:
				{
				alt2=6;
				}
				break;
			case 32:
				{
				alt2=7;
				}
				break;
			case 41:
			case 42:
			case 49:
				{
				alt2=8;
				}
				break;
			case 26:
			case 29:
			case 35:
			case 37:
			case 40:
			case 44:
			case 46:
			case 50:
				{
				alt2=9;
				}
				break;
			case COMMENTLINE:
				{
				alt2=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:262:5: canvasStmt
					{
					pushFollow(FOLLOW_canvasStmt_in_statement79);
					canvasStmt();
					state._fsp--;

					 cmd = null; 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:263:5: colorDef
					{
					pushFollow(FOLLOW_colorDef_in_statement93);
					colorDef();
					state._fsp--;

					 cmd = null; 
					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:264:5: varDeclStmt
					{
					pushFollow(FOLLOW_varDeclStmt_in_statement109);
					varDeclStmt1=varDeclStmt();
					state._fsp--;

					 cmd = varDeclStmt1; 
					}
					break;
				case 4 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:265:5: assignStmt
					{
					pushFollow(FOLLOW_assignStmt_in_statement122);
					assignStmt2=assignStmt();
					state._fsp--;

					 cmd = assignStmt2; 
					}
					break;
				case 5 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:266:5: ifStmt
					{
					pushFollow(FOLLOW_ifStmt_in_statement136);
					ifStmt3=ifStmt();
					state._fsp--;

					 cmd = ifStmt3; 
					}
					break;
				case 6 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:267:5: whileStmt
					{
					pushFollow(FOLLOW_whileStmt_in_statement154);
					whileStmt4=whileStmt();
					state._fsp--;

					 cmd = whileStmt4; 
					}
					break;
				case 7 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:268:5: forStmt
					{
					pushFollow(FOLLOW_forStmt_in_statement169);
					forStmt5=forStmt();
					state._fsp--;

					 cmd = forStmt5; 
					}
					break;
				case 8 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:269:5: transformStmt
					{
					pushFollow(FOLLOW_transformStmt_in_statement186);
					transformStmt();
					state._fsp--;

					 cmd = null; 
					}
					break;
				case 9 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:270:5: shapeStmt
					{
					pushFollow(FOLLOW_shapeStmt_in_statement197);
					shapeStmt6=shapeStmt();
					state._fsp--;

					 cmd = shapeStmt6; 
					}
					break;
				case 10 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:271:5: COMMENTLINE
					{
					match(input,COMMENTLINE,FOLLOW_COMMENTLINE_in_statement212); 
					 cmd = null; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "statement"



	// $ANTLR start "canvasStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:274:1: canvasStmt : 'CANVAS' '(' w= INT ',' h= INT ')' ';' ;
	public final void canvasStmt() throws RecognitionException {
		Token w=null;
		Token h=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:275:3: ( 'CANVAS' '(' w= INT ',' h= INT ')' ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:275:5: 'CANVAS' '(' w= INT ',' h= INT ')' ';'
			{
			match(input,25,FOLLOW_25_in_canvasStmt232); 
			match(input,12,FOLLOW_12_in_canvasStmt234); 
			w=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt238); 
			match(input,16,FOLLOW_16_in_canvasStmt240); 
			h=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt244); 
			match(input,13,FOLLOW_13_in_canvasStmt246); 
			match(input,19,FOLLOW_19_in_canvasStmt248); 
			 sem.setCanvas(Integer.parseInt(w.getText()), Integer.parseInt(h.getText())); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "canvasStmt"



	// $ANTLR start "colorDef"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:279:1: colorDef : 'DEF' id= ID '=' hex= HEX_COLOR ';' ;
	public final void colorDef() throws RecognitionException {
		Token id=null;
		Token hex=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:280:3: ( 'DEF' id= ID '=' hex= HEX_COLOR ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:280:5: 'DEF' id= ID '=' hex= HEX_COLOR ';'
			{
			match(input,28,FOLLOW_28_in_colorDef267); 
			id=(Token)match(input,ID,FOLLOW_ID_in_colorDef271); 
			match(input,21,FOLLOW_21_in_colorDef273); 
			hex=(Token)match(input,HEX_COLOR,FOLLOW_HEX_COLOR_in_colorDef277); 
			match(input,19,FOLLOW_19_in_colorDef279); 
			 sem.defineColor(id.getText(), hex.getText()); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "colorDef"



	// $ANTLR start "varDeclStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:284:1: varDeclStmt returns [Command cmd] : 'VAR' id= ID '=' e= expr ';' ;
	public final Command varDeclStmt() throws RecognitionException {
		Command cmd = null;


		Token id=null;
		Expr e =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:285:3: ( 'VAR' id= ID '=' e= expr ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:285:5: 'VAR' id= ID '=' e= expr ';'
			{
			match(input,51,FOLLOW_51_in_varDeclStmt302); 
			id=(Token)match(input,ID,FOLLOW_ID_in_varDeclStmt306); 
			match(input,21,FOLLOW_21_in_varDeclStmt308); 
			pushFollow(FOLLOW_expr_in_varDeclStmt312);
			e=expr();
			state._fsp--;

			match(input,19,FOLLOW_19_in_varDeclStmt314); 
			 cmd = makeVarDecl(id.getText(), e); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "varDeclStmt"



	// $ANTLR start "assignStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:289:1: assignStmt returns [Command cmd] : id= ID '=' e= expr ';' ;
	public final Command assignStmt() throws RecognitionException {
		Command cmd = null;


		Token id=null;
		Expr e =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:290:3: (id= ID '=' e= expr ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:290:5: id= ID '=' e= expr ';'
			{
			id=(Token)match(input,ID,FOLLOW_ID_in_assignStmt339); 
			match(input,21,FOLLOW_21_in_assignStmt341); 
			pushFollow(FOLLOW_expr_in_assignStmt345);
			e=expr();
			state._fsp--;

			match(input,19,FOLLOW_19_in_assignStmt347); 
			 cmd = makeAssign(id.getText(), e); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "assignStmt"



	// $ANTLR start "ifStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:294:1: ifStmt returns [Command cmd] : 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )? ;
	public final Command ifStmt() throws RecognitionException {
		Command cmd = null;


		Expr cond =null;
		Command s =null;
		Command s2 =null;


		  List<Command> thenList = new ArrayList<Command>();
		  List<Command> elseList = new ArrayList<Command>();

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:299:3: ( 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )? )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:299:5: 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )?
			{
			match(input,34,FOLLOW_34_in_ifStmt375); 
			match(input,12,FOLLOW_12_in_ifStmt377); 
			pushFollow(FOLLOW_expr_in_ifStmt381);
			cond=expr();
			state._fsp--;

			match(input,13,FOLLOW_13_in_ifStmt383); 
			match(input,47,FOLLOW_47_in_ifStmt385); 
			match(input,53,FOLLOW_53_in_ifStmt387); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:300:8: (s= statement )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMENTLINE||LA3_0==ID||(LA3_0 >= 25 && LA3_0 <= 26)||(LA3_0 >= 28 && LA3_0 <= 29)||LA3_0==32||(LA3_0 >= 34 && LA3_0 <= 35)||LA3_0==37||(LA3_0 >= 40 && LA3_0 <= 42)||LA3_0==44||LA3_0==46||(LA3_0 >= 49 && LA3_0 <= 52)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:300:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_ifStmt400);
					s=statement();
					state._fsp--;

					 if (s != null) thenList.add(s); 
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,54,FOLLOW_54_in_ifStmt406); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:301:5: ( 'ELSE' '{' (s2= statement )* '}' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==30) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:301:7: 'ELSE' '{' (s2= statement )* '}'
					{
					match(input,30,FOLLOW_30_in_ifStmt415); 
					match(input,53,FOLLOW_53_in_ifStmt417); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:302:8: (s2= statement )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMENTLINE||LA4_0==ID||(LA4_0 >= 25 && LA4_0 <= 26)||(LA4_0 >= 28 && LA4_0 <= 29)||LA4_0==32||(LA4_0 >= 34 && LA4_0 <= 35)||LA4_0==37||(LA4_0 >= 40 && LA4_0 <= 42)||LA4_0==44||LA4_0==46||(LA4_0 >= 49 && LA4_0 <= 52)) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:302:9: s2= statement
							{
							pushFollow(FOLLOW_statement_in_ifStmt430);
							s2=statement();
							state._fsp--;

							 if (s2 != null) elseList.add(s2); 
							}
							break;

						default :
							break loop4;
						}
					}

					match(input,54,FOLLOW_54_in_ifStmt436); 
					}
					break;

			}


			      cmd = new IfCommand(cond, thenList, elseList.isEmpty() ? null : elseList);
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "ifStmt"



	// $ANTLR start "whileStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:308:1: whileStmt returns [Command cmd] : 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}' ;
	public final Command whileStmt() throws RecognitionException {
		Command cmd = null;


		Expr cond =null;
		Command s =null;


		  List<Command> loopBody = new ArrayList<Command>();

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:312:3: ( 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:312:5: 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}'
			{
			match(input,52,FOLLOW_52_in_whileStmt467); 
			match(input,12,FOLLOW_12_in_whileStmt469); 
			pushFollow(FOLLOW_expr_in_whileStmt473);
			cond=expr();
			state._fsp--;

			match(input,13,FOLLOW_13_in_whileStmt475); 
			match(input,53,FOLLOW_53_in_whileStmt477); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:313:8: (s= statement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMENTLINE||LA6_0==ID||(LA6_0 >= 25 && LA6_0 <= 26)||(LA6_0 >= 28 && LA6_0 <= 29)||LA6_0==32||(LA6_0 >= 34 && LA6_0 <= 35)||LA6_0==37||(LA6_0 >= 40 && LA6_0 <= 42)||LA6_0==44||LA6_0==46||(LA6_0 >= 49 && LA6_0 <= 52)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:313:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_whileStmt490);
					s=statement();
					state._fsp--;

					 if (s != null) loopBody.add(s); 
					}
					break;

				default :
					break loop6;
				}
			}

			match(input,54,FOLLOW_54_in_whileStmt496); 

			      cmd = new WhileCommand(cond, loopBody);
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "whileStmt"



	// $ANTLR start "forStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:319:1: forStmt returns [Command cmd] : 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}' ;
	public final Command forStmt() throws RecognitionException {
		Command cmd = null;


		Command init =null;
		Expr cond =null;
		Command incr =null;
		Command s =null;


		  List<Command> loopBody = new ArrayList<Command>();

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:323:3: ( 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:323:5: 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}'
			{
			match(input,32,FOLLOW_32_in_forStmt524); 
			match(input,12,FOLLOW_12_in_forStmt526); 
			pushFollow(FOLLOW_forInitHeader_in_forStmt537);
			init=forInitHeader();
			state._fsp--;

			match(input,19,FOLLOW_19_in_forStmt539); 
			pushFollow(FOLLOW_expr_in_forStmt550);
			cond=expr();
			state._fsp--;

			match(input,19,FOLLOW_19_in_forStmt552); 
			pushFollow(FOLLOW_forIncrHeader_in_forStmt563);
			incr=forIncrHeader();
			state._fsp--;

			match(input,13,FOLLOW_13_in_forStmt570); 
			match(input,53,FOLLOW_53_in_forStmt572); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:328:8: (s= statement )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMENTLINE||LA7_0==ID||(LA7_0 >= 25 && LA7_0 <= 26)||(LA7_0 >= 28 && LA7_0 <= 29)||LA7_0==32||(LA7_0 >= 34 && LA7_0 <= 35)||LA7_0==37||(LA7_0 >= 40 && LA7_0 <= 42)||LA7_0==44||LA7_0==46||(LA7_0 >= 49 && LA7_0 <= 52)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:328:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_forStmt585);
					s=statement();
					state._fsp--;

					 if (s != null) loopBody.add(s); 
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,54,FOLLOW_54_in_forStmt591); 

			      cmd = new ForCommand(init, cond, incr, loopBody);
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "forStmt"



	// $ANTLR start "forInitHeader"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:334:1: forInitHeader returns [Command cmd] : ( 'VAR' id= ID '=' e= expr |c= assignSimple |);
	public final Command forInitHeader() throws RecognitionException {
		Command cmd = null;


		Token id=null;
		Expr e =null;
		Command c =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:335:3: ( 'VAR' id= ID '=' e= expr |c= assignSimple |)
			int alt8=3;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt8=1;
				}
				break;
			case ID:
				{
				alt8=2;
				}
				break;
			case 19:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:335:5: 'VAR' id= ID '=' e= expr
					{
					match(input,51,FOLLOW_51_in_forInitHeader614); 
					id=(Token)match(input,ID,FOLLOW_ID_in_forInitHeader618); 
					match(input,21,FOLLOW_21_in_forInitHeader620); 
					pushFollow(FOLLOW_expr_in_forInitHeader624);
					e=expr();
					state._fsp--;

					 cmd = makeVarDecl(id.getText(), e); 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:336:5: c= assignSimple
					{
					pushFollow(FOLLOW_assignSimple_in_forInitHeader634);
					c=assignSimple();
					state._fsp--;

					 cmd = c; 
					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:337:5: 
					{
					 cmd = null; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "forInitHeader"



	// $ANTLR start "forIncrHeader"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:340:1: forIncrHeader returns [Command cmd] : (c= assignSimple |);
	public final Command forIncrHeader() throws RecognitionException {
		Command cmd = null;


		Command c =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:341:3: (c= assignSimple |)
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==13) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:341:5: c= assignSimple
					{
					pushFollow(FOLLOW_assignSimple_in_forIncrHeader661);
					c=assignSimple();
					state._fsp--;

					 cmd = c; 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:342:5: 
					{
					 cmd = null; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "forIncrHeader"



	// $ANTLR start "transformStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:345:1: transformStmt : ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' );
	public final void transformStmt() throws RecognitionException {
		Token a=null;
		Expr x =null;
		Expr y =null;
		Expr sx =null;
		Expr sy =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:346:3: ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case 41:
				{
				alt10=1;
				}
				break;
			case 49:
				{
				alt10=2;
				}
				break;
			case 42:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:346:5: 'ROTATE' a= INT ';'
					{
					match(input,41,FOLLOW_41_in_transformStmt682); 
					a=(Token)match(input,INT,FOLLOW_INT_in_transformStmt686); 
					match(input,19,FOLLOW_19_in_transformStmt688); 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:347:5: 'TRANSLATE' '(' x= expr ',' y= expr ')' ';'
					{
					match(input,49,FOLLOW_49_in_transformStmt694); 
					match(input,12,FOLLOW_12_in_transformStmt696); 
					pushFollow(FOLLOW_expr_in_transformStmt700);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_transformStmt702); 
					pushFollow(FOLLOW_expr_in_transformStmt706);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_transformStmt708); 
					match(input,19,FOLLOW_19_in_transformStmt710); 
					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:348:5: 'SCALE' '(' sx= expr ',' sy= expr ')' ';'
					{
					match(input,42,FOLLOW_42_in_transformStmt716); 
					match(input,12,FOLLOW_12_in_transformStmt718); 
					pushFollow(FOLLOW_expr_in_transformStmt722);
					sx=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_transformStmt724); 
					pushFollow(FOLLOW_expr_in_transformStmt728);
					sy=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_transformStmt730); 
					match(input,19,FOLLOW_19_in_transformStmt732); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "transformStmt"



	// $ANTLR start "shapeStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:351:1: shapeStmt returns [Command cmd] : ( 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';' | 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' );
	public final Command shapeStmt() throws RecognitionException {
		Command cmd = null;


		Token f=null;
		Token st=null;
		Token str=null;
		Token c=null;
		Expr x =null;
		Expr y =null;
		Expr w =null;
		Expr h =null;
		Expr r =null;
		Expr x1 =null;
		Expr y1 =null;
		Expr x2 =null;
		Expr y2 =null;
		Expr sz =null;
		Expr p1x =null;
		Expr p1y =null;
		Expr p2x =null;
		Expr p2y =null;
		Expr p3x =null;
		Expr p3y =null;
		Expr rx =null;
		Expr ry =null;
		List<Expr> pts =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:3: ( 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';' | 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' )
			int alt24=8;
			switch ( input.LA(1) ) {
			case 40:
				{
				alt24=1;
				}
				break;
			case 26:
				{
				alt24=2;
				}
				break;
			case 35:
				{
				alt24=3;
				}
				break;
			case 44:
				{
				alt24=4;
				}
				break;
			case 50:
				{
				alt24=5;
				}
				break;
			case 29:
				{
				alt24=6;
				}
				break;
			case 37:
				{
				alt24=7;
				}
				break;
			case 46:
				{
				alt24=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:5: 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,40,FOLLOW_40_in_shapeStmt749); 
					match(input,24,FOLLOW_24_in_shapeStmt751); 
					match(input,12,FOLLOW_12_in_shapeStmt753); 
					pushFollow(FOLLOW_expr_in_shapeStmt757);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt759); 
					pushFollow(FOLLOW_expr_in_shapeStmt763);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt765); 
					match(input,43,FOLLOW_43_in_shapeStmt767); 
					match(input,12,FOLLOW_12_in_shapeStmt769); 
					pushFollow(FOLLOW_expr_in_shapeStmt773);
					w=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt775); 
					pushFollow(FOLLOW_expr_in_shapeStmt779);
					h=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt781); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:76: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==31) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:78: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt785); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:105: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==45) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:352:107: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt800); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt813); 

					      Expr[] ex = new Expr[]{ x, y, w, h };
					      cmd = new ShapeCommand("RECT", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:357:5: 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,26,FOLLOW_26_in_shapeStmt825); 
					match(input,24,FOLLOW_24_in_shapeStmt827); 
					match(input,12,FOLLOW_12_in_shapeStmt829); 
					pushFollow(FOLLOW_expr_in_shapeStmt833);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt835); 
					pushFollow(FOLLOW_expr_in_shapeStmt839);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt841); 
					match(input,39,FOLLOW_39_in_shapeStmt843); 
					pushFollow(FOLLOW_expr_in_shapeStmt847);
					r=expr();
					state._fsp--;

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:357:61: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==31) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:357:63: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt851); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:357:90: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==45) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:357:92: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt866); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt879); 

					      Expr[] ex = new Expr[]{ x, y, r };
					      cmd = new ShapeCommand("CIRCLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:362:5: 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';'
					{
					match(input,35,FOLLOW_35_in_shapeStmt891); 
					match(input,33,FOLLOW_33_in_shapeStmt893); 
					match(input,12,FOLLOW_12_in_shapeStmt895); 
					pushFollow(FOLLOW_expr_in_shapeStmt899);
					x1=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt901); 
					pushFollow(FOLLOW_expr_in_shapeStmt905);
					y1=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt907); 
					match(input,48,FOLLOW_48_in_shapeStmt909); 
					match(input,12,FOLLOW_12_in_shapeStmt911); 
					pushFollow(FOLLOW_expr_in_shapeStmt915);
					x2=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt917); 
					pushFollow(FOLLOW_expr_in_shapeStmt921);
					y2=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt923); 
					match(input,45,FOLLOW_45_in_shapeStmt925); 
					st=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,19,FOLLOW_19_in_shapeStmt935); 

					      Expr[] ex = new Expr[]{ x1, y1, x2, y2 };
					      cmd = new ShapeCommand("LINE", ex, null, null, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 4 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:367:5: 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,44,FOLLOW_44_in_shapeStmt947); 
					match(input,24,FOLLOW_24_in_shapeStmt949); 
					match(input,12,FOLLOW_12_in_shapeStmt951); 
					pushFollow(FOLLOW_expr_in_shapeStmt955);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt957); 
					pushFollow(FOLLOW_expr_in_shapeStmt961);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt963); 
					match(input,43,FOLLOW_43_in_shapeStmt965); 
					pushFollow(FOLLOW_expr_in_shapeStmt969);
					sz=expr();
					state._fsp--;

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:367:60: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==31) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:367:62: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt973); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:367:89: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==45) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:367:91: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt988); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt1001); 

					      Expr[] ex = new Expr[]{ x, y, sz };
					      cmd = new ShapeCommand("SQUARE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 5 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:372:5: 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,50,FOLLOW_50_in_shapeStmt1013); 
					match(input,24,FOLLOW_24_in_shapeStmt1015); 
					match(input,12,FOLLOW_12_in_shapeStmt1017); 
					pushFollow(FOLLOW_expr_in_shapeStmt1021);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1023); 
					pushFollow(FOLLOW_expr_in_shapeStmt1027);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1029); 
					match(input,36,FOLLOW_36_in_shapeStmt1031); 
					match(input,12,FOLLOW_12_in_shapeStmt1033); 
					pushFollow(FOLLOW_expr_in_shapeStmt1037);
					p1x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1039); 
					pushFollow(FOLLOW_expr_in_shapeStmt1043);
					p1y=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1045); 
					pushFollow(FOLLOW_expr_in_shapeStmt1049);
					p2x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1051); 
					pushFollow(FOLLOW_expr_in_shapeStmt1055);
					p2y=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1057); 
					pushFollow(FOLLOW_expr_in_shapeStmt1061);
					p3x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1063); 
					pushFollow(FOLLOW_expr_in_shapeStmt1067);
					p3y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1069); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:372:138: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==31) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:372:140: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt1073); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:372:167: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==45) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:372:169: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt1088); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt1101); 

					      Expr[] ex = new Expr[]{ p1x, p1y, p2x, p2y, p3x, p3y };
					      cmd = new ShapeCommand("TRIANGLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 6 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:377:5: 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,29,FOLLOW_29_in_shapeStmt1113); 
					match(input,24,FOLLOW_24_in_shapeStmt1115); 
					match(input,12,FOLLOW_12_in_shapeStmt1117); 
					pushFollow(FOLLOW_expr_in_shapeStmt1121);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1123); 
					pushFollow(FOLLOW_expr_in_shapeStmt1127);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1129); 
					match(input,38,FOLLOW_38_in_shapeStmt1131); 
					match(input,12,FOLLOW_12_in_shapeStmt1133); 
					pushFollow(FOLLOW_expr_in_shapeStmt1137);
					rx=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1139); 
					pushFollow(FOLLOW_expr_in_shapeStmt1143);
					ry=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1145); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:377:82: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==31) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:377:84: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt1149); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:377:111: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==45) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:377:113: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt1164); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt1177); 

					      Expr[] ex = new Expr[]{ x, y, rx, ry };
					      cmd = new ShapeCommand("ELLIPSE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 7 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:382:5: 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,37,FOLLOW_37_in_shapeStmt1189); 
					match(input,36,FOLLOW_36_in_shapeStmt1191); 
					match(input,12,FOLLOW_12_in_shapeStmt1193); 
					pushFollow(FOLLOW_pointList_in_shapeStmt1197);
					pts=pointList();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1199); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:382:46: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==31) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:382:48: 'FILL' f= ( ID | HEX_COLOR )
							{
							match(input,31,FOLLOW_31_in_shapeStmt1203); 
							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:382:75: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==45) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:382:77: 'STROKE' st= ( ID | HEX_COLOR )
							{
							match(input,45,FOLLOW_45_in_shapeStmt1218); 
							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt1231); 

					      Expr[] ex = pts.toArray(new Expr[0]);
					      cmd = new ShapeCommand("POLYGON", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 8 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:387:5: 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';'
					{
					match(input,46,FOLLOW_46_in_shapeStmt1243); 
					match(input,12,FOLLOW_12_in_shapeStmt1245); 
					str=(Token)match(input,STRING,FOLLOW_STRING_in_shapeStmt1249); 
					match(input,16,FOLLOW_16_in_shapeStmt1251); 
					pushFollow(FOLLOW_expr_in_shapeStmt1255);
					x=expr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_shapeStmt1257); 
					pushFollow(FOLLOW_expr_in_shapeStmt1261);
					y=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_shapeStmt1263); 
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:387:53: ( 'COLOR' c= ( ID | HEX_COLOR ) )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==27) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:387:55: 'COLOR' c= ( ID | HEX_COLOR )
							{
							match(input,27,FOLLOW_27_in_shapeStmt1267); 
							c=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					match(input,19,FOLLOW_19_in_shapeStmt1280); 

					      Expr[] ex = new Expr[]{ x, y };
					      String text = str.getText();
					      if (text.length()>=2) text = text.substring(1,text.length()-1);
					      cmd = new ShapeCommand("TEXT", ex, text, null, (c!=null?c.getText():null), c);
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "shapeStmt"



	// $ANTLR start "pointList"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:396:1: pointList returns [List<Expr> list] : a= expr ',' b= expr ( ',' c= expr ',' d= expr )* ;
	public final List<Expr> pointList() throws RecognitionException {
		List<Expr> list = null;


		Expr a =null;
		Expr b =null;
		Expr c =null;
		Expr d =null;

		 list = new ArrayList<Expr>(); 
		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:398:3: (a= expr ',' b= expr ( ',' c= expr ',' d= expr )* )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:398:5: a= expr ',' b= expr ( ',' c= expr ',' d= expr )*
			{
			pushFollow(FOLLOW_expr_in_pointList1310);
			a=expr();
			state._fsp--;

			 list.add(a); 
			match(input,16,FOLLOW_16_in_pointList1314); 
			pushFollow(FOLLOW_expr_in_pointList1318);
			b=expr();
			state._fsp--;

			 list.add(b); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:399:5: ( ',' c= expr ',' d= expr )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==16) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:399:7: ',' c= expr ',' d= expr
					{
					match(input,16,FOLLOW_16_in_pointList1328); 
					pushFollow(FOLLOW_expr_in_pointList1332);
					c=expr();
					state._fsp--;

					 list.add(c); 
					match(input,16,FOLLOW_16_in_pointList1336); 
					pushFollow(FOLLOW_expr_in_pointList1340);
					d=expr();
					state._fsp--;

					 list.add(d); 
					}
					break;

				default :
					break loop25;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return list;
	}
	// $ANTLR end "pointList"



	// $ANTLR start "expr"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:402:1: expr returns [Expr expr] : a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )* ;
	public final Expr expr() throws RecognitionException {
		Expr expr = null;


		Token op=null;
		Expr a =null;
		Expr b =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:403:3: (a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )* )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:403:5: a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_expr1364);
			a=addExpr();
			state._fsp--;

			 expr = a; 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:404:5: (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==11||LA26_0==20||(LA26_0 >= 22 && LA26_0 <= 23)) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:404:7: op= ( '<' | '>' | '==' | '!=' ) b= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==11||input.LA(1)==20||(input.LA(1) >= 22 && input.LA(1) <= 23) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_expr1388);
					b=addExpr();
					state._fsp--;

					 expr = makeBin(expr, (op!=null?op.getText():null), b); 
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expr;
	}
	// $ANTLR end "expr"



	// $ANTLR start "addExpr"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:407:1: addExpr returns [Expr expr] : a= term ( '+' b= term | '-' b2= term )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr expr = null;


		Expr a =null;
		Expr b =null;
		Expr b2 =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:408:3: (a= term ( '+' b= term | '-' b2= term )* )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:408:5: a= term ( '+' b= term | '-' b2= term )*
			{
			pushFollow(FOLLOW_term_in_addExpr1412);
			a=term();
			state._fsp--;

			 expr = a; 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:409:5: ( '+' b= term | '-' b2= term )*
			loop27:
			while (true) {
				int alt27=3;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==15) ) {
					alt27=1;
				}
				else if ( (LA27_0==17) ) {
					alt27=2;
				}

				switch (alt27) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:409:7: '+' b= term
					{
					match(input,15,FOLLOW_15_in_addExpr1422); 
					pushFollow(FOLLOW_term_in_addExpr1426);
					b=term();
					state._fsp--;

					 expr = makeBin(expr, "+", b); 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:410:7: '-' b2= term
					{
					match(input,17,FOLLOW_17_in_addExpr1436); 
					pushFollow(FOLLOW_term_in_addExpr1440);
					b2=term();
					state._fsp--;

					 expr = makeBin(expr, "-", b2); 
					}
					break;

				default :
					break loop27;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expr;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "term"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:414:1: term returns [Expr expr] : f= factor ( '*' g= factor | '/' g2= factor )* ;
	public final Expr term() throws RecognitionException {
		Expr expr = null;


		Expr f =null;
		Expr g =null;
		Expr g2 =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:415:3: (f= factor ( '*' g= factor | '/' g2= factor )* )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:415:5: f= factor ( '*' g= factor | '/' g2= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1468);
			f=factor();
			state._fsp--;

			 expr = f; 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:416:5: ( '*' g= factor | '/' g2= factor )*
			loop28:
			while (true) {
				int alt28=3;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==14) ) {
					alt28=1;
				}
				else if ( (LA28_0==18) ) {
					alt28=2;
				}

				switch (alt28) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:416:7: '*' g= factor
					{
					match(input,14,FOLLOW_14_in_term1478); 
					pushFollow(FOLLOW_factor_in_term1482);
					g=factor();
					state._fsp--;

					 expr = makeBin(expr, "*", g); 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:417:7: '/' g2= factor
					{
					match(input,18,FOLLOW_18_in_term1492); 
					pushFollow(FOLLOW_factor_in_term1496);
					g2=factor();
					state._fsp--;

					 expr = makeBin(expr, "/", g2); 
					}
					break;

				default :
					break loop28;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expr;
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:421:1: factor returns [Expr expr] : (n= INT |id= ID | '(' e= expr ')' );
	public final Expr factor() throws RecognitionException {
		Expr expr = null;


		Token n=null;
		Token id=null;
		Expr e =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:422:3: (n= INT |id= ID | '(' e= expr ')' )
			int alt29=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt29=1;
				}
				break;
			case ID:
				{
				alt29=2;
				}
				break;
			case 12:
				{
				alt29=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:422:5: n= INT
					{
					n=(Token)match(input,INT,FOLLOW_INT_in_factor1524); 
					 expr = makeConst(Integer.parseInt(n.getText())); 
					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:423:5: id= ID
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_factor1534); 
					 expr = makeVarExpr(id.getText()); 
					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:424:5: '(' e= expr ')'
					{
					match(input,12,FOLLOW_12_in_factor1542); 
					pushFollow(FOLLOW_expr_in_factor1546);
					e=expr();
					state._fsp--;

					match(input,13,FOLLOW_13_in_factor1548); 
					 expr = e; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expr;
	}
	// $ANTLR end "factor"



	// $ANTLR start "assignSimple"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:427:1: assignSimple returns [Command cmd] : id= ID '=' e= expr ;
	public final Command assignSimple() throws RecognitionException {
		Command cmd = null;


		Token id=null;
		Expr e =null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:428:3: (id= ID '=' e= expr )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScript/grammar/GeoScriptGrammar.g:428:5: id= ID '=' e= expr
			{
			id=(Token)match(input,ID,FOLLOW_ID_in_assignSimple1569); 
			match(input,21,FOLLOW_21_in_assignSimple1571); 
			pushFollow(FOLLOW_expr_in_assignSimple1575);
			e=expr();
			state._fsp--;

			 cmd = makeAssign(id.getText(), e); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "assignSimple"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_prog50 = new BitSet(new long[]{0x001E572D360000A0L});
	public static final BitSet FOLLOW_EOF_in_prog56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_canvasStmt_in_statement79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_colorDef_in_statement93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varDeclStmt_in_statement109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignStmt_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStmt_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStmt_in_statement154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forStmt_in_statement169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_transformStmt_in_statement186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shapeStmt_in_statement197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMENTLINE_in_statement212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_canvasStmt232 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_canvasStmt234 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt238 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_canvasStmt240 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt244 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_canvasStmt246 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_canvasStmt248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_colorDef267 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_colorDef271 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_colorDef273 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_HEX_COLOR_in_colorDef277 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_colorDef279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_varDeclStmt302 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_varDeclStmt306 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_varDeclStmt308 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_varDeclStmt312 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_varDeclStmt314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStmt339 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_assignStmt341 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_assignStmt345 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_assignStmt347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_ifStmt375 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_ifStmt377 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_ifStmt381 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ifStmt383 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_ifStmt385 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_ifStmt387 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt400 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_54_in_ifStmt406 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_30_in_ifStmt415 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_ifStmt417 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt430 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_54_in_ifStmt436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_whileStmt467 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_whileStmt469 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_whileStmt473 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_whileStmt475 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_whileStmt477 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_statement_in_whileStmt490 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_54_in_whileStmt496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_forStmt524 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_forStmt526 = new BitSet(new long[]{0x0008000000080080L});
	public static final BitSet FOLLOW_forInitHeader_in_forStmt537 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_forStmt539 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_forStmt550 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_forStmt552 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_forIncrHeader_in_forStmt563 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_forStmt570 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_forStmt572 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_statement_in_forStmt585 = new BitSet(new long[]{0x005E572D360000A0L});
	public static final BitSet FOLLOW_54_in_forStmt591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_forInitHeader614 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_forInitHeader618 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_forInitHeader620 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_forInitHeader624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignSimple_in_forInitHeader634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignSimple_in_forIncrHeader661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_transformStmt682 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_transformStmt686 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_transformStmt694 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_transformStmt696 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt700 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_transformStmt702 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt706 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt708 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_transformStmt716 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_transformStmt718 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt722 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_transformStmt724 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt728 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt730 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_shapeStmt749 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_shapeStmt751 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt753 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt757 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt759 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt763 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt765 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_shapeStmt767 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt769 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt773 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt775 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt779 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt781 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt785 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt789 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt800 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt804 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_shapeStmt825 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_shapeStmt827 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt829 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt833 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt835 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt839 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt841 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_shapeStmt843 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt847 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt851 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt855 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt866 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt870 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_shapeStmt891 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_shapeStmt893 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt895 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt899 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt901 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt905 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt907 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_shapeStmt909 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt911 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt915 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt917 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt921 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt923 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_shapeStmt925 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt929 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_shapeStmt947 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_shapeStmt949 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt951 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt955 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt957 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt961 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt963 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_shapeStmt965 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt969 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt973 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt977 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt988 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt992 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_shapeStmt1013 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_shapeStmt1015 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1017 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1021 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1023 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1027 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1029 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_shapeStmt1031 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1033 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1037 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1039 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1043 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1045 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1049 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1051 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1055 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1057 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1061 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1063 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1067 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1069 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt1073 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1077 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt1088 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1092 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_shapeStmt1113 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_shapeStmt1115 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1117 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1121 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1123 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1127 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1129 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_shapeStmt1131 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1133 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1137 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1139 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1143 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1145 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt1149 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1153 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt1164 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1168 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt1177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_shapeStmt1189 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_shapeStmt1191 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1193 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_pointList_in_shapeStmt1197 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1199 = new BitSet(new long[]{0x0000200080080000L});
	public static final BitSet FOLLOW_31_in_shapeStmt1203 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1207 = new BitSet(new long[]{0x0000200000080000L});
	public static final BitSet FOLLOW_45_in_shapeStmt1218 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1222 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt1231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_shapeStmt1243 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_shapeStmt1245 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_in_shapeStmt1249 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1251 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1255 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_shapeStmt1257 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1261 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1263 = new BitSet(new long[]{0x0000000008080000L});
	public static final BitSet FOLLOW_27_in_shapeStmt1267 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1271 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_shapeStmt1280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_pointList1310 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_pointList1314 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1318 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_pointList1328 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1332 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_pointList1336 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1340 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_addExpr_in_expr1364 = new BitSet(new long[]{0x0000000000D00802L});
	public static final BitSet FOLLOW_set_in_expr1376 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_addExpr_in_expr1388 = new BitSet(new long[]{0x0000000000D00802L});
	public static final BitSet FOLLOW_term_in_addExpr1412 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_15_in_addExpr1422 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_term_in_addExpr1426 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_17_in_addExpr1436 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_term_in_addExpr1440 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_factor_in_term1468 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_14_in_term1478 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_factor_in_term1482 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_18_in_term1492 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_factor_in_term1496 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_INT_in_factor1524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_factor1534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_factor1542 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_factor1546 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_factor1548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignSimple1569 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_assignSimple1571 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_assignSimple1575 = new BitSet(new long[]{0x0000000000000002L});
}
