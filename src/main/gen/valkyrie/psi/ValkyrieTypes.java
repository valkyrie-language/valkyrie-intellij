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
    IElementType CATEGORY = new ValkyrieElementType("CATEGORY");
    IElementType CLASS = new ValkyrieElementType("CLASS");
    IElementType CLASS_BODY = new ValkyrieElementType("CLASS_BODY");
    IElementType CLASS_CAST = new ValkyrieElementType("CLASS_CAST");
    IElementType DECLARE_ENUMERATE = new ValkyrieElementType("DECLARE_ENUMERATE");
    IElementType DECLARE_FLAGS = new ValkyrieElementType("DECLARE_FLAGS");
    IElementType DECLARE_NAMESPACE = new ValkyrieElementType("DECLARE_NAMESPACE");
    IElementType DECLARE_SEMANTIC = new ValkyrieElementType("DECLARE_SEMANTIC");
    IElementType DEFINE_FUNCTION = new ValkyrieElementType("DEFINE_FUNCTION");
    IElementType DEFINE_UNION = new ValkyrieElementType("DEFINE_UNION");
    IElementType ENUMERATE_BODY = new ValkyrieElementType("ENUMERATE_BODY");
    IElementType ENUMERATE_ITEM = new ValkyrieElementType("ENUMERATE_ITEM");
    IElementType ESCAPE = new ValkyrieElementType("ESCAPE");
    IElementType EXPRESSION = new ValkyrieElementType("EXPRESSION");
    IElementType EXPRESSION_CHOICE = new ValkyrieElementType("EXPRESSION_CHOICE");
    IElementType EXPRESSION_GROUP = new ValkyrieElementType("EXPRESSION_GROUP");
    IElementType EXPRESSION_HARD = new ValkyrieElementType("EXPRESSION_HARD");
    IElementType EXPRESSION_SOFT = new ValkyrieElementType("EXPRESSION_SOFT");
    IElementType EXPRESSION_TAG = new ValkyrieElementType("EXPRESSION_TAG");
    IElementType FUNCTION_BLOCK = new ValkyrieElementType("FUNCTION_BLOCK");
    IElementType FUNCTION_CALL = new ValkyrieElementType("FUNCTION_CALL");
    IElementType FUNCTION_PARAMETER = new ValkyrieElementType("FUNCTION_PARAMETER");
    IElementType GROUP = new ValkyrieElementType("GROUP");
    IElementType GROUP_BODY = new ValkyrieElementType("GROUP_BODY");
    IElementType GROUP_ITEM = new ValkyrieElementType("GROUP_ITEM");
    IElementType GROUP_TERM = new ValkyrieElementType("GROUP_TERM");
    IElementType IDENTIFIER = new ValkyrieElementType("IDENTIFIER");
    IElementType IDENTIFIER_FREE = new ValkyrieElementType("IDENTIFIER_FREE");
    IElementType KEY = new ValkyrieElementType("KEY");
    IElementType MODIFIER = new ValkyrieElementType("MODIFIER");
    IElementType NAMEPATH = new ValkyrieElementType("NAMEPATH");
    IElementType NAMEPATH_FREE = new ValkyrieElementType("NAMEPATH_FREE");
    IElementType NUMBER = new ValkyrieElementType("NUMBER");
    IElementType PAIR = new ValkyrieElementType("PAIR");
    IElementType PARAMETER = new ValkyrieElementType("PARAMETER");
    IElementType PREFIX = new ValkyrieElementType("PREFIX");
    IElementType RANGE = new ValkyrieElementType("RANGE");
    IElementType RANGE_LOWER = new ValkyrieElementType("RANGE_LOWER");
    IElementType RANGE_UPPER = new ValkyrieElementType("RANGE_UPPER");
    IElementType REGEX = new ValkyrieElementType("REGEX");
    IElementType STRING = new ValkyrieElementType("STRING");
    IElementType SUFFIX = new ValkyrieElementType("SUFFIX");
    IElementType TAG_BRANCH = new ValkyrieElementType("TAG_BRANCH");
    IElementType TERM = new ValkyrieElementType("TERM");
    IElementType TUPLE = new ValkyrieElementType("TUPLE");
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
    IElementType ESCAPED = new ValkyrieTokenType("\\escaped");
    IElementType HASH = new ValkyrieTokenType("HASH");
    IElementType HYPHEN = new ValkyrieTokenType("-");
    IElementType INTEGER = new ValkyrieTokenType("<<INTEGER>>");
    IElementType KW_AS = new ValkyrieTokenType("as");
    IElementType KW_CLASS = new ValkyrieTokenType("class");
    IElementType KW_CLIMB = new ValkyrieTokenType("climb");
    IElementType KW_ENUMERATE = new ValkyrieTokenType("KW_ENUMERATE");
    IElementType KW_FLAGS = new ValkyrieTokenType("KW_FLAGS");
    IElementType KW_GRAMMAR = new ValkyrieTokenType("grammar");
    IElementType KW_GROUP = new ValkyrieTokenType("group");
    IElementType KW_IMPORT = new ValkyrieTokenType("import");
    IElementType KW_MACRO = new ValkyrieTokenType("macro");
    IElementType KW_NAMESPACE = new ValkyrieTokenType("KW_NAMESPACE");
    IElementType KW_UNION = new ValkyrieTokenType("union");
    IElementType KW_USING = new ValkyrieTokenType("using");
    IElementType OP_AND = new ValkyrieTokenType("OP_AND");
    IElementType OP_CONCAT = new ValkyrieTokenType("~");
    IElementType OP_MANY = new ValkyrieTokenType("*");
    IElementType OP_MANY1 = new ValkyrieTokenType("OP_MANY1");
    IElementType OP_NOT = new ValkyrieTokenType("OP_NOT");
    IElementType OP_OPTIONAL = new ValkyrieTokenType("OP_OPTIONAL");
    IElementType OP_OR = new ValkyrieTokenType("|");
    IElementType OP_REMARK = new ValkyrieTokenType("^");
    IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
    IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
    IElementType PLACE_HOLDER = new ValkyrieTokenType("_");
    IElementType REFERENCE = new ValkyrieTokenType("$Symbol");
    IElementType REGULAR_EXPRESSION = new ValkyrieTokenType("REGULAR_EXPRESSION");
    IElementType REGULAR_RANGE = new ValkyrieTokenType("REGULAR_RANGE");
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
            } else if (type == CATEGORY) {
                return new ValkyrieCategoryNode(node);
            } else if (type == CLASS) {
                return new ValkyrieClassNode(node);
            } else if (type == CLASS_BODY) {
                return new ValkyrieClassBodyNode(node);
            } else if (type == CLASS_CAST) {
                return new ValkyrieClassCastNode(node);
            } else if (type == DECLARE_ENUMERATE) {
                return new ValkyrieDeclareEnumerateNode(node);
            } else if (type == DECLARE_FLAGS) {
                return new ValkyrieDeclareFlagsNode(node);
            } else if (type == DECLARE_NAMESPACE) {
                return new ValkyrieDeclareNamespaceNode(node);
            } else if (type == DECLARE_SEMANTIC) {
                return new ValkyrieDeclareSemanticNode(node);
            } else if (type == DEFINE_FUNCTION) {
                return new ValkyrieDefineFunctionNode(node);
            } else if (type == DEFINE_UNION) {
                return new ValkyrieDefineUnionNode(node);
            } else if (type == ENUMERATE_BODY) {
                return new ValkyrieEnumerateBodyNode(node);
            } else if (type == ENUMERATE_ITEM) {
                return new ValkyrieEnumerateItemNode(node);
            } else if (type == ESCAPE) {
                return new ValkyrieEscapeNode(node);
            } else if (type == EXPRESSION_CHOICE) {
                return new ValkyrieExpressionChoiceNode(node);
            } else if (type == EXPRESSION_GROUP) {
                return new ValkyrieExpressionGroupNode(node);
            } else if (type == EXPRESSION_HARD) {
                return new ValkyrieExpressionHardNode(node);
            } else if (type == EXPRESSION_SOFT) {
                return new ValkyrieExpressionSoftNode(node);
            } else if (type == EXPRESSION_TAG) {
                return new ValkyrieExpressionTagNode(node);
            } else if (type == FUNCTION_BLOCK) {
                return new ValkyrieFunctionBlockNode(node);
            } else if (type == FUNCTION_CALL) {
                return new ValkyrieFunctionCallNode(node);
            } else if (type == FUNCTION_PARAMETER) {
                return new ValkyrieFunctionParameterNode(node);
            } else if (type == GROUP) {
                return new ValkyrieGroupNode(node);
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
            } else if (type == KEY) {
                return new ValkyrieKeyNode(node);
            } else if (type == MODIFIER) {
                return new ValkyrieModifierNode(node);
            } else if (type == NAMEPATH) {
                return new ValkyrieNamepathNode(node);
            } else if (type == NAMEPATH_FREE) {
                return new ValkyrieNamepathFreeNode(node);
            } else if (type == NUMBER) {
                return new ValkyrieNumberNode(node);
            } else if (type == PAIR) {
                return new ValkyriePairNode(node);
            } else if (type == PARAMETER) {
                return new ValkyrieParameterNode(node);
            } else if (type == PREFIX) {
                return new ValkyriePrefixNode(node);
            } else if (type == RANGE) {
                return new ValkyrieRangeNode(node);
            } else if (type == RANGE_LOWER) {
                return new ValkyrieRangeLowerNode(node);
            } else if (type == RANGE_UPPER) {
                return new ValkyrieRangeUpperNode(node);
            } else if (type == REGEX) {
                return new ValkyrieRegexNode(node);
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
