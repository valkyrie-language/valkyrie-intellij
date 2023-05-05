package valkyrie.ide.hint

import com.intellij.lang.ExpressionTypeProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.ValkyrieNamepath
import valkyrie.psi.node.ValkyrieVisitor

/** Ctrl + Shift + P */
class TypeInfoHint : ExpressionTypeProvider<PsiElement>() {
    override fun getExpressionsAt(elementAt: PsiElement): MutableList<PsiElement> {
        when (elementAt.elementType) {
            ValkyrieTypes.SYMBOL -> {
                return mutableListOf(elementAt)
            }

            ValkyrieTypes.SYMBOW_RAW -> {
                return mutableListOf(elementAt)
            }

            else -> {
                println("getExpressionsAt: $elementAt")
                return mutableListOf()
            }
        }
    }

    override fun hasAdvancedInformation(): Boolean {
        return true
    }

    override fun getErrorHint(): String {
        return "GetErrorHint"
    }

    override fun getInformationHint(element: PsiElement): String {
//        val visitor = TypeInfoHintVisitor()
//        element.accept(visitor)
//        return visitor.type
        return "TypeInfoHint.getInformationHint"
    }

    override fun getAdvancedInformationHint(element: PsiElement): String {
        return "TypeInfoHint.getAdvancedInformationHint"
    }
}

private class TypeInfoHintVisitor : ValkyrieVisitor() {
    var type: String = "TypeInfoHint.getInformationHint"


    override fun visitNamepath(o: ValkyrieNamepath) {
        type = "visitNamepath: ${o.text}"
    }
}