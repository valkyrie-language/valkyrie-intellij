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
    val MICRO: Icon = IconLoader.getIcon("/icons/valkyrie-function.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val WORKSPACE: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val PROJECT: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val PACKAGES: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)

    // Structure View 图标
    @JvmStatic
    val CLASS: Icon = IconLoader.getIcon("/icons/c.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val UNION: Icon = IconLoader.getIcon("/icons/codeAssistantUnion.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val TRAIT: Icon = IconLoader.getIcon("/icons/trait.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val DOMAIN: Icon = IconLoader.getIcon("/icons/module.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val NAMESPACE: Icon = IconLoader.getIcon("/icons/codeAssistantNamespace.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val FIELD: Icon = IconLoader.getIcon("/icons/codeAssistantField.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val METHOD: Icon = IconLoader.getIcon("/icons/valkyrie-function.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val VARIANT: Icon = IconLoader.getIcon("/icons/codeAssistantEnum.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val LET_STATEMENT: Icon = IconLoader.getIcon("/icons/valkyrie-variable.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val MACRO: Icon = IconLoader.getIcon("/icons/codeAssistantMacro.svg", ValkyrieIcons::class.java)

    // 控制流图标
    @JvmStatic
    val LOOP: Icon = IconLoader.getIcon("/icons/loop.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val RETURN: Icon = IconLoader.getIcon("/icons/return.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val BREAK: Icon = IconLoader.getIcon("/icons/break.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val CONTINUE: Icon = IconLoader.getIcon("/icons/continue.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val YIELD: Icon = IconLoader.getIcon("/icons/yield.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val RAISE: Icon = IconLoader.getIcon("/icons/raise.svg", ValkyrieIcons::class.java)

    @JvmStatic
    val CATCH: Icon = IconLoader.getIcon("/icons/catch.svg", ValkyrieIcons::class.java)
}