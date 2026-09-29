package valkyrie.lexer

import com.intellij.lexer.Lexer
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.surface.file.ValkyrieLanguageConfig
import valkyrie.surface.lexer.ValkyrieLexer

/**
 * 对象/映射词法分析测试
 * 包含所有对象/映射相关的测试用例
 */
class ObjectTest : ValkyrieLexerTestCase("testData/lexer/object") {

    override fun createLexer(): Lexer {
        return ValkyrieLexer(ValkyrieLanguageConfig())
    }

    // 对象/映射测试
    fun testEmptyObject() {
        doTest("{}")
    }

    fun testObjectWithProperties() {
        doTest("{name: \"John\", age: 30}")
    }

    fun testNestedObject() {
        doTest("{person: {name: \"John\", age: 30}}")
    }

    fun testObjectWithArrays() {
        doTest("{numbers: [1, 2, 3], names: [\"a\", \"b\"]}")
    }

    // 集合操作测试
    fun testObjectAccess() {
        doTest("object.property")
    }

    fun testChainedAccess() {
        doTest("object.array[0].property")
    }

    // 集合字面量在表达式中的测试
    fun testObjectInExpression() {
        doTest("obj = {x: 10, y: 20}")
    }

    // 复杂集合结构测试
    fun testComplexStructure() {
        doTest("{users: [{name: \"John\", scores: [95, 87, 92]}]}")
    }
}