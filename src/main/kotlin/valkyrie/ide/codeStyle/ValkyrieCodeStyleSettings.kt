package valkyrie.ide.codeStyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings
import valkyrie.language.ValkyrieLanguage

@Suppress("PropertyName")
class ValkyrieCodeStyleSettings(container: CodeStyleSettings) : CustomCodeStyleSettings(ValkyrieLanguage.id, container) {
    val TRAILING_COMMA: TrailingComma = TrailingComma.ALWAYS
    val class_field_trailing: ClassFieldTrailing = ClassFieldTrailing.Semicolon
    val return_type: ReturnType = ReturnType.Arrow
    val namespace_delimiter: NamespaceDelimiter = NamespaceDelimiter.Colon

    enum class TrailingComma {
        ALWAYS, NEVER, WHEN_MULTILINE
    }

    enum class ClassFieldTrailing {
        Ignore,    // 别动
        Never,     // 去掉
        Comma,     // `,`
        Semicolon, // `;`
    }

    enum class ReturnType {
        Ignore,       // 别动
        Colon,        // `:`
        Arrow,        // `->`
        UnicodeArrow, // `⟶`
    }

    enum class NamespaceDelimiter {
        Ignore, // 别动
        Dot,    // `.`
        Colon,  // `::`
        UnicodeColon, // `∷`
    }
}
