// This is a generated file. Not intended for manual editing.
package valkyrie.psi.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static valkyrie.psi.ParserExtension.*;
import static valkyrie.psi.ValkyrieTypes.*;

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
            create_token_set_(MACRO_PATH, NAMEPATH_SAFE),
    };

    /* ********************************************************** */
    // ANGLE_L (<<term>> (COMMA <<term>>)* COMMA?)? ANGLE_R
    static boolean angle(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "angle")) return false;
        if (!nextTokenIs(b, ANGLE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, ANGLE_L);
        r = r && angle_1(b, l + 1, _term);
        r = r && consumeToken(b, ANGLE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (<<term>> (COMMA <<term>>)* COMMA?)?
    private static boolean angle_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "angle_1")) return false;
        angle_1_0(b, l + 1, _term);
        return true;
    }

    // <<term>> (COMMA <<term>>)* COMMA?
    private static boolean angle_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "angle_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = _term.parse(b, l);
        r = r && angle_1_0_1(b, l + 1, _term);
        r = r && angle_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA <<term>>)*
    private static boolean angle_1_0_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "angle_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!angle_1_0_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "angle_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA <<term>>
    private static boolean angle_1_0_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "angle_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean angle_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "angle_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

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
    // (identifier-safe BIND)? expression-root {
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

    // (identifier-safe BIND)?
    private static boolean argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0")) return false;
        argument_0_0(b, l + 1);
        return true;
    }

    // identifier-safe BIND
    private static boolean argument_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_safe(b, l + 1);
        r = r && consumeToken(b, BIND);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean argument_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // <<parenthesis argument>>
    public static boolean argument_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "argument_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parenthesis(b, l + 1, YggdrasilParser::argument);
        exit_section_(b, m, ARGUMENT_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_TYPE identifier-safe (EQUAL type-expression)?
    public static boolean associated_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "associated_type")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ASSOCIATED_TYPE, "<associated type>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TYPE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && associated_type_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (EQUAL type-expression)?
    private static boolean associated_type_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "associated_type_3")) return false;
        associated_type_3_0(b, l + 1);
        return true;
    }

    // EQUAL type-expression
    private static boolean associated_type_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "associated_type_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L expression-root PARENTHESIS_R
    //     | TEMPLATE_L expression-root TEMPLATE_R
    //     | FLOOR_L expression-root FLOOR_R // ⌊5/2.0⌋
    //     | FLOOR_L expression-root CEIL_R  // ⌊5/2.0⌉
    //     | CEIL_L expression-root FLOOR_R  // ⌈5/2.0⌋
    //     | CEIL_L expression-root CEIL_R   // ⌈5/2.0⌉
    //     | tuple               // ( )
    //     | offset-range        // ⁅ ⁆
    //     | ordinal-range       // [ ]
    //     | macro-call          // @path::id() { }
    //     | slot                // $id
    //     | localize-call       // ⸿scope.path
    //     | if-statement        // if ...
    //     | loop-template       // <% loop ... %> <% end %>
    //     | loop-statement      // loop {...}
    //     | control-yield-type  // yield type i32
    //     | may-let-statement   // let? Some(x) = X
    //     | try-let-statement   // if case ...
    //     | try-not-statement
    //     | try-statement       // try T {...}
    //     | control-raise       // raise T
    //     | match-statement     // match ... { ... }
    //     | new-value           // new T { ... }
    //     | new-object          // object(base): Interface { }
    //     | new-lambda          // lambda<T>(x, y) -> T
    //     | string              // handler"..."
    //     | special             // true false
    //     | function-call       // path::id() { }
    //     | namepath-safe
    //     | number-literal
    public static boolean atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ATOMIC, "<atomic>");
        r = atomic_0(b, l + 1);
        if (!r) r = atomic_1(b, l + 1);
        if (!r) r = atomic_2(b, l + 1);
        if (!r) r = atomic_3(b, l + 1);
        if (!r) r = atomic_4(b, l + 1);
        if (!r) r = atomic_5(b, l + 1);
        if (!r) r = tuple(b, l + 1);
        if (!r) r = offset_range(b, l + 1);
        if (!r) r = ordinal_range(b, l + 1);
        if (!r) r = macro_call(b, l + 1);
        if (!r) r = slot(b, l + 1);
        if (!r) r = localize_call(b, l + 1);
        if (!r) r = if_statement(b, l + 1);
        if (!r) r = loop_template(b, l + 1);
        if (!r) r = loop_statement(b, l + 1);
        if (!r) r = control_yield_type(b, l + 1);
        if (!r) r = may_let_statement(b, l + 1);
        if (!r) r = try_let_statement(b, l + 1);
        if (!r) r = try_not_statement(b, l + 1);
        if (!r) r = try_statement(b, l + 1);
        if (!r) r = control_raise(b, l + 1);
        if (!r) r = match_statement(b, l + 1);
        if (!r) r = new_value(b, l + 1);
        if (!r) r = new_object(b, l + 1);
        if (!r) r = new_lambda(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = special(b, l + 1);
        if (!r) r = function_call(b, l + 1);
        if (!r) r = namepath_safe(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
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

    // TEMPLATE_L expression-root TEMPLATE_R
    private static boolean atomic_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, TEMPLATE_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, TEMPLATE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // FLOOR_L expression-root FLOOR_R
    private static boolean atomic_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, FLOOR_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, FLOOR_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // FLOOR_L expression-root CEIL_R
    private static boolean atomic_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, FLOOR_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, CEIL_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // CEIL_L expression-root FLOOR_R
    private static boolean atomic_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_4")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, CEIL_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, FLOOR_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // CEIL_L expression-root CEIL_R
    private static boolean atomic_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "atomic_5")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, CEIL_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, CEIL_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // OP_MACRO_UPPER attribute-list
    public static boolean attribute_above(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_above")) return false;
        if (!nextTokenIs(b, OP_MACRO_UPPER)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_ABOVE, null);
        r = consumeToken(b, OP_MACRO_UPPER);
        p = r; // pin = 1
        r = r && attribute_list(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // OP_MACRO_LOWER attribute-list
    public static boolean attribute_below(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_below")) return false;
        if (!nextTokenIs(b, OP_MACRO_LOWER)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_BELOW, null);
        r = consumeToken(b, OP_MACRO_LOWER);
        p = r; // pin = 1
        r = r && attribute_list(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // namepath-free (DOT identifier-free)? generic-call? argument-body? class-body?
    public static boolean attribute_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_ITEM, "<attribute item>");
        r = namepath_free(b, l + 1);
        r = r && attribute_item_1(b, l + 1);
        r = r && attribute_item_2(b, l + 1);
        r = r && attribute_item_3(b, l + 1);
        r = r && attribute_item_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (DOT identifier-free)?
    private static boolean attribute_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_1")) return false;
        attribute_item_1_0(b, l + 1);
        return true;
    }

    // DOT identifier-free
    private static boolean attribute_item_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // generic-call?
    private static boolean attribute_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_2")) return false;
        generic_call(b, l + 1);
        return true;
    }

    // argument-body?
    private static boolean attribute_item_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_3")) return false;
        argument_body(b, l + 1);
        return true;
    }

    // class-body?
    private static boolean attribute_item_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_item_4")) return false;
        class_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // attribute-item
    //     | '[' attribute-item (',' attribute-item)* ','? ']'
    public static boolean attribute_list(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_list")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_LIST, "<attribute list>");
        r = attribute_item(b, l + 1);
        if (!r) r = attribute_list_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // '[' attribute-item (',' attribute-item)* ','? ']'
    private static boolean attribute_list_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_list_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && attribute_item(b, l + 1);
        r = r && attribute_list_1_2(b, l + 1);
        r = r && attribute_list_1_3(b, l + 1);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (',' attribute-item)*
    private static boolean attribute_list_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_list_1_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_list_1_2_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "attribute_list_1_2", c)) break;
        }
        return true;
    }

    // ',' attribute-item
    private static boolean attribute_list_1_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_list_1_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && attribute_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // ','?
    private static boolean attribute_list_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "attribute_list_1_3")) return false;
        consumeToken(b, COMMA);
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
    //     | OP_LL ANGLE_L
    //     | ANGLE_L OP_LL
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
    //     | OP_RR ANGLE_R
    //     | ANGLE_R OP_RR
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
    // bare-pattern-item (COMMA bare-pattern-item)* COMMA?
    public static boolean bare_pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, BARE_PATTERN, "<bare pattern>");
        r = bare_pattern_item(b, l + 1);
        r = r && bare_pattern_1(b, l + 1);
        r = r && bare_pattern_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (COMMA bare-pattern-item)*
    private static boolean bare_pattern_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!bare_pattern_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "bare_pattern_1", c)) break;
        }
        return true;
    }

    // COMMA bare-pattern-item
    private static boolean bare_pattern_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && bare_pattern_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean bare_pattern_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // modifier* identifier-safe
    public static boolean bare_pattern_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, BARE_PATTERN_ITEM, "<bare pattern item>");
        r = bare_pattern_item_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // modifier*
    private static boolean bare_pattern_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bare_pattern_item_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "bare_pattern_item_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // <<brace benchmark-unit>>
    public static boolean benchmark_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "benchmark_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::benchmark_unit);
        exit_section_(b, m, BENCHMARK_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // identifier-free argument-body? new-body? {
    // }
    public static boolean benchmark_unit(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "benchmark_unit")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, BENCHMARK_UNIT, "<benchmark unit>");
        r = identifier_free(b, l + 1);
        r = r && benchmark_unit_1(b, l + 1);
        r = r && benchmark_unit_2(b, l + 1);
        r = r && benchmark_unit_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // argument-body?
    private static boolean benchmark_unit_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "benchmark_unit_1")) return false;
        argument_body(b, l + 1);
        return true;
    }

    // new-body?
    private static boolean benchmark_unit_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "benchmark_unit_2")) return false;
        new_body(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean benchmark_unit_3(PsiBuilder b, int l) {
        return true;
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
    // <<brace block-statement>>
    public static boolean block_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::block_statement);
        exit_section_(b, m, BLOCK_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | let-statement
    //     | attribute-above
    //     | control-statement
    //     | expression-root
    static boolean block_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_statement")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = let_statement(b, l + 1);
        if (!r) r = attribute_above(b, l + 1);
        if (!r) r = control_statement(b, l + 1);
        if (!r) r = expression_root(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L (COMMA|SEMICOLON|<<term>>)* BRACE_R
    static boolean brace(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "brace")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && brace_1(b, l + 1, _term);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA|SEMICOLON|<<term>>)*
    private static boolean brace_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "brace_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!brace_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "brace_1", c)) break;
        }
        return true;
    }

    // COMMA|SEMICOLON|<<term>>
    private static boolean brace_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "brace_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // BRACKET_L (<<term>> (COMMA <<term>>)* COMMA?)? BRACKET_R
    static boolean bracket(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "bracket")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && bracket_1(b, l + 1, _term);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (<<term>> (COMMA <<term>>)* COMMA?)?
    private static boolean bracket_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "bracket_1")) return false;
        bracket_1_0(b, l + 1, _term);
        return true;
    }

    // <<term>> (COMMA <<term>>)* COMMA?
    private static boolean bracket_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "bracket_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = _term.parse(b, l);
        r = r && bracket_1_0_1(b, l + 1, _term);
        r = r && bracket_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA <<term>>)*
    private static boolean bracket_1_0_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "bracket_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!bracket_1_0_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "bracket_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA <<term>>
    private static boolean bracket_1_0_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "bracket_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean bracket_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "bracket_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // NAME_SPLIT | COLON COLON
    static boolean c2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "c2")) return false;
        if (!nextTokenIs(b, "", COLON, NAME_SPLIT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        if (!r) r = parseTokens(b, 0, COLON, COLON);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // NAME_SPLIT|PARENTHESIS_L|BRACE_L|BRACKET_L
    static boolean case_id_stop(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_id_stop")) return false;
        boolean r;
        r = consumeToken(b, NAME_SPLIT);
        if (!r) r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, BRACE_L);
        if (!r) r = consumeToken(b, BRACKET_L);
        return r;
    }

    /* ********************************************************** */
    // special
    //     | case-pattern-list    // case Some()
    //     | case-pattern-dict    // case Object { }
    //     | string               // case "text"
    //     | number-literal       // case 1
    //     | namepath-safe
    public static boolean case_pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN, "<case pattern>");
        r = special(b, l + 1);
        if (!r) r = case_pattern_list(b, l + 1);
        if (!r) r = case_pattern_dict(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = namepath_safe(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // ASSIGN_L | OP_MACRO | BIND
    public static boolean case_pattern_bind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_bind")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_BIND, "<case pattern bind>");
        r = consumeToken(b, ASSIGN_L);
        if (!r) r = consumeToken(b, OP_MACRO);
        if (!r) r = consumeToken(b, BIND);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // namepath-safe? <<brace case-pattern-pair>>
    public static boolean case_pattern_dict(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_dict")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_DICT, "<case pattern dict>");
        r = case_pattern_dict_0(b, l + 1);
        r = r && brace(b, l + 1, YggdrasilParser::case_pattern_pair);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-safe?
    private static boolean case_pattern_dict_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_dict_0")) return false;
        namepath_safe(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations (ANY_LIST|ANY_DICT)? identifier-safe !case-id-stop ((COLON|KW_IS) type-expression)? (case-pattern-bind case-pattern)? | case-pattern
    public static boolean case_pattern_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_ITEM, "<case pattern item>");
        r = case_pattern_item_0(b, l + 1);
        if (!r) r = case_pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // annotations (ANY_LIST|ANY_DICT)? identifier-safe !case-id-stop ((COLON|KW_IS) type-expression)? (case-pattern-bind case-pattern)?
    private static boolean case_pattern_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && case_pattern_item_0_1(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && case_pattern_item_0_3(b, l + 1);
        r = r && case_pattern_item_0_4(b, l + 1);
        r = r && case_pattern_item_0_5(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (ANY_LIST|ANY_DICT)?
    private static boolean case_pattern_item_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_1")) return false;
        case_pattern_item_0_1_0(b, l + 1);
        return true;
    }

    // ANY_LIST|ANY_DICT
    private static boolean case_pattern_item_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_1_0")) return false;
        boolean r;
        r = consumeToken(b, ANY_LIST);
        if (!r) r = consumeToken(b, ANY_DICT);
        return r;
    }

    // !case-id-stop
    private static boolean case_pattern_item_0_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_3")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !case_id_stop(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // ((COLON|KW_IS) type-expression)?
    private static boolean case_pattern_item_0_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_4")) return false;
        case_pattern_item_0_4_0(b, l + 1);
        return true;
    }

    // (COLON|KW_IS) type-expression
    private static boolean case_pattern_item_0_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_item_0_4_0_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COLON|KW_IS
    private static boolean case_pattern_item_0_4_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_4_0_0")) return false;
        boolean r;
        r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, KW_IS);
        return r;
    }

    // (case-pattern-bind case-pattern)?
    private static boolean case_pattern_item_0_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_5")) return false;
        case_pattern_item_0_5_0(b, l + 1);
        return true;
    }

    // case-pattern-bind case-pattern
    private static boolean case_pattern_item_0_5_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_item_0_5_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_bind(b, l + 1);
        r = r && case_pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // OP_OR|OP_AND|LOGIC_AND|LOGIC_OR
    public static boolean case_pattern_kind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_kind")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_KIND, "<case pattern kind>");
        r = consumeToken(b, OP_OR);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, LOGIC_AND);
        if (!r) r = consumeToken(b, LOGIC_OR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // <<bracket case-pattern-main>>
    //     | namepath-safe?  <<parenthesis case-pattern-main>>
    public static boolean case_pattern_list(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_list")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_LIST, "<case pattern list>");
        r = bracket(b, l + 1, YggdrasilParser::case_pattern_main);
        if (!r) r = case_pattern_list_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-safe?  <<parenthesis case-pattern-main>>
    private static boolean case_pattern_list_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_list_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_list_1_0(b, l + 1);
        r = r && parenthesis(b, l + 1, YggdrasilParser::case_pattern_main);
        exit_section_(b, m, null, r);
        return r;
    }

    // namepath-safe?
    private static boolean case_pattern_list_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_list_1_0")) return false;
        namepath_safe(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // case-pattern-kind? case-pattern-item case-pattern-rest*
    public static boolean case_pattern_main(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_main")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_MAIN, "<case pattern main>");
        r = case_pattern_main_0(b, l + 1);
        r = r && case_pattern_item(b, l + 1);
        r = r && case_pattern_main_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // case-pattern-kind?
    private static boolean case_pattern_main_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_main_0")) return false;
        case_pattern_kind(b, l + 1);
        return true;
    }

    // case-pattern-rest*
    private static boolean case_pattern_main_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_main_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!case_pattern_rest(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "case_pattern_main_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // annotations (ANY_LIST|ANY_DICT)? identifier-safe (COLON type-expression)? (case-pattern-bind case-pattern)?
    public static boolean case_pattern_pair(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_PAIR, "<case pattern pair>");
        r = annotations(b, l + 1);
        r = r && case_pattern_pair_1(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && case_pattern_pair_3(b, l + 1);
        r = r && case_pattern_pair_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (ANY_LIST|ANY_DICT)?
    private static boolean case_pattern_pair_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_1")) return false;
        case_pattern_pair_1_0(b, l + 1);
        return true;
    }

    // ANY_LIST|ANY_DICT
    private static boolean case_pattern_pair_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_1_0")) return false;
        boolean r;
        r = consumeToken(b, ANY_LIST);
        if (!r) r = consumeToken(b, ANY_DICT);
        return r;
    }

    // (COLON type-expression)?
    private static boolean case_pattern_pair_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_3")) return false;
        case_pattern_pair_3_0(b, l + 1);
        return true;
    }

    // COLON type-expression
    private static boolean case_pattern_pair_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (case-pattern-bind case-pattern)?
    private static boolean case_pattern_pair_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_4")) return false;
        case_pattern_pair_4_0(b, l + 1);
        return true;
    }

    // case-pattern-bind case-pattern
    private static boolean case_pattern_pair_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_pair_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_bind(b, l + 1);
        r = r && case_pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // case-pattern-kind case-pattern-item
    public static boolean case_pattern_rest(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_rest")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_REST, "<case pattern rest>");
        r = case_pattern_kind(b, l + 1);
        r = r && case_pattern_item(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // modifier* identifier-safe !case-id-stop (KW_IS type-expression)? (case-pattern-bind case-pattern)? | case-pattern
    public static boolean case_pattern_top(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CASE_PATTERN_TOP, "<case pattern top>");
        r = case_pattern_top_0(b, l + 1);
        if (!r) r = case_pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // modifier* identifier-safe !case-id-stop (KW_IS type-expression)? (case-pattern-bind case-pattern)?
    private static boolean case_pattern_top_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_top_0_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && case_pattern_top_0_2(b, l + 1);
        r = r && case_pattern_top_0_3(b, l + 1);
        r = r && case_pattern_top_0_4(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // modifier*
    private static boolean case_pattern_top_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "case_pattern_top_0_0", c)) break;
        }
        return true;
    }

    // !case-id-stop
    private static boolean case_pattern_top_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_2")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !case_id_stop(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (KW_IS type-expression)?
    private static boolean case_pattern_top_0_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_3")) return false;
        case_pattern_top_0_3_0(b, l + 1);
        return true;
    }

    // KW_IS type-expression
    private static boolean case_pattern_top_0_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_IS);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (case-pattern-bind case-pattern)?
    private static boolean case_pattern_top_0_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_4")) return false;
        case_pattern_top_0_4_0(b, l + 1);
        return true;
    }

    // case-pattern-bind case-pattern
    private static boolean case_pattern_top_0_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "case_pattern_top_0_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_bind(b, l + 1);
        r = r && case_pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // <<brace class-item>>
    public static boolean class_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::class_item);
        exit_section_(b, m, CLASS_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // <<parenthesis inherit-item>>
    public static boolean class_inherit(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_inherit")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parenthesis(b, l + 1, YggdrasilParser::inherit_item);
        exit_section_(b, m, CLASS_INHERIT, r);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | associated-type
    //     | declare-domain
    //     | declare-method
    //     | declare-field
    static boolean class_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "class_item")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = associated_type(b, l + 1);
        if (!r) r = declare_domain(b, l + 1);
        if (!r) r = declare_method(b, l + 1);
        if (!r) r = declare_field(b, l + 1);
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
    // OP_LABEL (SYMBOL|SYMBOL_RAW|INTEGER|KW_MACRO|KW_FOR|KW_WHILE)
    public static boolean control_label(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_label")) return false;
        if (!nextTokenIs(b, OP_LABEL)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_LABEL);
        r = r && control_label_1(b, l + 1);
        exit_section_(b, m, CONTROL_LABEL, r);
        return r;
    }

    // SYMBOL|SYMBOL_RAW|INTEGER|KW_MACRO|KW_FOR|KW_WHILE
    private static boolean control_label_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_label_1")) return false;
        boolean r;
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOL_RAW);
        if (!r) r = consumeToken(b, INTEGER);
        if (!r) r = consumeToken(b, KW_MACRO);
        if (!r) r = consumeToken(b, KW_FOR);
        if (!r) r = consumeToken(b, KW_WHILE);
        return r;
    }

    /* ********************************************************** */
    // KW_RAISE expression-root
    //     | KW_RAISE KW_USING expression-root
    //     | KW_RAISE KW_TYPE type-expression
    public static boolean control_raise(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_raise")) return false;
        if (!nextTokenIs(b, KW_RAISE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = control_raise_0(b, l + 1);
        if (!r) r = control_raise_1(b, l + 1);
        if (!r) r = control_raise_2(b, l + 1);
        exit_section_(b, m, CONTROL_RAISE, r);
        return r;
    }

    // KW_RAISE expression-root
    private static boolean control_raise_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_raise_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RAISE);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_RAISE KW_USING expression-root
    private static boolean control_raise_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_raise_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_RAISE, KW_USING);
        r = r && expression_root(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_RAISE KW_TYPE type-expression
    private static boolean control_raise_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_raise_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_RAISE, KW_TYPE);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
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
    //     | control-yield-send    // generator<Yield=T, Return=()>
    //     | control-yield-stop    // generator<Yield=R, Return=()>
    //     | control-yield-from
    //     | control-continue
    //     | control-break
    //     | control-through
    //     | control-resume
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
    // KW_YIELD KW_WITH KW_TYPE type-expression?
    //   | KW_YIELD KW_TYPE control-label? type-expression?
    public static boolean control_yield_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type")) return false;
        if (!nextTokenIs(b, KW_YIELD)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = control_yield_type_0(b, l + 1);
        if (!r) r = control_yield_type_1(b, l + 1);
        exit_section_(b, m, CONTROL_YIELD_TYPE, r);
        return r;
    }

    // KW_YIELD KW_WITH KW_TYPE type-expression?
    private static boolean control_yield_type_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_WITH, KW_TYPE);
        r = r && control_yield_type_0_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // type-expression?
    private static boolean control_yield_type_0_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type_0_3")) return false;
        type_expression(b, l + 1);
        return true;
    }

    // KW_YIELD KW_TYPE control-label? type-expression?
    private static boolean control_yield_type_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_YIELD, KW_TYPE);
        r = r && control_yield_type_1_2(b, l + 1);
        r = r && control_yield_type_1_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // control-label?
    private static boolean control_yield_type_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type_1_2")) return false;
        control_label(b, l + 1);
        return true;
    }

    // type-expression?
    private static boolean control_yield_type_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_yield_type_1_3")) return false;
        type_expression(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // declare-infer? annotations KW_CLASS identifier-safe declare-generic? class-inherit? type-hint? class-body
    public static boolean declare_class(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_CLASS, "<declare class>");
        r = declare_class_0(b, l + 1);
        r = r && annotations(b, l + 1);
        r = r && consumeToken(b, KW_CLASS);
        p = r; // pin = 3
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_class_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_5(b, l + 1)) && r;
        r = p && report_error_(b, declare_class_6(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_class_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_class_0")) return false;
        declare_infer(b, l + 1);
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
    // annotations KW_COMPONENT identifier-safe declare-generic? class-inherit? type-hint? class-body
    public static boolean declare_component(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_COMPONENT, "<declare component>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_COMPONENT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_component_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_component_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_component_5(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_component_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // class-inherit?
    private static boolean declare_component_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_4")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_component_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_component_5")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe class-body
    public static boolean declare_domain(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_domain")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_DOMAIN, "<declare domain>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && class_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_ENUMERATE identifier-safe class-inherit? (EQUAL type-atomic)? flags-body
    public static boolean declare_enums(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enums")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_ENUMS, "<declare enums>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_ENUMERATE);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_enums_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_enums_4(b, l + 1)) && r;
        r = p && flags_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean declare_enums_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enums_3")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // (EQUAL type-atomic)?
    private static boolean declare_enums_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enums_4")) return false;
        declare_enums_4_0(b, l + 1);
        return true;
    }

    // EQUAL type-atomic
    private static boolean declare_enums_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enums_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && type_atomic(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // annotations identifier-free type-hint? default-value?
    public static boolean declare_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FIELD, "<declare field>");
        r = annotations(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && declare_field_2(b, l + 1);
        r = r && declare_field_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
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
    // annotations KW_FLAGS identifier-free class-inherit? (EQUAL type-atomic)? flags-body
    public static boolean declare_flags(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FLAGS, "<declare flags>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_FLAGS);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, declare_flags_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_flags_4(b, l + 1)) && r;
        r = p && flags_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean declare_flags_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags_3")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // (EQUAL type-atomic)?
    private static boolean declare_flags_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags_4")) return false;
        declare_flags_4_0(b, l + 1);
        return true;
    }

    // EQUAL type-atomic
    private static boolean declare_flags_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_flags_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && type_atomic(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_MICRO declare-infer? identifier-safe parameter-body return-type? block-body
    public static boolean declare_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FUNCTION, "<declare function>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_MICRO);
        p = r; // pin = 2
        r = r && report_error_(b, declare_function_2(b, l + 1));
        r = p && report_error_(b, identifier_safe(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_function_5(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_function_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_2")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_function_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // NAME_SPLIT? <<generic generic-parameter>>
    //   | NAME_SPLIT? <<angle generic-parameter>>
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

    // NAME_SPLIT? <<generic generic-parameter>>
    private static boolean declare_generic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = declare_generic_0_0(b, l + 1);
        r = r && generic(b, l + 1, YggdrasilParser::generic_parameter);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean declare_generic_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_0_0")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // NAME_SPLIT? <<angle generic-parameter>>
    // {
    // }
    private static boolean declare_generic_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = declare_generic_1_0(b, l + 1);
        r = r && angle(b, l + 1, YggdrasilParser::generic_parameter);
        r = r && declare_generic_1_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean declare_generic_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_0")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // {
    // }
    private static boolean declare_generic_1_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations KW_IMPLY declare-infer? (
    //     // impl class: trait
    //     namepath-safe generic-call-free? COLON type-expression
    //     // impl trait for class
    //   | type-expression KW_FOR namepath-safe generic-call-free?
    // ) class-body
    public static boolean declare_imply(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_IMPLY, "<declare imply>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_IMPLY);
        p = r; // pin = 2
        r = r && report_error_(b, declare_imply_2(b, l + 1));
        r = p && report_error_(b, declare_imply_3(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_imply_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_2")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // namepath-safe generic-call-free? COLON type-expression
    //     // impl trait for class
    //   | type-expression KW_FOR namepath-safe generic-call-free?
    private static boolean declare_imply_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = declare_imply_3_0(b, l + 1);
        if (!r) r = declare_imply_3_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // namepath-safe generic-call-free? COLON type-expression
    private static boolean declare_imply_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = namepath_safe(b, l + 1);
        r = r && declare_imply_3_0_1(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // generic-call-free?
    private static boolean declare_imply_3_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_3_0_1")) return false;
        generic_call_free(b, l + 1);
        return true;
    }

    // type-expression KW_FOR namepath-safe generic-call-free?
    private static boolean declare_imply_3_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_3_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_expression(b, l + 1);
        r = r && consumeToken(b, KW_FOR);
        r = r && namepath_safe(b, l + 1);
        r = r && declare_imply_3_1_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // generic-call-free?
    private static boolean declare_imply_3_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_imply_3_1_3")) return false;
        generic_call_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_INFER (identifier-safe (COMMA identifier-safe)* COMMA?)? infer-body
    public static boolean declare_infer(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_INFER, "<declare infer>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_INFER);
        p = r; // pin = 2
        r = r && report_error_(b, declare_infer_2(b, l + 1));
        r = p && infer_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (identifier-safe (COMMA identifier-safe)* COMMA?)?
    private static boolean declare_infer_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer_2")) return false;
        declare_infer_2_0(b, l + 1);
        return true;
    }

    // identifier-safe (COMMA identifier-safe)* COMMA?
    private static boolean declare_infer_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_safe(b, l + 1);
        r = r && declare_infer_2_0_1(b, l + 1);
        r = r && declare_infer_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier-safe)*
    private static boolean declare_infer_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_infer_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_infer_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA identifier-safe
    private static boolean declare_infer_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_infer_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_infer_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_MACRO declare-infer? identifier-safe parameter-body return-type? block-body
    public static boolean declare_macro(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_MACRO, "<declare macro>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_MACRO);
        p = r; // pin = 2
        r = r && report_error_(b, declare_macro_2(b, l + 1));
        r = p && report_error_(b, identifier_safe(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_macro_5(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_macro_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro_2")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_macro_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_macro_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_FUNCTION? identifier-free declare-infer? parameter-body return-type? block-body?
    public static boolean declare_method(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_METHOD, "<declare method>");
        r = annotations(b, l + 1);
        r = r && declare_method_1(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && declare_method_3(b, l + 1);
        r = r && parameter_body(b, l + 1);
        r = r && declare_method_5(b, l + 1);
        r = r && declare_method_6(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_FUNCTION?
    private static boolean declare_method_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_1")) return false;
        consumeToken(b, KW_FUNCTION);
        return true;
    }

    // declare-infer?
    private static boolean declare_method_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_3")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_method_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    // block-body?
    private static boolean declare_method_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method_6")) return false;
        block_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_MEZZO declare-infer? identifier-safe parameter-body return-type? block-body
    public static boolean declare_mezzo(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_mezzo")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_MEZZO, "<declare mezzo>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_MEZZO);
        p = r; // pin = 2
        r = r && report_error_(b, declare_mezzo_2(b, l + 1));
        r = p && report_error_(b, identifier_safe(b, l + 1)) && r;
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, declare_mezzo_5(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_mezzo_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_mezzo_2")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_mezzo_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_mezzo_5")) return false;
        return_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_NAMESPACE namepath-auto
    public static boolean declare_namespace(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_namespace")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_NAMESPACE, "<declare namespace>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_NAMESPACE);
        p = r; // pin = 2
        r = r && namepath_auto(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // annotations KW_NEURAL identifier-safe declare-generic? class-inherit? type-hint? class-body
    public static boolean declare_neural(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_neural")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_NEURAL, "<declare neural>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_NEURAL);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_neural_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_neural_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_neural_5(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_neural_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_neural_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // class-inherit?
    private static boolean declare_neural_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_neural_4")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_neural_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_neural_5")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe (EQUAL expression)?
    public static boolean declare_semantic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SEMANTIC, "<declare semantic>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && declare_semantic_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (EQUAL expression)?
    private static boolean declare_semantic_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic_2")) return false;
        declare_semantic_2_0(b, l + 1);
        return true;
    }

    // EQUAL expression
    private static boolean declare_semantic_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_semantic_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, EQUAL);
        r = r && expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_SINGLETON identifier-safe declare-generic? class-inherit? type-hint? class-body
    public static boolean declare_singleton(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_singleton")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SINGLETON, "<declare singleton>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_SINGLETON);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_singleton_3(b, l + 1)) && r;
        r = p && report_error_(b, declare_singleton_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_singleton_5(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-generic?
    private static boolean declare_singleton_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_singleton_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // class-inherit?
    private static boolean declare_singleton_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_singleton_4")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean declare_singleton_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_singleton_5")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_TESTS identifier-free? tests-body
    public static boolean declare_tests(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_tests")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TESTS, "<declare tests>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TESTS);
        p = r; // pin = 2
        r = r && report_error_(b, declare_tests_2(b, l + 1));
        r = p && tests_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // identifier-free?
    private static boolean declare_tests_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_tests_2")) return false;
        identifier_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_TRAIT identifier-safe (trait-alias|trait-define)
    public static boolean declare_trait(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TRAIT, "<declare trait>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && declare_trait_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // trait-alias|trait-define
    private static boolean declare_trait_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_3")) return false;
        boolean r;
        r = trait_alias(b, l + 1);
        if (!r) r = trait_define(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_TYPE (type-alias|type-function)
    public static boolean declare_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_type")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TYPE, "<declare type>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_TYPE);
        p = r; // pin = 2
        r = r && declare_type_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-alias|type-function
    private static boolean declare_type_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_type_2")) return false;
        boolean r;
        r = type_alias(b, l + 1);
        if (!r) r = type_function(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_UNION identifier-safe class-body
    public static boolean declare_union(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_union")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNION, "<declare union>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNION);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // declare-infer? annotations KW_UNITE identifier-safe declare-infer? unite-body
    public static boolean declare_unite(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_UNITE, "<declare unite>");
        r = declare_unite_0(b, l + 1);
        r = r && annotations(b, l + 1);
        r = r && consumeToken(b, KW_UNITE);
        p = r; // pin = 3
        r = r && report_error_(b, identifier_safe(b, l + 1));
        r = p && report_error_(b, declare_unite_4(b, l + 1)) && r;
        r = p && unite_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean declare_unite_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite_0")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // declare-infer?
    private static boolean declare_unite_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_unite_4")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe class-body?
    public static boolean declare_variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variant")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_VARIANT, "<declare variant>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
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
    // KW_WHERE COLON? where-term*
    public static boolean declare_where(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_where")) return false;
        if (!nextTokenIs(b, KW_WHERE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_WHERE, null);
        r = consumeToken(b, KW_WHERE);
        p = r; // pin = 1
        r = r && report_error_(b, declare_where_1(b, l + 1));
        r = p && declare_where_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // COLON?
    private static boolean declare_where_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_where_1")) return false;
        consumeToken(b, COLON);
        return true;
    }

    // where-term*
    private static boolean declare_where_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_where_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!where_term(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_where_2", c)) break;
        }
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
    // OP_AND_THEN? DOT namepath-safe (argument-body | argument-body? block-body)?
    public static boolean dot_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call")) return false;
        if (!nextTokenIs(b, "<dot call>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL, "<dot call>");
        r = dot_call_0(b, l + 1);
        r = r && consumeToken(b, DOT);
        r = r && namepath_safe(b, l + 1);
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
    // OP_AND_THEN? DOT namepath-safe argument-body?
    public static boolean dot_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_inline")) return false;
        if (!nextTokenIs(b, "<dot call inline>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_INLINE, "<dot call inline>");
        r = dot_call_inline_0(b, l + 1);
        r = r && consumeToken(b, DOT);
        r = r && namepath_safe(b, l + 1);
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
    // OP_AND_THEN? DOT OP_MACRO namepath-safe (argument-body? class-body|argument-body)?
    public static boolean dot_call_macro(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro")) return false;
        if (!nextTokenIs(b, "<dot call macro>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_MACRO, "<dot call macro>");
        r = dot_call_macro_0(b, l + 1);
        r = r && consumeTokens(b, 0, DOT, OP_MACRO);
        r = r && namepath_safe(b, l + 1);
        r = r && dot_call_macro_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean dot_call_macro_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // (argument-body? class-body|argument-body)?
    private static boolean dot_call_macro_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_4")) return false;
        dot_call_macro_4_0(b, l + 1);
        return true;
    }

    // argument-body? class-body|argument-body
    private static boolean dot_call_macro_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = dot_call_macro_4_0_0(b, l + 1);
        if (!r) r = argument_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? class-body
    private static boolean dot_call_macro_4_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_4_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = dot_call_macro_4_0_0_0(b, l + 1);
        r = r && class_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean dot_call_macro_4_0_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_4_0_0_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT OP_MACRO namepath-safe argument-body?
    public static boolean dot_call_macro_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_inline")) return false;
        if (!nextTokenIs(b, "<dot call macro inline>", DOT, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DOT_CALL_MACRO_INLINE, "<dot call macro inline>");
        r = dot_call_macro_inline_0(b, l + 1);
        r = r && consumeTokens(b, 0, DOT, OP_MACRO);
        r = r && namepath_safe(b, l + 1);
        r = r && dot_call_macro_inline_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean dot_call_macro_inline_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_inline_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // argument-body?
    private static boolean dot_call_macro_inline_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_call_macro_inline_4")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT KW_LOOP control-label? attribute-below* KW_EACH? loop-inline? if-condition? block-body
    public static boolean dot_loop_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call")) return false;
        if (!nextTokenIs(b, "<dot loop call>", DOT, OP_AND_THEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DOT_LOOP_CALL, "<dot loop call>");
        r = dot_loop_call_0(b, l + 1);
        r = r && consumeTokens(b, 2, DOT, KW_LOOP);
        p = r; // pin = 3
        r = r && report_error_(b, dot_loop_call_3(b, l + 1));
        r = p && report_error_(b, dot_loop_call_4(b, l + 1)) && r;
        r = p && report_error_(b, dot_loop_call_5(b, l + 1)) && r;
        r = p && report_error_(b, dot_loop_call_6(b, l + 1)) && r;
        r = p && report_error_(b, dot_loop_call_7(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_AND_THEN?
    private static boolean dot_loop_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // control-label?
    private static boolean dot_loop_call_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_3")) return false;
        control_label(b, l + 1);
        return true;
    }

    // attribute-below*
    private static boolean dot_loop_call_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_4")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "dot_loop_call_4", c)) break;
        }
        return true;
    }

    // KW_EACH?
    private static boolean dot_loop_call_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_5")) return false;
        consumeToken(b, KW_EACH);
        return true;
    }

    // loop-inline?
    private static boolean dot_loop_call_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_6")) return false;
        loop_inline(b, l + 1);
        return true;
    }

    // if-condition?
    private static boolean dot_loop_call_7(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_loop_call_7")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_AND_THEN? DOT match-kind (modifier* identifier-safe BIND)? match-body
    public static boolean dot_match_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_match_call")) return false;
        if (!nextTokenIs(b, "<dot match call>", DOT, OP_AND_THEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DOT_MATCH_CALL, "<dot match call>");
        r = dot_match_call_0(b, l + 1);
        r = r && consumeToken(b, DOT);
        r = r && match_kind(b, l + 1);
        p = r; // pin = 3
        r = r && report_error_(b, dot_match_call_3(b, l + 1));
        r = p && match_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // OP_AND_THEN?
    private static boolean dot_match_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_match_call_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // (modifier* identifier-safe BIND)?
    private static boolean dot_match_call_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_match_call_3")) return false;
        dot_match_call_3_0(b, l + 1);
        return true;
    }

    // modifier* identifier-safe BIND
    private static boolean dot_match_call_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_match_call_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = dot_match_call_3_0_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, BIND);
        exit_section_(b, m, null, r);
        return r;
    }

    // modifier*
    private static boolean dot_match_call_3_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dot_match_call_3_0_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "dot_match_call_3_0_0", c)) break;
        }
        return true;
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
    // TEMPLATE_L KW_ELSE TEMPLATE_R statements*
    public static boolean else_template(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_template")) return false;
        if (!nextTokenIs(b, TEMPLATE_L)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ELSE_TEMPLATE, null);
        r = consumeTokens(b, 2, TEMPLATE_L, KW_ELSE, TEMPLATE_R);
        p = r; // pin = 2
        r = r && else_template_3(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // statements*
    private static boolean else_template_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_template_3")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "else_template_3", c)) break;
        }
        return true;
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
    // inline-term (infix inline-term)*
    public static boolean expression_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION_INLINE, "<expression inline>");
        r = inline_term(b, l + 1);
        r = r && expression_inline_1(b, l + 1);
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

    /* ********************************************************** */
    // expression OP_AND_THEN? SEMICOLON? {
    // }
    public static boolean expression_root(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_root")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, EXPRESSION_ROOT, "<expression root>");
        r = expression(b, l + 1);
        r = r && expression_root_1(b, l + 1);
        r = r && expression_root_2(b, l + 1);
        r = r && expression_root_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean expression_root_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_root_1")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    // SEMICOLON?
    private static boolean expression_root_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "expression_root_2")) return false;
        consumeToken(b, SEMICOLON);
        return true;
    }

    // {
    // }
    private static boolean expression_root_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // <<brace flags-item>>
    public static boolean flags_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::flags_item);
        exit_section_(b, m, FLAGS_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | declare-method
    //     | declare-domain
    //     | declare-semantic
    static boolean flags_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_item")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = declare_method(b, l + 1);
        if (!r) r = declare_domain(b, l + 1);
        if (!r) r = declare_semantic(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // namepath-safe generic-call? (argument-body? block-body | argument-body)
    public static boolean function_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
        r = namepath_safe(b, l + 1);
        r = r && function_call_1(b, l + 1);
        r = r && function_call_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // generic-call?
    private static boolean function_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_1")) return false;
        generic_call(b, l + 1);
        return true;
    }

    // argument-body? block-body | argument-body
    private static boolean function_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = function_call_2_0(b, l + 1);
        if (!r) r = argument_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? block-body
    private static boolean function_call_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = function_call_2_0_0(b, l + 1);
        r = r && block_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean function_call_2_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_2_0_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath-safe argument-body
    public static boolean function_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_call_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL_INLINE, "<function call inline>");
        r = namepath_safe(b, l + 1);
        r = r && argument_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // GENERIC_L (<<term>> (COMMA <<term>>)* COMMA?)? GENERIC_R
    static boolean generic(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "generic")) return false;
        if (!nextTokenIs(b, GENERIC_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, GENERIC_L);
        r = r && generic_1(b, l + 1, _term);
        r = r && consumeToken(b, GENERIC_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (<<term>> (COMMA <<term>>)* COMMA?)?
    private static boolean generic_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "generic_1")) return false;
        generic_1_0(b, l + 1, _term);
        return true;
    }

    // <<term>> (COMMA <<term>>)* COMMA?
    private static boolean generic_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "generic_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = _term.parse(b, l);
        r = r && generic_1_0_1(b, l + 1, _term);
        r = r && generic_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA <<term>>)*
    private static boolean generic_1_0_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "generic_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_1_0_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "generic_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA <<term>>
    private static boolean generic_1_0_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "generic_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe COLON type-expression BIND type-expression
    //     | annotations identifier-safe COLON type-expression
    //     | annotations identifier-safe BIND type-expression
    //     | type-expression
    public static boolean generic_argument(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_ARGUMENT, "<generic argument>");
        r = generic_argument_0(b, l + 1);
        if (!r) r = generic_argument_1(b, l + 1);
        if (!r) r = generic_argument_2(b, l + 1);
        if (!r) r = type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // annotations identifier-safe COLON type-expression BIND type-expression
    private static boolean generic_argument_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        r = r && consumeToken(b, BIND);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // annotations identifier-safe COLON type-expression
    private static boolean generic_argument_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // annotations identifier-safe BIND type-expression
    private static boolean generic_argument_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_argument_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, BIND);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // NAME_SPLIT? <<generic generic-argument>> | NAME_SPLIT  <<angle generic-argument>>
    public static boolean generic_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call")) return false;
        if (!nextTokenIs(b, "<generic call>", GENERIC_L, NAME_SPLIT)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL, "<generic call>");
        r = generic_call_0(b, l + 1);
        if (!r) r = generic_call_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // NAME_SPLIT? <<generic generic-argument>>
    private static boolean generic_call_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_0_0(b, l + 1);
        r = r && generic(b, l + 1, YggdrasilParser::generic_argument);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean generic_call_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_0_0")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // NAME_SPLIT  <<angle generic-argument>>
    private static boolean generic_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && angle(b, l + 1, YggdrasilParser::generic_argument);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // NAME_SPLIT? <<generic generic-argument>> | NAME_SPLIT? <<angle generic-argument>>
    public static boolean generic_call_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL_FREE, "<generic call free>");
        r = generic_call_free_0(b, l + 1);
        if (!r) r = generic_call_free_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // NAME_SPLIT? <<generic generic-argument>>
    private static boolean generic_call_free_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_0_0(b, l + 1);
        r = r && generic(b, l + 1, YggdrasilParser::generic_argument);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean generic_call_free_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_0_0")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // NAME_SPLIT? <<angle generic-argument>>
    private static boolean generic_call_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_call_free_1_0(b, l + 1);
        r = r && angle(b, l + 1, YggdrasilParser::generic_argument);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean generic_call_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_free_1_0")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe type-hint? default-type?
    public static boolean generic_parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_parameter")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_PARAMETER, "<generic parameter>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
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
    // symbol-lead | symbol-safe | symbol
    public static boolean identifier_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_FREE, "<identifier free>");
        r = symbol_lead(b, l + 1);
        if (!r) r = symbol_safe(b, l + 1);
        if (!r) r = symbol(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // symbol-safe | symbol
    public static boolean identifier_safe(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier_safe")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_SAFE, "<identifier safe>");
        r = symbol_safe(b, l + 1);
        if (!r) r = symbol(b, l + 1);
        exit_section_(b, l, m, r, false, null);
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
    // <<brace infer-item>>
    public static boolean infer_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infer_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::infer_item);
        exit_section_(b, m, INFER_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | declare-where
    public static boolean infer_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infer_item")) return false;
        if (!nextTokenIs(b, "<infer item>", KW_WHERE, SEMICOLON)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFER_ITEM, "<infer item>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = declare_where(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_ADD  | OP_ADD_ASSIGN
    //     | OP_SUB | OP_SUB_ASSIGN
    //     | OP_OR
    //     | OP_AND
    //     | infix-multiple | OP_MUL_ASSIGN
    //     | OP_DIV | OP_DIV_ASSIGN
    //     | OP_DIV_ROUND
    //     | OP_DIV_FLOOR
    //     | OP_DIV_CEIL
    //     | OP_DIV_REM
    //     | OP_REM | OP_REM_ASSIGN
    //     | OP_POW
    //     | OP_SQRT
    //     | OP_LLL | bad-lll  // <<<
    //     | OP_GGG | bad-rrr  // >>>
    //     | OP_LL  | bad-ll   // <<
    //     | OP_GG  | bad-rr   // >>
    //     // compare
    //     | infix-less           // <
    //     | infix-less-equal     // <=
    //     | infix-greater        // >
    //     | infix-greater-equal  // >=
    //     // range
    //     | OP_UNTIL
    //     | BIND | ASSIGN_L | ASSIGN_R
    //     | OP_EE | OP_NE
    //     | infix-logical
    //     // sequence
    //     | OP_MAP // f /@ x
    //     | OP_UNWRAP_OR | OP_UNWRAP_ELSE
    public static boolean infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_ADD_ASSIGN);
        if (!r) r = consumeToken(b, OP_SUB);
        if (!r) r = consumeToken(b, OP_SUB_ASSIGN);
        if (!r) r = consumeToken(b, OP_OR);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = infix_multiple(b, l + 1);
        if (!r) r = consumeToken(b, OP_MUL_ASSIGN);
        if (!r) r = consumeToken(b, OP_DIV);
        if (!r) r = consumeToken(b, OP_DIV_ASSIGN);
        if (!r) r = consumeToken(b, OP_DIV_ROUND);
        if (!r) r = consumeToken(b, OP_DIV_FLOOR);
        if (!r) r = consumeToken(b, OP_DIV_CEIL);
        if (!r) r = consumeToken(b, OP_DIV_REM);
        if (!r) r = consumeToken(b, OP_REM);
        if (!r) r = consumeToken(b, OP_REM_ASSIGN);
        if (!r) r = consumeToken(b, OP_POW);
        if (!r) r = consumeToken(b, OP_SQRT);
        if (!r) r = consumeToken(b, OP_LLL);
        if (!r) r = bad_lll(b, l + 1);
        if (!r) r = consumeToken(b, OP_GGG);
        if (!r) r = bad_rrr(b, l + 1);
        if (!r) r = consumeToken(b, OP_LL);
        if (!r) r = bad_ll(b, l + 1);
        if (!r) r = consumeToken(b, OP_GG);
        if (!r) r = bad_rr(b, l + 1);
        if (!r) r = infix_less(b, l + 1);
        if (!r) r = infix_less_equal(b, l + 1);
        if (!r) r = infix_greater(b, l + 1);
        if (!r) r = infix_greater_equal(b, l + 1);
        if (!r) r = consumeToken(b, OP_UNTIL);
        if (!r) r = consumeToken(b, BIND);
        if (!r) r = consumeToken(b, ASSIGN_L);
        if (!r) r = consumeToken(b, ASSIGN_R);
        if (!r) r = consumeToken(b, OP_EE);
        if (!r) r = consumeToken(b, OP_NE);
        if (!r) r = infix_logical(b, l + 1);
        if (!r) r = consumeToken(b, OP_MAP);
        if (!r) r = consumeToken(b, OP_UNWRAP_OR);
        if (!r) r = consumeToken(b, OP_UNWRAP_ELSE);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // ANGLE_R
    public static boolean infix_greater(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_greater")) return false;
        if (!nextTokenIs(b, ANGLE_R)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, ANGLE_R);
        exit_section_(b, m, INFIX_GREATER, r);
        return r;
    }

    /* ********************************************************** */
    // OP_GEQ
    public static boolean infix_greater_equal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_greater_equal")) return false;
        if (!nextTokenIs(b, OP_GEQ)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_GEQ);
        exit_section_(b, m, INFIX_GREATER_EQUAL, r);
        return r;
    }

    /* ********************************************************** */
    // ANGLE_L
    public static boolean infix_less(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_less")) return false;
        if (!nextTokenIs(b, ANGLE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, ANGLE_L);
        exit_section_(b, m, INFIX_LESS, r);
        return r;
    }

    /* ********************************************************** */
    // OP_LEQ
    public static boolean infix_less_equal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_less_equal")) return false;
        if (!nextTokenIs(b, OP_LEQ)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_LEQ);
        exit_section_(b, m, INFIX_LESS_EQUAL, r);
        return r;
    }

    /* ********************************************************** */
    // LOGIC_AND | LOGIC_XAND | LOGIC_NAND | LOGIC_OR | LOGIC_XOR | LOGIC_NOR
    public static boolean infix_logical(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_logical")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFIX_LOGICAL, "<infix logical>");
        r = consumeToken(b, LOGIC_AND);
        if (!r) r = consumeToken(b, LOGIC_XAND);
        if (!r) r = consumeToken(b, LOGIC_NAND);
        if (!r) r = consumeToken(b, LOGIC_OR);
        if (!r) r = consumeToken(b, LOGIC_XOR);
        if (!r) r = consumeToken(b, LOGIC_NOR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_MUL | STAR
    public static boolean infix_multiple(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "infix_multiple")) return false;
        if (!nextTokenIs(b, "<infix multiple>", OP_MUL, STAR)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INFIX_MULTIPLE, "<infix multiple>");
        r = consumeToken(b, OP_MUL);
        if (!r) r = consumeToken(b, STAR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (annotations identifier-safe COLON)? type-expression
    public static boolean inherit_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INHERIT_ITEM, "<inherit item>");
        r = inherit_item_0(b, l + 1);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (annotations identifier-safe COLON)?
    private static boolean inherit_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item_0")) return false;
        inherit_item_0_0(b, l + 1);
        return true;
    }

    // annotations identifier-safe COLON
    private static boolean inherit_item_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inherit_item_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, COLON);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L expression-root PARENTHESIS_R
    //     | TEMPLATE_L expression-root TEMPLATE_R
    //     | FLOOR_L expression-root FLOOR_R // ⌊5/2.0⌋
    //     | FLOOR_L expression-root CEIL_R  // ⌊5/2.0⌉
    //     | CEIL_L expression-root FLOOR_R  // ⌈5/2.0⌋
    //     | CEIL_L expression-root CEIL_R   // ⌈5/2.0⌉
    //     | tuple                 // (1, 2, 3)
    //     | macro-call-inline     // @macro()
    //     | offset-range          // ⁅1:2:3⁆
    //     | ordinal-range         // [1:2:3]
    //     | number-literal        // 1
    //     | string                // "text"
    //     | special               // true, false, null, ...
    //     | function-call-inline  // function()
    //     | namepath-safe
    public static boolean inline_atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_ATOMIC, "<inline atomic>");
        r = inline_atomic_0(b, l + 1);
        if (!r) r = inline_atomic_1(b, l + 1);
        if (!r) r = inline_atomic_2(b, l + 1);
        if (!r) r = inline_atomic_3(b, l + 1);
        if (!r) r = inline_atomic_4(b, l + 1);
        if (!r) r = inline_atomic_5(b, l + 1);
        if (!r) r = tuple(b, l + 1);
        if (!r) r = macro_call_inline(b, l + 1);
        if (!r) r = offset_range(b, l + 1);
        if (!r) r = ordinal_range(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = special(b, l + 1);
        if (!r) r = function_call_inline(b, l + 1);
        if (!r) r = namepath_safe(b, l + 1);
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

    // TEMPLATE_L expression-root TEMPLATE_R
    private static boolean inline_atomic_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, TEMPLATE_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, TEMPLATE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // FLOOR_L expression-root FLOOR_R
    private static boolean inline_atomic_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, FLOOR_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, FLOOR_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // FLOOR_L expression-root CEIL_R
    private static boolean inline_atomic_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, FLOOR_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, CEIL_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // CEIL_L expression-root FLOOR_R
    private static boolean inline_atomic_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_4")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, CEIL_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, FLOOR_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // CEIL_L expression-root CEIL_R
    private static boolean inline_atomic_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_atomic_5")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, CEIL_L);
        r = r && expression_root(b, l + 1);
        r = r && consumeToken(b, CEIL_R);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // OP_BANG
    //     | OP_CELSIUS
    //     | OP_FAHRENHEIT
    //     | dot-call-macro-inline  // .@macro
    //     | dot-call-inline        // .@function
    //     | is-expression
    //     | generic-call
    //     | ordinal-slice
    //     | offset-slice
    public static boolean inline_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "inline_suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, INLINE_SUFFIX, "<inline suffix>");
        r = consumeToken(b, OP_BANG);
        if (!r) r = consumeToken(b, OP_CELSIUS);
        if (!r) r = consumeToken(b, OP_FAHRENHEIT);
        if (!r) r = dot_call_macro_inline(b, l + 1);
        if (!r) r = dot_call_inline(b, l + 1);
        if (!r) r = is_expression(b, l + 1);
        if (!r) r = generic_call(b, l + 1);
        if (!r) r = ordinal_slice(b, l + 1);
        if (!r) r = offset_slice(b, l + 1);
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
    // (KW_IS KW_NOT | OP_BANG KW_IS | KW_IS) type-pattern-inline
    public static boolean is_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "is_expression")) return false;
        if (!nextTokenIs(b, "<is expression>", KW_IS, OP_BANG)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IS_EXPRESSION, "<is expression>");
        r = is_expression_0(b, l + 1);
        r = r && type_pattern_inline(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_IS KW_NOT | OP_BANG KW_IS | KW_IS
    private static boolean is_expression_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "is_expression_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parseTokens(b, 0, KW_IS, KW_NOT);
        if (!r) r = parseTokens(b, 0, OP_BANG, KW_IS);
        if (!r) r = consumeToken(b, KW_IS);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // (KW_IS KW_NOT | OP_BANG KW_IS | KW_IS) type-pattern
    public static boolean is_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "is_statement")) return false;
        if (!nextTokenIs(b, "<is statement>", KW_IS, OP_BANG)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IS_STATEMENT, "<is statement>");
        r = is_statement_0(b, l + 1);
        r = r && type_pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_IS KW_NOT | OP_BANG KW_IS | KW_IS
    private static boolean is_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "is_statement_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parseTokens(b, 0, KW_IS, KW_NOT);
        if (!r) r = parseTokens(b, 0, OP_BANG, KW_IS);
        if (!r) r = consumeToken(b, KW_IS);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // let-pattern type-hint? (ASSIGN_L|BIND) expression
    static boolean let_lhs(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_lhs")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_);
        r = let_pattern(b, l + 1);
        r = r && let_lhs_1(b, l + 1);
        r = r && let_lhs_2(b, l + 1);
        p = r; // pin = 3
        r = r && expression(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-hint?
    private static boolean let_lhs_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_lhs_1")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // ASSIGN_L|BIND
    private static boolean let_lhs_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_lhs_2")) return false;
        boolean r;
        r = consumeToken(b, ASSIGN_L);
        if (!r) r = consumeToken(b, BIND);
        return r;
    }

    /* ********************************************************** */
    // KW_CASE? modifier* case-pattern-list
    //     | KW_CASE? modifier* case-pattern-dict  // let a Object {x, y}
    //     | bare-pattern
    public static boolean let_pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LET_PATTERN, "<let pattern>");
        r = let_pattern_0(b, l + 1);
        if (!r) r = let_pattern_1(b, l + 1);
        if (!r) r = bare_pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_CASE? modifier* case-pattern-list
    private static boolean let_pattern_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = let_pattern_0_0(b, l + 1);
        r = r && let_pattern_0_1(b, l + 1);
        r = r && case_pattern_list(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_CASE?
    private static boolean let_pattern_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_0_0")) return false;
        consumeToken(b, KW_CASE);
        return true;
    }

    // modifier*
    private static boolean let_pattern_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "let_pattern_0_1", c)) break;
        }
        return true;
    }

    // KW_CASE? modifier* case-pattern-dict
    private static boolean let_pattern_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = let_pattern_1_0(b, l + 1);
        r = r && let_pattern_1_1(b, l + 1);
        r = r && case_pattern_dict(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // KW_CASE?
    private static boolean let_pattern_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_1_0")) return false;
        consumeToken(b, KW_CASE);
        return true;
    }

    // modifier*
    private static boolean let_pattern_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_pattern_1_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "let_pattern_1_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // attribute-below* KW_LET let-lhs
    public static boolean let_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement")) return false;
        if (!nextTokenIs(b, "<let statement>", KW_LET, OP_MACRO_LOWER)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LET_STATEMENT, "<let statement>");
        r = let_statement_0(b, l + 1);
        r = r && consumeToken(b, KW_LET);
        p = r; // pin = 2
        r = r && let_lhs(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // attribute-below*
    private static boolean let_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "let_statement_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // OP_L10N (identifier-safe ((DOT|NAME_SPLIT|OP_DIV) identifier-safe)*)? argument-body?
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

    // (identifier-safe ((DOT|NAME_SPLIT|OP_DIV) identifier-safe)*)?
    private static boolean localize_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1")) return false;
        localize_call_1_0(b, l + 1);
        return true;
    }

    // identifier-safe ((DOT|NAME_SPLIT|OP_DIV) identifier-safe)*
    private static boolean localize_call_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_safe(b, l + 1);
        r = r && localize_call_1_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // ((DOT|NAME_SPLIT|OP_DIV) identifier-safe)*
    private static boolean localize_call_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!localize_call_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "localize_call_1_0_1", c)) break;
        }
        return true;
    }

    // (DOT|NAME_SPLIT|OP_DIV) identifier-safe
    private static boolean localize_call_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = localize_call_1_0_1_0_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // DOT|NAME_SPLIT|OP_DIV
    private static boolean localize_call_1_0_1_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "localize_call_1_0_1_0_0")) return false;
        boolean r;
        r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, NAME_SPLIT);
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
    // loop-while-let // loop while let Some(value) = ... if ...
    //     | loop-while     // loop while {...}
    //     | loop-until-not // loop until not Integer = ... if ...
    //     | loop-until     // loop until {...}
    //     | loop-match     // loop match { case ... }
    //     | loop-each
    public static boolean loop_condition(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_condition")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LOOP_CONDITION, "<loop condition>");
        r = loop_while_let(b, l + 1);
        if (!r) r = loop_while(b, l + 1);
        if (!r) r = loop_until_not(b, l + 1);
        if (!r) r = loop_until(b, l + 1);
        if (!r) r = loop_match(b, l + 1);
        if (!r) r = loop_each(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_EACH? match-bind? (bare-pattern !(PARENTHESIS_L|BRACKET_L|BRACE_L)|case-pattern) KW_IN expression-inline if-condition?
    public static boolean loop_each(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_EACH, "<loop each>");
        r = loop_each_0(b, l + 1);
        r = r && loop_each_1(b, l + 1);
        r = r && loop_each_2(b, l + 1);
        r = r && consumeToken(b, KW_IN);
        p = r; // pin = 4
        r = r && report_error_(b, expression_inline(b, l + 1));
        r = p && loop_each_5(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // KW_EACH?
    private static boolean loop_each_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_0")) return false;
        consumeToken(b, KW_EACH);
        return true;
    }

    // match-bind?
    private static boolean loop_each_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_1")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // bare-pattern !(PARENTHESIS_L|BRACKET_L|BRACE_L)|case-pattern
    private static boolean loop_each_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_each_2_0(b, l + 1);
        if (!r) r = case_pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // bare-pattern !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    private static boolean loop_each_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = bare_pattern(b, l + 1);
        r = r && loop_each_2_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // !(PARENTHESIS_L|BRACKET_L|BRACE_L)
    private static boolean loop_each_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_2_0_1")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !loop_each_2_0_1_0(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L|BRACKET_L|BRACE_L
    private static boolean loop_each_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_2_0_1_0")) return false;
        boolean r;
        r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, BRACKET_L);
        if (!r) r = consumeToken(b, BRACE_L);
        return r;
    }

    // if-condition?
    private static boolean loop_each_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_each_5")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // bare-pattern !(PARENTHESIS_L|BRACKET_L|BIND)
    //     | match-bind? case-pattern-list   // loop x = Some(y) in ...
    //     | match-bind? namepath-safe       // loop x = Option::None in ...
    //     | match-bind? special             // loop x = ture in ...
    //     | match-bind? string              // loop x = "text" in ...
    //     | match-bind? number-literal
    public static boolean loop_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LOOP_INLINE, "<loop inline>");
        r = loop_inline_0(b, l + 1);
        if (!r) r = loop_inline_1(b, l + 1);
        if (!r) r = loop_inline_2(b, l + 1);
        if (!r) r = loop_inline_3(b, l + 1);
        if (!r) r = loop_inline_4(b, l + 1);
        if (!r) r = loop_inline_5(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // bare-pattern !(PARENTHESIS_L|BRACKET_L|BIND)
    private static boolean loop_inline_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = bare_pattern(b, l + 1);
        r = r && loop_inline_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // !(PARENTHESIS_L|BRACKET_L|BIND)
    private static boolean loop_inline_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_0_1")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !loop_inline_0_1_0(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L|BRACKET_L|BIND
    private static boolean loop_inline_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_0_1_0")) return false;
        boolean r;
        r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, BRACKET_L);
        if (!r) r = consumeToken(b, BIND);
        return r;
    }

    // match-bind? case-pattern-list
    private static boolean loop_inline_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_inline_1_0(b, l + 1);
        r = r && case_pattern_list(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // match-bind?
    private static boolean loop_inline_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_1_0")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // match-bind? namepath-safe
    private static boolean loop_inline_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_inline_2_0(b, l + 1);
        r = r && namepath_safe(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // match-bind?
    private static boolean loop_inline_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_2_0")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // match-bind? special
    private static boolean loop_inline_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_inline_3_0(b, l + 1);
        r = r && special(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // match-bind?
    private static boolean loop_inline_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_3_0")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // match-bind? string
    private static boolean loop_inline_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_4")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_inline_4_0(b, l + 1);
        r = r && string(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // match-bind?
    private static boolean loop_inline_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_4_0")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // match-bind? number-literal
    private static boolean loop_inline_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_5")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_inline_5_0(b, l + 1);
        r = r && number_literal(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // match-bind?
    private static boolean loop_inline_5_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_inline_5_0")) return false;
        match_bind(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_MATCH expression-inline
    public static boolean loop_match(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_match")) return false;
        if (!nextTokenIs(b, KW_MATCH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_MATCH, null);
        r = consumeToken(b, KW_MATCH);
        p = r; // pin = 1
        r = r && expression_inline(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // loop-condition? control-label? attribute-below*
    public static boolean loop_start(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_start")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LOOP_START, "<loop start>");
        r = loop_start_0(b, l + 1);
        r = r && loop_start_1(b, l + 1);
        r = r && loop_start_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // loop-condition?
    private static boolean loop_start_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_start_0")) return false;
        loop_condition(b, l + 1);
        return true;
    }

    // control-label?
    private static boolean loop_start_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_start_1")) return false;
        control_label(b, l + 1);
        return true;
    }

    // attribute-below*
    private static boolean loop_start_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_start_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!attribute_below(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "loop_start_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // (KW_LOOP|KW_FOR) loop-start block-body else-statement? {
    // }
    public static boolean loop_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_statement")) return false;
        if (!nextTokenIs(b, "<loop statement>", KW_FOR, KW_LOOP)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LOOP_STATEMENT, "<loop statement>");
        r = loop_statement_0(b, l + 1);
        r = r && loop_start(b, l + 1);
        r = r && block_body(b, l + 1);
        r = r && loop_statement_3(b, l + 1);
        r = r && loop_statement_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_LOOP|KW_FOR
    private static boolean loop_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_statement_0")) return false;
        boolean r;
        r = consumeToken(b, KW_LOOP);
        if (!r) r = consumeToken(b, KW_FOR);
        return r;
    }

    // else-statement?
    private static boolean loop_statement_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_statement_3")) return false;
        else_statement(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean loop_statement_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // loop-template-start else-template? template-end {
    // }
    public static boolean loop_template(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_template")) return false;
        if (!nextTokenIs(b, TEMPLATE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = loop_template_start(b, l + 1);
        r = r && loop_template_1(b, l + 1);
        r = r && template_end(b, l + 1);
        r = r && loop_template_3(b, l + 1);
        exit_section_(b, m, LOOP_TEMPLATE, r);
        return r;
    }

    // else-template?
    private static boolean loop_template_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_template_1")) return false;
        else_template(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean loop_template_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // TEMPLATE_L (KW_LOOP|KW_FOR) loop-start TEMPLATE_R statements* {
    // }
    public static boolean loop_template_start(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_template_start")) return false;
        if (!nextTokenIs(b, TEMPLATE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, TEMPLATE_L);
        r = r && loop_template_start_1(b, l + 1);
        r = r && loop_start(b, l + 1);
        r = r && consumeToken(b, TEMPLATE_R);
        r = r && loop_template_start_4(b, l + 1);
        r = r && loop_template_start_5(b, l + 1);
        exit_section_(b, m, LOOP_TEMPLATE_START, r);
        return r;
    }

    // KW_LOOP|KW_FOR
    private static boolean loop_template_start_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_template_start_1")) return false;
        boolean r;
        r = consumeToken(b, KW_LOOP);
        if (!r) r = consumeToken(b, KW_FOR);
        return r;
    }

    // statements*
    private static boolean loop_template_start_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_template_start_4")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "loop_template_start_4", c)) break;
        }
        return true;
    }

    // {
    // }
    private static boolean loop_template_start_5(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // KW_UNTIL expression-inline
    public static boolean loop_until(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_until")) return false;
        if (!nextTokenIs(b, KW_UNTIL)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_UNTIL, null);
        r = consumeToken(b, KW_UNTIL);
        p = r; // pin = 1
        r = r && expression_inline(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_UNTIL KW_NOT? type-pattern EQUAL expression-inline if-condition?
    public static boolean loop_until_not(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_until_not")) return false;
        if (!nextTokenIs(b, KW_UNTIL)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_UNTIL_NOT, null);
        r = consumeToken(b, KW_UNTIL);
        r = r && loop_until_not_1(b, l + 1);
        r = r && type_pattern(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        p = r; // pin = 4
        r = r && report_error_(b, expression_inline(b, l + 1));
        r = p && loop_until_not_5(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // KW_NOT?
    private static boolean loop_until_not_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_until_not_1")) return false;
        consumeToken(b, KW_NOT);
        return true;
    }

    // if-condition?
    private static boolean loop_until_not_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_until_not_5")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_WHILE expression-inline
    public static boolean loop_while(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_while")) return false;
        if (!nextTokenIs(b, KW_WHILE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_WHILE, null);
        r = consumeToken(b, KW_WHILE);
        p = r; // pin = 1
        r = r && expression_inline(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // KW_WHILE KW_LET? let-pattern type-hint? EQUAL expression-inline if-condition?
    public static boolean loop_while_let(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_while_let")) return false;
        if (!nextTokenIs(b, KW_WHILE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LOOP_WHILE_LET, null);
        r = consumeToken(b, KW_WHILE);
        r = r && loop_while_let_1(b, l + 1);
        r = r && let_pattern(b, l + 1);
        r = r && loop_while_let_3(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        p = r; // pin = 5
        r = r && report_error_(b, expression_inline(b, l + 1));
        r = p && loop_while_let_6(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // KW_LET?
    private static boolean loop_while_let_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_while_let_1")) return false;
        consumeToken(b, KW_LET);
        return true;
    }

    // type-hint?
    private static boolean loop_while_let_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_while_let_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // if-condition?
    private static boolean loop_while_let_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "loop_while_let_6")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_MACRO macro-path generic-call? (argument-body? class-body|argument-body)?
    public static boolean macro_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call")) return false;
        if (!nextTokenIs(b, OP_MACRO)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MACRO_CALL, null);
        r = consumeToken(b, OP_MACRO);
        p = r; // pin = 1
        r = r && report_error_(b, macro_path(b, l + 1));
        r = p && report_error_(b, macro_call_2(b, l + 1)) && r;
        r = p && macro_call_3(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // generic-call?
    private static boolean macro_call_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_2")) return false;
        generic_call(b, l + 1);
        return true;
    }

    // (argument-body? class-body|argument-body)?
    private static boolean macro_call_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_3")) return false;
        macro_call_3_0(b, l + 1);
        return true;
    }

    // argument-body? class-body|argument-body
    private static boolean macro_call_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = macro_call_3_0_0(b, l + 1);
        if (!r) r = argument_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body? class-body
    private static boolean macro_call_3_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_3_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = macro_call_3_0_0_0(b, l + 1);
        r = r && class_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // argument-body?
    private static boolean macro_call_3_0_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_3_0_0_0")) return false;
        argument_body(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_MACRO namepath-safe argument-body?
    public static boolean macro_call_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_call_inline")) return false;
        if (!nextTokenIs(b, OP_MACRO)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_MACRO);
        r = r && namepath_safe(b, l + 1);
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
    // identifier-free (NAME_SPLIT identifier-free)*
    public static boolean macro_path(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_path")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MACRO_PATH, "<macro path>");
        r = identifier_free(b, l + 1);
        r = r && macro_path_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (NAME_SPLIT identifier-free)*
    private static boolean macro_path_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_path_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!macro_path_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "macro_path_1", c)) break;
        }
        return true;
    }

    // NAME_SPLIT identifier-free
    private static boolean macro_path_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "macro_path_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // modifier* identifier-safe BIND
    public static boolean match_bind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_bind")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MATCH_BIND, "<match bind>");
        r = match_bind_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && consumeToken(b, BIND);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // modifier*
    private static boolean match_bind_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_bind_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "match_bind_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // <<brace (match-item)>>
    public static boolean match_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::match_body_0_0);
        exit_section_(b, m, MATCH_BODY, r);
        return r;
    }

    // (match-item)
    private static boolean match_body_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = match_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // KW_CASE match-case-head match-case-rest* if-condition? (COLON|KW_THEN) block-bare
    public static boolean match_case(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
        r = consumeToken(b, KW_CASE);
        p = r; // pin = 1
        r = r && report_error_(b, match_case_head(b, l + 1));
        r = p && report_error_(b, match_case_2(b, l + 1)) && r;
        r = p && report_error_(b, match_case_3(b, l + 1)) && r;
        r = p && report_error_(b, match_case_4(b, l + 1)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, YggdrasilParser::match_recover);
        return r || p;
    }

    // match-case-rest*
    private static boolean match_case_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!match_case_rest(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "match_case_2", c)) break;
        }
        return true;
    }

    // if-condition?
    private static boolean match_case_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_3")) return false;
        if_condition(b, l + 1);
        return true;
    }

    // COLON|KW_THEN
    private static boolean match_case_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_4")) return false;
        boolean r;
        r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, KW_THEN);
        return r;
    }

    /* ********************************************************** */
    // case-pattern-kind? case-pattern-top
    static boolean match_case_head(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_head")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = match_case_head_0(b, l + 1);
        r = r && case_pattern_top(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // case-pattern-kind?
    private static boolean match_case_head_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_head_0")) return false;
        case_pattern_kind(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // case-pattern-kind  case-pattern-top
    static boolean match_case_rest(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_case_rest")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = case_pattern_kind(b, l + 1);
        r = r && case_pattern_top(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // KW_ELSE (COLON|KW_THEN) block-bare
    public static boolean match_else(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_else")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_ELSE, "<match else>");
        r = consumeToken(b, KW_ELSE);
        p = r; // pin = 1
        r = r && report_error_(b, match_else_1(b, l + 1));
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, YggdrasilParser::match_recover);
        return r || p;
    }

    // COLON|KW_THEN
    private static boolean match_else_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_else_1")) return false;
        boolean r;
        r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, KW_THEN);
        return r;
    }

    /* ********************************************************** */
    // match-with
    //     | match-type
    //     | match-case
    //     | match-when
    //     | match-else
    static boolean match_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_item")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = match_with(b, l + 1);
        if (!r) r = match_type(b, l + 1);
        if (!r) r = match_case(b, l + 1);
        if (!r) r = match_when(b, l + 1);
        if (!r) r = match_else(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // KW_MATCH|KW_CATCH
    public static boolean match_kind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_kind")) return false;
        if (!nextTokenIs(b, "<match kind>", KW_CATCH, KW_MATCH)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MATCH_KIND, "<match kind>");
        r = consumeToken(b, KW_MATCH);
        if (!r) r = consumeToken(b, KW_CATCH);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // !(KW_WITH | KW_TYPE | KW_CASE | KW_WHEN | KW_ELSE | BRACE_R)
    static boolean match_recover(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_recover")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NOT_);
        r = !match_recover_0(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_WITH | KW_TYPE | KW_CASE | KW_WHEN | KW_ELSE | BRACE_R
    private static boolean match_recover_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_recover_0")) return false;
        boolean r;
        r = consumeToken(b, KW_WITH);
        if (!r) r = consumeToken(b, KW_TYPE);
        if (!r) r = consumeToken(b, KW_CASE);
        if (!r) r = consumeToken(b, KW_WHEN);
        if (!r) r = consumeToken(b, KW_ELSE);
        if (!r) r = consumeToken(b, BRACE_R);
        return r;
    }

    /* ********************************************************** */
    // match-kind match-bind? expression-inline? match-body
    public static boolean match_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement")) return false;
        if (!nextTokenIs(b, "<match statement>", KW_CATCH, KW_MATCH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_STATEMENT, "<match statement>");
        r = match_kind(b, l + 1);
        p = r; // pin = 1
        r = r && report_error_(b, match_statement_1(b, l + 1));
        r = p && report_error_(b, match_statement_2(b, l + 1)) && r;
        r = p && match_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // match-bind?
    private static boolean match_statement_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement_1")) return false;
        match_bind(b, l + 1);
        return true;
    }

    // expression-inline?
    private static boolean match_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement_2")) return false;
        expression_inline(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_TYPE OP_OR? type-pattern (OP_OR type-pattern)* (COLON|KW_THEN) block-bare
    public static boolean match_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_type")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_TYPE, "<match type>");
        r = consumeToken(b, KW_TYPE);
        p = r; // pin = 1
        r = r && report_error_(b, match_type_1(b, l + 1));
        r = p && report_error_(b, type_pattern(b, l + 1)) && r;
        r = p && report_error_(b, match_type_3(b, l + 1)) && r;
        r = p && report_error_(b, match_type_4(b, l + 1)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, YggdrasilParser::match_recover);
        return r || p;
    }

    // OP_OR?
    private static boolean match_type_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_type_1")) return false;
        consumeToken(b, OP_OR);
        return true;
    }

    // (OP_OR type-pattern)*
    private static boolean match_type_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_type_3")) return false;
        while (true) {
            int c = current_position_(b);
            if (!match_type_3_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "match_type_3", c)) break;
        }
        return true;
    }

    // OP_OR type-pattern
    private static boolean match_type_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_type_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_OR);
        r = r && type_pattern(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COLON|KW_THEN
    private static boolean match_type_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_type_4")) return false;
        boolean r;
        r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, KW_THEN);
        return r;
    }

    /* ********************************************************** */
    // KW_WHEN infix-logical? expression (COLON|KW_THEN) block-bare
    public static boolean match_when(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_when")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_WHEN, "<match when>");
        r = consumeToken(b, KW_WHEN);
        p = r; // pin = 1
        r = r && report_error_(b, match_when_1(b, l + 1));
        r = p && report_error_(b, expression(b, l + 1)) && r;
        r = p && report_error_(b, match_when_3(b, l + 1)) && r;
        r = p && block_bare(b, l + 1) && r;
        exit_section_(b, l, m, r, p, YggdrasilParser::match_recover);
        return r || p;
    }

    // infix-logical?
    private static boolean match_when_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_when_1")) return false;
        infix_logical(b, l + 1);
        return true;
    }

    // COLON|KW_THEN
    private static boolean match_when_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_when_3")) return false;
        boolean r;
        r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, KW_THEN);
        return r;
    }

    /* ********************************************************** */
    // KW_WITH (match-with-provide|match-with-control)
    public static boolean match_with(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_with")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_WITH, "<match with>");
        r = consumeToken(b, KW_WITH);
        p = r; // pin = 1
        r = r && match_with_1(b, l + 1);
        exit_section_(b, l, m, r, p, YggdrasilParser::match_recover);
        return r || p;
    }

    // match-with-provide|match-with-control
    private static boolean match_with_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_with_1")) return false;
        boolean r;
        r = match_with_provide(b, l + 1);
        if (!r) r = match_with_control(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // <<parenthesis identifier-free>>
    public static boolean match_with_control(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_with_control")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parenthesis(b, l + 1, YggdrasilParser::identifier_free);
        exit_section_(b, m, MATCH_WITH_CONTROL, r);
        return r;
    }

    /* ********************************************************** */
    // <<bracket type-expression>>
    public static boolean match_with_provide(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_with_provide")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = bracket(b, l + 1, YggdrasilParser::type_expression);
        exit_section_(b, m, MATCH_WITH_PROVIDE, r);
        return r;
    }

    /* ********************************************************** */
    // KW_LET let-pattern type-hint? OP_SET_THEN expression
    public static boolean may_let_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "may_let_statement")) return false;
        if (!nextTokenIs(b, KW_LET)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MAY_LET_STATEMENT, null);
        r = consumeToken(b, KW_LET);
        r = r && let_pattern(b, l + 1);
        r = r && may_let_statement_2(b, l + 1);
        r = r && consumeToken(b, OP_SET_THEN);
        p = r; // pin = 4
        r = r && expression(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-hint?
    private static boolean may_let_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "may_let_statement_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // (SYMBOL | SYMBOL_RAW) !modifier-stop
    public static boolean modifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier")) return false;
        if (!nextTokenIs(b, "<modifier>", SYMBOL, SYMBOL_RAW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
        r = modifier_0(b, l + 1);
        r = r && modifier_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // SYMBOL | SYMBOL_RAW
    private static boolean modifier_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_0")) return false;
        boolean r;
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOL_RAW);
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
    //     | COMMA | SEMICOLON
    //     | COLON | BIND
    //     | NAME_SPLIT | DOT
    //     | PARENTHESIS_L | PARENTHESIS_R
    //     | BRACE_L | BRACE_R
    //     | BRACKET_L | BRACKET_R
    //     | ANGLE_L | ANGLE_R
    //     | GENERIC_L | GENERIC_R
    //     | ASSIGN_L | ASSIGN_R
    static boolean modifier_stop(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier_stop")) return false;
        boolean r;
        r = consumeToken(b, KW_IN);
        if (!r) r = consumeToken(b, KW_IF);
        if (!r) r = consumeToken(b, COMMA);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, COLON);
        if (!r) r = consumeToken(b, BIND);
        if (!r) r = consumeToken(b, NAME_SPLIT);
        if (!r) r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, PARENTHESIS_L);
        if (!r) r = consumeToken(b, PARENTHESIS_R);
        if (!r) r = consumeToken(b, BRACE_L);
        if (!r) r = consumeToken(b, BRACE_R);
        if (!r) r = consumeToken(b, BRACKET_L);
        if (!r) r = consumeToken(b, BRACKET_R);
        if (!r) r = consumeToken(b, ANGLE_L);
        if (!r) r = consumeToken(b, ANGLE_R);
        if (!r) r = consumeToken(b, GENERIC_L);
        if (!r) r = consumeToken(b, GENERIC_R);
        if (!r) r = consumeToken(b, ASSIGN_L);
        if (!r) r = consumeToken(b, ASSIGN_R);
        return r;
    }

    /* ********************************************************** */
    // identifier-safe ((NAME_SPLIT|DOT) identifier-safe)*
    public static boolean namepath_auto(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_auto")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH_AUTO, "<namepath auto>");
        r = identifier_safe(b, l + 1);
        r = r && namepath_auto_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // ((NAME_SPLIT|DOT) identifier-safe)*
    private static boolean namepath_auto_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_auto_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_auto_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_auto_1", c)) break;
        }
        return true;
    }

    // (NAME_SPLIT|DOT) identifier-safe
    private static boolean namepath_auto_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_auto_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = namepath_auto_1_0_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT|DOT
    private static boolean namepath_auto_1_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_auto_1_0_0")) return false;
        boolean r;
        r = consumeToken(b, NAME_SPLIT);
        if (!r) r = consumeToken(b, DOT);
        return r;
    }

    /* ********************************************************** */
    // (NAME_SCOPE NAME_SPLIT?)? identifier-free (NAME_SPLIT identifier-free)*
    public static boolean namepath_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH_FREE, "<namepath free>");
        r = namepath_free_0(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && namepath_free_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (NAME_SCOPE NAME_SPLIT?)?
    private static boolean namepath_free_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_0")) return false;
        namepath_free_0_0(b, l + 1);
        return true;
    }

    // NAME_SCOPE NAME_SPLIT?
    private static boolean namepath_free_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_0_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SCOPE);
        r = r && namepath_free_0_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean namepath_free_0_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_0_0_1")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // (NAME_SPLIT identifier-free)*
    private static boolean namepath_free_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_free_2_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_free_2", c)) break;
        }
        return true;
    }

    // NAME_SPLIT identifier-free
    private static boolean namepath_free_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // identifier-safe (NAME_SPLIT identifier-free)*
    //     | NAME_SCOPE NAME_SPLIT? identifier-free (NAME_SPLIT identifier-free)*
    public static boolean namepath_safe(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH_SAFE, "<namepath safe>");
        r = namepath_safe_0(b, l + 1);
        if (!r) r = namepath_safe_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier-safe (NAME_SPLIT identifier-free)*
    private static boolean namepath_safe_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_safe(b, l + 1);
        r = r && namepath_safe_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (NAME_SPLIT identifier-free)*
    private static boolean namepath_safe_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_safe_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_safe_0_1", c)) break;
        }
        return true;
    }

    // NAME_SPLIT identifier-free
    private static boolean namepath_safe_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SCOPE NAME_SPLIT? identifier-free (NAME_SPLIT identifier-free)*
    private static boolean namepath_safe_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SCOPE);
        r = r && namepath_safe_1_1(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && namepath_safe_1_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // NAME_SPLIT?
    private static boolean namepath_safe_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_1_1")) return false;
        consumeToken(b, NAME_SPLIT);
        return true;
    }

    // (NAME_SPLIT identifier-free)*
    private static boolean namepath_safe_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_1_3")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_safe_1_3_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_safe_1_3", c)) break;
        }
        return true;
    }

    // NAME_SPLIT identifier-free
    private static boolean namepath_safe_1_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_safe_1_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // identifier-safe BIND expression
    public static boolean new_bind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_bind")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NEW_BIND, "<new bind>");
        r = identifier_safe(b, l + 1);
        r = r && consumeToken(b, BIND);
        r = r && expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // <<brace (new-bind|expression-root)>>
    public static boolean new_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::new_body_0_0);
        exit_section_(b, m, NEW_BODY, r);
        return r;
    }

    // new-bind|expression-root
    private static boolean new_body_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_body_0_0")) return false;
        boolean r;
        r = new_bind(b, l + 1);
        if (!r) r = expression_root(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_LAMBDA declare-infer? parameter-body return-type? block-body
    public static boolean new_lambda(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_LAMBDA, "<new lambda>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_LAMBDA);
        p = r; // pin = 2
        r = r && report_error_(b, new_lambda_2(b, l + 1));
        r = p && report_error_(b, parameter_body(b, l + 1)) && r;
        r = p && report_error_(b, new_lambda_4(b, l + 1)) && r;
        r = p && block_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // declare-infer?
    private static boolean new_lambda_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda_2")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean new_lambda_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_lambda_4")) return false;
        return_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_OBJECT class-inherit? type-hint? class-body
    public static boolean new_object(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_OBJECT, "<new object>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_OBJECT);
        p = r; // pin = 2
        r = r && report_error_(b, new_object_2(b, l + 1));
        r = p && report_error_(b, new_object_3(b, l + 1)) && r;
        r = p && class_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // class-inherit?
    private static boolean new_object_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object_2")) return false;
        class_inherit(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean new_object_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_object_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // annotations KW_NEW type-expression? argument-body? new-body
    public static boolean new_value(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "new_value")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, NEW_VALUE, "<new value>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_NEW);
        p = r; // pin = 2
        r = r && report_error_(b, new_value_2(b, l + 1));
        r = p && report_error_(b, new_value_3(b, l + 1)) && r;
        r = p && new_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
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
    // DECIMAL (OP_EXPONENT NUMBER_EXPONENT)? NUMBER_SUFFIX?
    //   | INTEGER (OP_BASE NUMBER_BASE)? (OP_EXPONENT NUMBER_EXPONENT)? NUMBER_SUFFIX?
    public static boolean number_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal")) return false;
        if (!nextTokenIs(b, "<number literal>", DECIMAL, INTEGER)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
        r = number_literal_0(b, l + 1);
        if (!r) r = number_literal_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // DECIMAL (OP_EXPONENT NUMBER_EXPONENT)? NUMBER_SUFFIX?
    private static boolean number_literal_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DECIMAL);
        r = r && number_literal_0_1(b, l + 1);
        r = r && number_literal_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (OP_EXPONENT NUMBER_EXPONENT)?
    private static boolean number_literal_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_0_1")) return false;
        number_literal_0_1_0(b, l + 1);
        return true;
    }

    // OP_EXPONENT NUMBER_EXPONENT
    private static boolean number_literal_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, OP_EXPONENT, NUMBER_EXPONENT);
        exit_section_(b, m, null, r);
        return r;
    }

    // NUMBER_SUFFIX?
    private static boolean number_literal_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_0_2")) return false;
        consumeToken(b, NUMBER_SUFFIX);
        return true;
    }

    // INTEGER (OP_BASE NUMBER_BASE)? (OP_EXPONENT NUMBER_EXPONENT)? NUMBER_SUFFIX?
    private static boolean number_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INTEGER);
        r = r && number_literal_1_1(b, l + 1);
        r = r && number_literal_1_2(b, l + 1);
        r = r && number_literal_1_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (OP_BASE NUMBER_BASE)?
    private static boolean number_literal_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1_1")) return false;
        number_literal_1_1_0(b, l + 1);
        return true;
    }

    // OP_BASE NUMBER_BASE
    private static boolean number_literal_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, OP_BASE, NUMBER_BASE);
        exit_section_(b, m, null, r);
        return r;
    }

    // (OP_EXPONENT NUMBER_EXPONENT)?
    private static boolean number_literal_1_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1_2")) return false;
        number_literal_1_2_0(b, l + 1);
        return true;
    }

    // OP_EXPONENT NUMBER_EXPONENT
    private static boolean number_literal_1_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, OP_EXPONENT, NUMBER_EXPONENT);
        exit_section_(b, m, null, r);
        return r;
    }

    // NUMBER_SUFFIX?
    private static boolean number_literal_1_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal_1_3")) return false;
        consumeToken(b, NUMBER_SUFFIX);
        return true;
    }

    /* ********************************************************** */
    // OFFSET_L (<<term>> (COMMA <<term>>)* COMMA?)? OFFSET_R
    static boolean offset(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "offset")) return false;
        if (!nextTokenIs(b, OFFSET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OFFSET_L);
        r = r && offset_1(b, l + 1, _term);
        r = r && consumeToken(b, OFFSET_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (<<term>> (COMMA <<term>>)* COMMA?)?
    private static boolean offset_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "offset_1")) return false;
        offset_1_0(b, l + 1, _term);
        return true;
    }

    // <<term>> (COMMA <<term>>)* COMMA?
    private static boolean offset_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "offset_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = _term.parse(b, l);
        r = r && offset_1_0_1(b, l + 1, _term);
        r = r && offset_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA <<term>>)*
    private static boolean offset_1_0_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "offset_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!offset_1_0_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "offset_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA <<term>>
    private static boolean offset_1_0_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "offset_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean offset_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // <<offset range-item>> | NAME_SPLIT <<bracket range-item>>
    public static boolean offset_range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range")) return false;
        if (!nextTokenIs(b, "<offset range>", NAME_SPLIT, OFFSET_L)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, OFFSET_RANGE, "<offset range>");
        r = offset(b, l + 1, YggdrasilParser::range_item);
        if (!r) r = offset_range_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // NAME_SPLIT <<bracket range-item>>
    private static boolean offset_range_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_range_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_SPLIT);
        r = r && bracket(b, l + 1, YggdrasilParser::range_item);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // OP_AND_THEN? offset-range
    public static boolean offset_slice(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_slice")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, OFFSET_SLICE, "<offset slice>");
        r = offset_slice_0(b, l + 1);
        r = r && offset_range(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean offset_slice_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "offset_slice_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    /* ********************************************************** */
    // <<bracket range-item>>
    public static boolean ordinal_range(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_range")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = bracket(b, l + 1, YggdrasilParser::range_item);
        exit_section_(b, m, ORDINAL_RANGE, r);
        return r;
    }

    /* ********************************************************** */
    // OP_AND_THEN? ordinal-range
    public static boolean ordinal_slice(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_slice")) return false;
        if (!nextTokenIs(b, "<ordinal slice>", BRACKET_L, OP_AND_THEN)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ORDINAL_SLICE, "<ordinal slice>");
        r = ordinal_slice_0(b, l + 1);
        r = r && ordinal_range(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_AND_THEN?
    private static boolean ordinal_slice_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "ordinal_slice_0")) return false;
        consumeToken(b, OP_AND_THEN);
        return true;
    }

    /* ********************************************************** */
    // <<parenthesis parameter-term>>
    public static boolean parameter_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_body")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parenthesis(b, l + 1, YggdrasilParser::parameter_term);
        exit_section_(b, m, PARAMETER_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // annotations ANY_DICT identifier-free? type-hint? default-value? {
    // }
    public static boolean parameter_dict(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_dict")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER_DICT, "<parameter dict>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, ANY_DICT);
        r = r && parameter_dict_2(b, l + 1);
        r = r && parameter_dict_3(b, l + 1);
        r = r && parameter_dict_4(b, l + 1);
        r = r && parameter_dict_5(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier-free?
    private static boolean parameter_dict_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_dict_2")) return false;
        identifier_free(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean parameter_dict_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_dict_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean parameter_dict_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_dict_4")) return false;
        default_value(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean parameter_dict_5(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations parameter-kind? identifier-free type-hint? default-value?
    public static boolean parameter_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER_ITEM, "<parameter item>");
        r = annotations(b, l + 1);
        r = r && parameter_item_1(b, l + 1);
        r = r && identifier_free(b, l + 1);
        r = r && parameter_item_3(b, l + 1);
        r = r && parameter_item_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // parameter-kind?
    private static boolean parameter_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_1")) return false;
        parameter_kind(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean parameter_item_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean parameter_item_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_item_4")) return false;
        default_value(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_POW
    public static boolean parameter_kind(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_kind")) return false;
        if (!nextTokenIs(b, OP_POW)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_POW);
        exit_section_(b, m, PARAMETER_KIND, r);
        return r;
    }

    /* ********************************************************** */
    // annotations ANY_LIST identifier-free? type-hint? default-value? {
    // }
    public static boolean parameter_list(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_list")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, ANY_LIST);
        r = r && parameter_list_2(b, l + 1);
        r = r && parameter_list_3(b, l + 1);
        r = r && parameter_list_4(b, l + 1);
        r = r && parameter_list_5(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier-free?
    private static boolean parameter_list_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_list_2")) return false;
        identifier_free(b, l + 1);
        return true;
    }

    // type-hint?
    private static boolean parameter_list_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_list_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-value?
    private static boolean parameter_list_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_list_4")) return false;
        default_value(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean parameter_list_5(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // ANGLE_L | ANGLE_R
    //     | parameter-dict
    //     | parameter-list
    //     | parameter-item
    static boolean parameter_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_term")) return false;
        boolean r;
        r = consumeToken(b, ANGLE_L);
        if (!r) r = consumeToken(b, ANGLE_R);
        if (!r) r = parameter_dict(b, l + 1);
        if (!r) r = parameter_list(b, l + 1);
        if (!r) r = parameter_item(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (<<term>> (COMMA <<term>>)* COMMA?)? PARENTHESIS_R
    static boolean parenthesis(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "parenthesis")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && parenthesis_1(b, l + 1, _term);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (<<term>> (COMMA <<term>>)* COMMA?)?
    private static boolean parenthesis_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "parenthesis_1")) return false;
        parenthesis_1_0(b, l + 1, _term);
        return true;
    }

    // <<term>> (COMMA <<term>>)* COMMA?
    private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = _term.parse(b, l);
        r = r && parenthesis_1_0_1(b, l + 1, _term);
        r = r && parenthesis_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA <<term>>)*
    private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!parenthesis_1_0_1_0(b, l + 1, _term)) break;
            if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA <<term>>
    private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _term) {
        if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && _term.parse(b, l);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean parenthesis_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // OP_ADD
    //     | OP_SUB
    //     | OP_SQRT
    //     | OP_SURD3
    //     | OP_SURD4
    //     | prefix-not
    //     | prefix-ref   // &p
    //     | prefix-deref // *p
    //     | ANY_LIST     // ..
    //     | ANY_DICT
    public static boolean prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX, "<prefix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_SUB);
        if (!r) r = consumeToken(b, OP_SQRT);
        if (!r) r = consumeToken(b, OP_SURD3);
        if (!r) r = consumeToken(b, OP_SURD4);
        if (!r) r = prefix_not(b, l + 1);
        if (!r) r = prefix_ref(b, l + 1);
        if (!r) r = prefix_deref(b, l + 1);
        if (!r) r = consumeToken(b, ANY_LIST);
        if (!r) r = consumeToken(b, ANY_DICT);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_DEREFERENCE | STAR
    public static boolean prefix_deref(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix_deref")) return false;
        if (!nextTokenIs(b, "<prefix deref>", OP_DEREFERENCE, STAR)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX_DEREF, "<prefix deref>");
        r = consumeToken(b, OP_DEREFERENCE);
        if (!r) r = consumeToken(b, STAR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_NOT | OP_BANG
    public static boolean prefix_not(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix_not")) return false;
        if (!nextTokenIs(b, "<prefix not>", OP_BANG, OP_NOT)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX_NOT, "<prefix not>");
        r = consumeToken(b, OP_NOT);
        if (!r) r = consumeToken(b, OP_BANG);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_REFERENCE | OP_AND
    public static boolean prefix_ref(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "prefix_ref")) return false;
        if (!nextTokenIs(b, "<prefix ref>", OP_AND, OP_REFERENCE)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PREFIX_REF, "<prefix ref>");
        r = consumeToken(b, OP_REFERENCE);
        if (!r) r = consumeToken(b, OP_AND);
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
    // annotations identifier-safe argument-body benchmark-body {
    // }
    public static boolean run_benchmark(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "run_benchmark")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RUN_BENCHMARK, "<run benchmark>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && argument_body(b, l + 1);
        r = r && benchmark_body(b, l + 1);
        r = r && run_benchmark_4(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // {
    // }
    private static boolean run_benchmark_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // annotations identifier-safe block-body
    public static boolean run_test_cast(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "run_test_cast")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, RUN_TEST_CAST, "<run test cast>");
        r = annotations(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && block_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // slot-named
    //   | slot-index
    //   | slot-first
    public static boolean slot(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = slot_named(b, l + 1);
        if (!r) r = slot_index(b, l + 1);
        if (!r) r = slot_first(b, l + 1);
        exit_section_(b, m, SLOT, r);
        return r;
    }

    /* ********************************************************** */
    // DOLLAR
    public static boolean slot_first(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot_first")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOLLAR);
        exit_section_(b, m, SLOT_FIRST, r);
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
    // DOLLAR identifier-safe
    public static boolean slot_named(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "slot_named")) return false;
        if (!nextTokenIs(b, DOLLAR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOLLAR);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, m, SLOT_NAMED, r);
        return r;
    }

    /* ********************************************************** */
    // KW_NIL|KW_NULL|KW_BOOLEAN|COLOR
    public static boolean special(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "special")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SPECIAL, "<special>");
        r = consumeToken(b, KW_NIL);
        if (!r) r = consumeToken(b, KW_NULL);
        if (!r) r = consumeToken(b, KW_BOOLEAN);
        if (!r) r = consumeToken(b, COLOR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // declare-namespace
    //     | using-statement
    //     | declare-type
    //     | declare-flags
    //     | declare-enums
    //     | declare-unite
    //     | declare-class
    //     | declare-union
    //     | declare-trait
    //     | declare-imply
    //     | declare-function
    //     | declare-mezzo
    //     | declare-macro
    //     | declare-tests
    //     | declare-component
    //     | declare-singleton
    //     | declare-neural
    //     | block-statement
    public static boolean statements(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, STATEMENTS, "<statements>");
        r = declare_namespace(b, l + 1);
        if (!r) r = using_statement(b, l + 1);
        if (!r) r = declare_type(b, l + 1);
        if (!r) r = declare_flags(b, l + 1);
        if (!r) r = declare_enums(b, l + 1);
        if (!r) r = declare_unite(b, l + 1);
        if (!r) r = declare_class(b, l + 1);
        if (!r) r = declare_union(b, l + 1);
        if (!r) r = declare_trait(b, l + 1);
        if (!r) r = declare_imply(b, l + 1);
        if (!r) r = declare_function(b, l + 1);
        if (!r) r = declare_mezzo(b, l + 1);
        if (!r) r = declare_macro(b, l + 1);
        if (!r) r = declare_tests(b, l + 1);
        if (!r) r = declare_component(b, l + 1);
        if (!r) r = declare_singleton(b, l + 1);
        if (!r) r = declare_neural(b, l + 1);
        if (!r) r = block_statement(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // identifier-safe? STRING_L STRING_TEXT* STRING_R
    public static boolean string(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
        r = string_0(b, l + 1);
        r = r && consumeToken(b, STRING_L);
        r = r && string_2(b, l + 1);
        r = r && consumeToken(b, STRING_R);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // identifier-safe?
    private static boolean string_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_0")) return false;
        identifier_safe(b, l + 1);
        return true;
    }

    // STRING_TEXT*
    private static boolean string_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!consumeToken(b, STRING_TEXT)) break;
            if (!empty_element_parsed_guard_(b, "string_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // OP_BANG
    //     | OP_CELSIUS
    //     | OP_FAHRENHEIT
    //     | dot-call-macro         // .@macro() { }
    //     | dot-call               // .method
    //     | dot-loop-call          // .loop { }
    //     | dot-match-call         // .match { }
    //     | KW_AS type-expression
    //     | is-statement
    //     | generic-call
    //     | ordinal-slice
    //     | offset-slice
    public static boolean suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, SUFFIX, "<suffix>");
        r = consumeToken(b, OP_BANG);
        if (!r) r = consumeToken(b, OP_CELSIUS);
        if (!r) r = consumeToken(b, OP_FAHRENHEIT);
        if (!r) r = dot_call_macro(b, l + 1);
        if (!r) r = dot_call(b, l + 1);
        if (!r) r = dot_loop_call(b, l + 1);
        if (!r) r = dot_match_call(b, l + 1);
        if (!r) r = suffix_7(b, l + 1);
        if (!r) r = is_statement(b, l + 1);
        if (!r) r = generic_call(b, l + 1);
        if (!r) r = ordinal_slice(b, l + 1);
        if (!r) r = offset_slice(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_AS type-expression
    private static boolean suffix_7(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "suffix_7")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_AS);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // SYMBOL | SYMBOL_RAW
    static boolean symbol(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "symbol")) return false;
        if (!nextTokenIs(b, "", SYMBOL, SYMBOL_RAW)) return false;
        boolean r;
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, SYMBOL_RAW);
        return r;
    }

    /* ********************************************************** */
    // KW_LET
    //     | KW_NAMESPACE
    //     | KW_TYPE
    //     | KW_CLASS | KW_TRAIT | KW_OBJECT
    //     | KW_CATCH | KW_MATCH | KW_CASE
    //     | KW_MICRO | KW_MEZZO | KW_MACRO
    //     | KW_IF | KW_ELSE
    //     | KW_LOOP | KW_FOR
    static boolean symbol_lead(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "symbol_lead")) return false;
        boolean r;
        r = consumeToken(b, KW_LET);
        if (!r) r = consumeToken(b, KW_NAMESPACE);
        if (!r) r = consumeToken(b, KW_TYPE);
        if (!r) r = consumeToken(b, KW_CLASS);
        if (!r) r = consumeToken(b, KW_TRAIT);
        if (!r) r = consumeToken(b, KW_OBJECT);
        if (!r) r = consumeToken(b, KW_CATCH);
        if (!r) r = consumeToken(b, KW_MATCH);
        if (!r) r = consumeToken(b, KW_CASE);
        if (!r) r = consumeToken(b, KW_MICRO);
        if (!r) r = consumeToken(b, KW_MEZZO);
        if (!r) r = consumeToken(b, KW_MACRO);
        if (!r) r = consumeToken(b, KW_IF);
        if (!r) r = consumeToken(b, KW_ELSE);
        if (!r) r = consumeToken(b, KW_LOOP);
        if (!r) r = consumeToken(b, KW_FOR);
        return r;
    }

    /* ********************************************************** */
    // KW_FROM | KW_AS
    static boolean symbol_safe(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "symbol_safe")) return false;
        if (!nextTokenIs(b, "", KW_AS, KW_FROM)) return false;
        boolean r;
        r = consumeToken(b, KW_FROM);
        if (!r) r = consumeToken(b, KW_AS);
        return r;
    }

    /* ********************************************************** */
    // OP_END
    //     | TEMPLATE_L symbol-lead? KW_END TEMPLATE_R
    public static boolean template_end(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_end")) return false;
        if (!nextTokenIs(b, "<template end>", OP_END, TEMPLATE_L)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TEMPLATE_END, "<template end>");
        r = consumeToken(b, OP_END);
        if (!r) r = template_end_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // TEMPLATE_L symbol-lead? KW_END TEMPLATE_R
    private static boolean template_end_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_end_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, TEMPLATE_L);
        r = r && template_end_1_1(b, l + 1);
        r = r && consumeTokens(b, 0, KW_END, TEMPLATE_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // symbol-lead?
    private static boolean template_end_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "template_end_1_1")) return false;
        symbol_lead(b, l + 1);
        return true;
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
    // <<brace (declare-tests|run-benchmark|run-test-cast)>>
    public static boolean tests_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tests_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::tests_body_0_0);
        exit_section_(b, m, TESTS_BODY, r);
        return r;
    }

    // declare-tests|run-benchmark|run-test-cast
    private static boolean tests_body_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tests_body_0_0")) return false;
        boolean r;
        r = declare_tests(b, l + 1);
        if (!r) r = run_benchmark(b, l + 1);
        if (!r) r = run_test_cast(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // KW_THEN block-body
    public static boolean then_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "then_statement")) return false;
        if (!nextTokenIs(b, KW_THEN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, THEN_STATEMENT, null);
        r = consumeToken(b, KW_THEN);
        p = r; // pin = 1
        r = r && block_body(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // EQUAL type-expression
    public static boolean trait_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_alias")) return false;
        if (!nextTokenIs(b, EQUAL)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRAIT_ALIAS, null);
        r = consumeToken(b, EQUAL);
        p = r; // pin = 1
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // type-hint? declare-infer? class-body {
    // //    pin = 2
    // //    mixin = "valkyrie.psi.mixin.MixinTraitAlias"
    // }
    public static boolean trait_define(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_define")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TRAIT_DEFINE, "<trait define>");
        r = trait_define_0(b, l + 1);
        r = r && trait_define_1(b, l + 1);
        r = r && class_body(b, l + 1);
        r = r && trait_define_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-hint?
    private static boolean trait_define_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_define_0")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // declare-infer?
    private static boolean trait_define_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_define_1")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // {
    // //    pin = 2
    // //    mixin = "valkyrie.psi.mixin.MixinTraitAlias"
    // }
    private static boolean trait_define_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // KW_TRY KW_LET let-pattern type-hint? ASSIGN_L expression if-condition? else-statement
    public static boolean try_let_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_let_statement")) return false;
        if (!nextTokenIs(b, KW_TRY)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRY_LET_STATEMENT, null);
        r = consumeTokens(b, 2, KW_TRY, KW_LET);
        p = r; // pin = 2
        r = r && report_error_(b, let_pattern(b, l + 1));
        r = p && report_error_(b, try_let_statement_3(b, l + 1)) && r;
        r = p && report_error_(b, consumeToken(b, ASSIGN_L)) && r;
        r = p && report_error_(b, expression(b, l + 1)) && r;
        r = p && report_error_(b, try_let_statement_6(b, l + 1)) && r;
        r = p && else_statement(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // type-hint?
    private static boolean try_let_statement_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_let_statement_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // if-condition?
    private static boolean try_let_statement_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_let_statement_6")) return false;
        if_condition(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_TRY KW_NOT type-pattern ASSIGN_L expression block-body then-statement
    public static boolean try_not_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "try_not_statement")) return false;
        if (!nextTokenIs(b, KW_TRY)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, TRY_NOT_STATEMENT, null);
        r = consumeTokens(b, 2, KW_TRY, KW_NOT);
        p = r; // pin = 2
        r = r && report_error_(b, type_pattern(b, l + 1));
        r = p && report_error_(b, consumeToken(b, ASSIGN_L)) && r;
        r = p && report_error_(b, expression(b, l + 1)) && r;
        r = p && report_error_(b, block_body(b, l + 1)) && r;
        r = p && then_statement(b, l + 1) && r;
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
    // identifier-safe declare-infer? EQUAL type-expression
    public static boolean type_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_alias")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS, "<type alias>");
        r = identifier_safe(b, l + 1);
        r = r && type_alias_1(b, l + 1);
        r = r && consumeToken(b, EQUAL);
        r = r && type_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // declare-infer?
    private static boolean type_alias_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_alias_1")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L type-expression PARENTHESIS_R
    //     | type-tuple
    //     | namepath-safe
    //     | number-literal
    //     | string
    public static boolean type_atomic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_atomic")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_ATOMIC, "<type atomic>");
        r = type_atomic_0(b, l + 1);
        if (!r) r = type_tuple(b, l + 1);
        if (!r) r = namepath_safe(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = string(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L type-expression PARENTHESIS_R
    private static boolean type_atomic_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_atomic_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && type_expression(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
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
    // declare-infer? identifier-safe parameter-body return-type? block-body
    public static boolean type_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_function")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_FUNCTION, "<type function>");
        r = type_function_0(b, l + 1);
        r = r && identifier_safe(b, l + 1);
        r = r && parameter_body(b, l + 1);
        r = r && type_function_3(b, l + 1);
        r = r && block_body(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // declare-infer?
    private static boolean type_function_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_function_0")) return false;
        declare_infer(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean type_function_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_function_3")) return false;
        return_type(b, l + 1);
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
    // OP_ADD | OP_ARROW1 | OP_OR | OP_MUL | OP_DIV
    public static boolean type_infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_INFIX, "<type infix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_ARROW1);
        if (!r) r = consumeToken(b, OP_OR);
        if (!r) r = consumeToken(b, OP_MUL);
        if (!r) r = consumeToken(b, OP_DIV);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // special
    //     | type-pattern-object // X is Object { a: _ }
    //     | type-pattern-tuple  // X is Tuple()
    //     | string              // X is "string"
    //     | number-literal              // X is 1
    //     | type-pattern-item
    public static boolean type_pattern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN, "<type pattern>");
        r = special(b, l + 1);
        if (!r) r = type_pattern_object(b, l + 1);
        if (!r) r = type_pattern_tuple(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = type_pattern_item(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // special
    //     | type-pattern-tuple  // X is Tuple()
    //     | string              // X is "string"
    //     | number-literal              // X is 1
    //     | type-pattern-item
    public static boolean type_pattern_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_inline")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN_INLINE, "<type pattern inline>");
        r = special(b, l + 1);
        if (!r) r = type_pattern_tuple(b, l + 1);
        if (!r) r = string(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = type_pattern_item(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // namepath-safe generic-call-free?
    public static boolean type_pattern_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN_ITEM, "<type pattern item>");
        r = namepath_safe(b, l + 1);
        r = r && type_pattern_item_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // generic-call-free?
    private static boolean type_pattern_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_item_1")) return false;
        generic_call_free(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // namepath-safe? <<brace type-pattern-pair>>
    public static boolean type_pattern_object(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_object")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN_OBJECT, "<type pattern object>");
        r = type_pattern_object_0(b, l + 1);
        r = r && brace(b, l + 1, YggdrasilParser::type_pattern_pair);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-safe?
    private static boolean type_pattern_object_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_object_0")) return false;
        namepath_safe(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // identifier-safe (BIND|COLON) type-pattern
    public static boolean type_pattern_pair(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_pair")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN_PAIR, "<type pattern pair>");
        r = identifier_safe(b, l + 1);
        r = r && type_pattern_pair_1(b, l + 1);
        r = r && type_pattern(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // BIND|COLON
    private static boolean type_pattern_pair_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_pair_1")) return false;
        boolean r;
        r = consumeToken(b, BIND);
        if (!r) r = consumeToken(b, COLON);
        return r;
    }

    /* ********************************************************** */
    // namepath-safe? <<parenthesis type-pattern>>
    //                       | namepath-safe? <<bracket type-pattern>>
    public static boolean type_pattern_tuple(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_tuple")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PATTERN_TUPLE, "<type pattern tuple>");
        r = type_pattern_tuple_0(b, l + 1);
        if (!r) r = type_pattern_tuple_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // namepath-safe? <<parenthesis type-pattern>>
    private static boolean type_pattern_tuple_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_tuple_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_pattern_tuple_0_0(b, l + 1);
        r = r && parenthesis(b, l + 1, YggdrasilParser::type_pattern);
        exit_section_(b, m, null, r);
        return r;
    }

    // namepath-safe?
    private static boolean type_pattern_tuple_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_tuple_0_0")) return false;
        namepath_safe(b, l + 1);
        return true;
    }

    // namepath-safe? <<bracket type-pattern>>
    private static boolean type_pattern_tuple_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_tuple_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_pattern_tuple_1_0(b, l + 1);
        r = r && bracket(b, l + 1, YggdrasilParser::type_pattern);
        exit_section_(b, m, null, r);
        return r;
    }

    // namepath-safe?
    private static boolean type_pattern_tuple_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_pattern_tuple_1_0")) return false;
        namepath_safe(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_ADD | OP_SUB | OP_BANG | OP_AND | STAR
    public static boolean type_prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_PREFIX, "<type prefix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_SUB);
        if (!r) r = consumeToken(b, OP_BANG);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, STAR);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_AND_THEN
    //     | generic-call-free
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
    // PARENTHESIS_L PARENTHESIS_R
    //     | PARENTHESIS_L generic-argument COMMA PARENTHESIS_R
    //     | PARENTHESIS_L generic-argument (COMMA generic-argument)+ COMMA? PARENTHESIS_R
    public static boolean type_tuple(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parseTokens(b, 0, PARENTHESIS_L, PARENTHESIS_R);
        if (!r) r = type_tuple_1(b, l + 1);
        if (!r) r = type_tuple_2(b, l + 1);
        exit_section_(b, m, TYPE_TUPLE, r);
        return r;
    }

    // PARENTHESIS_L generic-argument COMMA PARENTHESIS_R
    private static boolean type_tuple_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && generic_argument(b, l + 1);
        r = r && consumeTokens(b, 0, COMMA, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // PARENTHESIS_L generic-argument (COMMA generic-argument)+ COMMA? PARENTHESIS_R
    private static boolean type_tuple_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && generic_argument(b, l + 1);
        r = r && type_tuple_2_2(b, l + 1);
        r = r && type_tuple_2_3(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-argument)+
    private static boolean type_tuple_2_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple_2_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_tuple_2_2_0(b, l + 1);
        while (r) {
            int c = current_position_(b);
            if (!type_tuple_2_2_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_tuple_2_2", c)) break;
        }
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA generic-argument
    private static boolean type_tuple_2_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple_2_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_argument(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean type_tuple_2_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_tuple_2_3")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // <<brace (declare-method|declare-variant)>>
    public static boolean unite_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unite_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::unite_body_0_0);
        exit_section_(b, m, UNITE_BODY, r);
        return r;
    }

    // declare-method|declare-variant
    private static boolean unite_body_0_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "unite_body_0_0")) return false;
        boolean r;
        r = declare_method(b, l + 1);
        if (!r) r = declare_variant(b, l + 1);
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
    // identifier-safe KW_AS identifier-safe
    public static boolean using_alias(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_alias")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_ALIAS, "<using alias>");
        r = identifier_safe(b, l + 1);
        r = r && consumeToken(b, KW_AS);
        r = r && identifier_safe(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // (namepath-auto using-dot?) STAR using-exclude?
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

    // namepath-auto using-dot?
    private static boolean using_any_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_any_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = namepath_auto(b, l + 1);
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
    // namepath-auto using-dot? using-body
    public static boolean using_block(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_block")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_BLOCK, "<using block>");
        r = namepath_auto(b, l + 1);
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
    // <<brace using-term>>
    public static boolean using_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = brace(b, l + 1, YggdrasilParser::using_term);
        exit_section_(b, m, USING_BODY, r);
        return r;
    }

    /* ********************************************************** */
    // DOT|NAME_SPLIT|OP_DIV
    static boolean using_dot(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_dot")) return false;
        boolean r;
        r = consumeToken(b, DOT);
        if (!r) r = consumeToken(b, NAME_SPLIT);
        if (!r) r = consumeToken(b, OP_DIV);
        return r;
    }

    /* ********************************************************** */
    // KW_EXCLUDE (identifier-safe| <<brace identifier-free>>)
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

    // identifier-safe| <<brace identifier-free>>
    private static boolean using_exclude_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_exclude_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier_safe(b, l + 1);
        if (!r) r = brace(b, l + 1, YggdrasilParser::identifier_free);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // annotations KW_USING (using-body|using-term)
    public static boolean using_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_statement")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, USING_STATEMENT, "<using statement>");
        r = annotations(b, l + 1);
        r = r && consumeToken(b, KW_USING);
        p = r; // pin = 2
        r = r && using_statement_2(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // using-body|using-term
    private static boolean using_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_statement_2")) return false;
        boolean r;
        r = using_body(b, l + 1);
        if (!r) r = using_term(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | using-any      // using
    //     | using-alias    // using
    //     | using-block    // using
    //     | namepath-auto
    public static boolean using_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "using_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, USING_TERM, "<using term>");
        r = consumeToken(b, SEMICOLON);
        if (!r) r = using_any(b, l + 1);
        if (!r) r = using_alias(b, l + 1);
        if (!r) r = using_block(b, l + 1);
        if (!r) r = namepath_auto(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // annotations type-term type-hint? default-type?
    public static boolean where_condition(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "where_condition")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, WHERE_CONDITION, "<where condition>");
        r = annotations(b, l + 1);
        r = r && type_term(b, l + 1);
        r = r && where_condition_2(b, l + 1);
        r = r && where_condition_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-hint?
    private static boolean where_condition_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "where_condition_2")) return false;
        type_hint(b, l + 1);
        return true;
    }

    // default-type?
    private static boolean where_condition_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "where_condition_3")) return false;
        default_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // COMMA | SEMICOLON
    //     | where-condition
    public static boolean where_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "where_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, WHERE_TERM, "<where term>");
        r = consumeToken(b, COMMA);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = where_condition(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

}
