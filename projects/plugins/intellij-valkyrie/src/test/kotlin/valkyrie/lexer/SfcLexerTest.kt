package valkyrie.lexer

import com.intellij.lexer.Lexer
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.surface.lexer.ValkyrieSfcLexer

/**
 * Valkyrie 组件词法分析器测试
 */
class SfcLexerTest : ValkyrieLexerTestCase("testData/lexer/component") {

    override fun createLexer(): Lexer {
        return ValkyrieSfcLexer()
    }

    fun testBasicXmlTag() {
        doTest("<div>")
    }

    fun testVoidTag() {
        doTest("<br/>")
    }

    fun testTagWithAttributes() {
        doTest("<div class=\"container\" id=\"main\">")
    }

    fun testClosingTag() {
        doTest("</div>")
    }

    fun testCompleteElement() {
        doTest("<div class=\"container\">content</div>")
    }

    fun testNestedElements() {
        doTest("<div><span>text</span></div>")
    }

    fun testSelfClosingTag() {
        doTest("<input type=\"text\" />")
    }

    fun testSfcWithBlockComments() {
        doTest(
            """
            <template>
                <!-- This is a multi-line\n                     block comment in SFC -->
                <div>Hello</div>
            </template>
        """.trimIndent()
        )
    }

    fun testComponentWithScript() {
        doTest(
            """
            <template>
                <div>Hello</div>
            </template>
            <script>
                console.log('test');
            </script>
        """.trimIndent()
        )
    }

    fun testComponentWithStyle() {
        doTest(
            """
            <template>
                <div class="test">Content</div>
            </template>
            <style>
                .test { color: red; }
            </style>
        """.trimIndent()
        )
    }

    fun testFullComponent() {
        doTest(
            """
            <template>
                <div class="container">
                    <h1>{{ title }}</h1>
                    <p>{{ content }}</p>
                </div>
            </template>
            
            <script>
                export default {
                    data() {
                        return {
                            title: 'Hello',
                            content: 'World'
                        }
                    }
                }
            </script>
            
            <style scoped>
                .container {
                    padding: 20px;
                }
            </style>
        """.trimIndent()
        )
    }
}