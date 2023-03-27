package valkyrie.language.file

import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class ValkyrieIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val file = psiElement.containingFile ?: return null
        return when {
            file.name.endsWith(".vk") -> Instance.File
            file.name.endsWith(".valkyrie") -> Instance.File
            else -> null
        }
    }

    object Instance {
        val File = IconLoader.getIcon("/icons/vk.svg", ValkyrieIconProvider::class.java)
    }
}
