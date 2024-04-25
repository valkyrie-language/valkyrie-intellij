package valkyrie.project.sdk

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver
import com.intellij.openapi.roots.ui.configuration.UnknownSdkResolver.UnknownSdkLookup

class ValkyrieUnknownSdkResolver : UnknownSdkResolver {
    override fun supportsResolution(sdkTypeId: SdkTypeId): Boolean {
        return false
    }

    override fun createResolver(project: Project?, indicator: ProgressIndicator): UnknownSdkLookup {
        return ValkyrieUnknownSdkLookup()
    }
}


