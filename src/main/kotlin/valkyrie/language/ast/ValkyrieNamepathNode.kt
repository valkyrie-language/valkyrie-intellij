package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import com.jetbrains.rd.generator.nova.PredefinedType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree

class ValkyrieNamepathNode(node: ASTNode, type: IElementType, val free: Boolean = false) : IdentifierDefSubtree(node, type) {
}