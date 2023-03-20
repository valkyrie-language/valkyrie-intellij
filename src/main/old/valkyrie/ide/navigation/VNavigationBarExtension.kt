package valkyrie.ide.goto

import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import valkyrie.language.ValkyrieLanguage

/// 重写导航栏
class VNavigationBarExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = ValkyrieLanguage

    override fun getPresentableText(`object`: Any?): String? {
        return null
    }
}
