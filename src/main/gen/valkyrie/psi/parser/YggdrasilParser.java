// This is a generated file. Not intended for manual editing.
package valkyrie.psi.parser;

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
            create_token_set_(EXPRESSION, INLINE_EXPRESSION),
            create_token_set_(GENERIC_CALL, GENERIC_CALL_FREE),
            create_token_set_(NAMEPATH, NAMEPATH_FREE),
            create_token_set_(IDENTIFIER, IDENTIFIER_FREE),
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
    // (identifier-free EQUAL)? expression {
    // }
    public static boolean argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
        r = argument_0(b, l + 1);
        r = r && expression(b, l + 1);
        r = r && argument_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (identifier-free EQUAL)?
    private static boolean argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0")) return false;
        argument_0_0(b, l + 1);
        return true;
    }

    // identifier-free EQUAL
    private static boolean argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_free(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean argument_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (argument (COMMA argument)* COMMA?)? PARENTHESIS_R
    public static boolean argument_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && argument_body_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, ARGUMENT_BODY, r);
        return r;
    }

    // (argument (COMMA argument)* COMMA?)?
    private static boolean argument_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body_1")) return false;
        argument_body_1_0(b, l + 1);
        return true;
    }

    // argument (COMMA argument)* COMMA?
    private static boolean argument_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = argument(b, l + 1);
        r = r && argument_body_1_0_1(b, l + 1);
        r = r && argument_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA argument)*
    private static boolean argument_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!argument_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "argument_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA argument
    private static boolean argument_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean argument_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // HASH namepath argument-body?
    public static boolean attribute(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute")) return false;
        if (!nextTokenIs(b, HASH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, null);
        r = consumeToken(b, HASH);
        p = r; // pin = 1
        r = r && report_error_(b, namepath(b, l + 1));
        r = p && attribute_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // argument-body?
    private static boolean attribute_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_2")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // inline-statement*
    public static boolean block_bare(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_bare")) return false;
        Marker m = enter_section_(b, l, _NONE_, BLOCK_BARE, "<block bare>");
        while (true) {
            int c = current_position_(b);
            if (!inline_statement(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "block_bare", c)) break;
        }
        exit_section_(b, l, m, true, false, null);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L block-statement* BRACE_R
    public static boolean block_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && block_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, BLOCK_BODY, r);
        return r;
    }

    // block-statement*
    private static boolean block_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!block_statement(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "block_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // declare-variable
    //   | inline-statement
    static boolean block_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_statement")) return false;
        boolean r;
        r = declare_variable(b, l + 1);
        if (!r) r = inline_statement(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // namepath|number|pattern
    public static boolean case_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_ITEM, "<case item>");
        r = namepath(b, l + 1);
        if (!r) r = number(b, l + 1);
        if (!r) r = pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
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
    // (annotations identifier-free EQUAL)? type-expression
    public static boolean class_inherit(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CLASS_INHERIT, "<class inherit>");
        r = class_inherit_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (annotations identifier-free EQUAL)?
    private static boolean class_inherit_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_0")) return false;
        class_inherit_0_0(b, l + 1);
        return true;
    }

    // annotations identifier-free EQUAL
    private static boolean class_inherit_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (class-inherit (COMMA class-inherit)? COMMA?)? PARENTHESIS_R
    public static boolean class_inherit_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && class_inherit_body_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, CLASS_INHERIT_BODY, r);
        return r;
    }

    // (class-inherit (COMMA class-inherit)? COMMA?)?
    private static boolean class_inherit_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body_1")) return false;
        class_inherit_body_1_0(b, l + 1);
        return true;
    }

    // class-inherit (COMMA class-inherit)? COMMA?
    private static boolean class_inherit_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = class_inherit(b, l + 1);
        r = r && class_inherit_body_1_0_1(b, l + 1);
        r = r && class_inherit_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA class-inherit)?
    private static boolean class_inherit_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body_1_0_1")) return false;
        class_inherit_body_1_0_1_0(b, l + 1);
        return true;
    }

    // COMMA class-inherit
    private static boolean class_inherit_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && class_inherit(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean class_inherit_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // declare-method
    //   | declare-field
    //   | SEMICOLON
    //   | COMMA
    public static boolean class_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CLASS_ITEM, "<class item>");
        r = declare_method(b, l + 1);
        if (!r) r = declare_field(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_RETURN | KW_RESUME | KW_CONTINUE | KW_BREAK | KW_YIELD | KW_THROUGH | KW_RAISE
    public static boolean control_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CONTROL_STATEMENT, "<control statement>");
        r = consumeToken(b, KW_RETURN);
        if (!r) r = consumeToken(b, KW_RESUME);
        if (!r) r = consumeToken(b, KW_CONTINUE);
        if (!r) r = consumeToken(b, KW_BREAK);
        if (!r) r = consumeToken(b, KW_YIELD);
        if (!r) r = consumeToken(b, KW_THROUGH);
        if (!r) r = consumeToken(b, KW_RAISE);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_CLASS identifier-free declare-generic? class-inherit-body? type-hint? class-body
    public static boolean declare_class(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_CLASS, "<declare class>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_CLASS);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, declare_class_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_5(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_class_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // class-inherit-body?
    private static boolean declare_class_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_4")) return false;
        class_inherit_body(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_class_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_5")) return false;
        type_hint(b, l + 1);
        return true;
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
    // annotations identifier-free type-hint? default-value?
    public static boolean declare_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FIELD, "<declare field>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        p = r; // pin = 2
        r = r && report_error_(b, declare_field_2(b, l + 1));
        r = p && declare_field_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
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
    // annotations KW_FUNCTION declare-generic? identifier-free parameter-body return-type? effect-type? block-body
    public static boolean declare_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FUNCTION, "<declare function>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FUNCTION);
        p = r; // pin = 2
        r = r && report_error_(b, declare_function_2(b, l + 1));
        r = p && report_error_(b, identifier_free(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_function_5(b, l + 1)) && r;
        r = p && report_error_(b, declare_function_6(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_function_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_function_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    // effect-type?
    private static boolean declare_function_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_6")) return false;
        effect_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // PROPORTION? GENERIC_L (generic-parameter (COMMA generic-parameter)* COMMA?) GENERIC_R
    //   | PROPORTION? ANGLE_L   (generic-parameter (COMMA generic-parameter)* COMMA?) ANGLE_R
    // {
    // }
    public static boolean declare_generic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_GENERIC, "<declare generic>");
        r = declare_generic_0(b, l + 1);
        if (!r) r = declare_generic_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PROPORTION? GENERIC_L (generic-parameter (COMMA generic-parameter)* COMMA?) GENERIC_R
    private static boolean declare_generic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = declare_generic_0_0(b, l + 1);
        r = r && consumeToken(b, GENERIC_L);
        r = r && declare_generic_0_2(b, l + 1);
        r = r && consumeToken(b, GENERIC_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean declare_generic_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // generic-parameter (COMMA generic-parameter)* COMMA?
    private static boolean declare_generic_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_parameter(b, l + 1);
        r = r && declare_generic_0_2_1(b, l + 1);
        r = r && declare_generic_0_2_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-parameter)*
    private static boolean declare_generic_0_2_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_generic_0_2_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_generic_0_2_1", c)) break;
        }
        return true;
    }

    // COMMA generic-parameter
    private static boolean declare_generic_0_2_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_generic_0_2_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // PROPORTION? ANGLE_L   (generic-parameter (COMMA generic-parameter)* COMMA?) ANGLE_R
    // {
    // }
    private static boolean declare_generic_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = declare_generic_1_0(b, l + 1);
        r = r && consumeToken(b, ANGLE_L);
        r = r && declare_generic_1_2(b, l + 1);
        r = r && consumeToken(b, ANGLE_R);
        r = r && declare_generic_1_4(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean declare_generic_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // generic-parameter (COMMA generic-parameter)* COMMA?
    private static boolean declare_generic_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_parameter(b, l + 1);
        r = r && declare_generic_1_2_1(b, l + 1);
        r = r && declare_generic_1_2_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-parameter)*
    private static boolean declare_generic_1_2_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_generic_1_2_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_generic_1_2_1", c)) break;
        }
        return true;
    }

    // COMMA generic-parameter
    private static boolean declare_generic_1_2_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_generic_1_2_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // {
    // }
    private static boolean declare_generic_1_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations KW_IMPLY identifier-free class-body
    public static boolean declare_imply(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_IMPLY, "<declare imply>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_IMPLY);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // annotations identifier-free declare-generic? parameter-body return-type? effect-type? block-body?
    public static boolean declare_method(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_METHOD, "<declare method>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && declare_method_2(b, l + 1);
        r = r && parameter_body(b, l + 1);
        r = r && declare_method_4(b, l + 1);
        r = r && declare_method_5(b, l + 1);
        r = r && declare_method_6(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // declare-generic?
    private static boolean declare_method_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_method_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_4")) return false;
        return_type(b, l + 1);
        return true;
    }

    // effect-type?
    private static boolean declare_method_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_5")) return false;
        effect_type(b, l + 1);
        return true;
    }

    // block-body?
    private static boolean declare_method_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_6")) return false;
        block_body(b, l + 1);
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
    // annotations identifier-free default-value?
    public static boolean declare_semantic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SEMANTIC, "<declare semantic>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && declare_semantic_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // default-value?
    private static boolean declare_semantic_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic_2")) return false;
        default_value(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_TRAIT identifier-free? type-hint? class-body
    public static boolean declare_trait(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TRAIT, "<declare trait>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        p = r; // pin = 2
        r = r && report_error_(b, declare_trait_2(b, l + 1));
        r = p && report_error_(b, declare_trait_3(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // identifier-free?
    private static boolean declare_trait_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_2")) return false;
        identifier_free(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_trait_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_UNITE identifier-free class-body
    public static boolean declare_union(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_union")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNION, "<declare union>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNITE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
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
    // KW_LET pattern-bare type-hint? EQUAL inline-statement
    public static boolean declare_variable(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variable")) return false;
        if (!nextTokenIs(b, KW_LET)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_VARIABLE, null);
        r = consumeToken(b, KW_LET);
        p = r; // pin = 1
        r = r && report_error_(b, pattern_bare(b, l + 1));
        r = p && report_error_(b, declare_variable_2(b, l + 1)) && r;
        r = p && report_error_(b, consumeToken(b, EQUAL)) && r;
        r = p && inline_statement(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-hint?
    private static boolean declare_variable_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variable_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // EQUAL type-expression
    public static boolean default_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "default_type")) return false;
        if (!nextTokenIs(b, EQUAL)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, DEFAULT_TYPE, r);
        return r;
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
    // OP_AND_THEN? DOT namepath argument-body?
    public static boolean dot_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call")) return false;
        if (!nextTokenIs(b, "<dot call>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL, "<dot call>");
        r = dot_call_0(b, l + 1);
        r = r && consumeToken(b, DOT);
        r = r && namepath(b, l + 1);
        r = r && dot_call_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean dot_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // argument-body?
    private static boolean dot_call_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_3")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT KW_MATCH match-body
    public static boolean dot_call_match(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_match")) return false;
        if (!nextTokenIs(b, "<dot call match>", DOT, OP_AND_THEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_MATCH, "<dot call match>");
        r = dot_call_match_0(b, l + 1);
        r = r && consumeTokens(b, 2, DOT, KW_MATCH);
        p = r; // pin = 3
        r = r && match_body(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_AND_THEN?
    private static boolean dot_call_match_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_match_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    /* ********************************************************** */
    // SLASH type-expression
    public static boolean effect_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "effect_type")) return false;
        if (!nextTokenIs(b, SLASH)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, SLASH);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, EFFECT_TYPE, r);
        return r;
    }

    /* ********************************************************** */
    // KW_ELSE KW_IF inline-expression block-body
    public static boolean else_if_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_if_statement")) return false;
        if (!nextTokenIs(b, KW_ELSE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ELSE_IF_STATEMENT, null);
        r = consumeTokens(b, 2, KW_ELSE, KW_IF);
        p = r; // pin = 2
        r = r && report_error_(b, inline_expression(b, l + 1));
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_ELSE block-body
    public static boolean else_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_statement")) return false;
        if (!nextTokenIs(b, KW_ELSE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, null);
        r = consumeToken(b, KW_ELSE);
        p = r; // pin = 1
        r = r && block_body(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
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
    // KW_FOR pattern-bare KW_IN inline-expression if-condition? block-body otherwise-statement?
    public static boolean for_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement")) return false;
        if (!nextTokenIs(b, KW_FOR)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, null);
        r = consumeToken(b, KW_FOR);
        p = r; // pin = 1
        r = r && report_error_(b, pattern_bare(b, l + 1));
        r = p && report_error_(b, consumeToken(b, KW_IN)) && r;
        r = p && report_error_(b, inline_expression(b, l + 1)) && r;
        r = p && report_error_(b, for_statement_4(b, l + 1)) && r;
        r = p && report_error_(b, block_body(b, l + 1)) && r;
        r = p && for_statement_6(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // if-condition?
    private static boolean for_statement_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement_4")) return false;
        if_condition(b, l + 1);
        return true;
    }

    // otherwise-statement?
    private static boolean for_statement_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement_6")) return false;
        otherwise_statement(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath argument-body
    public static boolean function_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call")) return false;
        if (!nextTokenIs(b, "<function call>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
        r = namepath(b, l + 1);
        r = r && argument_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (annotations identifier-free EQUAL)? type-expression
    public static boolean generic_argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_ARGUMENT, "<generic argument>");
        r = generic_argument_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (annotations identifier-free EQUAL)?
    private static boolean generic_argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_0")) return false;
        generic_argument_0_0(b, l + 1);
        return true;
    }

    // annotations identifier-free EQUAL
    private static boolean generic_argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PROPORTION? generic-call-standard-body | PROPORTION generic-call-ascii-body {
    // }
    public static boolean generic_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call")) return false;
        if (!nextTokenIs(b, "<generic call>", GENERIC_L, PROPORTION)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL, "<generic call>");
        r = generic_call_0(b, l + 1);
        if (!r) r = generic_call_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PROPORTION? generic-call-standard-body
    private static boolean generic_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_0_0(b, l + 1);
        r = r && generic_call_standard_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // PROPORTION generic-call-ascii-body {
    // }
    private static boolean generic_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PROPORTION);
        r = r && generic_call_ascii_body(b, l + 1);
        r = r && generic_call_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean generic_call_1_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // ANGLE_L   (generic-argument (COMMA generic-argument)* COMMA?)? ANGLE_R
    public static boolean generic_call_ascii_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body")) return false;
        if (!nextTokenIs(b, ANGLE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, ANGLE_L);
        r = r && generic_call_ascii_body_1(b, l + 1);
        r = r && consumeToken(b, ANGLE_R);
        exit_section_(b, m, GENERIC_CALL_ASCII_BODY, r);
        return r;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_ascii_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body_1")) return false;
        generic_call_ascii_body_1_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_ascii_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_ascii_body_1_0_1(b, l + 1);
        r = r && generic_call_ascii_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_ascii_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_ascii_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_ascii_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_ascii_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_ascii_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_ascii_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // PROPORTION? generic-call-standard-body | PROPORTION? generic-call-ascii-body
    public static boolean generic_call_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL_FREE, "<generic call free>");
        r = generic_call_free_0(b, l + 1);
        if (!r) r = generic_call_free_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PROPORTION? generic-call-standard-body
    private static boolean generic_call_free_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_0_0(b, l + 1);
        r = r && generic_call_standard_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_free_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // PROPORTION? generic-call-ascii-body
    private static boolean generic_call_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_1_0(b, l + 1);
        r = r && generic_call_ascii_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    /* ********************************************************** */
    // GENERIC_L (generic-argument (COMMA generic-argument)* COMMA?)? GENERIC_R
    public static boolean generic_call_standard_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body")) return false;
        if (!nextTokenIs(b, GENERIC_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, GENERIC_L);
        r = r && generic_call_standard_body_1(b, l + 1);
        r = r && consumeToken(b, GENERIC_R);
        exit_section_(b, m, GENERIC_CALL_STANDARD_BODY, r);
        return r;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_standard_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body_1")) return false;
        generic_call_standard_body_1_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_standard_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_standard_body_1_0_1(b, l + 1);
        r = r && generic_call_standard_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_standard_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_standard_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_standard_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_standard_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_standard_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_standard_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-free type-hint? default-type?
    public static boolean generic_parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_parameter")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_PARAMETER, "<generic parameter>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && generic_parameter_2(b, l + 1);
        r = r && generic_parameter_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-hint?
    private static boolean generic_parameter_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_parameter_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-type?
    private static boolean generic_parameter_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_parameter_3")) return false;
        default_type(b, l + 1);
        return true;
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
    // KW_IF (KW_LET|KW_CASE) pattern EQUAL inline-expression block-body
    public static boolean if_case_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_case_statement")) return false;
        if (!nextTokenIs(b, KW_IF)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, IF_CASE_STATEMENT, null);
        r = consumeToken(b, KW_IF);
        r = r && if_case_statement_1(b, l + 1);
        p = r; // pin = 2
        r = r && report_error_(b, pattern(b, l + 1));
        r = p && report_error_(b, consumeToken(b, EQUAL)) && r;
        r = p && report_error_(b, inline_expression(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // KW_LET|KW_CASE
    private static boolean if_case_statement_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_case_statement_1")) return false;
        boolean r;
        r = consumeToken(b, KW_LET);
        if (!r) r = consumeToken(b, KW_CASE);
        return r;
    }

    /* ********************************************************** */
    // KW_IF inline-expression
    public static boolean if_condition(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_condition")) return false;
        if (!nextTokenIs(b, KW_IF)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, IF_CONDITION, null);
        r = consumeToken(b, KW_IF);
        p = r; // pin = 1
        r = r && inline_expression(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // if-condition block-body else-if-statement* else-statement? {
    // }
    public static boolean if_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_statement")) return false;
        if (!nextTokenIs(b, KW_IF)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = if_condition(b, l + 1);
        r = r && block_body(b, l + 1);
        r = r && if_statement_2(b, l + 1);
        r = r && if_statement_3(b, l + 1);
        r = r && if_statement_4(b, l + 1);
        exit_section_(b, m, IF_STATEMENT, r);
        return r;
    }

    // else-if-statement*
    private static boolean if_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_statement_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!else_if_statement(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "if_statement_2", c)) break;
        }
        return true;
    }

    // else-statement?
    private static boolean if_statement_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_statement_3")) return false;
        else_statement(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean if_statement_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // OP_PLUS | OP_MINUS
    //   | ANGLE_L | ANGLE_R
    //   | OP_AND
    //   | OP_UNTIL
    //   | OP_EQ | OP_NE
    //   | KW_AS
    //   | is_not | KW_IS
    public static boolean infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
        r = consumeToken(b, OP_PLUS);
        if (!r) r = consumeToken(b, OP_MINUS);
        if (!r) r = consumeToken(b, ANGLE_L);
        if (!r) r = consumeToken(b, ANGLE_R);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, OP_UNTIL);
        if (!r) r = consumeToken(b, OP_EQ);
        if (!r) r = consumeToken(b, OP_NE);
        if (!r) r = consumeToken(b, KW_AS);
        if (!r) r = is_not(b, l + 1);
        if (!r) r = consumeToken(b, KW_IS);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // term (infix term)*
    public static boolean inline_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_EXPRESSION, "<inline expression>");
        r = term(b, l + 1);
        r = r && inline_expression_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (infix term)*
    private static boolean inline_expression_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_expression_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!inline_expression_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "inline_expression_1", c)) break;
        }
        return true;
    }

    // infix term
    private static boolean inline_expression_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_expression_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = infix(b, l + 1);
        r = r && term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // if-case-statement
    //   | if-statement
    //   | while-statement
    //   | for-statement
    //   | try-statement
    //   | match-statement
    //   | new-value
    //   | new-object
    //   | new-lambda
    //   | expression
    //   | SEMICOLON
    static boolean inline_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_statement")) return false;
        boolean r;
        r = if_case_statement(b, l + 1);
        if (!r) r = if_statement(b, l + 1);
        if (!r) r = while_statement(b, l + 1);
        if (!r) r = for_statement(b, l + 1);
        if (!r) r = try_statement(b, l + 1);
        if (!r) r = match_statement(b, l + 1);
        if (!r) r = new_value(b, l + 1);
        if (!r) r = new_object(b, l + 1);
        if (!r) r = new_lambda(b, l + 1);
        if (!r) r = expression(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        return r;
    }

    /* ********************************************************** */
    // KW_IS KW_NOT | OP_BANG KW_IS
    public static boolean is_not(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "is_not")) return false;
        if (!nextTokenIs(b, "<is not>", KW_IS, OP_BANG)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IS_NOT, "<is not>");
        r = parseTokens(b, 0, KW_IS, KW_NOT);
        if (!r) r = parseTokens(b, 0, OP_BANG, KW_IS);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L expression PARENTHESIS_R
    //   | macro-call
    //   | function-call
    //   | special
    //   | namepath
    //   | string
    //   | number
    //   | ordinal-range
    //   | offset-range
    public static boolean literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "literal")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
        r = literal_0(b, l + 1);
        if (!r) r = macro_call(b, l + 1);
        if (!r) r = function_call(b, l + 1);
        if (!r) r = special(b, l + 1);
        if (!r) r = namepath(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = number(b, l + 1);
        if (!r) r = ordinal_range(b, l + 1);
        if (!r) r = offset_range(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L expression PARENTHESIS_R
    private static boolean literal_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "literal_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && expression(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // AT namepath argument-body?
    public static boolean macro_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call")) return false;
        if (!nextTokenIs(b, AT)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MACRO_CALL, null);
        r = consumeToken(b, AT);
        p = r; // pin = 1
        r = r && report_error_(b, namepath(b, l + 1));
        r = p && macro_call_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // argument-body?
    private static boolean macro_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L match-item* BRACE_R
    public static boolean match_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && match_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, MATCH_BODY, r);
        return r;
    }

    // match-item*
    private static boolean match_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!match_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "match_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // KW_CASE case-item COLON block-bare
    public static boolean match_case(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case")) return false;
        if (!nextTokenIs(b, KW_CASE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, null);
        r = consumeToken(b, KW_CASE);
        p = r; // pin = 1
        r = r && report_error_(b, case_item(b, l + 1));
        r = p && report_error_(b, consumeToken(b, COLON)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_ELSE COLON block-bare
    public static boolean match_else(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_else")) return false;
        if (!nextTokenIs(b, KW_ELSE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_ELSE, null);
        r = consumeTokens(b, 1, KW_ELSE, COLON);
        p = r; // pin = 1
        r = r && block_bare(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // match-with
    //   | match-case
    //   | match-when
    //   | match-else
    public static boolean match_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MATCH_ITEM, "<match item>");
        r = match_with(b, l + 1);
        if (!r) r = match_case(b, l + 1);
        if (!r) r = match_when(b, l + 1);
        if (!r) r = match_else(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_MATCH inline-expression match-body
    public static boolean match_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement")) return false;
        if (!nextTokenIs(b, KW_MATCH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_STATEMENT, null);
        r = consumeToken(b, KW_MATCH);
        p = r; // pin = 1
        r = r && report_error_(b, inline_expression(b, l + 1));
        r = p && match_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_WHEN inline-expression COLON block-bare
    public static boolean match_when(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_when")) return false;
        if (!nextTokenIs(b, KW_WHEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_WHEN, null);
        r = consumeToken(b, KW_WHEN);
        p = r; // pin = 1
        r = r && report_error_(b, inline_expression(b, l + 1));
        r = p && report_error_(b, consumeToken(b, COLON)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_WITH pattern COLON block-bare
    public static boolean match_with(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_with")) return false;
        if (!nextTokenIs(b, KW_WITH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_WITH, null);
        r = consumeToken(b, KW_WITH);
        p = r; // pin = 1
        r = r && report_error_(b, pattern(b, l + 1));
        r = p && report_error_(b, consumeToken(b, COLON)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // identifier !modifier-stop
    public static boolean modifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier")) return false;
        if (!nextTokenIs(b, "<modifier>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
        r = identifier(b, l + 1);
        r = r && modifier_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // !modifier-stop
    private static boolean modifier_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_1")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !modifier_stop(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_IN
    //     | COMMA | COLON | PROPORTION | DOT | SEMICOLON | EQUAL
    //     | PARENTHESIS_L | PARENTHESIS_R
    //     | BRACE_L | BRACE_R
    static boolean modifier_stop(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_stop")) return false;
        boolean r;
        r = consumeToken(b, KW_IN);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, PROPORTION);
        if (!r) r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, EQUAL);
        if (!r) r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, PARENTHESIS_R);
        if (!r) r = consumeToken(b, BRACE_L);
        if (!r) r = consumeToken(b, BRACE_R);
        return r;
    }

    /* ********************************************************** */
    // identifier (PROPORTION identifier)*
    public static boolean namepath(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath")) return false;
        if (!nextTokenIs(b, "<namepath>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
        r = identifier(b, l + 1);
        r = r && namepath_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (PROPORTION identifier)*
    private static boolean namepath_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
        }
        return true;
    }

    // PROPORTION identifier
    private static boolean namepath_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PROPORTION);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // identifier ((PROPORTION|DOT) identifier)*
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

    // ((PROPORTION|DOT) identifier)*
    private static boolean namepath_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_free_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_free_1", c)) break;
        }
        return true;
    }

    // (PROPORTION|DOT) identifier
    private static boolean namepath_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = namepath_free_1_0_0(b, l + 1);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION|DOT
    private static boolean namepath_free_1_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1_0_0")) return false;
        boolean r;
        r = consumeToken(b, PROPORTION);
        if (!r) r = consumeToken(b, DOT);
        return r;
    }

    /* ********************************************************** */
    // KW_LAMBDA
    public static boolean new_lambda(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda")) return false;
        if (!nextTokenIs(b, KW_LAMBDA)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_LAMBDA);
        exit_section_(b, m, NEW_LAMBDA, r);
        return r;
    }

    /* ********************************************************** */
    // KW_OBJECT type-hint?
    public static boolean new_object(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object")) return false;
        if (!nextTokenIs(b, KW_OBJECT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_OBJECT);
        r = r && new_object_1(b, l + 1);
        exit_section_(b, m, NEW_OBJECT, r);
        return r;
    }

    // type-hint?
    private static boolean new_object_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object_1")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_NEW type-expression
    public static boolean new_value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value")) return false;
        if (!nextTokenIs(b, KW_NEW)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_NEW);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, NEW_VALUE, r);
        return r;
    }

    /* ********************************************************** */
    // INTEGER {
    // //    mixin = "valkyrie.psi.mixin.MixinNumber"
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
    // //    mixin = "valkyrie.psi.mixin.MixinNumber"
    // }
    private static boolean number_1(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // OFFSET_L (range-item (COMMA range-item)? COMMA?) OFFSET_R
    public static boolean offset_range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range")) return false;
        if (!nextTokenIs(b, OFFSET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OFFSET_L);
        r = r && offset_range_1(b, l + 1);
        r = r && consumeToken(b, OFFSET_R);
        exit_section_(b, m, OFFSET_RANGE, r);
        return r;
    }

    // range-item (COMMA range-item)? COMMA?
    private static boolean offset_range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item(b, l + 1);
        r = r && offset_range_1_1(b, l + 1);
        r = r && offset_range_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA range-item)?
    private static boolean offset_range_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_1")) return false;
        offset_range_1_1_0(b, l + 1);
        return true;
    }

    // COMMA range-item
    private static boolean offset_range_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && range_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean offset_range_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L (range-item (COMMA range-item)? COMMA?) BRACE_R
    public static boolean ordinal_range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && ordinal_range_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, ORDINAL_RANGE, r);
        return r;
    }

    // range-item (COMMA range-item)? COMMA?
    private static boolean ordinal_range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item(b, l + 1);
        r = r && ordinal_range_1_1(b, l + 1);
        r = r && ordinal_range_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA range-item)?
    private static boolean ordinal_range_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_1")) return false;
        ordinal_range_1_1_0(b, l + 1);
        return true;
    }

    // COMMA range-item
    private static boolean ordinal_range_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && range_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean ordinal_range_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // KW_OTHERWISE|KW_ELSE
    public static boolean otherwise_kind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "otherwise_kind")) return false;
        if (!nextTokenIs(b, "<otherwise kind>", KW_ELSE, KW_OTHERWISE)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, OTHERWISE_KIND, "<otherwise kind>");
        r = consumeToken(b, KW_OTHERWISE);
        if (!r) r = consumeToken(b, KW_ELSE);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // otherwise-kind block-body
    public static boolean otherwise_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "otherwise_statement")) return false;
        if (!nextTokenIs(b, "<otherwise statement>", KW_ELSE, KW_OTHERWISE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, OTHERWISE_STATEMENT, "<otherwise statement>");
        r = otherwise_kind(b, l + 1);
        p = r; // pin = 1
        r = r && block_body(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (parameter-item (COMMA parameter-item)* COMMA?)? PARENTHESIS_R
    public static boolean parameter_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && parameter_body_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, PARAMETER_BODY, r);
        return r;
    }

    // (parameter-item (COMMA parameter-item)* COMMA?)?
    private static boolean parameter_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body_1")) return false;
        parameter_body_1_0(b, l + 1);
        return true;
    }

    // parameter-item (COMMA parameter-item)* COMMA?
    private static boolean parameter_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parameter_item(b, l + 1);
        r = r && parameter_body_1_0_1(b, l + 1);
        r = r && parameter_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA parameter-item)*
    private static boolean parameter_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!parameter_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "parameter_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA parameter-item
    private static boolean parameter_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && parameter_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean parameter_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // identifier type-hint? default-value? {
    // }
    public static boolean parameter_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item")) return false;
        if (!nextTokenIs(b, "<parameter item>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER_ITEM, "<parameter item>");
        r = identifier(b, l + 1);
        r = r && parameter_item_1(b, l + 1);
        r = r && parameter_item_2(b, l + 1);
        r = r && parameter_item_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-hint?
    private static boolean parameter_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_1")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean parameter_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_2")) return false;
        default_value(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean parameter_item_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // pattern-unapply
    //   | pattern-sequence
    //   | pattern-object
    //   | pattern-literal
    public static boolean pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
        r = pattern_unapply(b, l + 1);
        if (!r) r = pattern_sequence(b, l + 1);
        if (!r) r = pattern_object(b, l + 1);
        if (!r) r = pattern_literal(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // pattern-literal (COMMA pattern-literal)* COMMA? !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    //   | pattern-unapply
    //   | pattern-sequence
    //   | pattern-object
    public static boolean pattern_bare(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_BARE, "<pattern bare>");
        r = pattern_bare_0(b, l + 1);
        if (!r) r = pattern_unapply(b, l + 1);
        if (!r) r = pattern_sequence(b, l + 1);
        if (!r) r = pattern_object(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // pattern-literal (COMMA pattern-literal)* COMMA? !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    private static boolean pattern_bare_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = pattern_literal(b, l + 1);
        r = r && pattern_bare_0_1(b, l + 1);
        r = r && pattern_bare_0_2(b, l + 1);
        r = r && pattern_bare_0_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA pattern-literal)*
    private static boolean pattern_bare_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!pattern_bare_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "pattern_bare_0_1", c)) break;
        }
        return true;
    }

    // COMMA pattern-literal
    private static boolean pattern_bare_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && pattern_literal(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean pattern_bare_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    private static boolean pattern_bare_0_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0_3")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !pattern_bare_0_3_0(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L|BRACKET_L|BRACE_L
    private static boolean pattern_bare_0_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_0_3_0")) return false;
        boolean r;
        r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, BRACKET_L);
        if (!r) r = consumeToken(b, BRACE_L);
        return r;
    }

    /* ********************************************************** */
    // annotations (identifier-free|string|special)
    public static boolean pattern_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_literal")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_LITERAL, "<pattern literal>");
        r = annotations(b, l + 1);
        r = r && pattern_literal_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier-free|string|special
    private static boolean pattern_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_literal_1")) return false;
        boolean r;
        r = identifier_free(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = special(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // annotations namepath-free? pattern-object-body
    public static boolean pattern_object(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_OBJECT, "<pattern object>");
        r = annotations(b, l + 1);
        r = r && pattern_object_1(b, l + 1);
        r = r && pattern_object_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-free?
    private static boolean pattern_object_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_1")) return false;
        namepath_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L (pattern-pair (COMMA pattern-pair)* COMMA?)? BRACE_R
    public static boolean pattern_object_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_OBJECT_BODY, null);
        r = consumeToken(b, BRACE_L);
        p = r; // pin = 1
        r = r && report_error_(b, pattern_object_body_1(b, l + 1));
        r = p && consumeToken(b, BRACE_R) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (pattern-pair (COMMA pattern-pair)* COMMA?)?
    private static boolean pattern_object_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body_1")) return false;
        pattern_object_body_1_0(b, l + 1);
        return true;
    }

    // pattern-pair (COMMA pattern-pair)* COMMA?
    private static boolean pattern_object_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = pattern_pair(b, l + 1);
        r = r && pattern_object_body_1_0_1(b, l + 1);
        r = r && pattern_object_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA pattern-pair)*
    private static boolean pattern_object_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!pattern_object_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "pattern_object_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA pattern-pair
    private static boolean pattern_object_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && pattern_pair(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean pattern_object_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_object_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-free COLON pattern
    public static boolean pattern_pair(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_pair")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_PAIR, "<pattern pair>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // pattern-sequence-body
    public static boolean pattern_sequence(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = pattern_sequence_body(b, l + 1);
        exit_section_(b, m, PATTERN_SEQUENCE, r);
        return r;
    }

    /* ********************************************************** */
    // BRACKET_L (pattern (COMMA pattern)* COMMA?)? BRACKET_R
    public static boolean pattern_sequence_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_SEQUENCE_BODY, null);
        r = consumeToken(b, BRACKET_L);
        p = r; // pin = 1
        r = r && report_error_(b, pattern_sequence_body_1(b, l + 1));
        r = p && consumeToken(b, BRACKET_R) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (pattern (COMMA pattern)* COMMA?)?
    private static boolean pattern_sequence_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body_1")) return false;
        pattern_sequence_body_1_0(b, l + 1);
        return true;
    }

    // pattern (COMMA pattern)* COMMA?
    private static boolean pattern_sequence_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = pattern(b, l + 1);
        r = r && pattern_sequence_body_1_0_1(b, l + 1);
        r = r && pattern_sequence_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA pattern)*
    private static boolean pattern_sequence_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!pattern_sequence_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "pattern_sequence_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA pattern
    private static boolean pattern_sequence_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean pattern_sequence_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_sequence_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations namepath-free? pattern-unapply-body
    public static boolean pattern_unapply(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_UNAPPLY, "<pattern unapply>");
        r = annotations(b, l + 1);
        r = r && pattern_unapply_1(b, l + 1);
        r = r && pattern_unapply_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-free?
    private static boolean pattern_unapply_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_1")) return false;
        namepath_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (pattern (COMMA pattern)* COMMA?)? PARENTHESIS_R
    public static boolean pattern_unapply_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_UNAPPLY_BODY, null);
        r = consumeToken(b, PARENTHESIS_L);
        p = r; // pin = 1
        r = r && report_error_(b, pattern_unapply_body_1(b, l + 1));
        r = p && consumeToken(b, PARENTHESIS_R) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (pattern (COMMA pattern)* COMMA?)?
    private static boolean pattern_unapply_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body_1")) return false;
        pattern_unapply_body_1_0(b, l + 1);
        return true;
    }

    // pattern (COMMA pattern)* COMMA?
    private static boolean pattern_unapply_body_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = pattern(b, l + 1);
        r = r && pattern_unapply_body_1_0_1(b, l + 1);
        r = r && pattern_unapply_body_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA pattern)*
    private static boolean pattern_unapply_body_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!pattern_unapply_body_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "pattern_unapply_body_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA pattern
    private static boolean pattern_unapply_body_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean pattern_unapply_body_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_unapply_body_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // OP_PLUS | OP_MINUS | OP_BANG
    public static boolean prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX, "<prefix>");
        r = consumeToken(b, OP_PLUS);
        if (!r) r = consumeToken(b, OP_MINUS);
        if (!r) r = consumeToken(b, OP_BANG);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // expression
    public static boolean range_index(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_index")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_INDEX, "<range index>");
        r = expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // range-index
    //              | range-lower COLON range-upper?
    //              | range-lower COLON COLON range-step?
    //              | range-lower COLON range-upper COLON range-step?
    //              | COLON range-upper?
    //              | COLON COLON range-step?
    //              | COLON range-upper COLON range-step?
    public static boolean range_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_ITEM, "<range item>");
        r = range_index(b, l + 1);
        if (!r) r = range_item_1(b, l + 1);
        if (!r) r = range_item_2(b, l + 1);
        if (!r) r = range_item_3(b, l + 1);
        if (!r) r = range_item_4(b, l + 1);
        if (!r) r = range_item_5(b, l + 1);
        if (!r) r = range_item_6(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // range-lower COLON range-upper?
    private static boolean range_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_lower(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-upper?
    private static boolean range_item_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_1_2")) return false;
        range_upper(b, l + 1);
        return true;
    }

    // range-lower COLON COLON range-step?
    private static boolean range_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_lower(b, l + 1);
        r = r && consumeTokens(b, 0, COLON, COLON);
        r = r && range_item_2_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-step?
    private static boolean range_item_2_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_2_3")) return false;
        range_step(b, l + 1);
        return true;
    }

    // range-lower COLON range-upper COLON range-step?
    private static boolean range_item_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_lower(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_upper(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_3_4(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-step?
    private static boolean range_item_3_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_3_4")) return false;
        range_step(b, l + 1);
        return true;
    }

    // COLON range-upper?
    private static boolean range_item_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_4")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && range_item_4_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-upper?
    private static boolean range_item_4_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_4_1")) return false;
        range_upper(b, l + 1);
        return true;
    }

    // COLON COLON range-step?
    private static boolean range_item_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_5")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, COLON, COLON);
        r = r && range_item_5_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-step?
    private static boolean range_item_5_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_5_2")) return false;
        range_step(b, l + 1);
        return true;
    }

    // COLON range-upper COLON range-step?
    private static boolean range_item_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_6")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && range_upper(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_6_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-step?
    private static boolean range_item_6_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_6_3")) return false;
        range_step(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // expression
    public static boolean range_lower(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_lower")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_LOWER, "<range lower>");
        r = expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // expression
    public static boolean range_step(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_step")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_STEP, "<range step>");
        r = expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // expression
    public static boolean range_upper(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_upper")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_UPPER, "<range upper>");
        r = expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (OP_ARROW1|COLON) type-expression
    public static boolean return_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "return_type")) return false;
        if (!nextTokenIs(b, "<return type>", COLON, OP_ARROW1)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RETURN_TYPE, "<return type>");
        r = return_type_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_ARROW1|COLON
    private static boolean return_type_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "return_type_0")) return false;
        boolean r;
        r = consumeToken(b, OP_ARROW1);
        if (!r) r = consumeToken(b, COLON);
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
    // KW_NULL | KW_NIL | KW_TRUE | KW_FALSE | COLOR
    public static boolean special(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "special")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SPECIAL, "<special>");
        r = consumeToken(b, KW_NULL);
        if (!r) r = consumeToken(b, KW_NIL);
        if (!r) r = consumeToken(b, KW_TRUE);
        if (!r) r = consumeToken(b, KW_FALSE);
        if (!r) r = consumeToken(b, COLOR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // declare-namespace
    //   | using
    //   | type-alias
    //   | trait-alias
    //   | declare-flags
    //   | declare-enumerate
    //   | declare-unite
    //   | declare-class
    //   | declare-union
    //   | declare-trait
    //   | declare-imply
    //   | declare-function
    //   | block-statement
    static boolean statements(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements")) return false;
        boolean r;
        r = declare_namespace(b, l + 1);
        if (!r) r = using(b, l + 1);
        if (!r) r = type_alias(b, l + 1);
        if (!r) r = trait_alias(b, l + 1);
        if (!r) r = declare_flags(b, l + 1);
        if (!r) r = declare_enumerate(b, l + 1);
        if (!r) r = declare_unite(b, l + 1);
        if (!r) r = declare_class(b, l + 1);
        if (!r) r = declare_union(b, l + 1);
        if (!r) r = declare_trait(b, l + 1);
        if (!r) r = declare_imply(b, l + 1);
        if (!r) r = declare_function(b, l + 1);
        if (!r) r = block_statement(b, l + 1);
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
    // OP_BANG | OP_AND_THEN | dot-call | dot-call-match | generic-call
    public static boolean suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SUFFIX, "<suffix>");
        r = consumeToken(b, OP_BANG);
        if (!r) r = consumeToken(b, OP_AND_THEN);
        if (!r) r = dot_call(b, l + 1);
        if (!r) r = dot_call_match(b, l + 1);
        if (!r) r = generic_call(b, l + 1);
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
    // prefix* literal suffix* {
    // }
    public static boolean term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
        r = term_0(b, l + 1);
        r = r && literal(b, l + 1);
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
    // annotations KW_TRAIT identifier-free EQUAL type-expression
    public static boolean trait_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_alias")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRAIT_ALIAS, "<trait alias>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        r = r && identifier_free(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        p = r; // pin = 4
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_TRY type-expression? block-body
    public static boolean try_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_statement")) return false;
        if (!nextTokenIs(b, KW_TRY)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRY_STATEMENT, null);
        r = consumeToken(b, KW_TRY);
        p = r; // pin = 1
        r = r && report_error_(b, try_statement_1(b, l + 1));
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-expression?
    private static boolean try_statement_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_statement_1")) return false;
        type_expression(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L PARENTHESIS_R
    //   | PARENTHESIS_L argument COMMA PARENTHESIS_R
    //   | PARENTHESIS_L (argument (COMMA argument)+ COMMA?)? PARENTHESIS_R
    // {
    //   //    mixin = "valkyrie.psi.mixin.MixinTuple"
    // }
    public static boolean tuple(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parseTokens(b, 0, PARENTHESIS_L, PARENTHESIS_R);
        if (!r) r = tuple_1(b, l + 1);
        if (!r) r = tuple_2(b, l + 1);
        exit_section_(b, m, TUPLE, r);
        return r;
    }

    // PARENTHESIS_L argument COMMA PARENTHESIS_R
    private static boolean tuple_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && argument(b, l + 1);
        r = r && consumeTokens(b, 0, COMMA, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PARENTHESIS_L (argument (COMMA argument)+ COMMA?)? PARENTHESIS_R
    // {
    //   //    mixin = "valkyrie.psi.mixin.MixinTuple"
    // }
    private static boolean tuple_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && tuple_2_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        r = r && tuple_2_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (argument (COMMA argument)+ COMMA?)?
    private static boolean tuple_2_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2_1")) return false;
        tuple_2_1_0(b, l + 1);
        return true;
    }

    // argument (COMMA argument)+ COMMA?
    private static boolean tuple_2_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = argument(b, l + 1);
        r = r && tuple_2_1_0_1(b, l + 1);
        r = r && tuple_2_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA argument)+
    private static boolean tuple_2_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2_1_0_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = tuple_2_1_0_1_0(b, l + 1);
        while (r) {
            int c = current_position_(b);
            if (!tuple_2_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "tuple_2_1_0_1", c)) break;
        }
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA argument
    private static boolean tuple_2_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean tuple_2_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_2_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // {
    //   //    mixin = "valkyrie.psi.mixin.MixinTuple"
    // }
    private static boolean tuple_2_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations KW_TYPE identifier-free EQUAL type-expression
    public static boolean type_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_alias")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS, "<type alias>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TYPE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, consumeToken(b, EQUAL)) && r;
        r = p && type_expression(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // namepath | string
    public static boolean type_atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_ATOMIC, "<type atomic>");
        r = namepath(b, l + 1);
        if (!r) r = string(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // type-term (type-infix type-term)*
    public static boolean type_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
        r = type_term(b, l + 1);
        r = r && type_expression_1(b, l + 1);
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
    // OP_PLUS | OP_ARROW1 | OP_OR
    public static boolean type_infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_INFIX, "<type infix>");
        r = consumeToken(b, OP_PLUS);
        if (!r) r = consumeToken(b, OP_ARROW1);
        if (!r) r = consumeToken(b, OP_OR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_PLUS | OP_MINUS | OP_BANG
    public static boolean type_prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PREFIX, "<type prefix>");
        r = consumeToken(b, OP_PLUS);
        if (!r) r = consumeToken(b, OP_MINUS);
        if (!r) r = consumeToken(b, OP_BANG);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_AND_THEN | generic-call-free
    public static boolean type_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_SUFFIX, "<type suffix>");
        r = consumeToken(b, OP_AND_THEN);
        if (!r) r = generic_call_free(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // type-prefix* type-atomic type-suffix* {
    // }
    public static boolean type_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_TERM, "<type term>");
        r = type_term_0(b, l + 1);
        r = r && type_atomic(b, l + 1);
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
    // annotations KW_USING (using-body|using-term)
    public static boolean using(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, USING, "<using>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_USING);
        p = r; // pin = 2
        r = r && using_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // using-body|using-term
    private static boolean using_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_2")) return false;
        boolean r;
        r = using_body(b, l + 1);
        if (!r) r = using_term(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // identifier-free KW_AS identifier-free
    public static boolean using_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_alias")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_ALIAS, "<using alias>");
        r = identifier_free(b, l + 1);
        r = r && consumeToken(b, KW_AS);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (namepath-free using-dot?) STAR using-exclude?
    public static boolean using_any(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any")) return false;
        if (!nextTokenIs(b, "<using any>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_ANY, "<using any>");
        r = using_any_0(b, l + 1);
        r = r && consumeToken(b, STAR);
        r = r && using_any_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-free using-dot?
    private static boolean using_any_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = namepath_free(b, l + 1);
        r = r && using_any_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // using-dot?
    private static boolean using_any_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any_0_1")) return false;
        using_dot(b, l + 1);
        return true;
    }

    // using-exclude?
    private static boolean using_any_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any_2")) return false;
        using_exclude(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath-free using-dot? using-body
    public static boolean using_block(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_block")) return false;
        if (!nextTokenIs(b, "<using block>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_BLOCK, "<using block>");
        r = namepath_free(b, l + 1);
        r = r && using_block_1(b, l + 1);
        r = r && using_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // using-dot?
    private static boolean using_block_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_block_1")) return false;
        using_dot(b, l + 1);
        return true;
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
    // DOT|PROPORTION|OP_DIV
    static boolean using_dot(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_dot")) return false;
        boolean r;
        r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, PROPORTION);
        if (!r) r = consumeToken(b, OP_DIV);
        return r;
    }

    /* ********************************************************** */
    // KW_EXCLUDE (identifier-free|BRACE_L (identifier-free (COMMA identifier-free)* COMMA?) BRACE_R)
    public static boolean using_exclude(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude")) return false;
        if (!nextTokenIs(b, KW_EXCLUDE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_EXCLUDE);
        r = r && using_exclude_1(b, l + 1);
        exit_section_(b, m, USING_EXCLUDE, r);
        return r;
    }

    // identifier-free|BRACE_L (identifier-free (COMMA identifier-free)* COMMA?) BRACE_R
    private static boolean using_exclude_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_free(b, l + 1);
        if (!r) r = using_exclude_1_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // BRACE_L (identifier-free (COMMA identifier-free)* COMMA?) BRACE_R
    private static boolean using_exclude_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && using_exclude_1_1_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // identifier-free (COMMA identifier-free)* COMMA?
    private static boolean using_exclude_1_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_free(b, l + 1);
        r = r && using_exclude_1_1_1_1(b, l + 1);
        r = r && using_exclude_1_1_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier-free)*
    private static boolean using_exclude_1_1_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!using_exclude_1_1_1_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "using_exclude_1_1_1_1", c)) break;
        }
        return true;
    }

    // COMMA identifier-free
    private static boolean using_exclude_1_1_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean using_exclude_1_1_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // using-any
    //   | using-alias
    //   | using-block
    //   | namepath-free
    //   | SEMICOLON
    //   | COMMA
    public static boolean using_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_TERM, "<using term>");
        r = using_any(b, l + 1);
        if (!r) r = using_alias(b, l + 1);
        if (!r) r = using_block(b, l + 1);
        if (!r) r = namepath_free(b, l + 1);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_WHILE inline-expression block-body otherwise-statement?
    public static boolean while_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "while_statement")) return false;
        if (!nextTokenIs(b, KW_WHILE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, null);
        r = consumeToken(b, KW_WHILE);
        p = r; // pin = 1
        r = r && report_error_(b, inline_expression(b, l + 1));
        r = p && report_error_(b, block_body(b, l + 1)) && r;
        r = p && while_statement_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // otherwise-statement?
    private static boolean while_statement_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "while_statement_3")) return false;
        otherwise_statement(b, l + 1);
        return true;
    }

}
