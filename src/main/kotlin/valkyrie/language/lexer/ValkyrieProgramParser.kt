package valkyrie.language.lexer

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.ValkyrieParser.*
import valkyrie.language.ast.*

class ValkyrieProgramParser(parser: ValkyrieParser) : ANTLRParserAdaptor(ValkyrieLanguage, parser) {
    override fun parse(parser: Parser, root: IElementType): ParseTree {
        return (parser as ValkyrieParser).program()
    }


    companion object {
        fun extractCompositeNode(node: CompositeElement): PsiElement {
            val type: RuleIElementType = node.elementType as RuleIElementType;
            return when (type.ruleIndex) {
                RULE_program -> ValkyrieProgramNode(node, type)
                RULE_define_namespace -> ValkyrieNamespaceStatement(node, type)
                // class
                RULE_define_class -> {
                    ValkyrieClassStatement(node)
                }
                RULE_class_field -> ValkyrieClassFieldNode(node, type)
                RULE_modified_identifier -> ModifiedIdentifier(node)
                //
                RULE_define_bitflags -> ValkyrieFlagsStatement(node, type)
                RULE_bitflags_item -> ValkyrieFlagsItemNode(node, type)
                RULE_define_trait -> ValkyrieTraitStatement(node, type)
                //
                RULE_define_function -> ValkyrieFunctionStatement(node, type)
                RULE_parameter_item -> ValkyrieFunctionItem(node, type)
                //
                RULE_define_variale -> ValkyrieAssignStatement(node, type)
                //
                RULE_expression -> extractExpression(node)
                // atomic
                RULE_namepath_free -> ValkyrieNamepathNode(node, type, true)
                RULE_namepath -> ValkyrieNamepathNode(node, type)
                RULE_identifier -> ValkyrieIdentifierNode(node, type)
                RULE_number -> ValkyrieNumberNode(node)
                else -> ANTLRPsiNode(node)
            }
        }
    }
}

private fun extractExpression(node: CompositeElement): ANTLRPsiNode {
    val infix = node.findPsiChildByType(ValkyrieProgramLexer.OperatorInfix);
    return if (infix == null) {
//        println("extractExpression: ${node.elementType} ${node.text}")
        ANTLRPsiNode(node)
    } else {
        ValkyrieBinaryExpression(node, infix)
    }
}

