package valkyrie.ide.codeStyle

import com.intellij.json.formatter.JsonCodeStyleSettings.PropertyAlignment
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings
import valkyrie.language.ValkyrieLanguage

class ValkyrieCodeStyleSettings(container: CodeStyleSettings?) : CustomCodeStyleSettings(ValkyrieLanguage.id, container!!) {
    val KEEP_TRAILING_COMMA: Boolean = true
}