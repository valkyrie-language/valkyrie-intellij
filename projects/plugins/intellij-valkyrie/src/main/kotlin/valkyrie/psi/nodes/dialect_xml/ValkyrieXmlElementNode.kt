package valkyrie.psi.nodes.dialect_xml

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * XML 元素节点
 * 表示 XML 标签元素，如 <div>content</div> 或 <img/>
 */
class ValkyrieXmlElementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取开始标签名
     */
    fun getTagName(): String? {
        val tagNameElement = findChildByType<PsiElement>(XmlTokenType.XML_TAG_NAME)
        return tagNameElement?.text
    }
    
    /**
     * 获取所有属性
     */
    fun getAttributes(): List<ValkyrieXmlAttributeNode> {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieXmlAttributeNode::class.java)
    }
    
    /**
     * 根据名称获取属性
     */
    fun getAttribute(name: String): ValkyrieXmlAttributeNode? {
        return getAttributes().find { it.getAttributeName() == name }
    }
    
    /**
     * 获取XML内容（子元素和文本节点）
     */
    fun getContent(): List<PsiElement> {
        val content = mutableListOf<PsiElement>()
        
        // 查找所有子XML元素
        content.addAll(PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieXmlElementNode::class.java))
        
        // 查找所有文本节点
        content.addAll(PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieXmlTextNode::class.java))
        
        // 查找所有slot表达式
        content.addAll(PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieXmlSlotExpressionNode::class.java))
        
        return content
    }
    
    /**
     * 检查是否是自闭合标签
     */
    fun isSelfClosing(): Boolean {
        return findChildByType<PsiElement>(XmlTokenType.XML_EMPTY_ELEMENT_END) != null
    }
    
    /**
     * 获取文本内容（仅文本节点，不包括子元素）
     */
    fun getTextContent(): String {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieXmlTextNode::class.java)
            .joinToString("") { it.getText() }
    }
}