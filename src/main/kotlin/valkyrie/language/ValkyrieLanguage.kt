package valkyrie.language

import com.intellij.lang.Language

class ValkyrieLanguage private constructor() : Language("Valkyrie") {
    companion object {
        val INSTANCE = ValkyrieLanguage()
    }
}