package valkyrie.psi.nodes.dialect_xml

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * XML 属性节点
 * 表示 XML 属性，如 name="value" 或 onClick={handler}
 */
class ValkyrieXmlAttributeNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取属性名
     */
    fun getAttributeName(): String? {
        val nameElement = findChildByType<PsiElement>(XmlTokenType.XML_NAME)
        return nameElement?.text
    }
    
    /**
     * 获取属性值（字符串值）
     */
    fun getAttributeValue(): String? {
        val valueTokens = findChildrenByType<PsiElement>(XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN)
        return if (valueTokens.isNotEmpty()) {
            valueTokens.joinToString("") { it.text }
        } else null
    }
    
    /**
     * 获取属性值表达式（如果是 {expression} 形式）
     */
    fun getAttributeExpression(): ValkyrieXmlSlotExpressionNode? {
        return PsiTreeUtil.getChildOfType(this, ValkyrieXmlSlotExpressionNode::class.java)
    }
    
    /**
     * 检查属性值是否是表达式
     */
    fun isExpressionValue(): Boolean {
        return getAttributeExpression() != null
    }
    
    /**
     * 获取完整的属性值（字符串或表达式的文本表示）
     */
    fun getValueText(): String? {
        return getAttributeValue() ?: getAttributeExpression()?.text
    }
}