package br.com.isilanguage.ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {

	private String condition;
	private ArrayList<AbstractCommand> commands;
	
	public CommandEnquanto(String condition, ArrayList<AbstractCommand> commands) {
		if (condition.equals("verdadeiro")) {
			this.condition = "true";
		} else if (condition.equals("falso")) {
			this.condition = "false";
		} else {
			this.condition = condition;
		}
		this.commands = commands;
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("while(" + condition + ") {\n");
		for(AbstractCommand cmd : commands) {
			str.append("\t" + cmd.generateJavaCode());
			str.append("\n");
		}
		str.append("}\n");
		return str.toString();
	}

	@Override
	public String toString() {
		return "CommandEnquanto [condition=" + condition + ", commands=" + commands + "]";
	}
}
