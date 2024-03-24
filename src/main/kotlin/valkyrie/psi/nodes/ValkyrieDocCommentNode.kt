package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Doc Comment 节点实现
 * 用于处理文档注释的合并和渲染显示
 */
class ValkyrieDocCommentNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取注释内容
     */
    fun getCommentText(): String {
        return text.removePrefix("⍝").trim()
    }
    
    /**
     * 合并连续的doc comment
     * @return 合并后的文档注释内容
     */
    fun getMergedDocComment(): String {
        val comments = mutableListOf<String>()
        
        // 向前查找连续的doc comment
        var current: PsiElement? = this
        while (current != null) {
            if (current is ValkyrieDocCommentNode) {
                comments.add(0, current.getCommentText())
            } else if (current.node.elementType == WHITE_SPACE) {
                // 跳过空白字符
            } else {
                break
            }
            current = PsiTreeUtil.getPrevSiblingOfType(current, PsiElement::class.java)
        }
        
        // 向后查找连续的doc comment
        current = PsiTreeUtil.getNextSiblingOfType(this, PsiElement::class.java)
        while (current != null) {
            if (current is ValkyrieDocCommentNode) {
                comments.add(current.getCommentText())
            } else if (current.node.elementType == WHITE_SPACE) {
                // 跳过空白字符
            } else {
                break
            }
            current = PsiTreeUtil.getNextSiblingOfType(current, PsiElement::class.java)
        }
        
        return comments.joinToString("\n")
    }
    
    // 移除自定义HTML渲染方法，使用IntelliJ内置文档功能
    
    /**
     * 获取关联的声明元素
     */
    fun getAssociatedDeclaration(): PsiElement? {
        var next = PsiTreeUtil.getNextSiblingOfType(this, PsiElement::class.java)
        
        // 跳过空白和其他doc comment
        while (next != null) {
            when {
                next is ValkyrieDocCommentNode -> {
                    next = PsiTreeUtil.getNextSiblingOfType(next, PsiElement::class.java)
                }
                next.node.elementType == WHITE_SPACE -> {
                    next = PsiTreeUtil.getNextSiblingOfType(next, PsiElement::class.java)
                }
                next is ValkyrieClassDeclaration ||
                next is ValkyrieUnionDeclaration ||
                next is ValkyrieTraitDeclaration ||
                next is ValkyrieMethodDeclaration ||
                next is ValkyrieFieldDeclaration -> {
                    return next
                }
                else -> break
            }
        }
        
        return null
    }
    
    override fun toString(): String = "ValkyrieDocComment"
}