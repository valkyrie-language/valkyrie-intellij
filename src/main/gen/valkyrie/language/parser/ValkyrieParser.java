// This is a generated file. Not intended for manual editing.
package valkyrie.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static valkyrie.language.psi.ValkyrieTypes.*;
import static valkyrie.language.psi.ValkyrieParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ValkyrieParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return valkyrie(b, l + 1);
  }

  /* ********************************************************** */
  // OP_LT [<<item>> (<<sp>> <<item>>)* [<<sp>>]] OP_GT
  static boolean angle_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block")) return false;
    if (!nextTokenIs(b, OP_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LT);
    r = r && angle_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean angle_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1")) return false;
    angle_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean angle_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && angle_block_1_0_1(b, l + 1, _sp, _item);
    r = r && angle_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean angle_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!angle_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "angle_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean angle_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean angle_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // case_pattern | normal_pattern
  static boolean any_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_pattern")) return false;
    boolean r;
    r = case_pattern(b, l + 1);
    if (!r) r = normal_pattern(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // OP_UNIMPLEMENTED
  //     | range | list | object | tuple | number | string | boolean | namepath | expression_statement
  //     | new_statement
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, OP_UNIMPLEMENTED);
    if (!r) r = range(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = namepath(b, l + 1);
    if (!r) r = expression_statement(b, l + 1);
    if (!r) r = new_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<brace_free (bitflag_item | macro_call) SEMICOLON>>
  public static boolean bitflag_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::bitflag_block_0_0, SEMICOLON_parser_);
    exit_section_(b, m, BITFLAG_BLOCK, r);
    return r;
  }

  // bitflag_item | macro_call
  private static boolean bitflag_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block_0_0")) return false;
    boolean r;
    r = bitflag_item(b, l + 1);
    if (!r) r = macro_call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier OP_SET expression
  public static boolean bitflag_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITFLAG_ITEM, "<bitflag item>");
    r = identifier(b, l + 1);
    r = r && consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_BITFLAG [modifiers] identifier [COLON type_expression] bitflag_block
  public static boolean bitflag_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement")) return false;
    if (!nextTokenIs(b, KW_BITFLAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_BITFLAG);
    r = r && bitflag_statement_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && bitflag_statement_3(b, l + 1);
    r = r && bitflag_block(b, l + 1);
    exit_section_(b, m, BITFLAG_STATEMENT, r);
    return r;
  }

  // [modifiers]
  private static boolean bitflag_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [COLON type_expression]
  private static boolean bitflag_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_3")) return false;
    bitflag_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean bitflag_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACE_R
  static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    brace_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && brace_block_1_0_1(b, l + 1, _sp, _item);
    r = r && brace_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean brace_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean brace_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean brace_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  static boolean brace_free(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_free_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_free_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_free_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_free_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_free_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean call_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, CALL_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ELSE
  public static boolean case_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_else")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    exit_section_(b, m, CASE_ELSE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CASE expression
  public static boolean case_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expression")) return false;
    if (!nextTokenIs(b, KW_CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CASE);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CASE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CASE pattern_value
  public static boolean case_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern")) return false;
    if (!nextTokenIs(b, KW_CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CASE);
    r = r && pattern_value(b, l + 1);
    exit_section_(b, m, CASE_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // KW_WITH
  public static boolean case_with(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_with")) return false;
    if (!nextTokenIs(b, KW_WITH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WITH);
    exit_section_(b, m, CASE_WITH, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CATCH inline_expression match_block
  public static boolean catch_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catch_statement")) return false;
    if (!nextTokenIs(b, KW_CATCH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CATCH_STATEMENT, null);
    r = consumeToken(b, KW_CATCH);
    p = r; // pin = 1
    r = r && report_error_(b, inline_expression(b, l + 1));
    r = p && match_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<brace_free class_item separator>>
  public static boolean class_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::class_item, ValkyrieParser::separator);
    exit_section_(b, m, CLASS_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (OP_DIV|KW_RAISE) type_expression
  public static boolean class_effect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_effect")) return false;
    if (!nextTokenIs(b, "<class effect>", KW_RAISE, OP_DIV)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_EFFECT, "<class effect>");
    r = class_effect_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_DIV|KW_RAISE
  private static boolean class_effect_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_effect_0")) return false;
    boolean r;
    r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, KW_RAISE);
    return r;
  }

  /* ********************************************************** */
  // KW_LET? [modifiers] object_key [COLON type_expression] [OP_SET expression] | object_key
  public static boolean class_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_FIELD, "<class field>");
    r = class_field_0(b, l + 1);
    if (!r) r = object_key(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_LET? [modifiers] object_key [COLON type_expression] [OP_SET expression]
  private static boolean class_field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_field_0_0(b, l + 1);
    r = r && class_field_0_1(b, l + 1);
    r = r && object_key(b, l + 1);
    r = r && class_field_0_3(b, l + 1);
    r = r && class_field_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_LET?
  private static boolean class_field_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_0")) return false;
    consumeToken(b, KW_LET);
    return true;
  }

  // [modifiers]
  private static boolean class_field_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [COLON type_expression]
  private static boolean class_field_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_3")) return false;
    class_field_0_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean class_field_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_SET expression]
  private static boolean class_field_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_4")) return false;
    class_field_0_4_0(b, l + 1);
    return true;
  }

  // OP_SET expression
  private static boolean class_field_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (COLON|KW_EXTENDS) type_expression
  public static boolean class_inherit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit")) return false;
    if (!nextTokenIs(b, "<class inherit>", COLON, KW_EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_INHERIT, "<class inherit>");
    r = class_inherit_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COLON|KW_EXTENDS
  private static boolean class_inherit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, KW_EXTENDS);
    return r;
  }

  /* ********************************************************** */
  // macro_call | type_statement | class_method | class_field
  static boolean class_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item")) return false;
    boolean r;
    r = macro_call(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = class_method(b, l + 1);
    if (!r) r = class_field(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_DEF? [modifiers] identifier [generic_define] define_tuple [return_type] [define_block]
  public static boolean class_method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_METHOD, "<class method>");
    r = class_method_0(b, l + 1);
    r = r && class_method_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && class_method_3(b, l + 1);
    r = r && define_tuple(b, l + 1);
    p = r; // pin = define_tuple
    r = r && report_error_(b, class_method_5(b, l + 1));
    r = p && class_method_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_DEF?
  private static boolean class_method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method_0")) return false;
    consumeToken(b, KW_DEF);
    return true;
  }

  // [modifiers]
  private static boolean class_method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [generic_define]
  private static boolean class_method_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method_3")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [return_type]
  private static boolean class_method_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method_5")) return false;
    return_type(b, l + 1);
    return true;
  }

  // [define_block]
  private static boolean class_method_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_method_6")) return false;
    define_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_CLASS <<modified identifier>> [generic_define] [class_inherit] [class_effect] class_block
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_STATEMENT, null);
    r = consumeToken(b, KW_CLASS);
    r = r && modified(b, l + 1, ValkyrieParser::identifier);
    p = r; // pin = 2
    r = r && report_error_(b, class_statement_2(b, l + 1));
    r = p && report_error_(b, class_statement_3(b, l + 1)) && r;
    r = p && report_error_(b, class_statement_4(b, l + 1)) && r;
    r = p && class_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [generic_define]
  private static boolean class_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [class_inherit]
  private static boolean class_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3")) return false;
    class_inherit(b, l + 1);
    return true;
  }

  // [class_effect]
  private static boolean class_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_4")) return false;
    class_effect(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // case_pattern OP_SET inline_expression | inline_expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    if (!r) r = inline_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // case_pattern OP_SET inline_expression
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, OP_SET);
    r = r && inline_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_RAISE expression
  //     | KW_RETURN [expression]
  //     | KW_RESUME [expression]
  //     | KW_CONTINUE [jump_label]
  //     | KW_BREAK [jump_label]
  //     | KW_YIELD [KW_WITH] expression
  //     | KW_YIELD KW_BREAK [jump_label]
  //     | OP_QUOTE (expression | normal_block)
  public static boolean control_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROL_STATEMENT, "<control statement>");
    r = control_statement_0(b, l + 1);
    if (!r) r = control_statement_1(b, l + 1);
    if (!r) r = control_statement_2(b, l + 1);
    if (!r) r = control_statement_3(b, l + 1);
    if (!r) r = control_statement_4(b, l + 1);
    if (!r) r = control_statement_5(b, l + 1);
    if (!r) r = control_statement_6(b, l + 1);
    if (!r) r = control_statement_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_RAISE expression
  private static boolean control_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RAISE);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_RETURN [expression]
  private static boolean control_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RETURN);
    r = r && control_statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean control_statement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_1_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // KW_RESUME [expression]
  private static boolean control_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RESUME);
    r = r && control_statement_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean control_statement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_2_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // KW_CONTINUE [jump_label]
  private static boolean control_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CONTINUE);
    r = r && control_statement_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [jump_label]
  private static boolean control_statement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_3_1")) return false;
    jump_label(b, l + 1);
    return true;
  }

  // KW_BREAK [jump_label]
  private static boolean control_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_BREAK);
    r = r && control_statement_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [jump_label]
  private static boolean control_statement_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_4_1")) return false;
    jump_label(b, l + 1);
    return true;
  }

  // KW_YIELD [KW_WITH] expression
  private static boolean control_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_YIELD);
    r = r && control_statement_5_1(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [KW_WITH]
  private static boolean control_statement_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_5_1")) return false;
    consumeToken(b, KW_WITH);
    return true;
  }

  // KW_YIELD KW_BREAK [jump_label]
  private static boolean control_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_YIELD, KW_BREAK);
    r = r && control_statement_6_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [jump_label]
  private static boolean control_statement_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_6_2")) return false;
    jump_label(b, l + 1);
    return true;
  }

  // OP_QUOTE (expression | normal_block)
  private static boolean control_statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_QUOTE);
    r = r && control_statement_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression | normal_block
  private static boolean control_statement_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_7_1")) return false;
    boolean r;
    r = expression(b, l + 1);
    if (!r) r = normal_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<brace_free normal_statements SEMICOLON>> {
  // }
  public static boolean define_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    r = r && define_block_1(b, l + 1);
    exit_section_(b, m, DEFINE_BLOCK, r);
    return r;
  }

  // {
  // }
  private static boolean define_block_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // OP_POW | OP_LT | OP_GT |
  //     macro_call* [modifiers] [KW_DOTS] identifier [COLON type_expression] [OP_SET expression]
  public static boolean define_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_ITEM, "<define item>");
    r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = define_item_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // macro_call* [modifiers] [KW_DOTS] identifier [COLON type_expression] [OP_SET expression]
  private static boolean define_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = define_item_3_0(b, l + 1);
    r = r && define_item_3_1(b, l + 1);
    r = r && define_item_3_2(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && define_item_3_4(b, l + 1);
    r = r && define_item_3_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // macro_call*
  private static boolean define_item_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!macro_call(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "define_item_3_0", c)) break;
    }
    return true;
  }

  // [modifiers]
  private static boolean define_item_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [KW_DOTS]
  private static boolean define_item_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_2")) return false;
    consumeToken(b, KW_DOTS);
    return true;
  }

  // [COLON type_expression]
  private static boolean define_item_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4")) return false;
    define_item_3_4_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean define_item_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_SET expression]
  private static boolean define_item_3_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5")) return false;
    define_item_3_5_0(b, l + 1);
    return true;
  }

  // OP_SET expression
  private static boolean define_item_3_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DEF [modifiers] namepath_free [generic_define] define_tuple [return_type] [define_block]
  public static boolean define_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement")) return false;
    if (!nextTokenIs(b, KW_DEF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_STATEMENT, null);
    r = consumeToken(b, KW_DEF);
    r = r && define_statement_1(b, l + 1);
    r = r && namepath_free(b, l + 1);
    p = r; // pin = namepath_free
    r = r && report_error_(b, define_statement_3(b, l + 1));
    r = p && report_error_(b, define_tuple(b, l + 1)) && r;
    r = p && report_error_(b, define_statement_5(b, l + 1)) && r;
    r = p && define_statement_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [modifiers]
  private static boolean define_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [generic_define]
  private static boolean define_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_3")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [return_type]
  private static boolean define_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5")) return false;
    return_type(b, l + 1);
    return true;
  }

  // [define_block]
  private static boolean define_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_6")) return false;
    define_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis define_item COMMA>>
  public static boolean define_tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::define_item, COMMA_parser_);
    exit_section_(b, m, DEFINE_TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // DOT namepath
  public static boolean dot_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_call")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && namepath(b, l + 1);
    exit_section_(b, m, DOT_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ELSE KW_IF condition normal_block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ELSE, KW_IF);
    r = r && condition(b, l + 1);
    r = r && normal_block(b, l + 1);
    exit_section_(b, m, EF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ELSE normal_block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && normal_block(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // COLON|OP_PROPORTION|SEMICOLON|
  //     BRACKET_L|BRACKET_R|PARENTHESIS_L|PARENTHESIS_R|BRACE_L|BRACE_R
  //     COMMA|OP_SET|OP_EQ|DOT|COMMA|OP_IN
  static boolean end_m1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_m1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, BRACKET_L);
    if (!r) r = consumeToken(b, BRACKET_R);
    if (!r) r = consumeToken(b, PARENTHESIS_L);
    if (!r) r = consumeToken(b, PARENTHESIS_R);
    if (!r) r = consumeToken(b, BRACE_L);
    if (!r) r = parseTokens(b, 0, BRACE_R, COMMA);
    if (!r) r = consumeToken(b, OP_SET);
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, OP_IN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // term (op_binary term)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = term(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary term)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // op_binary term
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if_statement
  //   | iff_statement
  //   | try_statement
  static boolean expression_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement")) return false;
    if (!nextTokenIs(b, "", KW_IF, KW_TRY)) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = iff_statement(b, l + 1);
    if (!r) r = try_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_EXTENDS [generic_call] [modifiers] namepath [generic_call] [COLON type_expression] class_block
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, KW_EXTENDS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTENDS_STATEMENT, null);
    r = consumeToken(b, KW_EXTENDS);
    r = r && extends_statement_1(b, l + 1);
    r = r && extends_statement_2(b, l + 1);
    r = r && namepath(b, l + 1);
    p = r; // pin = namepath
    r = r && report_error_(b, extends_statement_4(b, l + 1));
    r = p && report_error_(b, extends_statement_5(b, l + 1)) && r;
    r = p && class_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [generic_call]
  private static boolean extends_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_1")) return false;
    generic_call(b, l + 1);
    return true;
  }

  // [modifiers]
  private static boolean extends_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [generic_call]
  private static boolean extends_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_4")) return false;
    generic_call(b, l + 1);
    return true;
  }

  // [COLON type_expression]
  private static boolean extends_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_5")) return false;
    extends_statement_5_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean extends_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_EXTENSION identifier COLON namepath_free top_block
  public static boolean extension_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_statement")) return false;
    if (!nextTokenIs(b, KW_EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_EXTENSION);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && namepath_free(b, l + 1);
    r = r && top_block(b, l + 1);
    exit_section_(b, m, EXTENSION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_FOR any_pattern OP_IN inline_expression [if_guard] normal_block [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, null);
    r = consumeToken(b, KW_FOR);
    p = r; // pin = 1
    r = r && report_error_(b, any_pattern(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_IN)) && r;
    r = p && report_error_(b, inline_expression(b, l + 1)) && r;
    r = p && report_error_(b, for_statement_4(b, l + 1)) && r;
    r = p && report_error_(b, normal_block(b, l + 1)) && r;
    r = p && for_statement_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [if_guard]
  private static boolean for_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_4")) return false;
    if_guard(b, l + 1);
    return true;
  }

  // [else_statement]
  private static boolean for_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_6")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block (expression COLON expression) separator>>
  public static boolean forall_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::forall_block_0_0, ValkyrieParser::separator);
    exit_section_(b, m, FORALL_BLOCK, r);
    return r;
  }

  // expression COLON expression
  private static boolean forall_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_FORALL <<sequence identifier COMMA>> [forall_block]
  public static boolean forall_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_statement")) return false;
    if (!nextTokenIs(b, OP_FORALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_FORALL);
    r = r && sequence(b, l + 1, ValkyrieParser::identifier, COMMA_parser_);
    r = r && forall_statement_2(b, l + 1);
    exit_section_(b, m, FORALL_STATEMENT, r);
    return r;
  }

  // [forall_block]
  private static boolean forall_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_statement_2")) return false;
    forall_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON{2} generic_type
  public static boolean generic_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_2")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && generic_2_1(b, l + 1);
    r = r && generic_type(b, l + 1);
    exit_section_(b, m, GENERIC_2, r);
    return r;
  }

  // {2}
  private static boolean generic_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "2");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block type_expression COMMA>>
  public static boolean generic_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::type_expression, COMMA_parser_);
    exit_section_(b, m, GENERIC_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block type_term COMMA>>
  public static boolean generic_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::type_term, COMMA_parser_);
    exit_section_(b, m, GENERIC_DEFINE, r);
    return r;
  }

  /* ********************************************************** */
  // identifier [generic_call]
  public static boolean generic_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE, "<generic type>");
    r = identifier(b, l + 1);
    r = r && generic_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [generic_call]
  private static boolean generic_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_type_1")) return false;
    generic_call(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [SLOT_LAMBDA|SLOT_MACRO] (SYMBOL_XID | SYMBOL_RAW | KW_NAMESPACE | KW_CLASS)
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = identifier_0(b, l + 1);
    r = r && identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [SLOT_LAMBDA|SLOT_MACRO]
  private static boolean identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_0")) return false;
    identifier_0_0(b, l + 1);
    return true;
  }

  // SLOT_LAMBDA|SLOT_MACRO
  private static boolean identifier_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_0_0")) return false;
    boolean r;
    r = consumeToken(b, SLOT_LAMBDA);
    if (!r) r = consumeToken(b, SLOT_MACRO);
    return r;
  }

  // SYMBOL_XID | SYMBOL_RAW | KW_NAMESPACE | KW_CLASS
  private static boolean identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1")) return false;
    boolean r;
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    if (!r) r = consumeToken(b, KW_NAMESPACE);
    if (!r) r = consumeToken(b, KW_CLASS);
    return r;
  }

  /* ********************************************************** */
  // KW_IF condition
  public static boolean if_guard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_guard")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && condition(b, l + 1);
    exit_section_(b, m, IF_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // KW_IF condition normal_block [ef_statement* else_statement]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, null);
    r = consumeToken(b, KW_IF);
    r = r && condition(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, normal_block(b, l + 1));
    r = p && if_statement_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ef_statement* else_statement]
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    if_statement_3_0(b, l + 1);
    return true;
  }

  // ef_statement* else_statement
  private static boolean if_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_3_0_0(b, l + 1);
    r = r && else_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ef_statement*
  private static boolean if_statement_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ef_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_3_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<brace_free iff_expression SEMICOLON>>
  public static boolean iff_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::iff_expression, SEMICOLON_parser_);
    exit_section_(b, m, IFF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (case_expression | case_else) COLON (normal_statements [SEMICOLON])+
  public static boolean iff_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_expression")) return false;
    if (!nextTokenIs(b, "<iff expression>", KW_CASE, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IFF_EXPRESSION, "<iff expression>");
    r = iff_expression_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && iff_expression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // case_expression | case_else
  private static boolean iff_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_expression_0")) return false;
    boolean r;
    r = case_expression(b, l + 1);
    if (!r) r = case_else(b, l + 1);
    return r;
  }

  // (normal_statements [SEMICOLON])+
  private static boolean iff_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = iff_expression_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!iff_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "iff_expression_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // normal_statements [SEMICOLON]
  private static boolean iff_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_statements(b, l + 1);
    r = r && iff_expression_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SEMICOLON]
  private static boolean iff_expression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_expression_2_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // KW_IF iff_block
  public static boolean iff_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iff_statement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && iff_block(b, l + 1);
    exit_section_(b, m, IFF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_free import_item (COMMA|SEMICOLON)>>
  public static boolean import_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::import_item, ValkyrieParser::import_block_0_1);
    exit_section_(b, m, IMPORT_BLOCK, r);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean import_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // namepath_star [OP_AS identifier|(DOT|OP_PROPORTION) import_block]
  public static boolean import_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ITEM, "<import item>");
    r = namepath_star(b, l + 1);
    r = r && import_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [OP_AS identifier|(DOT|OP_PROPORTION) import_block]
  private static boolean import_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1")) return false;
    import_item_1_0(b, l + 1);
    return true;
  }

  // OP_AS identifier|(DOT|OP_PROPORTION) import_block
  private static boolean import_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_item_1_0_0(b, l + 1);
    if (!r) r = import_item_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_AS identifier
  private static boolean import_item_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_AS);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT|OP_PROPORTION) import_block
  private static boolean import_item_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_item_1_0_1_0(b, l + 1);
    r = r && import_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT|OP_PROPORTION
  private static boolean import_item_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    return r;
  }

  /* ********************************************************** */
  // KW_IMPORT (import_block|import_item)
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IMPORT);
    r = r && import_statement_1(b, l + 1);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  // import_block|import_item
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    r = import_block(b, l + 1);
    if (!r) r = import_item(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // inline_term (op_binary inline_term)*
  public static boolean inline_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_EXPRESSION, "<inline expression>");
    r = inline_term(b, l + 1);
    r = r && inline_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary inline_term)*
  private static boolean inline_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inline_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_expression_1", c)) break;
    }
    return true;
  }

  // op_binary inline_term
  private static boolean inline_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && inline_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // op_prefix* atom line_sfx*
  public static boolean inline_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_TERM, "<inline term>");
    r = inline_term_0(b, l + 1);
    r = r && atom(b, l + 1);
    r = r && inline_term_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // op_prefix*
  private static boolean inline_term_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_term_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_term_0", c)) break;
    }
    return true;
  }

  // line_sfx*
  private static boolean inline_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_term_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_sfx(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_term_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L identifier PARENTHESIS_R | identifier
  public static boolean jump_label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_label")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JUMP_LABEL, "<jump label>");
    r = jump_label_0(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PARENTHESIS_L identifier PARENTHESIS_R
  private static boolean jump_label_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_label_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LET normal_pattern [let_type] [OP_SET normal_statements]
  //     | KW_LET case_pattern OP_SET normal_statements
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, KW_LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_statement_0(b, l + 1);
    if (!r) r = let_statement_1(b, l + 1);
    exit_section_(b, m, LET_STATEMENT, r);
    return r;
  }

  // KW_LET normal_pattern [let_type] [OP_SET normal_statements]
  private static boolean let_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LET);
    r = r && normal_pattern(b, l + 1);
    r = r && let_statement_0_2(b, l + 1);
    r = r && let_statement_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [let_type]
  private static boolean let_statement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_2")) return false;
    let_type(b, l + 1);
    return true;
  }

  // [OP_SET normal_statements]
  private static boolean let_statement_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_3")) return false;
    let_statement_0_3_0(b, l + 1);
    return true;
  }

  // OP_SET normal_statements
  private static boolean let_statement_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && normal_statements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_LET case_pattern OP_SET normal_statements
  private static boolean let_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LET);
    r = r && case_pattern(b, l + 1);
    r = r && consumeToken(b, OP_SET);
    r = r && normal_statements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON <<sequence type_expression COMMA>>
  static boolean let_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_type")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && sequence(b, l + 1, ValkyrieParser::type_expression, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // op_suffix | call_suffix | generic_2 | slice | dot_call {
  // }
  static boolean line_sfx(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_sfx")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = generic_2(b, l + 1);
    if (!r) r = slice(b, l + 1);
    if (!r) r = line_sfx_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // dot_call {
  // }
  private static boolean line_sfx_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_sfx_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dot_call(b, l + 1);
    r = r && line_sfx_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean line_sfx_4_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // <<bracket_block expression COMMA>>
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, LIST, r);
    return r;
  }

  /* ********************************************************** */
  // (KW_LOOP | KW_WHILE condition) normal_block [else_statement]
  public static boolean loop_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement")) return false;
    if (!nextTokenIs(b, "<loop statement>", KW_LOOP, KW_WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOOP_STATEMENT, "<loop statement>");
    r = loop_statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, normal_block(b, l + 1));
    r = p && loop_statement_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_LOOP | KW_WHILE condition
  private static boolean loop_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LOOP);
    if (!r) r = loop_statement_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_WHILE condition
  private static boolean loop_statement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WHILE);
    r = r && condition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [else_statement]
  private static boolean loop_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_2")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression separator>>
  //   | <<bracket_block expression separator>>
  //   | <<brace_block expression separator>>
  public static boolean macro_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_BLOCK, "<macro block>");
    r = parenthesis(b, l + 1, ValkyrieParser::expression, ValkyrieParser::separator);
    if (!r) r = bracket_block(b, l + 1, ValkyrieParser::expression, ValkyrieParser::separator);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::expression, ValkyrieParser::separator);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (OP_AT|OP_HASH) namepath_free [macro_block]
  public static boolean macro_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call")) return false;
    if (!nextTokenIs(b, "<macro call>", OP_AT, OP_HASH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_CALL, "<macro call>");
    r = macro_call_0(b, l + 1);
    r = r && namepath_free(b, l + 1);
    r = r && macro_call_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_AT|OP_HASH
  private static boolean macro_call_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_0")) return false;
    boolean r;
    r = consumeToken(b, OP_AT);
    if (!r) r = consumeToken(b, OP_HASH);
    return r;
  }

  // [macro_block]
  private static boolean macro_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_2")) return false;
    macro_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_MACRO <<bracket_block (namepath_free [macro_block]) COMMA>>
  public static boolean macro_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list")) return false;
    if (!nextTokenIs(b, KW_MACRO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_MACRO);
    r = r && bracket_block(b, l + 1, ValkyrieParser::macro_list_1_0, COMMA_parser_);
    exit_section_(b, m, MACRO_LIST, r);
    return r;
  }

  // namepath_free [macro_block]
  private static boolean macro_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath_free(b, l + 1);
    r = r && macro_list_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [macro_block]
  private static boolean macro_list_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_1_0_1")) return false;
    macro_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_free match_expression SEMICOLON>>
  public static boolean match_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::match_expression, SEMICOLON_parser_);
    exit_section_(b, m, MATCH_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (case_pattern|case_else) COLON (normal_statements [SEMICOLON])+ | case_with
  public static boolean match_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_EXPRESSION, "<match expression>");
    r = match_expression_0(b, l + 1);
    if (!r) r = case_with(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (case_pattern|case_else) COLON (normal_statements [SEMICOLON])+
  private static boolean match_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_expression_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && match_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case_pattern|case_else
  private static boolean match_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_0_0")) return false;
    boolean r;
    r = case_pattern(b, l + 1);
    if (!r) r = case_else(b, l + 1);
    return r;
  }

  // (normal_statements [SEMICOLON])+
  private static boolean match_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_expression_0_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_expression_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expression_0_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // normal_statements [SEMICOLON]
  private static boolean match_expression_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_statements(b, l + 1);
    r = r && match_expression_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SEMICOLON]
  private static boolean match_expression_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_0_2_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // KW_MATCH inline_expression match_block
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, KW_MATCH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATCH_STATEMENT, null);
    r = consumeToken(b, KW_MATCH);
    p = r; // pin = 1
    r = r && report_error_(b, inline_expression(b, l + 1));
    r = p && match_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // [modifiers] <<item>>
  public static boolean modified(PsiBuilder b, int l, Parser _item) {
    if (!recursion_guard_(b, l, "modified")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modified_0(b, l + 1);
    r = r && _item.parse(b, l);
    exit_section_(b, m, MODIFIED, r);
    return r;
  }

  // [modifiers]
  private static boolean modified_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modified_0")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (identifier !end_m1)+
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERS, "<modifiers>");
    r = modifiers_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!modifiers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifiers", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier !end_m1
  private static boolean modifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && modifiers_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !end_m1
  private static boolean modifiers_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !end_m1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (OP_PROPORTION identifier)*
  public static boolean namepath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
    r = identifier(b, l + 1);
    r = r && namepath_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_PROPORTION identifier)*
  private static boolean namepath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
    }
    return true;
  }

  // OP_PROPORTION identifier
  private static boolean namepath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PROPORTION);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ((DOT|OP_PROPORTION) identifier)*
  public static boolean namepath_free(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH_FREE, "<namepath free>");
    r = identifier(b, l + 1);
    r = r && namepath_free_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((DOT|OP_PROPORTION) identifier)*
  private static boolean namepath_free_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_free_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_free_1", c)) break;
    }
    return true;
  }

  // (DOT|OP_PROPORTION) identifier
  private static boolean namepath_free_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath_free_1_0_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT|OP_PROPORTION
  private static boolean namepath_free_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    return r;
  }

  /* ********************************************************** */
  // identifier ((DOT|OP_PROPORTION) (OP_MUL|identifier))*
  public static boolean namepath_star(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_star")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH_STAR, "<namepath star>");
    r = identifier(b, l + 1);
    r = r && namepath_star_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((DOT|OP_PROPORTION) (OP_MUL|identifier))*
  private static boolean namepath_star_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_star_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_star_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_star_1", c)) break;
    }
    return true;
  }

  // (DOT|OP_PROPORTION) (OP_MUL|identifier)
  private static boolean namepath_star_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_star_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath_star_1_0_0(b, l + 1);
    r = r && namepath_star_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT|OP_PROPORTION
  private static boolean namepath_star_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_star_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    return r;
  }

  // OP_MUL|identifier
  private static boolean namepath_star_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_star_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, OP_MUL);
    if (!r) r = identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_NAMESPACE namepath_free
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    if (!nextTokenIs(b, KW_NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NAMESPACE);
    r = r && namepath_free(b, l + 1);
    exit_section_(b, m, NAMESPACE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block new_item COMMA>>
  public static boolean new_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::new_item, COMMA_parser_);
    exit_section_(b, m, NEW_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // object_pair | (DOT2|DOT3) identifier
  static boolean new_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = object_pair(b, l + 1);
    if (!r) r = new_item_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT2|DOT3) identifier
  private static boolean new_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = new_item_1_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT2|DOT3
  private static boolean new_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_item_1_0")) return false;
    boolean r;
    r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT3);
    return r;
  }

  /* ********************************************************** */
  // KW_NEW <<modified type_expression>> new_block
  public static boolean new_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement")) return false;
    if (!nextTokenIs(b, KW_NEW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NEW_STATEMENT, null);
    r = consumeToken(b, KW_NEW);
    p = r; // pin = 1
    r = r && report_error_(b, modified(b, l + 1, ValkyrieParser::type_expression));
    r = p && new_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<brace_free normal_statements SEMICOLON>>
  public static boolean normal_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, NORMAL_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // '(' pattern_item (COMMA pattern_item)* [COMMA] ')' |
  //         pattern_item (COMMA pattern_item)* [COMMA]
  public static boolean normal_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NORMAL_PATTERN, "<normal pattern>");
    r = normal_pattern_0(b, l + 1);
    if (!r) r = normal_pattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' pattern_item (COMMA pattern_item)* [COMMA] ')'
  private static boolean normal_pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && pattern_item(b, l + 1);
    r = r && normal_pattern_0_2(b, l + 1);
    r = r && normal_pattern_0_3(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA pattern_item)*
  private static boolean normal_pattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!normal_pattern_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_pattern_0_2", c)) break;
    }
    return true;
  }

  // COMMA pattern_item
  private static boolean normal_pattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean normal_pattern_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // pattern_item (COMMA pattern_item)* [COMMA]
  private static boolean normal_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_item(b, l + 1);
    r = r && normal_pattern_1_1(b, l + 1);
    r = r && normal_pattern_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA pattern_item)*
  private static boolean normal_pattern_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!normal_pattern_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_pattern_1_1", c)) break;
    }
    return true;
  }

  // COMMA pattern_item
  private static boolean normal_pattern_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean normal_pattern_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_1_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // control_statement
  //   | macro_call
  //   | macro_list
  //   | for_statement
  //   | let_statement
  //   | type_statement
  //   | loop_statement
  //   | match_statement
  //   | catch_statement
  //   | forall_statement
  //   | expression
  static boolean normal_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_statements")) return false;
    boolean r;
    r = control_statement(b, l + 1);
    if (!r) r = macro_call(b, l + 1);
    if (!r) r = macro_list(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = loop_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    if (!r) r = catch_statement(b, l + 1);
    if (!r) r = forall_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BYTE | INTEGER | DECIMAL) [NUMBER_SUFFIX]
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_0(b, l + 1);
    r = r && number_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BYTE | INTEGER | DECIMAL
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    boolean r;
    r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // [NUMBER_SUFFIX]
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    consumeToken(b, NUMBER_SUFFIX);
    return true;
  }

  /* ********************************************************** */
  // <<bracket_block object_pair COMMA>>
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::object_pair, COMMA_parser_);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL_XID | SYMBOL_RAW | INTEGER | KW_IF | KW_CLASS
  public static boolean object_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_KEY, "<object key>");
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, KW_IF);
    if (!r) r = consumeToken(b, KW_CLASS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // object_key COLON expression
  public static boolean object_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_PAIR, "<object pair>");
    r = object_key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_SET | OP_EQ | OP_NE
  //     | OP_ADD | OP_ADD_ASSIGN
  //     | OP_SUB | OP_SUB_ASSIGN
  //     | OP_MUL | OP_MUL_ASSIGN
  //     | OP_DIV | OP_DIV_ASSIGN | OP_MOD | OP_MOD_ASSIGN
  //     | OP_POW | OP_POW_ASSIGN
  //     | OP_GT | OP_LT | OP_LL | OP_LLL | OP_GG | OP_GGG
  //     | DOT_LESS | DOT_EQ | DOT2 | DOT
  //     | OP_TO | OP_OR | OP_OR2
  //     | OP_AND_THEN | OP_OR_ELSE
  //     | OP_AND | OP_AND2
  //     // is | is not
  //     | OP_NOT_A | OP_IS_A OP_NOT | OP_IS_A | OP_NOT OP_IS_A
  //     | OP_AS
  //     // in | not in
  //     // | OP_IN | OP_NOT_IN | OP_NOT OP_IN
  //     | OP_UNTIL
  static boolean op_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, OP_NE);
    if (!r) r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_ADD_ASSIGN);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_SUB_ASSIGN);
    if (!r) r = consumeToken(b, OP_MUL);
    if (!r) r = consumeToken(b, OP_MUL_ASSIGN);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_DIV_ASSIGN);
    if (!r) r = consumeToken(b, OP_MOD);
    if (!r) r = consumeToken(b, OP_MOD_ASSIGN);
    if (!r) r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_POW_ASSIGN);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_LL);
    if (!r) r = consumeToken(b, OP_LLL);
    if (!r) r = consumeToken(b, OP_GG);
    if (!r) r = consumeToken(b, OP_GGG);
    if (!r) r = consumeToken(b, DOT_LESS);
    if (!r) r = consumeToken(b, DOT_EQ);
    if (!r) r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_TO);
    if (!r) r = consumeToken(b, OP_OR);
    if (!r) r = consumeToken(b, OP_OR2);
    if (!r) r = consumeToken(b, OP_AND_THEN);
    if (!r) r = consumeToken(b, OP_OR_ELSE);
    if (!r) r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_AND2);
    if (!r) r = consumeToken(b, OP_NOT_A);
    if (!r) r = parseTokens(b, 0, OP_IS_A, OP_NOT);
    if (!r) r = consumeToken(b, OP_IS_A);
    if (!r) r = parseTokens(b, 0, OP_NOT, OP_IS_A);
    if (!r) r = consumeToken(b, OP_AS);
    if (!r) r = consumeToken(b, OP_UNTIL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_ADD | OP_SUB | OP_NOT | BANG | AMP | DOT3 | DOT2
  static boolean op_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_prefix")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_NOT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, AMP);
    if (!r) r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  /* ********************************************************** */
  // BANG | OP_QUESTION
  static boolean op_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_suffix")) return false;
    if (!nextTokenIs(b, "", BANG, OP_QUESTION)) return false;
    boolean r;
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, OP_QUESTION);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && parenthesis_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean parenthesis_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1")) return false;
    parenthesis_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && parenthesis_1_0_1(b, l + 1, _sp, _item);
    r = r && parenthesis_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parenthesis_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean parenthesis_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis   id_with_mod COMMA>>
  //   | <<bracket_block id_with_mod COMMA>>
  //   | <<brace_block   pattern_pair COMMA>>
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ID_WITH_MOD_parser_, COMMA_parser_);
    if (!r) r = bracket_block(b, l + 1, ID_WITH_MOD_parser_, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [modifiers] identifier
  public static boolean pattern_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_ITEM, "<pattern item>");
    r = pattern_item_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean pattern_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier* COLON pattern_value | identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_PAIR, "<pattern pair>");
    r = pattern_pair_0(b, l + 1);
    if (!r) r = pattern_pair_1(b, l + 1);
    if (!r) r = pattern_pair_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* COLON pattern_value
  private static boolean pattern_pair_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && pattern_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_0_0", c)) break;
    }
    return true;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_pair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_1_0(b, l + 1);
    r = r && pattern_pair_1_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_1_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_pair_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_pair_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // number | string | [namepath] <<parenthesis pattern_value COMMA>> | [namepath] <<brace_block pattern_pair COMMA>> | namepath
  public static boolean pattern_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_VALUE, "<pattern value>");
    r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = pattern_value_2(b, l + 1);
    if (!r) r = pattern_value_3(b, l + 1);
    if (!r) r = namepath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [namepath] <<parenthesis pattern_value COMMA>>
  private static boolean pattern_value_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_value_2_0(b, l + 1);
    r = r && parenthesis(b, l + 1, ValkyrieParser::pattern_value, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // [namepath]
  private static boolean pattern_value_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value_2_0")) return false;
    namepath(b, l + 1);
    return true;
  }

  // [namepath] <<brace_block pattern_pair COMMA>>
  private static boolean pattern_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_value_3_0(b, l + 1);
    r = r && brace_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // [namepath]
  private static boolean pattern_value_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value_3_0")) return false;
    namepath(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<slice_block slice_item COMMA>>
  public static boolean range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_block(b, l + 1, ValkyrieParser::slice_item, COMMA_parser_);
    exit_section_(b, m, RANGE, r);
    return r;
  }

  /* ********************************************************** */
  // (COLON|OP_ARROW) type_expression
  public static boolean return_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_type")) return false;
    if (!nextTokenIs(b, "<return type>", COLON, OP_ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETURN_TYPE, "<return type>");
    r = return_type_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COLON|OP_ARROW
  private static boolean return_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_type_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_ARROW);
    return r;
  }

  /* ********************************************************** */
  // COMMA | SEMICOLON
  static boolean separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "separator")) return false;
    if (!nextTokenIs(b, "", COMMA, SEMICOLON)) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  static boolean sequence(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && sequence_1(b, l + 1, _sp, _item);
    r = r && sequence_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean sequence_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sequence_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "sequence_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean sequence_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean sequence_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<slice_block slice_item COMMA>>
  public static boolean slice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_block(b, l + 1, ValkyrieParser::slice_item, COMMA_parser_);
    exit_section_(b, m, SLICE, r);
    return r;
  }

  /* ********************************************************** */
  // SLICE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] SLICE_R
  static boolean slice_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLICE_L);
    r = r && slice_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, SLICE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean slice_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1")) return false;
    slice_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean slice_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && slice_block_1_0_1(b, l + 1, _sp, _item);
    r = r && slice_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean slice_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "slice_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!slice_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "slice_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean slice_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "slice_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean slice_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // [expression] COLON [expression] COLON [expression]
  //   | [expression] COLON [expression]
  //   | [expression] OP_PROPORTION [expression]
  //   | expression
  public static boolean slice_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLICE_ITEM, "<slice item>");
    r = slice_item_0(b, l + 1);
    if (!r) r = slice_item_1(b, l + 1);
    if (!r) r = slice_item_2(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [expression] COLON [expression] COLON [expression]
  private static boolean slice_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_0_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_4")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] COLON [expression]
  private static boolean slice_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_1_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] OP_PROPORTION [expression]
  private static boolean slice_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_2_0(b, l + 1);
    r = r && consumeToken(b, OP_PROPORTION);
    r = r && slice_item_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2_2")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [identifier] STRING_START STRING_TEXT STRING_END
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    r = r && consumeTokens(b, 0, STRING_START, STRING_TEXT, STRING_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier]
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // op_prefix* atom term_sfx*
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = term_0(b, l + 1);
    r = r && atom(b, l + 1);
    r = r && term_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // op_prefix*
  private static boolean term_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_0", c)) break;
    }
    return true;
  }

  // term_sfx*
  private static boolean term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_sfx(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line_sfx
  //     | normal_block
  //     | DOT KW_CATCH match_block
  //     | DOT KW_MATCH match_block
  //     | DOT KW_FOR any_pattern {
  // }
  static boolean term_sfx(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_sfx")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line_sfx(b, l + 1);
    if (!r) r = normal_block(b, l + 1);
    if (!r) r = term_sfx_2(b, l + 1);
    if (!r) r = term_sfx_3(b, l + 1);
    if (!r) r = term_sfx_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT KW_CATCH match_block
  private static boolean term_sfx_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_sfx_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, KW_CATCH);
    r = r && match_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT KW_MATCH match_block
  private static boolean term_sfx_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_sfx_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, KW_MATCH);
    r = r && match_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT KW_FOR any_pattern {
  // }
  private static boolean term_sfx_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_sfx_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, KW_FOR);
    r = r && any_pattern(b, l + 1);
    r = r && term_sfx_4_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean term_sfx_4_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // <<brace_free top_statements SEMICOLON>>
  public static boolean top_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::top_statements, SEMICOLON_parser_);
    exit_section_(b, m, TOP_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_statement
  //   | import_statement
  //   | extension_statement
  //   | class_statement
  //   | union_statement
  //   | bitflag_statement
  //   | trait_statement
  //   | extends_statement
  //   | define_statement
  static boolean top_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statements")) return false;
    boolean r;
    r = namespace_statement(b, l + 1);
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = extension_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = union_statement(b, l + 1);
    if (!r) r = bitflag_statement(b, l + 1);
    if (!r) r = trait_statement(b, l + 1);
    if (!r) r = extends_statement(b, l + 1);
    if (!r) r = define_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_TRAIT <<modified identifier>> [generic_define] [COLON type_expression] class_block
  public static boolean trait_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement")) return false;
    if (!nextTokenIs(b, KW_TRAIT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_STATEMENT, null);
    r = consumeToken(b, KW_TRAIT);
    r = r && modified(b, l + 1, ValkyrieParser::identifier);
    p = r; // pin = 2
    r = r && report_error_(b, trait_statement_2(b, l + 1));
    r = p && report_error_(b, trait_statement_3(b, l + 1)) && r;
    r = p && class_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [generic_define]
  private static boolean trait_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_2")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [COLON type_expression]
  private static boolean trait_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_3")) return false;
    trait_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean trait_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_TRY normal_block
  public static boolean try_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_statement")) return false;
    if (!nextTokenIs(b, KW_TRY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRY_STATEMENT, null);
    r = consumeToken(b, KW_TRY);
    p = r; // pin = 1
    r = r && normal_block(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // namepath_free | <<bracket_block namepath_free separator>>
  public static boolean type_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ATOM, "<type atom>");
    r = namepath_free(b, l + 1);
    if (!r) r = bracket_block(b, l + 1, ValkyrieParser::namepath_free, ValkyrieParser::separator);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_AND | OP_OR | OP_ADD | OP_DIV | OP_ARROW
  static boolean type_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_binary")) return false;
    boolean r;
    r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_OR);
    if (!r) r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_ARROW);
    return r;
  }

  /* ********************************************************** */
  // type_term (type_binary type_term)*
  public static boolean type_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
    r = type_term(b, l + 1);
    r = r && type_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (type_binary type_term)*
  private static boolean type_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expression_1", c)) break;
    }
    return true;
  }

  // type_binary type_term
  private static boolean type_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_binary(b, l + 1);
    r = r && type_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_TYPE generic_type [OP_SET type_term]
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, KW_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_STATEMENT, null);
    r = consumeToken(b, KW_TYPE);
    r = r && generic_type(b, l + 1);
    p = r; // pin = 2
    r = r && type_statement_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [OP_SET type_term]
  private static boolean type_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2")) return false;
    type_statement_2_0(b, l + 1);
    return true;
  }

  // OP_SET type_term
  private static boolean type_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && type_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_atom generic_call?
  public static boolean type_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_TERM, "<type term>");
    r = type_atom(b, l + 1);
    r = r && type_term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // generic_call?
  private static boolean type_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_term_1")) return false;
    generic_call(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block union_item separator>>
  public static boolean union_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::union_item, ValkyrieParser::separator);
    exit_section_(b, m, UNION_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // identifier [class_block]
  public static boolean union_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_ITEM, "<union item>");
    r = identifier(b, l + 1);
    r = r && union_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [class_block]
  private static boolean union_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_item_1")) return false;
    class_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_TAGGED <<modified identifier>> [generic_define] [class_effect] union_block
  public static boolean union_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement")) return false;
    if (!nextTokenIs(b, KW_TAGGED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION_STATEMENT, null);
    r = consumeToken(b, KW_TAGGED);
    r = r && modified(b, l + 1, ValkyrieParser::identifier);
    p = r; // pin = 2
    r = r && report_error_(b, union_statement_2(b, l + 1));
    r = p && report_error_(b, union_statement_3(b, l + 1)) && r;
    r = p && union_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [generic_define]
  private static boolean union_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement_2")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [class_effect]
  private static boolean union_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement_3")) return false;
    class_effect(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (top_statements | normal_statements | SEMICOLON)*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!valkyrie_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

  // top_statements | normal_statements | SEMICOLON
  private static boolean valkyrie_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0")) return false;
    boolean r;
    r = top_statements(b, l + 1);
    if (!r) r = normal_statements(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser ID_WITH_MOD_parser_ = (b, l) -> consumeToken(b, ID_WITH_MOD);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
