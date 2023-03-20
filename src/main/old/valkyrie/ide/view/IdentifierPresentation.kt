package valkyrie.ide.view

import com.intellij.navigation.ColoredItemPresentation
import com.intellij.openapi.editor.colors.TextAttributesKey
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieIdentifierNode
import javax.swing.Icon

class IdentifierPresentation(val name: ValkyrieIdentifierNode?, private val icon: Icon) : ColoredItemPresentation {
    override fun getPresentableText(): String {
        return name?.name ?: "[Missing]"
    }

    override fun getIcon(unused: Boolean): Icon {
        return icon
    }

    override fun getTextAttributesKey(): TextAttributesKey {
        return ValkyrieHighlightColor.IDENTIFIER.textAttributesKey
    }

}