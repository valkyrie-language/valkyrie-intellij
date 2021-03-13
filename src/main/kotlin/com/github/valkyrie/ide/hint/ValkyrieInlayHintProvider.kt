package com.github.valkyrie.ide.hint

import com.github.valkyrie.ValkyrieBundle
import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

@Suppress("UnstableApiUsage")
class ValkyrieInlayHintProvider : InlayHintsProvider<ValkyrieInlayHintProvider.Settings> {
    companion object {
        private val KEY: SettingsKey<Settings> = SettingsKey("v.type.hints")
    }

    data class Settings(
        var showForVariables: Boolean = true,
        var showForLambdas: Boolean = true,
        var showForIterators: Boolean = true,
        var showForPlaceholders: Boolean = true,
        var showObviousTypes: Boolean = false,
    )
    override val key: SettingsKey<Settings> get() = KEY
    override val name: String = ValkyrieBundle.message("settings.rust.inlay.hints.title.types")
    override val group: InlayGroup = InlayGroup.TYPES_GROUP
    override fun createSettings(): Settings = Settings()
    override val previewText: String = """
            struct Foo<T1, T2, T3> { x: T1, y: T2, z: T3 }
            fn main() {
                let foo = Foo { x: 1, y: "abc", z: true };
            }
            """.trimIndent()

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: Settings, sink: InlayHintsSink): InlayHintsCollector? {
        TODO("Not yet implemented")
    }

    override fun createConfigurable(settings: Settings): ImmediateConfigurable {
        TODO("Not yet implemented")
    }



}
