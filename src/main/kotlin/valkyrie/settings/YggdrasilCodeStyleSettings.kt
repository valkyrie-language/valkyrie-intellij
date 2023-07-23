package valkyrie.settings

import com.intellij.lang.Language
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider
import valkyrie.language.ValkyrieLanguage

class YggdrasilCodeStyleSettings : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language {
        return ValkyrieLanguage
    }

    override fun getCodeSample(p0: SettingsType): String? {
        return null
    }
}