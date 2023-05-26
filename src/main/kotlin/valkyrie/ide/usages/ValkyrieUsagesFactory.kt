package valkyrie.ide.usages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieModifier
import valkyrie.psi.node.ValkyrieNamepath

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        // element is a PsiNamedElement
        return when (element) {
            is ValkyrieFileNode -> true
            is ValkyrieNamepath -> false
            is ValkyrieModifier -> false
            is ValkyrieDeclaration -> true
            else -> {
                println("canFindUsages: $element")
                false
            }
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler {
        return ValkyrieUsagesHandler(element, forHighlightUsages)
    }

    override fun createFindUsagesHandler(element: PsiElement, operationMode: OperationMode): FindUsagesHandler {
        return ValkyrieUsagesHandler(element, operationMode)
    }

    override fun setPluginDescriptor(pluginDescriptor: PluginDescriptor) {
        super.setPluginDescriptor(pluginDescriptor)
    }
}