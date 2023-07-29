package valkyrie.settings

import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import kotlin.reflect.KMutableProperty0

class YggdrasilCodeStyleSettings : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language {
        return ValkyrieLanguage
    }

    override fun getCodeSample(p0: SettingsType): String? {
        return null
    }
}

fun inlayOption(id: String, property: KMutableProperty0<Boolean>): Case {
    return Case(
        ValkyrieBundle.message("inlay.${id}.name"),
        id,
        property,
        ValkyrieBundle.message("inlay.${id}.detail")
    )
}
