package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.reference.ValkyrieReference

/**
 * 标识符节点
 * 支持常规标识符和特殊名称标识符（用反引号包围）
 */
class ValkyrieIdentifierNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取标识符的真实名称
     * 对于特殊名称标识符，会去除反引号
     */
    override fun getName(): String {
        val text = this.node.text
        
        // 检查是否为特殊名称标识符（用反引号包围）
        return if (text.startsWith("`") && text.endsWith("`") && text.length > 2) {
            // 去除反引号，返回真实名称
            text.substring(1, text.length - 1)
        } else {
            // 常规标识符，直接返回
            text
        }
    }
    
    /**
     * 检查是否为特殊名称标识符
     */
    fun isSpecialName(): Boolean {
        val text = this.node.text
        return text.startsWith("`") && text.endsWith("`") && text.length > 2
    }
    
    /**
     * 获取标识符的原始文本（包含反引号）
     */
    fun getRawText(): String {
        return this.node.text
    }
    
    override fun toString(): String = "ValkyrieIdentifier(${getName()})"
    
    /**
     * 获取引用对象，用于支持 find usage 和 goto definition
     */
    override fun getReference(): PsiReference? {
        return ValkyrieReference(this)
    }
}