package valkyrie.project.modules

import com.intellij.openapi.project.Project
import com.intellij.usages.Usage
import com.intellij.usages.rules.GeneratedSourceUsageFilter

class generatedSourceUsageFilter : GeneratedSourceUsageFilter {
    override fun isAvailable(): Boolean {
        return true
    }

    override fun isGeneratedSource(usage: Usage, project: Project): Boolean {
        println("isGeneratedSource2: ${usage}")
        return false
    }

}
