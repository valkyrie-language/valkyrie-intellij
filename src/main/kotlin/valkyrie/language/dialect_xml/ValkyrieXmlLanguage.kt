package valkyrie.language.dialect_xml

import com.intellij.lang.Language

class ValkyrieXmlLanguage private constructor() : Language("valkyrie-xml") {
    companion object {
        val INSTANCE = ValkyrieXmlLanguage()
    }
}
