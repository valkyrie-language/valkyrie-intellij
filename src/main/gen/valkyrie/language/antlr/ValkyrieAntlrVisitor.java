// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr/ValkyrieAntlr.g4 by ANTLR 4.13.1
package valkyrie.language.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValkyrieAntlrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ValkyrieAntlrVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(ValkyrieAntlrParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#program_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram_block(ValkyrieAntlrParser.Program_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#program_term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram_term(ValkyrieAntlrParser.Program_termContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#eos}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEos(ValkyrieAntlrParser.EosContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_term(ValkyrieAntlrParser.Import_termContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_all}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_all(ValkyrieAntlrParser.Import_allContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_space}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_space(ValkyrieAntlrParser.Import_spaceContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_name(ValkyrieAntlrParser.Import_nameContext ctx);

    /**
     * Visit a parse tree produced by the {@code ImportMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImportMacro(ValkyrieAntlrParser.ImportMacroContext ctx);

    /**
     * Visit a parse tree produced by the {@code ImportAttribute}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImportAttribute(ValkyrieAntlrParser.ImportAttributeContext ctx);

    /**
     * Visit a parse tree produced by the {@code ImportIdentifier}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImportIdentifier(ValkyrieAntlrParser.ImportIdentifierContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_block(ValkyrieAntlrParser.Import_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#import_join}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImport_join(ValkyrieAntlrParser.Import_joinContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_class(ValkyrieAntlrParser.Define_classContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_block(ValkyrieAntlrParser.Class_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_statemnts}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_statemnts(ValkyrieAntlrParser.Class_statemntsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_inherit_item(ValkyrieAntlrParser.Class_inherit_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_method(ValkyrieAntlrParser.Class_methodContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#class_domain}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClass_domain(ValkyrieAntlrParser.Class_domainContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#trait_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrait_block(ValkyrieAntlrParser.Trait_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#trait_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrait_statement(ValkyrieAntlrParser.Trait_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_trait_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_trait_type(ValkyrieAntlrParser.Define_trait_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#extends_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExtends_block(ValkyrieAntlrParser.Extends_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#extends_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExtends_statement(ValkyrieAntlrParser.Extends_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#with_implements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWith_implements(ValkyrieAntlrParser.With_implementsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#base_layout}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBase_layout(ValkyrieAntlrParser.Base_layoutContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_flags}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_flags(ValkyrieAntlrParser.Define_flagsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#flags_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFlags_block(ValkyrieAntlrParser.Flags_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#flags_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFlags_statement(ValkyrieAntlrParser.Flags_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#flags_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFlags_item(ValkyrieAntlrParser.Flags_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);

    /**
     * Visit a parse tree produced by the {@code DictParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDictParameters(ValkyrieAntlrParser.DictParametersContext ctx);

    /**
     * Visit a parse tree produced by the {@code ListParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitListParameters(ValkyrieAntlrParser.ListParametersContext ctx);

    /**
     * Visit a parse tree produced by the {@code ContextParameter}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitContextParameter(ValkyrieAntlrParser.ContextParameterContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#return_part}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturn_part(ValkyrieAntlrParser.Return_partContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#return_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturn_type(ValkyrieAntlrParser.Return_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#effect_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEffect_type(ValkyrieAntlrParser.Effect_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#dot_function_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDot_function_call(ValkyrieAntlrParser.Dot_function_callContext ctx);

    /**
     * Visit a parse tree produced by the {@code NormalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNormalClosure(ValkyrieAntlrParser.NormalClosureContext ctx);

    /**
     * Visit a parse tree produced by the {@code SlotClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSlotClosure(ValkyrieAntlrParser.SlotClosureContext ctx);

    /**
     * Visit a parse tree produced by the {@code IntegerClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntegerClosure(ValkyrieAntlrParser.IntegerClosureContext ctx);

    /**
     * Visit a parse tree produced by the {@code InternalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInternalClosure(ValkyrieAntlrParser.InternalClosureContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#function_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction_statement(ValkyrieAntlrParser.Function_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#let_binding}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLet_binding(ValkyrieAntlrParser.Let_bindingContext ctx);

    /**
     * Visit a parse tree produced by the {@code LP1}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLP1(ValkyrieAntlrParser.LP1Context ctx);

    /**
     * Visit a parse tree produced by the {@code LP2}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLP2(ValkyrieAntlrParser.LP2Context ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_plain}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLet_pattern_plain(ValkyrieAntlrParser.Let_pattern_plainContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_tuple}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLet_pattern_tuple(ValkyrieAntlrParser.Let_pattern_tupleContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLet_pattern_item(ValkyrieAntlrParser.Let_pattern_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_hint(ValkyrieAntlrParser.Type_hintContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#type_pair}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_pair(ValkyrieAntlrParser.Type_pairContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf_statement(ValkyrieAntlrParser.If_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#guard_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGuard_statement(ValkyrieAntlrParser.Guard_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#loop_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLoop_statement(ValkyrieAntlrParser.Loop_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#while_let_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhile_let_statement(ValkyrieAntlrParser.While_let_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_statement(ValkyrieAntlrParser.For_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#for_dot_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_dot_call(ValkyrieAntlrParser.For_dot_callContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf_guard(ValkyrieAntlrParser.If_guardContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#mark_label}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMark_label(ValkyrieAntlrParser.Mark_labelContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#expression_root}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression_root(ValkyrieAntlrParser.Expression_rootContext ctx);

    /**
     * Visit a parse tree produced by the {@code EIf}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEIf(ValkyrieAntlrParser.EIfContext ctx);

    /**
     * Visit a parse tree produced by the {@code EUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEUntil(ValkyrieAntlrParser.EUntilContext ctx);

    /**
     * Visit a parse tree produced by the {@code EDotCall}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEDotCall(ValkyrieAntlrParser.EDotCallContext ctx);

    /**
     * Visit a parse tree produced by the {@code EIn}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEIn(ValkyrieAntlrParser.EInContext ctx);

    /**
     * Visit a parse tree produced by the {@code EFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEFloor(ValkyrieAntlrParser.EFloorContext ctx);

    /**
     * Visit a parse tree produced by the {@code EPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEPlus(ValkyrieAntlrParser.EPlusContext ctx);

    /**
     * Visit a parse tree produced by the {@code ESlice}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitESlice(ValkyrieAntlrParser.ESliceContext ctx);

    /**
     * Visit a parse tree produced by the {@code ETry}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitETry(ValkyrieAntlrParser.ETryContext ctx);

    /**
     * Visit a parse tree produced by the {@code EAs}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEAs(ValkyrieAntlrParser.EAsContext ctx);

    /**
     * Visit a parse tree produced by the {@code EObject}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEObject(ValkyrieAntlrParser.EObjectContext ctx);

    /**
     * Visit a parse tree produced by the {@code ETuple}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitETuple(ValkyrieAntlrParser.ETupleContext ctx);

    /**
     * Visit a parse tree produced by the {@code ERange}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitERange(ValkyrieAntlrParser.ERangeContext ctx);

    /**
     * Visit a parse tree produced by the {@code EAssign}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEAssign(ValkyrieAntlrParser.EAssignContext ctx);

    /**
     * Visit a parse tree produced by the {@code EAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEAtom(ValkyrieAntlrParser.EAtomContext ctx);

    /**
     * Visit a parse tree produced by the {@code EMul}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEMul(ValkyrieAntlrParser.EMulContext ctx);

    /**
     * Visit a parse tree produced by the {@code EPipe}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEPipe(ValkyrieAntlrParser.EPipeContext ctx);

    /**
     * Visit a parse tree produced by the {@code ELambda}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitELambda(ValkyrieAntlrParser.ELambdaContext ctx);

    /**
     * Visit a parse tree produced by the {@code EOrElse}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEOrElse(ValkyrieAntlrParser.EOrElseContext ctx);

    /**
     * Visit a parse tree produced by the {@code EGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEGroup(ValkyrieAntlrParser.EGroupContext ctx);

    /**
     * Visit a parse tree produced by the {@code EFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEFunction(ValkyrieAntlrParser.EFunctionContext ctx);

    /**
     * Visit a parse tree produced by the {@code ESuffix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitESuffix(ValkyrieAntlrParser.ESuffixContext ctx);

    /**
     * Visit a parse tree produced by the {@code EMatch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEMatch(ValkyrieAntlrParser.EMatchContext ctx);

    /**
     * Visit a parse tree produced by the {@code EMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEMacro(ValkyrieAntlrParser.EMacroContext ctx);

    /**
     * Visit a parse tree produced by the {@code EPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEPrefix(ValkyrieAntlrParser.EPrefixContext ctx);

    /**
     * Visit a parse tree produced by the {@code ECompare}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitECompare(ValkyrieAntlrParser.ECompareContext ctx);

    /**
     * Visit a parse tree produced by the {@code EGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEGeneric(ValkyrieAntlrParser.EGenericContext ctx);

    /**
     * Visit a parse tree produced by the {@code EIsA}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEIsA(ValkyrieAntlrParser.EIsAContext ctx);

    /**
     * Visit a parse tree produced by the {@code EPow}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEPow(ValkyrieAntlrParser.EPowContext ctx);

    /**
     * Visit a parse tree produced by the {@code EDefine}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEDefine(ValkyrieAntlrParser.EDefineContext ctx);

    /**
     * Visit a parse tree produced by the {@code ESwitch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitESwitch(ValkyrieAntlrParser.ESwitchContext ctx);

    /**
     * Visit a parse tree produced by the {@code EMap}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEMap(ValkyrieAntlrParser.EMapContext ctx);

    /**
     * Visit a parse tree produced by the {@code ELogic}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitELogic(ValkyrieAntlrParser.ELogicContext ctx);

    /**
     * Visit a parse tree produced by the {@code ELoop}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitELoop(ValkyrieAntlrParser.ELoopContext ctx);

    /**
     * Visit a parse tree produced by the {@code EControl}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEControl(ValkyrieAntlrParser.EControlContext ctx);

    /**
     * Visit a parse tree produced by the {@code ENew}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitENew(ValkyrieAntlrParser.ENewContext ctx);

    /**
     * Visit a parse tree produced by the {@code ECeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitECeiling(ValkyrieAntlrParser.ECeilingContext ctx);

    /**
     * Visit a parse tree produced by the {@code EBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEBitwise(ValkyrieAntlrParser.EBitwiseContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#main_dot_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMain_dot_call(ValkyrieAntlrParser.Main_dot_callContext ctx);

    /**
     * Visit a parse tree produced by the {@code ILogic}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitILogic(ValkyrieAntlrParser.ILogicContext ctx);

    /**
     * Visit a parse tree produced by the {@code IPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIPlus(ValkyrieAntlrParser.IPlusContext ctx);

    /**
     * Visit a parse tree produced by the {@code ICompare}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitICompare(ValkyrieAntlrParser.ICompareContext ctx);

    /**
     * Visit a parse tree produced by the {@code IGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIGeneric(ValkyrieAntlrParser.IGenericContext ctx);

    /**
     * Visit a parse tree produced by the {@code IFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIFunction(ValkyrieAntlrParser.IFunctionContext ctx);

    /**
     * Visit a parse tree produced by the {@code IBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIBitwise(ValkyrieAntlrParser.IBitwiseContext ctx);

    /**
     * Visit a parse tree produced by the {@code IMap}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIMap(ValkyrieAntlrParser.IMapContext ctx);

    /**
     * Visit a parse tree produced by the {@code IIs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIIs(ValkyrieAntlrParser.IIsContext ctx);

    /**
     * Visit a parse tree produced by the {@code ITuple}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitITuple(ValkyrieAntlrParser.ITupleContext ctx);

    /**
     * Visit a parse tree produced by the {@code IRange}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIRange(ValkyrieAntlrParser.IRangeContext ctx);

    /**
     * Visit a parse tree produced by the {@code IGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIGroup(ValkyrieAntlrParser.IGroupContext ctx);

    /**
     * Visit a parse tree produced by the {@code IMul}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIMul(ValkyrieAntlrParser.IMulContext ctx);

    /**
     * Visit a parse tree produced by the {@code IAs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIAs(ValkyrieAntlrParser.IAsContext ctx);

    /**
     * Visit a parse tree produced by the {@code IPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIPrefix(ValkyrieAntlrParser.IPrefixContext ctx);

    /**
     * Visit a parse tree produced by the {@code IFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIFloor(ValkyrieAntlrParser.IFloorContext ctx);

    /**
     * Visit a parse tree produced by the {@code IAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIAtom(ValkyrieAntlrParser.IAtomContext ctx);

    /**
     * Visit a parse tree produced by the {@code ICeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitICeiling(ValkyrieAntlrParser.ICeilingContext ctx);

    /**
     * Visit a parse tree produced by the {@code ISlice}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitISlice(ValkyrieAntlrParser.ISliceContext ctx);

    /**
     * Visit a parse tree produced by the {@code TBlock}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTBlock(ValkyrieAntlrParser.TBlockContext ctx);

    /**
     * Visit a parse tree produced by the {@code TPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTPrefix(ValkyrieAntlrParser.TPrefixContext ctx);

    /**
     * Visit a parse tree produced by the {@code TGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTGeneric(ValkyrieAntlrParser.TGenericContext ctx);

    /**
     * Visit a parse tree produced by the {@code TPattern}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTPattern(ValkyrieAntlrParser.TPatternContext ctx);

    /**
     * Visit a parse tree produced by the {@code TTuple}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTTuple(ValkyrieAntlrParser.TTupleContext ctx);

    /**
     * Visit a parse tree produced by the {@code TMust}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTMust(ValkyrieAntlrParser.TMustContext ctx);

    /**
     * Visit a parse tree produced by the {@code TAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTAtom(ValkyrieAntlrParser.TAtomContext ctx);

    /**
     * Visit a parse tree produced by the {@code TAdd}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTAdd(ValkyrieAntlrParser.TAddContext ctx);

    /**
     * Visit a parse tree produced by the {@code TKind}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTKind(ValkyrieAntlrParser.TKindContext ctx);

    /**
     * Visit a parse tree produced by the {@code TArrows}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTArrows(ValkyrieAntlrParser.TArrowsContext ctx);

    /**
     * Visit a parse tree produced by the {@code TOptional}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTOptional(ValkyrieAntlrParser.TOptionalContext ctx);

    /**
     * Visit a parse tree produced by the {@code AString}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAString(ValkyrieAntlrParser.AStringContext ctx);

    /**
     * Visit a parse tree produced by the {@code ANumber}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitANumber(ValkyrieAntlrParser.ANumberContext ctx);

    /**
     * Visit a parse tree produced by the {@code ALambda}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitALambda(ValkyrieAntlrParser.ALambdaContext ctx);

    /**
     * Visit a parse tree produced by the {@code AOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAOutput(ValkyrieAntlrParser.AOutputContext ctx);

    /**
     * Visit a parse tree produced by the {@code ANamepath}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitANamepath(ValkyrieAntlrParser.ANamepathContext ctx);

    /**
     * Visit a parse tree produced by the {@code ASpecial}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitASpecial(ValkyrieAntlrParser.ASpecialContext ctx);

    /**
     * Visit a parse tree produced by the {@code AUNIMPLEMENTED}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAUNIMPLEMENTED(ValkyrieAntlrParser.AUNIMPLEMENTEDContext ctx);

    /**
     * Visit a parse tree produced by the {@code CReturn}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCReturn(ValkyrieAntlrParser.CReturnContext ctx);

    /**
     * Visit a parse tree produced by the {@code CBreak}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCBreak(ValkyrieAntlrParser.CBreakContext ctx);

    /**
     * Visit a parse tree produced by the {@code CContinue}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCContinue(ValkyrieAntlrParser.CContinueContext ctx);

    /**
     * Visit a parse tree produced by the {@code CRaise}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCRaise(ValkyrieAntlrParser.CRaiseContext ctx);

    /**
     * Visit a parse tree produced by the {@code CYield}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCYield(ValkyrieAntlrParser.CYieldContext ctx);

    /**
     * Visit a parse tree produced by the {@code CWith}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCWith(ValkyrieAntlrParser.CWithContext ctx);

    /**
     * Visit a parse tree produced by the {@code CFall}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCFall(ValkyrieAntlrParser.CFallContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_prefix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_prefix(ValkyrieAntlrParser.Op_prefixContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_suffix}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_suffix(ValkyrieAntlrParser.Op_suffixContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_bitwise}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_bitwise(ValkyrieAntlrParser.Op_bitwiseContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_map}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_map(ValkyrieAntlrParser.Infix_mapContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_pow}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_pow(ValkyrieAntlrParser.Infix_powContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_range}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_range(ValkyrieAntlrParser.Infix_rangeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_arrows}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_arrows(ValkyrieAntlrParser.Infix_arrowsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#op_pipeline}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp_pipeline(ValkyrieAntlrParser.Op_pipelineContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_assign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_assign(ValkyrieAntlrParser.Infix_assignContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_as}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_as(ValkyrieAntlrParser.Infix_asContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGeneric_item(ValkyrieAntlrParser.Generic_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#generic_pair}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGeneric_pair(ValkyrieAntlrParser.Generic_pairContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#define_label}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine_label(ValkyrieAntlrParser.Define_labelContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#template_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTemplate_call(ValkyrieAntlrParser.Template_callContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#template_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTemplate_block(ValkyrieAntlrParser.Template_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#template_statements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTemplate_statements(ValkyrieAntlrParser.Template_statementsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#template_term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTemplate_term(ValkyrieAntlrParser.Template_termContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#template_implements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTemplate_implements(ValkyrieAntlrParser.Template_implementsContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#where_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhere_block(ValkyrieAntlrParser.Where_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#where_bound}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhere_bound(ValkyrieAntlrParser.Where_boundContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#require_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRequire_block(ValkyrieAntlrParser.Require_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#macro_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMacro_item(ValkyrieAntlrParser.Macro_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#attribute}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttribute(ValkyrieAntlrParser.AttributeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#attribute_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttribute_item(ValkyrieAntlrParser.Attribute_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#switch_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSwitch_statement(ValkyrieAntlrParser.Switch_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#dot_match_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDot_match_call(ValkyrieAntlrParser.Dot_match_callContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchWith}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchWith(ValkyrieAntlrParser.MatchWithContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchWithMany}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchWithMany(ValkyrieAntlrParser.MatchWithManyContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchType}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchType(ValkyrieAntlrParser.MatchTypeContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchWhen}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchWhen(ValkyrieAntlrParser.MatchWhenContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchElse}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchElse(ValkyrieAntlrParser.MatchElseContext ctx);

    /**
     * Visit a parse tree produced by the {@code MatchCase}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatchCase(ValkyrieAntlrParser.MatchCaseContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#match_case_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMatch_case_block(ValkyrieAntlrParser.Match_case_blockContext ctx);

    /**
     * Visit a parse tree produced by the {@code CaseOR}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCaseOR(ValkyrieAntlrParser.CaseORContext ctx);

    /**
     * Visit a parse tree produced by the {@code CaseAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCaseAtom(ValkyrieAntlrParser.CaseAtomContext ctx);

    /**
     * Visit a parse tree produced by the {@code CaseUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCaseUntil(ValkyrieAntlrParser.CaseUntilContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCase_pattern_item(ValkyrieAntlrParser.Case_pattern_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_tuple}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCase_pattern_tuple(ValkyrieAntlrParser.Case_pattern_tupleContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#object_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitObject_statement(ValkyrieAntlrParser.Object_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNew_statement(ValkyrieAntlrParser.New_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNew_block(ValkyrieAntlrParser.New_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#new_call_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNew_call_item(ValkyrieAntlrParser.New_call_itemContext ctx);

    /**
     * Visit a parse tree produced by the {@code NK1}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNK1(ValkyrieAntlrParser.NK1Context ctx);

    /**
     * Visit a parse tree produced by the {@code NK2}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNK2(ValkyrieAntlrParser.NK2Context ctx);

    /**
     * Visit a parse tree produced by the {@code NK3}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNK3(ValkyrieAntlrParser.NK3Context ctx);

    /**
     * Visit a parse tree produced by the {@code NK4}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNK4(ValkyrieAntlrParser.NK4Context ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#tuple_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTuple_literal(ValkyrieAntlrParser.Tuple_literalContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#collection_pair}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCollection_pair(ValkyrieAntlrParser.Collection_pairContext ctx);

    /**
     * Visit a parse tree produced by the {@code CK1}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCK1(ValkyrieAntlrParser.CK1Context ctx);

    /**
     * Visit a parse tree produced by the {@code CK2}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCK2(ValkyrieAntlrParser.CK2Context ctx);

    /**
     * Visit a parse tree produced by the {@code CK3}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCK3(ValkyrieAntlrParser.CK3Context ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#range_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange_literal(ValkyrieAntlrParser.Range_literalContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#range_axis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange_axis(ValkyrieAntlrParser.Range_axisContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModifiers(ValkyrieAntlrParser.ModifiersContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#lambda_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLambda_name(ValkyrieAntlrParser.Lambda_nameContext ctx);

    /**
     * Visit a parse tree produced by the {@code PositiveOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPositiveOutput(ValkyrieAntlrParser.PositiveOutputContext ctx);

    /**
     * Visit a parse tree produced by the {@code NegativeOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNegativeOutput(ValkyrieAntlrParser.NegativeOutputContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#range_join}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange_join(ValkyrieAntlrParser.Range_joinContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#namejoin_free}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamejoin_free(ValkyrieAntlrParser.Namejoin_freeContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamepath(ValkyrieAntlrParser.NamepathContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#namejoin}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamejoin(ValkyrieAntlrParser.NamejoinContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumber(ValkyrieAntlrParser.NumberContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#number_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumber_literal(ValkyrieAntlrParser.Number_literalContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#string}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString(ValkyrieAntlrParser.StringContext ctx);

    /**
     * Visit a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString_literal(ValkyrieAntlrParser.String_literalContext ctx);
}