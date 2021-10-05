package valkyrie.ide.highlight

import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class HighlightSetting : ColorSettingsPage {
    private val annotatorTags = ValkyrieHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = ValkyrieHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = ValkyrieBundle.message("filetype.name")

    override fun getIcon() = ValkyrieIconProvider.FILE

    override fun getHighlighter() = TokenHighlight()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() = javaClass.getResource("/templates/code-highlight.vk")!!.readText()
}
