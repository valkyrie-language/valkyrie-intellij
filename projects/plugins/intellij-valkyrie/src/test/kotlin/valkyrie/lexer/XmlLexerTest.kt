package valkyrie.lexer

import com.intellij.lexer.Lexer
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.surface.file.dialect_xml.ValkyrieXmlLexer

/**
 * XML 词法分析器测试
 */
class XmlLexerTest : ValkyrieLexerTestCase("testData/lexer/xml") {

    override fun createLexer(): Lexer {
        return ValkyrieXmlLexer()
    }

    fun testBasicXmlTag() {
        doTest("<div>content</div>")
    }

    fun testXmlWithAttributes() {
        doTest("<div class=\"container\" id=\"main\">")
    }

    fun testSelfClosingTag() {
        doTest("<img src=\"image.png\" />")
    }

    fun testXmlWithComments() {
        doTest("<!-- This is a comment -->")
    }

    fun testXmlWithBlockComments() {
        doTest("<!--\n    This is a multi-line\n    block comment\n-->")
    }

    fun testXmlWithCDATA() {
        doTest("<![CDATA[Some data here]]>")
    }

    fun testNestedTags() {
        doTest("<div><span>nested</span></div>")
    }

    fun testXmlWithValkyrieExpressions() {
        doTest("<div>{name}</div>")
    }

    fun testComplexXmlStructure() {
        doTest(
            """
            <template>
                <div class="container">
                    <h1>{title}</h1>
                    <p>{description}</p>
                </div>
            </template>
        """.trimIndent()
        )
    }
}