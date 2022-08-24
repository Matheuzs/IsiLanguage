// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.isilanguage.parser;

	import br.com.isilanguage.datastructures.IsiSymbol;
	import br.com.isilanguage.datastructures.IsiVariable;
	import br.com.isilanguage.datastructures.IsiSymbolTable;
	import br.com.isilanguage.exceptions.IsiSemanticException;
	import br.com.isilanguage.ast.IsiProgram;
	import br.com.isilanguage.ast.AbstractCommand;
	import br.com.isilanguage.ast.CommandLeitura;
	import br.com.isilanguage.ast.CommandEscrita;
	import br.com.isilanguage.ast.CommandAtribuicao;
	import br.com.isilanguage.ast.CommandDecisao;
	import br.com.isilanguage.ast.CommandEnquanto;
	import br.com.isilanguage.ast.CommandEscolha;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, AP=13, ASP=14, FP=15, SC=16, DD=17, OP=18, 
		ATTR=19, VIR=20, ACH=21, FCH=22, OPREL=23, BOOLEAN=24, ID=25, NUMBER=26, 
		STR=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "AP", "ASP", "FP", "SC", "DD", "OP", "ATTR", 
		"VIR", "ACH", "FCH", "OPREL", "BOOLEAN", "ID", "NUMBER", "STR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", "'escolha'", "'caso'", 
		"'('", "'\"'", "')'", "';'", "':'", null, "'='", "','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "AP", "ASP", "FP", "SC", "DD", "OP", "ATTR", "VIR", "ACH", "FCH", 
		"OPREL", "BOOLEAN", "ID", "NUMBER", "STR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		private int _tipo;
		private int _receiverTipo;
		private int _termoTipo;
		private int _exprTipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<ArrayList<AbstractCommand>> switchCommands;
		private ArrayList<String> listaCases;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol " + id + " not declared");
			}
		}
		
		public void verificaInicializado(String id){
			if (!symbolTable.get(id).hasBeenInitialized()){
				throw new IsiSemanticException("Symbol " + id + " not initialized");
			}
		}
		
		public int getSymbolType(String id) {
			IsiVariable var = (IsiVariable) symbolTable.get(id);
	        return var.getType();
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode() {
			program.generateTarget();
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00ad\n\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u00be\n\31\3\32\3\32\7\32\u00c2\n\32\f\32\16\32\u00c5\13\32\3\33"+
		"\6\33\u00c8\n\33\r\33\16\33\u00c9\3\33\3\33\6\33\u00ce\n\33\r\33\16\33"+
		"\u00cf\5\33\u00d2\n\33\3\34\3\34\5\34\u00d6\n\34\3\34\3\34\6\34\u00da"+
		"\n\34\r\34\16\34\u00db\3\34\3\34\3\35\3\35\3\35\3\35\2\2\36\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\t\5\2,-"+
		"//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\4\2C\\c|\5\2\13\f\17\17\""+
		"\"\2\u00ed\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\3;\3\2\2\2\5D\3\2\2\2\7M\3\2\2\2\tT\3\2\2\2\13Z\3\2\2\2\rc\3\2\2"+
		"\2\17h\3\2\2\2\21p\3\2\2\2\23s\3\2\2\2\25y\3\2\2\2\27\u0082\3\2\2\2\31"+
		"\u008a\3\2\2\2\33\u008f\3\2\2\2\35\u0091\3\2\2\2\37\u0093\3\2\2\2!\u0095"+
		"\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b\3\2\2\2)\u009d\3\2\2\2"+
		"+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00ac\3\2\2\2\61\u00bd\3\2\2\2\63\u00bf"+
		"\3\2\2\2\65\u00c7\3\2\2\2\67\u00d3\3\2\2\29\u00df\3\2\2\2;<\7r\2\2<=\7"+
		"t\2\2=>\7q\2\2>?\7i\2\2?@\7t\2\2@A\7c\2\2AB\7o\2\2BC\7c\2\2C\4\3\2\2\2"+
		"DE\7h\2\2EF\7k\2\2FG\7o\2\2GH\7r\2\2HI\7t\2\2IJ\7q\2\2JK\7i\2\2KL\7=\2"+
		"\2L\6\3\2\2\2MN\7p\2\2NO\7w\2\2OP\7o\2\2PQ\7g\2\2QR\7t\2\2RS\7q\2\2S\b"+
		"\3\2\2\2TU\7v\2\2UV\7g\2\2VW\7z\2\2WX\7v\2\2XY\7q\2\2Y\n\3\2\2\2Z[\7d"+
		"\2\2[\\\7q\2\2\\]\7q\2\2]^\7n\2\2^_\7g\2\2_`\7c\2\2`a\7p\2\2ab\7q\2\2"+
		"b\f\3\2\2\2cd\7n\2\2de\7g\2\2ef\7k\2\2fg\7c\2\2g\16\3\2\2\2hi\7g\2\2i"+
		"j\7u\2\2jk\7e\2\2kl\7t\2\2lm\7g\2\2mn\7x\2\2no\7c\2\2o\20\3\2\2\2pq\7"+
		"u\2\2qr\7g\2\2r\22\3\2\2\2st\7u\2\2tu\7g\2\2uv\7p\2\2vw\7c\2\2wx\7q\2"+
		"\2x\24\3\2\2\2yz\7g\2\2z{\7p\2\2{|\7s\2\2|}\7w\2\2}~\7c\2\2~\177\7p\2"+
		"\2\177\u0080\7v\2\2\u0080\u0081\7q\2\2\u0081\26\3\2\2\2\u0082\u0083\7"+
		"g\2\2\u0083\u0084\7u\2\2\u0084\u0085\7e\2\2\u0085\u0086\7q\2\2\u0086\u0087"+
		"\7n\2\2\u0087\u0088\7j\2\2\u0088\u0089\7c\2\2\u0089\30\3\2\2\2\u008a\u008b"+
		"\7e\2\2\u008b\u008c\7c\2\2\u008c\u008d\7u\2\2\u008d\u008e\7q\2\2\u008e"+
		"\32\3\2\2\2\u008f\u0090\7*\2\2\u0090\34\3\2\2\2\u0091\u0092\7$\2\2\u0092"+
		"\36\3\2\2\2\u0093\u0094\7+\2\2\u0094 \3\2\2\2\u0095\u0096\7=\2\2\u0096"+
		"\"\3\2\2\2\u0097\u0098\7<\2\2\u0098$\3\2\2\2\u0099\u009a\t\2\2\2\u009a"+
		"&\3\2\2\2\u009b\u009c\7?\2\2\u009c(\3\2\2\2\u009d\u009e\7.\2\2\u009e*"+
		"\3\2\2\2\u009f\u00a0\7}\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7\177\2\2\u00a2"+
		".\3\2\2\2\u00a3\u00ad\t\3\2\2\u00a4\u00a5\7@\2\2\u00a5\u00ad\7?\2\2\u00a6"+
		"\u00a7\7>\2\2\u00a7\u00ad\7?\2\2\u00a8\u00a9\7?\2\2\u00a9\u00ad\7?\2\2"+
		"\u00aa\u00ab\7#\2\2\u00ab\u00ad\7?\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a4"+
		"\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\60\3\2\2\2\u00ae\u00af\7x\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7t\2\2\u00b1"+
		"\u00b2\7f\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7f\2\2\u00b4\u00b5\7g\2\2"+
		"\u00b5\u00b6\7k\2\2\u00b6\u00b7\7t\2\2\u00b7\u00be\7q\2\2\u00b8\u00b9"+
		"\7h\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7u\2\2\u00bc"+
		"\u00be\7q\2\2\u00bd\u00ae\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be\62\3\2\2\2"+
		"\u00bf\u00c3\t\4\2\2\u00c0\u00c2\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\64\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c8\t\6\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d1\3\2\2\2\u00cb"+
		"\u00cd\7\60\2\2\u00cc\u00ce\t\6\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00cb\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\66\3\2\2\2\u00d3\u00d5\5\35\17"+
		"\2\u00d4\u00d6\t\7\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00da"+
		"\t\5\2\2\u00d8\u00da\59\35\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00de\5\35\17\2\u00de8\3\2\2\2\u00df\u00e0\t\b\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\b\35\2\2\u00e2:\3\2\2\2\r\2\u00ac\u00bd\u00c1\u00c3"+
		"\u00c9\u00cf\u00d1\u00d5\u00d9\u00db\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}