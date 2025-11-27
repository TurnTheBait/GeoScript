// $ANTLR 3.5.1 //GeoScript.g 2025-11-27 11:17:07
package myPackage;

import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;
import org.antlr.runtime.*;
import java.util.Stack;
import org.antlr.runtime.tree.*;

import myPackage.SemanticHandler.*;


@SuppressWarnings("all")
public class GeoScriptParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "COMMENTLINE", "HEX_COLOR", 
		"ID", "INT", "MOD", "STRING", "WS", "'!='", "'('", "')'", "'*'", "'+'", 
		"','", "'-'", "'/'", "';'", "'<'", "'='", "'=='", "'>'", "'AT'", "'CANVAS'", 
		"'CIRCLE'", "'COLOR'", "'DEF'", "'ELLIPSE'", "'ELSE'", "'FILL'", "'FOR'", 
		"'FROM'", "'IF'", "'LINE'", "'POINTS'", "'POLYGON'", "'RADII'", "'RADIUS'", 
		"'RECT'", "'ROTATE'", "'SCALE'", "'SIZE'", "'SQUARE'", "'STROKE'", "'TEXT'", 
		"'THEN'", "'TO'", "'TRANSLATE'", "'TRIANGLE'", "'VAR'", "'WHILE'", "'{'", 
		"'}'"
	};
	public static final int EOF=-1;
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
	public static final int COMMENT=4;
	public static final int COMMENTLINE=5;
	public static final int HEX_COLOR=6;
	public static final int ID=7;
	public static final int INT=8;
	public static final int MOD=9;
	public static final int STRING=10;
	public static final int WS=11;

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
	@Override public String getGrammarFileName() { return "//GeoScript.g"; }


	  // 1. Istanza dell'handler
	  public SemanticHandler sem = new SemanticHandler();
	  
	  // 2. Lista per raccogliere i comandi del programma
	  // (Definita qui in alto, non tra le regole!)
	  public List<Command> programList = new ArrayList<Command>();

	  // 3. Override gestione errori
	  @Override
	  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	    String hdr = "Line " + e.line + ":" + e.charPositionInLine;
	    String msg = getErrorMessage(e, tokenNames);
	    System.err.println("Syntax error " + hdr + ": " + msg);
	  }


	public static class prog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// //GeoScript.g:42:1: prog : (s= statement )* EOF ;
	public final GeoScriptParser.prog_return prog() throws RecognitionException {
		GeoScriptParser.prog_return retval = new GeoScriptParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF1=null;
		ParserRuleReturnScope s =null;

		Object EOF1_tree=null;

		try {
			// //GeoScript.g:44:3: ( (s= statement )* EOF )
			// //GeoScript.g:44:5: (s= statement )* EOF
			{
			root_0 = (Object)adaptor.nil();


			// //GeoScript.g:44:5: (s= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COMMENTLINE||LA1_0==ID||(LA1_0 >= 26 && LA1_0 <= 27)||(LA1_0 >= 29 && LA1_0 <= 30)||LA1_0==33||(LA1_0 >= 35 && LA1_0 <= 36)||LA1_0==38||(LA1_0 >= 41 && LA1_0 <= 43)||LA1_0==45||LA1_0==47||(LA1_0 >= 50 && LA1_0 <= 53)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// //GeoScript.g:44:6: s= statement
					{
					pushFollow(FOLLOW_statement_in_prog64);
					s=statement();
					state._fsp--;

					adaptor.addChild(root_0, s.getTree());

					 if ((s!=null?((GeoScriptParser.statement_return)s).cmd:null) != null) programList.add((s!=null?((GeoScriptParser.statement_return)s).cmd:null)); 
					}
					break;

				default :
					break loop1;
				}
			}

			EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_prog70); 
			EOF1_tree = (Object)adaptor.create(EOF1);
			adaptor.addChild(root_0, EOF1_tree);


			      // Esecuzione finale
			      for (Command c : programList) {
			        c.execute(sem);
			      }
			      sem.exportSVG("output.svg");
			    
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
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// //GeoScript.g:54:1: statement returns [Command cmd] : ( canvasStmt | colorDef | varDeclStmt | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE );
	public final GeoScriptParser.statement_return statement() throws RecognitionException {
		GeoScriptParser.statement_return retval = new GeoScriptParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMENTLINE11=null;
		ParserRuleReturnScope canvasStmt2 =null;
		ParserRuleReturnScope colorDef3 =null;
		ParserRuleReturnScope varDeclStmt4 =null;
		ParserRuleReturnScope assignStmt5 =null;
		ParserRuleReturnScope ifStmt6 =null;
		ParserRuleReturnScope whileStmt7 =null;
		ParserRuleReturnScope forStmt8 =null;
		ParserRuleReturnScope transformStmt9 =null;
		ParserRuleReturnScope shapeStmt10 =null;

		Object COMMENTLINE11_tree=null;

		try {
			// //GeoScript.g:55:3: ( canvasStmt | colorDef | varDeclStmt | assignStmt | ifStmt | whileStmt | forStmt | transformStmt | shapeStmt | COMMENTLINE )
			int alt2=10;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt2=1;
				}
				break;
			case 29:
				{
				alt2=2;
				}
				break;
			case 52:
				{
				alt2=3;
				}
				break;
			case ID:
				{
				alt2=4;
				}
				break;
			case 35:
				{
				alt2=5;
				}
				break;
			case 53:
				{
				alt2=6;
				}
				break;
			case 33:
				{
				alt2=7;
				}
				break;
			case 42:
			case 43:
			case 50:
				{
				alt2=8;
				}
				break;
			case 27:
			case 30:
			case 36:
			case 38:
			case 41:
			case 45:
			case 47:
			case 51:
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
					// //GeoScript.g:55:5: canvasStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_canvasStmt_in_statement93);
					canvasStmt2=canvasStmt();
					state._fsp--;

					adaptor.addChild(root_0, canvasStmt2.getTree());

					 retval.cmd = null; 
					}
					break;
				case 2 :
					// //GeoScript.g:56:5: colorDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_colorDef_in_statement107);
					colorDef3=colorDef();
					state._fsp--;

					adaptor.addChild(root_0, colorDef3.getTree());

					 retval.cmd = null; 
					}
					break;
				case 3 :
					// //GeoScript.g:57:5: varDeclStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_varDeclStmt_in_statement123);
					varDeclStmt4=varDeclStmt();
					state._fsp--;

					adaptor.addChild(root_0, varDeclStmt4.getTree());

					 retval.cmd = (varDeclStmt4!=null?((GeoScriptParser.varDeclStmt_return)varDeclStmt4).cmd:null); 
					}
					break;
				case 4 :
					// //GeoScript.g:58:5: assignStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignStmt_in_statement136);
					assignStmt5=assignStmt();
					state._fsp--;

					adaptor.addChild(root_0, assignStmt5.getTree());

					 retval.cmd = (assignStmt5!=null?((GeoScriptParser.assignStmt_return)assignStmt5).cmd:null); 
					}
					break;
				case 5 :
					// //GeoScript.g:59:5: ifStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifStmt_in_statement150);
					ifStmt6=ifStmt();
					state._fsp--;

					adaptor.addChild(root_0, ifStmt6.getTree());

					 retval.cmd = (ifStmt6!=null?((GeoScriptParser.ifStmt_return)ifStmt6).cmd:null); 
					}
					break;
				case 6 :
					// //GeoScript.g:60:5: whileStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whileStmt_in_statement168);
					whileStmt7=whileStmt();
					state._fsp--;

					adaptor.addChild(root_0, whileStmt7.getTree());

					 retval.cmd = (whileStmt7!=null?((GeoScriptParser.whileStmt_return)whileStmt7).cmd:null); 
					}
					break;
				case 7 :
					// //GeoScript.g:61:5: forStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_forStmt_in_statement183);
					forStmt8=forStmt();
					state._fsp--;

					adaptor.addChild(root_0, forStmt8.getTree());

					 retval.cmd = (forStmt8!=null?((GeoScriptParser.forStmt_return)forStmt8).cmd:null); 
					}
					break;
				case 8 :
					// //GeoScript.g:62:5: transformStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_transformStmt_in_statement200);
					transformStmt9=transformStmt();
					state._fsp--;

					adaptor.addChild(root_0, transformStmt9.getTree());

					 retval.cmd = null; 
					}
					break;
				case 9 :
					// //GeoScript.g:63:5: shapeStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_shapeStmt_in_statement211);
					shapeStmt10=shapeStmt();
					state._fsp--;

					adaptor.addChild(root_0, shapeStmt10.getTree());

					 retval.cmd = (shapeStmt10!=null?((GeoScriptParser.shapeStmt_return)shapeStmt10).cmd:null); 
					}
					break;
				case 10 :
					// //GeoScript.g:64:5: COMMENTLINE
					{
					root_0 = (Object)adaptor.nil();


					COMMENTLINE11=(Token)match(input,COMMENTLINE,FOLLOW_COMMENTLINE_in_statement226); 
					COMMENTLINE11_tree = (Object)adaptor.create(COMMENTLINE11);
					adaptor.addChild(root_0, COMMENTLINE11_tree);

					 retval.cmd = null; 
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
	// //GeoScript.g:67:1: canvasStmt : 'CANVAS' '(' w= INT ',' h= INT ')' ';' ;
	public final GeoScriptParser.canvasStmt_return canvasStmt() throws RecognitionException {
		GeoScriptParser.canvasStmt_return retval = new GeoScriptParser.canvasStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token w=null;
		Token h=null;
		Token string_literal12=null;
		Token char_literal13=null;
		Token char_literal14=null;
		Token char_literal15=null;
		Token char_literal16=null;

		Object w_tree=null;
		Object h_tree=null;
		Object string_literal12_tree=null;
		Object char_literal13_tree=null;
		Object char_literal14_tree=null;
		Object char_literal15_tree=null;
		Object char_literal16_tree=null;

		try {
			// //GeoScript.g:68:3: ( 'CANVAS' '(' w= INT ',' h= INT ')' ';' )
			// //GeoScript.g:68:5: 'CANVAS' '(' w= INT ',' h= INT ')' ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal12=(Token)match(input,26,FOLLOW_26_in_canvasStmt246); 
			string_literal12_tree = (Object)adaptor.create(string_literal12);
			adaptor.addChild(root_0, string_literal12_tree);

			char_literal13=(Token)match(input,13,FOLLOW_13_in_canvasStmt248); 
			char_literal13_tree = (Object)adaptor.create(char_literal13);
			adaptor.addChild(root_0, char_literal13_tree);

			w=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt252); 
			w_tree = (Object)adaptor.create(w);
			adaptor.addChild(root_0, w_tree);

			char_literal14=(Token)match(input,17,FOLLOW_17_in_canvasStmt254); 
			char_literal14_tree = (Object)adaptor.create(char_literal14);
			adaptor.addChild(root_0, char_literal14_tree);

			h=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt258); 
			h_tree = (Object)adaptor.create(h);
			adaptor.addChild(root_0, h_tree);

			char_literal15=(Token)match(input,14,FOLLOW_14_in_canvasStmt260); 
			char_literal15_tree = (Object)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);

			char_literal16=(Token)match(input,20,FOLLOW_20_in_canvasStmt262); 
			char_literal16_tree = (Object)adaptor.create(char_literal16);
			adaptor.addChild(root_0, char_literal16_tree);

			 sem.setCanvas(Integer.parseInt(w.getText()), Integer.parseInt(h.getText())); 
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


	public static class colorDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "colorDef"
	// //GeoScript.g:72:1: colorDef : 'DEF' id= ID '=' hex= HEX_COLOR ';' ;
	public final GeoScriptParser.colorDef_return colorDef() throws RecognitionException {
		GeoScriptParser.colorDef_return retval = new GeoScriptParser.colorDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token hex=null;
		Token string_literal17=null;
		Token char_literal18=null;
		Token char_literal19=null;

		Object id_tree=null;
		Object hex_tree=null;
		Object string_literal17_tree=null;
		Object char_literal18_tree=null;
		Object char_literal19_tree=null;

		try {
			// //GeoScript.g:73:3: ( 'DEF' id= ID '=' hex= HEX_COLOR ';' )
			// //GeoScript.g:73:5: 'DEF' id= ID '=' hex= HEX_COLOR ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal17=(Token)match(input,29,FOLLOW_29_in_colorDef281); 
			string_literal17_tree = (Object)adaptor.create(string_literal17);
			adaptor.addChild(root_0, string_literal17_tree);

			id=(Token)match(input,ID,FOLLOW_ID_in_colorDef285); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal18=(Token)match(input,22,FOLLOW_22_in_colorDef287); 
			char_literal18_tree = (Object)adaptor.create(char_literal18);
			adaptor.addChild(root_0, char_literal18_tree);

			hex=(Token)match(input,HEX_COLOR,FOLLOW_HEX_COLOR_in_colorDef291); 
			hex_tree = (Object)adaptor.create(hex);
			adaptor.addChild(root_0, hex_tree);

			char_literal19=(Token)match(input,20,FOLLOW_20_in_colorDef293); 
			char_literal19_tree = (Object)adaptor.create(char_literal19);
			adaptor.addChild(root_0, char_literal19_tree);

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


	public static class varDeclStmt_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "varDeclStmt"
	// //GeoScript.g:77:1: varDeclStmt returns [Command cmd] : 'VAR' id= ID '=' e= expr ';' ;
	public final GeoScriptParser.varDeclStmt_return varDeclStmt() throws RecognitionException {
		GeoScriptParser.varDeclStmt_return retval = new GeoScriptParser.varDeclStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token string_literal20=null;
		Token char_literal21=null;
		Token char_literal22=null;
		ParserRuleReturnScope e =null;

		Object id_tree=null;
		Object string_literal20_tree=null;
		Object char_literal21_tree=null;
		Object char_literal22_tree=null;

		try {
			// //GeoScript.g:78:3: ( 'VAR' id= ID '=' e= expr ';' )
			// //GeoScript.g:78:5: 'VAR' id= ID '=' e= expr ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal20=(Token)match(input,52,FOLLOW_52_in_varDeclStmt316); 
			string_literal20_tree = (Object)adaptor.create(string_literal20);
			adaptor.addChild(root_0, string_literal20_tree);

			id=(Token)match(input,ID,FOLLOW_ID_in_varDeclStmt320); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal21=(Token)match(input,22,FOLLOW_22_in_varDeclStmt322); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);

			pushFollow(FOLLOW_expr_in_varDeclStmt326);
			e=expr();
			state._fsp--;

			adaptor.addChild(root_0, e.getTree());

			char_literal22=(Token)match(input,20,FOLLOW_20_in_varDeclStmt328); 
			char_literal22_tree = (Object)adaptor.create(char_literal22);
			adaptor.addChild(root_0, char_literal22_tree);

			 retval.cmd = new VarDeclCommand(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).expr:null)); 
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
	// $ANTLR end "varDeclStmt"


	public static class assignStmt_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignStmt"
	// //GeoScript.g:82:1: assignStmt returns [Command cmd] : id= ID '=' e= expr ';' ;
	public final GeoScriptParser.assignStmt_return assignStmt() throws RecognitionException {
		GeoScriptParser.assignStmt_return retval = new GeoScriptParser.assignStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token char_literal23=null;
		Token char_literal24=null;
		ParserRuleReturnScope e =null;

		Object id_tree=null;
		Object char_literal23_tree=null;
		Object char_literal24_tree=null;

		try {
			// //GeoScript.g:83:3: (id= ID '=' e= expr ';' )
			// //GeoScript.g:83:5: id= ID '=' e= expr ';'
			{
			root_0 = (Object)adaptor.nil();


			id=(Token)match(input,ID,FOLLOW_ID_in_assignStmt353); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal23=(Token)match(input,22,FOLLOW_22_in_assignStmt355); 
			char_literal23_tree = (Object)adaptor.create(char_literal23);
			adaptor.addChild(root_0, char_literal23_tree);

			pushFollow(FOLLOW_expr_in_assignStmt359);
			e=expr();
			state._fsp--;

			adaptor.addChild(root_0, e.getTree());

			char_literal24=(Token)match(input,20,FOLLOW_20_in_assignStmt361); 
			char_literal24_tree = (Object)adaptor.create(char_literal24);
			adaptor.addChild(root_0, char_literal24_tree);

			 retval.cmd = new AssignCommand(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).expr:null)); 
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


	public static class ifStmt_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStmt"
	// //GeoScript.g:87:1: ifStmt returns [Command cmd] : 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )? ;
	public final GeoScriptParser.ifStmt_return ifStmt() throws RecognitionException {
		GeoScriptParser.ifStmt_return retval = new GeoScriptParser.ifStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal25=null;
		Token char_literal26=null;
		Token char_literal27=null;
		Token string_literal28=null;
		Token char_literal29=null;
		Token char_literal30=null;
		Token string_literal31=null;
		Token char_literal32=null;
		Token char_literal33=null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope s =null;
		ParserRuleReturnScope s2 =null;

		Object string_literal25_tree=null;
		Object char_literal26_tree=null;
		Object char_literal27_tree=null;
		Object string_literal28_tree=null;
		Object char_literal29_tree=null;
		Object char_literal30_tree=null;
		Object string_literal31_tree=null;
		Object char_literal32_tree=null;
		Object char_literal33_tree=null;


		  List<Command> thenList = new ArrayList<Command>();
		  List<Command> elseList = new ArrayList<Command>();

		try {
			// //GeoScript.g:92:3: ( 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )? )
			// //GeoScript.g:92:5: 'IF' '(' cond= expr ')' 'THEN' '{' (s= statement )* '}' ( 'ELSE' '{' (s2= statement )* '}' )?
			{
			root_0 = (Object)adaptor.nil();


			string_literal25=(Token)match(input,35,FOLLOW_35_in_ifStmt389); 
			string_literal25_tree = (Object)adaptor.create(string_literal25);
			adaptor.addChild(root_0, string_literal25_tree);

			char_literal26=(Token)match(input,13,FOLLOW_13_in_ifStmt391); 
			char_literal26_tree = (Object)adaptor.create(char_literal26);
			adaptor.addChild(root_0, char_literal26_tree);

			pushFollow(FOLLOW_expr_in_ifStmt395);
			cond=expr();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal27=(Token)match(input,14,FOLLOW_14_in_ifStmt397); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			string_literal28=(Token)match(input,48,FOLLOW_48_in_ifStmt399); 
			string_literal28_tree = (Object)adaptor.create(string_literal28);
			adaptor.addChild(root_0, string_literal28_tree);

			char_literal29=(Token)match(input,54,FOLLOW_54_in_ifStmt401); 
			char_literal29_tree = (Object)adaptor.create(char_literal29);
			adaptor.addChild(root_0, char_literal29_tree);

			// //GeoScript.g:93:8: (s= statement )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMENTLINE||LA3_0==ID||(LA3_0 >= 26 && LA3_0 <= 27)||(LA3_0 >= 29 && LA3_0 <= 30)||LA3_0==33||(LA3_0 >= 35 && LA3_0 <= 36)||LA3_0==38||(LA3_0 >= 41 && LA3_0 <= 43)||LA3_0==45||LA3_0==47||(LA3_0 >= 50 && LA3_0 <= 53)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// //GeoScript.g:93:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_ifStmt414);
					s=statement();
					state._fsp--;

					adaptor.addChild(root_0, s.getTree());

					 if ((s!=null?((GeoScriptParser.statement_return)s).cmd:null) != null) thenList.add((s!=null?((GeoScriptParser.statement_return)s).cmd:null)); 
					}
					break;

				default :
					break loop3;
				}
			}

			char_literal30=(Token)match(input,55,FOLLOW_55_in_ifStmt420); 
			char_literal30_tree = (Object)adaptor.create(char_literal30);
			adaptor.addChild(root_0, char_literal30_tree);

			// //GeoScript.g:94:5: ( 'ELSE' '{' (s2= statement )* '}' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==31) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// //GeoScript.g:94:7: 'ELSE' '{' (s2= statement )* '}'
					{
					string_literal31=(Token)match(input,31,FOLLOW_31_in_ifStmt429); 
					string_literal31_tree = (Object)adaptor.create(string_literal31);
					adaptor.addChild(root_0, string_literal31_tree);

					char_literal32=(Token)match(input,54,FOLLOW_54_in_ifStmt431); 
					char_literal32_tree = (Object)adaptor.create(char_literal32);
					adaptor.addChild(root_0, char_literal32_tree);

					// //GeoScript.g:95:8: (s2= statement )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMENTLINE||LA4_0==ID||(LA4_0 >= 26 && LA4_0 <= 27)||(LA4_0 >= 29 && LA4_0 <= 30)||LA4_0==33||(LA4_0 >= 35 && LA4_0 <= 36)||LA4_0==38||(LA4_0 >= 41 && LA4_0 <= 43)||LA4_0==45||LA4_0==47||(LA4_0 >= 50 && LA4_0 <= 53)) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// //GeoScript.g:95:9: s2= statement
							{
							pushFollow(FOLLOW_statement_in_ifStmt444);
							s2=statement();
							state._fsp--;

							adaptor.addChild(root_0, s2.getTree());

							 if ((s2!=null?((GeoScriptParser.statement_return)s2).cmd:null) != null) elseList.add((s2!=null?((GeoScriptParser.statement_return)s2).cmd:null)); 
							}
							break;

						default :
							break loop4;
						}
					}

					char_literal33=(Token)match(input,55,FOLLOW_55_in_ifStmt450); 
					char_literal33_tree = (Object)adaptor.create(char_literal33);
					adaptor.addChild(root_0, char_literal33_tree);

					}
					break;

			}


			      retval.cmd = new IfCommand((cond!=null?((GeoScriptParser.expr_return)cond).expr:null), thenList, elseList.isEmpty() ? null : elseList);
			    
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


	public static class whileStmt_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whileStmt"
	// //GeoScript.g:101:1: whileStmt returns [Command cmd] : 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}' ;
	public final GeoScriptParser.whileStmt_return whileStmt() throws RecognitionException {
		GeoScriptParser.whileStmt_return retval = new GeoScriptParser.whileStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal34=null;
		Token char_literal35=null;
		Token char_literal36=null;
		Token char_literal37=null;
		Token char_literal38=null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope s =null;

		Object string_literal34_tree=null;
		Object char_literal35_tree=null;
		Object char_literal36_tree=null;
		Object char_literal37_tree=null;
		Object char_literal38_tree=null;


		  List<Command> loopBody = new ArrayList<Command>();

		try {
			// //GeoScript.g:105:3: ( 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}' )
			// //GeoScript.g:105:5: 'WHILE' '(' cond= expr ')' '{' (s= statement )* '}'
			{
			root_0 = (Object)adaptor.nil();


			string_literal34=(Token)match(input,53,FOLLOW_53_in_whileStmt481); 
			string_literal34_tree = (Object)adaptor.create(string_literal34);
			adaptor.addChild(root_0, string_literal34_tree);

			char_literal35=(Token)match(input,13,FOLLOW_13_in_whileStmt483); 
			char_literal35_tree = (Object)adaptor.create(char_literal35);
			adaptor.addChild(root_0, char_literal35_tree);

			pushFollow(FOLLOW_expr_in_whileStmt487);
			cond=expr();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal36=(Token)match(input,14,FOLLOW_14_in_whileStmt489); 
			char_literal36_tree = (Object)adaptor.create(char_literal36);
			adaptor.addChild(root_0, char_literal36_tree);

			char_literal37=(Token)match(input,54,FOLLOW_54_in_whileStmt491); 
			char_literal37_tree = (Object)adaptor.create(char_literal37);
			adaptor.addChild(root_0, char_literal37_tree);

			// //GeoScript.g:106:8: (s= statement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMENTLINE||LA6_0==ID||(LA6_0 >= 26 && LA6_0 <= 27)||(LA6_0 >= 29 && LA6_0 <= 30)||LA6_0==33||(LA6_0 >= 35 && LA6_0 <= 36)||LA6_0==38||(LA6_0 >= 41 && LA6_0 <= 43)||LA6_0==45||LA6_0==47||(LA6_0 >= 50 && LA6_0 <= 53)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// //GeoScript.g:106:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_whileStmt504);
					s=statement();
					state._fsp--;

					adaptor.addChild(root_0, s.getTree());

					 if ((s!=null?((GeoScriptParser.statement_return)s).cmd:null) != null) loopBody.add((s!=null?((GeoScriptParser.statement_return)s).cmd:null)); 
					}
					break;

				default :
					break loop6;
				}
			}

			char_literal38=(Token)match(input,55,FOLLOW_55_in_whileStmt510); 
			char_literal38_tree = (Object)adaptor.create(char_literal38);
			adaptor.addChild(root_0, char_literal38_tree);


			      retval.cmd = new WhileCommand((cond!=null?((GeoScriptParser.expr_return)cond).expr:null), loopBody);
			    
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
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "forStmt"
	// //GeoScript.g:112:1: forStmt returns [Command cmd] : 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}' ;
	public final GeoScriptParser.forStmt_return forStmt() throws RecognitionException {
		GeoScriptParser.forStmt_return retval = new GeoScriptParser.forStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal39=null;
		Token char_literal40=null;
		Token char_literal41=null;
		Token char_literal42=null;
		Token char_literal43=null;
		Token char_literal44=null;
		Token char_literal45=null;
		ParserRuleReturnScope init =null;
		ParserRuleReturnScope cond =null;
		ParserRuleReturnScope incr =null;
		ParserRuleReturnScope s =null;

		Object string_literal39_tree=null;
		Object char_literal40_tree=null;
		Object char_literal41_tree=null;
		Object char_literal42_tree=null;
		Object char_literal43_tree=null;
		Object char_literal44_tree=null;
		Object char_literal45_tree=null;


		  List<Command> loopBody = new ArrayList<Command>();

		try {
			// //GeoScript.g:116:3: ( 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}' )
			// //GeoScript.g:116:5: 'FOR' '(' init= forInitHeader ';' cond= expr ';' incr= forIncrHeader ')' '{' (s= statement )* '}'
			{
			root_0 = (Object)adaptor.nil();


			string_literal39=(Token)match(input,33,FOLLOW_33_in_forStmt538); 
			string_literal39_tree = (Object)adaptor.create(string_literal39);
			adaptor.addChild(root_0, string_literal39_tree);

			char_literal40=(Token)match(input,13,FOLLOW_13_in_forStmt540); 
			char_literal40_tree = (Object)adaptor.create(char_literal40);
			adaptor.addChild(root_0, char_literal40_tree);

			pushFollow(FOLLOW_forInitHeader_in_forStmt551);
			init=forInitHeader();
			state._fsp--;

			adaptor.addChild(root_0, init.getTree());

			char_literal41=(Token)match(input,20,FOLLOW_20_in_forStmt553); 
			char_literal41_tree = (Object)adaptor.create(char_literal41);
			adaptor.addChild(root_0, char_literal41_tree);

			pushFollow(FOLLOW_expr_in_forStmt564);
			cond=expr();
			state._fsp--;

			adaptor.addChild(root_0, cond.getTree());

			char_literal42=(Token)match(input,20,FOLLOW_20_in_forStmt566); 
			char_literal42_tree = (Object)adaptor.create(char_literal42);
			adaptor.addChild(root_0, char_literal42_tree);

			pushFollow(FOLLOW_forIncrHeader_in_forStmt577);
			incr=forIncrHeader();
			state._fsp--;

			adaptor.addChild(root_0, incr.getTree());

			char_literal43=(Token)match(input,14,FOLLOW_14_in_forStmt584); 
			char_literal43_tree = (Object)adaptor.create(char_literal43);
			adaptor.addChild(root_0, char_literal43_tree);

			char_literal44=(Token)match(input,54,FOLLOW_54_in_forStmt586); 
			char_literal44_tree = (Object)adaptor.create(char_literal44);
			adaptor.addChild(root_0, char_literal44_tree);

			// //GeoScript.g:121:8: (s= statement )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMENTLINE||LA7_0==ID||(LA7_0 >= 26 && LA7_0 <= 27)||(LA7_0 >= 29 && LA7_0 <= 30)||LA7_0==33||(LA7_0 >= 35 && LA7_0 <= 36)||LA7_0==38||(LA7_0 >= 41 && LA7_0 <= 43)||LA7_0==45||LA7_0==47||(LA7_0 >= 50 && LA7_0 <= 53)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// //GeoScript.g:121:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_forStmt599);
					s=statement();
					state._fsp--;

					adaptor.addChild(root_0, s.getTree());

					 if ((s!=null?((GeoScriptParser.statement_return)s).cmd:null) != null) loopBody.add((s!=null?((GeoScriptParser.statement_return)s).cmd:null)); 
					}
					break;

				default :
					break loop7;
				}
			}

			char_literal45=(Token)match(input,55,FOLLOW_55_in_forStmt605); 
			char_literal45_tree = (Object)adaptor.create(char_literal45);
			adaptor.addChild(root_0, char_literal45_tree);


			      retval.cmd = new ForCommand((init!=null?((GeoScriptParser.forInitHeader_return)init).cmd:null), (cond!=null?((GeoScriptParser.expr_return)cond).expr:null), (incr!=null?((GeoScriptParser.forIncrHeader_return)incr).cmd:null), loopBody);
			    
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


	public static class forInitHeader_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "forInitHeader"
	// //GeoScript.g:127:1: forInitHeader returns [Command cmd] : ( 'VAR' id= ID '=' e= expr |c= assignSimple |);
	public final GeoScriptParser.forInitHeader_return forInitHeader() throws RecognitionException {
		GeoScriptParser.forInitHeader_return retval = new GeoScriptParser.forInitHeader_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token string_literal46=null;
		Token char_literal47=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope c =null;

		Object id_tree=null;
		Object string_literal46_tree=null;
		Object char_literal47_tree=null;

		try {
			// //GeoScript.g:128:3: ( 'VAR' id= ID '=' e= expr |c= assignSimple |)
			int alt8=3;
			switch ( input.LA(1) ) {
			case 52:
				{
				alt8=1;
				}
				break;
			case ID:
				{
				alt8=2;
				}
				break;
			case 20:
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
					// //GeoScript.g:128:5: 'VAR' id= ID '=' e= expr
					{
					root_0 = (Object)adaptor.nil();


					string_literal46=(Token)match(input,52,FOLLOW_52_in_forInitHeader628); 
					string_literal46_tree = (Object)adaptor.create(string_literal46);
					adaptor.addChild(root_0, string_literal46_tree);

					id=(Token)match(input,ID,FOLLOW_ID_in_forInitHeader632); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);

					char_literal47=(Token)match(input,22,FOLLOW_22_in_forInitHeader634); 
					char_literal47_tree = (Object)adaptor.create(char_literal47);
					adaptor.addChild(root_0, char_literal47_tree);

					pushFollow(FOLLOW_expr_in_forInitHeader638);
					e=expr();
					state._fsp--;

					adaptor.addChild(root_0, e.getTree());

					 retval.cmd = new VarDeclCommand(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).expr:null)); 
					}
					break;
				case 2 :
					// //GeoScript.g:129:5: c= assignSimple
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignSimple_in_forInitHeader648);
					c=assignSimple();
					state._fsp--;

					adaptor.addChild(root_0, c.getTree());

					 retval.cmd = (c!=null?((GeoScriptParser.assignSimple_return)c).cmd:null); 
					}
					break;
				case 3 :
					// //GeoScript.g:130:5: 
					{
					root_0 = (Object)adaptor.nil();


					 retval.cmd = null; 
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
	// $ANTLR end "forInitHeader"


	public static class forIncrHeader_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "forIncrHeader"
	// //GeoScript.g:133:1: forIncrHeader returns [Command cmd] : (c= assignSimple |);
	public final GeoScriptParser.forIncrHeader_return forIncrHeader() throws RecognitionException {
		GeoScriptParser.forIncrHeader_return retval = new GeoScriptParser.forIncrHeader_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope c =null;


		try {
			// //GeoScript.g:134:3: (c= assignSimple |)
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==14) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// //GeoScript.g:134:5: c= assignSimple
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignSimple_in_forIncrHeader675);
					c=assignSimple();
					state._fsp--;

					adaptor.addChild(root_0, c.getTree());

					 retval.cmd = (c!=null?((GeoScriptParser.assignSimple_return)c).cmd:null); 
					}
					break;
				case 2 :
					// //GeoScript.g:135:5: 
					{
					root_0 = (Object)adaptor.nil();


					 retval.cmd = null; 
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
	// $ANTLR end "forIncrHeader"


	public static class transformStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "transformStmt"
	// //GeoScript.g:138:1: transformStmt : ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' );
	public final GeoScriptParser.transformStmt_return transformStmt() throws RecognitionException {
		GeoScriptParser.transformStmt_return retval = new GeoScriptParser.transformStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token a=null;
		Token string_literal48=null;
		Token char_literal49=null;
		Token string_literal50=null;
		Token char_literal51=null;
		Token char_literal52=null;
		Token char_literal53=null;
		Token char_literal54=null;
		Token string_literal55=null;
		Token char_literal56=null;
		Token char_literal57=null;
		Token char_literal58=null;
		Token char_literal59=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope sx =null;
		ParserRuleReturnScope sy =null;

		Object a_tree=null;
		Object string_literal48_tree=null;
		Object char_literal49_tree=null;
		Object string_literal50_tree=null;
		Object char_literal51_tree=null;
		Object char_literal52_tree=null;
		Object char_literal53_tree=null;
		Object char_literal54_tree=null;
		Object string_literal55_tree=null;
		Object char_literal56_tree=null;
		Object char_literal57_tree=null;
		Object char_literal58_tree=null;
		Object char_literal59_tree=null;

		try {
			// //GeoScript.g:139:3: ( 'ROTATE' a= INT ';' | 'TRANSLATE' '(' x= expr ',' y= expr ')' ';' | 'SCALE' '(' sx= expr ',' sy= expr ')' ';' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case 42:
				{
				alt10=1;
				}
				break;
			case 50:
				{
				alt10=2;
				}
				break;
			case 43:
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
					// //GeoScript.g:139:5: 'ROTATE' a= INT ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal48=(Token)match(input,42,FOLLOW_42_in_transformStmt696); 
					string_literal48_tree = (Object)adaptor.create(string_literal48);
					adaptor.addChild(root_0, string_literal48_tree);

					a=(Token)match(input,INT,FOLLOW_INT_in_transformStmt700); 
					a_tree = (Object)adaptor.create(a);
					adaptor.addChild(root_0, a_tree);

					char_literal49=(Token)match(input,20,FOLLOW_20_in_transformStmt702); 
					char_literal49_tree = (Object)adaptor.create(char_literal49);
					adaptor.addChild(root_0, char_literal49_tree);

					}
					break;
				case 2 :
					// //GeoScript.g:140:5: 'TRANSLATE' '(' x= expr ',' y= expr ')' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal50=(Token)match(input,50,FOLLOW_50_in_transformStmt708); 
					string_literal50_tree = (Object)adaptor.create(string_literal50);
					adaptor.addChild(root_0, string_literal50_tree);

					char_literal51=(Token)match(input,13,FOLLOW_13_in_transformStmt710); 
					char_literal51_tree = (Object)adaptor.create(char_literal51);
					adaptor.addChild(root_0, char_literal51_tree);

					pushFollow(FOLLOW_expr_in_transformStmt714);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal52=(Token)match(input,17,FOLLOW_17_in_transformStmt716); 
					char_literal52_tree = (Object)adaptor.create(char_literal52);
					adaptor.addChild(root_0, char_literal52_tree);

					pushFollow(FOLLOW_expr_in_transformStmt720);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal53=(Token)match(input,14,FOLLOW_14_in_transformStmt722); 
					char_literal53_tree = (Object)adaptor.create(char_literal53);
					adaptor.addChild(root_0, char_literal53_tree);

					char_literal54=(Token)match(input,20,FOLLOW_20_in_transformStmt724); 
					char_literal54_tree = (Object)adaptor.create(char_literal54);
					adaptor.addChild(root_0, char_literal54_tree);

					}
					break;
				case 3 :
					// //GeoScript.g:141:5: 'SCALE' '(' sx= expr ',' sy= expr ')' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal55=(Token)match(input,43,FOLLOW_43_in_transformStmt730); 
					string_literal55_tree = (Object)adaptor.create(string_literal55);
					adaptor.addChild(root_0, string_literal55_tree);

					char_literal56=(Token)match(input,13,FOLLOW_13_in_transformStmt732); 
					char_literal56_tree = (Object)adaptor.create(char_literal56);
					adaptor.addChild(root_0, char_literal56_tree);

					pushFollow(FOLLOW_expr_in_transformStmt736);
					sx=expr();
					state._fsp--;

					adaptor.addChild(root_0, sx.getTree());

					char_literal57=(Token)match(input,17,FOLLOW_17_in_transformStmt738); 
					char_literal57_tree = (Object)adaptor.create(char_literal57);
					adaptor.addChild(root_0, char_literal57_tree);

					pushFollow(FOLLOW_expr_in_transformStmt742);
					sy=expr();
					state._fsp--;

					adaptor.addChild(root_0, sy.getTree());

					char_literal58=(Token)match(input,14,FOLLOW_14_in_transformStmt744); 
					char_literal58_tree = (Object)adaptor.create(char_literal58);
					adaptor.addChild(root_0, char_literal58_tree);

					char_literal59=(Token)match(input,20,FOLLOW_20_in_transformStmt746); 
					char_literal59_tree = (Object)adaptor.create(char_literal59);
					adaptor.addChild(root_0, char_literal59_tree);

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
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "shapeStmt"
	// //GeoScript.g:144:1: shapeStmt returns [Command cmd] : ( 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';' | 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' );
	public final GeoScriptParser.shapeStmt_return shapeStmt() throws RecognitionException {
		GeoScriptParser.shapeStmt_return retval = new GeoScriptParser.shapeStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token f=null;
		Token st=null;
		Token str=null;
		Token c=null;
		Token string_literal60=null;
		Token string_literal61=null;
		Token char_literal62=null;
		Token char_literal63=null;
		Token char_literal64=null;
		Token string_literal65=null;
		Token char_literal66=null;
		Token char_literal67=null;
		Token char_literal68=null;
		Token string_literal69=null;
		Token string_literal70=null;
		Token char_literal71=null;
		Token string_literal72=null;
		Token string_literal73=null;
		Token char_literal74=null;
		Token char_literal75=null;
		Token char_literal76=null;
		Token string_literal77=null;
		Token string_literal78=null;
		Token string_literal79=null;
		Token char_literal80=null;
		Token string_literal81=null;
		Token string_literal82=null;
		Token char_literal83=null;
		Token char_literal84=null;
		Token char_literal85=null;
		Token string_literal86=null;
		Token char_literal87=null;
		Token char_literal88=null;
		Token char_literal89=null;
		Token string_literal90=null;
		Token char_literal91=null;
		Token string_literal92=null;
		Token string_literal93=null;
		Token char_literal94=null;
		Token char_literal95=null;
		Token char_literal96=null;
		Token string_literal97=null;
		Token string_literal98=null;
		Token string_literal99=null;
		Token char_literal100=null;
		Token string_literal101=null;
		Token string_literal102=null;
		Token char_literal103=null;
		Token char_literal104=null;
		Token char_literal105=null;
		Token string_literal106=null;
		Token char_literal107=null;
		Token char_literal108=null;
		Token char_literal109=null;
		Token char_literal110=null;
		Token char_literal111=null;
		Token char_literal112=null;
		Token char_literal113=null;
		Token string_literal114=null;
		Token string_literal115=null;
		Token char_literal116=null;
		Token string_literal117=null;
		Token string_literal118=null;
		Token char_literal119=null;
		Token char_literal120=null;
		Token char_literal121=null;
		Token string_literal122=null;
		Token char_literal123=null;
		Token char_literal124=null;
		Token char_literal125=null;
		Token string_literal126=null;
		Token string_literal127=null;
		Token char_literal128=null;
		Token string_literal129=null;
		Token string_literal130=null;
		Token char_literal131=null;
		Token char_literal132=null;
		Token string_literal133=null;
		Token string_literal134=null;
		Token char_literal135=null;
		Token string_literal136=null;
		Token char_literal137=null;
		Token char_literal138=null;
		Token char_literal139=null;
		Token char_literal140=null;
		Token string_literal141=null;
		Token char_literal142=null;
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;
		ParserRuleReturnScope w =null;
		ParserRuleReturnScope h =null;
		ParserRuleReturnScope r =null;
		ParserRuleReturnScope x1 =null;
		ParserRuleReturnScope y1 =null;
		ParserRuleReturnScope x2 =null;
		ParserRuleReturnScope y2 =null;
		ParserRuleReturnScope sz =null;
		ParserRuleReturnScope p1x =null;
		ParserRuleReturnScope p1y =null;
		ParserRuleReturnScope p2x =null;
		ParserRuleReturnScope p2y =null;
		ParserRuleReturnScope p3x =null;
		ParserRuleReturnScope p3y =null;
		ParserRuleReturnScope rx =null;
		ParserRuleReturnScope ry =null;
		ParserRuleReturnScope pts =null;

		Object f_tree=null;
		Object st_tree=null;
		Object str_tree=null;
		Object c_tree=null;
		Object string_literal60_tree=null;
		Object string_literal61_tree=null;
		Object char_literal62_tree=null;
		Object char_literal63_tree=null;
		Object char_literal64_tree=null;
		Object string_literal65_tree=null;
		Object char_literal66_tree=null;
		Object char_literal67_tree=null;
		Object char_literal68_tree=null;
		Object string_literal69_tree=null;
		Object string_literal70_tree=null;
		Object char_literal71_tree=null;
		Object string_literal72_tree=null;
		Object string_literal73_tree=null;
		Object char_literal74_tree=null;
		Object char_literal75_tree=null;
		Object char_literal76_tree=null;
		Object string_literal77_tree=null;
		Object string_literal78_tree=null;
		Object string_literal79_tree=null;
		Object char_literal80_tree=null;
		Object string_literal81_tree=null;
		Object string_literal82_tree=null;
		Object char_literal83_tree=null;
		Object char_literal84_tree=null;
		Object char_literal85_tree=null;
		Object string_literal86_tree=null;
		Object char_literal87_tree=null;
		Object char_literal88_tree=null;
		Object char_literal89_tree=null;
		Object string_literal90_tree=null;
		Object char_literal91_tree=null;
		Object string_literal92_tree=null;
		Object string_literal93_tree=null;
		Object char_literal94_tree=null;
		Object char_literal95_tree=null;
		Object char_literal96_tree=null;
		Object string_literal97_tree=null;
		Object string_literal98_tree=null;
		Object string_literal99_tree=null;
		Object char_literal100_tree=null;
		Object string_literal101_tree=null;
		Object string_literal102_tree=null;
		Object char_literal103_tree=null;
		Object char_literal104_tree=null;
		Object char_literal105_tree=null;
		Object string_literal106_tree=null;
		Object char_literal107_tree=null;
		Object char_literal108_tree=null;
		Object char_literal109_tree=null;
		Object char_literal110_tree=null;
		Object char_literal111_tree=null;
		Object char_literal112_tree=null;
		Object char_literal113_tree=null;
		Object string_literal114_tree=null;
		Object string_literal115_tree=null;
		Object char_literal116_tree=null;
		Object string_literal117_tree=null;
		Object string_literal118_tree=null;
		Object char_literal119_tree=null;
		Object char_literal120_tree=null;
		Object char_literal121_tree=null;
		Object string_literal122_tree=null;
		Object char_literal123_tree=null;
		Object char_literal124_tree=null;
		Object char_literal125_tree=null;
		Object string_literal126_tree=null;
		Object string_literal127_tree=null;
		Object char_literal128_tree=null;
		Object string_literal129_tree=null;
		Object string_literal130_tree=null;
		Object char_literal131_tree=null;
		Object char_literal132_tree=null;
		Object string_literal133_tree=null;
		Object string_literal134_tree=null;
		Object char_literal135_tree=null;
		Object string_literal136_tree=null;
		Object char_literal137_tree=null;
		Object char_literal138_tree=null;
		Object char_literal139_tree=null;
		Object char_literal140_tree=null;
		Object string_literal141_tree=null;
		Object char_literal142_tree=null;

		try {
			// //GeoScript.g:145:3: ( 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';' | 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';' | 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';' )
			int alt24=8;
			switch ( input.LA(1) ) {
			case 41:
				{
				alt24=1;
				}
				break;
			case 27:
				{
				alt24=2;
				}
				break;
			case 36:
				{
				alt24=3;
				}
				break;
			case 45:
				{
				alt24=4;
				}
				break;
			case 51:
				{
				alt24=5;
				}
				break;
			case 30:
				{
				alt24=6;
				}
				break;
			case 38:
				{
				alt24=7;
				}
				break;
			case 47:
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
					// //GeoScript.g:145:5: 'RECT' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' '(' w= expr ',' h= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal60=(Token)match(input,41,FOLLOW_41_in_shapeStmt763); 
					string_literal60_tree = (Object)adaptor.create(string_literal60);
					adaptor.addChild(root_0, string_literal60_tree);

					string_literal61=(Token)match(input,25,FOLLOW_25_in_shapeStmt765); 
					string_literal61_tree = (Object)adaptor.create(string_literal61);
					adaptor.addChild(root_0, string_literal61_tree);

					char_literal62=(Token)match(input,13,FOLLOW_13_in_shapeStmt767); 
					char_literal62_tree = (Object)adaptor.create(char_literal62);
					adaptor.addChild(root_0, char_literal62_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt771);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal63=(Token)match(input,17,FOLLOW_17_in_shapeStmt773); 
					char_literal63_tree = (Object)adaptor.create(char_literal63);
					adaptor.addChild(root_0, char_literal63_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt777);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal64=(Token)match(input,14,FOLLOW_14_in_shapeStmt779); 
					char_literal64_tree = (Object)adaptor.create(char_literal64);
					adaptor.addChild(root_0, char_literal64_tree);

					string_literal65=(Token)match(input,44,FOLLOW_44_in_shapeStmt781); 
					string_literal65_tree = (Object)adaptor.create(string_literal65);
					adaptor.addChild(root_0, string_literal65_tree);

					char_literal66=(Token)match(input,13,FOLLOW_13_in_shapeStmt783); 
					char_literal66_tree = (Object)adaptor.create(char_literal66);
					adaptor.addChild(root_0, char_literal66_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt787);
					w=expr();
					state._fsp--;

					adaptor.addChild(root_0, w.getTree());

					char_literal67=(Token)match(input,17,FOLLOW_17_in_shapeStmt789); 
					char_literal67_tree = (Object)adaptor.create(char_literal67);
					adaptor.addChild(root_0, char_literal67_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt793);
					h=expr();
					state._fsp--;

					adaptor.addChild(root_0, h.getTree());

					char_literal68=(Token)match(input,14,FOLLOW_14_in_shapeStmt795); 
					char_literal68_tree = (Object)adaptor.create(char_literal68);
					adaptor.addChild(root_0, char_literal68_tree);

					// //GeoScript.g:145:76: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==32) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// //GeoScript.g:145:78: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal69=(Token)match(input,32,FOLLOW_32_in_shapeStmt799); 
							string_literal69_tree = (Object)adaptor.create(string_literal69);
							adaptor.addChild(root_0, string_literal69_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:145:105: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==46) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// //GeoScript.g:145:107: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal70=(Token)match(input,46,FOLLOW_46_in_shapeStmt814); 
							string_literal70_tree = (Object)adaptor.create(string_literal70);
							adaptor.addChild(root_0, string_literal70_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal71=(Token)match(input,20,FOLLOW_20_in_shapeStmt827); 
					char_literal71_tree = (Object)adaptor.create(char_literal71);
					adaptor.addChild(root_0, char_literal71_tree);


					      Expr[] ex = new Expr[]{ (x!=null?((GeoScriptParser.expr_return)x).expr:null), (y!=null?((GeoScriptParser.expr_return)y).expr:null), (w!=null?((GeoScriptParser.expr_return)w).expr:null), (h!=null?((GeoScriptParser.expr_return)h).expr:null) };
					      retval.cmd = new ShapeCommand("RECT", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 2 :
					// //GeoScript.g:150:5: 'CIRCLE' 'AT' '(' x= expr ',' y= expr ')' 'RADIUS' r= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal72=(Token)match(input,27,FOLLOW_27_in_shapeStmt839); 
					string_literal72_tree = (Object)adaptor.create(string_literal72);
					adaptor.addChild(root_0, string_literal72_tree);

					string_literal73=(Token)match(input,25,FOLLOW_25_in_shapeStmt841); 
					string_literal73_tree = (Object)adaptor.create(string_literal73);
					adaptor.addChild(root_0, string_literal73_tree);

					char_literal74=(Token)match(input,13,FOLLOW_13_in_shapeStmt843); 
					char_literal74_tree = (Object)adaptor.create(char_literal74);
					adaptor.addChild(root_0, char_literal74_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt847);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal75=(Token)match(input,17,FOLLOW_17_in_shapeStmt849); 
					char_literal75_tree = (Object)adaptor.create(char_literal75);
					adaptor.addChild(root_0, char_literal75_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt853);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal76=(Token)match(input,14,FOLLOW_14_in_shapeStmt855); 
					char_literal76_tree = (Object)adaptor.create(char_literal76);
					adaptor.addChild(root_0, char_literal76_tree);

					string_literal77=(Token)match(input,40,FOLLOW_40_in_shapeStmt857); 
					string_literal77_tree = (Object)adaptor.create(string_literal77);
					adaptor.addChild(root_0, string_literal77_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt861);
					r=expr();
					state._fsp--;

					adaptor.addChild(root_0, r.getTree());

					// //GeoScript.g:150:61: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==32) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// //GeoScript.g:150:63: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal78=(Token)match(input,32,FOLLOW_32_in_shapeStmt865); 
							string_literal78_tree = (Object)adaptor.create(string_literal78);
							adaptor.addChild(root_0, string_literal78_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:150:90: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==46) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// //GeoScript.g:150:92: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal79=(Token)match(input,46,FOLLOW_46_in_shapeStmt880); 
							string_literal79_tree = (Object)adaptor.create(string_literal79);
							adaptor.addChild(root_0, string_literal79_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal80=(Token)match(input,20,FOLLOW_20_in_shapeStmt893); 
					char_literal80_tree = (Object)adaptor.create(char_literal80);
					adaptor.addChild(root_0, char_literal80_tree);


					      Expr[] ex = new Expr[]{ (x!=null?((GeoScriptParser.expr_return)x).expr:null), (y!=null?((GeoScriptParser.expr_return)y).expr:null), (r!=null?((GeoScriptParser.expr_return)r).expr:null) };
					      retval.cmd = new ShapeCommand("CIRCLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 3 :
					// //GeoScript.g:155:5: 'LINE' 'FROM' '(' x1= expr ',' y1= expr ')' 'TO' '(' x2= expr ',' y2= expr ')' 'STROKE' st= ( ID | HEX_COLOR ) ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal81=(Token)match(input,36,FOLLOW_36_in_shapeStmt905); 
					string_literal81_tree = (Object)adaptor.create(string_literal81);
					adaptor.addChild(root_0, string_literal81_tree);

					string_literal82=(Token)match(input,34,FOLLOW_34_in_shapeStmt907); 
					string_literal82_tree = (Object)adaptor.create(string_literal82);
					adaptor.addChild(root_0, string_literal82_tree);

					char_literal83=(Token)match(input,13,FOLLOW_13_in_shapeStmt909); 
					char_literal83_tree = (Object)adaptor.create(char_literal83);
					adaptor.addChild(root_0, char_literal83_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt913);
					x1=expr();
					state._fsp--;

					adaptor.addChild(root_0, x1.getTree());

					char_literal84=(Token)match(input,17,FOLLOW_17_in_shapeStmt915); 
					char_literal84_tree = (Object)adaptor.create(char_literal84);
					adaptor.addChild(root_0, char_literal84_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt919);
					y1=expr();
					state._fsp--;

					adaptor.addChild(root_0, y1.getTree());

					char_literal85=(Token)match(input,14,FOLLOW_14_in_shapeStmt921); 
					char_literal85_tree = (Object)adaptor.create(char_literal85);
					adaptor.addChild(root_0, char_literal85_tree);

					string_literal86=(Token)match(input,49,FOLLOW_49_in_shapeStmt923); 
					string_literal86_tree = (Object)adaptor.create(string_literal86);
					adaptor.addChild(root_0, string_literal86_tree);

					char_literal87=(Token)match(input,13,FOLLOW_13_in_shapeStmt925); 
					char_literal87_tree = (Object)adaptor.create(char_literal87);
					adaptor.addChild(root_0, char_literal87_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt929);
					x2=expr();
					state._fsp--;

					adaptor.addChild(root_0, x2.getTree());

					char_literal88=(Token)match(input,17,FOLLOW_17_in_shapeStmt931); 
					char_literal88_tree = (Object)adaptor.create(char_literal88);
					adaptor.addChild(root_0, char_literal88_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt935);
					y2=expr();
					state._fsp--;

					adaptor.addChild(root_0, y2.getTree());

					char_literal89=(Token)match(input,14,FOLLOW_14_in_shapeStmt937); 
					char_literal89_tree = (Object)adaptor.create(char_literal89);
					adaptor.addChild(root_0, char_literal89_tree);

					string_literal90=(Token)match(input,46,FOLLOW_46_in_shapeStmt939); 
					string_literal90_tree = (Object)adaptor.create(string_literal90);
					adaptor.addChild(root_0, string_literal90_tree);

					st=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(st));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					char_literal91=(Token)match(input,20,FOLLOW_20_in_shapeStmt949); 
					char_literal91_tree = (Object)adaptor.create(char_literal91);
					adaptor.addChild(root_0, char_literal91_tree);


					      Expr[] ex = new Expr[]{ (x1!=null?((GeoScriptParser.expr_return)x1).expr:null), (y1!=null?((GeoScriptParser.expr_return)y1).expr:null), (x2!=null?((GeoScriptParser.expr_return)x2).expr:null), (y2!=null?((GeoScriptParser.expr_return)y2).expr:null) };
					      retval.cmd = new ShapeCommand("LINE", ex, null, null, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 4 :
					// //GeoScript.g:160:5: 'SQUARE' 'AT' '(' x= expr ',' y= expr ')' 'SIZE' sz= expr ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal92=(Token)match(input,45,FOLLOW_45_in_shapeStmt961); 
					string_literal92_tree = (Object)adaptor.create(string_literal92);
					adaptor.addChild(root_0, string_literal92_tree);

					string_literal93=(Token)match(input,25,FOLLOW_25_in_shapeStmt963); 
					string_literal93_tree = (Object)adaptor.create(string_literal93);
					adaptor.addChild(root_0, string_literal93_tree);

					char_literal94=(Token)match(input,13,FOLLOW_13_in_shapeStmt965); 
					char_literal94_tree = (Object)adaptor.create(char_literal94);
					adaptor.addChild(root_0, char_literal94_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt969);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal95=(Token)match(input,17,FOLLOW_17_in_shapeStmt971); 
					char_literal95_tree = (Object)adaptor.create(char_literal95);
					adaptor.addChild(root_0, char_literal95_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt975);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal96=(Token)match(input,14,FOLLOW_14_in_shapeStmt977); 
					char_literal96_tree = (Object)adaptor.create(char_literal96);
					adaptor.addChild(root_0, char_literal96_tree);

					string_literal97=(Token)match(input,44,FOLLOW_44_in_shapeStmt979); 
					string_literal97_tree = (Object)adaptor.create(string_literal97);
					adaptor.addChild(root_0, string_literal97_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt983);
					sz=expr();
					state._fsp--;

					adaptor.addChild(root_0, sz.getTree());

					// //GeoScript.g:160:60: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==32) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// //GeoScript.g:160:62: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal98=(Token)match(input,32,FOLLOW_32_in_shapeStmt987); 
							string_literal98_tree = (Object)adaptor.create(string_literal98);
							adaptor.addChild(root_0, string_literal98_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:160:89: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==46) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// //GeoScript.g:160:91: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal99=(Token)match(input,46,FOLLOW_46_in_shapeStmt1002); 
							string_literal99_tree = (Object)adaptor.create(string_literal99);
							adaptor.addChild(root_0, string_literal99_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal100=(Token)match(input,20,FOLLOW_20_in_shapeStmt1015); 
					char_literal100_tree = (Object)adaptor.create(char_literal100);
					adaptor.addChild(root_0, char_literal100_tree);


					      Expr[] ex = new Expr[]{ (x!=null?((GeoScriptParser.expr_return)x).expr:null), (y!=null?((GeoScriptParser.expr_return)y).expr:null), (sz!=null?((GeoScriptParser.expr_return)sz).expr:null) };
					      retval.cmd = new ShapeCommand("SQUARE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 5 :
					// //GeoScript.g:165:5: 'TRIANGLE' 'AT' '(' x= expr ',' y= expr ')' 'POINTS' '(' p1x= expr ',' p1y= expr ',' p2x= expr ',' p2y= expr ',' p3x= expr ',' p3y= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal101=(Token)match(input,51,FOLLOW_51_in_shapeStmt1027); 
					string_literal101_tree = (Object)adaptor.create(string_literal101);
					adaptor.addChild(root_0, string_literal101_tree);

					string_literal102=(Token)match(input,25,FOLLOW_25_in_shapeStmt1029); 
					string_literal102_tree = (Object)adaptor.create(string_literal102);
					adaptor.addChild(root_0, string_literal102_tree);

					char_literal103=(Token)match(input,13,FOLLOW_13_in_shapeStmt1031); 
					char_literal103_tree = (Object)adaptor.create(char_literal103);
					adaptor.addChild(root_0, char_literal103_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1035);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal104=(Token)match(input,17,FOLLOW_17_in_shapeStmt1037); 
					char_literal104_tree = (Object)adaptor.create(char_literal104);
					adaptor.addChild(root_0, char_literal104_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1041);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal105=(Token)match(input,14,FOLLOW_14_in_shapeStmt1043); 
					char_literal105_tree = (Object)adaptor.create(char_literal105);
					adaptor.addChild(root_0, char_literal105_tree);

					string_literal106=(Token)match(input,37,FOLLOW_37_in_shapeStmt1045); 
					string_literal106_tree = (Object)adaptor.create(string_literal106);
					adaptor.addChild(root_0, string_literal106_tree);

					char_literal107=(Token)match(input,13,FOLLOW_13_in_shapeStmt1047); 
					char_literal107_tree = (Object)adaptor.create(char_literal107);
					adaptor.addChild(root_0, char_literal107_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1051);
					p1x=expr();
					state._fsp--;

					adaptor.addChild(root_0, p1x.getTree());

					char_literal108=(Token)match(input,17,FOLLOW_17_in_shapeStmt1053); 
					char_literal108_tree = (Object)adaptor.create(char_literal108);
					adaptor.addChild(root_0, char_literal108_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1057);
					p1y=expr();
					state._fsp--;

					adaptor.addChild(root_0, p1y.getTree());

					char_literal109=(Token)match(input,17,FOLLOW_17_in_shapeStmt1059); 
					char_literal109_tree = (Object)adaptor.create(char_literal109);
					adaptor.addChild(root_0, char_literal109_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1063);
					p2x=expr();
					state._fsp--;

					adaptor.addChild(root_0, p2x.getTree());

					char_literal110=(Token)match(input,17,FOLLOW_17_in_shapeStmt1065); 
					char_literal110_tree = (Object)adaptor.create(char_literal110);
					adaptor.addChild(root_0, char_literal110_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1069);
					p2y=expr();
					state._fsp--;

					adaptor.addChild(root_0, p2y.getTree());

					char_literal111=(Token)match(input,17,FOLLOW_17_in_shapeStmt1071); 
					char_literal111_tree = (Object)adaptor.create(char_literal111);
					adaptor.addChild(root_0, char_literal111_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1075);
					p3x=expr();
					state._fsp--;

					adaptor.addChild(root_0, p3x.getTree());

					char_literal112=(Token)match(input,17,FOLLOW_17_in_shapeStmt1077); 
					char_literal112_tree = (Object)adaptor.create(char_literal112);
					adaptor.addChild(root_0, char_literal112_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1081);
					p3y=expr();
					state._fsp--;

					adaptor.addChild(root_0, p3y.getTree());

					char_literal113=(Token)match(input,14,FOLLOW_14_in_shapeStmt1083); 
					char_literal113_tree = (Object)adaptor.create(char_literal113);
					adaptor.addChild(root_0, char_literal113_tree);

					// //GeoScript.g:165:138: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==32) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// //GeoScript.g:165:140: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal114=(Token)match(input,32,FOLLOW_32_in_shapeStmt1087); 
							string_literal114_tree = (Object)adaptor.create(string_literal114);
							adaptor.addChild(root_0, string_literal114_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:165:167: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==46) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// //GeoScript.g:165:169: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal115=(Token)match(input,46,FOLLOW_46_in_shapeStmt1102); 
							string_literal115_tree = (Object)adaptor.create(string_literal115);
							adaptor.addChild(root_0, string_literal115_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal116=(Token)match(input,20,FOLLOW_20_in_shapeStmt1115); 
					char_literal116_tree = (Object)adaptor.create(char_literal116);
					adaptor.addChild(root_0, char_literal116_tree);


					      Expr[] ex = new Expr[]{ (p1x!=null?((GeoScriptParser.expr_return)p1x).expr:null), (p1y!=null?((GeoScriptParser.expr_return)p1y).expr:null), (p2x!=null?((GeoScriptParser.expr_return)p2x).expr:null), (p2y!=null?((GeoScriptParser.expr_return)p2y).expr:null), (p3x!=null?((GeoScriptParser.expr_return)p3x).expr:null), (p3y!=null?((GeoScriptParser.expr_return)p3y).expr:null) };
					      retval.cmd = new ShapeCommand("TRIANGLE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 6 :
					// //GeoScript.g:170:5: 'ELLIPSE' 'AT' '(' x= expr ',' y= expr ')' 'RADII' '(' rx= expr ',' ry= expr ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal117=(Token)match(input,30,FOLLOW_30_in_shapeStmt1127); 
					string_literal117_tree = (Object)adaptor.create(string_literal117);
					adaptor.addChild(root_0, string_literal117_tree);

					string_literal118=(Token)match(input,25,FOLLOW_25_in_shapeStmt1129); 
					string_literal118_tree = (Object)adaptor.create(string_literal118);
					adaptor.addChild(root_0, string_literal118_tree);

					char_literal119=(Token)match(input,13,FOLLOW_13_in_shapeStmt1131); 
					char_literal119_tree = (Object)adaptor.create(char_literal119);
					adaptor.addChild(root_0, char_literal119_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1135);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal120=(Token)match(input,17,FOLLOW_17_in_shapeStmt1137); 
					char_literal120_tree = (Object)adaptor.create(char_literal120);
					adaptor.addChild(root_0, char_literal120_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1141);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal121=(Token)match(input,14,FOLLOW_14_in_shapeStmt1143); 
					char_literal121_tree = (Object)adaptor.create(char_literal121);
					adaptor.addChild(root_0, char_literal121_tree);

					string_literal122=(Token)match(input,39,FOLLOW_39_in_shapeStmt1145); 
					string_literal122_tree = (Object)adaptor.create(string_literal122);
					adaptor.addChild(root_0, string_literal122_tree);

					char_literal123=(Token)match(input,13,FOLLOW_13_in_shapeStmt1147); 
					char_literal123_tree = (Object)adaptor.create(char_literal123);
					adaptor.addChild(root_0, char_literal123_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1151);
					rx=expr();
					state._fsp--;

					adaptor.addChild(root_0, rx.getTree());

					char_literal124=(Token)match(input,17,FOLLOW_17_in_shapeStmt1153); 
					char_literal124_tree = (Object)adaptor.create(char_literal124);
					adaptor.addChild(root_0, char_literal124_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1157);
					ry=expr();
					state._fsp--;

					adaptor.addChild(root_0, ry.getTree());

					char_literal125=(Token)match(input,14,FOLLOW_14_in_shapeStmt1159); 
					char_literal125_tree = (Object)adaptor.create(char_literal125);
					adaptor.addChild(root_0, char_literal125_tree);

					// //GeoScript.g:170:82: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==32) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// //GeoScript.g:170:84: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal126=(Token)match(input,32,FOLLOW_32_in_shapeStmt1163); 
							string_literal126_tree = (Object)adaptor.create(string_literal126);
							adaptor.addChild(root_0, string_literal126_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:170:111: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==46) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// //GeoScript.g:170:113: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal127=(Token)match(input,46,FOLLOW_46_in_shapeStmt1178); 
							string_literal127_tree = (Object)adaptor.create(string_literal127);
							adaptor.addChild(root_0, string_literal127_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal128=(Token)match(input,20,FOLLOW_20_in_shapeStmt1191); 
					char_literal128_tree = (Object)adaptor.create(char_literal128);
					adaptor.addChild(root_0, char_literal128_tree);


					      Expr[] ex = new Expr[]{ (x!=null?((GeoScriptParser.expr_return)x).expr:null), (y!=null?((GeoScriptParser.expr_return)y).expr:null), (rx!=null?((GeoScriptParser.expr_return)rx).expr:null), (ry!=null?((GeoScriptParser.expr_return)ry).expr:null) };
					      retval.cmd = new ShapeCommand("ELLIPSE", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 7 :
					// //GeoScript.g:175:5: 'POLYGON' 'POINTS' '(' pts= pointList ')' ( 'FILL' f= ( ID | HEX_COLOR ) )? ( 'STROKE' st= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal129=(Token)match(input,38,FOLLOW_38_in_shapeStmt1203); 
					string_literal129_tree = (Object)adaptor.create(string_literal129);
					adaptor.addChild(root_0, string_literal129_tree);

					string_literal130=(Token)match(input,37,FOLLOW_37_in_shapeStmt1205); 
					string_literal130_tree = (Object)adaptor.create(string_literal130);
					adaptor.addChild(root_0, string_literal130_tree);

					char_literal131=(Token)match(input,13,FOLLOW_13_in_shapeStmt1207); 
					char_literal131_tree = (Object)adaptor.create(char_literal131);
					adaptor.addChild(root_0, char_literal131_tree);

					pushFollow(FOLLOW_pointList_in_shapeStmt1211);
					pts=pointList();
					state._fsp--;

					adaptor.addChild(root_0, pts.getTree());

					char_literal132=(Token)match(input,14,FOLLOW_14_in_shapeStmt1213); 
					char_literal132_tree = (Object)adaptor.create(char_literal132);
					adaptor.addChild(root_0, char_literal132_tree);

					// //GeoScript.g:175:46: ( 'FILL' f= ( ID | HEX_COLOR ) )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==32) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// //GeoScript.g:175:48: 'FILL' f= ( ID | HEX_COLOR )
							{
							string_literal133=(Token)match(input,32,FOLLOW_32_in_shapeStmt1217); 
							string_literal133_tree = (Object)adaptor.create(string_literal133);
							adaptor.addChild(root_0, string_literal133_tree);

							f=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(f));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// //GeoScript.g:175:75: ( 'STROKE' st= ( ID | HEX_COLOR ) )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==46) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// //GeoScript.g:175:77: 'STROKE' st= ( ID | HEX_COLOR )
							{
							string_literal134=(Token)match(input,46,FOLLOW_46_in_shapeStmt1232); 
							string_literal134_tree = (Object)adaptor.create(string_literal134);
							adaptor.addChild(root_0, string_literal134_tree);

							st=input.LT(1);
							if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
								input.consume();
								adaptor.addChild(root_0, (Object)adaptor.create(st));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					char_literal135=(Token)match(input,20,FOLLOW_20_in_shapeStmt1245); 
					char_literal135_tree = (Object)adaptor.create(char_literal135);
					adaptor.addChild(root_0, char_literal135_tree);


					      Expr[] ex = (pts!=null?((GeoScriptParser.pointList_return)pts).list:null).toArray(new Expr[0]);
					      retval.cmd = new ShapeCommand("POLYGON", ex, (f!=null?f.getText():null), f, (st!=null?st.getText():null), st);
					    
					}
					break;
				case 8 :
					// //GeoScript.g:180:5: 'TEXT' '(' str= STRING ',' x= expr ',' y= expr ')' ( 'COLOR' c= ( ID | HEX_COLOR ) )? ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal136=(Token)match(input,47,FOLLOW_47_in_shapeStmt1257); 
					string_literal136_tree = (Object)adaptor.create(string_literal136);
					adaptor.addChild(root_0, string_literal136_tree);

					char_literal137=(Token)match(input,13,FOLLOW_13_in_shapeStmt1259); 
					char_literal137_tree = (Object)adaptor.create(char_literal137);
					adaptor.addChild(root_0, char_literal137_tree);

					str=(Token)match(input,STRING,FOLLOW_STRING_in_shapeStmt1263); 
					str_tree = (Object)adaptor.create(str);
					adaptor.addChild(root_0, str_tree);

					char_literal138=(Token)match(input,17,FOLLOW_17_in_shapeStmt1265); 
					char_literal138_tree = (Object)adaptor.create(char_literal138);
					adaptor.addChild(root_0, char_literal138_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1269);
					x=expr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());

					char_literal139=(Token)match(input,17,FOLLOW_17_in_shapeStmt1271); 
					char_literal139_tree = (Object)adaptor.create(char_literal139);
					adaptor.addChild(root_0, char_literal139_tree);

					pushFollow(FOLLOW_expr_in_shapeStmt1275);
					y=expr();
					state._fsp--;

					adaptor.addChild(root_0, y.getTree());

					char_literal140=(Token)match(input,14,FOLLOW_14_in_shapeStmt1277); 
					char_literal140_tree = (Object)adaptor.create(char_literal140);
					adaptor.addChild(root_0, char_literal140_tree);

					// //GeoScript.g:180:53: ( 'COLOR' c= ( ID | HEX_COLOR ) )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==28) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// //GeoScript.g:180:55: 'COLOR' c= ( ID | HEX_COLOR )
							{
							string_literal141=(Token)match(input,28,FOLLOW_28_in_shapeStmt1281); 
							string_literal141_tree = (Object)adaptor.create(string_literal141);
							adaptor.addChild(root_0, string_literal141_tree);

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

					char_literal142=(Token)match(input,20,FOLLOW_20_in_shapeStmt1294); 
					char_literal142_tree = (Object)adaptor.create(char_literal142);
					adaptor.addChild(root_0, char_literal142_tree);


					      Expr[] ex = new Expr[]{ (x!=null?((GeoScriptParser.expr_return)x).expr:null), (y!=null?((GeoScriptParser.expr_return)y).expr:null) };
					      String text = str.getText();
					      if (text.length()>=2) text = text.substring(1,text.length()-1);
					      retval.cmd = new ShapeCommand("TEXT", ex, text, null, (c!=null?c.getText():null), c);
					    
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


	public static class pointList_return extends ParserRuleReturnScope {
		public List<Expr> list;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pointList"
	// //GeoScript.g:189:1: pointList returns [List<Expr> list] : a= expr ',' b= expr ( ',' c= expr ',' d= expr )* ;
	public final GeoScriptParser.pointList_return pointList() throws RecognitionException {
		GeoScriptParser.pointList_return retval = new GeoScriptParser.pointList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal143=null;
		Token char_literal144=null;
		Token char_literal145=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope d =null;

		Object char_literal143_tree=null;
		Object char_literal144_tree=null;
		Object char_literal145_tree=null;

		 retval.list = new ArrayList<Expr>(); 
		try {
			// //GeoScript.g:191:3: (a= expr ',' b= expr ( ',' c= expr ',' d= expr )* )
			// //GeoScript.g:191:5: a= expr ',' b= expr ( ',' c= expr ',' d= expr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_pointList1324);
			a=expr();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			 retval.list.add((a!=null?((GeoScriptParser.expr_return)a).expr:null)); 
			char_literal143=(Token)match(input,17,FOLLOW_17_in_pointList1328); 
			char_literal143_tree = (Object)adaptor.create(char_literal143);
			adaptor.addChild(root_0, char_literal143_tree);

			pushFollow(FOLLOW_expr_in_pointList1332);
			b=expr();
			state._fsp--;

			adaptor.addChild(root_0, b.getTree());

			 retval.list.add((b!=null?((GeoScriptParser.expr_return)b).expr:null)); 
			// //GeoScript.g:192:5: ( ',' c= expr ',' d= expr )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==17) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// //GeoScript.g:192:7: ',' c= expr ',' d= expr
					{
					char_literal144=(Token)match(input,17,FOLLOW_17_in_pointList1342); 
					char_literal144_tree = (Object)adaptor.create(char_literal144);
					adaptor.addChild(root_0, char_literal144_tree);

					pushFollow(FOLLOW_expr_in_pointList1346);
					c=expr();
					state._fsp--;

					adaptor.addChild(root_0, c.getTree());

					 retval.list.add((c!=null?((GeoScriptParser.expr_return)c).expr:null)); 
					char_literal145=(Token)match(input,17,FOLLOW_17_in_pointList1350); 
					char_literal145_tree = (Object)adaptor.create(char_literal145);
					adaptor.addChild(root_0, char_literal145_tree);

					pushFollow(FOLLOW_expr_in_pointList1354);
					d=expr();
					state._fsp--;

					adaptor.addChild(root_0, d.getTree());

					 retval.list.add((d!=null?((GeoScriptParser.expr_return)d).expr:null)); 
					}
					break;

				default :
					break loop25;
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
	// $ANTLR end "pointList"


	public static class expr_return extends ParserRuleReturnScope {
		public Expr expr;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// //GeoScript.g:196:1: expr returns [Expr expr] : a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )* ;
	public final GeoScriptParser.expr_return expr() throws RecognitionException {
		GeoScriptParser.expr_return retval = new GeoScriptParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;

		Object op_tree=null;

		try {
			// //GeoScript.g:197:3: (a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )* )
			// //GeoScript.g:197:5: a= addExpr (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_expr1379);
			a=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			 retval.expr = (a!=null?((GeoScriptParser.addExpr_return)a).expr:null); 
			// //GeoScript.g:198:5: (op= ( '<' | '>' | '==' | '!=' ) b= addExpr )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==12||LA26_0==21||(LA26_0 >= 23 && LA26_0 <= 24)) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// //GeoScript.g:198:7: op= ( '<' | '>' | '==' | '!=' ) b= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||input.LA(1)==21||(input.LA(1) >= 23 && input.LA(1) <= 24) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_expr1403);
					b=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, b.getTree());

					 retval.expr = new BinExpr(retval.expr, (op!=null?op.getText():null), (b!=null?((GeoScriptParser.addExpr_return)b).expr:null)); 
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


	public static class addExpr_return extends ParserRuleReturnScope {
		public Expr expr;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// //GeoScript.g:201:1: addExpr returns [Expr expr] : a= term ( '+' b= term | '-' b2= term )* ;
	public final GeoScriptParser.addExpr_return addExpr() throws RecognitionException {
		GeoScriptParser.addExpr_return retval = new GeoScriptParser.addExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal146=null;
		Token char_literal147=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope b2 =null;

		Object char_literal146_tree=null;
		Object char_literal147_tree=null;

		try {
			// //GeoScript.g:202:3: (a= term ( '+' b= term | '-' b2= term )* )
			// //GeoScript.g:202:5: a= term ( '+' b= term | '-' b2= term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term_in_addExpr1427);
			a=term();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			 retval.expr = (a!=null?((GeoScriptParser.term_return)a).expr:null); 
			// //GeoScript.g:203:5: ( '+' b= term | '-' b2= term )*
			loop27:
			while (true) {
				int alt27=3;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==16) ) {
					alt27=1;
				}
				else if ( (LA27_0==18) ) {
					alt27=2;
				}

				switch (alt27) {
				case 1 :
					// //GeoScript.g:203:7: '+' b= term
					{
					char_literal146=(Token)match(input,16,FOLLOW_16_in_addExpr1437); 
					char_literal146_tree = (Object)adaptor.create(char_literal146);
					adaptor.addChild(root_0, char_literal146_tree);

					pushFollow(FOLLOW_term_in_addExpr1441);
					b=term();
					state._fsp--;

					adaptor.addChild(root_0, b.getTree());

					 retval.expr = new BinExpr(retval.expr, "+", (b!=null?((GeoScriptParser.term_return)b).expr:null)); 
					}
					break;
				case 2 :
					// //GeoScript.g:204:7: '-' b2= term
					{
					char_literal147=(Token)match(input,18,FOLLOW_18_in_addExpr1451); 
					char_literal147_tree = (Object)adaptor.create(char_literal147);
					adaptor.addChild(root_0, char_literal147_tree);

					pushFollow(FOLLOW_term_in_addExpr1455);
					b2=term();
					state._fsp--;

					adaptor.addChild(root_0, b2.getTree());

					 retval.expr = new BinExpr(retval.expr, "-", (b2!=null?((GeoScriptParser.term_return)b2).expr:null)); 
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
	// $ANTLR end "addExpr"


	public static class term_return extends ParserRuleReturnScope {
		public Expr expr;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// //GeoScript.g:208:1: term returns [Expr expr] : f= factor ( '*' g= factor | '/' g2= factor |m= MOD g3= factor )* ;
	public final GeoScriptParser.term_return term() throws RecognitionException {
		GeoScriptParser.term_return retval = new GeoScriptParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token m=null;
		Token char_literal148=null;
		Token char_literal149=null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope g =null;
		ParserRuleReturnScope g2 =null;
		ParserRuleReturnScope g3 =null;

		Object m_tree=null;
		Object char_literal148_tree=null;
		Object char_literal149_tree=null;

		try {
			// //GeoScript.g:209:3: (f= factor ( '*' g= factor | '/' g2= factor |m= MOD g3= factor )* )
			// //GeoScript.g:209:5: f= factor ( '*' g= factor | '/' g2= factor |m= MOD g3= factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1483);
			f=factor();
			state._fsp--;

			adaptor.addChild(root_0, f.getTree());

			 retval.expr = (f!=null?((GeoScriptParser.factor_return)f).expr:null); 
			// //GeoScript.g:210:5: ( '*' g= factor | '/' g2= factor |m= MOD g3= factor )*
			loop28:
			while (true) {
				int alt28=4;
				switch ( input.LA(1) ) {
				case 15:
					{
					alt28=1;
					}
					break;
				case 19:
					{
					alt28=2;
					}
					break;
				case MOD:
					{
					alt28=3;
					}
					break;
				}
				switch (alt28) {
				case 1 :
					// //GeoScript.g:210:7: '*' g= factor
					{
					char_literal148=(Token)match(input,15,FOLLOW_15_in_term1493); 
					char_literal148_tree = (Object)adaptor.create(char_literal148);
					adaptor.addChild(root_0, char_literal148_tree);

					pushFollow(FOLLOW_factor_in_term1497);
					g=factor();
					state._fsp--;

					adaptor.addChild(root_0, g.getTree());

					 retval.expr = new BinExpr(retval.expr, "*", (g!=null?((GeoScriptParser.factor_return)g).expr:null)); 
					}
					break;
				case 2 :
					// //GeoScript.g:211:7: '/' g2= factor
					{
					char_literal149=(Token)match(input,19,FOLLOW_19_in_term1507); 
					char_literal149_tree = (Object)adaptor.create(char_literal149);
					adaptor.addChild(root_0, char_literal149_tree);

					pushFollow(FOLLOW_factor_in_term1511);
					g2=factor();
					state._fsp--;

					adaptor.addChild(root_0, g2.getTree());

					 retval.expr = new BinExpr(retval.expr, "/", (g2!=null?((GeoScriptParser.factor_return)g2).expr:null)); 
					}
					break;
				case 3 :
					// //GeoScript.g:212:7: m= MOD g3= factor
					{
					m=(Token)match(input,MOD,FOLLOW_MOD_in_term1523); 
					m_tree = (Object)adaptor.create(m);
					adaptor.addChild(root_0, m_tree);

					pushFollow(FOLLOW_factor_in_term1527);
					g3=factor();
					state._fsp--;

					adaptor.addChild(root_0, g3.getTree());

					 retval.expr = new BinExpr(retval.expr, (m!=null?m.getText():null), (g3!=null?((GeoScriptParser.factor_return)g3).expr:null)); 
					}
					break;

				default :
					break loop28;
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
		public Expr expr;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// //GeoScript.g:216:1: factor returns [Expr expr] : (n= INT |id= ID | '(' e= expr ')' );
	public final GeoScriptParser.factor_return factor() throws RecognitionException {
		GeoScriptParser.factor_return retval = new GeoScriptParser.factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token id=null;
		Token char_literal150=null;
		Token char_literal151=null;
		ParserRuleReturnScope e =null;

		Object n_tree=null;
		Object id_tree=null;
		Object char_literal150_tree=null;
		Object char_literal151_tree=null;

		try {
			// //GeoScript.g:217:3: (n= INT |id= ID | '(' e= expr ')' )
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
			case 13:
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
					// //GeoScript.g:217:5: n= INT
					{
					root_0 = (Object)adaptor.nil();


					n=(Token)match(input,INT,FOLLOW_INT_in_factor1555); 
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);

					 retval.expr = new ConstExpr(Integer.parseInt(n.getText())); 
					}
					break;
				case 2 :
					// //GeoScript.g:218:5: id= ID
					{
					root_0 = (Object)adaptor.nil();


					id=(Token)match(input,ID,FOLLOW_ID_in_factor1565); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);

					 retval.expr = new VarExpr(id.getText()); 
					}
					break;
				case 3 :
					// //GeoScript.g:219:5: '(' e= expr ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal150=(Token)match(input,13,FOLLOW_13_in_factor1573); 
					char_literal150_tree = (Object)adaptor.create(char_literal150);
					adaptor.addChild(root_0, char_literal150_tree);

					pushFollow(FOLLOW_expr_in_factor1577);
					e=expr();
					state._fsp--;

					adaptor.addChild(root_0, e.getTree());

					char_literal151=(Token)match(input,14,FOLLOW_14_in_factor1579); 
					char_literal151_tree = (Object)adaptor.create(char_literal151);
					adaptor.addChild(root_0, char_literal151_tree);

					 retval.expr = (e!=null?((GeoScriptParser.expr_return)e).expr:null); 
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


	public static class assignSimple_return extends ParserRuleReturnScope {
		public Command cmd;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignSimple"
	// //GeoScript.g:222:1: assignSimple returns [Command cmd] : id= ID '=' e= expr ;
	public final GeoScriptParser.assignSimple_return assignSimple() throws RecognitionException {
		GeoScriptParser.assignSimple_return retval = new GeoScriptParser.assignSimple_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token char_literal152=null;
		ParserRuleReturnScope e =null;

		Object id_tree=null;
		Object char_literal152_tree=null;

		try {
			// //GeoScript.g:223:3: (id= ID '=' e= expr )
			// //GeoScript.g:223:5: id= ID '=' e= expr
			{
			root_0 = (Object)adaptor.nil();


			id=(Token)match(input,ID,FOLLOW_ID_in_assignSimple1600); 
			id_tree = (Object)adaptor.create(id);
			adaptor.addChild(root_0, id_tree);

			char_literal152=(Token)match(input,22,FOLLOW_22_in_assignSimple1602); 
			char_literal152_tree = (Object)adaptor.create(char_literal152);
			adaptor.addChild(root_0, char_literal152_tree);

			pushFollow(FOLLOW_expr_in_assignSimple1606);
			e=expr();
			state._fsp--;

			adaptor.addChild(root_0, e.getTree());

			 retval.cmd = new AssignCommand(id.getText(), (e!=null?((GeoScriptParser.expr_return)e).expr:null)); 
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
	// $ANTLR end "assignSimple"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_prog64 = new BitSet(new long[]{0x003CAE5A6C0000A0L});
	public static final BitSet FOLLOW_EOF_in_prog70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_canvasStmt_in_statement93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_colorDef_in_statement107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varDeclStmt_in_statement123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignStmt_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStmt_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStmt_in_statement168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forStmt_in_statement183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_transformStmt_in_statement200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shapeStmt_in_statement211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMENTLINE_in_statement226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_canvasStmt246 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_canvasStmt248 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt252 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_canvasStmt254 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_canvasStmt258 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_canvasStmt260 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_canvasStmt262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_colorDef281 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_colorDef285 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_colorDef287 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_HEX_COLOR_in_colorDef291 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_colorDef293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_varDeclStmt316 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_varDeclStmt320 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_varDeclStmt322 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_varDeclStmt326 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_varDeclStmt328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStmt353 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_assignStmt355 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_assignStmt359 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_assignStmt361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_ifStmt389 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ifStmt391 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_ifStmt395 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStmt397 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_ifStmt399 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_ifStmt401 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt414 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_55_in_ifStmt420 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_ifStmt429 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_ifStmt431 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_statement_in_ifStmt444 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_55_in_ifStmt450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_whileStmt481 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_whileStmt483 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_whileStmt487 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_whileStmt489 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_whileStmt491 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_statement_in_whileStmt504 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_55_in_whileStmt510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_forStmt538 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_forStmt540 = new BitSet(new long[]{0x0010000000100080L});
	public static final BitSet FOLLOW_forInitHeader_in_forStmt551 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_forStmt553 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_forStmt564 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_forStmt566 = new BitSet(new long[]{0x0000000000004080L});
	public static final BitSet FOLLOW_forIncrHeader_in_forStmt577 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_forStmt584 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_forStmt586 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_statement_in_forStmt599 = new BitSet(new long[]{0x00BCAE5A6C0000A0L});
	public static final BitSet FOLLOW_55_in_forStmt605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_forInitHeader628 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_forInitHeader632 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forInitHeader634 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_forInitHeader638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignSimple_in_forInitHeader648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignSimple_in_forIncrHeader675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_transformStmt696 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_INT_in_transformStmt700 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_transformStmt702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_transformStmt708 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt710 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_transformStmt714 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_transformStmt716 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_transformStmt720 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_transformStmt722 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_transformStmt724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_transformStmt730 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_transformStmt732 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_transformStmt736 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_transformStmt738 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_transformStmt742 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_transformStmt744 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_transformStmt746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_shapeStmt763 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_shapeStmt765 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt767 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt771 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt773 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt777 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt779 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_shapeStmt781 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt783 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt787 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt789 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt793 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt795 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt799 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt803 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt814 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt818 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_shapeStmt839 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_shapeStmt841 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt843 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt847 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt849 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt853 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt855 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_shapeStmt857 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt861 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt865 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt869 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt880 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt884 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_shapeStmt905 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_shapeStmt907 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt909 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt913 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt915 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt919 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt921 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_shapeStmt923 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt925 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt929 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt931 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt935 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt937 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_shapeStmt939 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt943 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_shapeStmt961 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_shapeStmt963 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt965 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt969 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt971 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt975 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt977 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_shapeStmt979 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt983 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt987 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt991 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt1002 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1006 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_shapeStmt1027 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_shapeStmt1029 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1031 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1035 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1037 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1041 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1043 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_shapeStmt1045 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1047 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1051 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1053 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1057 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1059 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1063 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1065 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1069 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1071 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1075 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1077 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1081 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1083 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt1087 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1091 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt1102 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1106 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt1115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_shapeStmt1127 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_shapeStmt1129 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1131 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1135 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1137 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1141 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1143 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_shapeStmt1145 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1147 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1151 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1153 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1157 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1159 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt1163 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1167 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt1178 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1182 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt1191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_shapeStmt1203 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_shapeStmt1205 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1207 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_pointList_in_shapeStmt1211 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1213 = new BitSet(new long[]{0x0000400100100000L});
	public static final BitSet FOLLOW_32_in_shapeStmt1217 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1221 = new BitSet(new long[]{0x0000400000100000L});
	public static final BitSet FOLLOW_46_in_shapeStmt1232 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1236 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt1245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_shapeStmt1257 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_shapeStmt1259 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_STRING_in_shapeStmt1263 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1265 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1269 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_shapeStmt1271 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_shapeStmt1275 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_shapeStmt1277 = new BitSet(new long[]{0x0000000010100000L});
	public static final BitSet FOLLOW_28_in_shapeStmt1281 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_set_in_shapeStmt1285 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_shapeStmt1294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_pointList1324 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_pointList1328 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_pointList1332 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_pointList1342 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_pointList1346 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_pointList1350 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_pointList1354 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_addExpr_in_expr1379 = new BitSet(new long[]{0x0000000001A01002L});
	public static final BitSet FOLLOW_set_in_expr1391 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_addExpr_in_expr1403 = new BitSet(new long[]{0x0000000001A01002L});
	public static final BitSet FOLLOW_term_in_addExpr1427 = new BitSet(new long[]{0x0000000000050002L});
	public static final BitSet FOLLOW_16_in_addExpr1437 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_term_in_addExpr1441 = new BitSet(new long[]{0x0000000000050002L});
	public static final BitSet FOLLOW_18_in_addExpr1451 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_term_in_addExpr1455 = new BitSet(new long[]{0x0000000000050002L});
	public static final BitSet FOLLOW_factor_in_term1483 = new BitSet(new long[]{0x0000000000088202L});
	public static final BitSet FOLLOW_15_in_term1493 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_factor_in_term1497 = new BitSet(new long[]{0x0000000000088202L});
	public static final BitSet FOLLOW_19_in_term1507 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_factor_in_term1511 = new BitSet(new long[]{0x0000000000088202L});
	public static final BitSet FOLLOW_MOD_in_term1523 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_factor_in_term1527 = new BitSet(new long[]{0x0000000000088202L});
	public static final BitSet FOLLOW_INT_in_factor1555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_factor1565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_factor1573 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_factor1577 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_factor1579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignSimple1600 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_assignSimple1602 = new BitSet(new long[]{0x0000000000002180L});
	public static final BitSet FOLLOW_expr_in_assignSimple1606 = new BitSet(new long[]{0x0000000000000002L});
}
