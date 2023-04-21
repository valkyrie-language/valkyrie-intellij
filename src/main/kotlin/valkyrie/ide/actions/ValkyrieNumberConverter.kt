package valkyrie.ide.actions

import com.intellij.codeInsight.intention.numeric.NumberConverter

class ValkyrieNumberConverter : NumberConverter {
    override fun getConvertedText(text: String, number: Number): String? {
        return "$number$text"
    }
}