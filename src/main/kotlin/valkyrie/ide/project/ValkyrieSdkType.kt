package valkyrie.ide.project

import com.intellij.openapi.projectRoots.*
import com.intellij.ui.dsl.builder.panel
import org.jdom.Element
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon
import javax.swing.JComponent

class ValkyrieSdkType() : SdkType("ValkyrieSdkType") {
    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {
        TODO("Not yet implemented")
    }

    override fun suggestHomePath(): String? {
        return suggestHomePaths().firstOrNull()
    }

    override fun suggestHomePaths(): MutableCollection<String> {
        return mutableListOf("C:\\Users\\Default")
    }

    override fun isValidSdkHome(path: String): Boolean {
        println(path)
        return true
    }

    override fun adjustSelectedSdkHome(homePath: String): String {
        return homePath
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        return "Saber $sdkHome $currentSdkName"
    }

    override fun createAdditionalDataConfigurable(sdkModel: SdkModel, sdkModificator: SdkModificator): AdditionalDataConfigurable? {
        return DataConfigurable(sdkModel, sdkModificator)
    }

    override fun getPresentableName(): String {
        return "Valkyrie SDK"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.FILE
    }

    override fun getDownloadSdkUrl(): String? {
        return "super.getDownloadSdkUrl()"
    }

    override fun getDefaultDocumentationUrl(sdk: Sdk): String {
        return "https://plugins.jetbrains.com/docs/intellij/sdk.html#working-with-a-custom-sdk"
    }

    override fun getHomeFieldLabel(): String {
        return super.getHomeFieldLabel()
    }

    override fun getInvalidHomeMessage(path: String): String {
        return super.getInvalidHomeMessage(path)
    }


}

private class DataConfigurable(var sdkModel: SdkModel, var sdkModificator: SdkModificator) : AdditionalDataConfigurable {
    override fun getTabName(): String? {
        return "getTabName"
    }

    override fun disposeUIResources() {
        super.disposeUIResources()
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return super.getPreferredFocusedComponent()
    }


    override fun createComponent(): JComponent? {
        return panel {
            row("Name") {
                textField()
            }
        }
    }

    override fun isModified(): Boolean {
        return true
    }

    override fun apply() {

    }

    override fun cancel() {
        super.cancel()
    }

    override fun reset() {
        super.reset()
    }

    override fun setSdk(sdk: Sdk?) {

    }

}