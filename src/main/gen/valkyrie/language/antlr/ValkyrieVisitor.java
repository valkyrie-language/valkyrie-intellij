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
	 * Visit a parse tree produced by {@link ValkyrieParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ValkyrieParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(ValkyrieParser.EosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_namespace(ValkyrieParser.Define_namespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#import_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_statement(ValkyrieParser.Import_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_extension(ValkyrieParser.Define_extensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_class(ValkyrieParser.Define_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#class_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_statements(ValkyrieParser.Class_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#class_inherit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_inherit(ValkyrieParser.Class_inheritContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#trait_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrait_statements(ValkyrieParser.Trait_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_method(ValkyrieParser.Define_methodContext ctx);
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
	 * Visit a parse tree produced by {@link ValkyrieParser#type_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_hint(ValkyrieParser.Type_hintContext ctx);
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
	 * Visit a parse tree produced by {@link ValkyrieParser#function_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_block(ValkyrieParser.Function_blockContext ctx);
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
	 * Visit a parse tree produced by the {@code TNumber}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTNumber(ValkyrieParser.TNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TOp}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTOp(ValkyrieParser.TOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTParens(ValkyrieParser.TParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TIdentifier}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTIdentifier(ValkyrieParser.TIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SpeicalLiteral}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpeicalLiteral(ValkyrieParser.SpeicalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ValkyrieParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Vector}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(ValkyrieParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EIdentifier}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEIdentifier(ValkyrieParser.EIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(ValkyrieParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(ValkyrieParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ValkyrieParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EVector}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEVector(ValkyrieParser.EVectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ENumber}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENumber(ValkyrieParser.ENumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ESpeicalLiteral}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitESpeicalLiteral(ValkyrieParser.ESpeicalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EString}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEString(ValkyrieParser.EStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfix(ValkyrieParser.InfixContext ctx);
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
	 * Visit a parse tree produced by {@link ValkyrieParser#namepath_free}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamepath_free(ValkyrieParser.Namepath_freeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#namepath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamepath(ValkyrieParser.NamepathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ValkyrieParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#number_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_suffix(ValkyrieParser.Number_suffixContext ctx);
}