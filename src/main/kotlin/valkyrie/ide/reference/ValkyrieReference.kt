package valkyrie.ide.reference

import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.mixin.MixinIdentifier
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference


class ValkyrieReference(private val source: ValkyrieASTBase, range: TextRange? = null) : PsiReference {
    private val range: TextRange
    init {
        when {
            range != null -> this.range = range
            else -> this.range = TextRange(0, source.textLength)
        }
    }
    constructor(source: ValkyrieIdentifier, range: TextRange? = null) : this(source as ValkyrieASTBase, range);
    override fun getElement(): ValkyrieASTBase = source
    override fun getRangeInElement(): TextRange = range
    override fun resolve(): ValkyrieASTBase? {
        val file = source.containingFile as ValkyrieFileNode
        return file.getChildrenSymbol(listOf(source.name ?: return null))
    }
    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
    }
    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }
    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }
    override fun isReferenceTo(element: PsiElement): Boolean {
        return true
    }
    override fun isSoft(): Boolean {
        return false
    }
}

