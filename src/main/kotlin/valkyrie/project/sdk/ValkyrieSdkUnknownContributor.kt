package valkyrie.project.sdk

import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.impl.UnknownSdkContributor
import com.intellij.openapi.roots.ui.configuration.UnknownSdk

class ValkyrieSdkUnknownContributor : UnknownSdkContributor {
    override fun contributeUnknownSdks(project: Project): List<UnknownSdk> {
        return listOf()
    }

    override fun contributeKnownSdks(project: Project): List<Sdk> {
        return listOf()
    }
}
