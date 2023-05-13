package valkyrie.ide.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TemplateSettings
import javax.swing.Icon

open class ValkyrieLookupElement : LookupElement() {
    private lateinit var lookup: String
    private val lookups: MutableSet<String> = mutableSetOf()
    private var itemIcon: Icon? = null
    private var itemText: String = ""
    private var typeIcon: Icon? = null
    private var typeText: String = ""


    override fun getLookupString(): String {
        return lookup
    }

    override fun getAllLookupStrings(): MutableSet<String> {
        return lookups
    }

    fun setLookup(dominant: String, set: MutableSet<String> = mutableSetOf()) {
        this.lookup = dominant
        this.lookups.clear()
        this.lookups.add(dominant)
        this.lookups.addAll(set)
    }

    fun setIcon(itemIcon: Icon, typeIcon: Icon? = null) {
        this.itemIcon = itemIcon;
        this.typeIcon = typeIcon;
    }

    fun setText(itemText: String, typeText: String = "") {
        this.itemText = itemText
        this.typeText = typeText
    }

    override fun renderElement(presentation: LookupElementPresentation) {
        presentation.icon = itemIcon
        presentation.setTypeText(typeText, typeIcon)
        presentation.isTypeGrayed = true
        presentation.isTypeIconRightAligned = true;
        presentation.itemText = itemText
    }

    companion object {
        fun getTemplate(key: String): TemplateImpl? {
            return TemplateSettings.getInstance().getTemplate(key, "Valkyrie Trigger")
        }
    }
}