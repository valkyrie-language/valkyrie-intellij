package valkyrie.project.sdk

import com.intellij.openapi.SdkEditorAdditionalOptionsProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.AdditionalDataConfigurable
import com.intellij.openapi.projectRoots.Sdk

class ValkyrieSdkAdditionalOptions : SdkEditorAdditionalOptionsProvider {
    constructor() : super(ValkyrieSdkType())

    override fun createOptions(project: Project, sdk: Sdk): AdditionalDataConfigurable? {
        // use ValkyrieSdkType.createAdditionalDataConfigurable
        return null
    }
}
