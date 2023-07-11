package valkyrie.project.sdk

import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.impl.SdkFinder


class ValkyrieSdkFinder : SdkFinder() {
    override fun findSdk(name: String, sdkType: String): Sdk? {
//        println("ValkyrieSdkFinder: $sdkType($name)")
        val jdkTable = ProjectJdkTable.getInstance()
        return jdkTable.findJdk(name)
    }
}
