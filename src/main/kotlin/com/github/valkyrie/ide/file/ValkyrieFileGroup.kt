package com.github.valkyrie.ide.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import org.jetbrains.annotations.NotNull

class ValkyrieFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: ProjectViewNestingRulesProvider.Consumer) {
        consumer.addNestingRule(".vk", ".g.vk")
        consumer.addNestingRule(".vk", ".md")
    }
}