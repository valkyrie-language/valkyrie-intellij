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
val DeclareNamespace = ValkyrieAST("DEFINE_NAMESPACE")

//
val DeclareEnums = ValkyrieAST("DEFINE_ENUMERATE")
val DeclareFlags = ValkyrieAST("DEFINE_FLAGS")
val DeclareUnion = ValkyrieAST("DEFINE_UNION")

//
val DeclareClass = ValkyrieAST("DEFINE_CLASS")
val DeclareNeural = ValkyrieAST("DEFINE_NEURAL")
val DeclareWidget = ValkyrieAST("DEFINE_WIDGET")
val DeclareSingleton = ValkyrieAST("DEFINE_SINGLETON")
val DeclareTrait = ValkyrieAST("DEFINE_TRAIT")

//
val DeclareMezzo = ValkyrieAST("DEFINE_MEZZO")
val DeclareMacro = ValkyrieAST("DEFINE_MACRO")
val DeclareMicro = ValkyrieAST("DEFINE_FUNCTION")
val FunctionBody = ValkyrieAST("FUNCTION_BODY")

//
val AnonymousClass = ValkyrieAST("ANONYMOUS_OBJECT")
val AnonymousMicro = ValkyrieAST("ANONYMOUS_LAMBDA")

//
val InheritList = ValkyrieAST("INHERIT_LIST")
val InheritItem = ValkyrieAST("INHERIT_ITEM")
val ImplementList = ValkyrieAST("IMPLEMENT_LIST")
val ImplementItem = ValkyrieAST("IMPLEMENT_ITEM")
val ObjectBody = ValkyrieAST("OBJECT_BODY")
val MixtureBody = ValkyrieAST("MIXTURE_BODY")

//
val NamePath = ValkyrieAST("NAME_PATH")
val Identifier = ValkyrieAST("IDENTIFIER")
val NumberLiteral = ValkyrieAST("NUMBER_LITERAL")
val NumberUnit = ValkyrieAST("NUMBER_UNIT")

val Keyword = ValkyrieAST("KEYWORD")

//
val LoopInfinity = ValkyrieAST("LOOP_INFINITY")
val LoopEach = ValkyrieAST("LOOP_EACH")
val LoopMatch = ValkyrieAST("LOOP_MATCH")
val LoopWhileLet = ValkyrieAST("LOOP_WHILE_LET")
val LoopWhile = ValkyrieAST("LOOP_WHILE")
val LoopUntil = ValkyrieAST("LOOP_UNTIL")
val LoopUntilNot = ValkyrieAST("LOOP_UNTIL_NOT")
val LoopElse = ValkyrieAST("LOOP_ELSE")

//
val Operator = ValkyrieAST("OPERATOR")
val TermBinary = ValkyrieAST("BINARY")
val TermUnary = ValkyrieAST("UNARY")
val TermAtomic = ValkyrieAST("ATOMIC")
val TypeBinary = ValkyrieAST("BINARY")
val TypeUnary = ValkyrieAST("UNARY")
val TypeAtomic = ValkyrieAST("ATOMIC")

//
val Array = ValkyrieAST("ARRAY")
val VALUE = ValkyrieAST("VALUE")
val DefineDomain = ValkyrieAST("DOMAIN")
val DefineField = ValkyrieAST("FIELD")
val DefineMethod = ValkyrieAST("METHOD")
val DefineVariant = ValkyrieAST("VARIANT")
val DefineSemantic = ValkyrieAST("SEMANTIC")

//
val ParameterList = ValkyrieAST("PARAMETER_LIST")
val ParameterItem = ValkyrieAST("PARAMETER_ITEM")


val MatchExpression = ValkyrieAST("MATCH")


val LetStatement = ValkyrieAST("LET")

val TermTuplePattern = ValkyrieAST("TermTuplePattern")
val CasePattern = ValkyrieAST("CAST_PATTERN")



val AnnotationArea = ValkyrieAST("ANNOTATION_AREA")
val Annotation = ValkyrieAST("ANNOTATION")
val Modifier = ValkyrieAST("MODIFIER")

val MacroCall = ValkyrieAST("MACRO")
val TUPLE = ValkyrieAST("TUPLE")
val ArrayItem = ValkyrieAST("ARRAY_ITEM")

