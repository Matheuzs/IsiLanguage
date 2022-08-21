grammar IsiLang;

@header {
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
	import java.util.ArrayList;
	import java.util.Stack;
}

@members {
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
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol " + id + " not declared");
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
}

prog	: 'programa' decl bloco 'fimprog;'
		  {
		  	program.setVarTable(symbolTable);
		  	program.setComandos(stack.pop());
				for(IsiSymbol symbol: symbolTable.getAll()){
					if (!symbol.hasBeenUsed()){
						System.out.println("WARNING: Variable " + symbol.getName() + " was declared but not used.");
					}
				}
		  }
		;
		
decl	: (declaravar)+
		;

declaravar	: tipo ID {
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
				(
					VIR
					ID {
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
				)* 
				SC
			;
			
tipo	: 'numero' { _tipo = IsiVariable.NUMBER; }
		| 'texto' { _tipo = IsiVariable.TEXT; }
		;
		
bloco	: 
		{ 
			curThread = new ArrayList<AbstractCommand>();
			stack.push(curThread);
		}
		(cmd)+
		;

cmd		: cmdleitura
		| cmdescrita
		| cmdattrib
		| cmdselecao
		| cmdenquanto
		;

cmdleitura	: 'leia' AP
					 ID { 
					 	verificaID(_input.LT(-1).getText());
					 	_readID = _input.LT(-1).getText();
						symbolTable.get(_readID).setUsed();
					 }
					 FP
					 SC
				{
					IsiVariable var = (IsiVariable) symbolTable.get(_readID);
					CommandLeitura cmd = new CommandLeitura(_readID, var);
					stack.peek().add(cmd);
				}
			;
			
cmdescrita	: 'escreva' AP
						ID { 
							verificaID(_input.LT(-1).getText());
							_writeID = _input.LT(-1).getText();
							symbolTable.get(_writeID).setUsed();
						}
						FP
						SC
				{
					CommandEscrita cmd = new CommandEscrita(_writeID);
					stack.peek().add(cmd);
				}
			;

cmdattrib:
	ID { verificaID(_input.LT(-1).getText());
      _exprID = _input.LT(-1).getText();
      _receiverTipo = getSymbolType(_exprID);
      } 
  ATTR { _exprContent = ""; } (
		expr {if (_receiverTipo != _exprTipo)
		 throw new IsiSemanticException("Can not assign expression of type \"" + IsiVariable.getTypeText(_exprTipo) + "\" to variable \"" + _exprID + "\" of type \"" + IsiVariable.getTypeText(_receiverTipo) + "\"");
		}
		| 
		STR {_exprContent += _input.LT(-1).getText();
			 if (_receiverTipo != IsiVariable.TEXT) {
				throw new IsiSemanticException("Can not assign expression of type \"texto\" to variable \"" + _exprID + "\" of type \"" + IsiVariable.getTypeText(_receiverTipo) + "\"");
			 }
			}
	) SC {
		CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
		stack.peek().add(cmd);
	};
			
cmdselecao	: 'se' AP 
				   ID { 
						_exprDecision = _input.LT(-1).getText(); 
						symbolTable.get(_exprDecision).setUsed();
					 }
				   OPREL { _exprDecision += _input.LT(-1).getText(); }
				   (ID | NUMBER) { _exprDecision += _input.LT(-1).getText(); }
				   FP 
				   ACH {
				   	curThread = new ArrayList<AbstractCommand>();
				   	stack.push(curThread);
				   }
				   (cmd)+ 
				   FCH {
				   	listaTrue = stack.pop();
				   }
			  ('senao' 
			  	ACH {
					curThread = new ArrayList<AbstractCommand>();
               	 	stack.push(curThread);
			  	}
			  	(cmd)+
			  	FCH {
	           		listaFalse = stack.pop();
	           		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
	           		stack.peek().add(cmd);
			  	}
			  )?
			;
			
cmdenquanto	: 'enquanto' AP
					     ID { 
								_exprDecision = _input.LT(-1).getText(); 
								 symbolTable.get(_exprDecision).setUsed();
							 }
					     OPREL { _exprDecision += _input.LT(-1).getText(); }
					     (ID | NUMBER) { _exprDecision += _input.LT(-1).getText(); }
					     FP 
					     ACH {
					   		curThread = new ArrayList<AbstractCommand>();
					   		stack.push(curThread);
						 }
						 (cmd)+ 
						 FCH {
						 	CommandEnquanto cmd = new CommandEnquanto(_exprDecision, stack.pop());
	           				stack.peek().add(cmd);
						 }
			  ;
			
expr		: termo {
				_exprTipo = _termoTipo;
			  } ( 
				OP { _exprContent += _input.LT(-1).getText(); }
				termo {
					if (_exprTipo != _termoTipo) {
						throw new IsiSemanticException("Inconsistent types at given expression: " + _exprContent);
					}
				}
			  )*
			;
			
termo		: ID { 
				verificaID(_input.LT(-1).getText());
				_exprContent += _input.LT(-1).getText();
				_varName = _input.LT(-1).getText();
				_termoTipo = getSymbolType(_varName);
				symbolTable.get(_varName).setUsed();
			  } 
			| 
			NUMBER {
				_exprContent += _input.LT(-1).getText();
				_termoTipo = IsiVariable.NUMBER;
			}
			|
			STR {
				_exprContent += _input.LT(-1).getText();
				_termoTipo = IsiVariable.TEXT;
			}
			;

AP	: '('
	;

ASP: '"';

FP	: ')'
	;

SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR	: '='
		;
		
VIR	: ','
	;
	
ACH	: '{'
	;

FCH	: '}'
	;
	
OPREL	: '>' | '<' | '>=' | '<=' | '==' | '!='
		;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

STR: ASP ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9] | WS)+ ASP;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;