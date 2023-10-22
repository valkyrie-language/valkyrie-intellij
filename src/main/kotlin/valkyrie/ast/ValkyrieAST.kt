package valkyrie.ast

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

// non-leaf node of the parse tree
class ValkyrieAST(show: String) : IElementType(show, ValkyrieLanguage) {

    override fun toString(): String = "AST<${super.toString()}>"
}

val Unknown = ValkyrieAST("UNKNOWN")
val Program = ValkyrieAST("PROGRAM")
val Statement = ValkyrieAST("STATEMENT")
val DeclareClass = ValkyrieAST("DEFINE_CLASS")
val DeclareTrait = ValkyrieAST("DEFINE_TRAIT")
val AnonymousClass = ValkyrieAST("ANONYMOUS_OBJECT")

//
val InheritList = ValkyrieAST("INHERIT_LIST")
val InheritItem = ValkyrieAST("INHERIT_ITEM")
val ImplementList = ValkyrieAST("IMPLEMENT_LIST")
val ImplementItem = ValkyrieAST("IMPLEMENT_ITEM")
val ObjectBody = ValkyrieAST("OBJECT_BODY")
val ANNOTATION = ValkyrieAST("ANNOTATION")
val ANNOTATION_MANY = ValkyrieAST("ANNOTATION_MANY")

//
val Identifier = ValkyrieAST("IDENTIFIER")
val Modifier = ValkyrieAST("MODIFIER")
val Keyword = ValkyrieAST("KEYWORD")

//
val Operator = ValkyrieAST("OPERATOR")
val TermBinary = ValkyrieAST("BINARY")
val TermUnary = ValkyrieAST("UNARY")
val TermAtomic = ValkyrieAST("ATOMIC")
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

//
val AnonymousMicro = ValkyrieAST("DEFINE_LAMBDA")
val DeclareMicro = ValkyrieAST("DEFINE_FUNCTION")
val FunctionBody = ValkyrieAST("FUNCTION_BODY")