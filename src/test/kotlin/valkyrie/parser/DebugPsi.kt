package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class DebugPsi : ParsingTestCase("parser/declaration", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources/testData"
    override fun includeRanges(): Boolean = false

    fun testPrintPsi() {
        val code = """
            trait Applicative: Functor {
                @.functional
                apply<A, B>(self, other: Self<A -> B>): Self<B>
                left_a2<A, B>(f: (A, A) -> B, a: Self<A>, b: Self<B>): Self<B>
            }
        """.trimIndent()
        val file = createPsiFile("test.vk", code)
        println(com.intellij.psi.impl.DebugUtil.psiToString(file, false))
    }
}
