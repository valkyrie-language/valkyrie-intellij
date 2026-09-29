package valkyrie.language

import com.intellij.lang.Language

class ValkyrieLanguage private constructor() : Language("valkyrie") {
    companion object {
        val INSTANCE = ValkyrieLanguage()
    }
}