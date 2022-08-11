// Generated from IsiLang.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(@NotNull IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(@NotNull IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(@NotNull IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(@NotNull IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(@NotNull IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(@NotNull IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(@NotNull IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(@NotNull IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(@NotNull IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(@NotNull IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(@NotNull IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(@NotNull IsiLangParser.CmdleituraContext ctx);
}