package valkyrie.ide.goto

import valkyrie.language.ValkyrieLanguage
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language

/// 重写导航栏
class VNavigationBarExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = ValkyrieLanguage

    override fun getPresentableText(`object`: Any?): String? {
        return null
    }
}
