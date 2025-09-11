package valkyrie.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import valkyrie.psi.impl.ValkyrieIdentifierExpressionNode

/**
 * Valkyrie 引用贡献者
 */
class ValkyrieReferenceContributor : PsiReferenceContributor() {
    
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        // 注册跨文件引用提供者
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieIdentifierExpressionNode::class.java),
            ValkyrieCrossFileReferenceProvider()
        )
    }
}