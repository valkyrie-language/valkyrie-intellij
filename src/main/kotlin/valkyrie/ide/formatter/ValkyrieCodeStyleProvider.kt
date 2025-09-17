package valkyrie.ide.formatter

import com.intellij.application.options.IndentOptionsEditor
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.*
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie 代码样式设置提供者
 */
class ValkyrieCodeStyleProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language = ValkyrieLanguage

    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        return ValkyrieCodeStyleSettings(settings)
    }

    override fun createConfigurable(baseSettings: CodeStyleSettings, modelSettings: CodeStyleSettings): CodeStyleConfigurable {
        return ValkyrieCodeStyleConfigurable(baseSettings, modelSettings)
    }

    override fun getCodeSample(settingsType: SettingsType): String {
        return when (settingsType) {
            SettingsType.SPACING_SETTINGS -> SPACING_SAMPLE
            SettingsType.WRAPPING_AND_BRACES_SETTINGS -> WRAPPING_SAMPLE
            SettingsType.INDENT_SETTINGS -> INDENT_SAMPLE
            else -> DEFAULT_SAMPLE
        }
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        when (settingsType) {
            SettingsType.SPACING_SETTINGS -> {
                consumer.showStandardOptions(
                    "SPACE_AROUND_ASSIGNMENT_OPERATORS",
                    "SPACE_AROUND_LOGICAL_OPERATORS",
                    "SPACE_AROUND_EQUALITY_OPERATORS",
                    "SPACE_AROUND_RELATIONAL_OPERATORS",
                    "SPACE_AROUND_ADDITIVE_OPERATORS",
                    "SPACE_AROUND_MULTIPLICATIVE_OPERATORS",
                    "SPACE_BEFORE_COMMA",
                    "SPACE_AFTER_COMMA",
                    "SPACE_BEFORE_COLON",
                    "SPACE_AFTER_COLON",
                    "SPACE_BEFORE_SEMICOLON",
                    "SPACE_AFTER_SEMICOLON"
                )
            }

            SettingsType.WRAPPING_AND_BRACES_SETTINGS -> {
                consumer.showStandardOptions(
                    "KEEP_LINE_BREAKS",
                    "KEEP_FIRST_COLUMN_COMMENT",
                    "BRACE_STYLE",
                    "CLASS_BRACE_STYLE",
                    "METHOD_BRACE_STYLE"
                )
            }

            SettingsType.INDENT_SETTINGS -> {
                consumer.showStandardOptions(
                    "INDENT_SIZE",
                    "CONTINUATION_INDENT_SIZE",
                    "TAB_SIZE",
                    "USE_TAB_CHARACTER"
                )
            }

            else -> {}
        }
    }

    override fun getIndentOptionsEditor(): IndentOptionsEditor? {
        return ValkyrieIndentOptionsEditor()
    }

    companion object {
        private const val DEFAULT_SAMPLE = """
namespace example {
    class Point {
        x: f64,
        y: f64,
    }
    
    micro distance(p1: Point, p2: Point) -> f64 {
        let dx = p1.x - p2.x
        let dy = p1.y - p2.y
        (dx * dx + dy * dy).sqrt()
    }
}
"""

        private const val SPACING_SAMPLE = """
let x = 1 + 2 * 3
let result = calculate(a, b, c)
let point: Point = Point { x: 0.0, y: 0.0 }
"""

        private const val WRAPPING_SAMPLE = """
class LongClassName {
    very_long_field_name: VeryLongTypeName,
    another_field: AnotherType,
}

micro long_function_name(
    first_parameter: FirstType,
    second_parameter: SecondType,
    third_parameter: ThirdType
) -> ReturnType {
    // function body
}
"""

        private const val INDENT_SAMPLE = """
class Example {
    field: Type,
    
    micro method() {
        if condition {
            do_something()
        } else {
            do_something_else()
        }
    }
}
"""
    }
}

