package valkyrie.ide.reference.declaration

import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieIdentifierNode

class ValkyrieClassReference(definition: ValkyrieClassStatement, element: ValkyrieIdentifierNode): ValkyrieReference(element, definition) {

}

