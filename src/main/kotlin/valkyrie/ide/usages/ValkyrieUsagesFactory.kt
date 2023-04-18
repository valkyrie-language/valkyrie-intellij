package valkyrie.ide.usages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.psi.PsiElement
import valkyrie.psi.node.*

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        // element is a PsiNamedElement
        return when (element) {
            is ValkyrieDeclareEnumerate,
            is ValkyrieDeclareClass,
            is ValkyrieDeclareTrait,
            is ValkyrieTraitAlias,
            is ValkyrieDeclareSemantic,
            is ValkyrieDeclareFlags,
            -> true

            is ValkyrieNamepath,
            -> false

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