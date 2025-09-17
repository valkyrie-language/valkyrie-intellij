package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class TypeExpressionTest : ParsingTestCase("testData/parser/complex", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"


    fun testComplexTypeExpressionParsing() = doTest(true, true)

    fun testNestedGenericTypes() = doTest(true, true)

    fun testGenericPathExpressions() = doTest(true, true)

    fun testMultipleTypeParameters() = doTest(true, true)

    fun testDeeplyNestedTypes() = doTest(true, true)

    fun testGenericWithBounds() = doTest(true, true)

    fun testAssociatedTypes() = doTest(true, true)

    fun testHigherKindedTypes() = doTest(true, true)

    fun testTypeAliasWithGenerics() = doTest(true, true)

    fun testComplexFunctionTypes() = doTest(true, true)

    fun testTupleTypes() = doTest(true, true)

    fun testUnionTypes() = doTest(true, true)

    fun testIntersectionTypes() = doTest(true, true)

    fun testExistentialTypes() = doTest(true, true)
}