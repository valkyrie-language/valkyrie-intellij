package com.github.valkyrie.ide.highlight

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ide.file.ValkyrieIconProvider

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class ValkyrieHighlightSetting : ColorSettingsPage {
    private val annotatorTags = ValkyrieHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = ValkyrieHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = ValkyrieBundle.message("filetype.name")

    override fun getIcon() = ValkyrieIconProvider.IconSVG

    override fun getHighlighter() = ValkyrieSyntaxHighlighter()

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
