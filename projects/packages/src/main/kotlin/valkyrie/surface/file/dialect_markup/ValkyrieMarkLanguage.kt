package valkyrie.surface.file.dialect_markup

import com.intellij.lang.Language

class ValkyrieMarkLanguage private constructor() : Language("ValkyrieMark") {
    companion object {
        val INSTANCE = ValkyrieMarkLanguage()
    }
}
