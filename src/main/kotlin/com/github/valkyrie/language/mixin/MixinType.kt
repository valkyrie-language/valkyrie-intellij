package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieTypeStatement
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinType(node: ASTNode) : DeclareNode(node)
     {
    override fun getOriginalElement(): ValkyrieASTBase {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieASTBase {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

         override fun getPresentation(): ItemPresentation = PresentationData(
        this.identifier.text,
        "",
        AllIcons.Nodes.Type,
        null
    )

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
     }

