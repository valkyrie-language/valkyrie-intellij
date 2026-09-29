package von.parser

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.impl.DebugUtil
import com.intellij.psi.util.PsiTreeUtil
import von.test.VonParsingTestCase

class VonParserSmokeTest : VonParsingTestCase("testData/parser/legion") {
    fun testFlatTableHasNoErrors() = assertNoErrors("{ core: true }")

    fun testNestedTableHasNoErrors() = assertNoErrors("{ auto_link: { core: true, std: true } }")

    fun testQuotedKeyAndArrayHasNoErrors() = assertNoErrors(
        """
        {
            dependencies: { "atlas": { version: "workspace" } },
            build: [ { target: "nyar" }, { target: "clr", msil: true } ]
        }
        """.trimIndent(),
    )

    fun testTrailingWhitespaceAfterRootTableHasNoErrors() = assertNoErrors(
        """
        {
            name: "atlas.tools"
        }
        
        """.trimIndent() + "\n",
    )

    private fun assertNoErrors(text: String) {
        val psiFile = createPsiFile("case.von", text)
        val errors = PsiTreeUtil.findChildrenOfType(psiFile, PsiErrorElement::class.java).toList()
        if (errors.isNotEmpty()) {
            fail(DebugUtil.psiToString(psiFile, true))
        }
    }
}
