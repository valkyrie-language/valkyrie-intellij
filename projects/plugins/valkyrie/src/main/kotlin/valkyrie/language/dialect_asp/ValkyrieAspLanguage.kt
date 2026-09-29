package valkyrie.language.dialect_asp

import com.intellij.lang.Language

class ValkyrieAspLanguage private constructor() : Language("valkyrie-template") {
    companion object {
        val INSTANCE = ValkyrieAspLanguage()
    }
}
