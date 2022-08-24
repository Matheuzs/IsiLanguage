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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, AP=13, ASP=14, FP=15, SC=16, DD=17, OP=18, 
		ATTR=19, VIR=20, ACH=21, FCH=22, OPREL=23, BOOLEAN=24, STR=25, ID=26, 
		NUMBER=27, WS=28;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdenquanto = 10, RULE_cmdswitch = 11, RULE_expr = 12, 
		RULE_termo = 13;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdenquanto", "cmdswitch", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", "'escolha'", "'caso'", 
		"'('", "'\"'", "')'", "';'", "':'", null, "'='", "','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "AP", "ASP", "FP", "SC", "DD", "OP", "ATTR", "VIR", "ACH", "FCH", 
		"OPREL", "BOOLEAN", "STR", "ID", "NUMBER", "WS"
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

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private int _receiverTipo;
		private int _termoTipo;
		private int _exprTipo;
		private String _savedValue;
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

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			bloco();
			setState(31);
			match(T__1);

					  	program.setVarTable(symbolTable);
					  	program.setComandos(stack.pop());
							for(IsiSymbol symbol: symbolTable.getAll()){
								if (!symbol.hasBeenUsed()){
									System.out.println("WARNING: Variable " + symbol.getName() + " was declared but not used.");
								}
							}
					  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaravar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			tipo();
			setState(40);
			match(ID);

								_varName = _input.LT(-1).getText();
								_varValue = null;
								symbol = new IsiVariable(_varName, _tipo, _varValue);
								if (!symbolTable.exists(_varName)) {
									symbolTable.add(symbol);	
								}
								else {
									throw new IsiSemanticException("Symbol " + _varName + " already declared");
								}
							
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);

										_varName = _input.LT(-1).getText();
										_varValue = null;
										symbol = new IsiVariable(_varName, _tipo, _varValue);
										if (!symbolTable.exists(_varName)) {
											symbolTable.add(symbol);	
										}
										else {
											throw new IsiSemanticException("Symbol " + _varName + " already declared");
										}
									
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = IsiVariable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = IsiVariable.TEXT; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = IsiVariable.BOOLEAN; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
						curThread = new ArrayList<AbstractCommand>();
						stack.push(curThread);
					
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				cmd();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdswitchContext cmdswitch() {
			return getRuleContext(CmdswitchContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdenquanto();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdswitch();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__5);
			setState(75);
			match(AP);
			setState(76);
			match(ID);
			 
								 	verificaID(_input.LT(-1).getText());
								 	_readID = _input.LT(-1).getText();
									symbolTable.get(_readID).setUsed();
									symbolTable.get(_readID).setInitialized();
								 
			setState(78);
			match(FP);
			setState(79);
			match(SC);

								IsiVariable var = (IsiVariable) symbolTable.get(_readID);
								CommandLeitura cmd = new CommandLeitura(_readID, var);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__6);
			setState(83);
			match(AP);
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(84);
				match(ID);
				 
											verificaID(_input.LT(-1).getText());
											verificaInicializado(_input.LT(-1).getText());
											_writeID = _input.LT(-1).getText();
											symbolTable.get(_writeID).setUsed();
										
				}
				break;
			case STR:
				{
				setState(86);
				match(STR);
				_writeID = _input.LT(-1).getText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(90);
			match(FP);
			setState(91);
			match(SC);

								CommandEscrita cmd = new CommandEscrita(_writeID);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			_exprID = _input.LT(-1).getText();
					verificaID(_exprID);
			        _receiverTipo = getSymbolType(_exprID);
			        symbolTable.get(_exprID).setInitialized();
			      
			setState(96);
			match(ATTR);
			 _exprContent = ""; 
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(98);
				expr();
				if (_receiverTipo != _exprTipo)
						 throw new IsiSemanticException("Can not assign expression of type \"" + IsiVariable.getTypeText(_exprTipo) + "\" to variable \"" + _exprID + "\" of type \"" + IsiVariable.getTypeText(_receiverTipo) + "\"");
						
				}
				break;
			case 2:
				{
				setState(101);
				match(STR);
				_exprContent += _input.LT(-1).getText();
							 if (_receiverTipo != IsiVariable.TEXT) {
								throw new IsiSemanticException("Can not assign expression of type \"texto\" to variable \"" + _exprID + "\" of type \"" + IsiVariable.getTypeText(_receiverTipo) + "\"");
							 }
							
				}
				break;
			}
			setState(105);
			match(SC);

					CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
					stack.peek().add(cmd);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode BOOLEAN() { return getToken(IsiLangParser.BOOLEAN, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__7);
			setState(109);
			match(AP);
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(110);
				match(ID);
				 
										_exprDecision = _input.LT(-1).getText(); 
										symbolTable.get(_exprDecision).setUsed();
										verificaID(_exprDecision);
										verificaInicializado(_exprDecision);
									 
				setState(112);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(114);
					match(ID);
					verificaID(_input.LT(-1).getText());
									   		verificaInicializado(_input.LT(-1).getText());
									   		symbolTable.get(_input.LT(-1).getText()).setUsed();
									   	   
					}
					break;
				case NUMBER:
					{
					setState(116);
					match(NUMBER);
					}
					break;
				case STR:
					{
					setState(117);
					match(STR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 _savedValue = _exprDecision + _input.LT(-1).getText(); 
				}
				}
				break;
			case 2:
				{
				setState(121);
				match(BOOLEAN);
				_savedValue = _input.LT(-1).getText();
				}
				break;
			case 3:
				{
				setState(123);
				match(ID);
				verificaID(_input.LT(-1).getText());
								   			verificaInicializado(_input.LT(-1).getText());
								   			symbolTable.get(_input.LT(-1).getText()).setUsed();
								   			_savedValue = _input.LT(-1).getText();
								   			_tipo = getSymbolType(_input.LT(-1).getText());
								   			if (_tipo != IsiVariable.BOOLEAN) {
								   				throw new IsiSemanticException("Symbol \"" + _input.LT(-1).getText() + "\" cannot be used as boolean");
								   			}
				}
				break;
			}
			setState(127);
			match(FP);
			setState(128);
			match(ACH);

							   	curThread = new ArrayList<AbstractCommand>();
							   	stack.push(curThread);
							   
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				cmd();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(135);
			match(FCH);

							   	listaTrue = stack.pop();
							   	listaFalse = new ArrayList<AbstractCommand>();
							   
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(137);
				match(T__8);
				setState(138);
				match(ACH);

									curThread = new ArrayList<AbstractCommand>();
				               	 	stack.push(curThread);
							  	
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140);
					cmd();
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
				setState(145);
				match(FCH);

					           		listaFalse = stack.pop();
							  	
				}
			}

				CommandDecisao cmd = new CommandDecisao(_savedValue, listaTrue, listaFalse);
				           		stack.peek().add(cmd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode BOOLEAN() { return getToken(IsiLangParser.BOOLEAN, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdenquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdenquanto(this);
		}
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__9);
			setState(153);
			match(AP);
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(154);
				match(ID);
				 
											_exprDecision = _input.LT(-1).getText(); 
											symbolTable.get(_exprDecision).setUsed();
											verificaID(_exprDecision);
											verificaInicializado(_exprDecision);
										 
				setState(156);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(162);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(158);
					match(ID);
					verificaID(_input.LT(-1).getText());
										   		verificaInicializado(_input.LT(-1).getText());
										   		symbolTable.get(_input.LT(-1).getText()).setUsed();
										   	   
					}
					break;
				case NUMBER:
					{
					setState(160);
					match(NUMBER);
					}
					break;
				case STR:
					{
					setState(161);
					match(STR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 _savedValue = _exprDecision + _input.LT(-1).getText(); 
				}
				}
				break;
			case 2:
				{
				setState(165);
				match(BOOLEAN);
				_savedValue = _input.LT(-1).getText();
				}
				break;
			case 3:
				{
				setState(167);
				match(ID);
				verificaID(_input.LT(-1).getText());
									   			verificaInicializado(_input.LT(-1).getText());
									   			symbolTable.get(_input.LT(-1).getText()).setUsed();
									   			_savedValue = _input.LT(-1).getText();
									   			_tipo = getSymbolType(_input.LT(-1).getText());
									   			if (_tipo != IsiVariable.BOOLEAN) {
									   				throw new IsiSemanticException("Symbol \"" + _input.LT(-1).getText() + "\" cannot be used as boolean");
									   			}
				}
				break;
			}
			setState(171);
			match(FP);
			setState(172);
			match(ACH);

								   		curThread = new ArrayList<AbstractCommand>();
								   		stack.push(curThread);
									 
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				cmd();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(179);
			match(FCH);

									 	CommandEnquanto cmd = new CommandEnquanto(_savedValue, stack.pop());
				           				stack.peek().add(cmd);
									 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdswitchContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public List<TerminalNode> DD() { return getTokens(IsiLangParser.DD); }
		public TerminalNode DD(int i) {
			return getToken(IsiLangParser.DD, i);
		}
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<TerminalNode> STR() { return getTokens(IsiLangParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(IsiLangParser.STR, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdswitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdswitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdswitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdswitch(this);
		}
	}

	public final CmdswitchContext cmdswitch() throws RecognitionException {
		CmdswitchContext _localctx = new CmdswitchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdswitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__10);
			setState(183);
			match(AP);
			listaCases = new ArrayList<String>();
									  switchCommands = new ArrayList<ArrayList<AbstractCommand>>();
									 
			setState(185);
			match(ID);

								  	 _exprDecision = _input.LT(-1).getText();
								  	 verificaID(_exprDecision);
								  	 verificaInicializado(_exprDecision);
									 symbolTable.get(_exprDecision).setUsed();
									 _tipo = getSymbolType(_exprDecision);
								  
			setState(187);
			match(FP);
			setState(188);
			match(ACH);
			setState(189);
			match(T__11);
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(190);
				match(ID);
				verificaID(_input.LT(-1).getText());
									     	  verificaInicializado(_input.LT(-1).getText());
									     	  symbolTable.get(_input.LT(-1).getText()).setUsed();
									     	 
				}
				break;
			case NUMBER:
				{
				setState(192);
				match(NUMBER);
				}
				break;
			case STR:
				{
				setState(193);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			listaCases.add(_input.LT(-1).getText());
			setState(197);
			match(DD);
			curThread = new ArrayList<AbstractCommand>();
			               	 			 stack.push(curThread);
			setState(200); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				cmd();
				}
				}
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			switchCommands.add(stack.pop());
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(205);
				match(T__11);
				setState(210);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(206);
					match(ID);
					verificaID(_input.LT(-1).getText());
										     	  verificaInicializado(_input.LT(-1).getText());
										     	  symbolTable.get(_input.LT(-1).getText()).setUsed();
										     	
					}
					break;
				case NUMBER:
					{
					setState(208);
					match(NUMBER);
					}
					break;
				case STR:
					{
					setState(209);
					match(STR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				listaCases.add(_input.LT(-1).getText());
				setState(213);
				match(DD);
				curThread = new ArrayList<AbstractCommand>();
				               	 			 stack.push(curThread);
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(215);
					cmd();
					}
					}
					setState(218); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
				switchCommands.add(stack.pop());
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(FCH);

								  	CommandEscolha cmd = new CommandEscolha(_exprDecision, listaCases, switchCommands);
								  	stack.peek().add(cmd);
								  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			termo();

							_exprTipo = _termoTipo;
						  
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(232);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(234);
				termo();

									if (_exprTipo != _termoTipo) {
										throw new IsiSemanticException("Inconsistent types at given expression: " + _exprContent);
									}
								
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public TerminalNode BOOLEAN() { return getToken(IsiLangParser.BOOLEAN, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(ID);
				 
								verificaID(_input.LT(-1).getText());
								_exprContent += _input.LT(-1).getText();
								_varName = _input.LT(-1).getText();
								_termoTipo = getSymbolType(_varName);
								symbolTable.get(_varName).setUsed();
								verificaInicializado(_varName);
							  
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(NUMBER);

								_exprContent += _input.LT(-1).getText();
								_termoTipo = IsiVariable.NUMBER;
							
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(STR);

								_exprContent += _input.LT(-1).getText();
								_termoTipo = IsiVariable.TEXT;
							
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(BOOLEAN);

								_exprContent += _input.LT(-1).getText();
								_termoTipo = IsiVariable.BOOLEAN;
							
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				match(AP);
				 
							_exprContent += _input.LT(-1).getText(); 
							
				setState(252);
				expr();
				setState(253);
				match(FP);
				 
							_exprContent += _input.LT(-1).getText(); 
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u0105\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\6\3\6\6\6A\n\6\r\6\16\6"+
		"B\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t[\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\nj\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13y\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13\3\13"+
		"\3\13\3\13\3\13\6\13\u0086\n\13\r\13\16\13\u0087\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\6\13\u0090\n\13\r\13\16\13\u0091\3\13\3\13\3\13\5\13\u0097\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a5\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00ac\n\f\3\f\3\f\3\f\3\f\6\f\u00b2\n\f\r\f\16"+
		"\f\u00b3\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00c5\n\r\3\r\3\r\3\r\3\r\6\r\u00cb\n\r\r\r\16\r\u00cc\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00d5\n\r\3\r\3\r\3\r\3\r\6\r\u00db\n\r\r\r\16\r\u00dc"+
		"\3\r\3\r\7\r\u00e1\n\r\f\r\16\r\u00e4\13\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u00f0\n\16\f\16\16\16\u00f3\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0103"+
		"\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2\u011a\2\36"+
		"\3\2\2\2\4%\3\2\2\2\6)\3\2\2\2\b<\3\2\2\2\n>\3\2\2\2\fJ\3\2\2\2\16L\3"+
		"\2\2\2\20T\3\2\2\2\22`\3\2\2\2\24n\3\2\2\2\26\u009a\3\2\2\2\30\u00b8\3"+
		"\2\2\2\32\u00e8\3\2\2\2\34\u0102\3\2\2\2\36\37\7\3\2\2\37 \5\4\3\2 !\5"+
		"\n\6\2!\"\7\4\2\2\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\34\2\2+\61\b\4\1\2,-\7"+
		"\26\2\2-.\7\34\2\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\22\2\2\65\7\3\2\2\2\66"+
		"\67\7\5\2\2\67=\b\5\1\289\7\6\2\29=\b\5\1\2:;\7\7\2\2;=\b\5\1\2<\66\3"+
		"\2\2\2<8\3\2\2\2<:\3\2\2\2=\t\3\2\2\2>@\b\6\1\2?A\5\f\7\2@?\3\2\2\2AB"+
		"\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DK\5\16\b\2EK\5\20\t\2FK\5\22"+
		"\n\2GK\5\24\13\2HK\5\26\f\2IK\5\30\r\2JD\3\2\2\2JE\3\2\2\2JF\3\2\2\2J"+
		"G\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\r\3\2\2\2LM\7\b\2\2MN\7\17\2\2NO\7\34\2"+
		"\2OP\b\b\1\2PQ\7\21\2\2QR\7\22\2\2RS\b\b\1\2S\17\3\2\2\2TU\7\t\2\2UZ\7"+
		"\17\2\2VW\7\34\2\2W[\b\t\1\2XY\7\33\2\2Y[\b\t\1\2ZV\3\2\2\2ZX\3\2\2\2"+
		"[\\\3\2\2\2\\]\7\21\2\2]^\7\22\2\2^_\b\t\1\2_\21\3\2\2\2`a\7\34\2\2ab"+
		"\b\n\1\2bc\7\25\2\2ci\b\n\1\2de\5\32\16\2ef\b\n\1\2fj\3\2\2\2gh\7\33\2"+
		"\2hj\b\n\1\2id\3\2\2\2ig\3\2\2\2jk\3\2\2\2kl\7\22\2\2lm\b\n\1\2m\23\3"+
		"\2\2\2no\7\n\2\2o\177\7\17\2\2pq\7\34\2\2qr\b\13\1\2rs\7\31\2\2sx\b\13"+
		"\1\2tu\7\34\2\2uy\b\13\1\2vy\7\35\2\2wy\7\33\2\2xt\3\2\2\2xv\3\2\2\2x"+
		"w\3\2\2\2yz\3\2\2\2z\u0080\b\13\1\2{|\7\32\2\2|\u0080\b\13\1\2}~\7\34"+
		"\2\2~\u0080\b\13\1\2\177p\3\2\2\2\177{\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\7\21\2\2\u0082\u0083\7\27\2\2\u0083\u0085\b\13\1"+
		"\2\u0084\u0086\5\f\7\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\30\2\2"+
		"\u008a\u0096\b\13\1\2\u008b\u008c\7\13\2\2\u008c\u008d\7\27\2\2\u008d"+
		"\u008f\b\13\1\2\u008e\u0090\5\f\7\2\u008f\u008e\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\7\30\2\2\u0094\u0095\b\13\1\2\u0095\u0097\3\2\2\2\u0096\u008b\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\13\1\2\u0099"+
		"\25\3\2\2\2\u009a\u009b\7\f\2\2\u009b\u00ab\7\17\2\2\u009c\u009d\7\34"+
		"\2\2\u009d\u009e\b\f\1\2\u009e\u009f\7\31\2\2\u009f\u00a4\b\f\1\2\u00a0"+
		"\u00a1\7\34\2\2\u00a1\u00a5\b\f\1\2\u00a2\u00a5\7\35\2\2\u00a3\u00a5\7"+
		"\33\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00ac\b\f\1\2\u00a7\u00a8\7\32\2\2\u00a8\u00ac\b"+
		"\f\1\2\u00a9\u00aa\7\34\2\2\u00aa\u00ac\b\f\1\2\u00ab\u009c\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\21"+
		"\2\2\u00ae\u00af\7\27\2\2\u00af\u00b1\b\f\1\2\u00b0\u00b2\5\f\7\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\30\2\2\u00b6\u00b7\b\f\1\2\u00b7"+
		"\27\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9\u00ba\7\17\2\2\u00ba\u00bb\b\r\1"+
		"\2\u00bb\u00bc\7\34\2\2\u00bc\u00bd\b\r\1\2\u00bd\u00be\7\21\2\2\u00be"+
		"\u00bf\7\27\2\2\u00bf\u00c4\7\16\2\2\u00c0\u00c1\7\34\2\2\u00c1\u00c5"+
		"\b\r\1\2\u00c2\u00c5\7\35\2\2\u00c3\u00c5\7\33\2\2\u00c4\u00c0\3\2\2\2"+
		"\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\b\r\1\2\u00c7\u00c8\7\23\2\2\u00c8\u00ca\b\r\1\2\u00c9\u00cb\5\f\7\2"+
		"\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00e2\b\r\1\2\u00cf\u00d4\7\16\2\2"+
		"\u00d0\u00d1\7\34\2\2\u00d1\u00d5\b\r\1\2\u00d2\u00d5\7\35\2\2\u00d3\u00d5"+
		"\7\33\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\r\1\2\u00d7\u00d8\7\23\2\2\u00d8\u00da"+
		"\b\r\1\2\u00d9\u00db\5\f\7\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\r"+
		"\1\2\u00df\u00e1\3\2\2\2\u00e0\u00cf\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e5\u00e6\7\30\2\2\u00e6\u00e7\b\r\1\2\u00e7\31\3\2\2\2\u00e8\u00e9"+
		"\5\34\17\2\u00e9\u00f1\b\16\1\2\u00ea\u00eb\7\24\2\2\u00eb\u00ec\b\16"+
		"\1\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee\b\16\1\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ea\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\33\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\34\2\2\u00f5\u0103"+
		"\b\17\1\2\u00f6\u00f7\7\35\2\2\u00f7\u0103\b\17\1\2\u00f8\u00f9\7\33\2"+
		"\2\u00f9\u0103\b\17\1\2\u00fa\u00fb\7\32\2\2\u00fb\u0103\b\17\1\2\u00fc"+
		"\u00fd\7\17\2\2\u00fd\u00fe\b\17\1\2\u00fe\u00ff\5\32\16\2\u00ff\u0100"+
		"\7\21\2\2\u0100\u0101\b\17\1\2\u0101\u0103\3\2\2\2\u0102\u00f4\3\2\2\2"+
		"\u0102\u00f6\3\2\2\2\u0102\u00f8\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u00fc"+
		"\3\2\2\2\u0103\35\3\2\2\2\30\'\61<BJZix\177\u0087\u0091\u0096\u00a4\u00ab"+
		"\u00b3\u00c4\u00cc\u00d4\u00dc\u00e2\u00f1\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}