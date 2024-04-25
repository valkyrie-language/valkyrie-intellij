package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdkLocalSdkFix

class ValkyrieSdkUnknownLocalFix(sdk: UnknownSdk, indicator: ProgressIndicator) : UnknownSdkLocalSdkFix {
    override fun configureSdk(sdk: Sdk) {

    }

    override fun getExistingSdkHome(): String {
        return "getExistingSdkHome11"
    }

    override fun getVersionString(): String {
        return "nightly (2024-1-1)"
    }

    override fun getSuggestedSdkName(): String {
        return "getSuggestedSdkName233"
    }

    override fun getPresentableVersionString(): String {
        return "getPresentableVersionString"
    }

    override fun getRegisteredSdkPrototype(): Sdk? {
        return super.getRegisteredSdkPrototype()
    }

}