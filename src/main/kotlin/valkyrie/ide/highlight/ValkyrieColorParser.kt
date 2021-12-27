package valkyrie.ide.highlight

import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.ui.JBColor
import java.awt.Color

class ValkyrieColorParser : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? {
        return null;
//        val rest = element.text.substring(1);
//        return when {
//            element.text.startsWith('®') -> rgb(rest)
//            element.text.startsWith('©') -> cmyk(rest)
//            else -> null
//        }
    }

    private fun rgb(text: String): Color? {
        if (text.contains(Regex("[^0-9A-Fa-f]"))) return null;
        when (text.length) {
            0 -> {
                return JBColor.BLACK
            }

            1 -> {
                val gray = Integer.parseInt(text, 16) * 0x11
                return Color(gray, gray, gray)
            }

            2 -> {
                val gray = Integer.parseInt(text, 16)
                return Color(gray, gray, gray)
            }

            3 -> {
                val r = Integer.parseInt(text.substring(0, 1), 16) * 0x11
                val g = Integer.parseInt(text.substring(1, 2), 16) * 0x11
                val b = Integer.parseInt(text.substring(2, 3), 16) * 0x11
                return Color(r, g, b)
            }

            4 -> {
                val r = Integer.parseInt(text.substring(0, 1), 16) * 0x11
                val g = Integer.parseInt(text.substring(1, 2), 16) * 0x11
                val b = Integer.parseInt(text.substring(2, 3), 16) * 0x11
                val a = Integer.parseInt(text.substring(3, 4), 16) * 0x11
                return Color(r, g, b, a)
            }

            6 -> {
                val r = Integer.parseInt(text.substring(0, 2), 16)
                val g = Integer.parseInt(text.substring(2, 4), 16)
                val b = Integer.parseInt(text.substring(4, 6), 16)
                return Color(r, g, b)
            }

            8 -> {
                val r = Integer.parseInt(text.substring(0, 2), 16)
                val g = Integer.parseInt(text.substring(2, 4), 16)
                val b = Integer.parseInt(text.substring(4, 6), 16)
                val a = Integer.parseInt(text.substring(6, 8), 16)
                return Color(r, g, b, a)
            }

            else -> {
                return null
            }
        }
    }

    private fun cmyk(text: String): Color? {
        return CMYK.parse(text)?.let { return it.toRGBA() }
    }

    override fun setColorTo(element: PsiElement, color: Color) {
        TODO("Not yet implemented")
    }
}

