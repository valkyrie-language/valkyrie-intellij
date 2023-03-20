package valkyrie.ide.project.sdk

import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.impl.SdkFinder
import valkyrie.ide.project.`package`.sdk.ValkyrieSdkType

class ValkyrieSdkFinder : SdkFinder() {
    override fun findSdk(name: String, sdkType: String): Sdk? {
        if (sdkType != ValkyrieSdkType.ID) {
            return null
        }
        // not path, just name
        println("findSdk($name, $sdkType)")
        return null
    }
}
