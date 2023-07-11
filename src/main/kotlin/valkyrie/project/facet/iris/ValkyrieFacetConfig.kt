package valkyrie.project.facet.iris

import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager

class ValkyrieFacetConfig : FacetConfiguration {
    override fun createEditorTabs(editorContext: FacetEditorContext?, validatorsManager: FacetValidatorsManager?): Array<FacetEditorTab> {
        return arrayOf(
            ValkyrieFacetConfigFramework(editorContext),
            ValkyrieFacetConfigDependency(editorContext)
        )
    }
}

