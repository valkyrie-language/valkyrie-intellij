package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings.ReturnType
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.node.*
import valkyrie.psi.replaceLeaf


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val root = element.psi
        val settings = CodeStyle.getCustomSettings(
            root.containingFile, ValkyrieCodeStyleSettings::class.java
        )
        val visitor = BeforeFormatFixer(settings)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }
        return range
    }

    override fun changesWhitespacesOnly(): Boolean {
        return super.changesWhitespacesOnly()
    }
}


private class BeforeFormatFixer : ValkyrieVisitor, PsiRecursiveVisitor {
    val settings: ValkyrieCodeStyleSettings

    constructor(settings: ValkyrieCodeStyleSettings) : super() {
        this.settings = settings
    }

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }

    override fun visitUsingTerm(o: ValkyrieUsingTerm) {
        super.visitUsingTerm(o)
    }

    override fun visitUsingBlock(o: ValkyrieUsingBlock) {
        super.visitUsingBlock(o)
    }

    override fun visitDeclareGeneric(o: ValkyrieDeclareGeneric) {
        fixGenericBracket(o)
    }


    override fun visitGenericCallFree(o: ValkyrieGenericCallFree) {
        fixGenericBracket(o)
    }

    override fun visitGenericCall(o: ValkyrieGenericCall) {
        fixGenericBracket(o)
    }

    override fun visitNamepath(o: ValkyrieNamepath) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.PROPORTION) {
                if (child.text == "::") {
                    child.replaceLeaf(ValkyrieTypes.PROPORTION, "∷")
                }
            }
        }
    }

    private fun fixGenericBracket(o: PsiElement) {
        for (child in o.childrenWithLeaves) {
            when (child.elementType) {
                ValkyrieTypes.PROPORTION -> child.delete()
                ValkyrieTypes.ANGLE_L -> child.replaceLeaf(ValkyrieTypes.GENERIC_L, "⟨")
                ValkyrieTypes.ANGLE_R -> child.replaceLeaf(ValkyrieTypes.GENERIC_R, "⟩")
            }
        }
    }

    override fun visitReturnType(o: ValkyrieReturnType) {
        when (settings.return_type) {
            ReturnType.Ignore -> return
            ReturnType.Colon -> o.firstChild.replaceLeaf(ValkyrieTypes.COLON, ":")
            ReturnType.Arrow -> o.firstChild.replaceLeaf(ValkyrieTypes.OP_ARROW1, "->")
            ReturnType.UnicodeArrow -> o.firstChild.replaceLeaf(ValkyrieTypes.OP_ARROW1, "⟶")
        }
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        when (settings.class_field_trailing) {
            ValkyrieCodeStyleSettings.CommaOrSemicolon.Ignore -> {

            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Nothing -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
                        ValkyrieTypes.SEMICOLON -> child.delete()
                        ValkyrieTypes.COMMA -> child.delete()
                    }
                }
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Comma -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
                        ValkyrieTypes.SEMICOLON -> child.replaceLeaf(ValkyrieTypes.COMMA, ",")
                    }
                }
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Semicolon -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
                        ValkyrieTypes.COMMA -> child.replaceLeaf(ValkyrieTypes.SEMICOLON, ";")
                    }
                }
            }
        }
    }

    override fun visitLocalizeCall(o: ValkyrieLocalizeCall) {
        val symbol = o.firstChild
        if (symbol.text == "\\L") {
            symbol.replaceLeaf(ValkyrieTypes.OP_L10N, "⸿")
        }
    }


    override fun visitBadLll(o: ValkyrieBadLll) {
        o.replaceLeaf(ValkyrieTypes.OP_LLL, "⋘")
    }

    override fun visitBadRrr(o: ValkyrieBadRrr) {
        o.replaceLeaf(ValkyrieTypes.OP_GGG, "⋙")
    }

    override fun visitBadLl(o: ValkyrieBadLl) {
        o.replaceLeaf(ValkyrieTypes.OP_LL, "≪")
    }

    override fun visitBadRr(o: ValkyrieBadRr) {
        o.replaceLeaf(ValkyrieTypes.OP_GG, "≫")
    }


}
