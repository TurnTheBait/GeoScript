// $ANTLR 3.5.1 /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g 2025-11-07 16:35:11

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GeoScriptGrammarLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public GeoScriptGrammarLexer() {} 
	public GeoScriptGrammarLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public GeoScriptGrammarLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g"; }

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:7:6: ( '(' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:7:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:8:6: ( ')' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:8:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:9:7: ( ',' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:9:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:10:7: ( ';' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:10:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:11:7: ( '=' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:11:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:12:7: ( 'AT' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:12:9: 'AT'
			{
			match("AT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:13:7: ( 'CANVAS' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:13:9: 'CANVAS'
			{
			match("CANVAS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:14:7: ( 'CIRCLE' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:14:9: 'CIRCLE'
			{
			match("CIRCLE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:15:7: ( 'DEF' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:15:9: 'DEF'
			{
			match("DEF"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:7: ( 'FILL' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:16:9: 'FILL'
			{
			match("FILL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:7: ( 'FROM' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:17:9: 'FROM'
			{
			match("FROM"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:18:7: ( 'LINE' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:18:9: 'LINE'
			{
			match("LINE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:19:7: ( 'RADIUS' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:19:9: 'RADIUS'
			{
			match("RADIUS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:20:7: ( 'RECT' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:20:9: 'RECT'
			{
			match("RECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:21:7: ( 'SIZE' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:21:9: 'SIZE'
			{
			match("SIZE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:22:7: ( 'STROKE' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:22:9: 'STROKE'
			{
			match("STROKE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:23:7: ( 'TO' )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:23:9: 'TO'
			{
			match("TO"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "HEX_COLOR"
	public final void mHEX_COLOR() throws RecognitionException {
		try {
			int _type = HEX_COLOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:51:11: ( '#' ( ( 'A' .. 'F' ) | ( 'a' .. 'f' ) | ( '0' .. '9' ) )+ )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:51:13: '#' ( ( 'A' .. 'F' ) | ( 'a' .. 'f' ) | ( '0' .. '9' ) )+
			{
			match('#'); 
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:51:17: ( ( 'A' .. 'F' ) | ( 'a' .. 'f' ) | ( '0' .. '9' ) )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'F')||(LA1_0 >= 'a' && LA1_0 <= 'f')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_COLOR"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:52:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:52:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:52:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:53:11: ( ( '0' .. '9' )+ )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:53:13: ( '0' .. '9' )+
			{
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:53:13: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:54:11: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:54:13: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:54:13: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | HEX_COLOR | ID | INT | WS )
		int alt5=21;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:44: T__14
				{
				mT__14(); 

				}
				break;
			case 8 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:50: T__15
				{
				mT__15(); 

				}
				break;
			case 9 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:56: T__16
				{
				mT__16(); 

				}
				break;
			case 10 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:62: T__17
				{
				mT__17(); 

				}
				break;
			case 11 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:68: T__18
				{
				mT__18(); 

				}
				break;
			case 12 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:74: T__19
				{
				mT__19(); 

				}
				break;
			case 13 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:80: T__20
				{
				mT__20(); 

				}
				break;
			case 14 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:86: T__21
				{
				mT__21(); 

				}
				break;
			case 15 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:92: T__22
				{
				mT__22(); 

				}
				break;
			case 16 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:98: T__23
				{
				mT__23(); 

				}
				break;
			case 17 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:104: T__24
				{
				mT__24(); 

				}
				break;
			case 18 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:110: HEX_COLOR
				{
				mHEX_COLOR(); 

				}
				break;
			case 19 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:120: ID
				{
				mID(); 

				}
				break;
			case 20 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:123: INT
				{
				mINT(); 

				}
				break;
			case 21 :
				// /Users/matteocesari/Documents/Università/5° anno/Linguaggi Formali e Compilatori/Progetto LFC/GeoScript/GeoScriptGrammar.g:1:127: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\6\uffff\10\17\4\uffff\1\36\12\17\1\51\1\uffff\2\17\1\54\7\17\1\uffff"+
		"\2\17\1\uffff\1\66\1\67\1\70\1\17\1\72\1\73\3\17\3\uffff\1\17\2\uffff"+
		"\1\17\1\101\1\102\1\103\1\104\4\uffff";
	static final String DFA5_eofS =
		"\105\uffff";
	static final String DFA5_minS =
		"\1\11\5\uffff\1\124\1\101\1\105\2\111\1\101\1\111\1\117\4\uffff\1\60\1"+
		"\116\1\122\1\106\1\114\1\117\1\116\1\104\1\103\1\132\1\122\1\60\1\uffff"+
		"\1\126\1\103\1\60\1\114\1\115\1\105\1\111\1\124\1\105\1\117\1\uffff\1"+
		"\101\1\114\1\uffff\3\60\1\125\2\60\1\113\1\123\1\105\3\uffff\1\123\2\uffff"+
		"\1\105\4\60\4\uffff";
	static final String DFA5_maxS =
		"\1\172\5\uffff\1\124\1\111\1\105\1\122\1\111\1\105\1\124\1\117\4\uffff"+
		"\1\172\1\116\1\122\1\106\1\114\1\117\1\116\1\104\1\103\1\132\1\122\1\172"+
		"\1\uffff\1\126\1\103\1\172\1\114\1\115\1\105\1\111\1\124\1\105\1\117\1"+
		"\uffff\1\101\1\114\1\uffff\3\172\1\125\2\172\1\113\1\123\1\105\3\uffff"+
		"\1\123\2\uffff\1\105\4\172\4\uffff";
	static final String DFA5_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\10\uffff\1\22\1\23\1\24\1\25\14\uffff\1\6"+
		"\12\uffff\1\21\2\uffff\1\11\11\uffff\1\12\1\13\1\14\1\uffff\1\16\1\17"+
		"\5\uffff\1\7\1\10\1\15\1\20";
	static final String DFA5_specialS =
		"\105\uffff}>";
	static final String[] DFA5_transitionS = {
			"\2\21\2\uffff\1\21\22\uffff\1\21\2\uffff\1\16\4\uffff\1\1\1\2\2\uffff"+
			"\1\3\3\uffff\12\20\1\uffff\1\4\1\uffff\1\5\3\uffff\1\6\1\17\1\7\1\10"+
			"\1\17\1\11\5\17\1\12\5\17\1\13\1\14\1\15\6\17\4\uffff\1\17\1\uffff\32"+
			"\17",
			"",
			"",
			"",
			"",
			"",
			"\1\22",
			"\1\23\7\uffff\1\24",
			"\1\25",
			"\1\26\10\uffff\1\27",
			"\1\30",
			"\1\31\3\uffff\1\32",
			"\1\33\12\uffff\1\34",
			"\1\35",
			"",
			"",
			"",
			"",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\43",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"",
			"\1\52",
			"\1\53",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"\1\64",
			"\1\65",
			"",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\1\71",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\1\74",
			"\1\75",
			"\1\76",
			"",
			"",
			"",
			"\1\77",
			"",
			"",
			"\1\100",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
			"",
			"",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | HEX_COLOR | ID | INT | WS );";
		}
	}

}
