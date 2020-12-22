package com.github.valkyrie

import com.intellij.lang.Language

class VkLanguage private constructor() : Language(LanguageID) {
    companion object {
        @JvmStatic
        val INSTANCE = VkLanguage()

        const val Bundle = "messages.ValkyrieBundle"

        const val LanguageID = "Valkyrie"
        const val Extensions = "vk;"
    }
}


