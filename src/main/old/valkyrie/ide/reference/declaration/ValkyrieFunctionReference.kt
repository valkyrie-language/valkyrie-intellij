package valkyrie.ide.reference.declaration

import valkyrie.language.ast.ValkyrieFunctionStatement
import valkyrie.language.ast.ValkyrieIdentifierNode

class ValkyrieFunctionReference(definition: ValkyrieFunctionStatement, element: ValkyrieIdentifierNode) :
    ValkyrieReference(element, definition) {

}