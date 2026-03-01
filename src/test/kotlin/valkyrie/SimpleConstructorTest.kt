package valkyrie

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieParserDefinition

class SimpleConstructorTest : ParsingTestCase("testData/parser/imply", "txt", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testConstructor() {
        // 简单测试：确保不会出现 "Parser stuck" 错误
        try {
            doTest(true, true)
            println("✅ Test passed - no parser stuck error!")
        } catch (e: Exception) {
            println("❌ Test failed: ${e.message}")
            throw e
        }
    }

    override fun skipSpaces(): Boolean {
        return true
    }
}