grammar IsiLang;

@header {
	import br.com.isilanguage.datastructures.IsiSymbol;
	import br.com.isilanguage.datastructures.IsiVariable;
	import br.com.isilanguage.datastructures.IsiSymbolTable;
	import br.com.isilanguage.exceptions.IsiSemanticException;
	import java.util.ArrayList;
}

@members {
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
}

prog	: 'programa' decl bloco 'fimprog;' 
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
		;

cmdleitura	: 'leia' AP
					 ID { 
					 	_varName = _input.LT(-1).getText();
					 	if(!symbolTable.exists(_varName)) {
					 		throw new IsiSemanticException("Symbol not " + _varName + " declared");
					 	}
					 }
					 FP
					 SC
			;
			
cmdescrita	: 'escreva' AP ID FP SC
			;

cmdattrib	: ID ATTR expr SC
			;
			
expr		: termo ( OP termo )*
			;
			
termo		: ID | NUMBER
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

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;