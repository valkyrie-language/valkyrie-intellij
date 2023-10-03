package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.elementType
import com.intellij.psi.util.firstLeaf
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.language.psi.ValkyrieFactory
import valkyrie.psi.ValkyrieTypes.*
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.node.*


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val root = element.psi
        val settings = CodeStyle.getCustomSettings(
            root.containingFile,
            ValkyrieCodeStyleSettings::class.java
        )
        println("Project: ${root.project}")
        val factory = ValkyrieFactory(root.project)
        root.accept(BeforeFormatFixer(settings, factory))
        // refresh document cache
        return root.textRange
    }

    override fun changesWhitespacesOnly(): Boolean {
        return false
    }
}


private class BeforeFormatFixer : ValkyrieVisitor, PsiRecursiveVisitor {
    val settings: ValkyrieCodeStyleSettings
    val factory: ValkyrieFactory

    constructor(settings: ValkyrieCodeStyleSettings, factory: ValkyrieFactory) : super() {
        this.settings = settings
        this.factory = factory
    }

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        when (element.elementType) {
//            BIND -> element.replaceToken(BIND, "←")
            INFIX_MULTIPLE -> element.replace(factory.operatorMultiplication)
//            OP_MUL_ASSIGN -> element.replaceToken(OP_MUL_ASSIGN, "<×=")
//            NAME_SCOPE -> element.replaceToken(NAME_SCOPE, "⁜")
            NAME_SPLIT -> element.replace(factory.nameSplit)
//            OP_BASE -> element.replaceToken(OP_BASE, "⁂")
//            OP_EXPONENT -> element.replaceToken(OP_EXPONENT, "⁑")
//            OP_MACRO_UPPER -> element.replaceToken(OP_MACRO_UPPER, "↸")
            else -> element.acceptChildren(this)
        }
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


    private fun fixGenericBracket(o: PsiElement) {
        for (child in o.childrenWithLeaves) {
            when (child.elementType) {
                NAME_SPLIT -> child.delete()
//                ANGLE_L -> child.replaceLeaf(GENERIC_L, "⟨")
//                ANGLE_R -> child.replaceLeaf(GENERIC_R, "⟩")
            }
        }
    }

    override fun visitOffsetRange(o: ValkyrieOffsetRange) {
        for (child in o.childrenWithLeaves) {
            when (child.elementType) {
                NAME_SPLIT -> child.delete()
//                BRACKET_L -> child.replaceLeaf(OFFSET_L, "⁅")
//                BRACKET_R -> child.replaceLeaf(OFFSET_R, "⁆")
            }
        }
    }

    override fun visitReturnType(o: ValkyrieReturnType) {
//        when (settings.return_type) {
//            ReturnType.Ignore -> return
//            ReturnType.Colon -> o.firstChild.replaceLeaf(COLON, ":")
//            ReturnType.Arrow -> o.firstChild.replaceLeaf(OP_ARROW1, "->")
//            ReturnType.UnicodeArrow -> o.firstChild.replaceLeaf(OP_ARROW1, "⟶")
//        }
    }

    override fun visitAttributeBelow(o: ValkyrieAttributeBelow) {
        o.firstChild.replace(factory.operatorMacroLower)
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        when (settings.class_field_trailing) {
            ValkyrieCodeStyleSettings.CommaOrSemicolon.Ignore -> {

            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Nothing -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
                        SEMICOLON -> child.delete()
                        COMMA -> child.delete()
                    }
                }
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Comma -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
//                        SEMICOLON -> child.replaceLeaf(COMMA, ",")
                    }
                }
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Semicolon -> {
                for (child in o.childrenWithLeaves) {
                    when (child.elementType) {
//                        COMMA -> child.replaceLeaf(SEMICOLON, ";")
                    }
                }
            }
        }
    }


    override fun visitLocalizeCall(o: ValkyrieLocalizeCall) {
        val symbol = o.firstLeaf()
        if (symbol.text != "⸿") {
//            symbol.replaceLeaf(OP_L10N, "⸿")
        }
    }


    override fun visitInfixLessEqual(o: ValkyrieInfixLessEqual) {
//        o.replaceLeaf(INFIX_LESS_EQUAL, "<=")
    }

    override fun visitInfixGreaterEqual(o: ValkyrieInfixGreaterEqual) {
//        o.replaceLeaf(INFIX_GREATER_EQUAL, ">=")
    }

    override fun visitPrefixRef(o: ValkyriePrefixRef) {
//        o.replaceLeaf(PREFIX_REF, "⁋")
    }

    override fun visitPrefixDeref(o: ValkyriePrefixDeref) {
//        o.replaceLeaf(PREFIX_DEREF, "❡")
    }

    override fun visitBadLll(o: ValkyrieBadLll) {
//        o.replaceLeaf(OP_LLL, "⋘")
    }

    override fun visitBadRrr(o: ValkyrieBadRrr) {
//        o.replaceLeaf(OP_GGG, "⋙")
    }

    override fun visitBadLl(o: ValkyrieBadLl) {
//        o.replaceLeaf(OP_LL, "≪")
    }

    override fun visitBadRr(o: ValkyrieBadRr) {
//        o.replaceLeaf(OP_GG, "≫")
    }
}