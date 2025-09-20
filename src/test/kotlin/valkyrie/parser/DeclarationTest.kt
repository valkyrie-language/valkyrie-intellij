package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class DeclarationTest : ParsingTestCase("testData/parser/declaration", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testTests() = doTest(true, true)
    fun testClass() = doTest(true, true)
    fun testSingleton() = doTest(true, true)


    fun testClassEmpty() = doTest(true, true)
    fun testClassField() = doTest(true, true)
    fun testClassMethod() = doTest(true, true)
    fun testClassDomain() = doTest(true, true)

    fun testClassGeneric() = doTest(true, true)
    fun testClassInherit() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }
}