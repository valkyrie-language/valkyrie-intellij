package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.psi.nodes.*
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlAttributeNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlElementNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlSlotExpressionNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlTextNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcTemplateNode

/**
 * Valkyrie PSI 元素工厂
 */
object ValkyrieElementFactory {
    /**
     * 获取工厂实例
     */
    fun getInstance(project: Project): ValkyrieElementFactory = this

    fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            ValkyrieElementTypes.FILE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LET_STATEMENT -> ValkyrieLetStatementNode(node)
            ValkyrieElementTypes.CLASS_STATEMENT -> ValkyrieClassDeclaration(node)
            ValkyrieElementTypes.NEURAL_STATEMENT -> ValkyrieNeuralDeclaration(node)
            ValkyrieElementTypes.WIDGET_STATEMENT -> ValkyrieWidgetDeclaration(node)
            ValkyrieElementTypes.SINGLETON_STATEMENT -> ValkyrieSingletonDeclaration(node)
            ValkyrieElementTypes.UNION_STATEMENT -> ValkyrieUnionDeclaration(node)
            ValkyrieElementTypes.FLAGS_STATEMENT -> ValkyrieUnionDeclaration(node) // 复用UnionDeclaration
            ValkyrieElementTypes.TRAIT_STATEMENT -> ValkyrieTraitDeclaration(node)
            ValkyrieElementTypes.TRAIT_ALIAS -> ValkyrieTraitAliasDeclaration(node)
            ValkyrieElementTypes.IMPLY_STATEMENT -> ValkyrieImplyStatement(node)
            ValkyrieElementTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceDeclaration(node)
            ValkyrieElementTypes.NAMESPACE_PATH -> ValkyrieElementNode(node)
            ValkyrieElementTypes.USING_STATEMENT -> ValkyrieUsingStatement(node)
            ValkyrieElementTypes.EXPRESSION_STATEMENT -> ValkyrieTermExpression(node)
            ValkyrieElementTypes.BLOCK_STATEMENT -> ValkyrieBlockStatementNode(node)
            ValkyrieElementTypes.OBJECT_BODY -> ValkyrieObjectBodyNode(node)
            ValkyrieElementTypes.UNION_BODY -> ValkyrieUnionBodyNode(node)
            ValkyrieElementTypes.EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionNode(node)
            ValkyrieElementTypes.BINARY_EXPRESSION -> ValkyrieBinaryTerm(node)
            ValkyrieElementTypes.UNARY_EXPRESSION -> ValkyrieUnaryTerm(node)
            ValkyrieElementTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionNode(node)
            ValkyrieElementTypes.CALL_EXPRESSION -> ValkyrieCallExpressionNode(node)
            ValkyrieElementTypes.CALL_TYPE_ARGUMENT -> ValkyrieGenericCallExpressionNode(node)
            ValkyrieElementTypes.POSTFIX_EXPRESSION -> ValkyriePostfixExpressionNode(node)
            ValkyrieElementTypes.ARRAY_EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TABLE_EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TABLE_PAIR -> ValkyrieElementNode(node)
            ValkyrieElementTypes.SLICE_EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.SLICE_ITEM -> ValkyrieElementNode(node)
            ValkyrieElementTypes.INDEX_EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TABLE_TYPE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.FIELD_DECLARATION -> ValkyrieFieldDeclaration(node)
            ValkyrieElementTypes.METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.INSTANCE_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.STATIC_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.DOMAIN_DECLARATION -> ValkyrieDomainDeclaration(node)
            ValkyrieElementTypes.UNION_VARIANT -> ValkyrieVariantDeclaration(node)
            ValkyrieElementTypes.FLAGS_ITEM -> ValkyrieVariantDeclaration(node)
            ValkyrieElementTypes.PATTERN -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TUPLE_PATTERN -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_NODE -> ValkyrieIdentifierNode(node)
            ValkyrieElementTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceNode(node)
            ValkyrieElementTypes.TYPE_HINT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.RETURN_TYPE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.EFFECT_TYPE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.DEFAULT_TYPE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.DEFAULT_VALUE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TERM_PARAMETER_LIST -> ValkyrieTermParameterList(node)
            ValkyrieElementTypes.TERM_PARAMETER_ITEM -> ValkyrieTermParameterItem(node)
            ValkyrieElementTypes.GENERIC_PARAMETER_LIST -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ANNOTATION_NODE -> ValkyrieAnnotationNode(node)
            ValkyrieElementTypes.MODIFIER_NODE -> ValkyrieModifierNode(node)
            ValkyrieElementTypes.ATTRIBUTE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ATTRIBUTE_LIST -> ValkyrieElementNode(node)
            ValkyrieElementTypes.MACRO_CALL -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ATTRIBUTE_ARGS -> ValkyrieElementNode(node)
            ValkyrieElementTypes.DOC_COMMENT -> ValkyrieDocCommentNode(node)
            ValkyrieElementTypes.IF_STATEMENT -> ValkyrieIfStatementNode(node)
            ValkyrieElementTypes.IF_LET_STATEMENT -> ValkyrieIfLetStatementNode(node)
            ValkyrieElementTypes.ELSE_CLAUSE -> ValkyrieElseClauseNode(node)
            ValkyrieElementTypes.DECLARE_TESTS -> ValkyrieTestStatement(node)
            // 元编程节点
            ValkyrieElementTypes.DECLARE_MICRO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.ASSIGN_MICRO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.DECLARE_MEZZO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.ASSIGN_MEZZO -> ValkyrieElementNode(node)
            ValkyrieElementTypes.DECLARE_MACRO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.ASSIGN_MACRO -> ValkyrieAssignStatement(node)
            ValkyrieElementTypes.COMPILE_TIME_BLOCK -> ValkyrieCompileTimeBlock(node)
            ValkyrieElementTypes.TEMPLATE_BLOCK -> ValkyrieTemplateBlock(node)
            ValkyrieElementTypes.TEMPLATE_IF_MARK -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TEMPLATE_ELSE_IF -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TEMPLATE_ELSE_IF_MARK -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TEMPLATE_ELSE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TEMPLATE_ELSE_MARK -> ValkyrieElementNode(node)
            ValkyrieElementTypes.TEMPLATE_END_MARK -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LOOP_STATEMENT -> ValkyrieControlFlowNodes(node)
            ValkyrieElementTypes.WHILE_STATEMENT -> ValkyrieWhileStatement(node)
            ValkyrieElementTypes.CATCH_STATEMENT -> ValkyrieCatchStatement(node)
            ValkyrieElementTypes.ASSIGN_STATEMENT -> ValkyrieAssignStatement(node)
            ValkyrieElementTypes.RESUME_STATEMENT -> ValkyrieResumeStatement(node)
            ValkyrieElementTypes.SCOPE_STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ERROR_ELEMENT -> ValkyrieElementNode(node)
            // XML 相关节点
            ValkyrieElementTypes.XML_ELEMENT -> ValkyrieXmlElementNode(node)
            ValkyrieElementTypes.XML_ATTRIBUTE -> ValkyrieXmlAttributeNode(node)
            ValkyrieElementTypes.XML_TEXT_NODE -> ValkyrieXmlTextNode(node)
            ValkyrieElementTypes.XML_SLOT_EXPRESSION -> ValkyrieXmlSlotExpressionNode(node)
            // SFC 相关节点
            ValkyrieElementTypes.SFC_TEMPLATE -> ValkyrieSfcTemplateNode(node)
            ValkyrieElementTypes.SFC_SCRIPT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.SFC_STYLE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.SFC_COMPONENT -> ValkyrieElementNode(node)
            else -> ValkyrieElementNode(node)
        }
    }

    /**
     * 从文本创建表达式
     */
    fun createExpressionFromText(text: String, project: Project): PsiElement? {
        val dummyFile = PsiFileFactory.getInstance(project)
            .createFileFromText(
                "dummy.vk",
                ValkyrieLanguage,
                "let dummy = $text"
            ) as? ValkyrieFileNode

        return dummyFile?.let { file ->
            PsiTreeUtil.findChildOfType(file, PsiElement::class.java)
        }
    }

    /**
     * 创建标识符节点
     */
    fun createIdentifier(project: Project, name: String): ValkyrieIdentifierNode {
        val fileText = "let $name = 1"
        val file = PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.vk", ValkyrieLanguage, fileText) as ValkyrieFileNode

        // 查找标识符节点
        val identifiers = PsiTreeUtil.findChildrenOfType(file, ValkyrieIdentifierNode::class.java)
        return identifiers.firstOrNull { it.getName() == name }
            ?: throw IllegalStateException("Could not create identifier: $name")
    }
}