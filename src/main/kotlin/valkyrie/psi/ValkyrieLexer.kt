package valkyrie.psi

import com.intellij.lexer.FlexAdapter

class ValkyrieLexer : FlexAdapter {
    constructor() : super(_ValkyrieLexer(null)) {

    }
}