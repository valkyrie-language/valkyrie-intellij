package valkyrie.ide.view

import com.intellij.navigation.ColoredItemPresentation
import com.intellij.openapi.editor.colors.TextAttributesKey
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieNamepathNode
import javax.swing.Icon

class NamepathPresentation(val name: ValkyrieNamepathNode, private val icon: Icon) : ColoredItemPresentation {
    override fun getPresentableText(): String {
        return name.name
    }

    override fun getLocationString(): String {
        return name.namespace
    }

    override fun getIcon(unused: Boolean): Icon {
        return icon
    }

    override fun getTextAttributesKey(): TextAttributesKey {
        return ValkyrieHighlightColor.IDENTIFIER.textAttributesKey
    }
}