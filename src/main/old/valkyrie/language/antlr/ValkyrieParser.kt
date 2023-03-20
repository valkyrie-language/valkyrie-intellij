package valkyrie.language.antlr

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.PsiBuilder
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParseTreeToPSIConverter
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser.*
import valkyrie.language.ast.*
import valkyrie.language.ast.calls.ValkyrieAttributeItem
import valkyrie.language.ast.calls.ValkyrieCallMacro
import valkyrie.language.ast.classes.*
import valkyrie.language.ast.pattern_match.ValkyrieMatchStatement
import valkyrie.language.ast.unions.ValkyrieFlagsStatement
import valkyrie.language.ast.unions.ValkyrieFlagsStatementItem
import valkyrie.language.ast.unions.ValkyrieUnionStatement
import valkyrie.language.ast.unions.ValkyrieUnionStatementItem
import valkyrie.language.psi.types.ValkyrieBlockType
import valkyrie.language.psi.types.ValkyrieModifiedType

class ValkyrieParser(parser: ValkyrieAntlrParser) : ANTLRParserAdaptor(ValkyrieLanguage, parser) {
    override fun parse(parser: Parser, root: IElementType): ParseTree {
        return (parser as ValkyrieAntlrParser).program()
    }


    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        return super.parse(root, builder)
    }

    override fun createListener(parser: Parser?, root: IElementType?, builder: PsiBuilder?): ANTLRParseTreeToPSIConverter {
        return RuleRewriter(language, parser, builder)
    }

    companion object {
        fun extractCompositeNode(node: CompositeElement): PsiElement {
            return RuleRewriter.extract(node)
        }

        inline fun <reified T> getChildOfType(psi: PsiElement?): T? where T : PsiElement {
            if (psi != null) {
                return PsiTreeUtil.getChildOfType(psi, T::class.java)
            }
            return null
        }

        fun getChildOfType(psi: PsiElement?, parserRule: Int): PsiElement? {
            if (psi != null) {
                for (child in psi.children) {
                    val type = child.node.elementType as? RuleIElementType;
                    if (type?.ruleIndex == parserRule) {
                        return child;
                    }
                }
            }
            return null;
        }

        inline fun <reified T> getChildrenOfType(psi: PsiElement?): List<T> where T : PsiElement {
            if (psi != null) {
                return PsiTreeUtil.getChildrenOfTypeAsList(psi, T::class.java)
            }
            return emptyList()
        }


        fun getChildrenOfType(psi: PsiElement?, parserRule: Int): List<PsiElement> {
            val output = mutableListOf<PsiElement>();
            if (psi != null) {
                for (child in psi.children) {
                    val type = child.node.elementType as RuleIElementType;
                    if (type.ruleIndex == parserRule) {
                        output.add(child)
                    }
                }
            }
            return output;
        }
    }
}

private class RuleRewriter(language: Language, parser: Parser?, builder: PsiBuilder?) :
    ANTLRParseTreeToPSIConverter(language, parser, builder) {
    override fun enterEveryRule(ctx: ParserRuleContext?) {
        ProgressIndicatorProvider.checkCanceled()
        if (ignoreContext(ctx)) {
            return
        }
        markers.push(getBuilder().mark())
    }

    override fun exitEveryRule(ctx: ParserRuleContext?) {
        ProgressIndicatorProvider.checkCanceled()
        if (ignoreContext(ctx)) {
            return
        }
        val marker = markers.pop()
        val index = getRuleElementTypes()[ctx!!.ruleIndex];
        marker.done(index)
    }

    override fun visitErrorNode(node: ErrorNode?) {
        super.visitErrorNode(node)
    }

    override fun visitTerminal(node: TerminalNode?) {
        builder!!.advanceLexer()
    }


    private fun ignoreContext(ctx: ParserRuleContext?): Boolean {
        return when (ctx) {
            is ProgramContext, is Program_termContext,
            is Class_statemntsContext, is Flags_statementContext, is Union_statementsContext,
            is Trait_statementContext, is Extends_statementContext,
            is Function_statementContext, is Return_partContext,
            is Leading_expressionContext, is Loop_statementContext,
            is NamejoinContext, is Namejoin_freeContext, is Range_joinContext,
            -> true

            null -> true
            else -> false
        }

    }

    companion object {
        fun extract(node: CompositeElement): PsiElement {
            val type: RuleIElementType = node.elementType as RuleIElementType;
            return when (type.ruleIndex) {
//                RULE_program -> ValkyrieProgramNode(node, type)
                RULE_define_namespace -> ValkyrieNamespaceNode(node)
                RULE_import_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // annotations
                RULE_template_call -> ValkyrieTemplateStatement(node)
                RULE_modifiers -> ValkyrieModifiedNode(node, ValkyrieModifiedType.Pure)
                RULE_modified_identifier -> ValkyrieModifiedNode(node, ValkyrieModifiedType.ModifiedIdentifier)
                RULE_modified_namepath -> ValkyrieModifiedNode(node, ValkyrieModifiedType.ModifiedNamepath)
                RULE_template_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                RULE_where_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
//                RULE_attribute -> ValkyrieAnnotation(node)
                RULE_attribute_item -> ValkyrieAttributeItem(node)
                // class
                RULE_define_class -> ValkyrieClassStatement(node)
                RULE_define_generic -> ValkyrieGenericDeclaration(node)
                RULE_generic_item -> ValkyrieGenericDeclarationItem(node)
                RULE_class_inherit_item -> ValkyrieClassInheritItem(node)
                RULE_class_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                RULE_class_field -> ValkyrieClassFieldNode(node)
                RULE_class_method -> ValkyrieClassMethodNode(node)
                RULE_class_domain -> ValkyrieClassDomainNode(node)
                // flags, enumeration
                RULE_define_flags -> ValkyrieFlagsStatement(node)
                RULE_flags_item -> ValkyrieFlagsStatementItem(node, type)
                RULE_flags_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // union
                RULE_define_union -> ValkyrieUnionStatement(node)
                RULE_union_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                RULE_define_variant -> ValkyrieUnionStatementItem(node)
                RULE_variant_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // trait
                RULE_define_trait -> ValkyrieTraitStatement(node, type)
                RULE_define_extends -> ValkyrieExtendsStatement(node)
                RULE_trait_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // function
                RULE_define_function -> ValkyrieFunctionStatement(node)
                RULE_function_parameters -> ValkyrieBlockNode(node, ValkyrieBlockType.Parenthesis)
                RULE_parameter_item -> ValkyrieFunctionParameter(node)
                RULE_function_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // variable
                RULE_let_binding -> ValkyrieLetStatement(node)
                RULE_let_pattern -> ValkyrieLetPattern(node)
                RULE_let_pattern_item -> ValkyrieLetPatternItem(node)
                // control
//                RULE_for_statement -> ValkyrieForStatement(node)
//                RULE_while_statement -> ValkyrieWhileStatement(node)
                // pattern match
                RULE_match_statement -> {
//                    ValkyrieParser.getChildOfType(node.psi)
                    ValkyrieMatchStatement(node)
                    // ValkyrieCatchBlockNode(node)
                }
//                RULE_match_call -> {
//                    ValkyrieMatchCall(node)
//                }

                RULE_lambda_name -> ValkyrieLambdaSlot(node)


                RULE_match_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                RULE_match_case_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Indent)
                // expression
                RULE_extends_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // expression
                RULE_macro_call -> ValkyrieCallMacro(node)
                RULE_generic_call -> ValkyrieGenericCall(node, true)
                RULE_generic_call_in_type -> ValkyrieGenericCall(node, false)

                RULE_tuple_literal -> ValkyrieBlockNode(node, ValkyrieBlockType.Parenthesis)
                RULE_new_call_item -> ValkyrieCallArgument(node)
                RULE_tuple_call_item -> ValkyrieCallArgument(node)
                RULE_tuple_call_body -> ValkyrieBlockNode(node, ValkyrieBlockType.Parenthesis)
                // operators
                RULE_infix_map -> ValkyrieOperatorNode(node, ValkyrieOperatorKind.Infix)
                RULE_op_multiple -> ValkyrieOperatorNode(node, ValkyrieOperatorKind.Infix)

//                RULE_collection_literal -> ValkyrieBlockNode(node, ValkyrieBlockType.Parenthesis)
                RULE_main_expression -> extractExpression(node)
                RULE_dot_function_call -> ValkyrieCallFunction(node)
                // new
                RULE_object_statement -> ValkyrieObjectStatement(node)
                RULE_new_statement -> ValkyrieNewStatement(node)
                RULE_new_block -> ValkyrieBlockNode(node, ValkyrieBlockType.Brace)
                // atomic
                RULE_namepath_free -> ValkyrieNamepathNode(node, type, true)
                RULE_namepath -> ValkyrieNamepathNode(node, type)
                RULE_identifier -> ValkyrieIdentifierNode(node)
                RULE_string_literal -> ValkyrieStringNode(node)
                RULE_number -> ValkyrieNumberNode(node)
                // comment


                else -> ASTWrapperPsiElement(node)
            }
        }
    }
}

