package von.editing.format.codestyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class VonCodeStyleSettings(settings: CodeStyleSettings) : CustomCodeStyleSettings(
    "VonCodeStyleSettings",
    settings,
)
