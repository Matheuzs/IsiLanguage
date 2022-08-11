package br.com.isilanguage.ast;

import java.util.ArrayList;

import br.com.isilanguage.datastructures.IsiSymbolTable;

public class IsiProgram {
	private IsiSymbolTable vartable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;

	public void generateTarget() {
		
	}

	public IsiSymbolTable getVartable() {
		return vartable;
	}

	public void setVartable(IsiSymbolTable vartable) {
		this.vartable = vartable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
}
