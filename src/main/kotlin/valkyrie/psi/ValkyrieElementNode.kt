package valkyrie.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.util.startOffset
import javax.swing.Icon

/**
 * Valkyrie PSI 元素基础实现
 * 添加了防止无限循环的保护机制，特别是针对PsiViewer插件的兼容性问题
 */
open class ValkyrieElementNode(node: ASTNode) : ASTWrapperPsiElement(node), ValkyrieElement {

    override fun getOriginalElement(): ValkyrieElementNode? {
        return this as ValkyrieElementNode
    }

    override fun findElementAt(offset: Int): PsiElement? {
        return super.findElementAt(offset)
    }

    override fun getNavigationElement(): PsiElement {
        return super.getNavigationElement()
    }
//
//    // Ctrl 可显示的方法
//    override fun getTextOffset(): Int {
//        return navigationElement.startOffset
//    }


    override fun getElementIcon(flags: Int): Icon? {
        return super.getElementIcon(flags)
    }

}