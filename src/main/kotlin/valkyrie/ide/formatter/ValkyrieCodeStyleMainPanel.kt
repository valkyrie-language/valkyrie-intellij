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
//        addIndentOptionsTab(settings)
//        addSpacesTab(settings)
//        addWrappingAndBracesTab(settings)
//        addBlankLinesTab(settings)
    }

    override fun getPreviewText(): String {
        return """
            namespace example.demo

            class Person {
                name: String
                age: Integer
                
                greet(target: String): String {
                    "Hello, " + target + "!"
                }
            }

            union Result<T, E> {
                Fine { value: T }
                Fail { error: E }
            }

            let person = new Person {
                name: "Alice",
                age: 30
            }

            let result = match person.greet("World") {
                case greeting => Result::Fine(greeting)
                case _ => Result::Fail("Failed to greet")
            }
        """.trimIndent()
    }
}