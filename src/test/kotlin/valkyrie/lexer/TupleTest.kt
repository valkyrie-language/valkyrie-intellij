package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.language.dialect_std.ValkyrieStandardLexer

/**
 * 元组词法分析测试
 * 包含所有元组相关的测试用例
 */
class TupleTest : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "testData/lexer/tuple"
    }
    
    // 元组测试
    fun testEmptyTuple() {
        doTest("()")
    }
    
    fun testTupleWithElements() {
        doTest("(1, \"hello\", true)")
    }
    
    fun testNestedTuple() {
        doTest("((1, 2), (3, 4))")
    }
    
    // 集合字面量在表达式中的测试
    fun testTupleInExpression() {
        doTest("point = (x, y)")
    }
}