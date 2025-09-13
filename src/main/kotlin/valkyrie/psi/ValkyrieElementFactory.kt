package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.nodes.*

/**
 * Valkyrie PSI 元素工厂
 */
object ValkyrieElementFactory {

    /**
     * 获取工厂实例
     */
    fun getInstance(project: Project): ValkyrieElementFactory = this

    /**
     * 从文本创建表达式
     */
    fun createExpressionFromText(text: String, project: Project): PsiElement? {
        val dummyFile = PsiFileFactory.getInstance(project)
            .createFileFromText(
                "dummy.vk",
                ValkyrieLanguage.INSTANCE,
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
            .createFileFromText("dummy.vk", ValkyrieLanguage.INSTANCE, fileText) as ValkyrieFileNode

        // 查找标识符节点
        val identifiers = PsiTreeUtil.findChildrenOfType(file, ValkyrieIdentifierNode::class.java)
        return identifiers.firstOrNull { it.getName() == name }
            ?: throw IllegalStateException("Could not create identifier: $name")
    }

    fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            ValkyrieElementTypes.FILE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LET_STATEMENT -> ValkyrieLetStatementNode(node)
            ValkyrieElementTypes.CLASS_STATEMENT -> ValkyrieClassDeclaration(node)
            ValkyrieElementTypes.NEURAL_STATEMENT -> ValkyrieClassDeclaration(node) // 复用ClassDeclaration
            ValkyrieElementTypes.WIDGET_STATEMENT -> ValkyrieClassDeclaration(node) // 复用ClassDeclaration
            ValkyrieElementTypes.SINGLETON_STATEMENT -> ValkyrieClassDeclaration(node) // 复用ClassDeclaration
            ValkyrieElementTypes.UNION_STATEMENT -> ValkyrieUnionDeclaration(node)
            ValkyrieElementTypes.FLAGS_STATEMENT -> ValkyrieUnionDeclaration(node) // 复用UnionDeclaration
            ValkyrieElementTypes.TRAIT_STATEMENT -> ValkyrieTraitDeclaration(node)
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
            ValkyrieElementTypes.GENERIC_CALL_EXPRESSION -> ValkyrieGenericCallExpressionNode(node)
            ValkyrieElementTypes.POSTFIX_EXPRESSION -> ValkyriePostfixExpressionNode(node)
            ValkyrieElementTypes.ARRAY_EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.FIELD_DECLARATION -> ValkyrieFieldDeclaration(node)
            ValkyrieElementTypes.METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.INSTANCE_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.STATIC_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.DOMAIN_DECLARATION -> ValkyrieDomainDeclaration(node)
            ValkyrieElementTypes.UNION_VARIANT -> ValkyrieVariantDeclaration(node)
            ValkyrieElementTypes.FLAGS_ITEM -> ValkyrieVariantDeclaration(node) // 复用VariantDeclaration
            ValkyrieElementTypes.MEZZO_DECLARATION -> ValkyrieElementNode(node)
            // ValkyrieElementTypes.MODIFIER_LIST -> ValkyrieModifierListNode(node) // 已移除
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
            ValkyrieElementTypes.DECLARE_TEST_METHOD -> ValkyrieTestStatement(node)
            // 元编程节点
            ValkyrieElementTypes.DECLARE_MICRO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.DECLARE_MEZZO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.DECLARE_MACRO -> ValkyrieMetaStatement(node)
            ValkyrieElementTypes.COMPILE_TIME_BLOCK -> ValkyrieCompileTimeBlock(node)
            ValkyrieElementTypes.TEMPLATE_BLOCK -> ValkyrieTemplateBlock(node)
            ValkyrieElementTypes.LOOP_STATEMENT -> ValkyrieControlFlowNodes(node)
            ValkyrieElementTypes.WHILE_STATEMENT -> ValkyrieWhileStatement(node)
            ValkyrieElementTypes.CATCH_STATEMENT -> ValkyrieCatchStatement(node)
            ValkyrieElementTypes.ASSIGN_STATEMENT -> ValkyrieAssignStatement(node)
            ValkyrieElementTypes.RESUME_STATEMENT -> ValkyrieResumeStatement(node)
            ValkyrieElementTypes.ERROR_ELEMENT -> ValkyrieElementNode(node)
            else -> ValkyrieElementNode(node)
        }
    }
}