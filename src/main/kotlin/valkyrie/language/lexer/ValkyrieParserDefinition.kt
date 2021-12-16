package valkyrie.language.lexer

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.ast.*
import valkyrie.language.file.ValkyrieFileNode

class ValkyrieParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return ValkyrieProgramLexer()
    }

    override fun createParser(project: Project): PsiParser {
        return ValkyrieProgramParser(ValkyrieParser(null))
    }

    /**
     * "Tokens of those types are automatically skipped by PsiBuilder."
     */
    override fun getWhitespaceTokens(): TokenSet {
        return PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.WS)
    }

    override fun getCommentTokens(): TokenSet {
        return PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.COMMENT, ValkyrieLexer.LINE_COMMENT)
    }

    override fun getStringLiteralElements(): TokenSet {
        return PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.STRING)
    }


    /**
     * What is the IFileElementType of the root parse tree node? It
     * is called from [.createFile] at least.
     */
    override fun getFileNodeType(): IFileElementType {
        return IFileElementType(ValkyrieLanguage)
    }

    /**
     * Create the root of your PSI tree (a PsiFile).
     *
     *
     * From IntelliJ IDEA Architectural Overview:
     * "A PSI (Program Structure Interface) file is the root of a structure
     * representing the contents of a file as a hierarchy of elements
     * in a particular programming language."
     *
     *
     * PsiFile is to be distinguished from a FileASTNode, which is a parse
     * tree node that eventually becomes a PsiFile. From PsiFile, we can get
     * it back via: [PsiFile.getNode].
     */
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ValkyrieFileNode(viewProvider)
    }
    /**
     * Convert from *NON-LEAF* parse node (AST they call it)
     * to PSI node. Leaves are created in the AST factory.
     * Rename re-factoring can cause this to be
     * called on a TokenIElementType since we want to rename ID nodes.
     * In that case, this method is called to create the root node
     * but with ID type. Kind of strange, but we can simply create a
     * ASTWrapperPsiElement to make everything work correctly.
     *
     *
     * RuleIElementType.  Ah! It's that ID is the root
     * IElementType requested to parse, which means that the root
     * node returned from parsetree->PSI conversion.  But, it
     * must be a CompositeElement! The adaptor calls
     * rootMarker.done(root) to finish off the PSI conversion.
     * See [ANTLRParserAdaptor.parse]
     *
     *
     * If you don't care to distinguish PSI nodes by type, it is
     * sufficient to create a [ANTLRPsiNode] around
     * the parse tree node
     */
    override fun createElement(node: ASTNode): PsiElement {
        return if (node is CompositeElement) {
            val type: RuleIElementType = node.elementType as RuleIElementType;
            when (type.ruleIndex) {
                ValkyrieParser.RULE_program -> ValkyrieProgramNode(node, type)
                ValkyrieParser.RULE_define_namespace -> ValkyrieNamespaceDeclaration(node, type)
                ValkyrieParser.RULE_define_class -> ValkyrieClassDeclaration(node, type)
                ValkyrieParser.RULE_define_trait -> ValkyrieTraitDeclaration(node, type)
                ValkyrieParser.RULE_define_function -> ValkyrieFunctionDeclaration(node, type)
                ValkyrieParser.RULE_namepath -> ValkyrieNamepathNode(node, type)
                ValkyrieParser.RULE_identifier -> ValkyrieIdentifierNode(node, type)
                else -> {
                    println("create element of ${node.javaClass.name}: ${node.elementType}")
                    ANTLRPsiNode(node)
                }
            }
        } else {
            println("create element of ${node.javaClass.name}: ${node.elementType}(${node.text})")
            ANTLRPsiNode(node)
        }
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return super.spaceExistenceTypeBetweenTokens(left, right)
    }

    companion object {
        var ID: TokenIElementType? = null

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                ValkyrieLanguage,
                ValkyrieParser.tokenNames,
                ValkyrieParser.ruleNames
            )
            val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(ValkyrieLanguage)
            ID = tokenIElementTypes[ValkyrieLexer.UNICODE_ID]
        }
    }
}


