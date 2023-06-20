package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.UnknownSdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkLocalSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver.UnknownSdkLookup
import com.intellij.openapi.roots.ui.configuration.projectRoot.SdkDownloadTask

class unknownSdkResolver : UnknownSdkResolver {
    override fun supportsResolution(sdkTypeId: SdkTypeId): Boolean {
        return true
    }

    override fun createResolver(project: Project?, indicator: ProgressIndicator): UnknownSdkLookup? {
        return SS()
    }
}


class SS : UnknownSdkLookup {
    override fun proposeLocalFix(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkLocalSdkFix? {
        return SA()
    }

    override fun proposeDownload(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkDownloadableSdkFix? {
        return SB()
    }

}

class SA : UnknownSdkLocalSdkFix {
    override fun configureSdk(sdk: Sdk) {

    }

    override fun getExistingSdkHome(): String {
        return "getExistingSdkHome11"
    }

    override fun getVersionString(): String {
        return "getVersionString22"
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

class SB : UnknownSdkDownloadableSdkFix {
    override fun configureSdk(sdk: Sdk) {

    }

    override fun getDownloadDescription(): String {
        return "getDownloadDescription2323"
    }

    override fun getVersionString(): String {
        return "getVersionString4556"
    }

    override fun createTask(indicator: ProgressIndicator): SdkDownloadTask {
        return SSC()
    }

    override fun getPresentableVersionString(): String {
        return "getPresentableVersionString23"
    }

}

class SSC : SdkDownloadTask {
    override fun getSuggestedSdkName(): String {
        return "getSuggestedSdkName323"
    }

    override fun getPlannedHomeDir(): String {
        return "getPlannedHomeDir34232"
    }

    override fun getPlannedVersion(): String {
        return "getPlannedVersion3423"
    }

    override fun doDownload(indicator: ProgressIndicator) {

    }
}