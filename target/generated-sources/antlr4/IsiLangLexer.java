// Generated from IsiLang.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, AP=9, 
		FP=10, SC=11, OP=12, ATTR=13, VIR=14, ACH=15, FCH=16, OPREL=17, ID=18, 
		NUMBER=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "AP", 
		"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
		"WS"
	};


		private int _tipo;
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
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol " + id + " not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22z\n\22\3\23\3\23\7\23~\n\23\f\23\16\23\u0081\13"+
		"\23\3\24\6\24\u0084\n\24\r\24\16\24\u0085\3\24\3\24\6\24\u008a\n\24\r"+
		"\24\16\24\u008b\5\24\u008e\n\24\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5"+
		"\2\13\f\17\17\"\"\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2"+
		"\2\5.\3\2\2\2\7\66\3\2\2\2\t?\3\2\2\2\13E\3\2\2\2\rL\3\2\2\2\17U\3\2\2"+
		"\2\21Z\3\2\2\2\23`\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31f\3\2\2\2\33h\3\2"+
		"\2\2\35j\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'\u0083\3\2"+
		"\2\2)\u008f\3\2\2\2+,\7u\2\2,-\7g\2\2-\4\3\2\2\2./\7g\2\2/\60\7u\2\2\60"+
		"\61\7e\2\2\61\62\7t\2\2\62\63\7g\2\2\63\64\7x\2\2\64\65\7c\2\2\65\6\3"+
		"\2\2\2\66\67\7h\2\2\678\7k\2\289\7o\2\29:\7r\2\2:;\7t\2\2;<\7q\2\2<=\7"+
		"i\2\2=>\7=\2\2>\b\3\2\2\2?@\7u\2\2@A\7g\2\2AB\7p\2\2BC\7c\2\2CD\7q\2\2"+
		"D\n\3\2\2\2EF\7p\2\2FG\7w\2\2GH\7o\2\2HI\7g\2\2IJ\7t\2\2JK\7q\2\2K\f\3"+
		"\2\2\2LM\7r\2\2MN\7t\2\2NO\7q\2\2OP\7i\2\2PQ\7t\2\2QR\7c\2\2RS\7o\2\2"+
		"ST\7c\2\2T\16\3\2\2\2UV\7n\2\2VW\7g\2\2WX\7k\2\2XY\7c\2\2Y\20\3\2\2\2"+
		"Z[\7v\2\2[\\\7g\2\2\\]\7z\2\2]^\7v\2\2^_\7q\2\2_\22\3\2\2\2`a\7*\2\2a"+
		"\24\3\2\2\2bc\7+\2\2c\26\3\2\2\2de\7=\2\2e\30\3\2\2\2fg\t\2\2\2g\32\3"+
		"\2\2\2hi\7?\2\2i\34\3\2\2\2jk\7.\2\2k\36\3\2\2\2lm\7}\2\2m \3\2\2\2no"+
		"\7\177\2\2o\"\3\2\2\2pz\t\3\2\2qr\7@\2\2rz\7?\2\2st\7>\2\2tz\7?\2\2uv"+
		"\7?\2\2vz\7?\2\2wx\7#\2\2xz\7?\2\2yp\3\2\2\2yq\3\2\2\2ys\3\2\2\2yu\3\2"+
		"\2\2yw\3\2\2\2z$\3\2\2\2{\177\t\4\2\2|~\t\5\2\2}|\3\2\2\2~\u0081\3\2\2"+
		"\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080&\3\2\2\2\u0081\177\3\2\2\2\u0082"+
		"\u0084\t\6\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u008d\3\2\2\2\u0087\u0089\7\60\2\2\u0088"+
		"\u008a\t\6\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u0087\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e(\3\2\2\2\u008f\u0090\t\7\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\u0092\b\25\2\2\u0092*\3\2\2\2\t\2y}\177\u0085\u008b\u008d\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}