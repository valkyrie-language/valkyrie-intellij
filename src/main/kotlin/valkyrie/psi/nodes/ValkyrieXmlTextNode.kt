package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementNode

/**
 * XML 文本节点
 * 表示 XML 元素中的文本内容
 */
class ValkyrieXmlTextNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取文本内容
     */
    fun getTextContent(): String? {
        val textElement = findChildByType<PsiElement>(XmlTokenType.XML_DATA_CHARACTERS)
        return textElement?.text
    }
    
    /**
     * 检查是否为空白文本
     */
    fun isWhitespace(): Boolean {
        val content = getTextContent()
        return content?.isBlank() == true
    }
    
    /**
     * 获取去除前后空白的文本内容
     */
    fun getTrimmedText(): String? {
        return getTextContent()?.trim()
    }
}