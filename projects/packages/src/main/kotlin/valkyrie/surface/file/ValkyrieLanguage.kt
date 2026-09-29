package valkyrie.surface.file

import com.intellij.lang.Language

class ValkyrieLanguage private constructor() : Language("valkyrie") {
    companion object {
        val INSTANCE = ValkyrieLanguage()
    }
}