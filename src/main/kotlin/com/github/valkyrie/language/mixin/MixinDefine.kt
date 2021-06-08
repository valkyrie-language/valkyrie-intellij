package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.FunctionKind
import com.github.valkyrie.language.psi.ValkyrieDefineTuple
import com.github.valkyrie.language.psi_node.*
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.github.valkyrie.language.ast.addChildrenView
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinDefine(node: ASTNode) : DeclareNode(node) {

    override fun getOriginalElement(): ValkyrieDefineStatementNode {
        return this as ValkyrieDefineStatementNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.namepath.identifierList().last()
    }

    override fun getIcon(flags: Int): Icon = when {
        originalElement.isMethod() -> Method
        else -> Function
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.modified.addChildrenView(childrenView)
        originalElement.defineTuple.addChildrenView(childrenView)
        originalElement.defineBlock.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }

    val kind: FunctionKind
        get() {
            val namespace = originalElement.namepath;
            val lastDot = namespace.delimiterList().lastOrNull();
            val firstArg = originalElement.defineTuple?.defineItemList?.firstOrNull()
            return when {
                lastDot?.text == "::" -> FunctionKind.STATIC_METHOD
                lastDot?.text == "." -> FunctionKind.METHOD
                firstArg == null -> FunctionKind.FREE_FUNCTION
                else -> FunctionKind.FREE_FUNCTION
            }
        }

    fun isMethod(): Boolean = kind.isMethod
    fun isStatic(): Boolean = kind.isStatic
}

