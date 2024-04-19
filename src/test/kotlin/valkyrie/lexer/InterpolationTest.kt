package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.psi.lexers.ValkyrieStandardLexer

/**
 * 字符串插值词法分析测试
 * 包含所有字符串插值相关的测试用例
 */
class InterpolationTest : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "testData/lexer/interpolation"
    }
    
    // 基本插值测试
    fun testSimpleInterpolation() {
        doTest("\"Hello, {name}!\"")
    }
    
    fun testMultipleInterpolations() {
        doTest("\"User {id}: {name}\"")
    }
    
    fun testEmptyInterpolation() {
        doTest("\"Value: {}\"")
    }
    
    // 表达式插值测试
    fun testArithmeticInterpolation() {
        doTest("\"Result: {x + y}\"")
    }
    
    fun testFunctionCallInterpolation() {
        doTest("\"Length: {text.length()}\"")
    }
    
    fun testPropertyAccessInterpolation() {
        doTest("\"Name: {user.name}\"")
    }
    
    fun testArrayAccessInterpolation() {
        doTest("\"First: {items[0]}\"")
    }
    
    fun testMethodChainInterpolation() {
        doTest("\"Result: {data.process().format()}\"")
    }
    
    // 嵌套插值测试
    fun testNestedInterpolation() {
        doTest("\"Outer: {\"Inner: {value}\"}\"")
    }
    
    fun testConditionalInterpolation() {
        doTest("\"Status: {if condition { \"active\" } else { \"inactive\" }}\"")
    }
    
    // 复杂表达式插值
    fun testComplexExpression() {
        doTest("\"Result: {(x * 2 + y) / z}\"")
    }
    
    fun testMethodChaining() {
        doTest("\"Data: {items.filter(|x| x > 0).map(|x| x * 2).join(\", \")}\"")
    }
    
    fun testLambdaInterpolation() {
        doTest("\"Sum: {numbers.reduce(|a, b| a + b)}\"")
    }
    
    // 转义和特殊情况
    fun testEscapedBraces() {
        doTest("\"Literal braces: \\{not interpolated\\}\"")
    }
    
    fun testInterpolationWithQuotes() {
        doTest("\"Message: {get_message(\"hello\")}\"")
    }
    
    fun testInterpolationWithNewlines() {
        doTest("\"Multi\\nline: {value}\"")
    }
    
    // 多行字符串插值
    fun testMultilineInterpolation() {
        doTest("""
            \"\"\"
            Name: {name}
            Age: {age}
            \"\"\"
        """.trimIndent())
    }
    
    // 原始字符串（如果支持）
    fun testRawStringInterpolation() {
        doTest("r\"Raw string with {value}\"")
    }
    
    // 错误情况测试
    fun testUnterminatedInterpolation() {
        doTest("\"Unterminated: {value\"")
    }
    
    fun testInvalidInterpolationSyntax() {
        doTest("\"Invalid: {{}\"")
    }
    
    fun testNestedBraces() {
        doTest("\"Complex: {map.get(\"key\").unwrap_or(\"default\")}\"")
    }
    
    fun testInterpolationInSingleQuotes() {
        doTest("'Single quote: {value}'")
    }
    
    // 数字和布尔值插值
    fun testNumberInterpolation() {
        doTest("\"Number: {42}\"")
    }
    
    fun testBooleanInterpolation() {
        doTest("\"Boolean: {true}\"")
    }
    
    // 复杂嵌套结构
    fun testComplexNestedStructure() {
        doTest("\"Result: {users.find(|u| u.id == {target_id}).map(|u| u.name).unwrap_or(\"Unknown\")}\"")
    }
}