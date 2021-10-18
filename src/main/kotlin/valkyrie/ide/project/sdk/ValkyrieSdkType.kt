package valkyrie.ide.project.sdk

import com.intellij.openapi.projectRoots.*
import com.intellij.ui.dsl.builder.panel
import org.jdom.Element
import valkyrie.language.file.ValkyrieIconProvider
import java.io.File
import javax.swing.JComponent

class ValkyrieSdkType : SdkType("sdk.valkyrie") {
    override fun getIcon() = ValkyrieIconProvider.FILE
    override fun getPresentableName() = "Valkyrie SDK"

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
        val file = File(sdkHome);
        if (file.exists()) {
            return "Saber ${file.name}"
        } else {
            return "Invalid SDK"
        }
    }

    override fun sdkHasValidPath(sdk: Sdk): Boolean {
        println("sdkHasValidPath: ${sdk.homePath} ${sdk.homeDirectory}")
        return super.sdkHasValidPath(sdk)
    }

    override fun getVersionString(sdk: Sdk): String? {
        return super.getVersionString(sdk)
    }

    override fun getVersionString(sdkHome: String): String {
        return "0.0.0"
    }

    override fun createAdditionalDataConfigurable(sdkModel: SdkModel, sdkModificator: SdkModificator): AdditionalDataConfigurable? {
        return DataConfigurable(sdkModel, sdkModificator)
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

private class DataConfigurable(var model: SdkModel, var modificator: SdkModificator) : AdditionalDataConfigurable {
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