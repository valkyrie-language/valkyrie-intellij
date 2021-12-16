@file:Suppress("UnstableApiUsage")

package valkyrie.language.mixin

import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.ide.reference.ValkyrieReference
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieImportStatementNode
import valkyrie.language.symbol.ImportData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference
import com.intellij.psi.search.GlobalSearchScope
import javax.swing.Icon

open class MixinImport(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.IMPORT
    override fun getOriginalElement(): ValkyrieImportStatementNode {
        return this as ValkyrieImportStatementNode
    }

    override fun getPresentation(): ItemPresentation? {
        return null
    }

    fun expandImports(): Map<String, Array<String>> {
        val imports = mutableMapOf<String, Array<String>>()
        val importStatement = this.originalElement.importItem
        return imports
    }

    fun resolveImports() {

    }
}

