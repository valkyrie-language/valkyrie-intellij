// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\ValkyrieAntlr.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValkyrieAntlrParser}.
 */
public interface ValkyrieAntlrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ValkyrieAntlrParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ValkyrieAntlrParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void enterTop_statement(ValkyrieAntlrParser.Top_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#top_statement}.
	 * @param ctx the parse tree
	 */
	void exitTop_statement(ValkyrieAntlrParser.Top_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_statements}.
	 * @param ctx the parse tree
	 */
	void enterFunction_statements(ValkyrieAntlrParser.Function_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_statements}.
	 * @param ctx the parse tree
	 */
	void exitFunction_statements(ValkyrieAntlrParser.Function_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(ValkyrieAntlrParser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(ValkyrieAntlrParser.EosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
	 * @param ctx the parse tree
	 */
	void enterEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
	 * @param ctx the parse tree
	 */
	void exitEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void enterDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
	 * @param ctx the parse tree
	 */
	void exitDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
	 * @param ctx the parse tree
	 */
	void enterDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
	 * @param ctx the parse tree
	 */
	void exitDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
	 * @param ctx the parse tree
	 */
	void enterDefine_class(ValkyrieAntlrParser.Define_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
	 * @param ctx the parse tree
	 */
	void exitDefine_class(ValkyrieAntlrParser.Define_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
	 * @param ctx the parse tree
	 */
	void enterClass_block(ValkyrieAntlrParser.Class_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
	 * @param ctx the parse tree
	 */
	void exitClass_block(ValkyrieAntlrParser.Class_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void enterClass_statements(ValkyrieAntlrParser.Class_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_statements}.
	 * @param ctx the parse tree
	 */
	void exitClass_statements(ValkyrieAntlrParser.Class_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
	 * @param ctx the parse tree
	 */
	void enterClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
	 * @param ctx the parse tree
	 */
	void exitClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
	 * @param ctx the parse tree
	 */
	void enterClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
	 * @param ctx the parse tree
	 */
	void exitClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
	 * @param ctx the parse tree
	 */
	void enterClass_method(ValkyrieAntlrParser.Class_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
	 * @param ctx the parse tree
	 */
	void exitClass_method(ValkyrieAntlrParser.Class_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void enterDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
	 * @param ctx the parse tree
	 */
	void exitDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
	 * @param ctx the parse tree
	 */
	void enterDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
	 * @param ctx the parse tree
	 */
	void exitDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
	 * @param ctx the parse tree
	 */
	void enterDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
	 * @param ctx the parse tree
	 */
	void exitDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
	 * @param ctx the parse tree
	 */
	void enterUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
	 * @param ctx the parse tree
	 */
	void exitUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void enterUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
	 * @param ctx the parse tree
	 */
	void exitUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
	 * @param ctx the parse tree
	 */
	void enterDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
	 * @param ctx the parse tree
	 */
	void exitDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
	 * @param ctx the parse tree
	 */
	void enterVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
	 * @param ctx the parse tree
	 */
	void exitVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#variant_statements}.
	 * @param ctx the parse tree
	 */
	void enterVariant_statements(ValkyrieAntlrParser.Variant_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#variant_statements}.
	 * @param ctx the parse tree
	 */
	void exitVariant_statements(ValkyrieAntlrParser.Variant_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_bitflags}.
	 * @param ctx the parse tree
	 */
	void enterDefine_bitflags(ValkyrieAntlrParser.Define_bitflagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_bitflags}.
	 * @param ctx the parse tree
	 */
	void exitDefine_bitflags(ValkyrieAntlrParser.Define_bitflagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#bitflags_block}.
	 * @param ctx the parse tree
	 */
	void enterBitflags_block(ValkyrieAntlrParser.Bitflags_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_block}.
	 * @param ctx the parse tree
	 */
	void exitBitflags_block(ValkyrieAntlrParser.Bitflags_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#bitflags_statements}.
	 * @param ctx the parse tree
	 */
	void enterBitflags_statements(ValkyrieAntlrParser.Bitflags_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_statements}.
	 * @param ctx the parse tree
	 */
	void exitBitflags_statements(ValkyrieAntlrParser.Bitflags_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#bitflags_item}.
	 * @param ctx the parse tree
	 */
	void enterBitflags_item(ValkyrieAntlrParser.Bitflags_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_item}.
	 * @param ctx the parse tree
	 */
	void exitBitflags_item(ValkyrieAntlrParser.Bitflags_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
	 * @param ctx the parse tree
	 */
	void enterDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
	 * @param ctx the parse tree
	 */
	void exitDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
	 * @param ctx the parse tree
	 */
	void enterType_hint(ValkyrieAntlrParser.Type_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
	 * @param ctx the parse tree
	 */
	void exitType_hint(ValkyrieAntlrParser.Type_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#effect_hint}.
	 * @param ctx the parse tree
	 */
	void enterEffect_hint(ValkyrieAntlrParser.Effect_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#effect_hint}.
	 * @param ctx the parse tree
	 */
	void exitEffect_hint(ValkyrieAntlrParser.Effect_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
	 * @param ctx the parse tree
	 */
	void enterDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
	 * @param ctx the parse tree
	 */
	void exitDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
	 * @param ctx the parse tree
	 */
	void enterParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
	 * @param ctx the parse tree
	 */
	void exitParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
	 * @param ctx the parse tree
	 */
	void enterParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
	 * @param ctx the parse tree
	 */
	void exitParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(ValkyrieAntlrParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(ValkyrieAntlrParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#dot_call}.
	 * @param ctx the parse tree
	 */
	void enterDot_call(ValkyrieAntlrParser.Dot_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#dot_call}.
	 * @param ctx the parse tree
	 */
	void exitDot_call(ValkyrieAntlrParser.Dot_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
	 * @param ctx the parse tree
	 */
	void enterTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
	 * @param ctx the parse tree
	 */
	void exitTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
	 * @param ctx the parse tree
	 */
	void enterTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
	 * @param ctx the parse tree
	 */
	void exitTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
	 * @param ctx the parse tree
	 */
	void enterDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
	 * @param ctx the parse tree
	 */
	void exitDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#lambda_call}.
	 * @param ctx the parse tree
	 */
	void enterLambda_call(ValkyrieAntlrParser.Lambda_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#lambda_call}.
	 * @param ctx the parse tree
	 */
	void exitLambda_call(ValkyrieAntlrParser.Lambda_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
	 * @param ctx the parse tree
	 */
	void enterFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
	 * @param ctx the parse tree
	 */
	void exitFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void enterDefine_variale(ValkyrieAntlrParser.Define_varialeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_variale}.
	 * @param ctx the parse tree
	 */
	void exitDefine_variale(ValkyrieAntlrParser.Define_varialeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(ValkyrieAntlrParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(ValkyrieAntlrParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(ValkyrieAntlrParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(ValkyrieAntlrParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(ValkyrieAntlrParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(ValkyrieAntlrParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#for_pattern}.
	 * @param ctx the parse tree
	 */
	void enterFor_pattern(ValkyrieAntlrParser.For_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#for_pattern}.
	 * @param ctx the parse tree
	 */
	void exitFor_pattern(ValkyrieAntlrParser.For_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#for_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFor_parameter(ValkyrieAntlrParser.For_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#for_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFor_parameter(ValkyrieAntlrParser.For_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
	 * @param ctx the parse tree
	 */
	void enterIf_guard(ValkyrieAntlrParser.If_guardContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
	 * @param ctx the parse tree
	 */
	void exitIf_guard(ValkyrieAntlrParser.If_guardContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ValkyrieAntlrParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ValkyrieAntlrParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void enterInline_expression(ValkyrieAntlrParser.Inline_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#inline_expression}.
	 * @param ctx the parse tree
	 */
	void exitInline_expression(ValkyrieAntlrParser.Inline_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTParens(ValkyrieAntlrParser.TParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTParens(ValkyrieAntlrParser.TParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTTerm(ValkyrieAntlrParser.TTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTTerm(ValkyrieAntlrParser.TTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TPattern}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void enterTPattern(ValkyrieAntlrParser.TPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TPattern}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 */
	void exitTPattern(ValkyrieAntlrParser.TPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#prefix_call}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_call(ValkyrieAntlrParser.Prefix_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#prefix_call}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_call(ValkyrieAntlrParser.Prefix_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#suffix_call}.
	 * @param ctx the parse tree
	 */
	void enterSuffix_call(ValkyrieAntlrParser.Suffix_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#suffix_call}.
	 * @param ctx the parse tree
	 */
	void exitSuffix_call(ValkyrieAntlrParser.Suffix_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#control_expression}.
	 * @param ctx the parse tree
	 */
	void enterControl_expression(ValkyrieAntlrParser.Control_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#control_expression}.
	 * @param ctx the parse tree
	 */
	void exitControl_expression(ValkyrieAntlrParser.Control_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ValkyrieAntlrParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ValkyrieAntlrParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
	 * @param ctx the parse tree
	 */
	void enterOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
	 * @param ctx the parse tree
	 */
	void exitOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
	 * @param ctx the parse tree
	 */
	void enterOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
	 * @param ctx the parse tree
	 */
	void exitOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
	 * @param ctx the parse tree
	 */
	void enterOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
	 * @param ctx the parse tree
	 */
	void exitOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
	 * @param ctx the parse tree
	 */
	void enterOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
	 * @param ctx the parse tree
	 */
	void exitOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
	 * @param ctx the parse tree
	 */
	void enterOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
	 * @param ctx the parse tree
	 */
	void exitOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
	 * @param ctx the parse tree
	 */
	void enterInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
	 * @param ctx the parse tree
	 */
	void exitInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
	 * @param ctx the parse tree
	 */
	void enterInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
	 * @param ctx the parse tree
	 */
	void exitInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
	 * @param ctx the parse tree
	 */
	void enterDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
	 * @param ctx the parse tree
	 */
	void exitDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
	 * @param ctx the parse tree
	 */
	void enterSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
	 * @param ctx the parse tree
	 */
	void exitSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#offset_call}.
	 * @param ctx the parse tree
	 */
	void enterOffset_call(ValkyrieAntlrParser.Offset_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#offset_call}.
	 * @param ctx the parse tree
	 */
	void exitOffset_call(ValkyrieAntlrParser.Offset_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
	 * @param ctx the parse tree
	 */
	void enterMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
	 * @param ctx the parse tree
	 */
	void exitMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#macro_call_item}.
	 * @param ctx the parse tree
	 */
	void enterMacro_call_item(ValkyrieAntlrParser.Macro_call_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#macro_call_item}.
	 * @param ctx the parse tree
	 */
	void exitMacro_call_item(ValkyrieAntlrParser.Macro_call_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_call}.
	 * @param ctx the parse tree
	 */
	void enterMatch_call(ValkyrieAntlrParser.Match_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_call}.
	 * @param ctx the parse tree
	 */
	void exitMatch_call(ValkyrieAntlrParser.Match_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#catch_call}.
	 * @param ctx the parse tree
	 */
	void enterCatch_call(ValkyrieAntlrParser.Catch_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#catch_call}.
	 * @param ctx the parse tree
	 */
	void exitCatch_call(ValkyrieAntlrParser.Catch_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
	 * @param ctx the parse tree
	 */
	void enterMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
	 * @param ctx the parse tree
	 */
	void exitMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
	 * @param ctx the parse tree
	 */
	void enterMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
	 * @param ctx the parse tree
	 */
	void exitMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#with_block}.
	 * @param ctx the parse tree
	 */
	void enterWith_block(ValkyrieAntlrParser.With_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#with_block}.
	 * @param ctx the parse tree
	 */
	void exitWith_block(ValkyrieAntlrParser.With_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#when_block}.
	 * @param ctx the parse tree
	 */
	void enterWhen_block(ValkyrieAntlrParser.When_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#when_block}.
	 * @param ctx the parse tree
	 */
	void exitWhen_block(ValkyrieAntlrParser.When_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#else_pattern}.
	 * @param ctx the parse tree
	 */
	void enterElse_pattern(ValkyrieAntlrParser.Else_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#else_pattern}.
	 * @param ctx the parse tree
	 */
	void exitElse_pattern(ValkyrieAntlrParser.Else_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#case_pattern}.
	 * @param ctx the parse tree
	 */
	void enterCase_pattern(ValkyrieAntlrParser.Case_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern}.
	 * @param ctx the parse tree
	 */
	void exitCase_pattern(ValkyrieAntlrParser.Case_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_call}.
	 * @param ctx the parse tree
	 */
	void enterNew_call(ValkyrieAntlrParser.New_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_call}.
	 * @param ctx the parse tree
	 */
	void exitNew_call(ValkyrieAntlrParser.New_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_body}.
	 * @param ctx the parse tree
	 */
	void enterNew_body(ValkyrieAntlrParser.New_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_body}.
	 * @param ctx the parse tree
	 */
	void exitNew_body(ValkyrieAntlrParser.New_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
	 * @param ctx the parse tree
	 */
	void enterNew_block(ValkyrieAntlrParser.New_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
	 * @param ctx the parse tree
	 */
	void exitNew_block(ValkyrieAntlrParser.New_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
	 * @param ctx the parse tree
	 */
	void enterNew_statement(ValkyrieAntlrParser.New_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
	 * @param ctx the parse tree
	 */
	void exitNew_statement(ValkyrieAntlrParser.New_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void enterModifiers(ValkyrieAntlrParser.ModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void exitModifiers(ValkyrieAntlrParser.ModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
	 * @param ctx the parse tree
	 */
	void enterModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
	 * @param ctx the parse tree
	 */
	void exitModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
	 * @param ctx the parse tree
	 */
	void enterModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
	 * @param ctx the parse tree
	 */
	void exitModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
	 * @param ctx the parse tree
	 */
	void enterNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
	 * @param ctx the parse tree
	 */
	void exitNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
	 * @param ctx the parse tree
	 */
	void enterNamepath(ValkyrieAntlrParser.NamepathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
	 * @param ctx the parse tree
	 */
	void exitNamepath(ValkyrieAntlrParser.NamepathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ValkyrieAntlrParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ValkyrieAntlrParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ValkyrieAntlrParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ValkyrieAntlrParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(ValkyrieAntlrParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(ValkyrieAntlrParser.String_literalContext ctx);
}