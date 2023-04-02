// This is a generated file. Not intended for manual editing.
package valkyrie.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import yggdrasil.psi.node.*;

public interface ValkyrieTypes {

    IElementType ANNOTATIONS = new ValkyrieElementType("ANNOTATIONS");
    IElementType ARGUMENT = new ValkyrieElementType("ARGUMENT");
    IElementType ATOMIC = new ValkyrieElementType("ATOMIC");
    IElementType ATTRIBUTE = new ValkyrieElementType("ATTRIBUTE");
    IElementType CLASS_BODY = new ValkyrieElementType("CLASS_BODY");
    IElementType CLASS_ITEM = new ValkyrieElementType("CLASS_ITEM");
    IElementType DECLARE_CLASS = new ValkyrieElementType("DECLARE_CLASS");
    IElementType DECLARE_ENUMERATE = new ValkyrieElementType("DECLARE_ENUMERATE");
    IElementType DECLARE_FIELD = new ValkyrieElementType("DECLARE_FIELD");
    IElementType DECLARE_FLAGS = new ValkyrieElementType("DECLARE_FLAGS");
    IElementType DECLARE_FUNCTION = new ValkyrieElementType("DECLARE_FUNCTION");
    IElementType DECLARE_INTERFACE = new ValkyrieElementType("DECLARE_INTERFACE");
    IElementType DECLARE_NAMESPACE = new ValkyrieElementType("DECLARE_NAMESPACE");
    IElementType DECLARE_SEMANTIC = new ValkyrieElementType("DECLARE_SEMANTIC");
    IElementType DECLARE_UNION = new ValkyrieElementType("DECLARE_UNION");
    IElementType DECLARE_UNITE = new ValkyrieElementType("DECLARE_UNITE");
    IElementType DEFAULT_VALUE = new ValkyrieElementType("DEFAULT_VALUE");
    IElementType EFFECT_TYPE = new ValkyrieElementType("EFFECT_TYPE");
    IElementType ENUMERATE_BODY = new ValkyrieElementType("ENUMERATE_BODY");
    IElementType ENUMERATE_ITEM = new ValkyrieElementType("ENUMERATE_ITEM");
    IElementType EXPRESSION = new ValkyrieElementType("EXPRESSION");
    IElementType FUNCTION_BODY = new ValkyrieElementType("FUNCTION_BODY");
    IElementType FUNCTION_CALL = new ValkyrieElementType("FUNCTION_CALL");
    IElementType FUNCTION_ITEM = new ValkyrieElementType("FUNCTION_ITEM");
    IElementType GROUP_BODY = new ValkyrieElementType("GROUP_BODY");
    IElementType GROUP_ITEM = new ValkyrieElementType("GROUP_ITEM");
    IElementType GROUP_TERM = new ValkyrieElementType("GROUP_TERM");
    IElementType IDENTIFIER = new ValkyrieElementType("IDENTIFIER");
    IElementType IDENTIFIER_FREE = new ValkyrieElementType("IDENTIFIER_FREE");
    IElementType INFIX = new ValkyrieElementType("INFIX");
    IElementType KEY = new ValkyrieElementType("KEY");
    IElementType MACRO_CALL = new ValkyrieElementType("MACRO_CALL");
    IElementType MODIFIER = new ValkyrieElementType("MODIFIER");
    IElementType NAMEPATH = new ValkyrieElementType("NAMEPATH");
    IElementType NAMEPATH_FREE = new ValkyrieElementType("NAMEPATH_FREE");
    IElementType NUMBER = new ValkyrieElementType("NUMBER");
    IElementType ORDINAL_RANGE = new ValkyrieElementType("ORDINAL_RANGE");
    IElementType PAIR = new ValkyrieElementType("PAIR");
    IElementType PARAMETER_BODY = new ValkyrieElementType("PARAMETER_BODY");
    IElementType PARAMETER_ITEM = new ValkyrieElementType("PARAMETER_ITEM");
    IElementType PREFIX = new ValkyrieElementType("PREFIX");
    IElementType RANGE_INDEX = new ValkyrieElementType("RANGE_INDEX");
    IElementType RANGE_ITEM = new ValkyrieElementType("RANGE_ITEM");
    IElementType RANGE_LOWER = new ValkyrieElementType("RANGE_LOWER");
    IElementType RANGE_STEP = new ValkyrieElementType("RANGE_STEP");
    IElementType RANGE_UPPER = new ValkyrieElementType("RANGE_UPPER");
    IElementType RETURN_TYPE = new ValkyrieElementType("RETURN_TYPE");
    IElementType STRING = new ValkyrieElementType("STRING");
    IElementType SUFFIX = new ValkyrieElementType("SUFFIX");
    IElementType TAG_BRANCH = new ValkyrieElementType("TAG_BRANCH");
    IElementType TERM = new ValkyrieElementType("TERM");
    IElementType TUPLE = new ValkyrieElementType("TUPLE");
    IElementType TYPE_ATOMIC = new ValkyrieElementType("TYPE_ATOMIC");
    IElementType TYPE_EXPRESSION = new ValkyrieElementType("TYPE_EXPRESSION");
    IElementType TYPE_HINT = new ValkyrieElementType("TYPE_HINT");
    IElementType TYPE_INFIX = new ValkyrieElementType("TYPE_INFIX");
    IElementType TYPE_PREFIX = new ValkyrieElementType("TYPE_PREFIX");
    IElementType TYPE_SUFFIX = new ValkyrieElementType("TYPE_SUFFIX");
    IElementType TYPE_TERM = new ValkyrieElementType("TYPE_TERM");
    IElementType UNION_BODY = new ValkyrieElementType("UNION_BODY");
    IElementType UNION_VARIANT = new ValkyrieElementType("UNION_VARIANT");
    IElementType USING = new ValkyrieElementType("USING");
    IElementType USING_ALIAS = new ValkyrieElementType("USING_ALIAS");
    IElementType USING_BODY = new ValkyrieElementType("USING_BODY");
    IElementType USING_TERM = new ValkyrieElementType("USING_TERM");
    IElementType VALUE = new ValkyrieElementType("VALUE");

    IElementType ANGLE_L = new ValkyrieTokenType("<");
    IElementType ANGLE_R = new ValkyrieTokenType(">");
    IElementType AT = new ValkyrieTokenType("@");
    IElementType BIND = new ValkyrieTokenType("=");
    IElementType BRACE_L = new ValkyrieTokenType("{");
    IElementType BRACE_R = new ValkyrieTokenType("}");
    IElementType BRACKET_L = new ValkyrieTokenType("[");
    IElementType BRACKET_R = new ValkyrieTokenType("]");
    IElementType COLON = new ValkyrieTokenType(":");
    IElementType COMMA = new ValkyrieTokenType(",");
    IElementType COMMENT_BLOCK = new ValkyrieTokenType("Comment Block");
    IElementType COMMENT_LINE = new ValkyrieTokenType("Comment");
    IElementType DOLLAR = new ValkyrieTokenType("$");
    IElementType DOT = new ValkyrieTokenType(".");
    IElementType EQUAL = new ValkyrieTokenType("EQUAL");
    IElementType ESCAPED = new ValkyrieTokenType("\\escaped");
    IElementType HASH = new ValkyrieTokenType("HASH");
    IElementType HYPHEN = new ValkyrieTokenType("-");
    IElementType INTEGER = new ValkyrieTokenType("<<INTEGER>>");
    IElementType KW_AS = new ValkyrieTokenType("as");
    IElementType KW_CLASS = new ValkyrieTokenType("class");
    IElementType KW_CLIMB = new ValkyrieTokenType("climb");
    IElementType KW_ENUMERATE = new ValkyrieTokenType("KW_ENUMERATE");
    IElementType KW_FLAGS = new ValkyrieTokenType("KW_FLAGS");
    IElementType KW_FUNCTION = new ValkyrieTokenType("KW_FUNCTION");
    IElementType KW_GRAMMAR = new ValkyrieTokenType("grammar");
    IElementType KW_GROUP = new ValkyrieTokenType("group");
    IElementType KW_IMPORT = new ValkyrieTokenType("import");
    IElementType KW_INTERFACE = new ValkyrieTokenType("KW_INTERFACE");
    IElementType KW_MACRO = new ValkyrieTokenType("macro");
    IElementType KW_NAMESPACE = new ValkyrieTokenType("KW_NAMESPACE");
    IElementType KW_UNION = new ValkyrieTokenType("union");
    IElementType KW_UNITE = new ValkyrieTokenType("KW_UNITE");
    IElementType KW_USING = new ValkyrieTokenType("using");
    IElementType OP_AND = new ValkyrieTokenType("OP_AND");
    IElementType OP_AND_THEN = new ValkyrieTokenType("OP_AND_THEN");
    IElementType OP_BANG = new ValkyrieTokenType("OP_BANG");
    IElementType OP_CONCAT = new ValkyrieTokenType("~");
    IElementType OP_MANY = new ValkyrieTokenType("*");
    IElementType OP_NOT = new ValkyrieTokenType("OP_NOT");
    IElementType OP_OPTIONAL = new ValkyrieTokenType("OP_OPTIONAL");
    IElementType OP_OR = new ValkyrieTokenType("|");
    IElementType OP_REMARK = new ValkyrieTokenType("^");
    IElementType OP_TO = new ValkyrieTokenType("OP_TO");
    IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
    IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
    IElementType PLACE_HOLDER = new ValkyrieTokenType("_");
    IElementType REFERENCE = new ValkyrieTokenType("$Symbol");
    IElementType SELECTION_LINE = new ValkyrieTokenType("SELECTION_LINE");
    IElementType SEMICOLON = new ValkyrieTokenType(";");
    IElementType SLASH = new ValkyrieTokenType("/");
    IElementType SYMBOL = new ValkyrieTokenType("Symbol");
    IElementType SYMBOW_RAW = new ValkyrieTokenType("SYMBOW_RAW");
    IElementType TEXT_DOUBLE = new ValkyrieTokenType("TEXT_DOUBLE");
    IElementType TEXT_SINGLE = new ValkyrieTokenType("TEXT_SINGLE");
    IElementType TO = new ValkyrieTokenType("->");
    IElementType URL = new ValkyrieTokenType("Url");
    IElementType VERSION = new ValkyrieTokenType("<<semver>>");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == ANNOTATIONS) {
                return new ValkyrieAnnotationsNode(node);
            } else if (type == ARGUMENT) {
                return new ValkyrieArgumentNode(node);
            } else if (type == ATOMIC) {
                return new ValkyrieAtomicNode(node);
            } else if (type == ATTRIBUTE) {
                return new ValkyrieAttributeNode(node);
            } else if (type == CLASS_BODY) {
                return new ValkyrieClassBodyNode(node);
            } else if (type == CLASS_ITEM) {
                return new ValkyrieClassItemNode(node);
            } else if (type == DECLARE_CLASS) {
                return new ValkyrieDeclareClassNode(node);
            } else if (type == DECLARE_ENUMERATE) {
                return new ValkyrieDeclareEnumerateNode(node);
            } else if (type == DECLARE_FIELD) {
                return new ValkyrieDeclareFieldNode(node);
            } else if (type == DECLARE_FLAGS) {
                return new ValkyrieDeclareFlagsNode(node);
            } else if (type == DECLARE_FUNCTION) {
                return new ValkyrieDeclareFunctionNode(node);
            } else if (type == DECLARE_INTERFACE) {
                return new ValkyrieDeclareInterfaceNode(node);
            } else if (type == DECLARE_NAMESPACE) {
                return new ValkyrieDeclareNamespaceNode(node);
            } else if (type == DECLARE_SEMANTIC) {
                return new ValkyrieDeclareSemanticNode(node);
            } else if (type == DECLARE_UNION) {
                return new ValkyrieDeclareUnionNode(node);
            } else if (type == DECLARE_UNITE) {
                return new ValkyrieDeclareUniteNode(node);
            } else if (type == DEFAULT_VALUE) {
                return new ValkyrieDefaultValueNode(node);
            } else if (type == EFFECT_TYPE) {
                return new ValkyrieEffectTypeNode(node);
            } else if (type == ENUMERATE_BODY) {
                return new ValkyrieEnumerateBodyNode(node);
            } else if (type == ENUMERATE_ITEM) {
                return new ValkyrieEnumerateItemNode(node);
            } else if (type == EXPRESSION) {
                return new ValkyrieExpressionNode(node);
            } else if (type == FUNCTION_BODY) {
                return new ValkyrieFunctionBodyNode(node);
            } else if (type == FUNCTION_CALL) {
                return new ValkyrieFunctionCallNode(node);
            } else if (type == FUNCTION_ITEM) {
                return new ValkyrieFunctionItemNode(node);
            } else if (type == GROUP_BODY) {
                return new ValkyrieGroupBodyNode(node);
            } else if (type == GROUP_ITEM) {
                return new ValkyrieGroupItemNode(node);
            } else if (type == GROUP_TERM) {
                return new ValkyrieGroupTermNode(node);
            } else if (type == IDENTIFIER) {
                return new ValkyrieIdentifierNode(node);
            } else if (type == IDENTIFIER_FREE) {
                return new ValkyrieIdentifierFreeNode(node);
            } else if (type == INFIX) {
                return new ValkyrieInfixNode(node);
            } else if (type == KEY) {
                return new ValkyrieKeyNode(node);
            } else if (type == MACRO_CALL) {
                return new ValkyrieMacroCallNode(node);
            } else if (type == MODIFIER) {
                return new ValkyrieModifierNode(node);
            } else if (type == NAMEPATH) {
                return new ValkyrieNamepathNode(node);
            } else if (type == NAMEPATH_FREE) {
                return new ValkyrieNamepathFreeNode(node);
            } else if (type == NUMBER) {
                return new ValkyrieNumberNode(node);
            } else if (type == ORDINAL_RANGE) {
                return new ValkyrieOrdinalRangeNode(node);
            } else if (type == PAIR) {
                return new ValkyriePairNode(node);
            } else if (type == PARAMETER_BODY) {
                return new ValkyrieParameterBodyNode(node);
            } else if (type == PARAMETER_ITEM) {
                return new ValkyrieParameterItemNode(node);
            } else if (type == PREFIX) {
                return new ValkyriePrefixNode(node);
            } else if (type == RANGE_INDEX) {
                return new ValkyrieRangeIndexNode(node);
            } else if (type == RANGE_ITEM) {
                return new ValkyrieRangeItemNode(node);
            } else if (type == RANGE_LOWER) {
                return new ValkyrieRangeLowerNode(node);
            } else if (type == RANGE_STEP) {
                return new ValkyrieRangeStepNode(node);
            } else if (type == RANGE_UPPER) {
                return new ValkyrieRangeUpperNode(node);
            } else if (type == RETURN_TYPE) {
                return new ValkyrieReturnTypeNode(node);
            } else if (type == STRING) {
                return new ValkyrieStringNode(node);
            } else if (type == SUFFIX) {
                return new ValkyrieSuffixNode(node);
            } else if (type == TAG_BRANCH) {
                return new ValkyrieTagBranchNode(node);
            } else if (type == TERM) {
                return new ValkyrieTermNode(node);
            } else if (type == TUPLE) {
                return new ValkyrieTupleNode(node);
            } else if (type == TYPE_ATOMIC) {
                return new ValkyrieTypeAtomicNode(node);
            } else if (type == TYPE_EXPRESSION) {
                return new ValkyrieTypeExpressionNode(node);
            } else if (type == TYPE_HINT) {
                return new ValkyrieTypeHintNode(node);
            } else if (type == TYPE_INFIX) {
                return new ValkyrieTypeInfixNode(node);
            } else if (type == TYPE_PREFIX) {
                return new ValkyrieTypePrefixNode(node);
            } else if (type == TYPE_SUFFIX) {
                return new ValkyrieTypeSuffixNode(node);
            } else if (type == TYPE_TERM) {
                return new ValkyrieTypeTermNode(node);
            } else if (type == UNION_BODY) {
                return new ValkyrieUnionBodyNode(node);
            } else if (type == UNION_VARIANT) {
                return new ValkyrieUnionVariantNode(node);
            } else if (type == USING) {
                return new ValkyrieUsingNode(node);
            } else if (type == USING_ALIAS) {
                return new ValkyrieUsingAliasNode(node);
            } else if (type == USING_BODY) {
                return new ValkyrieUsingBodyNode(node);
            } else if (type == USING_TERM) {
                return new ValkyrieUsingTermNode(node);
            } else if (type == VALUE) {
                return new ValkyrieValueNode(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
