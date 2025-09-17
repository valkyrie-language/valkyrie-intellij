package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition


class TypeFunctionReturnTest : ParsingTestCase("testData/parser/typing/function_return", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"


    fun testColonReturnType() = doTest(true, true)

    fun testArrowReturnType() = doTest(true, true)

    fun testMixedReturnTypes() = doTest(true, true)

    fun testBasicReturnType() = doTest(true, true)

    fun testStringReturnType() = doTest(true, true)

    fun testBooleanReturnType() = doTest(true, true)

    fun testVoidReturnType() = doTest(true, true)

    fun testArrayReturnType() = doTest(true, true)

    fun testOptionalReturnType() = doTest(true, true)

    fun testGenericReturnType() = doTest(true, true)

    fun testFunctionReturnType() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}