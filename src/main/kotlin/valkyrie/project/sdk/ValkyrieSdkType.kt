package valkyrie.project.sdk

import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.*
import com.intellij.openapi.util.io.toNioPathOrNull
import org.jdom.Element
import org.jetbrains.annotations.Unmodifiable
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import java.nio.file.Path
import javax.swing.Icon
import kotlin.io.path.exists

class ValkyrieSdkType : SdkType("ValkyrieSDK") {
    @Deprecated("Deprecated in Intellij")
    override fun suggestHomePath(): String? {
        val userPath = System.getProperty("user.home").toNioPathOrNull()
        return userPath?.let { suggestHomePath(it) }
    }

    override fun suggestHomePath(path: Path): String? {
        val roles = path.resolve("valkyrie").resolve("roles")
        return roles.toString()
    }

    override fun suggestHomePaths(project: Project?): @Unmodifiable Collection<String?> {
        return super.suggestHomePaths(project)
    }

    override fun isValidSdkHome(path: String): Boolean {
        val role = path.toNioPathOrNull()?.resolve("role.json");
        return role != null && role.exists()
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        println("suggestSdkName: $currentSdkName")
        return "Valkyrie (nightly)"
    }

    override fun createAdditionalDataConfigurable(sdkModel: SdkModel, sdkModificator: SdkModificator): AdditionalDataConfigurable {
        return ValkyrieSdkTypeInfo(sdkModel, sdkModificator)
    }

    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {

    }

    override fun getPresentableName(): String {
        return ValkyrieBundle.message("ui.sdk")
    }

    override fun getHelpTopic(): String {
        return "getHelpTopic33231"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getVersionString(sdk: Sdk): String {
        println("getVersionString: $sdk = ${sdk.versionString}")
        return "getVersionString"
    }

    override fun getDownloadSdkUrl(): String {
        return "getDownloadSdkUrl"
    }

    override fun getHomeFieldLabel(): String {
        return ValkyrieBundle.message("ui.path")
    }

    override fun getDefaultDocumentationUrl(sdk: Sdk): String {
        return "getDefaultDocumentationUrl"
    }

    override fun getInvalidHomeMessage(path: String): String {
        return ValkyrieBundle.message("ui.sdk.missing.role", path)
    }
}

