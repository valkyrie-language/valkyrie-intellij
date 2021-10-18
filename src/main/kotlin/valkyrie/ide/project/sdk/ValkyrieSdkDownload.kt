package valkyrie.ide.project.sdk

import com.intellij.icons.AllIcons
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.SdkModel
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.projectRoot.SdkDownload
import com.intellij.openapi.roots.ui.configuration.projectRoot.SdkDownloadTask
import java.util.function.Consumer
import javax.swing.Icon
import javax.swing.JComponent

class ValkyrieSdkDownload : SdkDownload {
    override fun getIconForDownloadAction(sdkTypeId: SdkTypeId): Icon {
        return AllIcons.Actions.Download
    }

    override fun supportsDownload(sdkTypeId: SdkTypeId): Boolean {
        if (sdkTypeId.name != ValkyrieSdkType.ID) {
            return false
        }
        return true
    }

    override fun showDownloadUI(
        sdkTypeId: SdkTypeId,
        sdkModel: SdkModel,
        parentComponent: JComponent,
        selectedSdk: Sdk?,
        sdkCreatedCallback: Consumer<in SdkDownloadTask?>,
    ) {

    }
}