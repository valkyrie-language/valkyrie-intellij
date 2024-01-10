package valkyrie.language

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * Valkyrie 图标定义
 */
object ValkyrieIcons {
    @JvmStatic
    val FILE: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val VARIABLE: Icon = IconLoader.getIcon("/icons/variable.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val FUNCTION: Icon = IconLoader.getIcon("/icons/fieldValue.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val WORKSPACE: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val PROJECT: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val PACKAGES: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)
}