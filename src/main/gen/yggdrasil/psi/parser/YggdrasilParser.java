// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static valkyrie.psi.ValkyrieTypes.*;
import static valkyrie.psi.ParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class YggdrasilParser implements PsiParser, LightPsiParser {

    public ASTNode parse(IElementType t, PsiBuilder b) {
        parseLight(t, b);
        return b.getTreeBuilt();
    }

    public void parseLight(IElementType t, PsiBuilder b) {
        boolean r;
        b = adapt_builder_(t, b, this, EXTENDS_SETS_);
        Marker m = enter_section_(b, 0, _COLLAPSE_, null);
        r = parse_root_(t, b);
        exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
    }

    protected boolean parse_root_(IElementType t, PsiBuilder b) {
        return parse_root_(t, b, 0);
    }

    static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
        return root(b, l + 1);
    }

    public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[]{
            create_token_set_(NAMEPATH, NAMEPATH_FREE),
            create_token_set_(IDENTIFIER, IDENTIFIER_FREE),
            create_token_set_(ATOMIC, EXPRESSION, EXPRESSION_GROUP),
    };

    /* ********************************************************** */
    // attribute* modifier*
    public static boolean annotations(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "annotations")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ANNOTATIONS, "<annotations>");
        r = annotations_0(b, l + 1);
        r = r && annotations_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // attribute*
    private static boolean annotations_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "annotations_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "annotations_0", c)) break;
        }
        return true;
    }

    // modifier*
    private static boolean annotations_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "annotations_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "annotations_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // (identifier-free COLON)? value {
    // //    mixin = "yggdrasil.psi.mixin.MixinTuple"
    // }
    public static boolean argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
        r = argument_0(b, l + 1);
        r = r && value(b, l + 1);
        r = r && argument_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (identifier-free COLON)?
    private static boolean argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0")) return false;
        argument_0_0(b, l + 1);
        return true;
    }

    // identifier-free COLON
    private static boolean argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_free(b, l + 1);
        r = r && consumeToken(b, COLON);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // //    mixin = "yggdrasil.psi.mixin.MixinTuple"
    // }
    private static boolean argument_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // expression-group | identifier-free | escape | string | regex | function-call | number
    public static boolean atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _COLLAPSE_, ATOMIC, "<atomic>");
        r = expression_group(b, l + 1);
        if (!r) r = identifier_free(b, l + 1);
        if (!r) r = escape(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = regex(b, l + 1);
        if (!r) r = function_call(b, l + 1);
        if (!r) r = number(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (AT|HASH) identifier tuple?
    public static boolean attribute(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute")) return false;
        if (!nextTokenIs(b, "<attribute>", AT, HASH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, "<attribute>");
        r = attribute_0(b, l + 1);
        r = r && identifier(b, l + 1);
        p = r; // pin = 2
        r = r && attribute_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // AT|HASH
    private static boolean attribute_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_0")) return false;
        boolean r;
        r = consumeToken(b, AT);
        if (!r) r = consumeToken(b, HASH);
        return r;
    }

    // tuple?
    private static boolean attribute_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_2")) return false;
        tuple(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L (key COLON)? identifier-free BRACE_R
    public static boolean category(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "category")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && category_1(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, CATEGORY, r);
        return r;
    }

    // (key COLON)?
    private static boolean category_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "category_1")) return false;
        category_1_0(b, l + 1);
        return true;
    }

    // key COLON
    private static boolean category_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "category_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = key(b, l + 1);
        r = r && consumeToken(b, COLON);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L class-item* BRACE_R
    public static boolean class_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && class_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, CLASS_BODY, r);
        return r;
    }

    // class-item*
    private static boolean class_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!class_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "class_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // declare-field
    //   | SEMICOLON
    //   | COMMA
    public static boolean class_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CLASS_ITEM, "<class item>");
        r = declare_field(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_CLASS identifier-free class-body
    public static boolean declare_class(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_CLASS, "<declare class>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_CLASS);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // annotations KW_ENUMERATE identifier-free enumerate-body
    public static boolean declare_enumerate(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enumerate")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_ENUMERATE, "<declare enumerate>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_ENUMERATE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && enumerate_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // attribute* modifier+ type-hint? default-value?
    public static boolean declare_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FIELD, "<declare field>");
        r = declare_field_0(b, l + 1);
        r = r && declare_field_1(b, l + 1);
        r = r && declare_field_2(b, l + 1);
        r = r && declare_field_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // attribute*
    private static boolean declare_field_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_field_0", c)) break;
        }
        return true;
    }

    // modifier+
    private static boolean declare_field_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = modifier(b, l + 1);
        while (r) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_field_1", c)) break;
        }
        exit_section_(b, m, null, r);
        return r;
    }

    // type-hint?
    private static boolean declare_field_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean declare_field_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field_3")) return false;
        default_value(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_FLAGS identifier-free enumerate-body
    public static boolean declare_flags(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FLAGS, "<declare flags>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FLAGS);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && enumerate_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // annotations KW_FUNCTION identifier-free function-parameter function-block
    public static boolean declare_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FUNCTION, "<declare function>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FUNCTION);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, function_parameter(b, l + 1)) && r;
        r = p && function_block(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // annotations KW_INTERFACE identifier-free? group-body
    public static boolean declare_interface(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_interface")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_INTERFACE, "<declare interface>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_INTERFACE);
        p = r; // pin = 2
        r = r && report_error_(b, declare_interface_2(b, l + 1));
        r = p && group_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // identifier-free?
    private static boolean declare_interface_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_interface_2")) return false;
        identifier_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_NAMESPACE namepath-free
    public static boolean declare_namespace(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_namespace")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_NAMESPACE, "<declare namespace>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_NAMESPACE);
        p = r; // pin = 2
        r = r && namepath_free(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // attribute* identifier-free default-value?
    public static boolean declare_semantic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SEMANTIC, "<declare semantic>");
        r = declare_semantic_0(b, l + 1);
        r = r && identifier_free(b, l + 1);
        p = r; // pin = 2
        r = r && declare_semantic_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // attribute*
    private static boolean declare_semantic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_semantic_0", c)) break;
        }
        return true;
    }

    // default-value?
    private static boolean declare_semantic_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic_2")) return false;
        default_value(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_UNITE identifier OP_REMARK? class-body
    public static boolean declare_union(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_union")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNION, "<declare union>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNITE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_union_3(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_REMARK?
    private static boolean declare_union_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_union_3")) return false;
        consumeToken(b, OP_REMARK);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_UNITE identifier OP_REMARK? union-body
    public static boolean declare_unite(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNITE, "<declare unite>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNITE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_unite_3(b, l + 1)) && r;
        r = p && union_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_REMARK?
    private static boolean declare_unite_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite_3")) return false;
        consumeToken(b, OP_REMARK);
        return true;
    }

    /* ********************************************************** */
    // EQUAL expression
    public static boolean default_value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "default_value")) return false;
        if (!nextTokenIs(b, EQUAL)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && expression(b, l + 1);
        exit_section_(b, m, DEFAULT_VALUE, r);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L enumerate-item* BRACE_R
    public static boolean enumerate_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enumerate_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && enumerate_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, ENUMERATE_BODY, r);
        return r;
    }

    // enumerate-item*
    private static boolean enumerate_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enumerate_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!enumerate_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "enumerate_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // declare-semantic
    //   | SEMICOLON
    //   | COMMA
    public static boolean enumerate_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enumerate_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ENUMERATE_ITEM, "<enumerate item>");
        r = declare_semantic(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // ESCAPED category? {
    // }
    public static boolean escape(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "escape")) return false;
        if (!nextTokenIs(b, ESCAPED)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, ESCAPED);
        r = r && escape_1(b, l + 1);
        r = r && escape_2(b, l + 1);
        exit_section_(b, m, ESCAPE, r);
        return r;
    }

    // category?
    private static boolean escape_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "escape_1")) return false;
        category(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean escape_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // term (infix term)* {
    // }
    public static boolean expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
        r = term(b, l + 1);
        r = r && expression_1(b, l + 1);
        r = r && expression_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (infix term)*
    private static boolean expression_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!expression_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
        }
        return true;
    }

    // infix term
    private static boolean expression_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = infix(b, l + 1);
        r = r && term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean expression_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L OP_OR? expression PARENTHESIS_R
    public static boolean expression_group(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_group")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && expression_group_1(b, l + 1);
        r = r && expression(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, EXPRESSION_GROUP, r);
        return r;
    }

    // OP_OR?
    private static boolean expression_group_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_group_1")) return false;
        consumeToken(b, OP_OR);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L OP_OR? expression? BRACE_R
    public static boolean function_block(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_block")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && function_block_1(b, l + 1);
        r = r && function_block_2(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, FUNCTION_BLOCK, r);
        return r;
    }

    // OP_OR?
    private static boolean function_block_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_block_1")) return false;
        consumeToken(b, OP_OR);
        return true;
    }

    // expression?
    private static boolean function_block_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_block_2")) return false;
        expression(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // AT identifier-free tuple?
    public static boolean function_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call")) return false;
        if (!nextTokenIs(b, AT)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, null);
        r = consumeToken(b, AT);
        r = r && identifier_free(b, l + 1);
        p = r; // pin = 2
        r = r && function_call_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // tuple?
    private static boolean function_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_2")) return false;
        tuple(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (parameter (COMMA parameter)* COMMA?)? PARENTHESIS_R
    public static boolean function_parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && function_parameter_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, FUNCTION_PARAMETER, r);
        return r;
    }

    // (parameter (COMMA parameter)* COMMA?)?
    private static boolean function_parameter_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter_1")) return false;
        function_parameter_1_0(b, l + 1);
        return true;
    }

    // parameter (COMMA parameter)* COMMA?
    private static boolean function_parameter_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parameter(b, l + 1);
        r = r && function_parameter_1_0_1(b, l + 1);
        r = r && function_parameter_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA parameter)*
    private static boolean function_parameter_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!function_parameter_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "function_parameter_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA parameter
    private static boolean function_parameter_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean function_parameter_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_parameter_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L group-term* BRACE_R
    public static boolean group_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && group_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, GROUP_BODY, r);
        return r;
    }

    // group-term*
    private static boolean group_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!group_term(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "group_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // attribute* identifier* COLON atomic
    public static boolean group_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GROUP_ITEM, "<group item>");
        r = group_item_0(b, l + 1);
        r = r && group_item_1(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && atomic(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // attribute*
    private static boolean group_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_item_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "group_item_0", c)) break;
        }
        return true;
    }

    // identifier*
    private static boolean group_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_item_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!identifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "group_item_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // group-item | SEMICOLON
    public static boolean group_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "group_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GROUP_TERM, "<group term>");
        r = group_item(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // SYMBOL | SYMBOW_RAW
    public static boolean identifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier")) return false;
        if (!nextTokenIs(b, "<identifier>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOW_RAW);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // SYMBOL | SYMBOW_RAW | KW_MACRO | KW_CLASS | KW_UNION | KW_GROUP | KW_GRAMMAR | KW_IMPORT | KW_AS | KW_CLIMB
    public static boolean identifier_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_FREE, "<identifier free>");
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOW_RAW);
        if (!r) r = consumeToken(b, KW_MACRO);
        if (!r) r = consumeToken(b, KW_CLASS);
        if (!r) r = consumeToken(b, KW_UNION);
        if (!r) r = consumeToken(b, KW_GROUP);
        if (!r) r = consumeToken(b, KW_GRAMMAR);
        if (!r) r = consumeToken(b, KW_IMPORT);
        if (!r) r = consumeToken(b, KW_AS);
        if (!r) r = consumeToken(b, KW_CLIMB);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_CONCAT
    public static boolean infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix")) return false;
        if (!nextTokenIs(b, OP_CONCAT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_CONCAT);
        exit_section_(b, m, INFIX, r);
        return r;
    }

    /* ********************************************************** */
    // identifier-free
    public static boolean key(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "key")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
        r = identifier_free(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // identifier
    public static boolean modifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier")) return false;
        if (!nextTokenIs(b, "<modifier>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
        r = identifier(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // identifier ((DOT) identifier)* {
    // }
    public static boolean namepath(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath")) return false;
        if (!nextTokenIs(b, "<namepath>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
        r = identifier(b, l + 1);
        r = r && namepath_1(b, l + 1);
        r = r && namepath_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // ((DOT) identifier)*
    private static boolean namepath_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
        }
        return true;
    }

    // (DOT) identifier
    private static boolean namepath_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean namepath_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // identifier ((DOT) identifier)*
    public static boolean namepath_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free")) return false;
        if (!nextTokenIs(b, "<namepath free>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH_FREE, "<namepath free>");
        r = identifier(b, l + 1);
        r = r && namepath_free_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // ((DOT) identifier)*
    private static boolean namepath_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_free_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_free_1", c)) break;
        }
        return true;
    }

    // (DOT) identifier
    private static boolean namepath_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // INTEGER {
    // //    mixin = "yggdrasil.psi.mixin.MixinNumber"
    // }
    public static boolean number(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number")) return false;
        if (!nextTokenIs(b, INTEGER)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INTEGER);
        r = r && number_1(b, l + 1);
        exit_section_(b, m, NUMBER, r);
        return r;
    }

    // {
    // //    mixin = "yggdrasil.psi.mixin.MixinNumber"
    // }
    private static boolean number_1(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // key COLON value {
    // //    mixin = "yggdrasil.psi.mixin.MixinTuple"
    // }
    public static boolean pair(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pair")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
        r = key(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && value(b, l + 1);
        r = r && pair_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // {
    // //    mixin = "yggdrasil.psi.mixin.MixinTuple"
    // }
    private static boolean pair_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // identifier (COLON expression)? {
    // }
    public static boolean parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter")) return false;
        if (!nextTokenIs(b, "<parameter>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
        r = identifier(b, l + 1);
        r = r && parameter_1(b, l + 1);
        r = r && parameter_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (COLON expression)?
    private static boolean parameter_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_1")) return false;
        parameter_1_0(b, l + 1);
        return true;
    }

    // COLON expression
    private static boolean parameter_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean parameter_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // OP_NOT | OP_AND | OP_REMARK
    public static boolean prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX, "<prefix>");
        r = consumeToken(b, OP_NOT);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, OP_REMARK);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L COMMA? BRACE_R
    //            | BRACE_L range-lower COMMA? BRACE_R
    //            | BRACE_L COMMA range-upper BRACE_R
    //            | BRACE_L range-upper COMMA range-upper BRACE_R
    public static boolean range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_0(b, l + 1);
        if (!r) r = range_1(b, l + 1);
        if (!r) r = range_2(b, l + 1);
        if (!r) r = range_3(b, l + 1);
        exit_section_(b, m, RANGE, r);
        return r;
    }

    // BRACE_L COMMA? BRACE_R
    private static boolean range_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && range_0_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean range_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_0_1")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // BRACE_L range-lower COMMA? BRACE_R
    private static boolean range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && range_lower(b, l + 1);
        r = r && range_1_2(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean range_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_1_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // BRACE_L COMMA range-upper BRACE_R
    private static boolean range_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, BRACE_L, COMMA);
        r = r && range_upper(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // BRACE_L range-upper COMMA range-upper BRACE_R
    private static boolean range_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && range_upper(b, l + 1);
        r = r && consumeToken(b, COMMA);
        r = r && range_upper(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // INTEGER
    public static boolean range_lower(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_lower")) return false;
        if (!nextTokenIs(b, INTEGER)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INTEGER);
        exit_section_(b, m, RANGE_LOWER, r);
        return r;
    }

    /* ********************************************************** */
    // INTEGER
    public static boolean range_upper(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_upper")) return false;
        if (!nextTokenIs(b, INTEGER)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INTEGER);
        exit_section_(b, m, RANGE_UPPER, r);
        return r;
    }

    /* ********************************************************** */
    // REGULAR_EXPRESSION | REGULAR_RANGE
    public static boolean regex(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "regex")) return false;
        if (!nextTokenIs(b, "<regex>", REGULAR_EXPRESSION, REGULAR_RANGE)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, REGEX, "<regex>");
        r = consumeToken(b, REGULAR_EXPRESSION);
        if (!r) r = consumeToken(b, REGULAR_RANGE);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // statements*
    static boolean root(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "root")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "root", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // declare-namespace
    //   | using
    //   | declare-flags
    //   | declare-enumerate
    //   | declare-unite
    //   | declare-class
    //   | declare-union
    //   | declare-interface
    //   | declare-function
    //   | SEMICOLON
    static boolean statements(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements")) return false;
        boolean r;
        r = declare_namespace(b, l + 1);
        if (!r) r = using(b, l + 1);
        if (!r) r = declare_flags(b, l + 1);
        if (!r) r = declare_enumerate(b, l + 1);
        if (!r) r = declare_unite(b, l + 1);
        if (!r) r = declare_class(b, l + 1);
        if (!r) r = declare_union(b, l + 1);
        if (!r) r = declare_interface(b, l + 1);
        if (!r) r = declare_function(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        return r;
    }

    /* ********************************************************** */
    // TEXT_SINGLE | TEXT_DOUBLE
    public static boolean string(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string")) return false;
        if (!nextTokenIs(b, "<string>", TEXT_DOUBLE, TEXT_SINGLE)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
        r = consumeToken(b, TEXT_SINGLE);
        if (!r) r = consumeToken(b, TEXT_DOUBLE);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_OPTIONAL | OP_MANY | OP_MANY1 | range
    public static boolean suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SUFFIX, "<suffix>");
        r = consumeToken(b, OP_OPTIONAL);
        if (!r) r = consumeToken(b, OP_MANY);
        if (!r) r = consumeToken(b, OP_MANY1);
        if (!r) r = range(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // HASH identifier-free
    public static boolean tag_branch(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tag_branch")) return false;
        if (!nextTokenIs(b, HASH)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, HASH);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, TAG_BRANCH, r);
        return r;
    }

    /* ********************************************************** */
    // prefix* atomic suffix* {
    // }
    public static boolean term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
        r = term_0(b, l + 1);
        r = r && atomic(b, l + 1);
        r = r && term_2(b, l + 1);
        r = r && term_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // prefix*
    private static boolean term_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!prefix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "term_0", c)) break;
        }
        return true;
    }

    // suffix*
    private static boolean term_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!suffix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "term_2", c)) break;
        }
        return true;
    }

    // {
    // }
    private static boolean term_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (argument (COMMA argument)* COMMA?)?  PARENTHESIS_R
    public static boolean tuple(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && tuple_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, TUPLE, r);
        return r;
    }

    // (argument (COMMA argument)* COMMA?)?
    private static boolean tuple_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1")) return false;
        tuple_1_0(b, l + 1);
        return true;
    }

    // argument (COMMA argument)* COMMA?
    private static boolean tuple_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = argument(b, l + 1);
        r = r && tuple_1_0_1(b, l + 1);
        r = r && tuple_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA argument)*
    private static boolean tuple_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!tuple_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "tuple_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA argument
    private static boolean tuple_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean tuple_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // type-term (type-infix type-term)* {
    // }
    public static boolean type_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
        r = type_term(b, l + 1);
        r = r && type_expression_1(b, l + 1);
        r = r && type_expression_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (type-infix type-term)*
    private static boolean type_expression_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_expression_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_expression_1", c)) break;
        }
        return true;
    }

    // type-infix type-term
    private static boolean type_expression_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_infix(b, l + 1);
        r = r && type_term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean type_expression_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // COLON type-expression
    public static boolean type_hint(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_hint")) return false;
        if (!nextTokenIs(b, COLON)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, TYPE_HINT, r);
        return r;
    }

    /* ********************************************************** */
    // OP_CONCAT
    public static boolean type_infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_infix")) return false;
        if (!nextTokenIs(b, OP_CONCAT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_CONCAT);
        exit_section_(b, m, TYPE_INFIX, r);
        return r;
    }

    /* ********************************************************** */
    // OP_NOT | OP_AND | OP_REMARK
    public static boolean type_prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PREFIX, "<type prefix>");
        r = consumeToken(b, OP_NOT);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, OP_REMARK);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_OPTIONAL | OP_MANY | OP_MANY1 | range
    public static boolean type_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_SUFFIX, "<type suffix>");
        r = consumeToken(b, OP_OPTIONAL);
        if (!r) r = consumeToken(b, OP_MANY);
        if (!r) r = consumeToken(b, OP_MANY1);
        if (!r) r = range(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // type-prefix* atomic type-suffix* {
    // }
    public static boolean type_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_TERM, "<type term>");
        r = type_term_0(b, l + 1);
        r = r && atomic(b, l + 1);
        r = r && type_term_2(b, l + 1);
        r = r && type_term_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-prefix*
    private static boolean type_term_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_term_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_prefix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_term_0", c)) break;
        }
        return true;
    }

    // type-suffix*
    private static boolean type_term_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_term_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_suffix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_term_2", c)) break;
        }
        return true;
    }

    // {
    // }
    private static boolean type_term_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // BRACE_L union-variant* BRACE_R
    public static boolean union_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "union_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && union_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, UNION_BODY, r);
        return r;
    }

    // union-variant*
    private static boolean union_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "union_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!union_variant(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "union_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // OP_OR expression tag-branch?
    public static boolean union_variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "union_variant")) return false;
        if (!nextTokenIs(b, OP_OR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_OR);
        r = r && expression(b, l + 1);
        r = r && union_variant_2(b, l + 1);
        exit_section_(b, m, UNION_VARIANT, r);
        return r;
    }

    // tag-branch?
    private static boolean union_variant_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "union_variant_2")) return false;
        tag_branch(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_USING identifier-free (DOT (OP_MANY | using-body))?
    public static boolean using(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, USING, "<using>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_USING);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && using_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (DOT (OP_MANY | using-body))?
    private static boolean using_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_3")) return false;
        using_3_0(b, l + 1);
        return true;
    }

    // DOT (OP_MANY | using-body)
    private static boolean using_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && using_3_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // OP_MANY | using-body
    private static boolean using_3_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_3_0_1")) return false;
        boolean r;
        r = consumeToken(b, OP_MANY);
        if (!r) r = using_body(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // key KW_AS identifier-free
    public static boolean using_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_alias")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_ALIAS, "<using alias>");
        r = key(b, l + 1);
        r = r && consumeToken(b, KW_AS);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L using-term* BRACE_R
    public static boolean using_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && using_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, USING_BODY, r);
        return r;
    }

    // using-term*
    private static boolean using_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!using_term(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "using_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // using-alias
    //   | SEMICOLON
    //   | COMMA
    public static boolean using_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_TERM, "<using term>");
        r = using_alias(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // tuple | expression-tag
    public static boolean value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "value")) return false;
        if (!nextTokenIs(b, "<value>", EXPRESSION_TAG, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
        r = tuple(b, l + 1);
        if (!r) r = consumeToken(b, EXPRESSION_TAG);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

}
