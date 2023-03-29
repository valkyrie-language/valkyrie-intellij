package valkyrie.ide.highlight

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider

class HighlightSetting : ColorSettingsPage {
    private val annotatorTags = HighlightColor.entries
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = HighlightColor.entries
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = ValkyrieBundle.message("filetype.name")

    override fun getIcon() = ValkyrieIconProvider.Instance.File

    override fun getHighlighter() = TokenHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText(): String {
        val file = javaClass.getResource("/templates/code-highlight.ne");
        return file?.readText() ?: ""
    }
}

