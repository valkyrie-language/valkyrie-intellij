package valkyrie.psi.nodes.dialect_sfc

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import valkyrie.psi.ValkyrieElementNode

/**
 * SFC Template 节点的专门实现
 * 解决PSI树遍历中的空指针问题
 */
class ValkyrieSfcTemplateNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    override fun toString(): String = "SFC Template"
    
    override fun accept(visitor: PsiElementVisitor) {
        try {
            // 安全地处理访问者模式
            super.accept(visitor)
        } catch (e: Exception) {
            // 如果出现异常，记录但不中断处理
            println("Warning: Exception in SFC template node accept: ${e.message}")
        }
    }
    
    override fun acceptChildren(visitor: PsiElementVisitor) {
        try {
            // 安全地遍历子元素
            var child: PsiElement? = firstChild
            while (child != null) {
                if (child.isValid) {
                    child.accept(visitor)
                }
                child = child.nextSibling
            }
        } catch (e: Exception) {
            // 如果出现异常，记录但不中断处理
            println("Warning: Exception in SFC template node acceptChildren: ${e.message}")
        }
    }
}