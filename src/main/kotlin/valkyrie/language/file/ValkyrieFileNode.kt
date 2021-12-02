package valkyrie.language.file

import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.reference.ValkyrieReference
import valkyrie.ide.reference.ValkyrieReferenceProvider

/// ValkyrieFile 是个 PsiElement
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    override fun getFileType(): FileType = ValkyrieFileType
    override fun toString(): String = ValkyrieBundle.message("action.create_file")
    fun getChildrenView(): Array<TreeElement> {
        return PsiTreeUtil
            .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
            .filter { it.presentation != null }
            .map { ValkyrieViewElement(it) }
            .toTypedArray()
    }

    fun getChildrenSymbol(name: List<String>): ValkyrieASTBase? {
        return PsiTreeUtil
            .getChildrenOfAnyType(
                this,
                ValkyrieClassStatementNode::class.java,
                ValkyrieTraitStatementNode::class.java,
            )
            .filter { it.name == name.first() }
            .firstNotNullOfOrNull { it.resolveNamespace(name.drop(1)) }
    }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
        return super.getOwnDeclarations()
    }

    override fun getOwnReferences(): MutableCollection<out PsiSymbolReference> {
        return super.getOwnReferences()
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk"
    }
}

