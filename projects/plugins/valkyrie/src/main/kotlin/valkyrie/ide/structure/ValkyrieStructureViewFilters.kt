package valkyrie.ide.structure

import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement

/**
 * Valkyrie 结构视图过滤器
 */
object ValkyrieStructureViewFilters {

    val SHOW_FIELDS = object : Filter {
        override fun isVisible(treeNode: TreeElement): Boolean {
            return true // 暂时显示所有字段
        }

        override fun getPresentation(): ActionPresentation {
            return ActionPresentationData(
                "Show Fields",
                "Show/hide fields",
                null // 可以添加图标
            )
        }

        override fun getName(): String = "SHOW_FIELDS"

        override fun isReverted(): Boolean = false
    }

    val SHOW_METHODS = object : Filter {
        override fun isVisible(treeNode: TreeElement): Boolean {
            return true // 暂时显示所有方法
        }

        override fun getPresentation(): ActionPresentation {
            return ActionPresentationData(
                "Show Methods",
                "Show/hide methods",
                null
            )
        }

        override fun getName(): String = "SHOW_METHODS"

        override fun isReverted(): Boolean = false
    }

    val SHOW_PRIVATE = object : Filter {
        override fun isVisible(treeNode: TreeElement): Boolean {
            return true // 暂时显示所有私有成员
        }

        override fun getPresentation(): ActionPresentation {
            return ActionPresentationData(
                "Show Private Members",
                "Show/hide private members",
                null
            )
        }

        override fun getName(): String = "SHOW_PRIVATE"

        override fun isReverted(): Boolean = true // 默认隐藏私有成员
    }
}