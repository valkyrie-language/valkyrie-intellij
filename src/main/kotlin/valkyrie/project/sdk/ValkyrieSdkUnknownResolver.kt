package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.UnknownSdk
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkLocalSdkFix
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver.UnknownSdkLookup

class ValkyrieSdkUnknownResolver : UnknownSdkResolver {
    override fun supportsResolution(sdkTypeId: SdkTypeId): Boolean {
        println("supportsResolution: $sdkTypeId ${sdkTypeId.name}")
        return true
    }

    override fun createResolver(project: Project?, indicator: ProgressIndicator): UnknownSdkLookup {
        return ValkyrieUnknownSdkLookup(project)
    }
}

private class ValkyrieUnknownSdkLookup(project: Project?) : UnknownSdkLookup {
    override fun proposeLocalFix(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkLocalSdkFix {
        return ValkyrieSdkUnknownLocalFix(sdk, indicator)
    }

    override fun proposeDownload(sdk: UnknownSdk, indicator: ProgressIndicator): UnknownSdkDownloadableSdkFix {
        return ValkyrieSdkUnknownRemoteFix(sdk, indicator)
    }
}