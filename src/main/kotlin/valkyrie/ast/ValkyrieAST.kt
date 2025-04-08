package valkyrie.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import valkyrie.ValkyrieLanguage
import valkyrie.ast.node.ValkyrieAnnotationManyNode
import valkyrie.ast.node.ValkyrieAnnotationNode
import valkyrie.ast.node.ValkyrieArrayItemNode
import valkyrie.ast.node.ValkyrieArrayNode
import valkyrie.ast.node.ValkyrieBinaryNode
import valkyrie.ast.node.ValkyrieClassDeclareNode
import valkyrie.ast.node.ValkyrieClassAnonymousNode
import valkyrie.ast.node.ValkyrieMicroDeclarationNode
import valkyrie.ast.node.ValkyrieAnonymousMicroNode
import valkyrie.ast.node.ValkyrieDomainNode
import valkyrie.ast.node.ValkyrieFieldNode
import valkyrie.ast.node.ValkyrieFunctionBodyNode
import valkyrie.ast.node.ValkyrieClassInheritItemNode
import valkyrie.ast.node.ValkyrieMacroCallNode
import valkyrie.ast.node.ValkyrieMethodNode
import valkyrie.ast.node.ValkyrieModifierListNode
import valkyrie.ast.node.ValkyrieModifierNode
import valkyrie.ast.node.ValkyrieObjectNode
import valkyrie.ast.node.ValkyrieRootNode
import valkyrie.ast.node.ValkyrieStatementNode
import valkyrie.ast.node.ValkyrieTraitDeclarationNode
import valkyrie.ast.node.ValkyrieTupleNode
import valkyrie.ast.node.ValkyrieValueNode

// non-leaf node of the parse tree
class ValkyrieAST(show: String) : IElementType(show, ValkyrieLanguage) {

    override fun toString(): String = "${ValkyrieAST::class.simpleName}<${super.toString()}>"

    companion object {
        val FILE = IFileElementType(ValkyrieLanguage)

        fun createElement(node: ASTNode): PsiElement {
            return when (node.elementType) {
                ROOT -> ValkyrieRootNode(node)
                STATEMENT -> ValkyrieStatementNode(node)
                // 修饰器


                ANNOTATION -> ValkyrieAnnotationNode(node)
                ANNOTATION_MANY -> ValkyrieAnnotationManyNode(node)
                MODIFIER_LIST -> ValkyrieModifierListNode(node)
                MODIFIER -> ValkyrieModifierNode(node)
                // 具名对象
                DeclareClass -> ValkyrieClassDeclareNode(node)
                DefineTrait -> ValkyrieTraitDeclarationNode(node)
                DefineMicro -> ValkyrieMicroDeclarationNode(node)

                // 匿名对象
                AnonymousClass -> ValkyrieClassAnonymousNode(node)
                DefineLambda -> ValkyrieAnonymousMicroNode(node)
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

        val ROOT = ValkyrieAST("PROGRAM")
        val Unknown = ValkyrieAST("UNKNOWN")
        val STATEMENT = ValkyrieAST("STATEMENT")
        val DeclareClass = ValkyrieAST("DEFINE_CLASS")
        val AnonymousClass = ValkyrieAST("ANONYMOUS_OBJECT")
        val DefineTrait = ValkyrieAST("DEFINE_TRAIT")
        val ObjectBody = ValkyrieAST("OBJECT_BODY")
        val ANNOTATION = ValkyrieAST("ANNOTATION")
        val ANNOTATION_MANY = ValkyrieAST("ANNOTATION_MANY")
        val Identifier = ValkyrieAST("IDENTIFIER")
        val MODIFIER = ValkyrieAST("MODIFIER")
        val EXPRESSION = ValkyrieAST("EXPRESSION")
        val BINARY = ValkyrieAST("BINARY")
        val ATOMIC = ValkyrieAST("ATOMIC")
        val Array = ValkyrieAST("ARRAY")
        val VALUE = ValkyrieAST("VALUE")
        val DefineDomain = ValkyrieAST("DOMAIN")
        val DefineField = ValkyrieAST("FIELD")
        val DefineMethod = ValkyrieAST("METHOD")
        val ANNOTATION_LIST = ValkyrieAST("ANNOTATION_LIST")
        val MacroCall = ValkyrieAST("MACRO")
        val MODIFIER_LIST = ValkyrieAST("MODIFIER_LIST")
        val TUPLE = ValkyrieAST("TUPLE")
        val ArrayItem = ValkyrieAST("ARRAY_ITEM")
        val ClassInheritItem = ValkyrieAST("INHERIT_CLASS_ITEM")
        val INHERIT_CLASS_LIST = ValkyrieAST("INHERIT_CLASS_LIST")
        val IMPLEMENT_TRAIT_LIST = ValkyrieAST("IMPLEMENT_TRAIT_LIST")
        val DefineLambda = ValkyrieAST("DEFINE_LAMBDA")
        val DefineMicro = ValkyrieAST("DEFINE_FUNCTION")
        val FunctionBody = ValkyrieAST("FUNCTION_BODY")
    }
}

