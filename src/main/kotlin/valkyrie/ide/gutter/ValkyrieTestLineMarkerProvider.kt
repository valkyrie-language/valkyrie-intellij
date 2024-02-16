package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.ValkyrieTestStatement
import valkyrie.ide.runner.ValkyrieTestRunner

/**
 * 测试语句的行标记提供器
 * 为 ValkyrieTestStatement 提供可点击的测试运行图标
 */
class ValkyrieTestLineMarkerProvider : LineMarkerProvider {

    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return when (element) {
            is ValkyrieTestStatement -> createTestRunMarker(element)
            else -> null
        }
    }

    private fun createTestRunMarker(element: ValkyrieTestStatement): LineMarkerInfo<PsiElement> {
        return LineMarkerInfo(
            element,
            element.textRange,
            ValkyrieIcons.TEST_RUN,
            { "Run Test" },
            { _, testElement ->
                if (testElement is ValkyrieTestStatement) {
                    ValkyrieTestRunner.runTest(testElement)
                }
            },
            GutterIconRenderer.Alignment.LEFT,
            { "Run Test" }
        )
    }
}