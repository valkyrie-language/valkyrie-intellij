package valkyrie.language.file

import com.intellij.icons.ExpUiIcons
import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class ValkyrieIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val file = psiElement.containingFile ?: return null
        return when {
            file.name.endsWith(".vk") -> Instance.Valkyrie
            file.name.endsWith(".valkyrie") -> Instance.Valkyrie
            else -> null
        }
    }

    object Instance {
        val Valkyrie = IconLoader.getIcon("/icons/vk.svg", ValkyrieIconProvider::class.java)
        val Namespace = IconLoader.getIcon("/icons/actionQualifiedNames.svg", ValkyrieIconProvider::class.java)
        val Trait = IconLoader.getIcon("/icons/trait.svg", ValkyrieIconProvider::class.java)
        val Enumeration = IconLoader.getIcon("/icons/codeAssistantEnum.svg", ValkyrieIconProvider::class.java)
        val Flags = IconLoader.getIcon("/icons/codeAssistantField.svg", ValkyrieIconProvider::class.java)
        val Attribute = IconLoader.getIcon("/icons/codeAssistantMacro.svg", ValkyrieIconProvider::class.java)
        val Object = IconLoader.getIcon("/icons/objectScala.svg", ValkyrieIconProvider::class.java)
        val Effect = ExpUiIcons.Actions.DiagramDiff
        val Untyped = IconLoader.getIcon("/icons/untyped.svg", ValkyrieIconProvider::class.java)
        val MultipleType = IconLoader.getIcon("/icons/multipleTypeDefinitions.svg", ValkyrieIconProvider::class.java)
        val Stop = ExpUiIcons.Actions.ShowWriteAccess
        val Then = IconLoader.getIcon("/icons/goto.svg", ValkyrieIconProvider::class.java)


    }
}
