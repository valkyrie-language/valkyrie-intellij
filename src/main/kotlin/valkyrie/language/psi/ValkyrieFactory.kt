package valkyrie.language.psi

import com.intellij.lang.ASTFactory
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.PsiManagerEx
import com.intellij.psi.impl.source.DummyHolder
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage
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

//    fun createSymbol(kind: IElementType, text: String): LeafElement {
//        return createLeaf(ValkyrieTypes.SYMBOL, text)
//    }

    fun createLeaf(kind: IElementType, text: String): LeafElement {
        val manager = PsiManagerEx.getInstanceEx(project)
        val holder = DummyHolder(manager, null, null, null, true, ValkyrieLanguage)
        val leaf = ASTFactory.leaf(kind, holder.treeElement.charTable.intern(text))
        CodeEditUtil.setNodeGenerated(leaf, true);
        return leaf
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