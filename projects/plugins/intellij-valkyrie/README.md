# intellij-valkyrie

[![Version](https://img.shields.io/jetbrains/plugin/v/20594.svg)](https://plugins.jetbrains.com/plugin/20594)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/20594.svg)](https://plugins.jetbrains.com/plugin/20594)

A [Valkyrie Language](https://github.com/ygg-lang/project-yggdrasil) plugin for IntelliJ-based IDEs.

## Features

| Feature            | Progress | Implement                                                                                                                                             |
|--------------------|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| Syntax Highlight   | ✅        | [SyntaxHighlighter](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/highlight/WitSyntaxHighlighter.kt) |
| Semantic Highlight | ✅        | [HighlightVisitor](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/highlight/WitHighlightVisitor.kt)   |
| Pretty Formatter   | ✅        | [FormatBuilder](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/formatter/WitFormatBuilder.kt)         |
| Block Folding      | ✅        | [FoldingVisitor](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/matcher/WitFoldingVisitor.kt)         |
| Braces Matcher     | ✅        |                                                                                                                                                       |
| Smart Enter        | ✅        | [SmartEnter]()                                                                                                                                        |
