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
import valkyrie.ast.node.ValkyrieAnnotationManyNode
import valkyrie.ast.node.ValkyrieAnnotationNode
import valkyrie.ast.node.ValkyrieAnonymousFunctionNode
import valkyrie.ast.node.ValkyrieAnonymousObjectNode
import valkyrie.ast.node.ValkyrieArrayItemNode
import valkyrie.ast.node.ValkyrieArrayNode
import valkyrie.ast.node.ValkyrieBinaryNode
import valkyrie.ast.node.ValkyrieClassDeclareNode
import valkyrie.ast.node.ValkyrieClassInheritItemNode
import valkyrie.ast.node.ValkyrieDomainNode
import valkyrie.ast.node.ValkyrieFieldNode
import valkyrie.ast.node.ValkyrieFunctionBodyNode
import valkyrie.ast.node.ValkyrieMacroCallNode
import valkyrie.ast.node.ValkyrieMethodNode
import valkyrie.ast.node.ValkyrieMicroDeclarationNode
import valkyrie.ast.node.ValkyrieModifierListNode
import valkyrie.ast.node.ValkyrieModifierNode
import valkyrie.ast.node.ValkyrieObjectNode
import valkyrie.ast.node.ValkyrieProgramNode
import valkyrie.ast.node.ValkyrieStatementNode
import valkyrie.ast.node.ValkyrieTraitDeclarationNode
import valkyrie.ast.node.ValkyrieTupleNode
import valkyrie.ast.node.ValkyrieValueNode
import valkyrie.cst.ValkyrieCST
import valkyrie.cst.ValkyrieLexer
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileNode

class ParserDefinition : ParserDefinition {
    override fun createLexer(project: Project) = ValkyrieLexer()
    override fun createParser(project: Project) = ValkyrieParser()
    override fun getFileNodeType() = IFileElementType(ValkyrieLanguage)
    override fun getCommentTokens() = TokenSet.create(
        ValkyrieCST.Companion.COMMENT_LINE, ValkyrieCST.Companion.COMMENT_BLOCK
    )

    override fun getStringLiteralElements(): TokenSet = TokenSet.create(
        ValkyrieCST.Companion.STRING
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
            MODIFIER -> ValkyrieModifierNode(node)
            // 具名对象
            DeclareClass -> ValkyrieClassDeclareNode(node)
            DeclareTrait -> ValkyrieTraitDeclarationNode(node)
            DeclareMicro -> ValkyrieMicroDeclarationNode(node)

            // 匿名对象
            AnonymousClass -> ValkyrieAnonymousObjectNode(node)
            AnonymousMicro -> ValkyrieAnonymousFunctionNode(node)
            // 对象属性
            DefineField -> ValkyrieFieldNode(node)
            DefineMethod -> ValkyrieMethodNode(node)
            DefineDomain -> ValkyrieDomainNode(node)
            // 后修饰器
            ClassInheritItem -> ValkyrieClassInheritItemNode(node)
            // 表达式
            BINARY -> ValkyrieBinaryNode(node)
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
            else -> ASTWrapperPsiElement(node)
        }
    }
}