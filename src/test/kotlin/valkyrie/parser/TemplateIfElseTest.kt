package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

class TemplateIfElseTest : ParsingTestCase("", "v", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"


    override fun getHomePath(): String {
        return super.getHomePath()
    }

    fun testTemplateIfElseEndStructure() = doTest(true, true)

    @Test
    fun testTemplateIfOnlyStructure() = doTest(true, true)

    @Test
    fun testTemplateElseIfStructure() = doTest(true, true)

    @Test
    fun testNestedTemplateStructure() = doTest(true, true)
}