package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi.ValkyrieNormalPattern
import com.github.valkyrie.language.psi.ValkyriePatternPair
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference


open class MixinCasePattern(node: ASTNode) : ValkyrieASTBase(node) {

}

