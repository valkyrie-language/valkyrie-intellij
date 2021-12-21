package valkyrie.ide.highlight

import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieClassMethodNode
//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode

enum class IdentifierKind {
    Trait,
    Class,
    ClassField,
    ClassMethod,
    Variant,
    VariantItem;

    val color
        get() = when (this) {
            Trait -> ValkyrieHighlightColor.SYM_TRAIT
            Class -> ValkyrieHighlightColor.SYM_CLASS
            ClassField -> ValkyrieHighlightColor.SYM_FIELD
            ClassMethod -> ValkyrieHighlightColor.SYM_FUNCTION_SELF
            Variant -> ValkyrieHighlightColor.SYM_VARIANT
            VariantItem -> ValkyrieHighlightColor.SYM_FIELD
        }

    companion object {
        fun resolve(o: ValkyrieIdentifier): IdentifierKind? {
            return when (o.reference?.resolve()) {
                is ValkyrieTraitStatementNode -> Trait
                is ValkyrieClassDeclaration -> Class
                is ValkyrieClassFieldNode -> ClassField
                is ValkyrieClassMethodNode -> ClassMethod
                else -> null
            }
        }
    }
}