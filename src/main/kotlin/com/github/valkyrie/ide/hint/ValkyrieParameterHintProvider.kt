package com.github.valkyrie.ide.hint

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.language.psi.startOffset
import com.github.valkyrie.language.psi_node.ValkyrieCallSuffixNode
import com.intellij.codeInsight.hints.HintInfo
import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.codeInsight.hints.InlayParameterHintsProvider
import com.intellij.codeInsight.hints.Option
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ValkyrieParameterHintProvider : InlayParameterHintsProvider {
    var context = ""
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

    override fun getHintInfo(element: PsiElement): HintInfo? {
        return HintInfo.MethodInfo("aaa", listOf("bbb"))
    }

    /// 函数里面的东西
    override fun getParameterHints(element: PsiElement): MutableList<InlayInfo> {
        return when (element) {
            is ValkyrieCallSuffixNode -> element.resolveParameterName()
            else -> mutableListOf()
        }
    }

    /// 强制复写 getParameterHints
    override fun getInlayPresentation(inlayText: String): String {
        return super.getInlayPresentation(inlayText)
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

    private fun ValkyrieCallSuffixNode.resolveParameterName(): MutableList<InlayInfo> {
        // TODO: Check if in call
        val out = mutableListOf<InlayInfo>();
        var id = 0;
        for (i in this.expressionList) {
            out.add(InlayInfo("$id", i.startOffset))
            id += 1
        }
        return out
    }

}
