package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.language.dialect_std.ValkyrieStandardLexer

/**
 * 关键字词法分析测试
 * 包含所有关键字相关的测试用例
 */
class KeywordTest : LexerTestCase() {
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }

    override fun getDirPath(): String {
        return "testData/lexer/keyword"
    }

    // 命名空间关键字
    fun testNamespaceKeyword() {
        doTest("namespace")
    }

    fun testUsingKeyword() {
        doTest("using")
    }

    // 基本控制流关键字
    fun testLetKeyword() {
        doTest("let")
    }

    fun testIfKeyword() {
        doTest("if")
    }

    fun testElseKeyword() {
        doTest("else")
    }

    fun testWhileKeyword() {
        doTest("while")
    }

    fun testUntilKeyword() {
        doTest("until")
    }

    fun testLoopKeyword() {
        doTest("loop")
    }

    fun testEndKeyword() {
        doTest("end")
    }

    // 函数定义关键字
    fun testMicroKeyword() {
        doTest("micro")
    }

    fun testMezzoKeyword() {
        doTest("mezzo")
    }

    fun testMacroKeyword() {
        doTest("macro")
    }

    // 类型定义关键字
    fun testClassKeyword() {
        doTest("class")
    }

    fun testNeuralKeyword() {
        doTest("neural")
    }

    fun testWidgetKeyword() {
        doTest("widget")
    }

    fun testSingletonKeyword() {
        doTest("singleton")
    }

    fun testUnionKeyword() {
        doTest("union")
    }

    fun testUnityKeyword() {
        doTest("unity")
    }

    fun testFlagsKeyword() {
        doTest("flags")
    }

    fun testEidosKeyword() {
        doTest("eidos")
    }

    fun testTraitKeyword() {
        doTest("trait")
    }

    fun testImplyKeyword() {
        doTest("imply")
    }

    fun testStructureKeyword() {
        doTest("structure")
    }

    // 控制流关键字
    fun testBreakKeyword() {
        doTest("break")
    }

    fun testContinueKeyword() {
        doTest("continue")
    }

    fun testYieldKeyword() {
        doTest("yield")
    }

    fun testRaiseKeyword() {
        doTest("raise")
    }

    fun testResumeKeyword() {
        doTest("resume")
    }

    fun testReturnKeyword() {
        doTest("return")
    }

    fun testScopeKeyword() {
        doTest("scope")
    }

    // 异常处理关键字
    fun testTryKeyword() {
        doTest("try")
    }

    fun testCatchKeyword() {
        doTest("catch")
    }

    // 模式匹配关键字
    fun testMatchKeyword() {
        doTest("match")
    }

    fun testCaseKeyword() {
        doTest("case")
    }

    fun testWhenKeyword() {
        doTest("when")
    }

    fun testFallthroughKeyword() {
        doTest("fallthrough;fallthrough!")
    }

    // 中缀运算符关键字
    fun testInKeyword() {
        doTest("in;not in")
    }

    fun testIsKeyword() {
        doTest("is;is not")
    }

    fun testAsKeyword() {
        doTest("as;as!;as?")
    }

    // 测试关键字
    fun testTestsKeyword() {
        doTest("tests")
    }

    // 特殊值关键字
    fun testNilKeyword() {
        doTest("nil")
    }

    fun testNullKeyword() {
        doTest("null")
    }
}