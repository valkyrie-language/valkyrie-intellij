package com.github.valkyrie

import com.intellij.lang.Language

class ValkyrieLanguage private constructor() : Language(LanguageID) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieLanguage()

        const val Bundle = "messages.ValkyrieBundle"

        const val LanguageID = "Valkyrie"
        const val Extensions = "vk;"
    }
}


