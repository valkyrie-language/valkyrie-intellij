package voml.ide.annotator

import voml.language.psi.VomlNode
import voml.language.psi.VomlTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement

class VomlScopeChecker : CheckerBase() {
    override fun check(element: PsiElement, holder: AnnotationHolder): CheckerAnnotatorResult =
        if (holder.isBatchMode) {
            CheckerAnnotatorResult.Ok
        } else {
            when (element) {
                is VomlNode if element.node.elementType == VomlTypes.SCOPE -> checkScope(element)
                else -> CheckerAnnotatorResult.Ok
            }
        }

    private fun checkScope(objectEntry: PsiElement): CheckerAnnotatorResult {
//        val filteredEntries = (objectEntry.parent as VomlObjectBody)
//            .objectEntryList
//            .asSequence()
//            .filterNot { it == objectEntry }
//
//        val duplicatesFound = filteredEntries.any { it.keyTextMatches(objectEntry.keyText) }
//
//        return if (duplicatesFound) {
//            CheckerAnnotatorResult.Error(
//                "Duplicate keys found in an object",
//                objectEntry.namedField.ident.textRange
//            )
//        } else {
//            CheckerAnnotatorResult.Ok
//        }
        return CheckerAnnotatorResult.Ok
    }
}

