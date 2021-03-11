package com.github.valkyrie.ide.hint

import com.github.valkyrie.ValkyrieBundle
import com.intellij.codeInsight.hints.HintInfo
import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.codeInsight.hints.InlayParameterHintsProvider
import com.intellij.codeInsight.hints.Option
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

@Suppress("UnstableApiUsage")
class ValkyrieInlayHintProvider : InlayParameterHintsProvider {
    override fun getHintInfo(element: PsiElement): HintInfo? {
        return HintInfo.MethodInfo("aaa", listOf("bbb"))
    }

    override fun getParameterHints(element: PsiElement): MutableList<InlayInfo> {
        return mutableListOf(InlayInfo("tt", 10))
    }

    override fun getDefaultBlackList(): Set<String> =
        setOf(
            "*listOf", "*setOf", "*arrayOf",
            /* Gradle DSL especially annoying hints */
            "org.gradle.api.Project.hasProperty(propertyName)",
            "org.gradle.api.Project.findProperty(propertyName)",
            "org.gradle.api.Project.file(path)",
            "org.gradle.api.Project.uri(path)",
            "jvmArgs(arguments)",
            "org.gradle.kotlin.dsl.DependencyHandlerScope.*(notation)",
            "org.gradle.kotlin.dsl.*(dependencyNotation)",
            "org.gradle.kotlin.dsl.kotlin(module)",
            "org.gradle.kotlin.dsl.kotlin(module,version)",
            "org.gradle.kotlin.dsl.project(path,configuration)"
        )

    override fun getInlayPresentation(inlayText: String): String {
        return "getInlayPresentation"
    }

    override fun getMainCheckboxText(): String {
        return "getMainCheckboxText"
    }

    override fun getDescription(): String {
        return "getDescription"
    }

    override fun getSupportedOptions(): MutableList<Option> {
        return mutableListOf(
            Option("getSupportedOptions", ValkyrieBundle.messagePointer("color.token.null"), true)
        )
    }
}
