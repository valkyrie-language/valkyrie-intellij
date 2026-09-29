package awsl.surface.file

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class AwslLanguage private constructor() : Language("AWSL") {
    companion object {
        @JvmStatic
        val INSTANCE = awsl.surface.file.AwslLanguage()

        @NonNls
        const val BUNDLE = "messages.AwslBundle"
    }
}


