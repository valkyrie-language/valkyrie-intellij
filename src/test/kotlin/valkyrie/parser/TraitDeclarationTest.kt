package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * ValkyrieTraitAliasDeclaration 测试用例
 * 验证 trait 别名声明的解析和功能
 */
class TraitDeclarationTest : ParsingTestCase("testData/parser/trait_alias", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    @Test
    fun testBasicTraitAlias() = doTest(true, true)

    @Test
    fun testTraitAliasWithSingleTrait() = doTest(true, true)

    @Test
    fun testTraitAliasWithMultipleTraits() = doTest(true, true)

    @Test
    fun testTraitAliasWithGenerics() = doTest(true, true)

    @Test
    fun testTraitAliasWithComplexGenerics() = doTest(true, true)

    @Test
    fun testTraitAliasWithBounds() = doTest(true, true)

    @Test
    fun testMultipleTraitAliases() = doTest(true, true)
}