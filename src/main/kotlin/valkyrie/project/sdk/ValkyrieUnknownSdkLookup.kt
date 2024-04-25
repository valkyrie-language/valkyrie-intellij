package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.roots.ui.configuration.UnknownSdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkLocalSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver

class ValkyrieUnknownSdkLookup : UnknownSdkResolver.UnknownSdkLookup {
    override fun proposeLocalFix(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkLocalSdkFix? {
        return ValkyrieUnknownSdkLocalSdkFix()
    }

    override fun proposeDownload(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkDownloadableSdkFix? {
        return ValkyrieUnknownSdkDownloadableSdkFix()
    }

}