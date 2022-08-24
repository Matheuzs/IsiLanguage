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
	import br.com.isilanguage.ast.CommandEscolha;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members {
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
		| 'booleano' { _tipo = IsiVariable.BOOLEAN; }
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
		| cmdswitch
		;

cmdleitura	: 'leia' AP
					 ID { 
					 	verificaID(_input.LT(-1).getText());
					 	_readID = _input.LT(-1).getText();
						symbolTable.get(_readID).setUsed();
						symbolTable.get(_readID).setInitialized();
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
						(ID { 
							verificaID(_input.LT(-1).getText());
							verificaInicializado(_input.LT(-1).getText());
							_writeID = _input.LT(-1).getText();
							symbolTable.get(_writeID).setUsed();
						} | STR {_writeID = _input.LT(-1).getText();})
						FP
						SC
				{
					CommandEscrita cmd = new CommandEscrita(_writeID);
					stack.peek().add(cmd);
				}
			;

cmdattrib:
	ID {_exprID = _input.LT(-1).getText();
		verificaID(_exprID);
        _receiverTipo = getSymbolType(_exprID);
        symbolTable.get(_exprID).setInitialized();
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
				   (
				   (ID { 
						_exprDecision = _input.LT(-1).getText(); 
						symbolTable.get(_exprDecision).setUsed();
						verificaID(_exprDecision);
						verificaInicializado(_exprDecision);
					 }
				   OPREL { _exprDecision += _input.LT(-1).getText(); }
				   (ID {verificaID(_input.LT(-1).getText());
				   		verificaInicializado(_input.LT(-1).getText());
				   		symbolTable.get(_input.LT(-1).getText()).setUsed();
				   	   }
				    |
				    NUMBER | STR) { _savedValue = _exprDecision + _input.LT(-1).getText(); })
				    
				    | BOOLEAN {_savedValue = _input.LT(-1).getText();}
				    | ID {verificaID(_input.LT(-1).getText());
				   			verificaInicializado(_input.LT(-1).getText());
				   			symbolTable.get(_input.LT(-1).getText()).setUsed();
				   			_savedValue = _input.LT(-1).getText();
				   			_tipo = getSymbolType(_input.LT(-1).getText());
				   			if (_tipo != IsiVariable.BOOLEAN) {
				   				throw new IsiSemanticException("Symbol \"" + _input.LT(-1).getText() + "\" cannot be used as boolean");
				   			}}
				    )
				   FP 
				   ACH {
				   	curThread = new ArrayList<AbstractCommand>();
				   	stack.push(curThread);
				   }
				   (cmd)+ 
				   FCH {
				   	listaTrue = stack.pop();
				   	listaFalse = new ArrayList<AbstractCommand>();
				   }
			  ('senao' 
			  	ACH {
					curThread = new ArrayList<AbstractCommand>();
               	 	stack.push(curThread);
			  	}
			  	(cmd)+
			  	FCH {
	           		listaFalse = stack.pop();
			  	}
			  )? {	CommandDecisao cmd = new CommandDecisao(_savedValue, listaTrue, listaFalse);
	           		stack.peek().add(cmd);}
			;
			
cmdenquanto	: 'enquanto' AP
					    (
					   (ID { 
							_exprDecision = _input.LT(-1).getText(); 
							symbolTable.get(_exprDecision).setUsed();
							verificaID(_exprDecision);
							verificaInicializado(_exprDecision);
						 }
					   OPREL { _exprDecision += _input.LT(-1).getText(); }
					   (ID {verificaID(_input.LT(-1).getText());
					   		verificaInicializado(_input.LT(-1).getText());
					   		symbolTable.get(_input.LT(-1).getText()).setUsed();
					   	   }
					    |
					    NUMBER | STR) { _savedValue = _exprDecision + _input.LT(-1).getText(); })
					    
					    | BOOLEAN {_savedValue = _input.LT(-1).getText();}
					    | ID {verificaID(_input.LT(-1).getText());
					   			verificaInicializado(_input.LT(-1).getText());
					   			symbolTable.get(_input.LT(-1).getText()).setUsed();
					   			_savedValue = _input.LT(-1).getText();
					   			_tipo = getSymbolType(_input.LT(-1).getText());
					   			if (_tipo != IsiVariable.BOOLEAN) {
					   				throw new IsiSemanticException("Symbol \"" + _input.LT(-1).getText() + "\" cannot be used as boolean");
					   			}}
						    )
					     FP 
					     ACH {
					   		curThread = new ArrayList<AbstractCommand>();
					   		stack.push(curThread);
						 }
						 (cmd)+ 
						 FCH {
						 	CommandEnquanto cmd = new CommandEnquanto(_savedValue, stack.pop());
	           				stack.peek().add(cmd);
						 }
			  ;

cmdswitch : 'escolha' AP {listaCases = new ArrayList<String>();
						  switchCommands = new ArrayList<ArrayList<AbstractCommand>>();
						 }
					  ID {
					  	 _exprDecision = _input.LT(-1).getText();
					  	 verificaID(_exprDecision);
					  	 verificaInicializado(_exprDecision);
						 symbolTable.get(_exprDecision).setUsed();
						 _tipo = getSymbolType(_exprDecision);
					  }
					  FP
					  ACH
					  'caso'
					  	(ID {verificaID(_input.LT(-1).getText());
					     	  verificaInicializado(_input.LT(-1).getText());
					     	  symbolTable.get(_input.LT(-1).getText()).setUsed();
					     	 }
					  	 | NUMBER | STR) {listaCases.add(_input.LT(-1).getText());}
					  	 DD {curThread = new ArrayList<AbstractCommand>();
               	 			 stack.push(curThread);}
               	 		 (cmd)+
               	 		  	{switchCommands.add(stack.pop());}
					  ('caso'
					  	(ID {verificaID(_input.LT(-1).getText());
					     	  verificaInicializado(_input.LT(-1).getText());
					     	  symbolTable.get(_input.LT(-1).getText()).setUsed();
					     	}
					     | NUMBER | STR) {listaCases.add(_input.LT(-1).getText());}
					     DD {curThread = new ArrayList<AbstractCommand>();
               	 			 stack.push(curThread);}
               	 		(cmd)+ {switchCommands.add(stack.pop());})*
					  FCH {
					  	CommandEscolha cmd = new CommandEscolha(_exprDecision, listaCases, switchCommands);
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
				verificaInicializado(_varName);
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
			|
			BOOLEAN {
				_exprContent += _input.LT(-1).getText();
				_termoTipo = IsiVariable.BOOLEAN;
			}
			|
			AP { 
			_exprContent += _input.LT(-1).getText(); 
			}
                	expr
			FP { 
			_exprContent += _input.LT(-1).getText(); 
			}
			;
		
AP	: '('
	;

ASP: '"';

FP	: ')'
	;

SC	: ';'
	;
	
DD	: ':'
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

BOOLEAN : 'verdadeiro' | 'falso'
		;

STR: ASP ([a-z] | [A-Z] | [0-9]) ([a-z] | [A-Z] | [0-9] | WS)* ASP;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;
