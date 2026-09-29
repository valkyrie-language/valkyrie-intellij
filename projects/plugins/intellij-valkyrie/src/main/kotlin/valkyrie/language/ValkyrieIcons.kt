package valkyrie.language

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class ValkyrieIcons {
    companion object {
        val VK_FILE: Icon = IconLoader.getIcon("/icons/vk.svg", ValkyrieIcons::class.java)
        val LOOP: Icon = IconLoader.getIcon("/icons/loop.svg", ValkyrieIcons::class.java)
        val RETURN: Icon = IconLoader.getIcon("/icons/return.svg", ValkyrieIcons::class.java)
        val BREAK: Icon = IconLoader.getIcon("/icons/break.svg", ValkyrieIcons::class.java)
        val CONTINUE: Icon = IconLoader.getIcon("/icons/continue.svg", ValkyrieIcons::class.java)
        val YIELD: Icon = IconLoader.getIcon("/icons/yield.svg", ValkyrieIcons::class.java)
        val RAISE: Icon = IconLoader.getIcon("/icons/raise.svg", ValkyrieIcons::class.java)
        val CATCH: Icon = IconLoader.getIcon("/icons/catch.svg", ValkyrieIcons::class.java)
        val TEST: Icon = IconLoader.getIcon("/icons/test.svg", ValkyrieIcons::class.java)
        val TEST_RUN: Icon = IconLoader.getIcon("/icons/testRun.svg", ValkyrieIcons::class.java)
        val FILE: Icon = IconLoader.getIcon("/icons/valkyrie-file.svg", ValkyrieIcons::class.java)
        val PROJECT: Icon = IconLoader.getIcon("/icons/module.svg", ValkyrieIcons::class.java)
        val PACKAGES: Icon = IconLoader.getIcon("/icons/actionQualifiedNames.svg", ValkyrieIcons::class.java)
        val WORKSPACE: Icon = IconLoader.getIcon("/icons/multipleTypeDefinitions.svg", ValkyrieIcons::class.java)
        val CLASS: Icon = IconLoader.getIcon("/icons/c.svg", ValkyrieIcons::class.java)
        val DOMAIN: Icon = IconLoader.getIcon("/icons/codeAssistantMacro.svg", ValkyrieIcons::class.java)
        val FIELD: Icon = IconLoader.getIcon("/icons/fieldVariable.svg", ValkyrieIcons::class.java)
        val VARIABLE: Icon = IconLoader.getIcon("/icons/variable.svg", ValkyrieIcons::class.java)
        val METHOD: Icon = IconLoader.getIcon("/icons/valkyrie-function.svg", ValkyrieIcons::class.java)
        val NAMESPACE: Icon = IconLoader.getIcon("/icons/codeAssistantNamespace.svg", ValkyrieIcons::class.java)
        val TRAIT: Icon = IconLoader.getIcon("/icons/trait.svg", ValkyrieIcons::class.java)
        val UNION: Icon = IconLoader.getIcon("/icons/codeAssistantUnion.svg", ValkyrieIcons::class.java)
        val VARIANT: Icon = IconLoader.getIcon("/icons/codeAssistantEnum.svg", ValkyrieIcons::class.java)
    }
}