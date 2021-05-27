package com.github.valkyrie.ide.completion

import com.github.valkyrie.ValkyrieLanguage
import com.intellij.codeInsight.AutoPopupControllerImpl
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.XmlCharFilter
import com.intellij.codeInsight.editorActions.XmlAutoPopupHandler
import com.intellij.codeInsight.lookup.CharFilter
import com.intellij.codeInsight.lookup.Lookup
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Condition
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class CompletionTrigger(project: Project) : AutoPopupControllerImpl(project) {
    override fun autoPopupMemberLookup(editor: Editor?, condition: Condition<in PsiFile>?) {
        super.autoPopupMemberLookup(editor, condition)
    }

    override fun autoPopupParameterInfo(editor: Editor, highlightedMethod: PsiElement?) {
        super.autoPopupParameterInfo(editor, highlightedMethod)
    }

    override fun autoPopupMemberLookup(editor: Editor?, completionType: CompletionType?, condition: Condition<in PsiFile>?) {
        super.autoPopupMemberLookup(editor, completionType, condition)
    }
}

class CompletionInterrupter : CharFilter() {
//    override fun acceptChar(c: Char, prefixLength: Int, lookup: Lookup?): Result? {

//        println("$c $prefixLength")
//        return Result.SELECT_ITEM_AND_FINISH_LOOKUP
//    }

    override fun acceptChar(c: Char, prefixLength: Int, lookup: Lookup?): Result? {
        val element = lookup?.psiElement ?: return null
        if (element.language != ValkyrieLanguage) {
            return null
        }
        return if (Character.isJavaIdentifierPart(c)) Result.ADD_TO_PREFIX
        else when (c) {
            '-', ':', '?' -> Result.ADD_TO_PREFIX
            '/' -> {
                if (XmlCharFilter.isWithinTag(lookup)) {
                    if (prefixLength > 0) {
                        return Result.SELECT_ITEM_AND_FINISH_LOOKUP
                    }
                    XmlAutoPopupHandler.autoPopupXmlLookup(lookup.project, lookup.editor)
                    return Result.HIDE_LOOKUP
                }
                Result.ADD_TO_PREFIX
            }

            '>' -> {
                if (prefixLength > 0) {
                    Result.SELECT_ITEM_AND_FINISH_LOOKUP
                }
                else Result.SELECT_ITEM_AND_FINISH_LOOKUP
            }

            '\'', '\"' -> Result.SELECT_ITEM_AND_FINISH_LOOKUP
            else -> null
        }
    }
}