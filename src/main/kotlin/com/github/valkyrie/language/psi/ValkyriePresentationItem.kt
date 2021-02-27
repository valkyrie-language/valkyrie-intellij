package com.github.valkyrie.language.psi

import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

class ValkyriePresentationItem(val name: String, val icon: Icon) : ItemPresentation {
    override fun getPresentableText(): String = this.name
    override fun getIcon(unused: Boolean): Icon = this.icon
}