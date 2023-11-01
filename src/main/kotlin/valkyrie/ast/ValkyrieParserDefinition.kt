package valkyrie.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.node.*
import valkyrie.cst.*
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileNode

class ValkyrieParserDefinition : ParserDefinition {
    override fun createLexer(project: Project) = ValkyrieLexer()
    override fun createParser(project: Project) = ValkyrieParser()
    override fun getFileNodeType() = IFileElementType(ValkyrieLanguage)
    override fun getCommentTokens() = TokenSet.create(
        COMMENT_LINE_HEAD, COMMENT_LINE_TEXT,
        COMMENT_BLOCK
    )

    override fun getStringLiteralElements(): TokenSet = TokenSet.create(
        STRING
    )

    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(
        TokenType.WHITE_SPACE
    )

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createFile(viewProvider: FileViewProvider) = ValkyrieFileNode(viewProvider)
    override fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            Program -> ValkyrieProgramNode(node)
            Statement -> ValkyrieStatementNode(node)
            // 修饰器
            ANNOTATION -> ValkyrieAnnotationNode(node)
            ANNOTATION_MANY -> ValkyrieAnnotationManyNode(node)
            MODIFIER_LIST -> ValkyrieModifierListNode(node)
            Modifier -> ValkyrieModifierNode(node)
            // 具名对象
            DeclareClass -> ValkyrieClassDeclarationNode(node)
            DeclareTrait -> ValkyrieTraitDeclarationNode(node)
            DeclareMicro -> ValkyrieDeclareMicroNode(node)
            // 匿名对象
            AnonymousClass -> ValkyrieAnonymousObjectNode(node)
            AnonymousMicro -> ValkyrieAnonymousFunctionNode(node)
            // 后修饰器
            InheritList -> ValkyrieInheritListNode(node)
            InheritItem -> ValkyrieInheritItemNode(node)
            // 对象属性
            DefineField -> ValkyrieObjectFieldNode(node)
            DefineMethod -> ValkyrieObjectMethodNode(node)
            DefineDomain -> ValkyrieObjectDomainNode(node)
            // 表达式
            Operator -> ValkyrieOperatorNode(node)
            TermBinary -> ValkyrieTermBinaryNode(node)
            TermUnary -> ValkyrieTermUnaryNode(node)
            TermAtomic -> ValkyrieTermAtomicNode(node)
            // 调用
            MacroCall -> ValkyrieMacroCallNode(node)
            // {...}
            FunctionBody -> ValkyrieFunctionBodyNode(node)
            ObjectBody -> ValkyrieObjectNode(node)
            // [...]
            Array -> ValkyrieArrayNode(node)
            ArrayItem -> ValkyrieArrayItemNode(node)
            // (...)
            TUPLE -> ValkyrieTupleNode(node)
            VALUE -> ValkyrieValueNode(node)
            Identifier -> ValkyrieIdentifierNode(node)
            Keyword -> ValkyrieKeywordNode(node)
            else -> ASTWrapperPsiElement(node)
        }
    }
}