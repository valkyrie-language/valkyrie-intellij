package valkyrie.semantics.resolve

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import valkyrie.surface.psi.nodes.ValkyrieCallExpressionNode
import valkyrie.surface.psi.nodes.ValkyriePostfixExpressionNode
import valkyrie.surface.psi.nodes.ValkyrieTypeReferenceNode

/**
 * Valkyrie reference contributor.
 */
class ValkyrieReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            ValkyrieCrossFileReferenceProvider.IDENTIFIER_USAGE_PATTERN,
            ValkyrieCrossFileReferenceProvider(),
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieCallExpressionNode::class.java),
            ValkyrieFunctionCallReferenceProvider(),
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieTypeReferenceNode::class.java),
            ValkyrieTypeReferenceProvider(),
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyriePostfixExpressionNode::class.java),
            ValkyriePostfixReferenceProvider(),
        )
    }
}
