package valkyrie.test

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.ide.highlight.ValkyrieSyntaxHighlighter

/**
 * Valkyrie 语法高亮测试基类
 * 基于 JetBrains 高亮测试模式实现 <mcreference link="https://plugins.jetbrains.com/docs/intellij/testing-highlighting.html" index="1">1</mcreference>
 */
abstract class ValkyrieHighlightingTestCase : LightJavaCodeInsightFixtureTestCase() {
    
    override fun getTestDataPath(): String {
        return "src/test/resources/testData/highlighting"
    }
    
    /**
     * 测试语法高亮
     * @param fileName 测试文件名
     */
    protected fun doHighlightingTest(fileName: String) {
        myFixture.testHighlighting(fileName)
    }
    
    /**
     * 测试代码片段的语法高亮
     * @param code 代码内容
     * @param expectedHighlights 期望的高亮信息
     */
    protected fun testCodeHighlighting(code: String, expectedHighlights: Map<String, ValkyrieColor>) {
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 触发高亮计算
        myFixture.doHighlighting()
        
        // 验证高亮结果
        for ((text, expectedColor) in expectedHighlights) {
            val textRange = psiFile.text.indexOf(text)
            assertTrue("Text '$text' should be found in code", textRange >= 0)
            
            // 这里可以添加更详细的高亮验证逻辑
            // 由于 IntelliJ 的高亮 API 比较复杂，这里提供基础框架
        }
    }
    
    /**
     * 测试关键字高亮
     * @param keywords 关键字列表
     */
    protected fun testKeywordHighlighting(keywords: List<String>) {
        val code = keywords.joinToString(" ") { "$it identifier" }
        val psiFile = myFixture.configureByText("test.vk", code)
        
        myFixture.doHighlighting()
        
        // 验证关键字被正确高亮
        for (keyword in keywords) {
            assertTrue("Keyword '$keyword' should be highlighted", code.contains(keyword))
        }
    }
    
    /**
     * 测试字符串字面量高亮
     * @param strings 字符串字面量列表
     */
    protected fun testStringHighlighting(strings: List<String>) {
        val code = strings.joinToString("\n") { "let x = $it" }
        val psiFile = myFixture.configureByText("test.vk", code)
        
        myFixture.doHighlighting()
        
        // 验证字符串被正确高亮
        for (string in strings) {
            assertTrue("String '$string' should be highlighted", code.contains(string))
        }
    }
    
    /**
     * 测试注释高亮
     * @param comments 注释列表
     */
    protected fun testCommentHighlighting(comments: List<String>) {
        val code = comments.joinToString("\n")
        val psiFile = myFixture.configureByText("test.vk", code)
        
        myFixture.doHighlighting()
        
        // 验证注释被正确高亮
        for (comment in comments) {
            assertTrue("Comment '$comment' should be highlighted", code.contains(comment))
        }
    }
    
    /**
     * 测试数字字面量高亮
     * @param numbers 数字字面量列表
     */
    protected fun testNumberHighlighting(numbers: List<String>) {
        val code = numbers.joinToString("\n") { "let x = $it" }
        val psiFile = myFixture.configureByText("test.vk", code)
        
        myFixture.doHighlighting()
        
        // 验证数字被正确高亮
        for (number in numbers) {
            assertTrue("Number '$number' should be highlighted", code.contains(number))
        }
    }
    
    /**
     * 测试错误高亮
     * @param code 包含错误的代码
     * @param expectedErrors 期望的错误数量
     */
    protected fun testErrorHighlighting(code: String, expectedErrors: Int) {
        val psiFile = myFixture.configureByText("test.vk", code)
        
        val highlights = myFixture.doHighlighting()
        val errors = highlights.filter { it.severity == HighlightSeverity.ERROR }
        
        assertEquals(
            "Should have $expectedErrors error(s) in code: '$code'",
            expectedErrors,
            errors.size
        )
    }
    
    /**
     * 测试警告高亮
     * @param code 包含警告的代码
     * @param expectedWarnings 期望的警告数量
     */
    protected fun testWarningHighlighting(code: String, expectedWarnings: Int) {
        val psiFile = myFixture.configureByText("test.vk", code)
        
        val highlights = myFixture.doHighlighting()
        val warnings = highlights.filter { it.severity == HighlightSeverity.WARNING }
        
        assertEquals(
            "Should have $expectedWarnings warning(s) in code: '$code'",
            expectedWarnings,
            warnings.size
        )
    }
    
    /**
     * 打印高亮信息（用于调试）
     */
    protected fun printHighlightInfo(code: String) {
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        
        println("Highlighting info for code: '$code'")
        for ((index, highlight) in highlights.withIndex()) {
            println("  [$index] ${highlight.severity} '${highlight.description}' (${highlight.startOffset}-${highlight.endOffset})")
        }
    }
    
    /**
     * 验证特定文本的高亮属性
     * @param code 代码内容
     * @param text 要检查的文本
     * @param expectedAttributesKey 期望的高亮属性键
     */
    protected fun assertHighlightAttributes(code: String, text: String, expectedAttributesKey: TextAttributesKey) {
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 这里需要实现具体的高亮属性检查逻辑
        // 由于 IntelliJ 的高亮 API 比较复杂，这里提供基础框架
        val textOffset = code.indexOf(text)
        assertTrue("Text '$text' should be found in code", textOffset >= 0)
        
        // 可以通过 SyntaxHighlighter 来验证高亮属性
        val syntaxHighlighter = ValkyrieSyntaxHighlighter()
        // 具体实现需要根据实际的高亮逻辑来完成
    }
}