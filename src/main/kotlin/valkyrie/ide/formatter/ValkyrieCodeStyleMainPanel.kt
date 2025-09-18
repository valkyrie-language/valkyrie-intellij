package valkyrie.ide.formatter

import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.language.dialect_std.ValkyrieFileType

/**
 * Valkyrie 代码样式主面板
 */
class ValkyrieCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(ValkyrieLanguage, currentSettings, settings) {

    override fun getFileType(): FileType {
        return ValkyrieFileType.INSTANCE
    }

    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addSpacesTab(settings)
        addWrappingAndBracesTab(settings)
        addBlankLinesTab(settings)
    }

    override fun getPreviewText(): String {
        return """
            namespace example.demo

            class Person {
                name: String
                age: Integer
                
                method greet(target: String): String {
                    return "Hello, " + target + "!"
                }
            }

            union Result<T, E> {
                Ok(T)
                Error(E)
            }

            let person = Person {
                name: "Alice",
                age: 30
            }

            let result = match person.greet("World") {
                case greeting => Result.Ok(greeting)
                case _ => Result.Error("Failed to greet")
            }
        """.trimIndent()
    }
}