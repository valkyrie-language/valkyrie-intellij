package com.github.valkyrie.ide.view.filter


import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.util.PlatformIcons


object PublicElementsFilter : Filter {

    override fun getName() = "KOTLIN_SHOW_NON_PUBLIC"

    override fun isReverted() = true
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        ValkyrieBundle.message("view.PublicElementsFilter"),
        "GGGGG",
        PlatformIcons.PRIVATE_ICON
    )
    override fun isVisible(treeNode: TreeElement): Boolean {
        return (treeNode as? ValkyrieStructureViewElement)?.getVisibility() ?: true
    }

}
