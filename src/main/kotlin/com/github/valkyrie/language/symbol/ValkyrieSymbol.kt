package com.github.valkyrie.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.presentation.PresentableSymbol
import com.intellij.navigation.NavigatableSymbol
import com.intellij.navigation.NavigationTarget

@Suppress("UnstableApiUsage")
abstract class ValkyrieSymbol : Pointer<ValkyrieSymbol>,
    PresentableSymbol,
    NavigatableSymbol,
    NavigationTarget {
    override fun createPointer(): Pointer<out ValkyrieSymbol> = this;
    override fun dereference(): ValkyrieSymbol = this

    open var fullName: List<String> = listOf("anonymous", "UNKNOWN");
    open fun getNamespace(): List<String> = fullName.subList(0, fullName.count() - 1)
    open fun getName(): String = fullName.last()

    open fun isModule(): Boolean = false
    open fun isStructure(): Boolean = false
    open fun isInterface(): Boolean = false
}

