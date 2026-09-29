package valkyrie.lexer

import com.intellij.lexer.Lexer
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.lexers.ValkyrieLexer

/**
 * 数组词法分析测试
 * 包含所有数组相关的测试用例
 */
class ArrayTest : ValkyrieLexerTestCase("testData/lexer/array") {

    override fun createLexer(): Lexer {
        return ValkyrieLexer(ValkyrieLanguageConfig())
    }

    // 数组测试
    fun testEmptyArray() {
        doTest("[]")
    }

    fun testArrayWithElements() {
        doTest("[1, 2, 3]")
    }

    fun testNestedArray() {
        doTest("[[1, 2], [3, 4]]")
    }

    fun testArrayWithMixedTypes() {
        doTest("[1, \"hello\", true]")
    }

    // 集合操作测试
    fun testArrayAccess() {
        doTest("array[0]")
    }

    // 集合字面量在表达式中的测试
    fun testArrayInExpression() {
        doTest("arr = [1, 2, 3]")
    }

    fun testArrayOfFunctions() {
        doTest("[micro() { x + 1 }, micro { y * 2 }]")
    }
}