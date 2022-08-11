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
	import java.util.ArrayList;
}

@members {
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread = new ArrayList<AbstractCommand>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	
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
}

prog	: 'programa' decl bloco 'fimprog;'
		  { program.setComandos(curThread); }
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
		
bloco	: (cmd)+
		;

cmd		: cmdleitura
		| cmdescrita
		| cmdattrib
		| cmdselecao
		;

cmdleitura	: 'leia' AP
					 ID { 
					 	verificaID(_input.LT(-1).getText());
					 	_readID = _input.LT(-1).getText();
					 }
					 FP
					 SC
				{
					CommandLeitura cmd = new CommandLeitura(_readID);
					curThread.add(cmd);
				}
			;
			
cmdescrita	: 'escreva' AP
						ID { 
							verificaID(_input.LT(-1).getText());
							_writeID = _input.LT(-1).getText();
						}
						FP
						SC
				{
					CommandEscrita cmd = new CommandEscrita(_writeID);
					curThread.add(cmd);
				}
			;

cmdattrib	: ID { 
				verificaID(_input.LT(-1).getText());
				_exprID = _input.LT(-1).getText();
			  }
			  ATTR { _exprContent = ""; }
			  expr 
			  SC
			  {
			  	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			  	curThread.add(cmd);
			  }
			;
			
cmdselecao	: 'se' AP ID OPREL (ID | NUMBER) FP ACH (cmd)+ FCH
			  ('senao' ACH (cmd)+ FCH)?
			;
			
expr		: termo ( 
				OP { _exprContent += _input.LT(-1).getText(); }
				termo
			  )*
			;
			
termo		: ID { 
				verificaID(_input.LT(-1).getText());
				_exprContent += _input.LT(-1).getText();
			  } 
			| 
			NUMBER {
				_exprContent += _input.LT(-1).getText();
			}
			;

AP	: '('
	;

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
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;