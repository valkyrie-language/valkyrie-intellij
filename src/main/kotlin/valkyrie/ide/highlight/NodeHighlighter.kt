package valkyrie.ide.highlight


import ai.grazie.utils.isUppercase
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieFunctionItem
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.ValkyrieRecursiveVisitor
//import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class NodeHighlighter : ValkyrieRecursiveVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null


    override fun visitClassDeclaration(node: ValkyrieClassStatement) {
        highlight(node.nameIdentifier, Color.SYM_CLASS)
    }

    override fun visitTraitDeclaration(node: ValkyrieTraitStatement) {
        highlight(node.nameIdentifier, Color.SYM_TRAIT)
    }

    override fun visitFunctionItem(node: ValkyrieFunctionItem) {
        highlight(node.nameIdentifier, Color.SYM_ARG)
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

private fun NodeHighlighter.fakeTypeColor(psi: PsiElement) {
    for (node in PsiTreeUtil.findChildrenOfType(psi, ValkyrieIdentifierNode::class.java)) {
        val name = node.name
        when {
            name.isUppercase() -> highlight(node, Color.SYM_GENERIC)
            name.first().isUpperCase() -> highlight(node, Color.SYM_CLASS)
            keywords.contains(name) -> highlight(node, Color.KEYWORD)
            traits.contains(name) -> highlight(node, Color.SYM_TRAIT)
        }
    }
}

private val forceKeywords = setOf("await", "async", "quote")

private val keywords = setOf(
    "u8", "u16", "u32", "u64",
    "i8", "i16", "i32", "i64",
    "f32", "f64",
    "bool", "char", "string",
    "unit"
)

private val traits = setOf("Iterator")

private val variants = setOf("Some", "None", "Success", "Failure", "Left", "Riht")

