package valkyrie.ide.highlight

import java.awt.Color

data class CMYK(val c: Float, val m: Float, val y: Float, val k: Float) {
    companion object {
        fun parse(text: String): CMYK? {
            if (text.contains(Regex("[^0-9A-Fa-f]"))) return null;
            when (text.length) {
                //
                0 -> {
                    return CMYK(0f, 0f, 0f, 0f)
                }
                // #1
                1 -> {
                    val gray = Integer.parseInt(text) * 0x11 / 255.0f
                    return CMYK(gray, gray, gray, gray)
                }

                2 -> {
                    val gray = Integer.parseInt(text) / 255.0f
                    return CMYK(gray, gray, gray, gray)
                }

                4 -> {
                    val c = Integer.parseInt(text.substring(0, 1)) * 0x11 / 255.0f
                    val m = Integer.parseInt(text.substring(1, 2)) * 0x11 / 255.0f
                    val y = Integer.parseInt(text.substring(2, 3)) * 0x11 / 255.0f
                    val k = Integer.parseInt(text.substring(3, 4)) * 0x11 / 255.0f
                    return CMYK(c, m, y, k)
                }

                8 -> {
                    val c = Integer.parseInt(text.substring(0, 2), 16) / 255.0f
                    val m = Integer.parseInt(text.substring(2, 4), 16) / 255.0f
                    val y = Integer.parseInt(text.substring(4, 6), 16) / 255.0f
                    val k = Integer.parseInt(text.substring(6, 8), 16) / 255.0f
                    return CMYK(c, m, y, k)
                }

                else -> {
                    return null
                }
            }
        }
    }


    fun toRGBA(): Color {
        val r = 255.0 * (1 - c) * (1 - k)
        val g = 255.0 * (1 - m) * (1 - k)
        val b = 255.0 * (1 - y) * (1 - k)
        val a = 255.0 * (1 - k)
        return Color(r.toInt(), g.toInt(), b.toInt(), a.toInt())
    }
}