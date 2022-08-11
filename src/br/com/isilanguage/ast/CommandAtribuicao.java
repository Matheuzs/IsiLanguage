package br.com.isilanguage.ast;

public class CommandAtribuicao extends AbstractCommand {

	public String id;
	public String expr;
	
	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}
	
	@Override
	public String generateJavaCode() {
		return id + " = " + expr + ";";
	}

	@Override
	public String toString() {
		return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
	}
}
