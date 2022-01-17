package valkyrie.language.ast


import com.intellij.psi.impl.source.tree.CompositeElement

class ModifiedIdentifier(node: CompositeElement) : ValkyrieASTBase(node) {
    public val identifier: ValkyrieIdentifierNode? = findChildrenByClass(ValkyrieIdentifierNode::class.java).last();
    public val modifiers: List<ValkyrieIdentifierNode> = findChildrenByClass(ValkyrieIdentifierNode::class.java).dropLast(1);
}


