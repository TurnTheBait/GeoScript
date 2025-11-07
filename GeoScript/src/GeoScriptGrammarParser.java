// $ANTLR 3.5.1 /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g 2025-11-07 16:35:10

  import java.util.Map;
  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class GeoScriptGrammarParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "HEX_COLOR", "ID", "INT", "WS", 
		"'('", "')'", "','", "';'", "'='", "'AT'", "'CANVAS'", "'CIRCLE'", "'DEF'", 
		"'FILL'", "'FROM'", "'LINE'", "'RADIUS'", "'RECT'", "'SIZE'", "'STROKE'", 
		"'TO'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
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
	public static final int HEX_COLOR=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int WS=7;

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

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return GeoScriptGrammarParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g"; }


	  Map<String,String> colorTable = new HashMap<String,String>();
	  boolean canvasDefined = false;


	public static class prog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:1: prog : ( statement )+ EOF ;
	public final GeoScriptGrammarParser.prog_return prog() throws RecognitionException {
		GeoScriptGrammarParser.prog_return retval = new GeoScriptGrammarParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope statement1 =null;

		Object EOF2_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:13: ( ( statement )+ EOF )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:15: ( statement )+ EOF
			{
			root_0 = (Object)adaptor.nil();


			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:15: ( statement )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 14 && LA1_0 <= 16)||LA1_0==19||LA1_0==21) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:16: statement
					{
					pushFollow(FOLLOW_statement_in_prog46);
					statement1=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement1.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog50); 
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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:1: statement : ( canvasStmt | colorDef | shapeStmt );
	public final GeoScriptGrammarParser.statement_return statement() throws RecognitionException {
		GeoScriptGrammarParser.statement_return retval = new GeoScriptGrammarParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope canvasStmt3 =null;
		ParserRuleReturnScope colorDef4 =null;
		ParserRuleReturnScope shapeStmt5 =null;


		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:13: ( canvasStmt | colorDef | shapeStmt )
			int alt2=3;
			switch ( input.LA(1) ) {
			case 14:
				{
				alt2=1;
				}
				break;
			case 16:
				{
				alt2=2;
				}
				break;
			case 15:
			case 19:
			case 21:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:15: canvasStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_canvasStmt_in_statement60);
					canvasStmt3=canvasStmt();
					state._fsp--;

					adaptor.addChild(root_0, canvasStmt3.getTree());

					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:28: colorDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_colorDef_in_statement64);
					colorDef4=colorDef();
					state._fsp--;

					adaptor.addChild(root_0, colorDef4.getTree());

					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:39: shapeStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_shapeStmt_in_statement68);
					shapeStmt5=shapeStmt();
					state._fsp--;

					adaptor.addChild(root_0, shapeStmt5.getTree());

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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:19:1: canvasStmt : 'CANVAS' '(' width= INT ',' height= INT ')' ';' ;
	public final GeoScriptGrammarParser.canvasStmt_return canvasStmt() throws RecognitionException {
		GeoScriptGrammarParser.canvasStmt_return retval = new GeoScriptGrammarParser.canvasStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token width=null;
		Token height=null;
		Token string_literal6=null;
		Token char_literal7=null;
		Token char_literal8=null;
		Token char_literal9=null;
		Token char_literal10=null;

		Object width_tree=null;
		Object height_tree=null;
		Object string_literal6_tree=null;
		Object char_literal7_tree=null;
		Object char_literal8_tree=null;
		Object char_literal9_tree=null;
		Object char_literal10_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:20:3: ( 'CANVAS' '(' width= INT ',' height= INT ')' ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:20:5: 'CANVAS' '(' width= INT ',' height= INT ')' ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal6=(Token)match(input,14,FOLLOW_14_in_canvasStmt79); 
			string_literal6_tree = (Object)adaptor.create(string_literal6);
			adaptor.addChild(root_0, string_literal6_tree);

			char_literal7=(Token)match(input,8,FOLLOW_8_in_canvasStmt81); 
			char_literal7_tree = (Object)adaptor.create(char_literal7);
			adaptor.addChild(root_0, char_literal7_tree);

			width=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt85); 
			width_tree = (Object)adaptor.create(width);
			adaptor.addChild(root_0, width_tree);

			char_literal8=(Token)match(input,10,FOLLOW_10_in_canvasStmt87); 
			char_literal8_tree = (Object)adaptor.create(char_literal8);
			adaptor.addChild(root_0, char_literal8_tree);

			height=(Token)match(input,INT,FOLLOW_INT_in_canvasStmt91); 
			height_tree = (Object)adaptor.create(height);
			adaptor.addChild(root_0, height_tree);

			char_literal9=(Token)match(input,9,FOLLOW_9_in_canvasStmt93); 
			char_literal9_tree = (Object)adaptor.create(char_literal9);
			adaptor.addChild(root_0, char_literal9_tree);

			char_literal10=(Token)match(input,11,FOLLOW_11_in_canvasStmt95); 
			char_literal10_tree = (Object)adaptor.create(char_literal10);
			adaptor.addChild(root_0, char_literal10_tree);


			      canvasDefined = true;
			      System.out.println("Canvas created: " + (width!=null?width.getText():null) + "x" + (height!=null?height.getText():null));
			    
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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:27:1: colorDef : 'DEF' ID '=' HEX_COLOR ';' ;
	public final GeoScriptGrammarParser.colorDef_return colorDef() throws RecognitionException {
		GeoScriptGrammarParser.colorDef_return retval = new GeoScriptGrammarParser.colorDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal11=null;
		Token ID12=null;
		Token char_literal13=null;
		Token HEX_COLOR14=null;
		Token char_literal15=null;

		Object string_literal11_tree=null;
		Object ID12_tree=null;
		Object char_literal13_tree=null;
		Object HEX_COLOR14_tree=null;
		Object char_literal15_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:28:3: ( 'DEF' ID '=' HEX_COLOR ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:28:5: 'DEF' ID '=' HEX_COLOR ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal11=(Token)match(input,16,FOLLOW_16_in_colorDef114); 
			string_literal11_tree = (Object)adaptor.create(string_literal11);
			adaptor.addChild(root_0, string_literal11_tree);

			ID12=(Token)match(input,ID,FOLLOW_ID_in_colorDef116); 
			ID12_tree = (Object)adaptor.create(ID12);
			adaptor.addChild(root_0, ID12_tree);

			char_literal13=(Token)match(input,12,FOLLOW_12_in_colorDef118); 
			char_literal13_tree = (Object)adaptor.create(char_literal13);
			adaptor.addChild(root_0, char_literal13_tree);

			HEX_COLOR14=(Token)match(input,HEX_COLOR,FOLLOW_HEX_COLOR_in_colorDef120); 
			HEX_COLOR14_tree = (Object)adaptor.create(HEX_COLOR14);
			adaptor.addChild(root_0, HEX_COLOR14_tree);

			char_literal15=(Token)match(input,11,FOLLOW_11_in_colorDef122); 
			char_literal15_tree = (Object)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);

			 colorTable.put((ID12!=null?ID12.getText():null), (HEX_COLOR14!=null?HEX_COLOR14.getText():null)); 
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


	public static class shapeStmt_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "shapeStmt"
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:32:1: shapeStmt : ( rectStmt | circleStmt | lineStmt );
	public final GeoScriptGrammarParser.shapeStmt_return shapeStmt() throws RecognitionException {
		GeoScriptGrammarParser.shapeStmt_return retval = new GeoScriptGrammarParser.shapeStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rectStmt16 =null;
		ParserRuleReturnScope circleStmt17 =null;
		ParserRuleReturnScope lineStmt18 =null;


		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:32:13: ( rectStmt | circleStmt | lineStmt )
			int alt3=3;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt3=1;
				}
				break;
			case 15:
				{
				alt3=2;
				}
				break;
			case 19:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:32:15: rectStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rectStmt_in_shapeStmt141);
					rectStmt16=rectStmt();
					state._fsp--;

					adaptor.addChild(root_0, rectStmt16.getTree());

					}
					break;
				case 2 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:32:26: circleStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_circleStmt_in_shapeStmt145);
					circleStmt17=circleStmt();
					state._fsp--;

					adaptor.addChild(root_0, circleStmt17.getTree());

					}
					break;
				case 3 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:32:39: lineStmt
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_lineStmt_in_shapeStmt149);
					lineStmt18=lineStmt();
					state._fsp--;

					adaptor.addChild(root_0, lineStmt18.getTree());

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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:34:1: rectStmt : 'RECT' 'AT' '(' INT ',' INT ')' 'SIZE' '(' INT ',' INT ')' ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptGrammarParser.rectStmt_return rectStmt() throws RecognitionException {
		GeoScriptGrammarParser.rectStmt_return retval = new GeoScriptGrammarParser.rectStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal19=null;
		Token string_literal20=null;
		Token char_literal21=null;
		Token INT22=null;
		Token char_literal23=null;
		Token INT24=null;
		Token char_literal25=null;
		Token string_literal26=null;
		Token char_literal27=null;
		Token INT28=null;
		Token char_literal29=null;
		Token INT30=null;
		Token char_literal31=null;
		Token string_literal32=null;
		Token set33=null;
		Token string_literal34=null;
		Token set35=null;
		Token char_literal36=null;

		Object string_literal19_tree=null;
		Object string_literal20_tree=null;
		Object char_literal21_tree=null;
		Object INT22_tree=null;
		Object char_literal23_tree=null;
		Object INT24_tree=null;
		Object char_literal25_tree=null;
		Object string_literal26_tree=null;
		Object char_literal27_tree=null;
		Object INT28_tree=null;
		Object char_literal29_tree=null;
		Object INT30_tree=null;
		Object char_literal31_tree=null;
		Object string_literal32_tree=null;
		Object set33_tree=null;
		Object string_literal34_tree=null;
		Object set35_tree=null;
		Object char_literal36_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:35:3: ( 'RECT' 'AT' '(' INT ',' INT ')' 'SIZE' '(' INT ',' INT ')' ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:35:5: 'RECT' 'AT' '(' INT ',' INT ')' 'SIZE' '(' INT ',' INT ')' ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal19=(Token)match(input,21,FOLLOW_21_in_rectStmt160); 
			string_literal19_tree = (Object)adaptor.create(string_literal19);
			adaptor.addChild(root_0, string_literal19_tree);

			string_literal20=(Token)match(input,13,FOLLOW_13_in_rectStmt162); 
			string_literal20_tree = (Object)adaptor.create(string_literal20);
			adaptor.addChild(root_0, string_literal20_tree);

			char_literal21=(Token)match(input,8,FOLLOW_8_in_rectStmt164); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);

			INT22=(Token)match(input,INT,FOLLOW_INT_in_rectStmt166); 
			INT22_tree = (Object)adaptor.create(INT22);
			adaptor.addChild(root_0, INT22_tree);

			char_literal23=(Token)match(input,10,FOLLOW_10_in_rectStmt168); 
			char_literal23_tree = (Object)adaptor.create(char_literal23);
			adaptor.addChild(root_0, char_literal23_tree);

			INT24=(Token)match(input,INT,FOLLOW_INT_in_rectStmt170); 
			INT24_tree = (Object)adaptor.create(INT24);
			adaptor.addChild(root_0, INT24_tree);

			char_literal25=(Token)match(input,9,FOLLOW_9_in_rectStmt172); 
			char_literal25_tree = (Object)adaptor.create(char_literal25);
			adaptor.addChild(root_0, char_literal25_tree);

			string_literal26=(Token)match(input,22,FOLLOW_22_in_rectStmt174); 
			string_literal26_tree = (Object)adaptor.create(string_literal26);
			adaptor.addChild(root_0, string_literal26_tree);

			char_literal27=(Token)match(input,8,FOLLOW_8_in_rectStmt176); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			INT28=(Token)match(input,INT,FOLLOW_INT_in_rectStmt178); 
			INT28_tree = (Object)adaptor.create(INT28);
			adaptor.addChild(root_0, INT28_tree);

			char_literal29=(Token)match(input,10,FOLLOW_10_in_rectStmt180); 
			char_literal29_tree = (Object)adaptor.create(char_literal29);
			adaptor.addChild(root_0, char_literal29_tree);

			INT30=(Token)match(input,INT,FOLLOW_INT_in_rectStmt182); 
			INT30_tree = (Object)adaptor.create(INT30);
			adaptor.addChild(root_0, INT30_tree);

			char_literal31=(Token)match(input,9,FOLLOW_9_in_rectStmt184); 
			char_literal31_tree = (Object)adaptor.create(char_literal31);
			adaptor.addChild(root_0, char_literal31_tree);

			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:36:5: ( 'FILL' ( ID | HEX_COLOR ) )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==17) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:36:6: 'FILL' ( ID | HEX_COLOR )
					{
					string_literal32=(Token)match(input,17,FOLLOW_17_in_rectStmt191); 
					string_literal32_tree = (Object)adaptor.create(string_literal32);
					adaptor.addChild(root_0, string_literal32_tree);

					set33=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set33));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:36:30: ( 'STROKE' ( ID | HEX_COLOR ) )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==23) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:36:31: 'STROKE' ( ID | HEX_COLOR )
					{
					string_literal34=(Token)match(input,23,FOLLOW_23_in_rectStmt202); 
					string_literal34_tree = (Object)adaptor.create(string_literal34);
					adaptor.addChild(root_0, string_literal34_tree);

					set35=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set35));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal36=(Token)match(input,11,FOLLOW_11_in_rectStmt212); 
			char_literal36_tree = (Object)adaptor.create(char_literal36);
			adaptor.addChild(root_0, char_literal36_tree);

			 if(!canvasDefined) System.err.println("Error: Canvas not defined before RECT."); 
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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:40:1: circleStmt : 'CIRCLE' 'AT' '(' INT ',' INT ')' 'RADIUS' INT ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';' ;
	public final GeoScriptGrammarParser.circleStmt_return circleStmt() throws RecognitionException {
		GeoScriptGrammarParser.circleStmt_return retval = new GeoScriptGrammarParser.circleStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal37=null;
		Token string_literal38=null;
		Token char_literal39=null;
		Token INT40=null;
		Token char_literal41=null;
		Token INT42=null;
		Token char_literal43=null;
		Token string_literal44=null;
		Token INT45=null;
		Token string_literal46=null;
		Token set47=null;
		Token string_literal48=null;
		Token set49=null;
		Token char_literal50=null;

		Object string_literal37_tree=null;
		Object string_literal38_tree=null;
		Object char_literal39_tree=null;
		Object INT40_tree=null;
		Object char_literal41_tree=null;
		Object INT42_tree=null;
		Object char_literal43_tree=null;
		Object string_literal44_tree=null;
		Object INT45_tree=null;
		Object string_literal46_tree=null;
		Object set47_tree=null;
		Object string_literal48_tree=null;
		Object set49_tree=null;
		Object char_literal50_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:41:3: ( 'CIRCLE' 'AT' '(' INT ',' INT ')' 'RADIUS' INT ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:41:5: 'CIRCLE' 'AT' '(' INT ',' INT ')' 'RADIUS' INT ( 'FILL' ( ID | HEX_COLOR ) )? ( 'STROKE' ( ID | HEX_COLOR ) )? ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal37=(Token)match(input,15,FOLLOW_15_in_circleStmt231); 
			string_literal37_tree = (Object)adaptor.create(string_literal37);
			adaptor.addChild(root_0, string_literal37_tree);

			string_literal38=(Token)match(input,13,FOLLOW_13_in_circleStmt233); 
			string_literal38_tree = (Object)adaptor.create(string_literal38);
			adaptor.addChild(root_0, string_literal38_tree);

			char_literal39=(Token)match(input,8,FOLLOW_8_in_circleStmt235); 
			char_literal39_tree = (Object)adaptor.create(char_literal39);
			adaptor.addChild(root_0, char_literal39_tree);

			INT40=(Token)match(input,INT,FOLLOW_INT_in_circleStmt237); 
			INT40_tree = (Object)adaptor.create(INT40);
			adaptor.addChild(root_0, INT40_tree);

			char_literal41=(Token)match(input,10,FOLLOW_10_in_circleStmt239); 
			char_literal41_tree = (Object)adaptor.create(char_literal41);
			adaptor.addChild(root_0, char_literal41_tree);

			INT42=(Token)match(input,INT,FOLLOW_INT_in_circleStmt241); 
			INT42_tree = (Object)adaptor.create(INT42);
			adaptor.addChild(root_0, INT42_tree);

			char_literal43=(Token)match(input,9,FOLLOW_9_in_circleStmt243); 
			char_literal43_tree = (Object)adaptor.create(char_literal43);
			adaptor.addChild(root_0, char_literal43_tree);

			string_literal44=(Token)match(input,20,FOLLOW_20_in_circleStmt245); 
			string_literal44_tree = (Object)adaptor.create(string_literal44);
			adaptor.addChild(root_0, string_literal44_tree);

			INT45=(Token)match(input,INT,FOLLOW_INT_in_circleStmt247); 
			INT45_tree = (Object)adaptor.create(INT45);
			adaptor.addChild(root_0, INT45_tree);

			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:42:5: ( 'FILL' ( ID | HEX_COLOR ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==17) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:42:6: 'FILL' ( ID | HEX_COLOR )
					{
					string_literal46=(Token)match(input,17,FOLLOW_17_in_circleStmt254); 
					string_literal46_tree = (Object)adaptor.create(string_literal46);
					adaptor.addChild(root_0, string_literal46_tree);

					set47=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set47));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:42:30: ( 'STROKE' ( ID | HEX_COLOR ) )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==23) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:42:31: 'STROKE' ( ID | HEX_COLOR )
					{
					string_literal48=(Token)match(input,23,FOLLOW_23_in_circleStmt265); 
					string_literal48_tree = (Object)adaptor.create(string_literal48);
					adaptor.addChild(root_0, string_literal48_tree);

					set49=input.LT(1);
					if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set49));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			char_literal50=(Token)match(input,11,FOLLOW_11_in_circleStmt275); 
			char_literal50_tree = (Object)adaptor.create(char_literal50);
			adaptor.addChild(root_0, char_literal50_tree);

			 if(!canvasDefined) System.err.println("Error: Canvas not defined before CIRCLE."); 
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
	// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:46:1: lineStmt : 'LINE' 'FROM' '(' INT ',' INT ')' 'TO' '(' INT ',' INT ')' 'STROKE' ( ID | HEX_COLOR ) ';' ;
	public final GeoScriptGrammarParser.lineStmt_return lineStmt() throws RecognitionException {
		GeoScriptGrammarParser.lineStmt_return retval = new GeoScriptGrammarParser.lineStmt_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal51=null;
		Token string_literal52=null;
		Token char_literal53=null;
		Token INT54=null;
		Token char_literal55=null;
		Token INT56=null;
		Token char_literal57=null;
		Token string_literal58=null;
		Token char_literal59=null;
		Token INT60=null;
		Token char_literal61=null;
		Token INT62=null;
		Token char_literal63=null;
		Token string_literal64=null;
		Token set65=null;
		Token char_literal66=null;

		Object string_literal51_tree=null;
		Object string_literal52_tree=null;
		Object char_literal53_tree=null;
		Object INT54_tree=null;
		Object char_literal55_tree=null;
		Object INT56_tree=null;
		Object char_literal57_tree=null;
		Object string_literal58_tree=null;
		Object char_literal59_tree=null;
		Object INT60_tree=null;
		Object char_literal61_tree=null;
		Object INT62_tree=null;
		Object char_literal63_tree=null;
		Object string_literal64_tree=null;
		Object set65_tree=null;
		Object char_literal66_tree=null;

		try {
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:47:3: ( 'LINE' 'FROM' '(' INT ',' INT ')' 'TO' '(' INT ',' INT ')' 'STROKE' ( ID | HEX_COLOR ) ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:47:5: 'LINE' 'FROM' '(' INT ',' INT ')' 'TO' '(' INT ',' INT ')' 'STROKE' ( ID | HEX_COLOR ) ';'
			{
			root_0 = (Object)adaptor.nil();


			string_literal51=(Token)match(input,19,FOLLOW_19_in_lineStmt294); 
			string_literal51_tree = (Object)adaptor.create(string_literal51);
			adaptor.addChild(root_0, string_literal51_tree);

			string_literal52=(Token)match(input,18,FOLLOW_18_in_lineStmt296); 
			string_literal52_tree = (Object)adaptor.create(string_literal52);
			adaptor.addChild(root_0, string_literal52_tree);

			char_literal53=(Token)match(input,8,FOLLOW_8_in_lineStmt298); 
			char_literal53_tree = (Object)adaptor.create(char_literal53);
			adaptor.addChild(root_0, char_literal53_tree);

			INT54=(Token)match(input,INT,FOLLOW_INT_in_lineStmt300); 
			INT54_tree = (Object)adaptor.create(INT54);
			adaptor.addChild(root_0, INT54_tree);

			char_literal55=(Token)match(input,10,FOLLOW_10_in_lineStmt302); 
			char_literal55_tree = (Object)adaptor.create(char_literal55);
			adaptor.addChild(root_0, char_literal55_tree);

			INT56=(Token)match(input,INT,FOLLOW_INT_in_lineStmt304); 
			INT56_tree = (Object)adaptor.create(INT56);
			adaptor.addChild(root_0, INT56_tree);

			char_literal57=(Token)match(input,9,FOLLOW_9_in_lineStmt306); 
			char_literal57_tree = (Object)adaptor.create(char_literal57);
			adaptor.addChild(root_0, char_literal57_tree);

			string_literal58=(Token)match(input,24,FOLLOW_24_in_lineStmt308); 
			string_literal58_tree = (Object)adaptor.create(string_literal58);
			adaptor.addChild(root_0, string_literal58_tree);

			char_literal59=(Token)match(input,8,FOLLOW_8_in_lineStmt310); 
			char_literal59_tree = (Object)adaptor.create(char_literal59);
			adaptor.addChild(root_0, char_literal59_tree);

			INT60=(Token)match(input,INT,FOLLOW_INT_in_lineStmt312); 
			INT60_tree = (Object)adaptor.create(INT60);
			adaptor.addChild(root_0, INT60_tree);

			char_literal61=(Token)match(input,10,FOLLOW_10_in_lineStmt314); 
			char_literal61_tree = (Object)adaptor.create(char_literal61);
			adaptor.addChild(root_0, char_literal61_tree);

			INT62=(Token)match(input,INT,FOLLOW_INT_in_lineStmt316); 
			INT62_tree = (Object)adaptor.create(INT62);
			adaptor.addChild(root_0, INT62_tree);

			char_literal63=(Token)match(input,9,FOLLOW_9_in_lineStmt318); 
			char_literal63_tree = (Object)adaptor.create(char_literal63);
			adaptor.addChild(root_0, char_literal63_tree);

			string_literal64=(Token)match(input,23,FOLLOW_23_in_lineStmt320); 
			string_literal64_tree = (Object)adaptor.create(string_literal64);
			adaptor.addChild(root_0, string_literal64_tree);

			set65=input.LT(1);
			if ( (input.LA(1) >= HEX_COLOR && input.LA(1) <= ID) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set65));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal66=(Token)match(input,11,FOLLOW_11_in_lineStmt328); 
			char_literal66_tree = (Object)adaptor.create(char_literal66);
			adaptor.addChild(root_0, char_literal66_tree);

			 if(!canvasDefined) System.err.println("Error: Canvas not defined before LINE."); 
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

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_prog46 = new BitSet(new long[]{0x000000000029C000L});
	public static final BitSet FOLLOW_EOF_in_prog50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_canvasStmt_in_statement60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_colorDef_in_statement64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shapeStmt_in_statement68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_canvasStmt79 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_canvasStmt81 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_canvasStmt85 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_canvasStmt87 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_canvasStmt91 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_canvasStmt93 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_canvasStmt95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_colorDef114 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_colorDef116 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_colorDef118 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_HEX_COLOR_in_colorDef120 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_colorDef122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rectStmt_in_shapeStmt141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_circleStmt_in_shapeStmt145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lineStmt_in_shapeStmt149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_rectStmt160 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_rectStmt162 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_rectStmt164 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_rectStmt166 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_rectStmt168 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_rectStmt170 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_rectStmt172 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_rectStmt174 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_rectStmt176 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_rectStmt178 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_rectStmt180 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_rectStmt182 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_rectStmt184 = new BitSet(new long[]{0x0000000000820800L});
	public static final BitSet FOLLOW_17_in_rectStmt191 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_rectStmt193 = new BitSet(new long[]{0x0000000000800800L});
	public static final BitSet FOLLOW_23_in_rectStmt202 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_rectStmt204 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_rectStmt212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_circleStmt231 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_circleStmt233 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_circleStmt235 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_circleStmt237 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_circleStmt239 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_circleStmt241 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_circleStmt243 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_circleStmt245 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_circleStmt247 = new BitSet(new long[]{0x0000000000820800L});
	public static final BitSet FOLLOW_17_in_circleStmt254 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_circleStmt256 = new BitSet(new long[]{0x0000000000800800L});
	public static final BitSet FOLLOW_23_in_circleStmt265 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_circleStmt267 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_circleStmt275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_lineStmt294 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_lineStmt296 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_lineStmt298 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_lineStmt300 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lineStmt302 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_lineStmt304 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lineStmt306 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_lineStmt308 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_lineStmt310 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_lineStmt312 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lineStmt314 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_lineStmt316 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lineStmt318 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_lineStmt320 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_lineStmt322 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_lineStmt328 = new BitSet(new long[]{0x0000000000000002L});
}
