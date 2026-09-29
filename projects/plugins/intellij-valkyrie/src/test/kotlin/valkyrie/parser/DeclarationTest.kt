package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class DeclarationTest : ValkyrieParsingTestCase("testData/parser/declaration") {
    fun testTests() = doTest(true, true)
    fun testClass() = doTest(true, true)
    fun testSingleton() = doTest(true, true)

    fun testClassEmpty() = doTest(true, true)
    fun testClassField() = doTest(true, true)
    fun testClassMethod() = doTest(true, true)
    fun testClassDomain() = doTest(true, true)

    fun testClassGeneric() = doTest(true, true)
    fun testClassInherit() = doTest(true, true)
    fun testClassConstructor() {
        doTest(true, true)
    }
    fun testClassWithSemicolon() = doTest(true, true)
    fun testUnionWithSemicolon() = doTest(true, true)
    fun testTraitWithSemicolon() = doTest(true, true)
    fun testImplyWithSemicolon() = doTest(true, true)
    fun testStructureIssue() = doTest(true, true)
    fun testGenericDefault() = doTest(true, true)
    fun testFunction() = doTest(true, true)
    fun testImplyMacro() = doTest(true, true)
    fun testTypeAlias() = doTest(true, true)
    fun testImplyAssociatedType() = doTest(true, true)
    fun testStructure() = doTest(true, true)
    fun testStructureGetField() = doTest(true, true)
    fun testMutSelfParameter() = doTest(true, true)
    fun testEnums() = doTest(true, true)
    fun testTraitSelf() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }
}