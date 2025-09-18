package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlElementType
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.nodes.*
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcTemplateNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcScriptNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcStyleNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcComponentNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlAttributeNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlElementNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlSlotExpressionNode
import valkyrie.psi.nodes.dialect_xml.ValkyrieXmlTextNode

/**
 * Valkyrie PSI 元素工厂
 */
object ValkyrieFactory {
    private val LOG = Logger.getInstance(ValkyrieFactory::class.java)

    /**
     * 获取工厂实例
     */
    fun getInstance(project: Project): ValkyrieFactory = this


    /**
     * 从文本创建表达式
     */
    fun createExpressionFromText(text: String, project: Project): PsiElement? {
        val dummyFile = PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.vk", ValkyrieLanguage.INSTANCE, "let dummy = $text") as? ValkyrieFileNode

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
        val elementType = node.elementType
        LOG.info("ValkyrieElementFactory.createElement: $elementType")
        
        // 确保所有 SFC 相关元素类型都能正确处理
        when (elementType) {
            ValkyrieTypes.SFC_TEMPLATE -> {
                LOG.info("Creating ValkyrieSfcTemplateNode for SFC_TEMPLATE")
                return ValkyrieSfcTemplateNode(node)
            }
            ValkyrieTypes.SFC_SCRIPT -> {
                LOG.info("Creating ValkyrieSfcScriptNode for SFC_SCRIPT")
                return ValkyrieSfcScriptNode(node)
            }
            ValkyrieTypes.SFC_STYLE -> {
                LOG.info("Creating ValkyrieSfcStyleNode for SFC_STYLE")
                return ValkyrieSfcStyleNode(node)
            }
            ValkyrieTypes.SFC_COMPONENT -> {
                LOG.info("Creating ValkyrieSfcComponentNode for SFC_COMPONENT")
                return ValkyrieSfcComponentNode(node)
            }
            ValkyrieTypes.STRING_TEXT -> {
                LOG.info("Creating ValkyrieElementNode for STRING_TEXT")
                return ValkyrieElementNode(node)
            }
            else -> {
                // 处理与 ValkyrieSfcLanguage 关联的 STRING_TEXT token 类型
                if (elementType.toString() == "ValkyrieToken.STRING.TEXT") {
                    LOG.info("Creating ValkyrieElementNode for ValkyrieToken.STRING.TEXT")
                    return ValkyrieElementNode(node)
                }
                
                LOG.info("Creating default element for $elementType")
                return when (elementType) {
                    ValkyrieTypes.FILE -> ValkyrieElementNode(node)
                    ValkyrieTypes.STATEMENT -> ValkyrieElementNode(node)
                    ValkyrieTypes.LET_STATEMENT -> ValkyrieLetStatementNode(node)
                    ValkyrieTypes.CLASS_STATEMENT -> ValkyrieClassDeclaration(node)
                    ValkyrieTypes.NEURAL_STATEMENT -> ValkyrieNeuralDeclaration(node)
                    ValkyrieTypes.WIDGET_STATEMENT -> ValkyrieWidgetDeclaration(node)
                    ValkyrieTypes.SINGLETON_STATEMENT -> ValkyrieSingletonDeclaration(node)
                    ValkyrieTypes.UNION_STATEMENT -> ValkyrieUnionDeclaration(node)
                    ValkyrieTypes.FLAGS_STATEMENT -> ValkyrieUnionDeclaration(node) // 复用UnionDeclaration
                    ValkyrieTypes.TRAIT_STATEMENT -> ValkyrieTraitDeclaration(node)
                    ValkyrieTypes.TRAIT_ALIAS -> ValkyrieTraitAliasDeclaration(node)
                    ValkyrieTypes.IMPLY_STATEMENT -> ValkyrieImplyStatement(node)
                    ValkyrieTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceDeclaration(node)
                    ValkyrieTypes.NAMESPACE_PATH -> ValkyrieElementNode(node)
                    ValkyrieTypes.USING_STATEMENT -> ValkyrieUsingStatement(node)
                    ValkyrieTypes.EXPRESSION_STATEMENT -> ValkyrieTermExpression(node)
                    ValkyrieTypes.BLOCK_STATEMENT -> ValkyrieBlockStatementNode(node)
                    ValkyrieTypes.OBJECT_BODY -> ValkyrieObjectBodyNode(node)
                    ValkyrieTypes.UNION_BODY -> ValkyrieUnionBodyNode(node)
                    ValkyrieTypes.EXPRESSION -> ValkyrieElementNode(node)
                    ValkyrieTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionNode(node)
                    ValkyrieTypes.BINARY_EXPRESSION -> ValkyrieBinaryTerm(node)
                    ValkyrieTypes.UNARY_EXPRESSION -> ValkyrieUnaryTerm(node)
                    ValkyrieTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionNode(node)
                    ValkyrieTypes.CALL_EXPRESSION -> ValkyrieCallExpressionNode(node)
                    ValkyrieTypes.CALL_TYPE_ARGUMENT -> ValkyrieGenericCallExpressionNode(node)
                    ValkyrieTypes.POSTFIX_EXPRESSION -> ValkyriePostfixExpressionNode(node)
                    ValkyrieTypes.ARRAY_EXPRESSION -> ValkyrieElementNode(node)
                    ValkyrieTypes.TABLE_EXPRESSION -> ValkyrieElementNode(node)
                    ValkyrieTypes.TABLE_PAIR -> ValkyrieElementNode(node)
                    ValkyrieTypes.SLICE_EXPRESSION -> ValkyrieElementNode(node)
                    ValkyrieTypes.SLICE_ITEM -> ValkyrieElementNode(node)
                    ValkyrieTypes.INDEX_EXPRESSION -> ValkyrieElementNode(node)
                    ValkyrieTypes.TABLE_TYPE -> ValkyrieElementNode(node)
                    ValkyrieTypes.FIELD_DECLARATION -> ValkyrieFieldDeclaration(node)
                    ValkyrieTypes.METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
                    ValkyrieTypes.INSTANCE_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
                    ValkyrieTypes.STATIC_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
                    ValkyrieTypes.DOMAIN_DECLARATION -> ValkyrieDomainDeclaration(node)
                    ValkyrieTypes.UNION_VARIANT -> ValkyrieVariantDeclaration(node)
                    ValkyrieTypes.FLAGS_ITEM -> ValkyrieVariantDeclaration(node)
                    ValkyrieTypes.PATTERN -> ValkyrieElementNode(node)
                    ValkyrieTypes.TUPLE_PATTERN -> ValkyrieElementNode(node)
                    ValkyrieTypes.IDENTIFIER_NODE -> ValkyrieIdentifierNode(node)
                    ValkyrieTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceNode(node)
                    ValkyrieTypes.TYPE_HINT -> ValkyrieElementNode(node)
                    ValkyrieTypes.RETURN_TYPE -> ValkyrieElementNode(node)
                    ValkyrieTypes.EFFECT_TYPE -> ValkyrieElementNode(node)
                    ValkyrieTypes.DEFAULT_TYPE -> ValkyrieElementNode(node)
                    ValkyrieTypes.DEFAULT_VALUE -> ValkyrieElementNode(node)
                    ValkyrieTypes.TERM_PARAMETER_LIST -> ValkyrieTermParameterList(node)
                    ValkyrieTypes.TERM_PARAMETER_ITEM -> ValkyrieTermParameterItem(node)
                    ValkyrieTypes.GENERIC_PARAMETER_LIST -> ValkyrieElementNode(node)
                    ValkyrieTypes.ANNOTATION_NODE -> ValkyrieAnnotationNode(node)
                    ValkyrieTypes.MODIFIER_NODE -> ValkyrieModifierNode(node)
                    ValkyrieTypes.ATTRIBUTE -> ValkyrieElementNode(node)
                    ValkyrieTypes.ATTRIBUTE_LIST -> ValkyrieElementNode(node)
                    ValkyrieTypes.MACRO_CALL -> ValkyrieElementNode(node)
                    ValkyrieTypes.ATTRIBUTE_ARGS -> ValkyrieElementNode(node)
                    ValkyrieTypes.DOC_COMMENT -> ValkyrieDocCommentNode(node)
                    ValkyrieTypes.IF_STATEMENT -> ValkyrieIfStatementNode(node)
                    ValkyrieTypes.IF_LET_STATEMENT -> ValkyrieIfLetStatementNode(node)
                    ValkyrieTypes.ELSE_CLAUSE -> ValkyrieElseClauseNode(node)
                    ValkyrieTypes.DECLARE_TESTS -> ValkyrieTestStatement(node)
                    // 元编程节点
                    ValkyrieTypes.DECLARE_MICRO -> ValkyrieMetaStatement(node)
                    ValkyrieTypes.ASSIGN_MICRO -> ValkyrieMetaStatement(node)
                    ValkyrieTypes.DECLARE_MEZZO -> ValkyrieMetaStatement(node)
                    ValkyrieTypes.ASSIGN_MEZZO -> ValkyrieElementNode(node)
                    ValkyrieTypes.DECLARE_MACRO -> ValkyrieMetaStatement(node)
                    ValkyrieTypes.ASSIGN_MACRO -> ValkyrieAssignStatement(node)
                    ValkyrieTypes.COMPILE_TIME_BLOCK -> ValkyrieCompileTimeBlock(node)
                    ValkyrieTypes.TEMPLATE_BLOCK -> ValkyrieTemplateBlock(node)
                    ValkyrieTypes.TEMPLATE_IF_MARK -> ValkyrieElementNode(node)
                    ValkyrieTypes.TEMPLATE_ELSE_IF -> ValkyrieElementNode(node)
                    ValkyrieTypes.TEMPLATE_ELSE_IF_MARK -> ValkyrieElementNode(node)
                    ValkyrieTypes.TEMPLATE_ELSE -> ValkyrieElementNode(node)
                    ValkyrieTypes.TEMPLATE_ELSE_MARK -> ValkyrieElementNode(node)
                    ValkyrieTypes.TEMPLATE_END_MARK -> ValkyrieElementNode(node)
                    ValkyrieTypes.LOOP_STATEMENT -> ValkyrieControlFlowNodes(node)
                    ValkyrieTypes.WHILE_STATEMENT -> ValkyrieWhileStatement(node)
                    ValkyrieTypes.CATCH_STATEMENT -> ValkyrieCatchStatement(node)
                    ValkyrieTypes.ASSIGN_STATEMENT -> ValkyrieAssignStatement(node)
                    ValkyrieTypes.RESUME_STATEMENT -> ValkyrieResumeStatement(node)
                    ValkyrieTypes.ASSERT_STATEMENT -> ValkyrieAssertStatement(node)
                    ValkyrieTypes.DEBUG_STATEMENT -> ValkyrieDebugStatement(node)
                    ValkyrieTypes.SCOPE_STATEMENT -> ValkyrieElementNode(node)
                    ValkyrieTypes.ERROR_ELEMENT -> ValkyrieElementNode(node)
                    // XML 相关节点
                    ValkyrieTypes.XML_ELEMENT -> ValkyrieXmlElementNode(node)
                    XmlElementType.XML_ATTRIBUTE -> ValkyrieXmlAttributeNode(node)
                    ValkyrieTypes.XML_TEXT_NODE -> ValkyrieXmlTextNode(node)
                    ValkyrieTypes.XML_SLOT_EXPRESSION -> ValkyrieXmlSlotExpressionNode(node)
                    else -> ValkyrieElementNode(node)
                }
            }
        }
    }

}
