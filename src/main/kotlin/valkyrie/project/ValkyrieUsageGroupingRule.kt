package valkyrie.project

import com.intellij.usages.Usage
import com.intellij.usages.UsageGroup
import com.intellij.usages.UsageTarget
import com.intellij.usages.rules.UsageGroupingRule

class ValkyrieUsageGroupingRule : UsageGroupingRule {
    override fun getRank(): Int {
        return super.getRank()
    }

    override fun getParentGroupsFor(usage: Usage, targets: Array<out UsageTarget>): MutableList<UsageGroup> {
        return super.getParentGroupsFor(usage, targets)
    }

}