package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode

/**
 * Tests 语句实现
 * 支持 tests { } 和 test function() { } 两种形式
 */
class ValkyrieTestStatement(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    /**
     * 获取测试体（object body）
     */
    fun getTestBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }

    /**
     * 获取修饰符节点列表
     */
    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    /**
     * 检查是否有指定修饰符
     */
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    /**
     * 获取注解列表
     */
    fun getAnnotations(): List<ValkyrieAnnotationNode> {
        return findChildrenByClass(ValkyrieAnnotationNode::class.java).toList()
    }
    
    /**
     * 判断是否为 tests 块形式
     */
    fun isTestsBlock(): Boolean {
        return text.trimStart().startsWith("tests")
    }
    
    /**
     * 判断是否为 test 函数形式
     */
    fun isTestFunction(): Boolean {
        return hasModifier("test") && text.contains("function")
    }
    
    /**
     * 获取测试类型（benchmark、unit test 等）
     */
    fun getTestType(): TestType {
        val bodyText = getTestBody()?.text ?: ""
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
        val body = getTestBody() ?: return emptyList()
        return body.children.filter { 
            it.text.trimStart().startsWith("benchmark")
        }
    }
    
    /**
     * 获取所有生命周期钩子（prepare, before, after, clean）
     */
    fun getLifecycleHooks(): Map<String, PsiElement> {
        val body = getTestBody() ?: return emptyMap()
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

/**
 * 测试类型枚举
 */
enum class TestType {
    UNIT,        // 单元测试
    INTEGRATION, // 集成测试
    BENCHMARK    // 性能测试
}