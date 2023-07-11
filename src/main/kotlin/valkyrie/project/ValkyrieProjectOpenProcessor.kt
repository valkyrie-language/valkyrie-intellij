package valkyrie.project

import com.intellij.projectImport.ProjectOpenProcessorBase
import valkyrie.project.legion.LegionImporter

class ValkyrieProjectOpenProcessor : ProjectOpenProcessorBase<LegionImporter>() {
    override val supportedExtensions: Array<String> = arrayOf("json")
}
