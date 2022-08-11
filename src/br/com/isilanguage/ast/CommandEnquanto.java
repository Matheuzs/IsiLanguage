package br.com.isilanguage.ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {

	private String condition;
	private ArrayList<AbstractCommand> commands;
	
	public CommandEnquanto(String condition, ArrayList<AbstractCommand> commands) {
		this.condition = condition;
		this.commands = commands;
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("while(" + condition + ") {\n");
		for(AbstractCommand cmd : commands) {
			str.append("\t" + cmd.generateJavaCode());
		}
		str.append("}\n");
		return str.toString();
	}

	@Override
	public String toString() {
		return "CommandEnquanto [condition=" + condition + ", commands=" + commands + "]";
	}
}
