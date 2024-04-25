package valkyrie.project.sdk

import com.intellij.openapi.projectRoots.AdditionalDataConfigurable
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.SdkModel
import com.intellij.openapi.projectRoots.SdkModificator
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieSdkTypeInfo : AdditionalDataConfigurable {

    constructor(sdk: SdkModel, modifier: SdkModificator)



    override fun createComponent(): JComponent? {
        return panel {
            row("ValkyrieSdkTypeInfo") {
                text("???")
            }
        }
        return null
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {

    }

    override fun setSdk(sdk: Sdk?) {

    }
}