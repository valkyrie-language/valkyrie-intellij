package com.github.valkyrie.ide.view.filter


import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.util.PlatformIcons


object PublicElementsFilter : Filter {
    override fun isVisible(treeNode: TreeElement): Boolean {
        return (treeNode as? ValkyrieStructureViewElement)?.getVisibility() ?: true
    }

    override fun getPresentation(): ActionPresentation {
        return ActionPresentationData(ValkyrieBundle.message("show.non.public"), null, PlatformIcons.PRIVATE_ICON)
    }

    override fun getName() = ID

    override fun isReverted() = true

    const val ID = "KOTLIN_SHOW_NON_PUBLIC"
}
