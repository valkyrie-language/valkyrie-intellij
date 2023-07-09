package valkyrie.project.sdk

import com.intellij.openapi.projectRoots.*
import org.jdom.Element
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieSdkType : SdkType("ValkyrieSdkType") {
    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {

    }

    override fun suggestHomePath(): String? {
        return "suggestHomePath"
    }


    override fun isValidSdkHome(path: String): Boolean {
        return true
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        return "suggestSdkName"
    }

    override fun createAdditionalDataConfigurable(sdkModel: SdkModel, sdkModificator: SdkModificator): AdditionalDataConfigurable? {
        return ValkyrieAdditionalDataConfigurable()
    }

    override fun getPresentableName(): String {
        return "GetPresentableName223"
    }

    override fun getHelpTopic(): String {
        return "getHelpTopic33231"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getVersionString(sdk: Sdk): String {
        return "getVersionString"
    }

    override fun getDownloadSdkUrl(): String? {
        return "getDownloadSdkUrl"
    }

    override fun getHomeFieldLabel(): String {
        return "GetHomeFieldLabel"
    }

    override fun getDefaultDocumentationUrl(sdk: Sdk): String? {
        return "getDefaultDocumentationUrl"
    }

    override fun getInvalidHomeMessage(path: String): String {
        return "getInvalidHomeMessage"
    }
}

