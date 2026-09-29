package valkyrie.workspace.project

import com.intellij.ide.projectView.PresentationData
import com.intellij.ui.SimpleTextAttributes

internal fun PresentationData.setPresentableNameWithTypeSuffix(name: String, typeLabel: String) {
    clearText()
    addText(name, SimpleTextAttributes.REGULAR_ATTRIBUTES)
    addText(" ($typeLabel)", SimpleTextAttributes.GRAYED_ATTRIBUTES)
}
