package com.github.valkyrie.language.psi

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

class ValkyriePresentationItem(val name: String?, val icon: Icon?) : ItemPresentation {
    override fun getPresentableText(): String = this.name ?: "UNKNOWN"
    override fun getIcon(unused: Boolean): Icon = this.icon ?: AllIcons.Nodes.Unknown
}