package valkyrie.ide.project.`package`.sdk

import com.intellij.openapi.projectRoots.Sdk
import java.io.File

class ValkyrieSdk {
    private val home: File;

    constructor(sdk: Sdk) {
        this.home = sdk.homePath?.let { File(it) } ?: File("")
    }

    val version: String
        get() {
            return "0.0.0";
        }

    constructor(path: String) {
        this.home = File(path)
    }

    fun isValid(): Boolean {
        if (!home.isDirectory) {
            return false
        }
        return true
    }
}