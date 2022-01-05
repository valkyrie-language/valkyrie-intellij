// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\Valkyrie.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValkyrieParser}.
 */
public interface ValkyrieListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ValkyrieParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ValkyrieParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void enterTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void exitTop_statement(ValkyrieParser.Top_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(ValkyrieParser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(ValkyrieParser.EosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void enterDefine_namespace(ValkyrieParser.Define_namespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void exitDefine_namespace(ValkyrieParser.Define_namespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(ValkyrieParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(ValkyrieParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_extension}.
	 * @param ctx the parse tree
	 */
	void enterDefine_extension(ValkyrieParser.Define_extensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_extension}.
	 * @param ctx the parse tree
	 */
	void exitDefine_extension(ValkyrieParser.Define_extensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_class}.
	 * @param ctx the parse tree
	 */
	void enterDefine_class(ValkyrieParser.Define_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_class}.
	 * @param ctx the parse tree
	 */
	void exitDefine_class(ValkyrieParser.Define_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void enterClass_statements(ValkyrieParser.Class_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void exitClass_statements(ValkyrieParser.Class_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#class_inherit}.
	 * @param ctx the parse tree
	 */
	void enterClass_inherit(ValkyrieParser.Class_inheritContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#class_inherit}.
	 * @param ctx the parse tree
	 */
	void exitClass_inherit(ValkyrieParser.Class_inheritContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void enterDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void exitDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#trait_statements}.
	 * @param ctx the parse tree
	 */
	void enterTrait_statements(ValkyrieParser.Trait_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#trait_statements}.
	 * @param ctx the parse tree
	 */
	void exitTrait_statements(ValkyrieParser.Trait_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 */
	void enterDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 */
	void exitDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void enterUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void exitUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void enterDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void exitDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 */
	void enterDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 */
	void exitDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameters(ValkyrieParser.Function_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameters(ValkyrieParser.Function_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#function_parameter_item}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter_item(ValkyrieParser.Function_parameter_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#function_parameter_item}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter_item(ValkyrieParser.Function_parameter_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#function_statements}.
	 * @param ctx the parse tree
	 */
	void enterFunction_statements(ValkyrieParser.Function_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#function_statements}.
	 * @param ctx the parse tree
	 */
	void exitFunction_statements(ValkyrieParser.Function_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_method}.
	 * @param ctx the parse tree
	 */
	void enterDefine_method(ValkyrieParser.Define_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_method}.
	 * @param ctx the parse tree
	 */
	void exitDefine_method(ValkyrieParser.Define_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#define_type}.
	 * @param ctx the parse tree
	 */
	void enterDefine_type(ValkyrieParser.Define_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#define_type}.
	 * @param ctx the parse tree
	 */
	void exitDefine_type(ValkyrieParser.Define_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#type_hint}.
	 * @param ctx the parse tree
	 */
	void enterType_hint(ValkyrieParser.Type_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#type_hint}.
	 * @param ctx the parse tree
	 */
	void exitType_hint(ValkyrieParser.Type_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(ValkyrieParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(ValkyrieParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(ValkyrieParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(ValkyrieParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(ValkyrieParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(ValkyrieParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(ValkyrieParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(ValkyrieParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOp(ValkyrieParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOp(ValkyrieParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Control}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterControl(ValkyrieParser.ControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Control}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitControl(ValkyrieParser.ControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ETerm}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterETerm(ValkyrieParser.ETermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ETerm}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitETerm(ValkyrieParser.ETermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParens(ValkyrieParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex(ValkyrieParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegate(ValkyrieParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITerm}
	 * labeled alternative in {@link ValkyrieParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void enterITerm(ValkyrieParser.ITermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITerm}
	 * labeled alternative in {@link ValkyrieParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void exitITerm(ValkyrieParser.ITermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IOP}
	 * labeled alternative in {@link ValkyrieParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void enterIOP(ValkyrieParser.IOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IOP}
	 * labeled alternative in {@link ValkyrieParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void exitIOP(ValkyrieParser.IOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EIdentifier}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void enterEIdentifier(ValkyrieParser.EIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EIdentifier}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void exitEIdentifier(ValkyrieParser.EIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ENumber}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void enterENumber(ValkyrieParser.ENumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ENumber}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void exitENumber(ValkyrieParser.ENumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EString}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void enterEString(ValkyrieParser.EStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EString}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void exitEString(ValkyrieParser.EStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EVector}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void enterEVector(ValkyrieParser.EVectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EVector}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void exitEVector(ValkyrieParser.EVectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ESpeicalLiteral}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void enterESpeicalLiteral(ValkyrieParser.ESpeicalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ESpeicalLiteral}
	 * labeled alternative in {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 */
	void exitESpeicalLiteral(ValkyrieParser.ESpeicalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#infix}.
	 * @param ctx the parse tree
	 */
	void enterInfix(ValkyrieParser.InfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#infix}.
	 * @param ctx the parse tree
	 */
	void exitInfix(ValkyrieParser.InfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TOp}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTOp(ValkyrieParser.TOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TOp}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTOp(ValkyrieParser.TOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTParens(ValkyrieParser.TParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTParens(ValkyrieParser.TParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTTerm(ValkyrieParser.TTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTTerm(ValkyrieParser.TTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(ValkyrieParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(ValkyrieParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(ValkyrieParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(ValkyrieParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#control_expression}.
	 * @param ctx the parse tree
	 */
	void enterControl_expression(ValkyrieParser.Control_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#control_expression}.
	 * @param ctx the parse tree
	 */
	void exitControl_expression(ValkyrieParser.Control_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#namepath_free}.
	 * @param ctx the parse tree
	 */
	void enterNamepath_free(ValkyrieParser.Namepath_freeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#namepath_free}.
	 * @param ctx the parse tree
	 */
	void exitNamepath_free(ValkyrieParser.Namepath_freeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#namepath}.
	 * @param ctx the parse tree
	 */
	void enterNamepath(ValkyrieParser.NamepathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#namepath}.
	 * @param ctx the parse tree
	 */
	void exitNamepath(ValkyrieParser.NamepathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ValkyrieParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ValkyrieParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ValkyrieParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieParser#number_suffix}.
	 * @param ctx the parse tree
	 */
	void enterNumber_suffix(ValkyrieParser.Number_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieParser#number_suffix}.
	 * @param ctx the parse tree
	 */
	void exitNumber_suffix(ValkyrieParser.Number_suffixContext ctx);
}