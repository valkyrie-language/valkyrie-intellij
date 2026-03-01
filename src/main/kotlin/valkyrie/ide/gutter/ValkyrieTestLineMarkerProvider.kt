package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.ValkyrieTestStatement
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.ide.runner.ValkyrieTestRunner

/**
 * 测试语句的行标记提供器
 * 为 ValkyrieTestStatement 提供可点击的测试运行图标
 */
class ValkyrieTestLineMarkerProvider : LineMarkerProvider {

    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        // 只对 tests 关键字的叶子节点注册 LineMarker
        if (element.node?.elementType != ValkyrieTypes.TESTS) return null
        
        // 确保父节点是 ValkyrieTestStatement
        val testStatement = element.parent as? ValkyrieTestStatement ?: return null
        
        return LineMarkerInfo(
            element, // 注册到叶子节点
            element.textRange,
            ValkyrieIcons.TEST,
            { "Run test" },
            { _, _ ->
                ValkyrieTestRunner.runTest(testStatement)
            },
            GutterIconRenderer.Alignment.LEFT,
            { "Run test" }
        )
    }
}