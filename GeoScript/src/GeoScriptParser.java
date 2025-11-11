// $ANTLR 3.5.1 /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g 2025-11-11 10:44:53

  
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class GeoScriptParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "COMMENTLINE", "HEX_COLOR", 
		"ID", "INT", "STRING", "WS", "'!='", "'('", "')'", "'*'", "'+'", "','", 
		"'-'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AT'", 
		"'CANVAS'", "'CIRCLE'", "'COLOR'", "'DEF'", "'ELLIPSE'", "'ELSE'", "'FILL'", 
		"'FOR'", "'FROM'", "'IF'", "'LINE'", "'POINTS'", "'POLYGON'", "'RADII'", 
		"'RADIUS'", "'RECT'", "'ROTATE'", "'SCALE'", "'SIZE'", "'SQUARE'", "'STROKE'", 
		"'TEXT'", "'THEN'", "'TO'", "'TRANSLATE'", "'TRIANGLE'", "'VAR'", "'WHILE'", 
		"'{'", "'}'"
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
	public static final int T__55=55;
	public static final int T__56=56;
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


	public GeoScriptParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public GeoScriptParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return GeoScriptParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g"; }


	  // === Semantic Handler ===
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
	  }

	  // renamed from h → sem to avoid token name collisions
	  SemanticHandler sem = new SemanticHandler();

	  @Override
	  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	    String hdr = "Line " + e.line + ":" + e.charPositionInLine;
	    String msg = getErrorMessage(e, tokenNames);
	    Token tk = input.LT(1);
	    System.err.println("Syntax error " + hdr + " at token '" + tk.getText() + "': " + msg);
	  }


	public static class prog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:78:1: prog : ( statement )* EOF ;
	public final GeoScriptParser.prog_return prog() throws RecognitionException {
		GeoScriptParser.prog_return retval = new GeoScriptParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope statement1 =null;

		Object EOF2_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:78:6: ( ( statement )* EOF )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:78:8: ( statement )* EOF
			{
			root_0 = (Object)adaptor.nil();


			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:78:8: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COMMENTLINE||LA1_0==ID||(LA1_0 >= 27 && LA1_0 <= 28)||(LA1_0 >= 30 && LA1_0 <= 31)||LA1_0==34||(LA1_0 >= 36 && LA1_0 <= 37)||LA1_0==39||(LA1_0 >= 42 && LA1_0 <= 44)||LA1_0==46||LA1_0==48||(LA1_0 >= 51 && LA1_0 <= 54)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:78:9: statement
					{
					pushFollow(FOLLOW_statement_in_prog55);
					statement1=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement1.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog59); 
			EOF2_tree = (Object)adaptor.create(EOF2);
			adaptor.addChild(root_0, EOF2_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:80:1: statement : ( canvasStmt | colorDef | varDecl | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE );
	public final GeoScriptParser.statement_return statement() throws RecognitionException {
		GeoScriptParser.statement_return retval = new GeoScriptParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMENTLINE12=null;
		ParserRuleReturnScope canvasStmt3 =null;
		ParserRuleReturnScope colorDef4 =null;
		ParserRuleReturnScope varDecl5 =null;
		ParserRuleReturnScope assignStmt6 =null;
		ParserRuleReturnScope ifStmt7 =null;
		ParserRuleReturnScope whileStmt8 =null;
		ParserRuleReturnScope forStmt9 =null;
		ParserRuleReturnScope transformStmt10 =null;
		ParserRuleReturnScope shapeStmt11 =null;

		Object COMMENTLINE12_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:81:3: ( canvasStmt | colorDef | varDecl | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE )
			int alt2=10;
			switch ( input.LA(1) ) {
			case 27:
				{
				alt2=1;
				}
				break;
			case 30:
				{
				alt2=2;
				}
				break;
			case 53:
				{
				alt2=3;
				}
				break;
			case ID:
				{
				alt2=4;
				}
				break;
			case 36:
				{
				alt2=5;
				}
				break;
			case 54:
				{
				alt2=6;
				}
				break;
			case 34:
				{
				alt2=7;
				}
				break;
			case 43:
			case 44:
			case 51:
				{
				alt2=8;
				}
				break;
			case 28:
			case 31:
			case 37:
			case 39:
			case 42:
			case 46:
			case 48:
			case 52:
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
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:81:5: canvasStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_canvasStmt_in_statement70);
					canvasStmt3=canvasStmt();
					state._fsp--;

					adaptor.addChild(root_0, canvasStmt3.getTree());

					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:82:5: colorDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_colorDef_in_statement76);
					colorDef4=colorDef();
					state._fsp--;

					adaptor.addChild(root_0, colorDef4.getTree());

					}
					break;
				case 3 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:83:5: varDecl
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_varDecl_in_statement82);
					varDecl5=varDecl();
					state._fsp--;

					adaptor.addChild(root_0, varDecl5.getTree());

					}
					break;
				case 4 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:84:5: assignStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignStmt_in_statement88);
					assignStmt6=assignStmt();
					state._fsp--;

					adaptor.addChild(root_0, assignStmt6.getTree());

					}
					break;
				case 5 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:85:5: ifStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifStmt_in_statement94);
					ifStmt7=ifStmt();
					state._fsp--;

					adaptor.addChild(root_0, ifStmt7.getTree());

					}
					break;
				case 6 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:86:5: whileStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whileStmt_in_statement100);
					whileStmt8=whileStmt();
					state._fsp--;

					adaptor.addChild(root_0, whileStmt8.getTree());

					}
					break;
				case 7 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:87:5: forStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_forStmt_in_statement106);
					forStmt9=forStmt();
					state._fsp--;

					adaptor.addChild(root_0, forStmt9.getTree());

					}
					break;
				case 8 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:88:5: transformStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_transformStmt_in_statement112);
					transformStmt10=transformStmt();
					state._fsp--;

					adaptor.addChild(root_0, transformStmt10.getTree());

					}
					break;
				case 9 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:89:5: shapeStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_shapeStmt_in_statement118);
					shapeStmt11=shapeStmt();
					state._fsp--;

					adaptor.addChild(root_0, shapeStmt11.getTree());

					}
					break;
				case 10 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:90:5: COMMENTLINE
					{
					root_0 = (Object)adaptor.nil();


					COMMENTLINE12=(Token)match(input,COMMENTLINE,FOLLOW_COMMENTLINE_in_statement124); 
					COMMENTLINE12_tree = (Object)adaptor.create(COMMENTLINE12);
					adaptor.addChild(root_0, COMMENTLINE12_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class canvasStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "canvasStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:96:1: canvasStmt : 'CANVAS' '(' w= INT ',' h2= INT ')' ';' ;
	public final GeoScriptParser.canvasStmt_return canvasStmt() throws RecognitionException {
		GeoScriptParser.canvasStmt_return retval = new GeoScriptParser.canvasStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token w=null;
		Token h2=null;
		Token string_literal13=null;
		Token char_literal14=null;
		Token char_literal15=null;
		Token char_literal16=null;
		Token char_literal17=null;

		Object w_tree=null;
		Object h2_tree=null;
		Object string_literal13_tree=null;
		Object char_literal14_tree=null;
		Object char_literal15_tree=null;
		Object char_literal16_tree=null;
		Object char_literal17_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:97:3: ( 'CANVAS' '(' w= INT ',' h2= INT ')' ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:97:5: 'CANVAS' '(' w= INT ',' h2= INT ')' ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal13=(Token)match(input,27,FOLLOW_27_in_canvasStmt140); 
			string_literal13_tree = (Object)adaptor.create(string_literal13);
			adaptor.addChild(root_0, string_literal13_tree);

			char_literal14=(Token)match(input,12,FOLLOW_12_in_canvasStmt142); 
			char_literal14_tree = (Object)adaptor.create(char_literal14);
			adaptor.addChild(root_0, char_literal14_tree);

			w=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt146); 
			w_tree = (Object)adaptor.create(w);
			adaptor.addChild(root_0, w_tree);

			char_literal15=(Token)match(input,16,FOLLOW_16_in_canvasStmt148); 
			char_literal15_tree = (Object)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);

			h2=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt152); 
			h2_tree = (Object)adaptor.create(h2);
			adaptor.addChild(root_0, h2_tree);

			char_literal16=(Token)match(input,13,FOLLOW_13_in_canvasStmt154); 
			char_literal16_tree = (Object)adaptor.create(char_literal16);
			adaptor.addChild(root_0, char_literal16_tree);

			char_literal17=(Token)match(input,19,FOLLOW_19_in_canvasStmt156); 
			char_literal17_tree = (Object)adaptor.create(char_literal17);
			adaptor.addChild(root_0, char_literal17_tree);

			 sem.setCanvas(Integer.parseInt(w.getText()), Integer.parseInt(h2.getText())); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "canvasStmt"


	public static class varDecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "varDecl"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:104:1: varDecl : 'VAR' id= ID '=' e= expr ';' ;
	public final GeoScriptParser.varDecl_return varDecl() throws RecognitionException {
		GeoScriptParser.varDecl_return retval = new GeoScriptParser.varDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token string_literal18=null;
		Token char_literal19=null;
		Token char_literal20=null;
		ParserRuleReturnScope e =null;

		Object id_tree=null;
		Object string_literal18_tree=null;
		Object char_literal19_tree=null;
		Object char_literal20_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:105:3: ( 'VAR' id= ID '=' e= expr ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:105:5: 'VAR' id= ID '=' e= expr ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal18=(Token)match(input,53,FOLLOW_53_in_varDecl178); 
			string_literal18_tree = (Object)adaptor.create(string_literal18);
			adaptor.addChild(root_0, string_literal18_tree);

			id=(Token)match(input,ID,FOLLOW_ID_in_varDecl182); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal19=(Token)match(input,22,FOLLOW_22_in_varDecl184); 
			char_literal19_tree = (Object)adaptor.create(char_literal19);
			adaptor.addChild(root_0, char_literal19_tree);

			pushFollow(FOLLOW_expr_in_varDecl188);
			e=expr();
			state._fsp--;

			adaptor.addChild(root_0, e.getTree());

			char_literal20=(Token)match(input,19,FOLLOW_19_in_varDecl190); 
			char_literal20_tree = (Object)adaptor.create(char_literal20);
			adaptor.addChild(root_0, char_literal20_tree);

			 sem.defineVar(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).value:0)); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "varDecl"


	public static class assignStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:109:1: assignStmt : id= ID '=' e= expr ';' ;
	public final GeoScriptParser.assignStmt_return assignStmt() throws RecognitionException {
		GeoScriptParser.assignStmt_return retval = new GeoScriptParser.assignStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token char_literal21=null;
		Token char_literal22=null;
		ParserRuleReturnScope e =null;

		Object id_tree=null;
		Object char_literal21_tree=null;
		Object char_literal22_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:110:3: (id= ID '=' e= expr ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:110:5: id= ID '=' e= expr ';'
			{
			root_0 = (Object)adaptor.nil();


			id=(Token)match(input,ID,FOLLOW_ID_in_assignStmt211); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal21=(Token)match(input,22,FOLLOW_22_in_assignStmt213); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);

			pushFollow(FOLLOW_expr_in_assignStmt217);
			e=expr();
			state._fsp--;

			adaptor.addChild(root_0, e.getTree());

			char_literal22=(Token)match(input,19,FOLLOW_19_in_assignStmt219); 
			char_literal22_tree = (Object)adaptor.create(char_literal22);
			adaptor.addChild(root_0, char_literal22_tree);

			 sem.setVar(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).value:0)); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignStmt"


	public static class colorDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "colorDef"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:117:1: colorDef : 'DEF' id= ID '=' hex= HEX_COLOR ';' ;
	public final GeoScriptParser.colorDef_return colorDef() throws RecognitionException {
		GeoScriptParser.colorDef_return retval = new GeoScriptParser.colorDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token hex=null;
		Token string_literal23=null;
		Token char_literal24=null;
		Token char_literal25=null;

		Object id_tree=null;
		Object hex_tree=null;
		Object string_literal23_tree=null;
		Object char_literal24_tree=null;
		Object char_literal25_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:118:3: ( 'DEF' id= ID '=' hex= HEX_COLOR ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:118:5: 'DEF' id= ID '=' hex= HEX_COLOR ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal23=(Token)match(input,30,FOLLOW_30_in_colorDef241); 
			string_literal23_tree = (Object)adaptor.create(string_literal23);
			adaptor.addChild(root_0, string_literal23_tree);

			id=(Token)match(input,ID,FOLLOW_ID_in_colorDef245); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal24=(Token)match(input,22,FOLLOW_22_in_colorDef247); 
			char_literal24_tree = (Object)adaptor.create(char_literal24);
			adaptor.addChild(root_0, char_literal24_tree);

			hex=(Token)match(input,HEX_COLOR,FOLLOW_HEX_COLOR_in_colorDef251); 
			hex_tree = (Object)adaptor.create(hex);
			adaptor.addChild(root_0, hex_tree);

			char_literal25=(Token)match(input,19,FOLLOW_19_in_colorDef253); 
			char_literal25_tree = (Object)adaptor.create(char_literal25);
			adaptor.addChild(root_0, char_literal25_tree);

			 sem.defineColor(id.getText(), hex.getText()); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "colorDef"


	public static class ifStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:125:1: ifStmt : 'IF' '(' cond= condition ')' 'THEN' '{' ( statement )* '}' ( 'ELSE' '{' ( statement )* '}' )? ;
	public final GeoScriptParser.ifStmt_return ifStmt() throws RecognitionException {
		GeoScriptParser.ifStmt_return retval = new GeoScriptParser.ifStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal26=null;
		Token char_literal27=null;
		Token char_literal28=null;
		Token string_literal29=null;
		Token char_literal30=null;
		Token char_literal32=null;
		Token string_literal33=null;
		Token char_literal34=null;
		Token char_literal36=null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope statement31 =null;
		ParserRuleReturnScope statement35 =null;

		Object string_literal26_tree=null;
		Object char_literal27_tree=null;
		Object char_literal28_tree=null;
		Object string_literal29_tree=null;
		Object char_literal30_tree=null;
		Object char_literal32_tree=null;
		Object string_literal33_tree=null;
		Object char_literal34_tree=null;
		Object char_literal36_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:3: ( 'IF' '(' cond= condition ')' 'THEN' '{' ( statement )* '}' ( 'ELSE' '{' ( statement )* '}' )? )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:5: 'IF' '(' cond= condition ')' 'THEN' '{' ( statement )* '}' ( 'ELSE' '{' ( statement )* '}' )?
			{
			root_0 = (Object)adaptor.nil();


			string_literal26=(Token)match(input,36,FOLLOW_36_in_ifStmt275); 
			string_literal26_tree = (Object)adaptor.create(string_literal26);
			adaptor.addChild(root_0, string_literal26_tree);

			char_literal27=(Token)match(input,12,FOLLOW_12_in_ifStmt277); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			pushFollow(FOLLOW_condition_in_ifStmt281);
			cond=condition();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal28=(Token)match(input,13,FOLLOW_13_in_ifStmt283); 
			char_literal28_tree = (Object)adaptor.create(char_literal28);
			adaptor.addChild(root_0, char_literal28_tree);

			string_literal29=(Token)match(input,49,FOLLOW_49_in_ifStmt285); 
			string_literal29_tree = (Object)adaptor.create(string_literal29);
			adaptor.addChild(root_0, string_literal29_tree);

			char_literal30=(Token)match(input,55,FOLLOW_55_in_ifStmt287); 
			char_literal30_tree = (Object)adaptor.create(char_literal30);
			adaptor.addChild(root_0, char_literal30_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:44: ( statement )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMENTLINE||LA3_0==ID||(LA3_0 >= 27 && LA3_0 <= 28)||(LA3_0 >= 30 && LA3_0 <= 31)||LA3_0==34||(LA3_0 >= 36 && LA3_0 <= 37)||LA3_0==39||(LA3_0 >= 42 && LA3_0 <= 44)||LA3_0==46||LA3_0==48||(LA3_0 >= 51 && LA3_0 <= 54)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:45: statement
					{
					pushFollow(FOLLOW_statement_in_ifStmt290);
					statement31=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement31.getTree());

					}
					break;

				default :
					break loop3;
				}
			}

			char_literal32=(Token)match(input,56,FOLLOW_56_in_ifStmt294); 
			char_literal32_tree = (Object)adaptor.create(char_literal32);
			adaptor.addChild(root_0, char_literal32_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:61: ( 'ELSE' '{' ( statement )* '}' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==32) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:62: 'ELSE' '{' ( statement )* '}'
					{
					string_literal33=(Token)match(input,32,FOLLOW_32_in_ifStmt297); 
					string_literal33_tree = (Object)adaptor.create(string_literal33);
					adaptor.addChild(root_0, string_literal33_tree);

					char_literal34=(Token)match(input,55,FOLLOW_55_in_ifStmt299); 
					char_literal34_tree = (Object)adaptor.create(char_literal34);
					adaptor.addChild(root_0, char_literal34_tree);

					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:73: ( statement )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMENTLINE||LA4_0==ID||(LA4_0 >= 27 && LA4_0 <= 28)||(LA4_0 >= 30 && LA4_0 <= 31)||LA4_0==34||(LA4_0 >= 36 && LA4_0 <= 37)||LA4_0==39||(LA4_0 >= 42 && LA4_0 <= 44)||LA4_0==46||LA4_0==48||(LA4_0 >= 51 && LA4_0 <= 54)) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:126:74: statement
							{
							pushFollow(FOLLOW_statement_in_ifStmt302);
							statement35=statement();
							state._fsp--;

							adaptor.addChild(root_0, statement35.getTree());

							}
							break;

						default :
							break loop4;
						}
					}

					char_literal36=(Token)match(input,56,FOLLOW_56_in_ifStmt306); 
					char_literal36_tree = (Object)adaptor.create(char_literal36);
					adaptor.addChild(root_0, char_literal36_tree);

					}
					break;

			}

			 System.out.println("IF evaluated: " + (cond!=null?((GeoScriptParser.condition_return)cond).result:false)); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifStmt"


	public static class condition_return extends ParserRuleReturnScope {
		public boolean result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condition"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:130:1: condition returns [boolean result] : left= expr comp= ( '==' | '!=' | '>' | '<' | '>=' | '<=' ) right= expr ;
	public final GeoScriptParser.condition_return condition() throws RecognitionException {
		GeoScriptParser.condition_return retval = new GeoScriptParser.condition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token comp=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope right =null;

		Object comp_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:131:3: (left= expr comp= ( '==' | '!=' | '>' | '<' | '>=' | '<=' ) right= expr )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:131:5: left= expr comp= ( '==' | '!=' | '>' | '<' | '>=' | '<=' ) right= expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_condition333);
			left=expr();
			state._fsp--;

			adaptor.addChild(root_0, left.getTree());

			comp=input.LT(1);
			if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 21)||(input.LA(1) >= 23 && input.LA(1) <= 25) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(comp));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_expr_in_condition365);
			right=expr();
			state._fsp--;

			adaptor.addChild(root_0, right.getTree());


			      int L = (left!=null?((GeoScriptParser.expr_return)left).value:0), R = (right!=null?((GeoScriptParser.expr_return)right).value:0);
			      String op = comp.getText();
			      if (op.equals("==")) retval.result = (L == R);
			      else if (op.equals("!=")) retval.result = (L != R);
			      else if (op.equals(">")) retval.result = (L > R);
			      else if (op.equals("<")) retval.result = (L < R);
			      else if (op.equals(">=")) retval.result = (L >= R);
			      else if (op.equals("<=")) retval.result = (L <= R);
			      else retval.result = false;
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condition"


	public static class whileStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whileStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:148:1: whileStmt : 'WHILE' '(' cond= condition ')' '{' ( statement )* '}' ;
	public final GeoScriptParser.whileStmt_return whileStmt() throws RecognitionException {
		GeoScriptParser.whileStmt_return retval = new GeoScriptParser.whileStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal37=null;
		Token char_literal38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		Token char_literal42=null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope statement41 =null;

		Object string_literal37_tree=null;
		Object char_literal38_tree=null;
		Object char_literal39_tree=null;
		Object char_literal40_tree=null;
		Object char_literal42_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:149:3: ( 'WHILE' '(' cond= condition ')' '{' ( statement )* '}' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:149:5: 'WHILE' '(' cond= condition ')' '{' ( statement )* '}'
			{
			root_0 = (Object)adaptor.nil();


			string_literal37=(Token)match(input,54,FOLLOW_54_in_whileStmt387); 
			string_literal37_tree = (Object)adaptor.create(string_literal37);
			adaptor.addChild(root_0, string_literal37_tree);

			char_literal38=(Token)match(input,12,FOLLOW_12_in_whileStmt389); 
			char_literal38_tree = (Object)adaptor.create(char_literal38);
			adaptor.addChild(root_0, char_literal38_tree);

			pushFollow(FOLLOW_condition_in_whileStmt393);
			cond=condition();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal39=(Token)match(input,13,FOLLOW_13_in_whileStmt395); 
			char_literal39_tree = (Object)adaptor.create(char_literal39);
			adaptor.addChild(root_0, char_literal39_tree);

			char_literal40=(Token)match(input,55,FOLLOW_55_in_whileStmt397); 
			char_literal40_tree = (Object)adaptor.create(char_literal40);
			adaptor.addChild(root_0, char_literal40_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:149:40: ( statement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMENTLINE||LA6_0==ID||(LA6_0 >= 27 && LA6_0 <= 28)||(LA6_0 >= 30 && LA6_0 <= 31)||LA6_0==34||(LA6_0 >= 36 && LA6_0 <= 37)||LA6_0==39||(LA6_0 >= 42 && LA6_0 <= 44)||LA6_0==46||LA6_0==48||(LA6_0 >= 51 && LA6_0 <= 54)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:149:41: statement
					{
					pushFollow(FOLLOW_statement_in_whileStmt400);
					statement41=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement41.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			char_literal42=(Token)match(input,56,FOLLOW_56_in_whileStmt404); 
			char_literal42_tree = (Object)adaptor.create(char_literal42);
			adaptor.addChild(root_0, char_literal42_tree);

			 System.out.println("WHILE loop parsed. Condition: " + (cond!=null?((GeoScriptParser.condition_return)cond).result:false)); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whileStmt"


	public static class forStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "forStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:156:1: forStmt : 'FOR' '(' ( 'VAR' forInitId= ID '=' forInitExpr= expr ';' |forInitId2= ID '=' forInitExpr2= expr ';' | ';' ) cond= condition ';' (forIncrId= ID '=' forIncrExpr= expr | ';' ) ')' '{' ( statement )* '}' ;
	public final GeoScriptParser.forStmt_return forStmt() throws RecognitionException {
		GeoScriptParser.forStmt_return retval = new GeoScriptParser.forStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token forInitId=null;
		Token forInitId2=null;
		Token forIncrId=null;
		Token string_literal43=null;
		Token char_literal44=null;
		Token string_literal45=null;
		Token char_literal46=null;
		Token char_literal47=null;
		Token char_literal48=null;
		Token char_literal49=null;
		Token char_literal50=null;
		Token char_literal51=null;
		Token char_literal52=null;
		Token char_literal53=null;
		Token char_literal54=null;
		Token char_literal55=null;
		Token char_literal57=null;
		ParserRuleReturnScope forInitExpr =null;
		ParserRuleReturnScope forInitExpr2 =null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope forIncrExpr =null;
		ParserRuleReturnScope statement56 =null;

		Object forInitId_tree=null;
		Object forInitId2_tree=null;
		Object forIncrId_tree=null;
		Object string_literal43_tree=null;
		Object char_literal44_tree=null;
		Object string_literal45_tree=null;
		Object char_literal46_tree=null;
		Object char_literal47_tree=null;
		Object char_literal48_tree=null;
		Object char_literal49_tree=null;
		Object char_literal50_tree=null;
		Object char_literal51_tree=null;
		Object char_literal52_tree=null;
		Object char_literal53_tree=null;
		Object char_literal54_tree=null;
		Object char_literal55_tree=null;
		Object char_literal57_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:157:3: ( 'FOR' '(' ( 'VAR' forInitId= ID '=' forInitExpr= expr ';' |forInitId2= ID '=' forInitExpr2= expr ';' | ';' ) cond= condition ';' (forIncrId= ID '=' forIncrExpr= expr | ';' ) ')' '{' ( statement )* '}' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:157:5: 'FOR' '(' ( 'VAR' forInitId= ID '=' forInitExpr= expr ';' |forInitId2= ID '=' forInitExpr2= expr ';' | ';' ) cond= condition ';' (forIncrId= ID '=' forIncrExpr= expr | ';' ) ')' '{' ( statement )* '}'
			{
			root_0 = (Object)adaptor.nil();


			string_literal43=(Token)match(input,34,FOLLOW_34_in_forStmt426); 
			string_literal43_tree = (Object)adaptor.create(string_literal43);
			adaptor.addChild(root_0, string_literal43_tree);

			char_literal44=(Token)match(input,12,FOLLOW_12_in_forStmt428); 
			char_literal44_tree = (Object)adaptor.create(char_literal44);
			adaptor.addChild(root_0, char_literal44_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:158:7: ( 'VAR' forInitId= ID '=' forInitExpr= expr ';' |forInitId2= ID '=' forInitExpr2= expr ';' | ';' )
			int alt7=3;
			switch ( input.LA(1) ) {
			case 53:
				{
				alt7=1;
				}
				break;
			case ID:
				{
				alt7=2;
				}
				break;
			case 19:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:158:9: 'VAR' forInitId= ID '=' forInitExpr= expr ';'
					{
					string_literal45=(Token)match(input,53,FOLLOW_53_in_forStmt438); 
					string_literal45_tree = (Object)adaptor.create(string_literal45);
					adaptor.addChild(root_0, string_literal45_tree);

					forInitId=(Token)match(input,ID,FOLLOW_ID_in_forStmt442); 
					forInitId_tree = (Object)adaptor.create(forInitId);
					adaptor.addChild(root_0, forInitId_tree);

					char_literal46=(Token)match(input,22,FOLLOW_22_in_forStmt444); 
					char_literal46_tree = (Object)adaptor.create(char_literal46);
					adaptor.addChild(root_0, char_literal46_tree);

					pushFollow(FOLLOW_expr_in_forStmt448);
					forInitExpr=expr();
					state._fsp--;

					adaptor.addChild(root_0, forInitExpr.getTree());

					char_literal47=(Token)match(input,19,FOLLOW_19_in_forStmt450); 
					char_literal47_tree = (Object)adaptor.create(char_literal47);
					adaptor.addChild(root_0, char_literal47_tree);

					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:159:11: forInitId2= ID '=' forInitExpr2= expr ';'
					{
					forInitId2=(Token)match(input,ID,FOLLOW_ID_in_forStmt464); 
					forInitId2_tree = (Object)adaptor.create(forInitId2);
					adaptor.addChild(root_0, forInitId2_tree);

					char_literal48=(Token)match(input,22,FOLLOW_22_in_forStmt466); 
					char_literal48_tree = (Object)adaptor.create(char_literal48);
					adaptor.addChild(root_0, char_literal48_tree);

					pushFollow(FOLLOW_expr_in_forStmt470);
					forInitExpr2=expr();
					state._fsp--;

					adaptor.addChild(root_0, forInitExpr2.getTree());

					char_literal49=(Token)match(input,19,FOLLOW_19_in_forStmt472); 
					char_literal49_tree = (Object)adaptor.create(char_literal49);
					adaptor.addChild(root_0, char_literal49_tree);

					}
					break;
				case 3 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:160:11: ';'
					{
					char_literal50=(Token)match(input,19,FOLLOW_19_in_forStmt484); 
					char_literal50_tree = (Object)adaptor.create(char_literal50);
					adaptor.addChild(root_0, char_literal50_tree);

					}
					break;

			}

			pushFollow(FOLLOW_condition_in_forStmt502);
			cond=condition();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal51=(Token)match(input,19,FOLLOW_19_in_forStmt504); 
			char_literal51_tree = (Object)adaptor.create(char_literal51);
			adaptor.addChild(root_0, char_literal51_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:163:7: (forIncrId= ID '=' forIncrExpr= expr | ';' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID) ) {
				alt8=1;
			}
			else if ( (LA8_0==19) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:163:9: forIncrId= ID '=' forIncrExpr= expr
					{
					forIncrId=(Token)match(input,ID,FOLLOW_ID_in_forStmt516); 
					forIncrId_tree = (Object)adaptor.create(forIncrId);
					adaptor.addChild(root_0, forIncrId_tree);

					char_literal52=(Token)match(input,22,FOLLOW_22_in_forStmt518); 
					char_literal52_tree = (Object)adaptor.create(char_literal52);
					adaptor.addChild(root_0, char_literal52_tree);

					pushFollow(FOLLOW_expr_in_forStmt522);
					forIncrExpr=expr();
					state._fsp--;

					adaptor.addChild(root_0, forIncrExpr.getTree());

					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:163:45: ';'
					{
					char_literal53=(Token)match(input,19,FOLLOW_19_in_forStmt526); 
					char_literal53_tree = (Object)adaptor.create(char_literal53);
					adaptor.addChild(root_0, char_literal53_tree);

					}
					break;

			}

			char_literal54=(Token)match(input,13,FOLLOW_13_in_forStmt534); 
			char_literal54_tree = (Object)adaptor.create(char_literal54);
			adaptor.addChild(root_0, char_literal54_tree);

			char_literal55=(Token)match(input,55,FOLLOW_55_in_forStmt536); 
			char_literal55_tree = (Object)adaptor.create(char_literal55);
			adaptor.addChild(root_0, char_literal55_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:164:13: ( statement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMENTLINE||LA9_0==ID||(LA9_0 >= 27 && LA9_0 <= 28)||(LA9_0 >= 30 && LA9_0 <= 31)||LA9_0==34||(LA9_0 >= 36 && LA9_0 <= 37)||LA9_0==39||(LA9_0 >= 42 && LA9_0 <= 44)||LA9_0==46||LA9_0==48||(LA9_0 >= 51 && LA9_0 <= 54)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:164:14: statement
					{
					pushFollow(FOLLOW_statement_in_forStmt539);
					statement56=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement56.getTree());

					}
					break;

				default :
					break loop9;
				}
			}

			char_literal57=(Token)match(input,56,FOLLOW_56_in_forStmt543); 
			char_literal57_tree = (Object)adaptor.create(char_literal57);
			adaptor.addChild(root_0, char_literal57_tree);


			      String initName = (forInitId!=null? forInitId.getText() : (forInitId2!=null? forInitId2.getText() : "<none>"));
			      System.out.println("FOR loop parsed. Init var=" + initName);
			      if (forInitId != null) sem.defineVar(forInitId.getText(), (forInitExpr!=null?((GeoScriptParser.expr_return)forInitExpr).value:0));
			      else if (forInitId2 != null) sem.setVar(forInitId2.getText(), (forInitExpr2!=null?((GeoScriptParser.expr_return)forInitExpr2).value:0));
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "forStmt"


	public static class transformStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "transformStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:176:1: transformStmt : ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' );
	public final GeoScriptParser.transformStmt_return transformStmt() throws RecognitionException {
		GeoScriptParser.transformStmt_return retval = new GeoScriptParser.transformStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token a=null;
		Token string_literal58=null;
		Token char_literal59=null;
		Token string_literal60=null;
		Token char_literal61=null;
		Token char_literal62=null;
		Token char_literal63=null;
		Token char_literal64=null;
		Token string_literal65=null;
		Token char_literal66=null;
		Token char_literal67=null;
		Token char_literal68=null;
		Token char_literal69=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope sx =null;
		ParserRuleReturnScope sy =null;

		Object a_tree=null;
		Object string_literal58_tree=null;
		Object char_literal59_tree=null;
		Object string_literal60_tree=null;
		Object char_literal61_tree=null;
		Object char_literal62_tree=null;
		Object char_literal63_tree=null;
		Object char_literal64_tree=null;
		Object string_literal65_tree=null;
		Object char_literal66_tree=null;
		Object char_literal67_tree=null;
		Object char_literal68_tree=null;
		Object char_literal69_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:177:3: ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case 43:
				{
				alt10=1;
				}
				break;
			case 51:
				{
				alt10=2;
				}
				break;
			case 44:
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
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:177:5: 'ROTATE' a= INT ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal58=(Token)match(input,43,FOLLOW_43_in_transformStmt565); 
					string_literal58_tree = (Object)adaptor.create(string_literal58);
					adaptor.addChild(root_0, string_literal58_tree);

					a=(Token)match(input,INT,FOLLOW_INT_in_transformStmt569); 
					a_tree = (Object)adaptor.create(a);
					adaptor.addChild(root_0, a_tree);

					char_literal59=(Token)match(input,19,FOLLOW_19_in_transformStmt571); 
					char_literal59_tree = (Object)adaptor.create(char_literal59);
					adaptor.addChild(root_0, char_literal59_tree);

					 System.out.println("ROTATE " + a.getText()); 
					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:178:5: 'TRANSLATE' '(' x= expr ',' y= expr ')' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal60=(Token)match(input,51,FOLLOW_51_in_transformStmt584); 
					string_literal60_tree = (Object)adaptor.create(string_literal60);
					adaptor.addChild(root_0, string_literal60_tree);

					char_literal61=(Token)match(input,12,FOLLOW_12_in_transformStmt586); 
					char_literal61_tree = (Object)adaptor.create(char_literal61);
					adaptor.addChild(root_0, char_literal61_tree);

					pushFollow(FOLLOW_expr_in_transformStmt590);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal62=(Token)match(input,16,FOLLOW_16_in_transformStmt592); 
					char_literal62_tree = (Object)adaptor.create(char_literal62);
					adaptor.addChild(root_0, char_literal62_tree);

					pushFollow(FOLLOW_expr_in_transformStmt596);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal63=(Token)match(input,13,FOLLOW_13_in_transformStmt598); 
					char_literal63_tree = (Object)adaptor.create(char_literal63);
					adaptor.addChild(root_0, char_literal63_tree);

					char_literal64=(Token)match(input,19,FOLLOW_19_in_transformStmt600); 
					char_literal64_tree = (Object)adaptor.create(char_literal64);
					adaptor.addChild(root_0, char_literal64_tree);

					 System.out.println("TRANSLATE ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+")"); 
					}
					break;
				case 3 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:179:5: 'SCALE' '(' sx= expr ',' sy= expr ')' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal65=(Token)match(input,44,FOLLOW_44_in_transformStmt608); 
					string_literal65_tree = (Object)adaptor.create(string_literal65);
					adaptor.addChild(root_0, string_literal65_tree);

					char_literal66=(Token)match(input,12,FOLLOW_12_in_transformStmt610); 
					char_literal66_tree = (Object)adaptor.create(char_literal66);
					adaptor.addChild(root_0, char_literal66_tree);

					pushFollow(FOLLOW_expr_in_transformStmt614);
					sx=expr();
					state._fsp--;

					adaptor.addChild(root_0, sx.getTree());

					char_literal67=(Token)match(input,16,FOLLOW_16_in_transformStmt616); 
					char_literal67_tree = (Object)adaptor.create(char_literal67);
					adaptor.addChild(root_0, char_literal67_tree);

					pushFollow(FOLLOW_expr_in_transformStmt620);
					sy=expr();
					state._fsp--;

					adaptor.addChild(root_0, sy.getTree());

					char_literal68=(Token)match(input,13,FOLLOW_13_in_transformStmt622); 
					char_literal68_tree = (Object)adaptor.create(char_literal68);
					adaptor.addChild(root_0, char_literal68_tree);

					char_literal69=(Token)match(input,19,FOLLOW_19_in_transformStmt624); 
					char_literal69_tree = (Object)adaptor.create(char_literal69);
					adaptor.addChild(root_0, char_literal69_tree);

					 System.out.println("SCALE ("+(sx!=null?((GeoScriptParser.expr_return)sx).value:0)+","+ (sy!=null?((GeoScriptParser.expr_return)sy).value:0)+")"); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "transformStmt"


	public static class shapeStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "shapeStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:185:1: shapeStmt : ( rectStmt | circleStmt | lineStmt | squareStmt | triangleStmt | ellipseStmt | polygonStmt | textStmt );
	public final GeoScriptParser.shapeStmt_return shapeStmt() throws RecognitionException {
		GeoScriptParser.shapeStmt_return retval = new GeoScriptParser.shapeStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rectStmt70 =null;
		ParserRuleReturnScope circleStmt71 =null;
		ParserRuleReturnScope lineStmt72 =null;
		ParserRuleReturnScope squareStmt73 =null;
		ParserRuleReturnScope triangleStmt74 =null;
		ParserRuleReturnScope ellipseStmt75 =null;
		ParserRuleReturnScope polygonStmt76 =null;
		ParserRuleReturnScope textStmt77 =null;


		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:186:3: ( rectStmt | circleStmt | lineStmt | squareStmt | triangleStmt | ellipseStmt | polygonStmt | textStmt )
			int alt11=8;
			switch ( input.LA(1) ) {
			case 42:
				{
				alt11=1;
				}
				break;
			case 28:
				{
				alt11=2;
				}
				break;
			case 37:
				{
				alt11=3;
				}
				break;
			case 46:
				{
				alt11=4;
				}
				break;
			case 52:
				{
				alt11=5;
				}
				break;
			case 31:
				{
				alt11=6;
				}
				break;
			case 39:
				{
				alt11=7;
				}
				break;
			case 48:
				{
				alt11=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:186:5: rectStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rectStmt_in_shapeStmt644);
					rectStmt70=rectStmt();
					state._fsp--;

					adaptor.addChild(root_0, rectStmt70.getTree());

					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:186:16: circleStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_circleStmt_in_shapeStmt648);
					circleStmt71=circleStmt();
					state._fsp--;

					adaptor.addChild(root_0, circleStmt71.getTree());

					}
					break;
				case 3 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:186:29: lineStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_lineStmt_in_shapeStmt652);
					lineStmt72=lineStmt();
					state._fsp--;

					adaptor.addChild(root_0, lineStmt72.getTree());

					}
					break;
				case 4 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:186:40: squareStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_squareStmt_in_shapeStmt656);
					squareStmt73=squareStmt();
					state._fsp--;

					adaptor.addChild(root_0, squareStmt73.getTree());

					}
					break;
				case 5 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:187:5: triangleStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_triangleStmt_in_shapeStmt662);
					triangleStmt74=triangleStmt();
					state._fsp--;

					adaptor.addChild(root_0, triangleStmt74.getTree());

					}
					break;
				case 6 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:187:20: ellipseStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ellipseStmt_in_shapeStmt666);
					ellipseStmt75=ellipseStmt();
					state._fsp--;

					adaptor.addChild(root_0, ellipseStmt75.getTree());

					}
					break;
				case 7 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:187:34: polygonStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_polygonStmt_in_shapeStmt670);
					polygonStmt76=polygonStmt();
					state._fsp--;

					adaptor.addChild(root_0, polygonStmt76.getTree());

					}
					break;
				case 8 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:187:48: textStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_textStmt_in_shapeStmt674);
					textStmt77=textStmt();
					state._fsp--;

					adaptor.addChild(root_0, textStmt77.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "shapeStmt"


	public static class rectStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rectStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:190:1: rectStmt : 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.rectStmt_return rectStmt() throws RecognitionException {
		GeoScriptParser.rectStmt_return retval = new GeoScriptParser.rectStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal78=null;
		Token string_literal79=null;
		Token char_literal80=null;
		Token char_literal81=null;
		Token char_literal82=null;
		Token string_literal83=null;
		Token char_literal84=null;
		Token char_literal85=null;
		Token char_literal86=null;
		Token string_literal87=null;
		Token string_literal88=null;
		Token char_literal89=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope w =null;
		ParserRuleReturnScope h3 =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal78_tree=null;
		Object string_literal79_tree=null;
		Object char_literal80_tree=null;
		Object char_literal81_tree=null;
		Object char_literal82_tree=null;
		Object string_literal83_tree=null;
		Object char_literal84_tree=null;
		Object char_literal85_tree=null;
		Object char_literal86_tree=null;
		Object string_literal87_tree=null;
		Object string_literal88_tree=null;
		Object char_literal89_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:191:3: ( 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:191:5: 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal78=(Token)match(input,42,FOLLOW_42_in_rectStmt687); 
			string_literal78_tree = (Object)adaptor.create(string_literal78);
			adaptor.addChild(root_0, string_literal78_tree);

			string_literal79=(Token)match(input,26,FOLLOW_26_in_rectStmt689); 
			string_literal79_tree = (Object)adaptor.create(string_literal79);
			adaptor.addChild(root_0, string_literal79_tree);

			char_literal80=(Token)match(input,12,FOLLOW_12_in_rectStmt691); 
			char_literal80_tree = (Object)adaptor.create(char_literal80);
			adaptor.addChild(root_0, char_literal80_tree);

			pushFollow(FOLLOW_expr_in_rectStmt695);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal81=(Token)match(input,16,FOLLOW_16_in_rectStmt697); 
			char_literal81_tree = (Object)adaptor.create(char_literal81);
			adaptor.addChild(root_0, char_literal81_tree);

			pushFollow(FOLLOW_expr_in_rectStmt701);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal82=(Token)match(input,13,FOLLOW_13_in_rectStmt703); 
			char_literal82_tree = (Object)adaptor.create(char_literal82);
			adaptor.addChild(root_0, char_literal82_tree);

			string_literal83=(Token)match(input,45,FOLLOW_45_in_rectStmt705); 
			string_literal83_tree = (Object)adaptor.create(string_literal83);
			adaptor.addChild(root_0, string_literal83_tree);

			char_literal84=(Token)match(input,12,FOLLOW_12_in_rectStmt707); 
			char_literal84_tree = (Object)adaptor.create(char_literal84);
			adaptor.addChild(root_0, char_literal84_tree);

			pushFollow(FOLLOW_expr_in_rectStmt711);
			w=expr();
			state._fsp--;

			adaptor.addChild(root_0, w.getTree());

			char_literal85=(Token)match(input,16,FOLLOW_16_in_rectStmt713); 
			char_literal85_tree = (Object)adaptor.create(char_literal85);
			adaptor.addChild(root_0, char_literal85_tree);

			pushFollow(FOLLOW_expr_in_rectStmt717);
			h3=expr();
			state._fsp--;

			adaptor.addChild(root_0, h3.getTree());

			char_literal86=(Token)match(input,13,FOLLOW_13_in_rectStmt719); 
			char_literal86_tree = (Object)adaptor.create(char_literal86);
			adaptor.addChild(root_0, char_literal86_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:192:5: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==33) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:192:6: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal87=(Token)match(input,33,FOLLOW_33_in_rectStmt726); 
					string_literal87_tree = (Object)adaptor.create(string_literal87);
					adaptor.addChild(root_0, string_literal87_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:192:35: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==47) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:192:36: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal88=(Token)match(input,47,FOLLOW_47_in_rectStmt739); 
					string_literal88_tree = (Object)adaptor.create(string_literal88);
					adaptor.addChild(root_0, string_literal88_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal89=(Token)match(input,19,FOLLOW_19_in_rectStmt751); 
			char_literal89_tree = (Object)adaptor.create(char_literal89);
			adaptor.addChild(root_0, char_literal89_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before RECT");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("RECT at ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+") size ("+(w!=null?((GeoScriptParser.expr_return)w).value:0)+","+ (h3!=null?((GeoScriptParser.expr_return)h3).value:0)+")");
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rectStmt"


	public static class circleStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "circleStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:200:1: circleStmt : 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.circleStmt_return circleStmt() throws RecognitionException {
		GeoScriptParser.circleStmt_return retval = new GeoScriptParser.circleStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal90=null;
		Token string_literal91=null;
		Token char_literal92=null;
		Token char_literal93=null;
		Token char_literal94=null;
		Token string_literal95=null;
		Token string_literal96=null;
		Token string_literal97=null;
		Token char_literal98=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope r =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal90_tree=null;
		Object string_literal91_tree=null;
		Object char_literal92_tree=null;
		Object char_literal93_tree=null;
		Object char_literal94_tree=null;
		Object string_literal95_tree=null;
		Object string_literal96_tree=null;
		Object string_literal97_tree=null;
		Object char_literal98_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:201:3: ( 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:201:5: 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal90=(Token)match(input,28,FOLLOW_28_in_circleStmt770); 
			string_literal90_tree = (Object)adaptor.create(string_literal90);
			adaptor.addChild(root_0, string_literal90_tree);

			string_literal91=(Token)match(input,26,FOLLOW_26_in_circleStmt772); 
			string_literal91_tree = (Object)adaptor.create(string_literal91);
			adaptor.addChild(root_0, string_literal91_tree);

			char_literal92=(Token)match(input,12,FOLLOW_12_in_circleStmt774); 
			char_literal92_tree = (Object)adaptor.create(char_literal92);
			adaptor.addChild(root_0, char_literal92_tree);

			pushFollow(FOLLOW_expr_in_circleStmt778);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal93=(Token)match(input,16,FOLLOW_16_in_circleStmt780); 
			char_literal93_tree = (Object)adaptor.create(char_literal93);
			adaptor.addChild(root_0, char_literal93_tree);

			pushFollow(FOLLOW_expr_in_circleStmt784);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal94=(Token)match(input,13,FOLLOW_13_in_circleStmt786); 
			char_literal94_tree = (Object)adaptor.create(char_literal94);
			adaptor.addChild(root_0, char_literal94_tree);

			string_literal95=(Token)match(input,41,FOLLOW_41_in_circleStmt788); 
			string_literal95_tree = (Object)adaptor.create(string_literal95);
			adaptor.addChild(root_0, string_literal95_tree);

			pushFollow(FOLLOW_expr_in_circleStmt792);
			r=expr();
			state._fsp--;

			adaptor.addChild(root_0, r.getTree());

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:202:5: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==33) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:202:6: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal96=(Token)match(input,33,FOLLOW_33_in_circleStmt799); 
					string_literal96_tree = (Object)adaptor.create(string_literal96);
					adaptor.addChild(root_0, string_literal96_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:202:35: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==47) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:202:36: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal97=(Token)match(input,47,FOLLOW_47_in_circleStmt812); 
					string_literal97_tree = (Object)adaptor.create(string_literal97);
					adaptor.addChild(root_0, string_literal97_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal98=(Token)match(input,19,FOLLOW_19_in_circleStmt824); 
			char_literal98_tree = (Object)adaptor.create(char_literal98);
			adaptor.addChild(root_0, char_literal98_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before CIRCLE");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("CIRCLE at ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+") r="+(r!=null?((GeoScriptParser.expr_return)r).value:0));
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "circleStmt"


	public static class lineStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lineStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:210:1: lineStmt : 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' stroke= ( ID | HEX_COLOR ) ';' ;
	public final GeoScriptParser.lineStmt_return lineStmt() throws RecognitionException {
		GeoScriptParser.lineStmt_return retval = new GeoScriptParser.lineStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token stroke=null;
		Token string_literal99=null;
		Token string_literal100=null;
		Token char_literal101=null;
		Token char_literal102=null;
		Token char_literal103=null;
		Token string_literal104=null;
		Token char_literal105=null;
		Token char_literal106=null;
		Token char_literal107=null;
		Token string_literal108=null;
		Token char_literal109=null;
		ParserRuleReturnScope x1 =null;
		ParserRuleReturnScope y1 =null;
		ParserRuleReturnScope x2 =null;
		ParserRuleReturnScope y2 =null;

		Object stroke_tree=null;
		Object string_literal99_tree=null;
		Object string_literal100_tree=null;
		Object char_literal101_tree=null;
		Object char_literal102_tree=null;
		Object char_literal103_tree=null;
		Object string_literal104_tree=null;
		Object char_literal105_tree=null;
		Object char_literal106_tree=null;
		Object char_literal107_tree=null;
		Object string_literal108_tree=null;
		Object char_literal109_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:211:3: ( 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' stroke= ( ID | HEX_COLOR ) ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:211:5: 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' stroke= ( ID | HEX_COLOR ) ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal99=(Token)match(input,37,FOLLOW_37_in_lineStmt843); 
			string_literal99_tree = (Object)adaptor.create(string_literal99);
			adaptor.addChild(root_0, string_literal99_tree);

			string_literal100=(Token)match(input,35,FOLLOW_35_in_lineStmt845); 
			string_literal100_tree = (Object)adaptor.create(string_literal100);
			adaptor.addChild(root_0, string_literal100_tree);

			char_literal101=(Token)match(input,12,FOLLOW_12_in_lineStmt847); 
			char_literal101_tree = (Object)adaptor.create(char_literal101);
			adaptor.addChild(root_0, char_literal101_tree);

			pushFollow(FOLLOW_expr_in_lineStmt851);
			x1=expr();
			state._fsp--;

			adaptor.addChild(root_0, x1.getTree());

			char_literal102=(Token)match(input,16,FOLLOW_16_in_lineStmt853); 
			char_literal102_tree = (Object)adaptor.create(char_literal102);
			adaptor.addChild(root_0, char_literal102_tree);

			pushFollow(FOLLOW_expr_in_lineStmt857);
			y1=expr();
			state._fsp--;

			adaptor.addChild(root_0, y1.getTree());

			char_literal103=(Token)match(input,13,FOLLOW_13_in_lineStmt859); 
			char_literal103_tree = (Object)adaptor.create(char_literal103);
			adaptor.addChild(root_0, char_literal103_tree);

			string_literal104=(Token)match(input,50,FOLLOW_50_in_lineStmt861); 
			string_literal104_tree = (Object)adaptor.create(string_literal104);
			adaptor.addChild(root_0, string_literal104_tree);

			char_literal105=(Token)match(input,12,FOLLOW_12_in_lineStmt863); 
			char_literal105_tree = (Object)adaptor.create(char_literal105);
			adaptor.addChild(root_0, char_literal105_tree);

			pushFollow(FOLLOW_expr_in_lineStmt867);
			x2=expr();
			state._fsp--;

			adaptor.addChild(root_0, x2.getTree());

			char_literal106=(Token)match(input,16,FOLLOW_16_in_lineStmt869); 
			char_literal106_tree = (Object)adaptor.create(char_literal106);
			adaptor.addChild(root_0, char_literal106_tree);

			pushFollow(FOLLOW_expr_in_lineStmt873);
			y2=expr();
			state._fsp--;

			adaptor.addChild(root_0, y2.getTree());

			char_literal107=(Token)match(input,13,FOLLOW_13_in_lineStmt875); 
			char_literal107_tree = (Object)adaptor.create(char_literal107);
			adaptor.addChild(root_0, char_literal107_tree);

			string_literal108=(Token)match(input,47,FOLLOW_47_in_lineStmt877); 
			string_literal108_tree = (Object)adaptor.create(string_literal108);
			adaptor.addChild(root_0, string_literal108_tree);

			stroke=input.LT(1);
			if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(stroke));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal109=(Token)match(input,19,FOLLOW_19_in_lineStmt887); 
			char_literal109_tree = (Object)adaptor.create(char_literal109);
			adaptor.addChild(root_0, char_literal109_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before LINE");
			      if (stroke != null && stroke.getType() == ID) sem.checkColor(stroke.getText(), stroke);
			      System.out.println("LINE from ("+(x1!=null?((GeoScriptParser.expr_return)x1).value:0)+","+ (y1!=null?((GeoScriptParser.expr_return)y1).value:0)+") to ("+(x2!=null?((GeoScriptParser.expr_return)x2).value:0)+","+ (y2!=null?((GeoScriptParser.expr_return)y2).value:0)+")");
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lineStmt"


	public static class squareStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "squareStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:219:1: squareStmt : 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' s= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.squareStmt_return squareStmt() throws RecognitionException {
		GeoScriptParser.squareStmt_return retval = new GeoScriptParser.squareStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal110=null;
		Token string_literal111=null;
		Token char_literal112=null;
		Token char_literal113=null;
		Token char_literal114=null;
		Token string_literal115=null;
		Token string_literal116=null;
		Token string_literal117=null;
		Token char_literal118=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope s =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal110_tree=null;
		Object string_literal111_tree=null;
		Object char_literal112_tree=null;
		Object char_literal113_tree=null;
		Object char_literal114_tree=null;
		Object string_literal115_tree=null;
		Object string_literal116_tree=null;
		Object string_literal117_tree=null;
		Object char_literal118_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:220:3: ( 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' s= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:220:5: 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' s= expr ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal110=(Token)match(input,46,FOLLOW_46_in_squareStmt906); 
			string_literal110_tree = (Object)adaptor.create(string_literal110);
			adaptor.addChild(root_0, string_literal110_tree);

			string_literal111=(Token)match(input,26,FOLLOW_26_in_squareStmt908); 
			string_literal111_tree = (Object)adaptor.create(string_literal111);
			adaptor.addChild(root_0, string_literal111_tree);

			char_literal112=(Token)match(input,12,FOLLOW_12_in_squareStmt910); 
			char_literal112_tree = (Object)adaptor.create(char_literal112);
			adaptor.addChild(root_0, char_literal112_tree);

			pushFollow(FOLLOW_expr_in_squareStmt914);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal113=(Token)match(input,16,FOLLOW_16_in_squareStmt916); 
			char_literal113_tree = (Object)adaptor.create(char_literal113);
			adaptor.addChild(root_0, char_literal113_tree);

			pushFollow(FOLLOW_expr_in_squareStmt920);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal114=(Token)match(input,13,FOLLOW_13_in_squareStmt922); 
			char_literal114_tree = (Object)adaptor.create(char_literal114);
			adaptor.addChild(root_0, char_literal114_tree);

			string_literal115=(Token)match(input,45,FOLLOW_45_in_squareStmt924); 
			string_literal115_tree = (Object)adaptor.create(string_literal115);
			adaptor.addChild(root_0, string_literal115_tree);

			pushFollow(FOLLOW_expr_in_squareStmt928);
			s=expr();
			state._fsp--;

			adaptor.addChild(root_0, s.getTree());

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:221:5: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==33) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:221:6: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal116=(Token)match(input,33,FOLLOW_33_in_squareStmt935); 
					string_literal116_tree = (Object)adaptor.create(string_literal116);
					adaptor.addChild(root_0, string_literal116_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:221:35: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==47) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:221:36: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal117=(Token)match(input,47,FOLLOW_47_in_squareStmt948); 
					string_literal117_tree = (Object)adaptor.create(string_literal117);
					adaptor.addChild(root_0, string_literal117_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal118=(Token)match(input,19,FOLLOW_19_in_squareStmt960); 
			char_literal118_tree = (Object)adaptor.create(char_literal118);
			adaptor.addChild(root_0, char_literal118_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before SQUARE");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("SQUARE at ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+") size "+(s!=null?((GeoScriptParser.expr_return)s).value:0));
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "squareStmt"


	public static class triangleStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "triangleStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:229:1: triangleStmt : 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' x2= expr ',' y2= expr ',' x3= expr ',' y3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.triangleStmt_return triangleStmt() throws RecognitionException {
		GeoScriptParser.triangleStmt_return retval = new GeoScriptParser.triangleStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal119=null;
		Token string_literal120=null;
		Token char_literal121=null;
		Token char_literal122=null;
		Token char_literal123=null;
		Token string_literal124=null;
		Token char_literal125=null;
		Token char_literal126=null;
		Token char_literal127=null;
		Token char_literal128=null;
		Token char_literal129=null;
		Token string_literal130=null;
		Token string_literal131=null;
		Token char_literal132=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope x2 =null;
		ParserRuleReturnScope y2 =null;
		ParserRuleReturnScope x3 =null;
		ParserRuleReturnScope y3 =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal119_tree=null;
		Object string_literal120_tree=null;
		Object char_literal121_tree=null;
		Object char_literal122_tree=null;
		Object char_literal123_tree=null;
		Object string_literal124_tree=null;
		Object char_literal125_tree=null;
		Object char_literal126_tree=null;
		Object char_literal127_tree=null;
		Object char_literal128_tree=null;
		Object char_literal129_tree=null;
		Object string_literal130_tree=null;
		Object string_literal131_tree=null;
		Object char_literal132_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:230:3: ( 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' x2= expr ',' y2= expr ',' x3= expr ',' y3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:230:5: 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' x2= expr ',' y2= expr ',' x3= expr ',' y3= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal119=(Token)match(input,52,FOLLOW_52_in_triangleStmt979); 
			string_literal119_tree = (Object)adaptor.create(string_literal119);
			adaptor.addChild(root_0, string_literal119_tree);

			string_literal120=(Token)match(input,26,FOLLOW_26_in_triangleStmt981); 
			string_literal120_tree = (Object)adaptor.create(string_literal120);
			adaptor.addChild(root_0, string_literal120_tree);

			char_literal121=(Token)match(input,12,FOLLOW_12_in_triangleStmt983); 
			char_literal121_tree = (Object)adaptor.create(char_literal121);
			adaptor.addChild(root_0, char_literal121_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt987);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal122=(Token)match(input,16,FOLLOW_16_in_triangleStmt989); 
			char_literal122_tree = (Object)adaptor.create(char_literal122);
			adaptor.addChild(root_0, char_literal122_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt993);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal123=(Token)match(input,13,FOLLOW_13_in_triangleStmt995); 
			char_literal123_tree = (Object)adaptor.create(char_literal123);
			adaptor.addChild(root_0, char_literal123_tree);

			string_literal124=(Token)match(input,38,FOLLOW_38_in_triangleStmt997); 
			string_literal124_tree = (Object)adaptor.create(string_literal124);
			adaptor.addChild(root_0, string_literal124_tree);

			char_literal125=(Token)match(input,12,FOLLOW_12_in_triangleStmt999); 
			char_literal125_tree = (Object)adaptor.create(char_literal125);
			adaptor.addChild(root_0, char_literal125_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt1003);
			x2=expr();
			state._fsp--;

			adaptor.addChild(root_0, x2.getTree());

			char_literal126=(Token)match(input,16,FOLLOW_16_in_triangleStmt1005); 
			char_literal126_tree = (Object)adaptor.create(char_literal126);
			adaptor.addChild(root_0, char_literal126_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt1009);
			y2=expr();
			state._fsp--;

			adaptor.addChild(root_0, y2.getTree());

			char_literal127=(Token)match(input,16,FOLLOW_16_in_triangleStmt1011); 
			char_literal127_tree = (Object)adaptor.create(char_literal127);
			adaptor.addChild(root_0, char_literal127_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt1015);
			x3=expr();
			state._fsp--;

			adaptor.addChild(root_0, x3.getTree());

			char_literal128=(Token)match(input,16,FOLLOW_16_in_triangleStmt1017); 
			char_literal128_tree = (Object)adaptor.create(char_literal128);
			adaptor.addChild(root_0, char_literal128_tree);

			pushFollow(FOLLOW_expr_in_triangleStmt1021);
			y3=expr();
			state._fsp--;

			adaptor.addChild(root_0, y3.getTree());

			char_literal129=(Token)match(input,13,FOLLOW_13_in_triangleStmt1023); 
			char_literal129_tree = (Object)adaptor.create(char_literal129);
			adaptor.addChild(root_0, char_literal129_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:231:5: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==33) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:231:6: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal130=(Token)match(input,33,FOLLOW_33_in_triangleStmt1030); 
					string_literal130_tree = (Object)adaptor.create(string_literal130);
					adaptor.addChild(root_0, string_literal130_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:231:35: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==47) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:231:36: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal131=(Token)match(input,47,FOLLOW_47_in_triangleStmt1043); 
					string_literal131_tree = (Object)adaptor.create(string_literal131);
					adaptor.addChild(root_0, string_literal131_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal132=(Token)match(input,19,FOLLOW_19_in_triangleStmt1055); 
			char_literal132_tree = (Object)adaptor.create(char_literal132);
			adaptor.addChild(root_0, char_literal132_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before TRIANGLE");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("TRIANGLE at ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+") points ("+(x2!=null?((GeoScriptParser.expr_return)x2).value:0)+","+ (y2!=null?((GeoScriptParser.expr_return)y2).value:0)+","+ (x3!=null?((GeoScriptParser.expr_return)x3).value:0)+","+ (y3!=null?((GeoScriptParser.expr_return)y3).value:0)+")");
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triangleStmt"


	public static class ellipseStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ellipseStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:239:1: ellipseStmt : 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.ellipseStmt_return ellipseStmt() throws RecognitionException {
		GeoScriptParser.ellipseStmt_return retval = new GeoScriptParser.ellipseStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal133=null;
		Token string_literal134=null;
		Token char_literal135=null;
		Token char_literal136=null;
		Token char_literal137=null;
		Token string_literal138=null;
		Token char_literal139=null;
		Token char_literal140=null;
		Token char_literal141=null;
		Token string_literal142=null;
		Token string_literal143=null;
		Token char_literal144=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope rx =null;
		ParserRuleReturnScope ry =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal133_tree=null;
		Object string_literal134_tree=null;
		Object char_literal135_tree=null;
		Object char_literal136_tree=null;
		Object char_literal137_tree=null;
		Object string_literal138_tree=null;
		Object char_literal139_tree=null;
		Object char_literal140_tree=null;
		Object char_literal141_tree=null;
		Object string_literal142_tree=null;
		Object string_literal143_tree=null;
		Object char_literal144_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:240:3: ( 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:240:5: 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal133=(Token)match(input,31,FOLLOW_31_in_ellipseStmt1074); 
			string_literal133_tree = (Object)adaptor.create(string_literal133);
			adaptor.addChild(root_0, string_literal133_tree);

			string_literal134=(Token)match(input,26,FOLLOW_26_in_ellipseStmt1076); 
			string_literal134_tree = (Object)adaptor.create(string_literal134);
			adaptor.addChild(root_0, string_literal134_tree);

			char_literal135=(Token)match(input,12,FOLLOW_12_in_ellipseStmt1078); 
			char_literal135_tree = (Object)adaptor.create(char_literal135);
			adaptor.addChild(root_0, char_literal135_tree);

			pushFollow(FOLLOW_expr_in_ellipseStmt1082);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal136=(Token)match(input,16,FOLLOW_16_in_ellipseStmt1084); 
			char_literal136_tree = (Object)adaptor.create(char_literal136);
			adaptor.addChild(root_0, char_literal136_tree);

			pushFollow(FOLLOW_expr_in_ellipseStmt1088);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal137=(Token)match(input,13,FOLLOW_13_in_ellipseStmt1090); 
			char_literal137_tree = (Object)adaptor.create(char_literal137);
			adaptor.addChild(root_0, char_literal137_tree);

			string_literal138=(Token)match(input,40,FOLLOW_40_in_ellipseStmt1092); 
			string_literal138_tree = (Object)adaptor.create(string_literal138);
			adaptor.addChild(root_0, string_literal138_tree);

			char_literal139=(Token)match(input,12,FOLLOW_12_in_ellipseStmt1094); 
			char_literal139_tree = (Object)adaptor.create(char_literal139);
			adaptor.addChild(root_0, char_literal139_tree);

			pushFollow(FOLLOW_expr_in_ellipseStmt1098);
			rx=expr();
			state._fsp--;

			adaptor.addChild(root_0, rx.getTree());

			char_literal140=(Token)match(input,16,FOLLOW_16_in_ellipseStmt1100); 
			char_literal140_tree = (Object)adaptor.create(char_literal140);
			adaptor.addChild(root_0, char_literal140_tree);

			pushFollow(FOLLOW_expr_in_ellipseStmt1104);
			ry=expr();
			state._fsp--;

			adaptor.addChild(root_0, ry.getTree());

			char_literal141=(Token)match(input,13,FOLLOW_13_in_ellipseStmt1106); 
			char_literal141_tree = (Object)adaptor.create(char_literal141);
			adaptor.addChild(root_0, char_literal141_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:241:5: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==33) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:241:6: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal142=(Token)match(input,33,FOLLOW_33_in_ellipseStmt1113); 
					string_literal142_tree = (Object)adaptor.create(string_literal142);
					adaptor.addChild(root_0, string_literal142_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:241:35: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==47) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:241:36: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal143=(Token)match(input,47,FOLLOW_47_in_ellipseStmt1126); 
					string_literal143_tree = (Object)adaptor.create(string_literal143);
					adaptor.addChild(root_0, string_literal143_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal144=(Token)match(input,19,FOLLOW_19_in_ellipseStmt1138); 
			char_literal144_tree = (Object)adaptor.create(char_literal144);
			adaptor.addChild(root_0, char_literal144_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before ELLIPSE");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("ELLIPSE ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+") radii ("+(rx!=null?((GeoScriptParser.expr_return)rx).value:0)+","+ (ry!=null?((GeoScriptParser.expr_return)ry).value:0)+")");
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ellipseStmt"


	public static class polygonStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "polygonStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:249:1: polygonStmt : 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.polygonStmt_return polygonStmt() throws RecognitionException {
		GeoScriptParser.polygonStmt_return retval = new GeoScriptParser.polygonStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fill=null;
		Token stroke=null;
		Token string_literal145=null;
		Token string_literal146=null;
		Token char_literal147=null;
		Token char_literal148=null;
		Token string_literal149=null;
		Token string_literal150=null;
		Token char_literal151=null;
		ParserRuleReturnScope pts =null;

		Object fill_tree=null;
		Object stroke_tree=null;
		Object string_literal145_tree=null;
		Object string_literal146_tree=null;
		Object char_literal147_tree=null;
		Object char_literal148_tree=null;
		Object string_literal149_tree=null;
		Object string_literal150_tree=null;
		Object char_literal151_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:3: ( 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:5: 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' fill= ( ID | HEX_COLOR ) )? ( 'STROKE' stroke= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal145=(Token)match(input,39,FOLLOW_39_in_polygonStmt1157); 
			string_literal145_tree = (Object)adaptor.create(string_literal145);
			adaptor.addChild(root_0, string_literal145_tree);

			string_literal146=(Token)match(input,38,FOLLOW_38_in_polygonStmt1159); 
			string_literal146_tree = (Object)adaptor.create(string_literal146);
			adaptor.addChild(root_0, string_literal146_tree);

			char_literal147=(Token)match(input,12,FOLLOW_12_in_polygonStmt1161); 
			char_literal147_tree = (Object)adaptor.create(char_literal147);
			adaptor.addChild(root_0, char_literal147_tree);

			pushFollow(FOLLOW_pointList_in_polygonStmt1165);
			pts=pointList();
			state._fsp--;

			adaptor.addChild(root_0, pts.getTree());

			char_literal148=(Token)match(input,13,FOLLOW_13_in_polygonStmt1167); 
			char_literal148_tree = (Object)adaptor.create(char_literal148);
			adaptor.addChild(root_0, char_literal148_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:46: ( 'FILL' fill= ( ID | HEX_COLOR ) )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==33) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:47: 'FILL' fill= ( ID | HEX_COLOR )
					{
					string_literal149=(Token)match(input,33,FOLLOW_33_in_polygonStmt1170); 
					string_literal149_tree = (Object)adaptor.create(string_literal149);
					adaptor.addChild(root_0, string_literal149_tree);

					fill=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(fill));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:76: ( 'STROKE' stroke= ( ID | HEX_COLOR ) )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==47) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:250:77: 'STROKE' stroke= ( ID | HEX_COLOR )
					{
					string_literal150=(Token)match(input,47,FOLLOW_47_in_polygonStmt1183); 
					string_literal150_tree = (Object)adaptor.create(string_literal150);
					adaptor.addChild(root_0, string_literal150_tree);

					stroke=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(stroke));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal151=(Token)match(input,19,FOLLOW_19_in_polygonStmt1195); 
			char_literal151_tree = (Object)adaptor.create(char_literal151);
			adaptor.addChild(root_0, char_literal151_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before POLYGON");
			      if (fill != null && fill.getType() == ID) sem.checkColor(fill.getText(), fill);
			      System.out.println("POLYGON points "+(pts!=null?((GeoScriptParser.pointList_return)pts).text:null));
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "polygonStmt"


	public static class textStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "textStmt"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:258:1: textStmt : 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptParser.textStmt_return textStmt() throws RecognitionException {
		GeoScriptParser.textStmt_return retval = new GeoScriptParser.textStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token str=null;
		Token c=null;
		Token string_literal152=null;
		Token char_literal153=null;
		Token char_literal154=null;
		Token char_literal155=null;
		Token char_literal156=null;
		Token string_literal157=null;
		Token char_literal158=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;

		Object str_tree=null;
		Object c_tree=null;
		Object string_literal152_tree=null;
		Object char_literal153_tree=null;
		Object char_literal154_tree=null;
		Object char_literal155_tree=null;
		Object char_literal156_tree=null;
		Object string_literal157_tree=null;
		Object char_literal158_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:259:3: ( 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:259:5: 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal152=(Token)match(input,48,FOLLOW_48_in_textStmt1214); 
			string_literal152_tree = (Object)adaptor.create(string_literal152);
			adaptor.addChild(root_0, string_literal152_tree);

			char_literal153=(Token)match(input,12,FOLLOW_12_in_textStmt1216); 
			char_literal153_tree = (Object)adaptor.create(char_literal153);
			adaptor.addChild(root_0, char_literal153_tree);

			str=(Token)match(input,STRING,FOLLOW_STRING_in_textStmt1220); 
			str_tree = (Object)adaptor.create(str);
			adaptor.addChild(root_0, str_tree);

			char_literal154=(Token)match(input,16,FOLLOW_16_in_textStmt1222); 
			char_literal154_tree = (Object)adaptor.create(char_literal154);
			adaptor.addChild(root_0, char_literal154_tree);

			pushFollow(FOLLOW_expr_in_textStmt1226);
			x=expr();
			state._fsp--;

			adaptor.addChild(root_0, x.getTree());

			char_literal155=(Token)match(input,16,FOLLOW_16_in_textStmt1228); 
			char_literal155_tree = (Object)adaptor.create(char_literal155);
			adaptor.addChild(root_0, char_literal155_tree);

			pushFollow(FOLLOW_expr_in_textStmt1232);
			y=expr();
			state._fsp--;

			adaptor.addChild(root_0, y.getTree());

			char_literal156=(Token)match(input,13,FOLLOW_13_in_textStmt1234); 
			char_literal156_tree = (Object)adaptor.create(char_literal156);
			adaptor.addChild(root_0, char_literal156_tree);

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:259:53: ( 'COLOR' c= ( ID | HEX_COLOR ) )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==29) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:259:54: 'COLOR' c= ( ID | HEX_COLOR )
					{
					string_literal157=(Token)match(input,29,FOLLOW_29_in_textStmt1237); 
					string_literal157_tree = (Object)adaptor.create(string_literal157);
					adaptor.addChild(root_0, string_literal157_tree);

					c=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(c));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal158=(Token)match(input,19,FOLLOW_19_in_textStmt1249); 
			char_literal158_tree = (Object)adaptor.create(char_literal158);
			adaptor.addChild(root_0, char_literal158_tree);


			      if (!sem.canvasDefined) System.err.println("Error: Canvas not defined before TEXT");
			      if (c != null && c.getType() == ID) sem.checkColor(c.getText(), c);
			      System.out.println("TEXT "+str.getText()+" at ("+(x!=null?((GeoScriptParser.expr_return)x).value:0)+","+ (y!=null?((GeoScriptParser.expr_return)y).value:0)+")");
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "textStmt"


	public static class pointList_return extends ParserRuleReturnScope {
		public String text;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pointList"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:267:1: pointList returns [String text] : firstX= expr ',' firstY= expr ( ',' x= expr ',' y= expr )* ;
	public final GeoScriptParser.pointList_return pointList() throws RecognitionException {
		GeoScriptParser.pointList_return retval = new GeoScriptParser.pointList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal159=null;
		Token char_literal160=null;
		Token char_literal161=null;
		ParserRuleReturnScope firstX =null;
		ParserRuleReturnScope firstY =null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;

		Object char_literal159_tree=null;
		Object char_literal160_tree=null;
		Object char_literal161_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:268:3: (firstX= expr ',' firstY= expr ( ',' x= expr ',' y= expr )* )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:268:5: firstX= expr ',' firstY= expr ( ',' x= expr ',' y= expr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_pointList1274);
			firstX=expr();
			state._fsp--;

			adaptor.addChild(root_0, firstX.getTree());

			char_literal159=(Token)match(input,16,FOLLOW_16_in_pointList1276); 
			char_literal159_tree = (Object)adaptor.create(char_literal159);
			adaptor.addChild(root_0, char_literal159_tree);

			pushFollow(FOLLOW_expr_in_pointList1280);
			firstY=expr();
			state._fsp--;

			adaptor.addChild(root_0, firstY.getTree());

			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:269:5: ( ',' x= expr ',' y= expr )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==16) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:269:7: ',' x= expr ',' y= expr
					{
					char_literal160=(Token)match(input,16,FOLLOW_16_in_pointList1288); 
					char_literal160_tree = (Object)adaptor.create(char_literal160);
					adaptor.addChild(root_0, char_literal160_tree);

					pushFollow(FOLLOW_expr_in_pointList1292);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal161=(Token)match(input,16,FOLLOW_16_in_pointList1294); 
					char_literal161_tree = (Object)adaptor.create(char_literal161);
					adaptor.addChild(root_0, char_literal161_tree);

					pushFollow(FOLLOW_expr_in_pointList1298);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					 if (retval.text==null) retval.text = (firstX!=null?((GeoScriptParser.expr_return)firstX).value:0) + "," + (firstY!=null?((GeoScriptParser.expr_return)firstY).value:0) + "," + (x!=null?((GeoScriptParser.expr_return)x).value:0) + "," + (y!=null?((GeoScriptParser.expr_return)y).value:0); else retval.text += ","+(x!=null?((GeoScriptParser.expr_return)x).value:0)+ "," + (y!=null?((GeoScriptParser.expr_return)y).value:0); 
					}
					break;

				default :
					break loop25;
				}
			}

			 if (retval.text==null) retval.text = (firstX!=null?((GeoScriptParser.expr_return)firstX).value:0) + "," + (firstY!=null?((GeoScriptParser.expr_return)firstY).value:0); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pointList"


	public static class expr_return extends ParserRuleReturnScope {
		public int value;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:276:1: expr returns [int value] : a= term ( '+' b= term | '-' c= term )* ;
	public final GeoScriptParser.expr_return expr() throws RecognitionException {
		GeoScriptParser.expr_return retval = new GeoScriptParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal162=null;
		Token char_literal163=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		Object char_literal162_tree=null;
		Object char_literal163_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:277:3: (a= term ( '+' b= term | '-' c= term )* )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:277:5: a= term ( '+' b= term | '-' c= term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term_in_expr1331);
			a=term();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			 retval.value =(a!=null?((GeoScriptParser.term_return)a).value:0); 
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:278:5: ( '+' b= term | '-' c= term )*
			loop26:
			while (true) {
				int alt26=3;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==15) ) {
					alt26=1;
				}
				else if ( (LA26_0==17) ) {
					alt26=2;
				}

				switch (alt26) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:278:7: '+' b= term
					{
					char_literal162=(Token)match(input,15,FOLLOW_15_in_expr1341); 
					char_literal162_tree = (Object)adaptor.create(char_literal162);
					adaptor.addChild(root_0, char_literal162_tree);

					pushFollow(FOLLOW_term_in_expr1345);
					b=term();
					state._fsp--;

					adaptor.addChild(root_0, b.getTree());

					 retval.value+=(b!=null?((GeoScriptParser.term_return)b).value:0); 
					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:279:7: '-' c= term
					{
					char_literal163=(Token)match(input,17,FOLLOW_17_in_expr1355); 
					char_literal163_tree = (Object)adaptor.create(char_literal163);
					adaptor.addChild(root_0, char_literal163_tree);

					pushFollow(FOLLOW_term_in_expr1359);
					c=term();
					state._fsp--;

					adaptor.addChild(root_0, c.getTree());

					 retval.value-=(c!=null?((GeoScriptParser.term_return)c).value:0); 
					}
					break;

				default :
					break loop26;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		public int value;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:283:1: term returns [int value] : f= factor ( '*' g= factor | '/' g2= factor )* ;
	public final GeoScriptParser.term_return term() throws RecognitionException {
		GeoScriptParser.term_return retval = new GeoScriptParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal164=null;
		Token char_literal165=null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope g =null;
		ParserRuleReturnScope g2 =null;

		Object char_literal164_tree=null;
		Object char_literal165_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:284:3: (f= factor ( '*' g= factor | '/' g2= factor )* )
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:284:5: f= factor ( '*' g= factor | '/' g2= factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1387);
			f=factor();
			state._fsp--;

			adaptor.addChild(root_0, f.getTree());

			 retval.value =(f!=null?((GeoScriptParser.factor_return)f).value:0); 
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:285:5: ( '*' g= factor | '/' g2= factor )*
			loop27:
			while (true) {
				int alt27=3;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==14) ) {
					alt27=1;
				}
				else if ( (LA27_0==18) ) {
					alt27=2;
				}

				switch (alt27) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:285:7: '*' g= factor
					{
					char_literal164=(Token)match(input,14,FOLLOW_14_in_term1397); 
					char_literal164_tree = (Object)adaptor.create(char_literal164);
					adaptor.addChild(root_0, char_literal164_tree);

					pushFollow(FOLLOW_factor_in_term1401);
					g=factor();
					state._fsp--;

					adaptor.addChild(root_0, g.getTree());

					 retval.value*=(g!=null?((GeoScriptParser.factor_return)g).value:0); 
					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:286:7: '/' g2= factor
					{
					char_literal165=(Token)match(input,18,FOLLOW_18_in_term1411); 
					char_literal165_tree = (Object)adaptor.create(char_literal165);
					adaptor.addChild(root_0, char_literal165_tree);

					pushFollow(FOLLOW_factor_in_term1415);
					g2=factor();
					state._fsp--;

					adaptor.addChild(root_0, g2.getTree());

					 if((g2!=null?((GeoScriptParser.factor_return)g2).value:0)==0){System.err.println("Div0");retval.value =0;}else retval.value/=(g2!=null?((GeoScriptParser.factor_return)g2).value:0);
					}
					break;

				default :
					break loop27;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		public int value;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:290:1: factor returns [int value] : (n= INT |id= ID | '(' e= expr ')' );
	public final GeoScriptParser.factor_return factor() throws RecognitionException {
		GeoScriptParser.factor_return retval = new GeoScriptParser.factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token id=null;
		Token char_literal166=null;
		Token char_literal167=null;
		ParserRuleReturnScope e =null;

		Object n_tree=null;
		Object id_tree=null;
		Object char_literal166_tree=null;
		Object char_literal167_tree=null;

		try {
			// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:291:3: (n= INT |id= ID | '(' e= expr ')' )
			int alt28=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt28=1;
				}
				break;
			case ID:
				{
				alt28=2;
				}
				break;
			case 12:
				{
				alt28=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:291:5: n= INT
					{
					root_0 = (Object)adaptor.nil();


					n=(Token)match(input,INT,FOLLOW_INT_in_factor1443); 
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);

					 retval.value =Integer.parseInt(n.getText()); 
					}
					break;
				case 2 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:292:5: id= ID
					{
					root_0 = (Object)adaptor.nil();


					id=(Token)match(input,ID,FOLLOW_ID_in_factor1453); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);


					      if (!sem.isVarDefined(id.getText())) { System.err.println("Warning: var '"+id.getText()+"' undef"); retval.value =0; }
					      else retval.value =sem.getVarValue(id.getText());
					    
					}
					break;
				case 3 :
					// /Users/davidegirolamo/Programming/ProgettoLFC/GeoScript.g:296:5: '(' e= expr ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal166=(Token)match(input,12,FOLLOW_12_in_factor1461); 
					char_literal166_tree = (Object)adaptor.create(char_literal166);
					adaptor.addChild(root_0, char_literal166_tree);

					pushFollow(FOLLOW_expr_in_factor1465);
					e=expr();
					state._fsp--;

					adaptor.addChild(root_0, e.getTree());

					char_literal167=(Token)match(input,13,FOLLOW_13_in_factor1467); 
					char_literal167_tree = (Object)adaptor.create(char_literal167);
					adaptor.addChild(root_0, char_literal167_tree);

					 retval.value =(e!=null?((GeoScriptParser.expr_return)e).value:0); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_prog55 = new BitSet(new long[]{0x00795CB4D80000A0L});
	public static final BitSet FOLLOW_EOF_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_canvasStmt_in_statement70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_colorDef_in_statement76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varDecl_in_statement82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignStmt_in_statement88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStmt_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStmt_in_statement100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forStmt_in_statement106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_transformStmt_in_statement112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shapeStmt_in_statement118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMENTLINE_in_statement124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_canvasStmt140 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_canvasStmt142 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt146 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_canvasStmt148 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt152 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_canvasStmt154 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_canvasStmt156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_varDecl178 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_varDecl182 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_varDecl184 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_varDecl188 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_varDecl190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStmt211 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_assignStmt213 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_assignStmt217 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_assignStmt219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_colorDef241 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_colorDef245 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_colorDef247 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_HEX_COLOR_in_colorDef251 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_colorDef253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_ifStmt275 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_ifStmt277 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_condition_in_ifStmt281 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ifStmt283 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_ifStmt285 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_ifStmt287 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt290 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_56_in_ifStmt294 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_ifStmt297 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_ifStmt299 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt302 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_56_in_ifStmt306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_condition333 = new BitSet(new long[]{0x0000000003B00800L});
	public static final BitSet FOLLOW_set_in_condition337 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_condition365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_whileStmt387 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_whileStmt389 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_condition_in_whileStmt393 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_whileStmt395 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_whileStmt397 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_statement_in_whileStmt400 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_56_in_whileStmt404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_forStmt426 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_forStmt428 = new BitSet(new long[]{0x0020000000080080L});
	public static final BitSet FOLLOW_53_in_forStmt438 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_forStmt442 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forStmt444 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_forStmt448 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_forStmt450 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_ID_in_forStmt464 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forStmt466 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_forStmt470 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_forStmt472 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_19_in_forStmt484 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_condition_in_forStmt502 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_forStmt504 = new BitSet(new long[]{0x0000000000080080L});
	public static final BitSet FOLLOW_ID_in_forStmt516 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forStmt518 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_forStmt522 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_19_in_forStmt526 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_forStmt534 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_forStmt536 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_statement_in_forStmt539 = new BitSet(new long[]{0x01795CB4D80000A0L});
	public static final BitSet FOLLOW_56_in_forStmt543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_transformStmt565 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_transformStmt569 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_transformStmt584 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_transformStmt586 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt590 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_transformStmt592 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt596 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt598 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_transformStmt608 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_transformStmt610 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt614 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_transformStmt616 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_transformStmt620 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt622 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_transformStmt624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rectStmt_in_shapeStmt644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_circleStmt_in_shapeStmt648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lineStmt_in_shapeStmt652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_squareStmt_in_shapeStmt656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_triangleStmt_in_shapeStmt662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ellipseStmt_in_shapeStmt666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_polygonStmt_in_shapeStmt670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_textStmt_in_shapeStmt674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_rectStmt687 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_rectStmt689 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_rectStmt691 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_rectStmt695 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_rectStmt697 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_rectStmt701 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_rectStmt703 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_rectStmt705 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_rectStmt707 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_rectStmt711 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_rectStmt713 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_rectStmt717 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_rectStmt719 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_rectStmt726 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_rectStmt730 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_rectStmt739 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_rectStmt743 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_rectStmt751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_circleStmt770 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_circleStmt772 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_circleStmt774 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_circleStmt778 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_circleStmt780 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_circleStmt784 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_circleStmt786 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_circleStmt788 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_circleStmt792 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_circleStmt799 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_circleStmt803 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_circleStmt812 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_circleStmt816 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_circleStmt824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_lineStmt843 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_lineStmt845 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_lineStmt847 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_lineStmt851 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_lineStmt853 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_lineStmt857 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_lineStmt859 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_lineStmt861 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_lineStmt863 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_lineStmt867 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_lineStmt869 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_lineStmt873 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_lineStmt875 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_lineStmt877 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_lineStmt881 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_lineStmt887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_squareStmt906 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_squareStmt908 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_squareStmt910 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_squareStmt914 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_squareStmt916 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_squareStmt920 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_squareStmt922 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_squareStmt924 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_squareStmt928 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_squareStmt935 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_squareStmt939 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_squareStmt948 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_squareStmt952 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_squareStmt960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_triangleStmt979 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_triangleStmt981 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_triangleStmt983 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt987 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_triangleStmt989 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt993 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_triangleStmt995 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_triangleStmt997 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_triangleStmt999 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt1003 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_triangleStmt1005 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt1009 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_triangleStmt1011 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt1015 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_triangleStmt1017 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_triangleStmt1021 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_triangleStmt1023 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_triangleStmt1030 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_triangleStmt1034 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_triangleStmt1043 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_triangleStmt1047 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_triangleStmt1055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_ellipseStmt1074 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_ellipseStmt1076 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_ellipseStmt1078 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_ellipseStmt1082 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ellipseStmt1084 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_ellipseStmt1088 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ellipseStmt1090 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_ellipseStmt1092 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_ellipseStmt1094 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_ellipseStmt1098 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ellipseStmt1100 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_ellipseStmt1104 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ellipseStmt1106 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_ellipseStmt1113 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_ellipseStmt1117 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_ellipseStmt1126 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_ellipseStmt1130 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_ellipseStmt1138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_polygonStmt1157 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_polygonStmt1159 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_polygonStmt1161 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_pointList_in_polygonStmt1165 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_polygonStmt1167 = new BitSet(new long[]{0x0000800200080000L});
	public static final BitSet FOLLOW_33_in_polygonStmt1170 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_polygonStmt1174 = new BitSet(new long[]{0x0000800000080000L});
	public static final BitSet FOLLOW_47_in_polygonStmt1183 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_polygonStmt1187 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_polygonStmt1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_textStmt1214 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_textStmt1216 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_in_textStmt1220 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_textStmt1222 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_textStmt1226 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_textStmt1228 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_textStmt1232 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_textStmt1234 = new BitSet(new long[]{0x0000000020080000L});
	public static final BitSet FOLLOW_29_in_textStmt1237 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_textStmt1241 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_textStmt1249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_pointList1274 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_pointList1276 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1280 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_pointList1288 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1292 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_pointList1294 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_pointList1298 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_term_in_expr1331 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_15_in_expr1341 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_term_in_expr1345 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_17_in_expr1355 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_term_in_expr1359 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_factor_in_term1387 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_14_in_term1397 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_factor_in_term1401 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_18_in_term1411 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_factor_in_term1415 = new BitSet(new long[]{0x0000000000044002L});
	public static final BitSet FOLLOW_INT_in_factor1443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_factor1453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_factor1461 = new BitSet(new long[]{0x0000000000001180L});
	public static final BitSet FOLLOW_expr_in_factor1465 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_factor1467 = new BitSet(new long[]{0x0000000000000002L});
}
