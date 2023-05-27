package valkyrie.ide.navigation

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.usages.UsageView
import com.intellij.usages.rules.UsageGroupingRuleProvider

class ValkyrieUsageGroupingRuleProvider : UsageGroupingRuleProvider {
    override fun createGroupingActions(view: UsageView): Array<AnAction> {
        return super.createGroupingActions(view)
    }
}
