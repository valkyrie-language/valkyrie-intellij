package valkyrie.ide.highlight

import ai.grazie.utils.isUppercase
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.*
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.ValkyrieVisitor

class NodeHighlighter2 : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitFlagsField(o: ValkyrieFlagsItemNode) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_FIELD)
    }

    override fun visitUnionDeclaration(o: ValkyrieUnionStatement) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_CLASS)
    }

    override fun visitVariantDeclaration(o: ValkyrieVariantItem) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_VARIANT)
    }

    override fun visitTraitDeclaration(o: ValkyrieTraitStatement) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_TRAIT)
    }

    override fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_FUNCTION_FREE)
        for (mod in o.modifiers) {
            highlight(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }

    override fun visitCallArgument(o: ValkyrieCallArgument) {
        highlight(o.key, ValkyrieHighlightColor.SYM_ARG)
    }

    override fun visitVariableDeclaration(o: ValkyrieLetStatement) {
        super.visitVariableDeclaration(o)
    }

    override fun visitFunctionItem(o: ValkyrieFunctionParameter) {
        highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_ARG)
        for (mod in o.modifiers) {
            highlight(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }

    override fun visitForParameter(o: ValkyrieLetParameter) {
        if (o.mutable) {
            highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_LOCAL_MUT)
        } else {
            highlight(o.nameIdentifier, ValkyrieHighlightColor.SYM_LOCAL)
        }
        for (mod in o.modifiers) {
            highlight(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }

    override fun visitNewObject(o: ValkyrieNewStatement) {
        highlight(o.identifier, ValkyrieHighlightColor.SYM_CLASS)
        for (mod in o.modifiers) {
            highlight(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }

    override fun visitNamepath(o: ValkyrieNamepathNode) {
        fakeTypeColor(o.nameIdentifier)
    }

    override fun visitString(o: ValkyrieStringNode) {
        highlight(o.handler, ValkyrieHighlightColor.SYM_MACRO)
    }

    override fun visitIdentifier(o: ValkyrieIdentifierNode) {
//        fakeTypeColor(o)
    }
// =================================================================================================================

    fun highlight(element: PsiElement?, color: ValkyrieHighlightColor) {
        if (element == null) return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element.textRange)

        infoHolder?.add(builder.create())
    }


    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = NodeHighlighter2()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}

private fun NodeHighlighter2.fakeTypeColor(psi: ValkyrieIdentifierNode) {
    val name = psi.name
    if (keywords.contains(name)) {
        highlight(psi, ValkyrieHighlightColor.KEYWORD)
    } else if (traits.contains(name)) {
        highlight(psi, ValkyrieHighlightColor.SYM_TRAIT)
    } else if (variants.contains(name)) {
        highlight(psi, ValkyrieHighlightColor.SYM_VARIANT)
    } else if (name.isUppercase()) {
        highlight(psi, ValkyrieHighlightColor.SYM_GENERIC)
    } else {
        val first = name.firstOrNull();
        if (first != null && first.isUpperCase()) {
            highlight(psi, ValkyrieHighlightColor.SYM_CLASS)
        }
    }
}

private val keywords = setOf(
    "u8", "u16", "u32", "u64", "int",
    "i8", "i16", "i32", "i64",
    "f32", "f64",
    "bool", "char", "string",
    "unit",
    "pass", "scope", "async", "await", "quote",
    "self", "Self"
)

private val traits = setOf("Iterator", "Iterable", "Sequence", "Debug", "Display")

private val variants = setOf("Some", "None", "Success", "Failure", "Left", "Riht")

