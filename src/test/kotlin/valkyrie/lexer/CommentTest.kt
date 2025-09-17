package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.psi.lexers.ValkyrieStandardLexer

/**
 * 注释词法分析测试
 * 包含所有注释相关的测试用例
 */
class CommentTest : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "testData/lexer/comment"
    }
    
    // 单行注释测试
    fun testSingleLineComment() {
        doTest("# single line comment")
    }
    
    fun testEmptyComment() {
        doTest("#")
    }
    
    fun testCommentWithCode() {
        doTest("let x = 5; # this is a comment")
    }
    
    fun testCommentAtEndOfLine() {
        doTest("let x = 5 # comment at end")
    }
    
    // 文档注释测试
    fun testDocComment() {
        doTest("#? this is a doc comment")
    }
    
    fun testEmptyDocComment() {
        doTest("#?")
    }
    
    fun testDocCommentWithCode() {
        doTest("let x = 5; #? this is a doc comment")
    }
    
    fun testMultilineDocComment() {
        doTest("#? First line\n#? Second line")
    }
    
    // APL风格注释测试
    fun testAplComment() {
        doTest("⍝ APL style comment")
    }
    
    fun testEmptyAplComment() {
        doTest("⍝")
    }
    
    fun testAplCommentWithCode() {
        doTest("let x = 5 ⍝ APL comment")
    }
    
    // 复杂注释测试
    fun testCodeWithComments() {
        doTest("""
            # This is a header comment
            let x = 5 # inline comment
            #? Documentation for function
            micro test() {
                ⍝ APL style comment inside function
                return x
            }
        """.trimIndent())
    }
    
    fun testMultipleComments() {
        doTest("# comment 1\n# comment 2\n# comment 3")
    }
    
    fun testCommentInString() {
        doTest("\"This # is not a comment\"")
    }
    
    fun testMixedCommentTypes() {
        doTest("# regular comment\n#? doc comment\n⍝ APL comment")
    }
    
    // 特殊字符注释测试
    fun testCommentWithSpecialChars() {
        doTest("# Comment with 中文 and émojis 🎉")
    }
    
    fun testCommentWithSymbols() {
        doTest("# Comment with symbols: @#$%^&*()")
    }
    
    // 边界情况测试
    fun testCommentAtStartOfFile() {
        doTest("# First line comment\nlet x = 1")
    }
    
    fun testCommentAtEndOfFile() {
        doTest("let x = 1\n# Last line comment")
    }
    
    fun testConsecutiveCommentChars() {
        doTest("## double hash\n### triple hash")
    }
    
    fun testCommentWithTabs() {
        doTest("#\tcomment with tab")
    }
}