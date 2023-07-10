package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.projectRoot.SdkDownloadTask

class ValkyrieSdkUnknownRemoteFix(sdk: UnknownSdk, indicator: ProgressIndicator) : UnknownSdkDownloadableSdkFix {
    override fun configureSdk(sdk: Sdk) {

    }

    override fun getDownloadDescription(): String {
        return "getDownloadDescription2323"
    }

    override fun getVersionString(): String {
        return "getVersionString4556"
    }

    override fun createTask(indicator: ProgressIndicator): SdkDownloadTask {
        return ValkyrieSdkDownloadTask()
    }

    override fun getPresentableVersionString(): String {
        return "getPresentableVersionString23"
    }

}