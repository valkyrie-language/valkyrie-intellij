package valkyrie.ide.navigation

import com.intellij.navigation.DirectNavigationProvider
import com.intellij.psi.PsiElement


/// 快速导航, 直接跳转到指定的元素
/// 由 element.elementType 触发

class ValkyrieDirectNavigationProvider : DirectNavigationProvider {
    override fun getNavigationElement(element: PsiElement): PsiElement? {
        return null
    }
}


