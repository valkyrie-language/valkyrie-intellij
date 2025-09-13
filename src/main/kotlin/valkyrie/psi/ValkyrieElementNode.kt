package valkyrie.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

/**
 * Valkyrie PSI 元素基础实现
 * 添加了防止无限循环的保护机制，特别是针对PsiViewer插件的兼容性问题
 */
open class ValkyrieElementNode(node: ASTNode) : ASTWrapperPsiElement(node), ValkyrieElement {
    
    // 防止无限循环的访问计数器
    private var siblingAccessCount = 0
    private val maxSiblingAccess = 1000
    
    override fun getNextSibling(): PsiElement? {
        // 防止无限循环：限制访问次数
        if (siblingAccessCount > maxSiblingAccess) {
            return null
        }
        siblingAccessCount++
        
        try {
            return super.getNextSibling()
        } catch (e: StackOverflowError) {
            // 捕获栈溢出错误，返回null防止崩溃
            return null
        } finally {
            siblingAccessCount--
        }
    }
    
    override fun getPrevSibling(): PsiElement? {
        // 防止无限循环：限制访问次数
        if (siblingAccessCount > maxSiblingAccess) {
            return null
        }
        siblingAccessCount++
        
        try {
            return super.getPrevSibling()
        } catch (e: StackOverflowError) {
            // 捕获栈溢出错误，返回null防止崩溃
            return null
        } finally {
            siblingAccessCount--
        }
    }
    
//    override fun accept(visitor: PsiElementVisitor) {
//        super.accept(visitor)
//    }
}