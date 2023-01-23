package valkyrie.ide.highlight


//import valkyrie.language.psi_node.ValkyrieIdentifierNode
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
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitClassDeclaration(o: ValkyrieClassStatement) {
        highlight(o.nameIdentifier, Color.SYM_CLASS)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
        for (inherit in o.inherits) {
            for (mod in inherit.modifiers) {
                highlight(mod, Color.MODIFIER)
            }
        }
    }

    override fun visitClassField(o: ValkyrieClassFieldNode) {
        highlight(o.nameIdentifier, Color.SYM_FIELD)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitClassMethod(o: ValkyrieClassMethodNode) {
        highlight(o.nameIdentifier, Color.SYM_FUNCTION_SELF)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitFlagsDeclaration(o: ValkyrieFlagsStatement) {
        highlight(o.nameIdentifier, Color.SYM_CLASS)
    }

    override fun visitFlagsField(o: ValkyrieFlagsItemNode) {
        highlight(o.nameIdentifier, Color.SYM_FIELD)
    }

    override fun visitUnionDeclaration(o: ValkyrieUnionStatement) {
        highlight(o.nameIdentifier, Color.SYM_CLASS)
    }

    override fun visitVariantDeclaration(o: ValkyrieVariantItem) {
        highlight(o.nameIdentifier, Color.SYM_VARIANT)
    }

    override fun visitTraitDeclaration(o: ValkyrieTraitStatement) {
        highlight(o.nameIdentifier, Color.SYM_TRAIT)
    }

    override fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {
        highlight(o.getNameIdentifier(), Color.SYM_FUNCTION_FREE)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitVariableDeclaration(o: ValkyrieLetStatement) {
        super.visitVariableDeclaration(o)
    }

    override fun visitFunctionItem(o: ValkyrieFunctionParameter) {
        highlight(o.nameIdentifier, Color.SYM_ARG)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitForParameter(o: ValkyrieLetParameter) {
        if (o.mutable) {
            highlight(o.nameIdentifier, Color.SYM_LOCAL_MUT)
        } else {
            highlight(o.nameIdentifier, Color.SYM_LOCAL)
        }
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitNewObject(o: ValkyrieNewStatement) {
        highlight(o.identifier, Color.SYM_CLASS)
        for (mod in o.modifiers) {
            highlight(mod, Color.MODIFIER)
        }
    }

    override fun visitNamepath(o: ValkyrieNamepathNode) {
        fakeTypeColor(o.nameIdentifier)
    }

    override fun visitIdentifier(o: ValkyrieIdentifierNode) {
        fakeTypeColor(o)
    }
// =================================================================================================================

    fun highlight(element: PsiElement?, color: Color) {
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

    override fun clone(): HighlightVisitor = NodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}

private fun NodeHighlighter.fakeTypeColor(psi: ValkyrieIdentifierNode) {
    val name = psi.name
    when {
        keywords.contains(name) -> highlight(psi, Color.KEYWORD)
        traits.contains(name) -> highlight(psi, Color.SYM_TRAIT)
        variants.contains(name) -> highlight(psi, Color.SYM_VARIANT)
        name.isUppercase() -> highlight(psi, Color.SYM_GENERIC)
        name.first().isUpperCase() -> highlight(psi, Color.SYM_CLASS)
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

private val traits = setOf("Iterator", "Iterable", "Sequence")

private val variants = setOf("Some", "None", "Success", "Failure", "Left", "Riht")

