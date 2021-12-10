// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\Valkyrie.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValkyrieParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValkyrieVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ValkyrieParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#formal_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_args(ValkyrieParser.Formal_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#formal_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_arg(ValkyrieParser.Formal_argContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntTypeSpec(ValkyrieParser.IntTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatTypeSpec(ValkyrieParser.FloatTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTypeSpec(ValkyrieParser.StringTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTypeSpec(ValkyrieParser.BooleanTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorTypeSpec}
	 * labeled alternative in {@link ValkyrieParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorTypeSpec(ValkyrieParser.VectorTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ValkyrieParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(ValkyrieParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ValkyrieParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ValkyrieParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementAssign}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAssign(ValkyrieParser.ElementAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(ValkyrieParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ValkyrieParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(ValkyrieParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link ValkyrieParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(ValkyrieParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#vardef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardef(ValkyrieParser.VardefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(ValkyrieParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(ValkyrieParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ValkyrieParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link ValkyrieParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ValkyrieParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(ValkyrieParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_expr(ValkyrieParser.Call_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(ValkyrieParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(ValkyrieParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(ValkyrieParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ValkyrieParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Vector}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(ValkyrieParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(ValkyrieParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link ValkyrieParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(ValkyrieParser.FalseLiteralContext ctx);
}