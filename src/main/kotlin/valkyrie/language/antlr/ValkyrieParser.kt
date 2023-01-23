package valkyrie.language.antlr

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser.*
import valkyrie.language.ast.*
import valkyrie.language.ast.calls.ValkyrieCallGeneric
import valkyrie.language.ast.calls.ValkyrieCallMacro
import valkyrie.language.ast.pattern_match.ValkyrieCatchBlockNode
import valkyrie.language.ast.pattern_match.ValkyrieMatchBlockNode
import valkyrie.language.ast.pattern_match.ValkyrieWhenBlockNode
import valkyrie.language.ast.pattern_match.ValkyrieWithBlockNode

class ValkyrieParser(parser: ValkyrieAntlrParser) : ANTLRParserAdaptor(ValkyrieLanguage, parser) {
    override fun parse(parser: Parser, root: IElementType): ParseTree {
        return (parser as ValkyrieAntlrParser).program()
    }


    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        return super.parse(root, builder)
    }


    companion object {
        fun extractCompositeNode(node: CompositeElement): PsiElement {
            val type: RuleIElementType = node.elementType as RuleIElementType;
            return when (type.ruleIndex) {
                RULE_program -> ValkyrieProgramNode(node, type)
                RULE_define_namespace -> ValkyrieNamespaceStatement(node, type)
                RULE_import_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                // annotations
                RULE_modifiers -> ValkyrieModifiedNode(node, ValkyrieModifiedKind.Pure)
                RULE_modified_identifier -> ValkyrieModifiedNode(node, ValkyrieModifiedKind.ModifiedIdentifier)
                RULE_modified_namepath -> ValkyrieModifiedNode(node, ValkyrieModifiedKind.ModifiedNamepath)
                RULE_template_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                RULE_where_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                // class
                RULE_define_class -> ValkyrieClassStatement(node)
                RULE_class_inherit_item -> ValkyrieClassInheritItem(node)
                RULE_class_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                RULE_class_field -> ValkyrieClassFieldNode(node)
                RULE_class_method -> ValkyrieClassMethodNode(node)

                // flags
                RULE_define_bitflags -> ValkyrieFlagsStatement(node, type)
                RULE_bitflags_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                RULE_bitflags_item -> ValkyrieFlagsItemNode(node, type)
                // union
                RULE_define_union -> ValkyrieUnionStatement(node)
                RULE_union_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                RULE_define_variant -> ValkyrieVariantItem(node)
                RULE_variant_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                // trait
                RULE_define_trait -> ValkyrieTraitStatement(node, type)
                RULE_define_extends -> ValkyrieExtendsStatement(node)
                // function
                RULE_define_function -> ValkyrieFunctionStatement(node)
                RULE_function_parameters -> ValkyrieBlockNode(node, ValkyrieBlockKind.Parenthesis)
                RULE_parameter_item -> ValkyrieFunctionParameter(node, type)
                RULE_function_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                // variable
                RULE_define_variale -> ValkyrieLetStatement(node)
                RULE_let_parameter -> ValkyrieLetParameter(node)
                // control
                RULE_for_statement -> ValkyrieForStatement(node)
                RULE_while_statement -> ValkyrieWhileStatement(node)
                // pattern match
                RULE_match_call -> ValkyrieMatchBlockNode(node)
                RULE_catch_call -> ValkyrieCatchBlockNode(node)
                RULE_match_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                RULE_with_block -> ValkyrieWithBlockNode(node)
                RULE_when_block -> ValkyrieWhenBlockNode(node)
                // expression
                RULE_macro_call -> ValkyrieCallMacro(node)
                RULE_generic_call -> ValkyrieCallGeneric(node, true)
                RULE_generic_call_in_type -> ValkyrieCallGeneric(node, false)
                RULE_tuple_call_item -> ValkyrieCallArgument(node)
                RULE_expression -> extractExpression(node)
                // new
                RULE_new_call -> ValkyrieNewStatement(node)
                RULE_new_block -> ValkyrieBlockNode(node, ValkyrieBlockKind.Brace)
                // atomic
                RULE_namepath_free -> ValkyrieNamepathNode(node, type, true)
                RULE_namepath -> ValkyrieNamepathNode(node, type)
                RULE_identifier -> ValkyrieIdentifierNode(node)
                RULE_string_literal -> ValkyrieStringNode(node)
                RULE_number -> ValkyrieNumberNode(node)
                // comment


                else -> ANTLRPsiNode(node)
            }
        }

        fun getChildOfType(psi: PsiElement?, parserRule: Int): PsiElement? {
            if (psi != null) {
                for (child in psi.children) {
                    val type = child.node.elementType as RuleIElementType;
                    if (type.ruleIndex == parserRule) {
                        return child;
                    }
                }
            }
            return null;
        }

        fun getChildrenOfTypeAsList(psi: PsiElement?, parserRule: Int): List<PsiElement> {
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

