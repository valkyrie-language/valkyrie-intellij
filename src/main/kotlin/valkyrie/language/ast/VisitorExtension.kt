package valkyrie.language.ast

import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.psi.*
import valkyrie.language.psi_node.ValkyrieImportItemNode
import valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil


fun ValkyrieImportStatement?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    val node = this as ValkyrieImportStatementNode
    val head = mutableListOf<String>()
    node.importItem?.addChildrenView(list, head.toTypedArray())
    node.importBlock?.addChildrenView(list, head.toTypedArray())
}

fun ValkyrieImportItem?.addChildrenView(list: MutableList<ValkyrieViewElement>, head: Array<String>) {
    if (this == null) return
    val item = this as ValkyrieImportItemNode
    val head = head.toMutableList()
    item.getNamepath().forEach { head.add(it.name) }
    when (val symbol = item.getIdentifierSymbol()) {
        null -> item.importBlock.addChildrenView(list, head.toTypedArray())
        else -> {
            val view = PresentationData(
                symbol.name,
                head.joinToString("∷"),
                // TODO: resolve icon
                symbol.reference?.element?.getIcon(0) ?: ValkyrieIconProvider.IMPORT,
                ValkyrieHighlightColor.LINE_COMMENT.textAttributesKey
            )
            list.add(ValkyrieViewElement(symbol, view))
        }
    }
}

fun ValkyrieImportBlock?.addChildrenView(list: MutableList<ValkyrieViewElement>, head: Array<String>) {
    if (this == null) return
    for (item in this.importItemList) {
        item.addChildrenView(list, head)
    }
}

fun ValkyrieDefineTuple?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            // val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(ValkyrieViewElement(it))
        }
}

fun ValkyrieDefineBlock?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            list.add(ValkyrieViewElement(it))
        }
}