package valkyrie.lexer

import com.intellij.lexer.Lexer
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.lexers.ValkyrieLexer

/**
 * 元组词法分析测试
 * 包含所有元组相关的测试用例
 */
class TupleTest : ValkyrieLexerTestCase("testData/lexer/tuple") {

    override fun createLexer(): Lexer {
        return ValkyrieLexer(ValkyrieLanguageConfig())
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