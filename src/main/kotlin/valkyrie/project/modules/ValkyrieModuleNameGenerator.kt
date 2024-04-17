package valkyrie.project.facet

import com.intellij.ide.util.projectWizard.ModuleNameGenerator
import java.util.function.Consumer
import javax.swing.JComponent

@Suppress("UnstableApiUsage")
class ValkyrieModuleNameGenerator : ModuleNameGenerator {
    /** New > Project > Name (right side) */
    override fun getUi(place: String?, nameSetter: Consumer<in String>): JComponent? {
        // This interface is effective for all languages and frameworks
        // Temporarily remove
        return null
    }
}
