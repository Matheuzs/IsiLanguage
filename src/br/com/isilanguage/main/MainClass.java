package br.com.isilanguage.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.isilanguage.exceptions.IsiSemanticException;
import br.com.isilanguage.parser.IsiLangLexer;
import br.com.isilanguage.parser.IsiLangParser;

/* Esta é a classe responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 * 
 * Arquivo fonte: extensao .isi
 */
public class MainClass {
	public static void main(String[] args) {
		try {
			IsiLangLexer lexer;
			IsiLangParser parser;
			
			// Leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
			lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
			
			// Crio um "fluxo de tokens" para passar para o Parser
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// Crio meu parser a partir desse tokenStream
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compilation Successful");
			
			parser.exibeComandos();
			
			parser.generateCode();
		}
		catch(IsiSemanticException ex) {
			System.err.println("Semantic Error - " + ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("ERROR " + ex.getMessage());
		}
	}
}
