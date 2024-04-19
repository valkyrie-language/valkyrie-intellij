package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.psi.lexers.ValkyrieStandardLexer

/**
 * 操作符词法分析测试
 * 包含所有操作符相关的测试用例
 */
class OperatorTest : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "testData/lexer/operator"
    }
    
    // 基本算术操作符
    fun testArithmeticOperators() {
        doTest("+ - * / %")
    }
    
    fun testMultiplySymbols() {
        doTest("* ×")
    }
    
    fun testDivisionOperators() {
        doTest("/ // ⅟")
    }
    
    fun testPowerOperator() {
        doTest("^")
    }
    
    // 比较操作符
    fun testComparisonOperators() {
        doTest("== != < >")
    }
    
    fun testComparisonSymbols() {
        doTest("<= >=")
    }
    
    // 逻辑操作符
    fun testLogicalOperators() {
        doTest("∧ ∨ ⩟ ⊼ ⊻ ⊽")
    }
    
    fun testLogicalSymbols() {
        doTest("! ?")
    }
    
    // 赋值操作符
    fun testAssignmentOperator() {
        doTest("=")
    }
    
    fun testCompoundAssignment() {
        doTest("+= -= ×= /= %= ^=")
    }
    
    // 位操作符
    fun testBitwiseOperators() {
        doTest("& | _")
    }
    
    // 范围操作符
    fun testRangeOperators() {
        doTest(".. ... ..= ..<")
    }
    
    // 访问操作符
    fun testAccessOperators() {
        doTest(". ::")
    }
    
    // 箭头操作符
    fun testArrowOperators() {
        doTest("-> =>")
    }
    
    // 分隔符
    fun testDelimiters() {
        doTest("; ;; , :")
    }
    
    // 括号
    fun testParentheses() {
        doTest("( ) { } [ ]")
    }
    
    fun testAngleBrackets() {
        doTest("< >")
    }
    
    fun testGenericBrackets() {
        doTest("⟨ ⟩")
    }
    
    // 特殊符号
    fun testSpecialSymbols() {
        doTest("@ ◤ ↯ ⸿ ※")
    }
    
    // 后缀单位操作符
    fun testUnitOperators() {
        doTest("℃ ℉ % ‰ ‱")
    }
    
    // 模板操作符
    fun testTemplateOperators() {
        doTest("<$ $>")
    }
    
    // 组合测试
    fun testOperatorCombinations() {
        doTest("x += y * z")
    }
    
    fun testComplexExpression() {
        doTest("(a + b) * c^2 <= max_value")
    }
    
    fun testLogicalExpression() {
        doTest("x ∧ y ∨ (not z)")
    }
}