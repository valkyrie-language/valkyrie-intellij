package valkyrie.lexer

import org.junit.Test
import org.junit.Assert.assertEquals
import valkyrie.psi.lexers.ValkyrieXmlLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes
import com.intellij.psi.xml.XmlTokenType

class ValkyrieXmlLexerTest {
    
    @Test
    fun testBasicXmlTag() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<div>content</div>", 0, 18, 0)
        
        // <
        assertEquals("First token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        assertEquals("Tag start should be '<'", "<", lexer.tokenText)
        
        // div
        lexer.advance()
        assertEquals("Second token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Tag name should be 'div'", "div", lexer.tokenText)
        
        // >
        lexer.advance()
        assertEquals("Third token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        assertEquals("Tag end should be '>'", ">", lexer.tokenText)
        
        // content
        lexer.advance()
        assertEquals("Fourth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Content should be 'content'", "content", lexer.tokenText)
        
        // </
        lexer.advance()
        assertEquals("Fifth token should be END_TAG_START", 
                    XmlTokenType.XML_END_TAG_START, lexer.tokenType)
        assertEquals("End tag start should be '</'", "</", lexer.tokenText)
        
        // div
        lexer.advance()
        assertEquals("Sixth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Closing tag name should be 'div'", "div", lexer.tokenText)
        
        // >
        lexer.advance()
        assertEquals("Seventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        assertEquals("Closing tag end should be '>'", ">", lexer.tokenText)
    }
    
    @Test
    fun testXmlWithAttributes() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<div class=\"container\" id=\"main\">", 0, 34, 0)
        
        // <
        assertEquals("First token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        // div
        lexer.advance()
        assertEquals("Second token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Tag name should be 'div'", "div", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Third token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // class
        lexer.advance()
        assertEquals("Fourth token should be XML_ATTRIBUTE_NAME", 
                    XmlTokenType.XML_ATTRIBUTE_NAME, lexer.tokenType)
        assertEquals("Attribute name should be 'class'", "class", lexer.tokenText)
        
        // =
        lexer.advance()
        assertEquals("Fifth token should be XML_EQ", 
                    XmlTokenType.XML_EQ, lexer.tokenType)
        assertEquals("Equals sign should be '='", "=", lexer.tokenText)
        
        // "container"
        lexer.advance()
        assertEquals("Sixth token should be XML_ATTRIBUTE_VALUE", 
                    XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN, lexer.tokenType)
        assertEquals("Attribute value should be '\"container\"'", "\"container\"", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Seventh token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // id
        lexer.advance()
        assertEquals("Eighth token should be XML_ATTRIBUTE_NAME", 
                    XmlTokenType.XML_ATTRIBUTE_NAME, lexer.tokenType)
        assertEquals("Second attribute name should be 'id'", "id", lexer.tokenText)
        
        // =
        lexer.advance()
        assertEquals("Ninth token should be XML_EQ", 
                    XmlTokenType.XML_EQ, lexer.tokenType)
        
        // "main"
        lexer.advance()
        assertEquals("Tenth token should be XML_ATTRIBUTE_VALUE", 
                    XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN, lexer.tokenType)
        assertEquals("Second attribute value should be '\"main\"'", "\"main\"", lexer.tokenText)
        
        // >
        lexer.advance()
        assertEquals("Eleventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
    }
    
    @Test
    fun testSelfClosingTag() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<img src=\"image.jpg\" />", 0, 23, 0)
        
        // <
        assertEquals("First token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        // img
        lexer.advance()
        assertEquals("Second token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Tag name should be 'img'", "img", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Third token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // src
        lexer.advance()
        assertEquals("Fourth token should be XML_ATTRIBUTE_NAME", 
                    XmlTokenType.XML_ATTRIBUTE_NAME, lexer.tokenType)
        assertEquals("Attribute name should be 'src'", "src", lexer.tokenText)
        
        // =
        lexer.advance()
        assertEquals("Fifth token should be XML_EQ", 
                    XmlTokenType.XML_EQ, lexer.tokenType)
        
        // "image.jpg"
        lexer.advance()
        assertEquals("Sixth token should be XML_ATTRIBUTE_VALUE", 
                    XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN, lexer.tokenType)
        assertEquals("Attribute value should be '\"image.jpg\"'", "\"image.jpg\"", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Seventh token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // />
        lexer.advance()
        assertEquals("Eighth token should be EMPTY_ELEMENT_END", 
                    XmlTokenType.XML_EMPTY_ELEMENT_END, lexer.tokenType)
        assertEquals("Self-closing end should be '/>'", "/>", lexer.tokenText)
    }
    
    @Test
    fun testNestedXmlTags() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<div><span>text</span></div>", 0, 28, 0)
        
        // <div>
        assertEquals("First token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Second token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Outer tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Third token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // <span>
        lexer.advance()
        assertEquals("Fourth token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Sixth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Inner tag name should be 'span'", "span", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Seventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // text
        lexer.advance()
        assertEquals("Eighth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Text should be 'text'", "text", lexer.tokenText)
        
        // </span>
        lexer.advance()
        assertEquals("Ninth token should be END_TAG_START", 
                    XmlTokenType.XML_END_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Tenth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Closing tag name should be 'span'", "span", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Eleventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // 换行
        lexer.advance()
        assertEquals("Twelfth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Final whitespace should be newline", "\n", lexer.tokenText)
        
        // </div>
        lexer.advance()
        assertEquals("Thirteenth token should be END_TAG_START", 
                    XmlTokenType.XML_END_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Fourteenth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Final tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Fifteenth token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
    }
    
    @Test
    fun testXmlComment() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<!-- This is a comment -->", 0, 27, 0)
        
        // 整个注释应该被识别为一个 token
        assertEquals("Token should be XML_COMMENT", 
                    XmlTokenType.XML_COMMENT_START, lexer.tokenType)
        assertEquals("Comment text should match", 
                    "<!-- This is a comment -->", lexer.tokenText)
        assertEquals("Comment should start at 0", 0, lexer.tokenStart)
        assertEquals("Comment should end at 27", 27, lexer.tokenEnd)
    }
    
    @Test
    fun testXmlWithWhitespace() {
        val lexer = ValkyrieXmlLexer()
        lexer.start("<div>\n  <span>text</span>\n</div>", 0, 32, 0)
        
        // <div>
        assertEquals("First token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Second token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Third token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // 换行和空格
        lexer.advance()
        assertEquals("Fourth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Whitespace should be preserved", "\n  ", lexer.tokenText)
        
        // <span>
        lexer.advance()
        assertEquals("Fifth token should be TAG_START", 
                    XmlTokenType.XML_START_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Sixth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Inner tag name should be 'span'", "span", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Seventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // text
        lexer.advance()
        assertEquals("Eighth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Text should be 'text'", "text", lexer.tokenText)
        
        // </span>
        lexer.advance()
        assertEquals("Ninth token should be END_TAG_START", 
                    XmlTokenType.XML_END_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Tenth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Closing tag name should be 'span'", "span", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Eleventh token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
        
        // 换行
        lexer.advance()
        assertEquals("Twelfth token should be XML_DATA_CHARACTERS", 
                    XmlTokenType.XML_DATA_CHARACTERS, lexer.tokenType)
        assertEquals("Final whitespace should be newline", "\n", lexer.tokenText)
        
        // </div>
        lexer.advance()
        assertEquals("Thirteenth token should be END_TAG_START", 
                    XmlTokenType.XML_END_TAG_START, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Fourteenth token should be TAG_NAME", 
                    XmlTokenType.XML_TAG_NAME, lexer.tokenType)
        assertEquals("Final tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Fifteenth token should be TAG_END", 
                    XmlTokenType.XML_TAG_END, lexer.tokenType)
    }
}