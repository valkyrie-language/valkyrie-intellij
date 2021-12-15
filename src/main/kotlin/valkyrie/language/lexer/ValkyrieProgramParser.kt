package valkyrie.language.lexer

import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieParser

class ValkyrieProgramParser(parser: ValkyrieParser) : ANTLRParserAdaptor(ValkyrieLanguage, parser) {
    override fun parse(parser: Parser, root: IElementType): ParseTree {
        return (parser as ValkyrieParser).program()
    }
}