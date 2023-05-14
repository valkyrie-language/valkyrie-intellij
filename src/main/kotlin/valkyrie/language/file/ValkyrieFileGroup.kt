package valkyrie.language.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider

class ValkyrieFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(consumer: ProjectViewNestingRulesProvider.Consumer) {
        consumer.addNestingRule(".vk", ".g.vk")
    }
}