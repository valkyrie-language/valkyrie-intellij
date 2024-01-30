package valkyrie.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieCallExpressionNode

/**
 * Valkyrie 引用贡献者
 */
class ValkyrieReferenceContributor : PsiReferenceContributor() {
    
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        // 注册跨文件引用提供者
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java),
            ValkyrieCrossFileReferenceProvider()
        )
        
        // 注册函数调用引用提供者
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieCallExpressionNode::class.java),
            ValkyrieFunctionCallReferenceProvider()
        )
    }
}