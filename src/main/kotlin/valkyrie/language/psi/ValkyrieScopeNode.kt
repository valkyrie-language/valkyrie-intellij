package valkyrie.language.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.util.parents

interface ValkyrieScopeNode : PsiElement {
    override fun getContext(): ValkyrieScopeNode? {
        for (parent in this.parents(false)) {
            if (parent is ValkyrieScopeNode) {
                return parent
            }
        }
        return null;
    }
}