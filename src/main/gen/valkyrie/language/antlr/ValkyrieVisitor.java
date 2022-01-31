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
	 * Visit a parse tree produced by {@link ValkyrieParser#function_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_statements(ValkyrieParser.Function_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(ValkyrieParser.EosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#eos_free}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos_free(ValkyrieParser.Eos_freeContext ctx);
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
	 * Visit a parse tree produced by {@link ValkyrieParser#class_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_block(ValkyrieParser.Class_blockContext ctx);
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
	 * Visit a parse tree produced by {@link ValkyrieParser#class_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_field(ValkyrieParser.Class_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#class_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_method(ValkyrieParser.Class_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_trait}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_trait(ValkyrieParser.Define_traitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_extends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_extends(ValkyrieParser.Define_extendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_union(ValkyrieParser.Define_unionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#union_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_block(ValkyrieParser.Union_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#union_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_statements(ValkyrieParser.Union_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_variant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variant(ValkyrieParser.Define_variantContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#variant_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant_block(ValkyrieParser.Variant_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#variant_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant_statements(ValkyrieParser.Variant_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_bitflags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_bitflags(ValkyrieParser.Define_bitflagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#bitflags_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_block(ValkyrieParser.Bitflags_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#bitflags_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_statements(ValkyrieParser.Bitflags_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#bitflags_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_item(ValkyrieParser.Bitflags_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_type(ValkyrieParser.Define_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#type_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_hint(ValkyrieParser.Type_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#effect_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect_hint(ValkyrieParser.Effect_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_function(ValkyrieParser.Define_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#function_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameters(ValkyrieParser.Function_parametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#parameter_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_item(ValkyrieParser.Parameter_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#parameter_default}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_default(ValkyrieParser.Parameter_defaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(ValkyrieParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_lambda(ValkyrieParser.Define_lambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#lambda_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_call(ValkyrieParser.Lambda_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#function_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_block(ValkyrieParser.Function_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_variale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variale(ValkyrieParser.Define_varialeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(ValkyrieParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#else_if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if_statement(ValkyrieParser.Else_if_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(ValkyrieParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(ValkyrieParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(ValkyrieParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#for_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_pattern(ValkyrieParser.For_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#for_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_parameter(ValkyrieParser.For_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ValkyrieParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#inline_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_expression(ValkyrieParser.Inline_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTParens(ValkyrieParser.TParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTTerm(ValkyrieParser.TTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TPattern}
	 * labeled alternative in {@link ValkyrieParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTPattern(ValkyrieParser.TPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#prefix_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_call(ValkyrieParser.Prefix_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#suffix_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix_call(ValkyrieParser.Suffix_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#control_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_expression(ValkyrieParser.Control_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ValkyrieParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#op_compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_compare(ValkyrieParser.Op_compareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#op_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_pattern(ValkyrieParser.Op_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#op_multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_multiple(ValkyrieParser.Op_multipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#op_plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_plus(ValkyrieParser.Op_plusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#op_logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logic(ValkyrieParser.Op_logicContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#infix_is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfix_is(ValkyrieParser.Infix_isContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#infix_in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfix_in(ValkyrieParser.Infix_inContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#call_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_arguments(ValkyrieParser.Call_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#define_generic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_generic(ValkyrieParser.Define_genericContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#generic_call_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_call_type(ValkyrieParser.Generic_call_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#generic_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_call(ValkyrieParser.Generic_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#dot_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_call(ValkyrieParser.Dot_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#slice_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice_call(ValkyrieParser.Slice_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#offset_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffset_call(ValkyrieParser.Offset_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#macro_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_call(ValkyrieParser.Macro_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#macro_call_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_call_item(ValkyrieParser.Macro_call_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_statement(ValkyrieParser.Try_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#match_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_call(ValkyrieParser.Match_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#catch_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_call(ValkyrieParser.Catch_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#match_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_block(ValkyrieParser.Match_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#match_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_statement(ValkyrieParser.Match_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#with_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_block(ValkyrieParser.With_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#when_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen_block(ValkyrieParser.When_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#else_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_pattern(ValkyrieParser.Else_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#case_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_pattern(ValkyrieParser.Case_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(ValkyrieParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#modified_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModified_identifier(ValkyrieParser.Modified_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieParser#modified_namepath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModified_namepath(ValkyrieParser.Modified_namepathContext ctx);
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
}