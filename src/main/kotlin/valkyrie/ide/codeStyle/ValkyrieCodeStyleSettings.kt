package valkyrie.ide.codeStyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings
import valkyrie.language.ValkyrieLanguage

@Suppress("PropertyName")
class ValkyrieCodeStyleSettings(container: CodeStyleSettings) : CustomCodeStyleSettings(ValkyrieLanguage.id, container) {
    val TRAILING_COMMA: TrailingComma = TrailingComma.ALWAYS
    val class_field_trailing: ClassFieldTrailing = ClassFieldTrailing.SEMICOLON

    enum class TrailingComma {
        ALWAYS,
        NEVER,
        WHEN_MULTILINE
    }

    enum class ClassFieldTrailing {
        IGNORE,    // 别动
        NEVER,     // 去掉
        COMMA,     // 逗号
        SEMICOLON, // 分号
    }
}
