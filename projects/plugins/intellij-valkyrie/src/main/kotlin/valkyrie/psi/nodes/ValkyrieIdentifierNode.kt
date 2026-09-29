package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieFactory

/**
 * 标识符节点
 * 支持常规标识符和特殊名称标识符（用反引号包围）
 */
class ValkyrieIdentifierNode(node: ASTNode) : ValkyrieElementNode(node), PsiNamedElement {
    
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
     * References are contributed by [valkyrie.reference.ValkyrieCrossFileReferenceProvider].
     */
    override fun getReference(): com.intellij.psi.PsiReference? = null
    
    /**
     * 设置新的名称（用于重命名重构）
     */
    override fun setName(name: String): PsiElement {
        val newText = if (isSpecialName()) {
            "`$name`"
        } else {
            name
        }
        
        // 创建新的标识符节点
        val newElement = ValkyrieFactory.createIdentifier(project, newText)
        return replace(newElement)
    }
    
    /**
     * 获取名称标识符元素（用于重命名）
     */
    fun getNameIdentifier(): PsiElement? {
        return this
    }
}