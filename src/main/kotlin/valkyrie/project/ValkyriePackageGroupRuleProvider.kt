package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.usages.impl.PackageGroupRuleProvider
import com.intellij.usages.rules.UsageGroupingRule

class ValkyriePackageGroupRuleProvider : PackageGroupRuleProvider {
    override fun getUsageGroupingRule(project: Project, isDetachedMode: Boolean): UsageGroupingRule? {
        return ValkyrieUsageGroupingRule()
    }
}

