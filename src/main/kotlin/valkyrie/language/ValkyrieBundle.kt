package valkyrie.language

import com.intellij.DynamicBundle
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.PropertyKey

/**
 * Valkyrie 多语言资源包
 */
class ValkyrieBundle : DynamicBundle(BUNDLE) {
    companion object {
        private const val BUNDLE = "messages.ValkyrieBundle"
        private val INSTANCE = ValkyrieBundle()

        @JvmStatic
        fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): @Nls String {
            return INSTANCE.getMessage(key, *params)
        }

        @JvmStatic
        fun messagePointer(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            INSTANCE.getLazyMessage(key, *params)
    }
}