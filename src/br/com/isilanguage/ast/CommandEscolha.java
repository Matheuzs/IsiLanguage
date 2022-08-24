package br.com.isilanguage.ast;

import java.util.ArrayList;

public class CommandEscolha extends AbstractCommand {
	private String escolhaID;
	private ArrayList<String> casos;
	private ArrayList<ArrayList<AbstractCommand>> comandosCasos;
	
	public CommandEscolha(String escolhaID, ArrayList<String> casos, ArrayList<ArrayList<AbstractCommand>> comandosCasos) {
		this.escolhaID = escolhaID;
		this.casos = casos;
		this.comandosCasos = comandosCasos;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("switch (" + escolhaID + ") {\n");
		for(int i = 0; i < comandosCasos.size(); i++) {
			str.append("\tcase " + casos.get(i) + ":\n");
			for (AbstractCommand cmd: comandosCasos.get(i)) {
				str.append("\t\t" + cmd.generateJavaCode());
				str.append("\n");
			}
			str.append("\t\tbreak;\n");
		}
		str.append("}");
		return str.toString();
	}
	
	@Override
	public String toString() {
		return "CommandEscolha [escolhaID=" + escolhaID + ", casos=" + casos + ", comandosCasos=" + comandosCasos
				+ "]";
	}
}
