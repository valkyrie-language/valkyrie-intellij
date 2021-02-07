package com.github.valkyrie.ide.highlight

import com.intellij.psi.PsiElement
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

enum class ValkyrieVariableHighlightMode {
    Local,
    Global,
    Argument,
    Self;

    fun render(visitor: ValkyrieHighlightVisitor, tail: PsiElement, mut: Boolean) = when (this) {
        Local -> visitor.highlight(tail, if (mut) Color.SYM_LOCAL_MUT else Color.SYM_LOCAL)
        Global -> visitor.highlight(tail, if (mut) Color.SYM_GLOBAL_MUT else Color.SYM_GLOBAL)
        Argument -> visitor.highlight(tail, if (mut) Color.SYM_ARG_MUT else Color.SYM_ARG)
        Self -> visitor.highlight(tail, if (mut) Color.SYM_ARG_SELF_MUT else Color.SYM_ARG_SELF)
    }
}




