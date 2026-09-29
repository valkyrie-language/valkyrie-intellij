package vos.intellij.ide.codeStyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class CodeStyleSettings(settings: CodeStyleSettings?) : CustomCodeStyleSettings(
    "VosCodeStyleSettings",
    settings!!
)
