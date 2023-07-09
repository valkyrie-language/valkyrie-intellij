package valkyrie.project.sdk

import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.impl.UnknownSdkContributor
import com.intellij.openapi.roots.ui.configuration.UnknownSdk

class ValkyrieUnknownSdkContributor : UnknownSdkContributor {
    override fun contributeUnknownSdks(project: Project): List<UnknownSdk> {
        return listOf()
    }
}
