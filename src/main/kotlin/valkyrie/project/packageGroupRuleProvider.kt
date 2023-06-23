package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.usages.Usage
import com.intellij.usages.UsageGroup
import com.intellij.usages.UsageTarget
import com.intellij.usages.impl.PackageGroupRuleProvider
import com.intellij.usages.rules.UsageGroupingRule

class packageGroupRuleProvider : PackageGroupRuleProvider {
    override fun getUsageGroupingRule(project: Project, isDetachedMode: Boolean): UsageGroupingRule? {
        return RR()
    }
}

class RR : UsageGroupingRule {
    override fun getRank(): Int {
        return super.getRank()
    }

    override fun getParentGroupsFor(usage: Usage, targets: Array<out UsageTarget>): MutableList<UsageGroup> {
        return super.getParentGroupsFor(usage, targets)
    }

}