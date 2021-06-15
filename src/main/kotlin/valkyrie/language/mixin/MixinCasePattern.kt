package valkyrie.language.mixin

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi.ValkyrieNormalPattern
import valkyrie.language.psi.ValkyriePatternPair
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference


open class MixinCasePattern(node: ASTNode) : ValkyrieASTBase(node) {

}

