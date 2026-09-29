package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.navigation.TestType
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasObjectBody

/**
 * Tests 语句实现
 * 支持 tests { }
 */
class ValkyrieTestStatement(node: ASTNode) : ValkyrieElementNode(node), HasObjectBody, HasAnnotation {
    /**
     * 获取测试类型（benchmark、unit test 等）
     */
    fun getTestType(): TestType {
        val bodyText = getObjectBody()?.text ?: ""
        return when {
            bodyText.contains("benchmark") -> TestType.BENCHMARK
            bodyText.contains("prepare") || bodyText.contains("before") || bodyText.contains("after") -> TestType.INTEGRATION
            else -> TestType.UNIT
        }
    }

    /**
     * 获取所有 benchmark 块
     */
    fun getBenchmarkBlocks(): List<PsiElement> {
        val body = getObjectBody() ?: return emptyList()
        return body.children.filter {
            it.text.trimStart().startsWith("benchmark")
        }
    }

    /**
     * 获取所有生命周期钩子（prepare, before, after, clean）
     */
    fun getLifecycleHooks(): Map<String, PsiElement> {
        val body = getObjectBody() ?: return emptyMap()
        val hooks = mutableMapOf<String, PsiElement>()

        for (child in body.children) {
            val text = child.text.trimStart()
            when {
                text.startsWith("prepare") -> hooks["prepare"] = child
                text.startsWith("before") -> hooks["before"] = child
                text.startsWith("after") -> hooks["after"] = child
                text.startsWith("clean") -> hooks["clean"] = child
                text.startsWith("config") -> hooks["config"] = child
            }
        }

        return hooks
    }
}

