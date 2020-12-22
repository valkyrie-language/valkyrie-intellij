package com.github.valkyrie.language.psi

import com.github.valkyrie.language._FluentLexer
import com.intellij.lexer.FlexAdapter

class FluentLexerAdapter : FlexAdapter(_FluentLexer())
