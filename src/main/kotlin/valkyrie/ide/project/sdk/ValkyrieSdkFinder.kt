package valkyrie.ide.project.sdk

import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.impl.SdkFinder

class ValkyrieSdkFinder : SdkFinder() {
    override fun findSdk(name: String, sdkType: String): Sdk? {
        println("findSdk($name, $sdkType)")
        return null
    }
}