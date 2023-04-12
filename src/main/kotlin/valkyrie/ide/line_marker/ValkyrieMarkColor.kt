package valkyrie.ide.line_marker

import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes
import java.awt.Color

class ValkyrieMarkColor : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? {
        if (element.elementType != ValkyrieTypes.COLOR) {
            return null
        }
        val head = element.text.first()
        val rest = element.text.substring(1)
        return when (head) {
            '®' -> rgb(rest)
            '©' -> cmyk(rest)
            else -> null
        }
    }

    private fun rgb(text: String): Color? {
        return RGBA.parse(text)
    }

    private fun cmyk(text: String): Color? {
        return CMYK.parse(text)?.let { return it.toRGBA() }
    }

    override fun setColorTo(element: PsiElement, color: Color) {
        TODO("Not yet implemented")
    }
}

