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
            create_token_set_(NAMEPATH, NAMEPATH_FREE),
    };

    /* ********************************************************** */
    // attribute-below* modifier*
    public static boolean annotations(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "annotations")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ANNOTATIONS, "<annotations>");
        r = annotations_0(b, l + 1);
        r = r && annotations_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // attribute-below*
    private static boolean annotations_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "annotations_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
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
    // (identifier EQUAL)? expression-root {
    // }
    public static boolean argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
        r = argument_0(b, l + 1);
        r = r && expression_root(b, l + 1);
        r = r && argument_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (identifier EQUAL)?
    private static boolean argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0")) return false;
        argument_0_0(b, l + 1);
        return true;
    }

    // identifier EQUAL
    private static boolean argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
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
    // PARENTHESIS_L expression-root PARENTHESIS_R
    //   | tuple           // ( )
    //   | lambda-block    // { }
    //   | ordinal-range   // [ ]
    //   | offset-range    // ⁅ ⁆
    //   | for-statement   // for ... {...}
    //   | while-statement // while/until {...}
    //   | try-statement   // try T {...}
    //   | control-raise   // raise T
    //   | match-statement // match ... { ... }
    //   | new-value       // new T { ... }
    //   | new-object      // object(base): Interface { }
    //   | macro-call      // @path::id() { }
    //   | slot            // $id
    //   | localize-call   // ⸿scope.path
    //   | function-call   // path::id() { }
    //   | literal
    public static boolean atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ATOMIC, "<atomic>");
        r = atomic_0(b, l + 1);
        if (!r) r = tuple(b, l + 1);
        if (!r) r = lambda_block(b, l + 1);
        if (!r) r = ordinal_range(b, l + 1);
        if (!r) r = offset_range(b, l + 1);
        if (!r) r = for_statement(b, l + 1);
        if (!r) r = while_statement(b, l + 1);
        if (!r) r = try_statement(b, l + 1);
        if (!r) r = control_raise(b, l + 1);
        if (!r) r = match_statement(b, l + 1);
        if (!r) r = new_value(b, l + 1);
        if (!r) r = new_object(b, l + 1);
        if (!r) r = macro_call(b, l + 1);
        if (!r) r = slot(b, l + 1);
        if (!r) r = localize_call(b, l + 1);
        if (!r) r = function_call(b, l + 1);
        if (!r) r = literal(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L expression-root PARENTHESIS_R
    private static boolean atomic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // HASH OP_POW attribute-item
    public static boolean attribute_above(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_above")) return false;
        if (!nextTokenIs(b, HASH)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, HASH, OP_POW);
        r = r && attribute_item(b, l + 1);
        exit_section_(b, m, ATTRIBUTE_ABOVE, r);
        return r;
    }

    /* ********************************************************** */
    // HASH attribute-item
    public static boolean attribute_below(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_below")) return false;
        if (!nextTokenIs(b, HASH)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, HASH);
        r = r && attribute_item(b, l + 1);
        exit_section_(b, m, ATTRIBUTE_BELOW, r);
        return r;
    }

    /* ********************************************************** */
    // namepath argument-body? class-body?
    public static boolean attribute_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_ITEM, "<attribute item>");
        r = namepath(b, l + 1);
        r = r && attribute_item_1(b, l + 1);
        r = r && attribute_item_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // argument-body?
    private static boolean attribute_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_1")) return false;
        argument_body(b, l + 1);
        return true;
    }

    // class-body?
    private static boolean attribute_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_2")) return false;
        class_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // ANGLE_L ANGLE_L
    public static boolean bad_ll(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bad_ll")) return false;
        if (!nextTokenIs(b, ANGLE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, ANGLE_L, ANGLE_L);
        exit_section_(b, m, BAD_LL, r);
        return r;
    }

    /* ********************************************************** */
    // ANGLE_L ANGLE_L ANGLE_L
    //   | OP_LL ANGLE_L
    //   | ANGLE_L OP_LL
    public static boolean bad_lll(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bad_lll")) return false;
        if (!nextTokenIs(b, "<bad lll>", ANGLE_L, OP_LL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, BAD_LLL, "<bad lll>");
        r = parseTokens(b, 0, ANGLE_L, ANGLE_L, ANGLE_L);
        if (!r) r = parseTokens(b, 0, OP_LL, ANGLE_L);
        if (!r) r = parseTokens(b, 0, ANGLE_L, OP_LL);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // ANGLE_R ANGLE_R
    public static boolean bad_rr(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bad_rr")) return false;
        if (!nextTokenIs(b, ANGLE_R)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, ANGLE_R, ANGLE_R);
        exit_section_(b, m, BAD_RR, r);
        return r;
    }

    /* ********************************************************** */
    // ANGLE_R ANGLE_R ANGLE_R
    //   | OP_RR ANGLE_R
    //   | ANGLE_R OP_RR
    public static boolean bad_rrr(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bad_rrr")) return false;
        if (!nextTokenIs(b, "<bad rrr>", ANGLE_R, OP_RR)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, BAD_RRR, "<bad rrr>");
        r = parseTokens(b, 0, ANGLE_R, ANGLE_R, ANGLE_R);
        if (!r) r = parseTokens(b, 0, OP_RR, ANGLE_R);
        if (!r) r = parseTokens(b, 0, ANGLE_R, OP_RR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // block-statement*
    public static boolean block_bare(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_bare")) return false;
        Marker m = enter_section_(b, l, _NONE_, BLOCK_BARE, "<block bare>");
        while (true) {
            int c = current_position_(b);
            if (!block_statement(b, l + 1)) break;
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
    //   | new-lambda
    //   | attribute-above
    //   | control-statement
    //   | inline-statement
    static boolean block_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_statement")) return false;
        boolean r;
        r = declare_variable(b, l + 1);
        if (!r) r = new_lambda(b, l + 1);
        if (!r) r = attribute_above(b, l + 1);
        if (!r) r = control_statement(b, l + 1);
        if (!r) r = inline_statement(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // PROPORTION | COLON COLON
    static boolean c2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "c2")) return false;
        if (!nextTokenIs(b, "", COLON, PROPORTION)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PROPORTION);
        if (!r) r = parseTokens(b, 0, COLON, COLON);
        exit_section_(b, m, null, r);
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
    // PARENTHESIS_L (inherit-item (COMMA inherit-item)* COMMA?)? PARENTHESIS_R
    public static boolean class_inherit(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && class_inherit_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, CLASS_INHERIT, r);
        return r;
    }

    // (inherit-item (COMMA inherit-item)* COMMA?)?
    private static boolean class_inherit_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_1")) return false;
        class_inherit_1_0(b, l + 1);
        return true;
    }

    // inherit-item (COMMA inherit-item)* COMMA?
    private static boolean class_inherit_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = inherit_item(b, l + 1);
        r = r && class_inherit_1_0_1(b, l + 1);
        r = r && class_inherit_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA inherit-item)*
    private static boolean class_inherit_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!class_inherit_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "class_inherit_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA inherit-item
    private static boolean class_inherit_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && inherit_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean class_inherit_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON | COMMA
    //   | declare-domain
    //   | declare-method
    //   | declare-field
    public static boolean class_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CLASS_ITEM, "<class item>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = declare_domain(b, l + 1);
        if (!r) r = declare_method(b, l + 1);
        if (!r) r = declare_field(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_BREAK control-label?
    public static boolean control_break(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_break")) return false;
        if (!nextTokenIs(b, KW_BREAK)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_BREAK);
        r = r && control_break_1(b, l + 1);
        exit_section_(b, m, CONTROL_BREAK, r);
        return r;
    }

    // control-label?
    private static boolean control_break_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_break_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_CONTINUE control-label?
    public static boolean control_continue(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_continue")) return false;
        if (!nextTokenIs(b, KW_CONTINUE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_CONTINUE);
        r = r && control_continue_1(b, l + 1);
        exit_section_(b, m, CONTROL_CONTINUE, r);
        return r;
    }

    // control-label?
    private static boolean control_continue_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_continue_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_POW (identifier| INTEGER|KW_MACRO|KW_FOR|KW_WHILE)
    public static boolean control_label(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_label")) return false;
        if (!nextTokenIs(b, OP_POW)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_POW);
        r = r && control_label_1(b, l + 1);
        exit_section_(b, m, CONTROL_LABEL, r);
        return r;
    }

    // identifier| INTEGER|KW_MACRO|KW_FOR|KW_WHILE
    private static boolean control_label_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_label_1")) return false;
        boolean r;
        r = identifier(b, l + 1);
        if (!r) r = consumeToken(b, INTEGER);
        if (!r) r = consumeToken(b, KW_MACRO);
        if (!r) r = consumeToken(b, KW_FOR);
        if (!r) r = consumeToken(b, KW_WHILE);
        return r;
    }

    /* ********************************************************** */
    // KW_RAISE expression-root
    public static boolean control_raise(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_raise")) return false;
        if (!nextTokenIs(b, KW_RAISE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RAISE);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, CONTROL_RAISE, r);
        return r;
    }

    /* ********************************************************** */
    // KW_RESUME control-label? expression-root
    public static boolean control_resume(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_resume")) return false;
        if (!nextTokenIs(b, KW_RESUME)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RESUME);
        r = r && control_resume_1(b, l + 1);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, CONTROL_RESUME, r);
        return r;
    }

    // control-label?
    private static boolean control_resume_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_resume_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_RETURN control-label? expression-root?
    public static boolean control_return(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_return")) return false;
        if (!nextTokenIs(b, KW_RETURN)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RETURN);
        r = r && control_return_1(b, l + 1);
        r = r && control_return_2(b, l + 1);
        exit_section_(b, m, CONTROL_RETURN, r);
        return r;
    }

    // control-label?
    private static boolean control_return_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_return_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    // expression-root?
    private static boolean control_return_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_return_2")) return false;
        expression_root(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // control-return
    //   | control-yield-send    // generator<Yield=T, Return=()>
    //   | control-yield-stop    // generator<Yield=R, Return=()>
    //   | control-yield-from
    //   | control-continue
    //   | control-break
    //   | control-through
    //   | control-resume
    public static boolean control_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CONTROL_STATEMENT, "<control statement>");
        r = control_return(b, l + 1);
        if (!r) r = control_yield_send(b, l + 1);
        if (!r) r = control_yield_stop(b, l + 1);
        if (!r) r = control_yield_from(b, l + 1);
        if (!r) r = control_continue(b, l + 1);
        if (!r) r = control_break(b, l + 1);
        if (!r) r = control_through(b, l + 1);
        if (!r) r = control_resume(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_THROUGH control-label?
    public static boolean control_through(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_through")) return false;
        if (!nextTokenIs(b, KW_THROUGH)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_THROUGH);
        r = r && control_through_1(b, l + 1);
        exit_section_(b, m, CONTROL_THROUGH, r);
        return r;
    }

    // control-label?
    private static boolean control_through_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_through_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_YIELD KW_WITH KW_FROM expression-root
    //   | KW_YIELD KW_FROM control-label? expression-root
    public static boolean control_yield_from(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_from")) return false;
        if (!nextTokenIs(b, KW_YIELD)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = control_yield_from_0(b, l + 1);
        if (!r) r = control_yield_from_1(b, l + 1);
        exit_section_(b, m, CONTROL_YIELD_FROM, r);
        return r;
    }

    // KW_YIELD KW_WITH KW_FROM expression-root
    private static boolean control_yield_from_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_from_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_WITH, KW_FROM);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_YIELD KW_FROM control-label? expression-root
    private static boolean control_yield_from_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_from_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_FROM);
        r = r && control_yield_from_1_2(b, l + 1);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // control-label?
    private static boolean control_yield_from_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_from_1_2")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_YIELD KW_WITH KW_CONTINUE? expression-root
    //   | KW_YIELD KW_CONTINUE? control-label? expression-root
    public static boolean control_yield_send(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send")) return false;
        if (!nextTokenIs(b, KW_YIELD)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = control_yield_send_0(b, l + 1);
        if (!r) r = control_yield_send_1(b, l + 1);
        exit_section_(b, m, CONTROL_YIELD_SEND, r);
        return r;
    }

    // KW_YIELD KW_WITH KW_CONTINUE? expression-root
    private static boolean control_yield_send_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_WITH);
        r = r && control_yield_send_0_2(b, l + 1);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_CONTINUE?
    private static boolean control_yield_send_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send_0_2")) return false;
        consumeToken(b, KW_CONTINUE);
        return true;
    }

    // KW_YIELD KW_CONTINUE? control-label? expression-root
    private static boolean control_yield_send_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_YIELD);
        r = r && control_yield_send_1_1(b, l + 1);
        r = r && control_yield_send_1_2(b, l + 1);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_CONTINUE?
    private static boolean control_yield_send_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send_1_1")) return false;
        consumeToken(b, KW_CONTINUE);
        return true;
    }

    // control-label?
    private static boolean control_yield_send_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_send_1_2")) return false;
        control_label(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_YIELD KW_WITH KW_RETURN expression-root?
    //   | KW_YIELD KW_WITH KW_BREAK expression-root?
    //   | KW_YIELD KW_RETURN control-label? expression-root?
    //   | KW_YIELD KW_BREAK control-label? expression-root?
    public static boolean control_yield_stop(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop")) return false;
        if (!nextTokenIs(b, KW_YIELD)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = control_yield_stop_0(b, l + 1);
        if (!r) r = control_yield_stop_1(b, l + 1);
        if (!r) r = control_yield_stop_2(b, l + 1);
        if (!r) r = control_yield_stop_3(b, l + 1);
        exit_section_(b, m, CONTROL_YIELD_STOP, r);
        return r;
    }

    // KW_YIELD KW_WITH KW_RETURN expression-root?
    private static boolean control_yield_stop_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_WITH, KW_RETURN);
        r = r && control_yield_stop_0_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // expression-root?
    private static boolean control_yield_stop_0_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_0_3")) return false;
        expression_root(b, l + 1);
        return true;
    }

    // KW_YIELD KW_WITH KW_BREAK expression-root?
    private static boolean control_yield_stop_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_WITH, KW_BREAK);
        r = r && control_yield_stop_1_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // expression-root?
    private static boolean control_yield_stop_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_1_3")) return false;
        expression_root(b, l + 1);
        return true;
    }

    // KW_YIELD KW_RETURN control-label? expression-root?
    private static boolean control_yield_stop_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_RETURN);
        r = r && control_yield_stop_2_2(b, l + 1);
        r = r && control_yield_stop_2_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // control-label?
    private static boolean control_yield_stop_2_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_2_2")) return false;
        control_label(b, l + 1);
        return true;
    }

    // expression-root?
    private static boolean control_yield_stop_2_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_2_3")) return false;
        expression_root(b, l + 1);
        return true;
    }

    // KW_YIELD KW_BREAK control-label? expression-root?
    private static boolean control_yield_stop_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_BREAK);
        r = r && control_yield_stop_3_2(b, l + 1);
        r = r && control_yield_stop_3_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // control-label?
    private static boolean control_yield_stop_3_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_3_2")) return false;
        control_label(b, l + 1);
        return true;
    }

    // expression-root?
    private static boolean control_yield_stop_3_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_stop_3_3")) return false;
        expression_root(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // declare-template? annotations KW_CLASS identifier declare-generic? class-inherit? type-hint? class-body
    public static boolean declare_class(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_CLASS, "<declare class>");
        r = declare_class_0(b, l + 1);
        r = r && annotations(b, l + 1);
        r = r && consumeToken(b, KW_CLASS);
        p = r; // pin = 3
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_class_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_5(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_6(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-template?
    private static boolean declare_class_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_0")) return false;
        declare_template(b, l + 1);
        return true;
    }

    // declare-generic?
    private static boolean declare_class_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_4")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // class-inherit?
    private static boolean declare_class_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_5")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_class_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_6")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_COMPONENT declare-generic? identifier parameter-body return-type? effect-type? block-body
    public static boolean declare_component(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_COMPONENT, "<declare component>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_COMPONENT);
        p = r; // pin = 2
        r = r && report_error_(b, declare_component_2(b, l + 1));
        r = p && report_error_(b, identifier(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_component_5(b, l + 1)) && r;
        r = p && report_error_(b, declare_component_6(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_component_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_component_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    // effect-type?
    private static boolean declare_component_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_6")) return false;
        effect_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier class-body
    public static boolean declare_domain(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_domain")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_DOMAIN, "<declare domain>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && class_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_ENUMERATE identifier class-inherit? type-hint? enumerate-body
    public static boolean declare_enumerate(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enumerate")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_ENUMERATE, "<declare enumerate>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_ENUMERATE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_enumerate_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_enumerate_4(b, l + 1)) && r;
        r = p && enumerate_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean declare_enumerate_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enumerate_3")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_enumerate_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enumerate_4")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier type-hint? default-value?
    public static boolean declare_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FIELD, "<declare field>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
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
    // annotations KW_FLAGS identifier class-inherit? type-hint? enumerate-body
    public static boolean declare_flags(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FLAGS, "<declare flags>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FLAGS);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_flags_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_flags_4(b, l + 1)) && r;
        r = p && enumerate_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean declare_flags_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags_3")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_flags_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags_4")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_FUNCTION declare-generic? identifier parameter-body return-type? effect-type? block-body
    public static boolean declare_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FUNCTION, "<declare function>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FUNCTION);
        p = r; // pin = 2
        r = r && report_error_(b, declare_function_2(b, l + 1));
        r = p && report_error_(b, identifier(b, l + 1)) && r;
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
    // PROPORTION? GENERIC_L (generic-parameter (COMMA generic-parameter)* COMMA?)? GENERIC_R
    //   | PROPORTION? ANGLE_L   (generic-parameter (COMMA generic-parameter)* COMMA?)? ANGLE_R
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

    // PROPORTION? GENERIC_L (generic-parameter (COMMA generic-parameter)* COMMA?)? GENERIC_R
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

    // (generic-parameter (COMMA generic-parameter)* COMMA?)?
    private static boolean declare_generic_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2")) return false;
        declare_generic_0_2_0(b, l + 1);
        return true;
    }

    // generic-parameter (COMMA generic-parameter)* COMMA?
    private static boolean declare_generic_0_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_parameter(b, l + 1);
        r = r && declare_generic_0_2_0_1(b, l + 1);
        r = r && declare_generic_0_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-parameter)*
    private static boolean declare_generic_0_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_generic_0_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_generic_0_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-parameter
    private static boolean declare_generic_0_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_generic_0_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // PROPORTION? ANGLE_L   (generic-parameter (COMMA generic-parameter)* COMMA?)? ANGLE_R
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

    // (generic-parameter (COMMA generic-parameter)* COMMA?)?
    private static boolean declare_generic_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2")) return false;
        declare_generic_1_2_0(b, l + 1);
        return true;
    }

    // generic-parameter (COMMA generic-parameter)* COMMA?
    private static boolean declare_generic_1_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_parameter(b, l + 1);
        r = r && declare_generic_1_2_0_1(b, l + 1);
        r = r && declare_generic_1_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-parameter)*
    private static boolean declare_generic_1_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_generic_1_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_generic_1_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-parameter
    private static boolean declare_generic_1_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_generic_1_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // {
    // }
    private static boolean declare_generic_1_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations KW_IMPLY declare-generic? namepath generic-call-free? type-hint class-body
    public static boolean declare_imply(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_IMPLY, "<declare imply>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_IMPLY);
        p = r; // pin = 2
        r = r && report_error_(b, declare_imply_2(b, l + 1));
        r = p && report_error_(b, namepath(b, l + 1)) && r;
        r = p && report_error_(b, declare_imply_4(b, l + 1)) && r;
        r = p && report_error_(b, type_hint(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_imply_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // generic-call-free?
    private static boolean declare_imply_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_4")) return false;
        generic_call_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_MACRO declare-generic? identifier parameter-body return-type? effect-type? block-body
    public static boolean declare_macro(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_MACRO, "<declare macro>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_MACRO);
        p = r; // pin = 2
        r = r && report_error_(b, declare_macro_2(b, l + 1));
        r = p && report_error_(b, identifier(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_macro_5(b, l + 1)) && r;
        r = p && report_error_(b, declare_macro_6(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_macro_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_macro_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    // effect-type?
    private static boolean declare_macro_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro_6")) return false;
        effect_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier declare-generic? parameter-body return-type? effect-type? block-body?
    public static boolean declare_method(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_METHOD, "<declare method>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
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
    // annotations identifier default-value?
    public static boolean declare_semantic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SEMANTIC, "<declare semantic>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
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
    // annotations KW_TEMPLATE (identifier (COMMA identifier)* COMMA?)? template-body
    public static boolean declare_template(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TEMPLATE, "<declare template>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TEMPLATE);
        p = r; // pin = 2
        r = r && report_error_(b, declare_template_2(b, l + 1));
        r = p && template_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (identifier (COMMA identifier)* COMMA?)?
    private static boolean declare_template_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template_2")) return false;
        declare_template_2_0(b, l + 1);
        return true;
    }

    // identifier (COMMA identifier)* COMMA?
    private static boolean declare_template_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        r = r && declare_template_2_0_1(b, l + 1);
        r = r && declare_template_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier)*
    private static boolean declare_template_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_template_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_template_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA identifier
    private static boolean declare_template_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_template_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_template_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_TRAIT identifier declare-generic? type-hint? class-body
    public static boolean declare_trait(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TRAIT, "<declare trait>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_trait_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_trait_4(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_trait_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_trait_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_4")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_UNION identifier class-body
    public static boolean declare_union(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_union")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNION, "<declare union>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNION);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // declare-template? annotations KW_UNITE identifier unite-body
    public static boolean declare_unite(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNITE, "<declare unite>");
        r = declare_unite_0(b, l + 1);
        r = r && annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNITE);
        p = r; // pin = 3
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && unite_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-template?
    private static boolean declare_unite_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite_0")) return false;
        declare_template(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_LET let-pattern type-hint? EQUAL inline-statement
    public static boolean declare_variable(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variable")) return false;
        if (!nextTokenIs(b, KW_LET)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_VARIABLE, null);
        r = consumeToken(b, KW_LET);
        p = r; // pin = 1
        r = r && report_error_(b, let_pattern(b, l + 1));
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
    // annotations identifier class-body?
    public static boolean declare_variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variant")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_VARIANT, "<declare variant>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && declare_variant_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // class-body?
    private static boolean declare_variant_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variant_2")) return false;
        class_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_WHERE where-body
    public static boolean declare_where(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_where")) return false;
        if (!nextTokenIs(b, KW_WHERE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_WHERE);
        r = r && where_body(b, l + 1);
        exit_section_(b, m, DECLARE_WHERE, r);
        return r;
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
    // EQUAL expression-root
    public static boolean default_value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "default_value")) return false;
        if (!nextTokenIs(b, EQUAL)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, DEFAULT_VALUE, r);
        return r;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT namepath (argument-body | argument-body? block-body)?
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

    // (argument-body | argument-body? block-body)?
    private static boolean dot_call_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_3")) return false;
        dot_call_3_0(b, l + 1);
        return true;
    }

    // argument-body | argument-body? block-body
    private static boolean dot_call_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = argument_body(b, l + 1);
        if (!r) r = dot_call_3_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? block-body
    private static boolean dot_call_3_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_3_0_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = dot_call_3_0_1_0(b, l + 1);
        r = r && block_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean dot_call_3_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_3_0_1_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT KW_FOR for-pattern-dot expression-inline if-condition? block-body
    public static boolean dot_call_for(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_for")) return false;
        if (!nextTokenIs(b, "<dot call for>", DOT, OP_AND_THEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_FOR, "<dot call for>");
        r = dot_call_for_0(b, l + 1);
        r = r && consumeTokens(b, 2, DOT, KW_FOR);
        p = r; // pin = 3
        r = r && report_error_(b, for_pattern_dot(b, l + 1));
        r = p && report_error_(b, expression_inline(b, l + 1)) && r;
        r = p && report_error_(b, dot_call_for_5(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_AND_THEN?
    private static boolean dot_call_for_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_for_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // if-condition?
    private static boolean dot_call_for_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_for_5")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT namepath argument-body?
    public static boolean dot_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_inline")) return false;
        if (!nextTokenIs(b, "<dot call inline>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_INLINE, "<dot call inline>");
        r = dot_call_inline_0(b, l + 1);
        r = r && consumeToken(b, DOT);
        r = r && namepath(b, l + 1);
        r = r && dot_call_inline_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean dot_call_inline_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_inline_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // argument-body?
    private static boolean dot_call_inline_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_inline_3")) return false;
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
    // OP_DIV type-expression
    public static boolean effect_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "effect_type")) return false;
        if (!nextTokenIs(b, OP_DIV)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_DIV);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, EFFECT_TYPE, r);
        return r;
    }

    /* ********************************************************** */
    // KW_ELSE KW_IF expression-inline block-body
    public static boolean else_if_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_if_statement")) return false;
        if (!nextTokenIs(b, KW_ELSE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ELSE_IF_STATEMENT, null);
        r = consumeTokens(b, 2, KW_ELSE, KW_IF);
        p = r; // pin = 2
        r = r && report_error_(b, expression_inline(b, l + 1));
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
    // SEMICOLON | COMMA
    //   | declare-method
    //   | declare-semantic
    public static boolean enumerate_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enumerate_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ENUMERATE_ITEM, "<enumerate item>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = declare_method(b, l + 1);
        if (!r) r = declare_semantic(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // term (infix term)*
    public static boolean expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
        r = term(b, l + 1);
        r = r && expression_1(b, l + 1);
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

    /* ********************************************************** */
    // inline-term (infix inline-term)* {
    // }
    public static boolean expression_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION_INLINE, "<expression inline>");
        r = inline_term(b, l + 1);
        r = r && expression_inline_1(b, l + 1);
        r = r && expression_inline_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (infix inline-term)*
    private static boolean expression_inline_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_inline_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!expression_inline_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "expression_inline_1", c)) break;
        }
        return true;
    }

    // infix inline-term
    private static boolean expression_inline_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_inline_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = infix(b, l + 1);
        r = r && inline_term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean expression_inline_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // expression OP_AND_THEN? {
    // }
    public static boolean expression_root(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_root")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION_ROOT, "<expression root>");
        r = expression(b, l + 1);
        r = r && expression_root_1(b, l + 1);
        r = r && expression_root_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean expression_root_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_root_1")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // {
    // }
    private static boolean expression_root_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // pattern-bare
    //   | pattern-unapply
    //   | pattern-sequence
    public static boolean for_pattern_dot(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_pattern_dot")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FOR_PATTERN_DOT, "<for pattern dot>");
        r = pattern_bare(b, l + 1);
        if (!r) r = pattern_unapply(b, l + 1);
        if (!r) r = pattern_sequence(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // attribute-below* KW_FOR let-pattern KW_IN expression-inline if-condition? block-body
    public static boolean for_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement")) return false;
        if (!nextTokenIs(b, "<for statement>", HASH, KW_FOR)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
        r = for_statement_0(b, l + 1);
        r = r && consumeToken(b, KW_FOR);
        p = r; // pin = 2
        r = r && report_error_(b, let_pattern(b, l + 1));
        r = p && report_error_(b, consumeToken(b, KW_IN)) && r;
        r = p && report_error_(b, expression_inline(b, l + 1)) && r;
        r = p && report_error_(b, for_statement_5(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // attribute-below*
    private static boolean for_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "for_statement_0", c)) break;
        }
        return true;
    }

    // if-condition?
    private static boolean for_statement_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement_5")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath (argument-body? block-body | argument-body)?
    public static boolean function_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
        r = namepath(b, l + 1);
        r = r && function_call_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (argument-body? block-body | argument-body)?
    private static boolean function_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_1")) return false;
        function_call_1_0(b, l + 1);
        return true;
    }

    // argument-body? block-body | argument-body
    private static boolean function_call_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = function_call_1_0_0(b, l + 1);
        if (!r) r = argument_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? block-body
    private static boolean function_call_1_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_1_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = function_call_1_0_0_0(b, l + 1);
        r = r && block_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean function_call_1_0_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_1_0_0_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath argument-body
    public static boolean function_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL_INLINE, "<function call inline>");
        r = namepath(b, l + 1);
        r = r && argument_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (annotations identifier EQUAL)? type-expression
    public static boolean generic_argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_ARGUMENT, "<generic argument>");
        r = generic_argument_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (annotations identifier EQUAL)?
    private static boolean generic_argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_0")) return false;
        generic_argument_0_0(b, l + 1);
        return true;
    }

    // annotations identifier EQUAL
    private static boolean generic_argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PROPORTION? GENERIC_L (generic-argument (COMMA generic-argument)* COMMA?)? GENERIC_R
    //   | PROPORTION  ANGLE_L   (generic-argument (COMMA generic-argument)* COMMA?)? ANGLE_R
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

    // PROPORTION? GENERIC_L (generic-argument (COMMA generic-argument)* COMMA?)? GENERIC_R
    private static boolean generic_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_0_0(b, l + 1);
        r = r && consumeToken(b, GENERIC_L);
        r = r && generic_call_0_2(b, l + 1);
        r = r && consumeToken(b, GENERIC_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_2")) return false;
        generic_call_0_2_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_0_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_0_2_0_1(b, l + 1);
        r = r && generic_call_0_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_0_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_0_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_0_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_0_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_0_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // PROPORTION  ANGLE_L   (generic-argument (COMMA generic-argument)* COMMA?)? ANGLE_R
    private static boolean generic_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, PROPORTION, ANGLE_L);
        r = r && generic_call_1_2(b, l + 1);
        r = r && consumeToken(b, ANGLE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_2")) return false;
        generic_call_1_2_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_1_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_1_2_0_1(b, l + 1);
        r = r && generic_call_1_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_1_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_1_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_1_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_1_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_1_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // PROPORTION? GENERIC_L (generic-argument (COMMA generic-argument)* COMMA?)? GENERIC_R
    //   | PROPORTION? ANGLE_L   (generic-argument (COMMA generic-argument)* COMMA?)? ANGLE_R
    public static boolean generic_call_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL_FREE, "<generic call free>");
        r = generic_call_free_0(b, l + 1);
        if (!r) r = generic_call_free_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PROPORTION? GENERIC_L (generic-argument (COMMA generic-argument)* COMMA?)? GENERIC_R
    private static boolean generic_call_free_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_0_0(b, l + 1);
        r = r && consumeToken(b, GENERIC_L);
        r = r && generic_call_free_0_2(b, l + 1);
        r = r && consumeToken(b, GENERIC_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_free_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_free_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_2")) return false;
        generic_call_free_0_2_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_free_0_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_free_0_2_0_1(b, l + 1);
        r = r && generic_call_free_0_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_free_0_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_free_0_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_free_0_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_free_0_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_free_0_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // PROPORTION? ANGLE_L   (generic-argument (COMMA generic-argument)* COMMA?)? ANGLE_R
    private static boolean generic_call_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_1_0(b, l + 1);
        r = r && consumeToken(b, ANGLE_L);
        r = r && generic_call_free_1_2(b, l + 1);
        r = r && consumeToken(b, ANGLE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PROPORTION?
    private static boolean generic_call_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_0")) return false;
        consumeToken(b, PROPORTION);
        return true;
    }

    // (generic-argument (COMMA generic-argument)* COMMA?)?
    private static boolean generic_call_free_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_2")) return false;
        generic_call_free_1_2_0(b, l + 1);
        return true;
    }

    // generic-argument (COMMA generic-argument)* COMMA?
    private static boolean generic_call_free_1_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_argument(b, l + 1);
        r = r && generic_call_free_1_2_0_1(b, l + 1);
        r = r && generic_call_free_1_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)*
    private static boolean generic_call_free_1_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_free_1_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_free_1_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-argument
    private static boolean generic_call_free_1_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_free_1_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier type-hint? default-type?
    public static boolean generic_parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_parameter")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_PARAMETER, "<generic parameter>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
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
    //     | KW_CLASS
    //     | KW_FUNCTION | KW_MACRO | KW_COMPONENT
    //     | KW_UNION | KW_IMPORT | KW_AS
    //     | KW_FROM
    public static boolean identifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOW_RAW);
        if (!r) r = consumeToken(b, KW_CLASS);
        if (!r) r = consumeToken(b, KW_FUNCTION);
        if (!r) r = consumeToken(b, KW_MACRO);
        if (!r) r = consumeToken(b, KW_COMPONENT);
        if (!r) r = consumeToken(b, KW_UNION);
        if (!r) r = consumeToken(b, KW_IMPORT);
        if (!r) r = consumeToken(b, KW_AS);
        if (!r) r = consumeToken(b, KW_FROM);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_IF (KW_LET|KW_CASE) pattern EQUAL expression-inline block-body
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
        r = p && report_error_(b, expression_inline(b, l + 1)) && r;
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
    // KW_IF expression-inline
    public static boolean if_condition(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_condition")) return false;
        if (!nextTokenIs(b, KW_IF)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, IF_CONDITION, null);
        r = consumeToken(b, KW_IF);
        p = r; // pin = 1
        r = r && expression_inline(b, l + 1);
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
    //   | STAR | OP_DIV | OP_REM | OP_DIV_REM
    //   | OP_OR
    //   | OP_AND
    //   | OP_LLL | bad-lll  // <<<
    //   | OP_GGG | bad-rrr  // >>>
    //   | OP_LL  | bad-ll   // <<
    //   | OP_GG  | bad-rr   // >>
    //   | OP_LEQ | ANGLE_L  // <
    //   | OP_GEQ | ANGLE_R  // >
    //   | OP_UNTIL
    //   | EQUAL | OP_EE | OP_NE
    //   | KW_AS
    //   | is_not | KW_IS
    public static boolean infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
        r = consumeToken(b, OP_PLUS);
        if (!r) r = consumeToken(b, OP_MINUS);
        if (!r) r = consumeToken(b, STAR);
        if (!r) r = consumeToken(b, OP_DIV);
        if (!r) r = consumeToken(b, OP_REM);
        if (!r) r = consumeToken(b, OP_DIV_REM);
        if (!r) r = consumeToken(b, OP_OR);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, OP_LLL);
        if (!r) r = bad_lll(b, l + 1);
        if (!r) r = consumeToken(b, OP_GGG);
        if (!r) r = bad_rrr(b, l + 1);
        if (!r) r = consumeToken(b, OP_LL);
        if (!r) r = bad_ll(b, l + 1);
        if (!r) r = consumeToken(b, OP_GG);
        if (!r) r = bad_rr(b, l + 1);
        if (!r) r = consumeToken(b, OP_LEQ);
        if (!r) r = consumeToken(b, ANGLE_L);
        if (!r) r = consumeToken(b, OP_GEQ);
        if (!r) r = consumeToken(b, ANGLE_R);
        if (!r) r = consumeToken(b, OP_UNTIL);
        if (!r) r = consumeToken(b, EQUAL);
        if (!r) r = consumeToken(b, OP_EE);
        if (!r) r = consumeToken(b, OP_NE);
        if (!r) r = consumeToken(b, KW_AS);
        if (!r) r = is_not(b, l + 1);
        if (!r) r = consumeToken(b, KW_IS);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (annotations identifier EQUAL)? type-expression
    public static boolean inherit_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INHERIT_ITEM, "<inherit item>");
        r = inherit_item_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (annotations identifier EQUAL)?
    private static boolean inherit_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item_0")) return false;
        inherit_item_0_0(b, l + 1);
        return true;
    }

    // annotations identifier EQUAL
    private static boolean inherit_item_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L expression-root PARENTHESIS_R
    //   | macro-call
    //   | function-call-inline
    //   | ordinal-range
    //   | offset-range
    //   | literal
    public static boolean inline_atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_ATOMIC, "<inline atomic>");
        r = inline_atomic_0(b, l + 1);
        if (!r) r = macro_call(b, l + 1);
        if (!r) r = function_call_inline(b, l + 1);
        if (!r) r = ordinal_range(b, l + 1);
        if (!r) r = offset_range(b, l + 1);
        if (!r) r = literal(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L expression-root PARENTHESIS_R
    private static boolean inline_atomic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //   | if-case-statement
    //   | if-statement
    //   | expression-root
    static boolean inline_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_statement")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = if_case_statement(b, l + 1);
        if (!r) r = if_statement(b, l + 1);
        if (!r) r = expression_root(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // OP_BANG
    //     | dot-call-inline
    //     | generic-call
    public static boolean inline_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_SUFFIX, "<inline suffix>");
        r = consumeToken(b, OP_BANG);
        if (!r) r = dot_call_inline(b, l + 1);
        if (!r) r = generic_call(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // prefix* inline-atomic inline-suffix* {
    // }
    public static boolean inline_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_TERM, "<inline term>");
        r = inline_term_0(b, l + 1);
        r = r && inline_atomic(b, l + 1);
        r = r && inline_term_2(b, l + 1);
        r = r && inline_term_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // prefix*
    private static boolean inline_term_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_term_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!prefix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "inline_term_0", c)) break;
        }
        return true;
    }

    // inline-suffix*
    private static boolean inline_term_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_term_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!inline_suffix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "inline_term_2", c)) break;
        }
        return true;
    }

    // {
    // }
    private static boolean inline_term_3(PsiBuilder b, int l) {
        return true;
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
    // BRACE_L new-lambda? block-statement* BRACE_R
    public static boolean lambda_block(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lambda_block")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && lambda_block_1(b, l + 1);
        r = r && lambda_block_2(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, LAMBDA_BLOCK, r);
        return r;
    }

    // new-lambda?
    private static boolean lambda_block_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lambda_block_1")) return false;
        new_lambda(b, l + 1);
        return true;
    }

    // block-statement*
    private static boolean lambda_block_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lambda_block_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!block_statement(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "lambda_block_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // pattern-bare
    //   | pattern-unapply
    //   | pattern-sequence
    //   | pattern-object
    public static boolean let_pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LET_PATTERN, "<let pattern>");
        r = pattern_bare(b, l + 1);
        if (!r) r = pattern_unapply(b, l + 1);
        if (!r) r = pattern_sequence(b, l + 1);
        if (!r) r = pattern_object(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // special | namepath | number | string
    public static boolean literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "literal")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
        r = special(b, l + 1);
        if (!r) r = namepath(b, l + 1);
        if (!r) r = number(b, l + 1);
        if (!r) r = string(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_L10N (identifier ((DOT|PROPORTION|OP_DIV) identifier)*)? argument-body?
    public static boolean localize_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call")) return false;
        if (!nextTokenIs(b, OP_L10N)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOCALIZE_CALL, null);
        r = consumeToken(b, OP_L10N);
        p = r; // pin = 1
        r = r && report_error_(b, localize_call_1(b, l + 1));
        r = p && localize_call_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (identifier ((DOT|PROPORTION|OP_DIV) identifier)*)?
    private static boolean localize_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1")) return false;
        localize_call_1_0(b, l + 1);
        return true;
    }

    // identifier ((DOT|PROPORTION|OP_DIV) identifier)*
    private static boolean localize_call_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        r = r && localize_call_1_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // ((DOT|PROPORTION|OP_DIV) identifier)*
    private static boolean localize_call_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!localize_call_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "localize_call_1_0_1", c)) break;
        }
        return true;
    }

    // (DOT|PROPORTION|OP_DIV) identifier
    private static boolean localize_call_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = localize_call_1_0_1_0_0(b, l + 1);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // DOT|PROPORTION|OP_DIV
    private static boolean localize_call_1_0_1_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1_0_0")) return false;
        boolean r;
        r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, PROPORTION);
        if (!r) r = consumeToken(b, OP_DIV);
        return r;
    }

    // argument-body?
    private static boolean localize_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_2")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // AT namepath (argument-body? class-body|argument-body)?
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

    // (argument-body? class-body|argument-body)?
    private static boolean macro_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2")) return false;
        macro_call_2_0(b, l + 1);
        return true;
    }

    // argument-body? class-body|argument-body
    private static boolean macro_call_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = macro_call_2_0_0(b, l + 1);
        if (!r) r = argument_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? class-body
    private static boolean macro_call_2_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = macro_call_2_0_0_0(b, l + 1);
        r = r && class_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean macro_call_2_0_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2_0_0_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // AT namepath argument-body?
    public static boolean macro_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_inline")) return false;
        if (!nextTokenIs(b, AT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, AT);
        r = r && namepath(b, l + 1);
        r = r && macro_call_inline_2(b, l + 1);
        exit_section_(b, m, MACRO_CALL_INLINE, r);
        return r;
    }

    // argument-body?
    private static boolean macro_call_inline_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_inline_2")) return false;
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
    // KW_MATCH expression-inline match-body
    public static boolean match_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement")) return false;
        if (!nextTokenIs(b, KW_MATCH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_STATEMENT, null);
        r = consumeToken(b, KW_MATCH);
        p = r; // pin = 1
        r = r && report_error_(b, expression_inline(b, l + 1));
        r = p && match_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_WHEN expression-inline COLON block-bare
    public static boolean match_when(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_when")) return false;
        if (!nextTokenIs(b, KW_WHEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_WHEN, null);
        r = consumeToken(b, KW_WHEN);
        p = r; // pin = 1
        r = r && report_error_(b, expression_inline(b, l + 1));
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
    // (SYMBOL | SYMBOW_RAW) !modifier-stop
    public static boolean modifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier")) return false;
        if (!nextTokenIs(b, "<modifier>", SYMBOL, SYMBOW_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
        r = modifier_0(b, l + 1);
        r = r && modifier_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // SYMBOL | SYMBOW_RAW
    private static boolean modifier_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_0")) return false;
        boolean r;
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOW_RAW);
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
    // KW_IN | KW_IF
    //     | COMMA | COLON | PROPORTION | DOT | SEMICOLON | EQUAL
    //     | PARENTHESIS_L | PARENTHESIS_R
    //     | BRACE_L | BRACE_R
    static boolean modifier_stop(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_stop")) return false;
        boolean r;
        r = consumeToken(b, KW_IN);
        if (!r) r = consumeToken(b, KW_IF);
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
    // BRACE_L new-item* BRACE_R
    public static boolean new_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && new_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, NEW_BODY, r);
        return r;
    }

    // new-item*
    private static boolean new_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!new_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "new_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // inline-statement
    //   | COLON
    //   | COMMA
    public static boolean new_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NEW_ITEM, "<new item>");
        r = inline_statement(b, l + 1);
        if (!r) r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, COMMA);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_LAMBDA declare-generic? parameter-body return-type? effect-type?
    public static boolean new_lambda(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda")) return false;
        if (!nextTokenIs(b, KW_LAMBDA)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_LAMBDA, null);
        r = consumeToken(b, KW_LAMBDA);
        p = r; // pin = 1
        r = r && report_error_(b, new_lambda_1(b, l + 1));
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, new_lambda_3(b, l + 1)) && r;
        r = p && new_lambda_4(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean new_lambda_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda_1")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean new_lambda_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda_3")) return false;
        return_type(b, l + 1);
        return true;
    }

    // effect-type?
    private static boolean new_lambda_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda_4")) return false;
        effect_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_OBJECT class-inherit? type-hint? class-body
    public static boolean new_object(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object")) return false;
        if (!nextTokenIs(b, KW_OBJECT)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_OBJECT, null);
        r = consumeToken(b, KW_OBJECT);
        p = r; // pin = 1
        r = r && report_error_(b, new_object_1(b, l + 1));
        r = p && report_error_(b, new_object_2(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean new_object_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object_1")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean new_object_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_NEW modifier* type-expression? argument-body? new-body
    public static boolean new_value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value")) return false;
        if (!nextTokenIs(b, KW_NEW)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_VALUE, null);
        r = consumeToken(b, KW_NEW);
        p = r; // pin = 1
        r = r && report_error_(b, new_value_1(b, l + 1));
        r = p && report_error_(b, new_value_2(b, l + 1)) && r;
        r = p && report_error_(b, new_value_3(b, l + 1)) && r;
        r = p && new_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean new_value_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "new_value_1", c)) break;
        }
        return true;
    }

    // type-expression?
    private static boolean new_value_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value_2")) return false;
        type_expression(b, l + 1);
        return true;
    }

    // argument-body?
    private static boolean new_value_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value_3")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // INTEGER identifier?
    //   | DECIMAL identifier?
    public static boolean number(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number")) return false;
        if (!nextTokenIs(b, "<number>", DECIMAL, INTEGER)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
        r = number_0(b, l + 1);
        if (!r) r = number_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // INTEGER identifier?
    private static boolean number_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INTEGER);
        r = r && number_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // identifier?
    private static boolean number_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_0_1")) return false;
        identifier(b, l + 1);
        return true;
    }

    // DECIMAL identifier?
    private static boolean number_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DECIMAL);
        r = r && number_1_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // identifier?
    private static boolean number_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_1_1")) return false;
        identifier(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OFFSET_L (range-item (COMMA range-item)* COMMA?)? OFFSET_R
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

    // (range-item (COMMA range-item)* COMMA?)?
    private static boolean offset_range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1")) return false;
        offset_range_1_0(b, l + 1);
        return true;
    }

    // range-item (COMMA range-item)* COMMA?
    private static boolean offset_range_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item(b, l + 1);
        r = r && offset_range_1_0_1(b, l + 1);
        r = r && offset_range_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA range-item)*
    private static boolean offset_range_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!offset_range_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "offset_range_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA range-item
    private static boolean offset_range_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && range_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean offset_range_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // BRACKET_L (range-item (COMMA range-item)* COMMA?)? BRACKET_R
    public static boolean ordinal_range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && ordinal_range_1(b, l + 1);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, ORDINAL_RANGE, r);
        return r;
    }

    // (range-item (COMMA range-item)* COMMA?)?
    private static boolean ordinal_range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1")) return false;
        ordinal_range_1_0(b, l + 1);
        return true;
    }

    // range-item (COMMA range-item)* COMMA?
    private static boolean ordinal_range_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item(b, l + 1);
        r = r && ordinal_range_1_0_1(b, l + 1);
        r = r && ordinal_range_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA range-item)*
    private static boolean ordinal_range_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!ordinal_range_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "ordinal_range_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA range-item
    private static boolean ordinal_range_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && range_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean ordinal_range_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
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
    // annotations identifier type-hint? default-value?
    public static boolean parameter_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER_ITEM, "<parameter item>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && parameter_item_2(b, l + 1);
        r = r && parameter_item_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-hint?
    private static boolean parameter_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean parameter_item_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_3")) return false;
        default_value(b, l + 1);
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
    public static boolean pattern_bare(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_BARE, "<pattern bare>");
        r = pattern_literal(b, l + 1);
        r = r && pattern_bare_1(b, l + 1);
        r = r && pattern_bare_2(b, l + 1);
        r = r && pattern_bare_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (COMMA pattern-literal)*
    private static boolean pattern_bare_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!pattern_bare_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "pattern_bare_1", c)) break;
        }
        return true;
    }

    // COMMA pattern-literal
    private static boolean pattern_bare_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && pattern_literal(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean pattern_bare_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    private static boolean pattern_bare_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_3")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !pattern_bare_3_0(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L|BRACKET_L|BRACE_L
    private static boolean pattern_bare_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_bare_3_0")) return false;
        boolean r;
        r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, BRACKET_L);
        if (!r) r = consumeToken(b, BRACE_L);
        return r;
    }

    /* ********************************************************** */
    // annotations (identifier|string|special)
    public static boolean pattern_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_literal")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_LITERAL, "<pattern literal>");
        r = annotations(b, l + 1);
        r = r && pattern_literal_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier|string|special
    private static boolean pattern_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_literal_1")) return false;
        boolean r;
        r = identifier(b, l + 1);
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
    // annotations identifier COLON pattern
    public static boolean pattern_pair(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "pattern_pair")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PATTERN_PAIR, "<pattern pair>");
        r = annotations(b, l + 1);
        r = r && identifier(b, l + 1);
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
    // expression-root
    public static boolean range_index(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_index")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_INDEX, "<range index>");
        r = expression_root(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // range-lower? COLON range-upper? COLON range-step?
    //   | range-lower? c2 range-upper?
    //   | range-lower? COLON range-upper?
    //   | range-index
    public static boolean range_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_ITEM, "<range item>");
        r = range_item_0(b, l + 1);
        if (!r) r = range_item_1(b, l + 1);
        if (!r) r = range_item_2(b, l + 1);
        if (!r) r = range_index(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // range-lower? COLON range-upper? COLON range-step?
    private static boolean range_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item_0_0(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_0_2(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_0_4(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-lower?
    private static boolean range_item_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_0_0")) return false;
        range_lower(b, l + 1);
        return true;
    }

    // range-upper?
    private static boolean range_item_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_0_2")) return false;
        range_upper(b, l + 1);
        return true;
    }

    // range-step?
    private static boolean range_item_0_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_0_4")) return false;
        range_step(b, l + 1);
        return true;
    }

    // range-lower? c2 range-upper?
    private static boolean range_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item_1_0(b, l + 1);
        r = r && c2(b, l + 1);
        r = r && range_item_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-lower?
    private static boolean range_item_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_1_0")) return false;
        range_lower(b, l + 1);
        return true;
    }

    // range-upper?
    private static boolean range_item_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_1_2")) return false;
        range_upper(b, l + 1);
        return true;
    }

    // range-lower? COLON range-upper?
    private static boolean range_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = range_item_2_0(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && range_item_2_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // range-lower?
    private static boolean range_item_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_2_0")) return false;
        range_lower(b, l + 1);
        return true;
    }

    // range-upper?
    private static boolean range_item_2_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_item_2_2")) return false;
        range_upper(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // expression-root
    public static boolean range_lower(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_lower")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_LOWER, "<range lower>");
        r = expression_root(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // expression-root
    public static boolean range_step(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_step")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_STEP, "<range step>");
        r = expression_root(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // expression-root
    public static boolean range_upper(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "range_upper")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RANGE_UPPER, "<range upper>");
        r = expression_root(b, l + 1);
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
    // slot-named
    //   | slot-index
    public static boolean slot(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = slot_named(b, l + 1);
        if (!r) r = slot_index(b, l + 1);
        exit_section_(b, m, SLOT, r);
        return r;
    }

    /* ********************************************************** */
    // DOLLAR INTEGER
    public static boolean slot_index(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot_index")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, DOLLAR, INTEGER);
        exit_section_(b, m, SLOT_INDEX, r);
        return r;
    }

    /* ********************************************************** */
    // DOLLAR identifier
    public static boolean slot_named(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot_named")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOLLAR);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, SLOT_NAMED, r);
        return r;
    }

    /* ********************************************************** */
    // KW_NULL | KW_NIL | KW_BOOLEAN | COLOR
    public static boolean special(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "special")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SPECIAL, "<special>");
        r = consumeToken(b, KW_NULL);
        if (!r) r = consumeToken(b, KW_NIL);
        if (!r) r = consumeToken(b, KW_BOOLEAN);
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
    //   | declare-component
    //   | declare-macro
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
        if (!r) r = declare_component(b, l + 1);
        if (!r) r = declare_macro(b, l + 1);
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
    // OP_BANG
    //     | dot-call | dot-call-for | dot-call-match
    //     | generic-call
    public static boolean suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SUFFIX, "<suffix>");
        r = consumeToken(b, OP_BANG);
        if (!r) r = dot_call(b, l + 1);
        if (!r) r = dot_call_for(b, l + 1);
        if (!r) r = dot_call_match(b, l + 1);
        if (!r) r = generic_call(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L template-item* BRACE_R
    public static boolean template_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && template_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, TEMPLATE_BODY, r);
        return r;
    }

    // template-item*
    private static boolean template_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!template_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "template_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON
    //   | declare-where
    public static boolean template_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_item")) return false;
        if (!nextTokenIs(b, "<template item>", KW_WHERE, SEMICOLON)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TEMPLATE_ITEM, "<template item>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = declare_where(b, l + 1);
        exit_section_(b, l, m, r, false, null);
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
    // annotations KW_TRAIT identifier EQUAL type-expression
    public static boolean trait_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_alias")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRAIT_ALIAS, "<trait alias>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        r = r && identifier(b, l + 1);
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
    // annotations KW_TYPE identifier EQUAL type-expression
    public static boolean type_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_alias")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS, "<type alias>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TYPE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
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
    // BRACE_L unite-item* BRACE_R
    public static boolean unite_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unite_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && unite_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, UNITE_BODY, r);
        return r;
    }

    // unite-item*
    private static boolean unite_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unite_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!unite_item(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "unite_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON | COMMA
    //   | declare-variant
    //   | declare-method
    public static boolean unite_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unite_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, UNITE_ITEM, "<unite item>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = declare_variant(b, l + 1);
        if (!r) r = declare_method(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // BUILDER_L BUILDER_R DOMAIN_L DOMAIN_R OP_ARROW2 OP_ARROW3
    public static boolean unused(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unused")) return false;
        if (!nextTokenIs(b, BUILDER_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, BUILDER_L, BUILDER_R, DOMAIN_L, DOMAIN_R, OP_ARROW2, OP_ARROW3);
        exit_section_(b, m, UNUSED, r);
        return r;
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
    // identifier KW_AS identifier
    public static boolean using_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_alias")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_ALIAS, "<using alias>");
        r = identifier(b, l + 1);
        r = r && consumeToken(b, KW_AS);
        r = r && identifier(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (namepath-free using-dot?) STAR using-exclude?
    public static boolean using_any(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any")) return false;
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
    // KW_EXCLUDE (identifier|BRACE_L (identifier (COMMA identifier)* COMMA?) BRACE_R)
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

    // identifier|BRACE_L (identifier (COMMA identifier)* COMMA?) BRACE_R
    private static boolean using_exclude_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        if (!r) r = using_exclude_1_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // BRACE_L (identifier (COMMA identifier)* COMMA?) BRACE_R
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

    // identifier (COMMA identifier)* COMMA?
    private static boolean using_exclude_1_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        r = r && using_exclude_1_1_1_1(b, l + 1);
        r = r && using_exclude_1_1_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier)*
    private static boolean using_exclude_1_1_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!using_exclude_1_1_1_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "using_exclude_1_1_1_1", c)) break;
        }
        return true;
    }

    // COMMA identifier
    private static boolean using_exclude_1_1_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1_1_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier(b, l + 1);
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
    // SEMICOLON | COMMA
    //   | using-any
    //   | using-alias
    //   | using-block
    //   | namepath-free
    public static boolean using_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_TERM, "<using term>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = using_any(b, l + 1);
        if (!r) r = using_alias(b, l + 1);
        if (!r) r = using_block(b, l + 1);
        if (!r) r = namepath_free(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L BRACE_R
    public static boolean where_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "where_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, BRACE_L, BRACE_R);
        exit_section_(b, m, WHERE_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // attribute-below* KW_WHILE expression-inline block-body
    public static boolean while_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "while_statement")) return false;
        if (!nextTokenIs(b, "<while statement>", HASH, KW_WHILE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, "<while statement>");
        r = while_statement_0(b, l + 1);
        r = r && consumeToken(b, KW_WHILE);
        p = r; // pin = 2
        r = r && report_error_(b, expression_inline(b, l + 1));
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // attribute-below*
    private static boolean while_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "while_statement_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "while_statement_0", c)) break;
        }
        return true;
    }

}
