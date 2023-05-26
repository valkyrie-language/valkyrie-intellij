// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package valkyrie.ide.view.grouper

import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.util.PlatformIcons.ABSTRACT_CLASS_ICON
import valkyrie.language.ValkyrieBundle

private val title = ValkyrieBundle.message("view.PropertiesGrouper");
private val text = ValkyrieBundle.message("view.PropertiesGrouper");
private val description = ValkyrieBundle.message("view.PropertiesGrouper");

object PropertiesGrouper : Grouper {
    override fun getPresentation(): ActionPresentation {
        return ActionPresentationData(text, description, ABSTRACT_CLASS_ICON)
    }

    override fun getName(): String {
        return title
    }

    override fun group(parent: AbstractTreeNode<*>, children: MutableCollection<TreeElement>): MutableCollection<Group> {
        return arrayListOf()
    }
}

