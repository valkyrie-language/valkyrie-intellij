package com.github.valkyrie.ide.highlight

import com.github.valkyrie.VkBundle
import com.github.valkyrie.ide.view.VkIconProvider

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class VkHighlightSetting : ColorSettingsPage {
    private val annotatorTags = VkHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = VkHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = VkBundle.message("filetype.name")

    override fun getIcon() = VkIconProvider.FluentFile

    override fun getHighlighter() = VkSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() =
        """# References
hello   = Hello, world!
welcome = Welcome, { ${"$"}user }!
time-elapsed = Time elapsed: { NUMBER(${"$"}duration, maximumFractionDigits: 0) }s.
-brand-name = Firefox
installing = Installing { -brand-name }.

# Selectors
your-score = You scored {
    NUMBER(${"$"}score, minimumFractionDigits: 1) ->
        [0.0]   zero points. What happened?
       *[other] { NUMBER(${"$"}score, minimumFractionDigits: 1)} points.
    }

# Attributes
login-input = Predefined value
    .placeholder = email@example.com
    .aria-label = Login input value
    .title = Type your login email
"""


}
