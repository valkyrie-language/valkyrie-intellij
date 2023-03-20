// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr/ValkyrieAntlr.g4 by ANTLR 4.13.1
package valkyrie.language.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValkyrieAntlrParser}.
 */
public interface ValkyrieAntlrListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(ValkyrieAntlrParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(ValkyrieAntlrParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#program_block}.
     *
     * @param ctx the parse tree
     */
    void enterProgram_block(ValkyrieAntlrParser.Program_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#program_block}.
     *
     * @param ctx the parse tree
     */
    void exitProgram_block(ValkyrieAntlrParser.Program_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#program_term}.
     *
     * @param ctx the parse tree
     */
    void enterProgram_term(ValkyrieAntlrParser.Program_termContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#program_term}.
     *
     * @param ctx the parse tree
     */
    void exitProgram_term(ValkyrieAntlrParser.Program_termContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#eos}.
     *
     * @param ctx the parse tree
     */
    void enterEos(ValkyrieAntlrParser.EosContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#eos}.
     *
     * @param ctx the parse tree
     */
    void exitEos(ValkyrieAntlrParser.EosContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
     *
     * @param ctx the parse tree
     */
    void enterEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#eos_free}.
     *
     * @param ctx the parse tree
     */
    void exitEos_free(ValkyrieAntlrParser.Eos_freeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_namespace}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_namespace(ValkyrieAntlrParser.Define_namespaceContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
     *
     * @param ctx the parse tree
     */
    void enterImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_statement}.
     *
     * @param ctx the parse tree
     */
    void exitImport_statement(ValkyrieAntlrParser.Import_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_term}.
     *
     * @param ctx the parse tree
     */
    void enterImport_term(ValkyrieAntlrParser.Import_termContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_term}.
     *
     * @param ctx the parse tree
     */
    void exitImport_term(ValkyrieAntlrParser.Import_termContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_all}.
     *
     * @param ctx the parse tree
     */
    void enterImport_all(ValkyrieAntlrParser.Import_allContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_all}.
     *
     * @param ctx the parse tree
     */
    void exitImport_all(ValkyrieAntlrParser.Import_allContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_space}.
     *
     * @param ctx the parse tree
     */
    void enterImport_space(ValkyrieAntlrParser.Import_spaceContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_space}.
     *
     * @param ctx the parse tree
     */
    void exitImport_space(ValkyrieAntlrParser.Import_spaceContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_name}.
     *
     * @param ctx the parse tree
     */
    void enterImport_name(ValkyrieAntlrParser.Import_nameContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_name}.
     *
     * @param ctx the parse tree
     */
    void exitImport_name(ValkyrieAntlrParser.Import_nameContext ctx);

    /**
     * Enter a parse tree produced by the {@code ImportMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void enterImportMacro(ValkyrieAntlrParser.ImportMacroContext ctx);

    /**
     * Exit a parse tree produced by the {@code ImportMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void exitImportMacro(ValkyrieAntlrParser.ImportMacroContext ctx);

    /**
     * Enter a parse tree produced by the {@code ImportAttribute}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void enterImportAttribute(ValkyrieAntlrParser.ImportAttributeContext ctx);

    /**
     * Exit a parse tree produced by the {@code ImportAttribute}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void exitImportAttribute(ValkyrieAntlrParser.ImportAttributeContext ctx);

    /**
     * Enter a parse tree produced by the {@code ImportIdentifier}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void enterImportIdentifier(ValkyrieAntlrParser.ImportIdentifierContext ctx);

    /**
     * Exit a parse tree produced by the {@code ImportIdentifier}
     * labeled alternative in {@link ValkyrieAntlrParser#import_name_item}.
     *
     * @param ctx the parse tree
     */
    void exitImportIdentifier(ValkyrieAntlrParser.ImportIdentifierContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_block}.
     *
     * @param ctx the parse tree
     */
    void enterImport_block(ValkyrieAntlrParser.Import_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_block}.
     *
     * @param ctx the parse tree
     */
    void exitImport_block(ValkyrieAntlrParser.Import_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#import_join}.
     *
     * @param ctx the parse tree
     */
    void enterImport_join(ValkyrieAntlrParser.Import_joinContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#import_join}.
     *
     * @param ctx the parse tree
     */
    void exitImport_join(ValkyrieAntlrParser.Import_joinContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_extension}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_extension(ValkyrieAntlrParser.Define_extensionContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_class(ValkyrieAntlrParser.Define_classContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_class}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_class(ValkyrieAntlrParser.Define_classContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
     *
     * @param ctx the parse tree
     */
    void enterClass_block(ValkyrieAntlrParser.Class_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_block}.
     *
     * @param ctx the parse tree
     */
    void exitClass_block(ValkyrieAntlrParser.Class_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_statemnts}.
     *
     * @param ctx the parse tree
     */
    void enterClass_statemnts(ValkyrieAntlrParser.Class_statemntsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_statemnts}.
     *
     * @param ctx the parse tree
     */
    void exitClass_statemnts(ValkyrieAntlrParser.Class_statemntsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
     *
     * @param ctx the parse tree
     */
    void enterClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit}.
     *
     * @param ctx the parse tree
     */
    void exitClass_inherit(ValkyrieAntlrParser.Class_inheritContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_inherit_item}.
     *
     * @param ctx the parse tree
     */
    void enterClass_inherit_item(ValkyrieAntlrParser.Class_inherit_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_inherit_item}.
     *
     * @param ctx the parse tree
     */
    void exitClass_inherit_item(ValkyrieAntlrParser.Class_inherit_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
     *
     * @param ctx the parse tree
     */
    void enterClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_field}.
     *
     * @param ctx the parse tree
     */
    void exitClass_field(ValkyrieAntlrParser.Class_fieldContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
     *
     * @param ctx the parse tree
     */
    void enterClass_method(ValkyrieAntlrParser.Class_methodContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_method}.
     *
     * @param ctx the parse tree
     */
    void exitClass_method(ValkyrieAntlrParser.Class_methodContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#class_domain}.
     *
     * @param ctx the parse tree
     */
    void enterClass_domain(ValkyrieAntlrParser.Class_domainContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#class_domain}.
     *
     * @param ctx the parse tree
     */
    void exitClass_domain(ValkyrieAntlrParser.Class_domainContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_trait}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_trait(ValkyrieAntlrParser.Define_traitContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#trait_block}.
     *
     * @param ctx the parse tree
     */
    void enterTrait_block(ValkyrieAntlrParser.Trait_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#trait_block}.
     *
     * @param ctx the parse tree
     */
    void exitTrait_block(ValkyrieAntlrParser.Trait_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#trait_statement}.
     *
     * @param ctx the parse tree
     */
    void enterTrait_statement(ValkyrieAntlrParser.Trait_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#trait_statement}.
     *
     * @param ctx the parse tree
     */
    void exitTrait_statement(ValkyrieAntlrParser.Trait_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_trait_type}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_trait_type(ValkyrieAntlrParser.Define_trait_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_trait_type}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_trait_type(ValkyrieAntlrParser.Define_trait_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_extends}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_extends(ValkyrieAntlrParser.Define_extendsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#extends_block}.
     *
     * @param ctx the parse tree
     */
    void enterExtends_block(ValkyrieAntlrParser.Extends_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#extends_block}.
     *
     * @param ctx the parse tree
     */
    void exitExtends_block(ValkyrieAntlrParser.Extends_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#extends_statement}.
     *
     * @param ctx the parse tree
     */
    void enterExtends_statement(ValkyrieAntlrParser.Extends_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#extends_statement}.
     *
     * @param ctx the parse tree
     */
    void exitExtends_statement(ValkyrieAntlrParser.Extends_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#with_implements}.
     *
     * @param ctx the parse tree
     */
    void enterWith_implements(ValkyrieAntlrParser.With_implementsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#with_implements}.
     *
     * @param ctx the parse tree
     */
    void exitWith_implements(ValkyrieAntlrParser.With_implementsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_union}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_union(ValkyrieAntlrParser.Define_unionContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#base_layout}.
     *
     * @param ctx the parse tree
     */
    void enterBase_layout(ValkyrieAntlrParser.Base_layoutContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#base_layout}.
     *
     * @param ctx the parse tree
     */
    void exitBase_layout(ValkyrieAntlrParser.Base_layoutContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
     *
     * @param ctx the parse tree
     */
    void enterUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#union_block}.
     *
     * @param ctx the parse tree
     */
    void exitUnion_block(ValkyrieAntlrParser.Union_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
     *
     * @param ctx the parse tree
     */
    void enterUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#union_statements}.
     *
     * @param ctx the parse tree
     */
    void exitUnion_statements(ValkyrieAntlrParser.Union_statementsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_variant}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_variant(ValkyrieAntlrParser.Define_variantContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
     *
     * @param ctx the parse tree
     */
    void enterVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#variant_block}.
     *
     * @param ctx the parse tree
     */
    void exitVariant_block(ValkyrieAntlrParser.Variant_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_flags}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_flags(ValkyrieAntlrParser.Define_flagsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_flags}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_flags(ValkyrieAntlrParser.Define_flagsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#flags_block}.
     *
     * @param ctx the parse tree
     */
    void enterFlags_block(ValkyrieAntlrParser.Flags_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#flags_block}.
     *
     * @param ctx the parse tree
     */
    void exitFlags_block(ValkyrieAntlrParser.Flags_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#flags_statement}.
     *
     * @param ctx the parse tree
     */
    void enterFlags_statement(ValkyrieAntlrParser.Flags_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#flags_statement}.
     *
     * @param ctx the parse tree
     */
    void exitFlags_statement(ValkyrieAntlrParser.Flags_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#flags_item}.
     *
     * @param ctx the parse tree
     */
    void enterFlags_item(ValkyrieAntlrParser.Flags_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#flags_item}.
     *
     * @param ctx the parse tree
     */
    void exitFlags_item(ValkyrieAntlrParser.Flags_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_function}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_function(ValkyrieAntlrParser.Define_functionContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
     *
     * @param ctx the parse tree
     */
    void enterFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_parameters}.
     *
     * @param ctx the parse tree
     */
    void exitFunction_parameters(ValkyrieAntlrParser.Function_parametersContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
     *
     * @param ctx the parse tree
     */
    void enterParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#parameter_item}.
     *
     * @param ctx the parse tree
     */
    void exitParameter_item(ValkyrieAntlrParser.Parameter_itemContext ctx);

    /**
     * Enter a parse tree produced by the {@code DictParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void enterDictParameters(ValkyrieAntlrParser.DictParametersContext ctx);

    /**
     * Exit a parse tree produced by the {@code DictParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void exitDictParameters(ValkyrieAntlrParser.DictParametersContext ctx);

    /**
     * Enter a parse tree produced by the {@code ListParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void enterListParameters(ValkyrieAntlrParser.ListParametersContext ctx);

    /**
     * Exit a parse tree produced by the {@code ListParameters}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void exitListParameters(ValkyrieAntlrParser.ListParametersContext ctx);

    /**
     * Enter a parse tree produced by the {@code ContextParameter}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void enterContextParameter(ValkyrieAntlrParser.ContextParameterContext ctx);

    /**
     * Exit a parse tree produced by the {@code ContextParameter}
     * labeled alternative in {@link ValkyrieAntlrParser#parameter_special}.
     *
     * @param ctx the parse tree
     */
    void exitContextParameter(ValkyrieAntlrParser.ContextParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#return_part}.
     *
     * @param ctx the parse tree
     */
    void enterReturn_part(ValkyrieAntlrParser.Return_partContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#return_part}.
     *
     * @param ctx the parse tree
     */
    void exitReturn_part(ValkyrieAntlrParser.Return_partContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#return_type}.
     *
     * @param ctx the parse tree
     */
    void enterReturn_type(ValkyrieAntlrParser.Return_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#return_type}.
     *
     * @param ctx the parse tree
     */
    void exitReturn_type(ValkyrieAntlrParser.Return_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#effect_type}.
     *
     * @param ctx the parse tree
     */
    void enterEffect_type(ValkyrieAntlrParser.Effect_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#effect_type}.
     *
     * @param ctx the parse tree
     */
    void exitEffect_type(ValkyrieAntlrParser.Effect_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
     *
     * @param ctx the parse tree
     */
    void enterParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#parameter_default}.
     *
     * @param ctx the parse tree
     */
    void exitParameter_default(ValkyrieAntlrParser.Parameter_defaultContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#dot_function_call}.
     *
     * @param ctx the parse tree
     */
    void enterDot_function_call(ValkyrieAntlrParser.Dot_function_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#dot_function_call}.
     *
     * @param ctx the parse tree
     */
    void exitDot_function_call(ValkyrieAntlrParser.Dot_function_callContext ctx);

    /**
     * Enter a parse tree produced by the {@code NormalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void enterNormalClosure(ValkyrieAntlrParser.NormalClosureContext ctx);

    /**
     * Exit a parse tree produced by the {@code NormalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void exitNormalClosure(ValkyrieAntlrParser.NormalClosureContext ctx);

    /**
     * Enter a parse tree produced by the {@code SlotClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void enterSlotClosure(ValkyrieAntlrParser.SlotClosureContext ctx);

    /**
     * Exit a parse tree produced by the {@code SlotClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void exitSlotClosure(ValkyrieAntlrParser.SlotClosureContext ctx);

    /**
     * Enter a parse tree produced by the {@code IntegerClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void enterIntegerClosure(ValkyrieAntlrParser.IntegerClosureContext ctx);

    /**
     * Exit a parse tree produced by the {@code IntegerClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void exitIntegerClosure(ValkyrieAntlrParser.IntegerClosureContext ctx);

    /**
     * Enter a parse tree produced by the {@code InternalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void enterInternalClosure(ValkyrieAntlrParser.InternalClosureContext ctx);

    /**
     * Exit a parse tree produced by the {@code InternalClosure}
     * labeled alternative in {@link ValkyrieAntlrParser#dot_closure_call}.
     *
     * @param ctx the parse tree
     */
    void exitInternalClosure(ValkyrieAntlrParser.InternalClosureContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
     *
     * @param ctx the parse tree
     */
    void enterTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_body}.
     *
     * @param ctx the parse tree
     */
    void exitTuple_call_body(ValkyrieAntlrParser.Tuple_call_bodyContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
     *
     * @param ctx the parse tree
     */
    void enterTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#tuple_call_item}.
     *
     * @param ctx the parse tree
     */
    void exitTuple_call_item(ValkyrieAntlrParser.Tuple_call_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_lambda}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_lambda(ValkyrieAntlrParser.Define_lambdaContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
     *
     * @param ctx the parse tree
     */
    void enterFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_block}.
     *
     * @param ctx the parse tree
     */
    void exitFunction_block(ValkyrieAntlrParser.Function_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#function_statement}.
     *
     * @param ctx the parse tree
     */
    void enterFunction_statement(ValkyrieAntlrParser.Function_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#function_statement}.
     *
     * @param ctx the parse tree
     */
    void exitFunction_statement(ValkyrieAntlrParser.Function_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#let_binding}.
     *
     * @param ctx the parse tree
     */
    void enterLet_binding(ValkyrieAntlrParser.Let_bindingContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#let_binding}.
     *
     * @param ctx the parse tree
     */
    void exitLet_binding(ValkyrieAntlrParser.Let_bindingContext ctx);

    /**
     * Enter a parse tree produced by the {@code LP1}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterLP1(ValkyrieAntlrParser.LP1Context ctx);

    /**
     * Exit a parse tree produced by the {@code LP1}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitLP1(ValkyrieAntlrParser.LP1Context ctx);

    /**
     * Enter a parse tree produced by the {@code LP2}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterLP2(ValkyrieAntlrParser.LP2Context ctx);

    /**
     * Exit a parse tree produced by the {@code LP2}
     * labeled alternative in {@link ValkyrieAntlrParser#let_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitLP2(ValkyrieAntlrParser.LP2Context ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_plain}.
     *
     * @param ctx the parse tree
     */
    void enterLet_pattern_plain(ValkyrieAntlrParser.Let_pattern_plainContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_plain}.
     *
     * @param ctx the parse tree
     */
    void exitLet_pattern_plain(ValkyrieAntlrParser.Let_pattern_plainContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_tuple}.
     *
     * @param ctx the parse tree
     */
    void enterLet_pattern_tuple(ValkyrieAntlrParser.Let_pattern_tupleContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_tuple}.
     *
     * @param ctx the parse tree
     */
    void exitLet_pattern_tuple(ValkyrieAntlrParser.Let_pattern_tupleContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_item}.
     *
     * @param ctx the parse tree
     */
    void enterLet_pattern_item(ValkyrieAntlrParser.Let_pattern_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#let_pattern_item}.
     *
     * @param ctx the parse tree
     */
    void exitLet_pattern_item(ValkyrieAntlrParser.Let_pattern_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_type}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_type(ValkyrieAntlrParser.Define_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
     *
     * @param ctx the parse tree
     */
    void enterType_hint(ValkyrieAntlrParser.Type_hintContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#type_hint}.
     *
     * @param ctx the parse tree
     */
    void exitType_hint(ValkyrieAntlrParser.Type_hintContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#type_pair}.
     *
     * @param ctx the parse tree
     */
    void enterType_pair(ValkyrieAntlrParser.Type_pairContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#type_pair}.
     *
     * @param ctx the parse tree
     */
    void exitType_pair(ValkyrieAntlrParser.Type_pairContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
     *
     * @param ctx the parse tree
     */
    void enterIf_statement(ValkyrieAntlrParser.If_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#if_statement}.
     *
     * @param ctx the parse tree
     */
    void exitIf_statement(ValkyrieAntlrParser.If_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#guard_statement}.
     *
     * @param ctx the parse tree
     */
    void enterGuard_statement(ValkyrieAntlrParser.Guard_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#guard_statement}.
     *
     * @param ctx the parse tree
     */
    void exitGuard_statement(ValkyrieAntlrParser.Guard_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
     *
     * @param ctx the parse tree
     */
    void enterElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#else_if_statement}.
     *
     * @param ctx the parse tree
     */
    void exitElse_if_statement(ValkyrieAntlrParser.Else_if_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#loop_statement}.
     *
     * @param ctx the parse tree
     */
    void enterLoop_statement(ValkyrieAntlrParser.Loop_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#loop_statement}.
     *
     * @param ctx the parse tree
     */
    void exitLoop_statement(ValkyrieAntlrParser.Loop_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
     *
     * @param ctx the parse tree
     */
    void enterWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#while_statement}.
     *
     * @param ctx the parse tree
     */
    void exitWhile_statement(ValkyrieAntlrParser.While_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#while_let_statement}.
     *
     * @param ctx the parse tree
     */
    void enterWhile_let_statement(ValkyrieAntlrParser.While_let_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#while_let_statement}.
     *
     * @param ctx the parse tree
     */
    void exitWhile_let_statement(ValkyrieAntlrParser.While_let_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
     *
     * @param ctx the parse tree
     */
    void enterFor_statement(ValkyrieAntlrParser.For_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#for_statement}.
     *
     * @param ctx the parse tree
     */
    void exitFor_statement(ValkyrieAntlrParser.For_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#for_dot_call}.
     *
     * @param ctx the parse tree
     */
    void enterFor_dot_call(ValkyrieAntlrParser.For_dot_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#for_dot_call}.
     *
     * @param ctx the parse tree
     */
    void exitFor_dot_call(ValkyrieAntlrParser.For_dot_callContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
     *
     * @param ctx the parse tree
     */
    void enterIf_guard(ValkyrieAntlrParser.If_guardContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#if_guard}.
     *
     * @param ctx the parse tree
     */
    void exitIf_guard(ValkyrieAntlrParser.If_guardContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#mark_label}.
     *
     * @param ctx the parse tree
     */
    void enterMark_label(ValkyrieAntlrParser.Mark_labelContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#mark_label}.
     *
     * @param ctx the parse tree
     */
    void exitMark_label(ValkyrieAntlrParser.Mark_labelContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#expression_root}.
     *
     * @param ctx the parse tree
     */
    void enterExpression_root(ValkyrieAntlrParser.Expression_rootContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#expression_root}.
     *
     * @param ctx the parse tree
     */
    void exitExpression_root(ValkyrieAntlrParser.Expression_rootContext ctx);

    /**
     * Enter a parse tree produced by the {@code EIf}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEIf(ValkyrieAntlrParser.EIfContext ctx);

    /**
     * Exit a parse tree produced by the {@code EIf}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEIf(ValkyrieAntlrParser.EIfContext ctx);

    /**
     * Enter a parse tree produced by the {@code EUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEUntil(ValkyrieAntlrParser.EUntilContext ctx);

    /**
     * Exit a parse tree produced by the {@code EUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEUntil(ValkyrieAntlrParser.EUntilContext ctx);

    /**
     * Enter a parse tree produced by the {@code EDotCall}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEDotCall(ValkyrieAntlrParser.EDotCallContext ctx);

    /**
     * Exit a parse tree produced by the {@code EDotCall}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEDotCall(ValkyrieAntlrParser.EDotCallContext ctx);

    /**
     * Enter a parse tree produced by the {@code EIn}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEIn(ValkyrieAntlrParser.EInContext ctx);

    /**
     * Exit a parse tree produced by the {@code EIn}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEIn(ValkyrieAntlrParser.EInContext ctx);

    /**
     * Enter a parse tree produced by the {@code EFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEFloor(ValkyrieAntlrParser.EFloorContext ctx);

    /**
     * Exit a parse tree produced by the {@code EFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEFloor(ValkyrieAntlrParser.EFloorContext ctx);

    /**
     * Enter a parse tree produced by the {@code EPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEPlus(ValkyrieAntlrParser.EPlusContext ctx);

    /**
     * Exit a parse tree produced by the {@code EPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEPlus(ValkyrieAntlrParser.EPlusContext ctx);

    /**
     * Enter a parse tree produced by the {@code ESlice}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterESlice(ValkyrieAntlrParser.ESliceContext ctx);

    /**
     * Exit a parse tree produced by the {@code ESlice}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitESlice(ValkyrieAntlrParser.ESliceContext ctx);

    /**
     * Enter a parse tree produced by the {@code ETry}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterETry(ValkyrieAntlrParser.ETryContext ctx);

    /**
     * Exit a parse tree produced by the {@code ETry}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitETry(ValkyrieAntlrParser.ETryContext ctx);

    /**
     * Enter a parse tree produced by the {@code EAs}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEAs(ValkyrieAntlrParser.EAsContext ctx);

    /**
     * Exit a parse tree produced by the {@code EAs}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEAs(ValkyrieAntlrParser.EAsContext ctx);

    /**
     * Enter a parse tree produced by the {@code EObject}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEObject(ValkyrieAntlrParser.EObjectContext ctx);

    /**
     * Exit a parse tree produced by the {@code EObject}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEObject(ValkyrieAntlrParser.EObjectContext ctx);

    /**
     * Enter a parse tree produced by the {@code ETuple}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterETuple(ValkyrieAntlrParser.ETupleContext ctx);

    /**
     * Exit a parse tree produced by the {@code ETuple}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitETuple(ValkyrieAntlrParser.ETupleContext ctx);

    /**
     * Enter a parse tree produced by the {@code ERange}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterERange(ValkyrieAntlrParser.ERangeContext ctx);

    /**
     * Exit a parse tree produced by the {@code ERange}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitERange(ValkyrieAntlrParser.ERangeContext ctx);

    /**
     * Enter a parse tree produced by the {@code EAssign}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEAssign(ValkyrieAntlrParser.EAssignContext ctx);

    /**
     * Exit a parse tree produced by the {@code EAssign}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEAssign(ValkyrieAntlrParser.EAssignContext ctx);

    /**
     * Enter a parse tree produced by the {@code EAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEAtom(ValkyrieAntlrParser.EAtomContext ctx);

    /**
     * Exit a parse tree produced by the {@code EAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEAtom(ValkyrieAntlrParser.EAtomContext ctx);

    /**
     * Enter a parse tree produced by the {@code EMul}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEMul(ValkyrieAntlrParser.EMulContext ctx);

    /**
     * Exit a parse tree produced by the {@code EMul}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEMul(ValkyrieAntlrParser.EMulContext ctx);

    /**
     * Enter a parse tree produced by the {@code EPipe}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEPipe(ValkyrieAntlrParser.EPipeContext ctx);

    /**
     * Exit a parse tree produced by the {@code EPipe}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEPipe(ValkyrieAntlrParser.EPipeContext ctx);

    /**
     * Enter a parse tree produced by the {@code ELambda}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterELambda(ValkyrieAntlrParser.ELambdaContext ctx);

    /**
     * Exit a parse tree produced by the {@code ELambda}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitELambda(ValkyrieAntlrParser.ELambdaContext ctx);

    /**
     * Enter a parse tree produced by the {@code EOrElse}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEOrElse(ValkyrieAntlrParser.EOrElseContext ctx);

    /**
     * Exit a parse tree produced by the {@code EOrElse}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEOrElse(ValkyrieAntlrParser.EOrElseContext ctx);

    /**
     * Enter a parse tree produced by the {@code EGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEGroup(ValkyrieAntlrParser.EGroupContext ctx);

    /**
     * Exit a parse tree produced by the {@code EGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEGroup(ValkyrieAntlrParser.EGroupContext ctx);

    /**
     * Enter a parse tree produced by the {@code EFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEFunction(ValkyrieAntlrParser.EFunctionContext ctx);

    /**
     * Exit a parse tree produced by the {@code EFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEFunction(ValkyrieAntlrParser.EFunctionContext ctx);

    /**
     * Enter a parse tree produced by the {@code ESuffix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterESuffix(ValkyrieAntlrParser.ESuffixContext ctx);

    /**
     * Exit a parse tree produced by the {@code ESuffix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitESuffix(ValkyrieAntlrParser.ESuffixContext ctx);

    /**
     * Enter a parse tree produced by the {@code EMatch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEMatch(ValkyrieAntlrParser.EMatchContext ctx);

    /**
     * Exit a parse tree produced by the {@code EMatch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEMatch(ValkyrieAntlrParser.EMatchContext ctx);

    /**
     * Enter a parse tree produced by the {@code EMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEMacro(ValkyrieAntlrParser.EMacroContext ctx);

    /**
     * Exit a parse tree produced by the {@code EMacro}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEMacro(ValkyrieAntlrParser.EMacroContext ctx);

    /**
     * Enter a parse tree produced by the {@code EPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEPrefix(ValkyrieAntlrParser.EPrefixContext ctx);

    /**
     * Exit a parse tree produced by the {@code EPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEPrefix(ValkyrieAntlrParser.EPrefixContext ctx);

    /**
     * Enter a parse tree produced by the {@code ECompare}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterECompare(ValkyrieAntlrParser.ECompareContext ctx);

    /**
     * Exit a parse tree produced by the {@code ECompare}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitECompare(ValkyrieAntlrParser.ECompareContext ctx);

    /**
     * Enter a parse tree produced by the {@code EGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEGeneric(ValkyrieAntlrParser.EGenericContext ctx);

    /**
     * Exit a parse tree produced by the {@code EGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEGeneric(ValkyrieAntlrParser.EGenericContext ctx);

    /**
     * Enter a parse tree produced by the {@code EIsA}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEIsA(ValkyrieAntlrParser.EIsAContext ctx);

    /**
     * Exit a parse tree produced by the {@code EIsA}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEIsA(ValkyrieAntlrParser.EIsAContext ctx);

    /**
     * Enter a parse tree produced by the {@code EPow}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEPow(ValkyrieAntlrParser.EPowContext ctx);

    /**
     * Exit a parse tree produced by the {@code EPow}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEPow(ValkyrieAntlrParser.EPowContext ctx);

    /**
     * Enter a parse tree produced by the {@code EDefine}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEDefine(ValkyrieAntlrParser.EDefineContext ctx);

    /**
     * Exit a parse tree produced by the {@code EDefine}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEDefine(ValkyrieAntlrParser.EDefineContext ctx);

    /**
     * Enter a parse tree produced by the {@code ESwitch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterESwitch(ValkyrieAntlrParser.ESwitchContext ctx);

    /**
     * Exit a parse tree produced by the {@code ESwitch}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitESwitch(ValkyrieAntlrParser.ESwitchContext ctx);

    /**
     * Enter a parse tree produced by the {@code EMap}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEMap(ValkyrieAntlrParser.EMapContext ctx);

    /**
     * Exit a parse tree produced by the {@code EMap}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEMap(ValkyrieAntlrParser.EMapContext ctx);

    /**
     * Enter a parse tree produced by the {@code ELogic}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterELogic(ValkyrieAntlrParser.ELogicContext ctx);

    /**
     * Exit a parse tree produced by the {@code ELogic}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitELogic(ValkyrieAntlrParser.ELogicContext ctx);

    /**
     * Enter a parse tree produced by the {@code ELoop}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterELoop(ValkyrieAntlrParser.ELoopContext ctx);

    /**
     * Exit a parse tree produced by the {@code ELoop}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitELoop(ValkyrieAntlrParser.ELoopContext ctx);

    /**
     * Enter a parse tree produced by the {@code EControl}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEControl(ValkyrieAntlrParser.EControlContext ctx);

    /**
     * Exit a parse tree produced by the {@code EControl}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEControl(ValkyrieAntlrParser.EControlContext ctx);

    /**
     * Enter a parse tree produced by the {@code ENew}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterENew(ValkyrieAntlrParser.ENewContext ctx);

    /**
     * Exit a parse tree produced by the {@code ENew}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitENew(ValkyrieAntlrParser.ENewContext ctx);

    /**
     * Enter a parse tree produced by the {@code ECeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterECeiling(ValkyrieAntlrParser.ECeilingContext ctx);

    /**
     * Exit a parse tree produced by the {@code ECeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitECeiling(ValkyrieAntlrParser.ECeilingContext ctx);

    /**
     * Enter a parse tree produced by the {@code EBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void enterEBitwise(ValkyrieAntlrParser.EBitwiseContext ctx);

    /**
     * Exit a parse tree produced by the {@code EBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#main_expression}.
     *
     * @param ctx the parse tree
     */
    void exitEBitwise(ValkyrieAntlrParser.EBitwiseContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#main_dot_call}.
     *
     * @param ctx the parse tree
     */
    void enterMain_dot_call(ValkyrieAntlrParser.Main_dot_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#main_dot_call}.
     *
     * @param ctx the parse tree
     */
    void exitMain_dot_call(ValkyrieAntlrParser.Main_dot_callContext ctx);

    /**
     * Enter a parse tree produced by the {@code ILogic}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterILogic(ValkyrieAntlrParser.ILogicContext ctx);

    /**
     * Exit a parse tree produced by the {@code ILogic}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitILogic(ValkyrieAntlrParser.ILogicContext ctx);

    /**
     * Enter a parse tree produced by the {@code IPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIPlus(ValkyrieAntlrParser.IPlusContext ctx);

    /**
     * Exit a parse tree produced by the {@code IPlus}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIPlus(ValkyrieAntlrParser.IPlusContext ctx);

    /**
     * Enter a parse tree produced by the {@code ICompare}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterICompare(ValkyrieAntlrParser.ICompareContext ctx);

    /**
     * Exit a parse tree produced by the {@code ICompare}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitICompare(ValkyrieAntlrParser.ICompareContext ctx);

    /**
     * Enter a parse tree produced by the {@code IGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIGeneric(ValkyrieAntlrParser.IGenericContext ctx);

    /**
     * Exit a parse tree produced by the {@code IGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIGeneric(ValkyrieAntlrParser.IGenericContext ctx);

    /**
     * Enter a parse tree produced by the {@code IFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIFunction(ValkyrieAntlrParser.IFunctionContext ctx);

    /**
     * Exit a parse tree produced by the {@code IFunction}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIFunction(ValkyrieAntlrParser.IFunctionContext ctx);

    /**
     * Enter a parse tree produced by the {@code IBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIBitwise(ValkyrieAntlrParser.IBitwiseContext ctx);

    /**
     * Exit a parse tree produced by the {@code IBitwise}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIBitwise(ValkyrieAntlrParser.IBitwiseContext ctx);

    /**
     * Enter a parse tree produced by the {@code IMap}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIMap(ValkyrieAntlrParser.IMapContext ctx);

    /**
     * Exit a parse tree produced by the {@code IMap}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIMap(ValkyrieAntlrParser.IMapContext ctx);

    /**
     * Enter a parse tree produced by the {@code IIs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIIs(ValkyrieAntlrParser.IIsContext ctx);

    /**
     * Exit a parse tree produced by the {@code IIs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIIs(ValkyrieAntlrParser.IIsContext ctx);

    /**
     * Enter a parse tree produced by the {@code ITuple}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterITuple(ValkyrieAntlrParser.ITupleContext ctx);

    /**
     * Exit a parse tree produced by the {@code ITuple}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitITuple(ValkyrieAntlrParser.ITupleContext ctx);

    /**
     * Enter a parse tree produced by the {@code IRange}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIRange(ValkyrieAntlrParser.IRangeContext ctx);

    /**
     * Exit a parse tree produced by the {@code IRange}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIRange(ValkyrieAntlrParser.IRangeContext ctx);

    /**
     * Enter a parse tree produced by the {@code IGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIGroup(ValkyrieAntlrParser.IGroupContext ctx);

    /**
     * Exit a parse tree produced by the {@code IGroup}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIGroup(ValkyrieAntlrParser.IGroupContext ctx);

    /**
     * Enter a parse tree produced by the {@code IMul}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIMul(ValkyrieAntlrParser.IMulContext ctx);

    /**
     * Exit a parse tree produced by the {@code IMul}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIMul(ValkyrieAntlrParser.IMulContext ctx);

    /**
     * Enter a parse tree produced by the {@code IAs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIAs(ValkyrieAntlrParser.IAsContext ctx);

    /**
     * Exit a parse tree produced by the {@code IAs}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIAs(ValkyrieAntlrParser.IAsContext ctx);

    /**
     * Enter a parse tree produced by the {@code IPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIPrefix(ValkyrieAntlrParser.IPrefixContext ctx);

    /**
     * Exit a parse tree produced by the {@code IPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIPrefix(ValkyrieAntlrParser.IPrefixContext ctx);

    /**
     * Enter a parse tree produced by the {@code IFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIFloor(ValkyrieAntlrParser.IFloorContext ctx);

    /**
     * Exit a parse tree produced by the {@code IFloor}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIFloor(ValkyrieAntlrParser.IFloorContext ctx);

    /**
     * Enter a parse tree produced by the {@code IAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterIAtom(ValkyrieAntlrParser.IAtomContext ctx);

    /**
     * Exit a parse tree produced by the {@code IAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitIAtom(ValkyrieAntlrParser.IAtomContext ctx);

    /**
     * Enter a parse tree produced by the {@code ICeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterICeiling(ValkyrieAntlrParser.ICeilingContext ctx);

    /**
     * Exit a parse tree produced by the {@code ICeiling}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitICeiling(ValkyrieAntlrParser.ICeilingContext ctx);

    /**
     * Enter a parse tree produced by the {@code ISlice}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void enterISlice(ValkyrieAntlrParser.ISliceContext ctx);

    /**
     * Exit a parse tree produced by the {@code ISlice}
     * labeled alternative in {@link ValkyrieAntlrParser#inline_expression}.
     *
     * @param ctx the parse tree
     */
    void exitISlice(ValkyrieAntlrParser.ISliceContext ctx);

    /**
     * Enter a parse tree produced by the {@code TBlock}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTBlock(ValkyrieAntlrParser.TBlockContext ctx);

    /**
     * Exit a parse tree produced by the {@code TBlock}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTBlock(ValkyrieAntlrParser.TBlockContext ctx);

    /**
     * Enter a parse tree produced by the {@code TPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTPrefix(ValkyrieAntlrParser.TPrefixContext ctx);

    /**
     * Exit a parse tree produced by the {@code TPrefix}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTPrefix(ValkyrieAntlrParser.TPrefixContext ctx);

    /**
     * Enter a parse tree produced by the {@code TGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTGeneric(ValkyrieAntlrParser.TGenericContext ctx);

    /**
     * Exit a parse tree produced by the {@code TGeneric}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTGeneric(ValkyrieAntlrParser.TGenericContext ctx);

    /**
     * Enter a parse tree produced by the {@code TPattern}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTPattern(ValkyrieAntlrParser.TPatternContext ctx);

    /**
     * Exit a parse tree produced by the {@code TPattern}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTPattern(ValkyrieAntlrParser.TPatternContext ctx);

    /**
     * Enter a parse tree produced by the {@code TTuple}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTTuple(ValkyrieAntlrParser.TTupleContext ctx);

    /**
     * Exit a parse tree produced by the {@code TTuple}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTTuple(ValkyrieAntlrParser.TTupleContext ctx);

    /**
     * Enter a parse tree produced by the {@code TMust}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTMust(ValkyrieAntlrParser.TMustContext ctx);

    /**
     * Exit a parse tree produced by the {@code TMust}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTMust(ValkyrieAntlrParser.TMustContext ctx);

    /**
     * Enter a parse tree produced by the {@code TAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTAtom(ValkyrieAntlrParser.TAtomContext ctx);

    /**
     * Exit a parse tree produced by the {@code TAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTAtom(ValkyrieAntlrParser.TAtomContext ctx);

    /**
     * Enter a parse tree produced by the {@code TAdd}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTAdd(ValkyrieAntlrParser.TAddContext ctx);

    /**
     * Exit a parse tree produced by the {@code TAdd}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTAdd(ValkyrieAntlrParser.TAddContext ctx);

    /**
     * Enter a parse tree produced by the {@code TKind}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTKind(ValkyrieAntlrParser.TKindContext ctx);

    /**
     * Exit a parse tree produced by the {@code TKind}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTKind(ValkyrieAntlrParser.TKindContext ctx);

    /**
     * Enter a parse tree produced by the {@code TArrows}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTArrows(ValkyrieAntlrParser.TArrowsContext ctx);

    /**
     * Exit a parse tree produced by the {@code TArrows}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTArrows(ValkyrieAntlrParser.TArrowsContext ctx);

    /**
     * Enter a parse tree produced by the {@code TOptional}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void enterTOptional(ValkyrieAntlrParser.TOptionalContext ctx);

    /**
     * Exit a parse tree produced by the {@code TOptional}
     * labeled alternative in {@link ValkyrieAntlrParser#type_expression}.
     *
     * @param ctx the parse tree
     */
    void exitTOptional(ValkyrieAntlrParser.TOptionalContext ctx);

    /**
     * Enter a parse tree produced by the {@code AString}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterAString(ValkyrieAntlrParser.AStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code AString}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitAString(ValkyrieAntlrParser.AStringContext ctx);

    /**
     * Enter a parse tree produced by the {@code ANumber}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterANumber(ValkyrieAntlrParser.ANumberContext ctx);

    /**
     * Exit a parse tree produced by the {@code ANumber}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitANumber(ValkyrieAntlrParser.ANumberContext ctx);

    /**
     * Enter a parse tree produced by the {@code ALambda}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterALambda(ValkyrieAntlrParser.ALambdaContext ctx);

    /**
     * Exit a parse tree produced by the {@code ALambda}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitALambda(ValkyrieAntlrParser.ALambdaContext ctx);

    /**
     * Enter a parse tree produced by the {@code AOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterAOutput(ValkyrieAntlrParser.AOutputContext ctx);

    /**
     * Exit a parse tree produced by the {@code AOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitAOutput(ValkyrieAntlrParser.AOutputContext ctx);

    /**
     * Enter a parse tree produced by the {@code ANamepath}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterANamepath(ValkyrieAntlrParser.ANamepathContext ctx);

    /**
     * Exit a parse tree produced by the {@code ANamepath}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitANamepath(ValkyrieAntlrParser.ANamepathContext ctx);

    /**
     * Enter a parse tree produced by the {@code ASpecial}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterASpecial(ValkyrieAntlrParser.ASpecialContext ctx);

    /**
     * Exit a parse tree produced by the {@code ASpecial}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitASpecial(ValkyrieAntlrParser.ASpecialContext ctx);

    /**
     * Enter a parse tree produced by the {@code AUNIMPLEMENTED}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void enterAUNIMPLEMENTED(ValkyrieAntlrParser.AUNIMPLEMENTEDContext ctx);

    /**
     * Exit a parse tree produced by the {@code AUNIMPLEMENTED}
     * labeled alternative in {@link ValkyrieAntlrParser#leading_expression}.
     *
     * @param ctx the parse tree
     */
    void exitAUNIMPLEMENTED(ValkyrieAntlrParser.AUNIMPLEMENTEDContext ctx);

    /**
     * Enter a parse tree produced by the {@code CReturn}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCReturn(ValkyrieAntlrParser.CReturnContext ctx);

    /**
     * Exit a parse tree produced by the {@code CReturn}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCReturn(ValkyrieAntlrParser.CReturnContext ctx);

    /**
     * Enter a parse tree produced by the {@code CBreak}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCBreak(ValkyrieAntlrParser.CBreakContext ctx);

    /**
     * Exit a parse tree produced by the {@code CBreak}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCBreak(ValkyrieAntlrParser.CBreakContext ctx);

    /**
     * Enter a parse tree produced by the {@code CContinue}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCContinue(ValkyrieAntlrParser.CContinueContext ctx);

    /**
     * Exit a parse tree produced by the {@code CContinue}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCContinue(ValkyrieAntlrParser.CContinueContext ctx);

    /**
     * Enter a parse tree produced by the {@code CRaise}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCRaise(ValkyrieAntlrParser.CRaiseContext ctx);

    /**
     * Exit a parse tree produced by the {@code CRaise}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCRaise(ValkyrieAntlrParser.CRaiseContext ctx);

    /**
     * Enter a parse tree produced by the {@code CYield}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCYield(ValkyrieAntlrParser.CYieldContext ctx);

    /**
     * Exit a parse tree produced by the {@code CYield}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCYield(ValkyrieAntlrParser.CYieldContext ctx);

    /**
     * Enter a parse tree produced by the {@code CWith}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCWith(ValkyrieAntlrParser.CWithContext ctx);

    /**
     * Exit a parse tree produced by the {@code CWith}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCWith(ValkyrieAntlrParser.CWithContext ctx);

    /**
     * Enter a parse tree produced by the {@code CFall}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void enterCFall(ValkyrieAntlrParser.CFallContext ctx);

    /**
     * Exit a parse tree produced by the {@code CFall}
     * labeled alternative in {@link ValkyrieAntlrParser#control_expression}.
     *
     * @param ctx the parse tree
     */
    void exitCFall(ValkyrieAntlrParser.CFallContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_prefix}.
     *
     * @param ctx the parse tree
     */
    void enterOp_prefix(ValkyrieAntlrParser.Op_prefixContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_prefix}.
     *
     * @param ctx the parse tree
     */
    void exitOp_prefix(ValkyrieAntlrParser.Op_prefixContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_suffix}.
     *
     * @param ctx the parse tree
     */
    void enterOp_suffix(ValkyrieAntlrParser.Op_suffixContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_suffix}.
     *
     * @param ctx the parse tree
     */
    void exitOp_suffix(ValkyrieAntlrParser.Op_suffixContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
     *
     * @param ctx the parse tree
     */
    void enterOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_compare}.
     *
     * @param ctx the parse tree
     */
    void exitOp_compare(ValkyrieAntlrParser.Op_compareContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitOp_pattern(ValkyrieAntlrParser.Op_patternContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_bitwise}.
     *
     * @param ctx the parse tree
     */
    void enterOp_bitwise(ValkyrieAntlrParser.Op_bitwiseContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_bitwise}.
     *
     * @param ctx the parse tree
     */
    void exitOp_bitwise(ValkyrieAntlrParser.Op_bitwiseContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_map}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_map(ValkyrieAntlrParser.Infix_mapContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_map}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_map(ValkyrieAntlrParser.Infix_mapContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_pow}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_pow(ValkyrieAntlrParser.Infix_powContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_pow}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_pow(ValkyrieAntlrParser.Infix_powContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_range}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_range(ValkyrieAntlrParser.Infix_rangeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_range}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_range(ValkyrieAntlrParser.Infix_rangeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_arrows}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_arrows(ValkyrieAntlrParser.Infix_arrowsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_arrows}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_arrows(ValkyrieAntlrParser.Infix_arrowsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
     *
     * @param ctx the parse tree
     */
    void enterOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_multiple}.
     *
     * @param ctx the parse tree
     */
    void exitOp_multiple(ValkyrieAntlrParser.Op_multipleContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
     *
     * @param ctx the parse tree
     */
    void enterOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_plus}.
     *
     * @param ctx the parse tree
     */
    void exitOp_plus(ValkyrieAntlrParser.Op_plusContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
     *
     * @param ctx the parse tree
     */
    void enterOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_logic}.
     *
     * @param ctx the parse tree
     */
    void exitOp_logic(ValkyrieAntlrParser.Op_logicContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#op_pipeline}.
     *
     * @param ctx the parse tree
     */
    void enterOp_pipeline(ValkyrieAntlrParser.Op_pipelineContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#op_pipeline}.
     *
     * @param ctx the parse tree
     */
    void exitOp_pipeline(ValkyrieAntlrParser.Op_pipelineContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_assign}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_assign(ValkyrieAntlrParser.Infix_assignContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_assign}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_assign(ValkyrieAntlrParser.Infix_assignContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_is}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_is(ValkyrieAntlrParser.Infix_isContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_as}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_as(ValkyrieAntlrParser.Infix_asContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_as}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_as(ValkyrieAntlrParser.Infix_asContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
     *
     * @param ctx the parse tree
     */
    void enterInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#infix_in}.
     *
     * @param ctx the parse tree
     */
    void exitInfix_in(ValkyrieAntlrParser.Infix_inContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_generic}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_generic(ValkyrieAntlrParser.Define_genericContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_item}.
     *
     * @param ctx the parse tree
     */
    void enterGeneric_item(ValkyrieAntlrParser.Generic_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_item}.
     *
     * @param ctx the parse tree
     */
    void exitGeneric_item(ValkyrieAntlrParser.Generic_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
     *
     * @param ctx the parse tree
     */
    void enterGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_call}.
     *
     * @param ctx the parse tree
     */
    void exitGeneric_call(ValkyrieAntlrParser.Generic_callContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
     *
     * @param ctx the parse tree
     */
    void enterGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_call_in_type}.
     *
     * @param ctx the parse tree
     */
    void exitGeneric_call_in_type(ValkyrieAntlrParser.Generic_call_in_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#generic_pair}.
     *
     * @param ctx the parse tree
     */
    void enterGeneric_pair(ValkyrieAntlrParser.Generic_pairContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#generic_pair}.
     *
     * @param ctx the parse tree
     */
    void exitGeneric_pair(ValkyrieAntlrParser.Generic_pairContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#define_label}.
     *
     * @param ctx the parse tree
     */
    void enterDefine_label(ValkyrieAntlrParser.Define_labelContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#define_label}.
     *
     * @param ctx the parse tree
     */
    void exitDefine_label(ValkyrieAntlrParser.Define_labelContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#template_call}.
     *
     * @param ctx the parse tree
     */
    void enterTemplate_call(ValkyrieAntlrParser.Template_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#template_call}.
     *
     * @param ctx the parse tree
     */
    void exitTemplate_call(ValkyrieAntlrParser.Template_callContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#template_block}.
     *
     * @param ctx the parse tree
     */
    void enterTemplate_block(ValkyrieAntlrParser.Template_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#template_block}.
     *
     * @param ctx the parse tree
     */
    void exitTemplate_block(ValkyrieAntlrParser.Template_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#template_statements}.
     *
     * @param ctx the parse tree
     */
    void enterTemplate_statements(ValkyrieAntlrParser.Template_statementsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#template_statements}.
     *
     * @param ctx the parse tree
     */
    void exitTemplate_statements(ValkyrieAntlrParser.Template_statementsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#template_term}.
     *
     * @param ctx the parse tree
     */
    void enterTemplate_term(ValkyrieAntlrParser.Template_termContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#template_term}.
     *
     * @param ctx the parse tree
     */
    void exitTemplate_term(ValkyrieAntlrParser.Template_termContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#template_implements}.
     *
     * @param ctx the parse tree
     */
    void enterTemplate_implements(ValkyrieAntlrParser.Template_implementsContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#template_implements}.
     *
     * @param ctx the parse tree
     */
    void exitTemplate_implements(ValkyrieAntlrParser.Template_implementsContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#where_block}.
     *
     * @param ctx the parse tree
     */
    void enterWhere_block(ValkyrieAntlrParser.Where_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#where_block}.
     *
     * @param ctx the parse tree
     */
    void exitWhere_block(ValkyrieAntlrParser.Where_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#where_bound}.
     *
     * @param ctx the parse tree
     */
    void enterWhere_bound(ValkyrieAntlrParser.Where_boundContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#where_bound}.
     *
     * @param ctx the parse tree
     */
    void exitWhere_bound(ValkyrieAntlrParser.Where_boundContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#require_block}.
     *
     * @param ctx the parse tree
     */
    void enterRequire_block(ValkyrieAntlrParser.Require_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#require_block}.
     *
     * @param ctx the parse tree
     */
    void exitRequire_block(ValkyrieAntlrParser.Require_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
     *
     * @param ctx the parse tree
     */
    void enterMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#macro_call}.
     *
     * @param ctx the parse tree
     */
    void exitMacro_call(ValkyrieAntlrParser.Macro_callContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#macro_item}.
     *
     * @param ctx the parse tree
     */
    void enterMacro_item(ValkyrieAntlrParser.Macro_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#macro_item}.
     *
     * @param ctx the parse tree
     */
    void exitMacro_item(ValkyrieAntlrParser.Macro_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#attribute}.
     *
     * @param ctx the parse tree
     */
    void enterAttribute(ValkyrieAntlrParser.AttributeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#attribute}.
     *
     * @param ctx the parse tree
     */
    void exitAttribute(ValkyrieAntlrParser.AttributeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#attribute_item}.
     *
     * @param ctx the parse tree
     */
    void enterAttribute_item(ValkyrieAntlrParser.Attribute_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#attribute_item}.
     *
     * @param ctx the parse tree
     */
    void exitAttribute_item(ValkyrieAntlrParser.Attribute_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
     *
     * @param ctx the parse tree
     */
    void enterTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#try_statement}.
     *
     * @param ctx the parse tree
     */
    void exitTry_statement(ValkyrieAntlrParser.Try_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
     *
     * @param ctx the parse tree
     */
    void enterMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_statement}.
     *
     * @param ctx the parse tree
     */
    void exitMatch_statement(ValkyrieAntlrParser.Match_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#switch_statement}.
     *
     * @param ctx the parse tree
     */
    void enterSwitch_statement(ValkyrieAntlrParser.Switch_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#switch_statement}.
     *
     * @param ctx the parse tree
     */
    void exitSwitch_statement(ValkyrieAntlrParser.Switch_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
     *
     * @param ctx the parse tree
     */
    void enterMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_block}.
     *
     * @param ctx the parse tree
     */
    void exitMatch_block(ValkyrieAntlrParser.Match_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#dot_match_call}.
     *
     * @param ctx the parse tree
     */
    void enterDot_match_call(ValkyrieAntlrParser.Dot_match_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#dot_match_call}.
     *
     * @param ctx the parse tree
     */
    void exitDot_match_call(ValkyrieAntlrParser.Dot_match_callContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchWith}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchWith(ValkyrieAntlrParser.MatchWithContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchWith}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchWith(ValkyrieAntlrParser.MatchWithContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchWithMany}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchWithMany(ValkyrieAntlrParser.MatchWithManyContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchWithMany}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchWithMany(ValkyrieAntlrParser.MatchWithManyContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchType}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchType(ValkyrieAntlrParser.MatchTypeContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchType}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchType(ValkyrieAntlrParser.MatchTypeContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchWhen}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchWhen(ValkyrieAntlrParser.MatchWhenContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchWhen}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchWhen(ValkyrieAntlrParser.MatchWhenContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchElse}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchElse(ValkyrieAntlrParser.MatchElseContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchElse}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchElse(ValkyrieAntlrParser.MatchElseContext ctx);

    /**
     * Enter a parse tree produced by the {@code MatchCase}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void enterMatchCase(ValkyrieAntlrParser.MatchCaseContext ctx);

    /**
     * Exit a parse tree produced by the {@code MatchCase}
     * labeled alternative in {@link ValkyrieAntlrParser#match_terms}.
     *
     * @param ctx the parse tree
     */
    void exitMatchCase(ValkyrieAntlrParser.MatchCaseContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#match_case_block}.
     *
     * @param ctx the parse tree
     */
    void enterMatch_case_block(ValkyrieAntlrParser.Match_case_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#match_case_block}.
     *
     * @param ctx the parse tree
     */
    void exitMatch_case_block(ValkyrieAntlrParser.Match_case_blockContext ctx);

    /**
     * Enter a parse tree produced by the {@code CaseOR}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterCaseOR(ValkyrieAntlrParser.CaseORContext ctx);

    /**
     * Exit a parse tree produced by the {@code CaseOR}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitCaseOR(ValkyrieAntlrParser.CaseORContext ctx);

    /**
     * Enter a parse tree produced by the {@code CaseAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterCaseAtom(ValkyrieAntlrParser.CaseAtomContext ctx);

    /**
     * Exit a parse tree produced by the {@code CaseAtom}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitCaseAtom(ValkyrieAntlrParser.CaseAtomContext ctx);

    /**
     * Enter a parse tree produced by the {@code CaseUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void enterCaseUntil(ValkyrieAntlrParser.CaseUntilContext ctx);

    /**
     * Exit a parse tree produced by the {@code CaseUntil}
     * labeled alternative in {@link ValkyrieAntlrParser#case_pattern}.
     *
     * @param ctx the parse tree
     */
    void exitCaseUntil(ValkyrieAntlrParser.CaseUntilContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_item}.
     *
     * @param ctx the parse tree
     */
    void enterCase_pattern_item(ValkyrieAntlrParser.Case_pattern_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_item}.
     *
     * @param ctx the parse tree
     */
    void exitCase_pattern_item(ValkyrieAntlrParser.Case_pattern_itemContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_tuple}.
     *
     * @param ctx the parse tree
     */
    void enterCase_pattern_tuple(ValkyrieAntlrParser.Case_pattern_tupleContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#case_pattern_tuple}.
     *
     * @param ctx the parse tree
     */
    void exitCase_pattern_tuple(ValkyrieAntlrParser.Case_pattern_tupleContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#object_statement}.
     *
     * @param ctx the parse tree
     */
    void enterObject_statement(ValkyrieAntlrParser.Object_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#object_statement}.
     *
     * @param ctx the parse tree
     */
    void exitObject_statement(ValkyrieAntlrParser.Object_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
     *
     * @param ctx the parse tree
     */
    void enterNew_statement(ValkyrieAntlrParser.New_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_statement}.
     *
     * @param ctx the parse tree
     */
    void exitNew_statement(ValkyrieAntlrParser.New_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
     *
     * @param ctx the parse tree
     */
    void enterNew_block(ValkyrieAntlrParser.New_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_block}.
     *
     * @param ctx the parse tree
     */
    void exitNew_block(ValkyrieAntlrParser.New_blockContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#new_call_item}.
     *
     * @param ctx the parse tree
     */
    void enterNew_call_item(ValkyrieAntlrParser.New_call_itemContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#new_call_item}.
     *
     * @param ctx the parse tree
     */
    void exitNew_call_item(ValkyrieAntlrParser.New_call_itemContext ctx);

    /**
     * Enter a parse tree produced by the {@code NK1}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void enterNK1(ValkyrieAntlrParser.NK1Context ctx);

    /**
     * Exit a parse tree produced by the {@code NK1}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void exitNK1(ValkyrieAntlrParser.NK1Context ctx);

    /**
     * Enter a parse tree produced by the {@code NK2}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void enterNK2(ValkyrieAntlrParser.NK2Context ctx);

    /**
     * Exit a parse tree produced by the {@code NK2}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void exitNK2(ValkyrieAntlrParser.NK2Context ctx);

    /**
     * Enter a parse tree produced by the {@code NK3}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void enterNK3(ValkyrieAntlrParser.NK3Context ctx);

    /**
     * Exit a parse tree produced by the {@code NK3}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void exitNK3(ValkyrieAntlrParser.NK3Context ctx);

    /**
     * Enter a parse tree produced by the {@code NK4}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void enterNK4(ValkyrieAntlrParser.NK4Context ctx);

    /**
     * Exit a parse tree produced by the {@code NK4}
     * labeled alternative in {@link ValkyrieAntlrParser#new_call_key}.
     *
     * @param ctx the parse tree
     */
    void exitNK4(ValkyrieAntlrParser.NK4Context ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#tuple_literal}.
     *
     * @param ctx the parse tree
     */
    void enterTuple_literal(ValkyrieAntlrParser.Tuple_literalContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#tuple_literal}.
     *
     * @param ctx the parse tree
     */
    void exitTuple_literal(ValkyrieAntlrParser.Tuple_literalContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#collection_pair}.
     *
     * @param ctx the parse tree
     */
    void enterCollection_pair(ValkyrieAntlrParser.Collection_pairContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#collection_pair}.
     *
     * @param ctx the parse tree
     */
    void exitCollection_pair(ValkyrieAntlrParser.Collection_pairContext ctx);

    /**
     * Enter a parse tree produced by the {@code CK1}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void enterCK1(ValkyrieAntlrParser.CK1Context ctx);

    /**
     * Exit a parse tree produced by the {@code CK1}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void exitCK1(ValkyrieAntlrParser.CK1Context ctx);

    /**
     * Enter a parse tree produced by the {@code CK2}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void enterCK2(ValkyrieAntlrParser.CK2Context ctx);

    /**
     * Exit a parse tree produced by the {@code CK2}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void exitCK2(ValkyrieAntlrParser.CK2Context ctx);

    /**
     * Enter a parse tree produced by the {@code CK3}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void enterCK3(ValkyrieAntlrParser.CK3Context ctx);

    /**
     * Exit a parse tree produced by the {@code CK3}
     * labeled alternative in {@link ValkyrieAntlrParser#collection_key}.
     *
     * @param ctx the parse tree
     */
    void exitCK3(ValkyrieAntlrParser.CK3Context ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
     *
     * @param ctx the parse tree
     */
    void enterSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#slice_call}.
     *
     * @param ctx the parse tree
     */
    void exitSlice_call(ValkyrieAntlrParser.Slice_callContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#range_literal}.
     *
     * @param ctx the parse tree
     */
    void enterRange_literal(ValkyrieAntlrParser.Range_literalContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#range_literal}.
     *
     * @param ctx the parse tree
     */
    void exitRange_literal(ValkyrieAntlrParser.Range_literalContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#range_axis}.
     *
     * @param ctx the parse tree
     */
    void enterRange_axis(ValkyrieAntlrParser.Range_axisContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#range_axis}.
     *
     * @param ctx the parse tree
     */
    void exitRange_axis(ValkyrieAntlrParser.Range_axisContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
     *
     * @param ctx the parse tree
     */
    void enterModifiers(ValkyrieAntlrParser.ModifiersContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#modifiers}.
     *
     * @param ctx the parse tree
     */
    void exitModifiers(ValkyrieAntlrParser.ModifiersContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
     *
     * @param ctx the parse tree
     */
    void enterModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#modified_identifier}.
     *
     * @param ctx the parse tree
     */
    void exitModified_identifier(ValkyrieAntlrParser.Modified_identifierContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
     *
     * @param ctx the parse tree
     */
    void enterModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#modified_namepath}.
     *
     * @param ctx the parse tree
     */
    void exitModified_namepath(ValkyrieAntlrParser.Modified_namepathContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#lambda_name}.
     *
     * @param ctx the parse tree
     */
    void enterLambda_name(ValkyrieAntlrParser.Lambda_nameContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#lambda_name}.
     *
     * @param ctx the parse tree
     */
    void exitLambda_name(ValkyrieAntlrParser.Lambda_nameContext ctx);

    /**
     * Enter a parse tree produced by the {@code PositiveOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     */
    void enterPositiveOutput(ValkyrieAntlrParser.PositiveOutputContext ctx);

    /**
     * Exit a parse tree produced by the {@code PositiveOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     */
    void exitPositiveOutput(ValkyrieAntlrParser.PositiveOutputContext ctx);

    /**
     * Enter a parse tree produced by the {@code NegativeOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     */
    void enterNegativeOutput(ValkyrieAntlrParser.NegativeOutputContext ctx);

    /**
     * Exit a parse tree produced by the {@code NegativeOutput}
     * labeled alternative in {@link ValkyrieAntlrParser#output_name}.
     *
     * @param ctx the parse tree
     */
    void exitNegativeOutput(ValkyrieAntlrParser.NegativeOutputContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#range_join}.
     *
     * @param ctx the parse tree
     */
    void enterRange_join(ValkyrieAntlrParser.Range_joinContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#range_join}.
     *
     * @param ctx the parse tree
     */
    void exitRange_join(ValkyrieAntlrParser.Range_joinContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
     *
     * @param ctx the parse tree
     */
    void enterNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#namepath_free}.
     *
     * @param ctx the parse tree
     */
    void exitNamepath_free(ValkyrieAntlrParser.Namepath_freeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#namejoin_free}.
     *
     * @param ctx the parse tree
     */
    void enterNamejoin_free(ValkyrieAntlrParser.Namejoin_freeContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#namejoin_free}.
     *
     * @param ctx the parse tree
     */
    void exitNamejoin_free(ValkyrieAntlrParser.Namejoin_freeContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
     *
     * @param ctx the parse tree
     */
    void enterNamepath(ValkyrieAntlrParser.NamepathContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#namepath}.
     *
     * @param ctx the parse tree
     */
    void exitNamepath(ValkyrieAntlrParser.NamepathContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#namejoin}.
     *
     * @param ctx the parse tree
     */
    void enterNamejoin(ValkyrieAntlrParser.NamejoinContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#namejoin}.
     *
     * @param ctx the parse tree
     */
    void exitNamejoin(ValkyrieAntlrParser.NamejoinContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void enterIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void exitIdentifier(ValkyrieAntlrParser.IdentifierContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#number}.
     *
     * @param ctx the parse tree
     */
    void enterNumber(ValkyrieAntlrParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#number}.
     *
     * @param ctx the parse tree
     */
    void exitNumber(ValkyrieAntlrParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#number_literal}.
     *
     * @param ctx the parse tree
     */
    void enterNumber_literal(ValkyrieAntlrParser.Number_literalContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#number_literal}.
     *
     * @param ctx the parse tree
     */
    void exitNumber_literal(ValkyrieAntlrParser.Number_literalContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#string}.
     *
     * @param ctx the parse tree
     */
    void enterString(ValkyrieAntlrParser.StringContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#string}.
     *
     * @param ctx the parse tree
     */
    void exitString(ValkyrieAntlrParser.StringContext ctx);

    /**
     * Enter a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
     *
     * @param ctx the parse tree
     */
    void enterString_literal(ValkyrieAntlrParser.String_literalContext ctx);

    /**
     * Exit a parse tree produced by {@link ValkyrieAntlrParser#string_literal}.
     *
     * @param ctx the parse tree
     */
    void exitString_literal(ValkyrieAntlrParser.String_literalContext ctx);
}