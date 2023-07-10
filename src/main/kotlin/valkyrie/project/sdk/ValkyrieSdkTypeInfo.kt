package valkyrie.project.sdk

import com.intellij.openapi.projectRoots.AdditionalDataConfigurable
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.SdkModel
import com.intellij.openapi.projectRoots.SdkModificator
import javax.swing.JComponent

class ValkyrieSdkTypeInfo(sdk: SdkModel, modifier: SdkModificator) : AdditionalDataConfigurable {
    override fun createComponent(): JComponent? {
//        return panel {
//            row("ValkyrieAdditionalDataConfigurable") {
//                text("???")
//            }
//        }
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