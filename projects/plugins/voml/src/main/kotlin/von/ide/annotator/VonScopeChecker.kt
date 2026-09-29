package von.ide.annotator

import von.language.psi.VonNode
import von.language.psi.VonTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement

class VonScopeChecker : CheckerBase() {
    override fun check(element: PsiElement, holder: AnnotationHolder): CheckerAnnotatorResult =
        if (holder.isBatchMode) {
            CheckerAnnotatorResult.Ok
        } else {
            when (element) {
                is VonNode if element.node.elementType == VonTypes.SCOPE -> checkScope(element)
                else -> CheckerAnnotatorResult.Ok
            }
        }

    private fun checkScope(objectEntry: PsiElement): CheckerAnnotatorResult {
//        val filteredEntries = (objectEntry.parent as VonObjectBody)
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

