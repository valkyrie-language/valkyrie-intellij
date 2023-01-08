// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\ValkyrieAntlr.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValkyrieAntlrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValkyrieAntlrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ValkyrieAntlrParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#top_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_statement(ValkyrieAntlrParser.Top_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_statements(ValkyrieAntlrParser.Function_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(ValkyrieAntlrParser.EosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_class(ValkyrieAntlrParser.Define_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_block(ValkyrieAntlrParser.Class_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_statements(ValkyrieAntlrParser.Class_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_method(ValkyrieAntlrParser.Class_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#trait_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrait_block(ValkyrieAntlrParser.Trait_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#trait_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrait_statements(ValkyrieAntlrParser.Trait_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_trait_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_trait_type(ValkyrieAntlrParser.Define_trait_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#variant_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant_statements(ValkyrieAntlrParser.Variant_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_bitflags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_bitflags(ValkyrieAntlrParser.Define_bitflagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_block(ValkyrieAntlrParser.Bitflags_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_statements(ValkyrieAntlrParser.Bitflags_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#bitflags_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitflags_item(ValkyrieAntlrParser.Bitflags_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(ValkyrieAntlrParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#dot_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_call(ValkyrieAntlrParser.Dot_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#lambda_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_call(ValkyrieAntlrParser.Lambda_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_variale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variale(ValkyrieAntlrParser.Define_varialeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_variale_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_variale_lhs(ValkyrieAntlrParser.Define_variale_lhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#let_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_parameter(ValkyrieAntlrParser.Let_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_hint(ValkyrieAntlrParser.Type_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#effect_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect_hint(ValkyrieAntlrParser.Effect_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(ValkyrieAntlrParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(ValkyrieAntlrParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(ValkyrieAntlrParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#for_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_pattern(ValkyrieAntlrParser.For_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_guard(ValkyrieAntlrParser.If_guardContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ValkyrieAntlrParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#inline_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_expression(ValkyrieAntlrParser.Inline_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TParens}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTParens(ValkyrieAntlrParser.TParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TTerm}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTTerm(ValkyrieAntlrParser.TTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TPattern}
	 * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTPattern(ValkyrieAntlrParser.TPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#prefix_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_call(ValkyrieAntlrParser.Prefix_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#suffix_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix_call(ValkyrieAntlrParser.Suffix_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#control_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_expression(ValkyrieAntlrParser.Control_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ValkyrieAntlrParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#offset_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffset_call(ValkyrieAntlrParser.Offset_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#macro_call_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_call_item(ValkyrieAntlrParser.Macro_call_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_call(ValkyrieAntlrParser.Match_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#catch_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_call(ValkyrieAntlrParser.Catch_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#with_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_block(ValkyrieAntlrParser.With_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#when_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen_block(ValkyrieAntlrParser.When_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#else_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_pattern(ValkyrieAntlrParser.Else_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_pattern(ValkyrieAntlrParser.Case_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#case_tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_tuple(ValkyrieAntlrParser.Case_tupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#case_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_term(ValkyrieAntlrParser.Case_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_call(ValkyrieAntlrParser.New_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_body(ValkyrieAntlrParser.New_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_block(ValkyrieAntlrParser.New_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_statement(ValkyrieAntlrParser.New_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(ValkyrieAntlrParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamepath(ValkyrieAntlrParser.NamepathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ValkyrieAntlrParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#number_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_literal(ValkyrieAntlrParser.Number_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ValkyrieAntlrParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(ValkyrieAntlrParser.String_literalContext ctx);
}