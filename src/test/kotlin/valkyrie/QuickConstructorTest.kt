package valkyrie

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class QuickConstructorTest : ParsingTestCase("testData/parser/imply", "txt", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testConstructor() {
        // 测试构造函数解析
        try {
            doTest(true, true)
            println("✅ 解析成功！没有出现 'Parser stuck' 错误")
            println("✅ 构造函数语法被正确识别")
            println("✅ DOT_CIRCLE (⸬) 分隔符被正确处理")
        } catch (e: Exception) {
            println("❌ 测试失败: ${e.message}")
            throw e
        }
    }

    override fun skipSpaces(): Boolean {
        return true
    }
}