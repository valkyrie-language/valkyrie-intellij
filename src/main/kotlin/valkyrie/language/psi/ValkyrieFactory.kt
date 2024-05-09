package valkyrie.language.psi

import com.intellij.lang.ASTFactory
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.GeneratedMarkerVisitor
import com.intellij.psi.impl.PsiManagerEx
import com.intellij.psi.impl.source.DummyHolderFactory
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.ValkyrieNumberLiteralNode

class ValkyrieFactory {
    private val project: Project

    constructor(project: Project) {
        this.project = project
    }


    constructor(element: PsiElement) {
        this.project = element.project
    }

    fun createNumberLiteral(number: String, unit: String?): ValkyrieNumberLiteralNode {
//        return letDefineAtom(number)!!.number as ValkyrieNumberNode
        throw Exception("unreachable: ValkyrieFactory::createNumberLiteral")
    }

    fun createSymbol(kind: IElementType, text: String): PsiElement {
        return createLeaf(ValkyrieTypes.SYMBOL, text)
    }

    fun createLeaf(kind: IElementType, text: String): PsiElement {
        val myManager = PsiManagerEx.getInstanceEx(project)
        val holderElement = DummyHolderFactory.createHolder(myManager, null).treeElement
        val newElement = ASTFactory.leaf(kind, holderElement.charTable.intern(text))
        holderElement.rawAddChildren(newElement)
        GeneratedMarkerVisitor.markGenerated(newElement.psi)
        return newElement.psi
    }

//
//    private fun letDefineAtom(atom: String): ValkyrieAtom? {
//        val file = createFile("let target = $atom;");
//        for (child in file.children) {
//            if (child is ValkyrieLetStatementNode) {
//                return child.expression!!.termList.first().atom
//            }
//        }
//        return null
//    }
}