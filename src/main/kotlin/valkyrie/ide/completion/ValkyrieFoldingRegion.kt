package valkyrie.ide.completion

import com.intellij.lang.folding.CustomFoldingProvider

class ValkyrieFoldingRegion : CustomFoldingProvider() {
    override fun isCustomRegionStart(elementText: String?): Boolean {
        return elementText?.startsWith("⍝+") ?: false
    }

    override fun isCustomRegionEnd(elementText: String?): Boolean {
        return elementText?.startsWith("⍝-") ?: false
    }

    override fun getPlaceholderText(elementText: String?): String {
        return "Region: ${elementText?.trim('⍝')?.trim('+')}"
    }

    override fun getDescription(): String {
        return "GetDescription"
    }

    override fun getStartString(): String {
        return "GetStartString"
    }

    override fun getEndString(): String {
        return "GetEndString"
    }
}

