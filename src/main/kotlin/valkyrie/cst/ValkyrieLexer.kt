package valkyrie.cst

import com.intellij.lexer.FlexAdapter
import valkyrie.psi._ValkyrieLexer

class ValkyrieLexer : FlexAdapter {
    constructor() : super(_ValkyrieLexer(null)) {

    }
}