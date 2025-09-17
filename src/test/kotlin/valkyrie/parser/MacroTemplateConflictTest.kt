package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * 宏赋值与模板语法冲突测试
 * 验证修复后的解析器能正确区分宏赋值和模板语法
 */
class MacroTemplateConflictTest : ParsingTestCase("", "v", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "E:\\RustroverProjects\\nyar-framework\\valkyrie-intellij\\src\\test\\kotlin\\valkyrie\\parser"

    @Test
    fun testMacroAssignmentStructure() = doTest(true, true)

    @Test
    fun testTemplateBlockStructure() = doTest(true, true)

    @Test
    fun testMixedMacroAndTemplate() = doTest(true, true)

    @Test
    fun testComplexTemplateWithVariables() = doTest(true, true)
}