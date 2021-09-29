package valkyrie.ide.completion

import com.intellij.usages.Usage
import com.intellij.usages.UsageTarget
import com.intellij.usages.rules.ImportFilteringRule

class ValkyrieImportFilter : ImportFilteringRule() {
    override fun isVisible(usage: Usage): Boolean {
        return super.isVisible(usage)
    }

    override fun isVisible(usage: Usage, targets: Array<out UsageTarget>): Boolean {
        return super.isVisible(usage, targets)
    }
}