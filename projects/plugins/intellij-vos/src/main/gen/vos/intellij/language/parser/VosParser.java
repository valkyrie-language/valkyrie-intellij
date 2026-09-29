// This is a generated file. Not intended for manual editing.
package vos.intellij.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static vos.intellij.language.psi.VosTypes.*;
import static vos.intellij.language.psi.VosParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VosParser implements PsiParser, LightPsiParser {

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
    return VOS(b, l + 1);
  }

  /* ********************************************************** */
  // statement*
  static boolean VOS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VOS")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VOS", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ANNOTATION_MARK (annotation_one | <<bracket_block annotation_one COMMA>>) {
  // }
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANNOTATION_MARK);
    r = r && annotation_1(b, l + 1);
    r = r && annotation_2(b, l + 1);
    exit_section_(b, m, ANNOTATION, r);
    return r;
  }

  // annotation_one | <<bracket_block annotation_one COMMA>>
  private static boolean annotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_one(b, l + 1);
    if (!r) r = bracket_block(b, l + 1, VosParser::annotation_one, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean annotation_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L PARENTHESIS_R
  public static boolean annotation_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_block")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARENTHESIS_L, PARENTHESIS_R);
    exit_section_(b, m, ANNOTATION_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // identifier [annotation_block]
  public static boolean annotation_one(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_one")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && annotation_one_1(b, l + 1);
    exit_section_(b, m, ANNOTATION_ONE, r);
    return r;
  }

  // [annotation_block]
  private static boolean annotation_one_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_one_1")) return false;
    annotation_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<bracket_block value ignore>>
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, VosParser::value, VosParser::ignore);
    exit_section_(b, m, ARRAY, r);
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
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, BRACE_BLOCK, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  public static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, BRACKET_BLOCK, r);
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
  // CHARACTER | esc
  static boolean char_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "char_$")) return false;
    boolean r;
    r = consumeToken(b, CHARACTER);
    if (!r) r = esc(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L (class_inner|ignore)* BRACE_R
  public static boolean class_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && class_block_1(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, CLASS_BLOCK, r);
    return r;
  }

  // (class_inner|ignore)*
  private static boolean class_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_block_1", c)) break;
    }
    return true;
  }

  // class_inner|ignore
  private static boolean class_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block_1_0")) return false;
    boolean r;
    r = class_inner(b, l + 1);
    if (!r) r = ignore(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ACCENT identifier [(COLON|EQ) value]
  public static boolean class_bound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_bound")) return false;
    if (!nextTokenIs(b, ACCENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_BOUND, null);
    r = consumeToken(b, ACCENT);
    r = r && identifier(b, l + 1);
    p = r; // pin = identifier
    r = r && class_bound_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [(COLON|EQ) value]
  private static boolean class_bound_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_bound_2")) return false;
    class_bound_2_0(b, l + 1);
    return true;
  }

  // (COLON|EQ) value
  private static boolean class_bound_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_bound_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_bound_2_0_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|EQ
  private static boolean class_bound_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_bound_2_0_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, EQ);
    return r;
  }

  /* ********************************************************** */
  // identifier [COLON type_expression] [EQ value]
  public static boolean class_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && class_field_1(b, l + 1);
    r = r && class_field_2(b, l + 1);
    exit_section_(b, m, CLASS_FIELD, r);
    return r;
  }

  // [COLON type_expression]
  private static boolean class_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_1")) return false;
    class_field_1_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean class_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [EQ value]
  private static boolean class_field_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_2")) return false;
    class_field_2_0(b, l + 1);
    return true;
  }

  // EQ value
  private static boolean class_field_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_field_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // annotation|class_field|class_bound
  static boolean class_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inner")) return false;
    boolean r;
    r = annotation(b, l + 1);
    if (!r) r = class_field(b, l + 1);
    if (!r) r = class_bound(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_CLASS modifiers identifier [COLON type_expression] class_block
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_STATEMENT, null);
    r = consumeToken(b, KW_CLASS);
    r = r && modifiers(b, l + 1);
    r = r && identifier(b, l + 1);
    p = r; // pin = identifier
    r = r && report_error_(b, class_statement_3(b, l + 1));
    r = p && class_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [COLON type_expression]
  private static boolean class_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3")) return false;
    class_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean class_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L|ANGLE_R|LEQ|GEQ|EQ
  public static boolean compare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compare")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE, "<compare>");
    r = consumeToken(b, ANGLE_L);
    if (!r) r = consumeToken(b, ANGLE_R);
    if (!r) r = consumeToken(b, LEQ);
    if (!r) r = consumeToken(b, GEQ);
    if (!r) r = consumeToken(b, EQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ESCAPE_UNICODE | ESCAPE_SPECIAL
  static boolean esc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "esc")) return false;
    if (!nextTokenIs(b, "", ESCAPE_SPECIAL, ESCAPE_UNICODE)) return false;
    boolean r;
    r = consumeToken(b, ESCAPE_UNICODE);
    if (!r) r = consumeToken(b, ESCAPE_SPECIAL);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON | COMMA
  static boolean ignore(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignore")) return false;
    if (!nextTokenIs(b, "", COMMA, SEMICOLON)) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // [SIGN] INTEGER
  public static boolean integer_signed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_signed")) return false;
    if (!nextTokenIs(b, "<integer signed>", INTEGER, SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_SIGNED, "<integer signed>");
    r = integer_signed_0(b, l + 1);
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [SIGN]
  private static boolean integer_signed_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_signed_0")) return false;
    consumeToken(b, SIGN);
    return true;
  }

  /* ********************************************************** */
  // identifier | string_literal
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
    r = identifier(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key set value
  public static boolean kv_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kv_pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KV_PAIR, "<kv pair>");
    r = key(b, l + 1);
    r = r && set(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_LET identifier [type_expression] [EQ] [value]
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, KW_LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_LET);
    r = r && identifier(b, l + 1);
    r = r && let_statement_2(b, l + 1);
    r = r && let_statement_3(b, l + 1);
    r = r && let_statement_4(b, l + 1);
    exit_section_(b, m, LET_STATEMENT, r);
    return r;
  }

  // [type_expression]
  private static boolean let_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_2")) return false;
    type_expression(b, l + 1);
    return true;
  }

  // [EQ]
  private static boolean let_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_3")) return false;
    consumeToken(b, EQ);
    return true;
  }

  // [value]
  private static boolean let_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_4")) return false;
    value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (identifier !(':'|'{'))*
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERS, "<modifiers>");
    while (true) {
      int c = current_position_(b);
      if (!modifiers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifiers", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // identifier !(':'|'{')
  private static boolean modifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && modifiers_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(':'|'{')
  private static boolean modifiers_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !modifiers_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ':'|'{'
  private static boolean modifiers_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, BRACE_L);
    return r;
  }

  /* ********************************************************** */
  // identifier (DOT identifier)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && namespace_1(b, l + 1);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  // (DOT identifier)*
  private static boolean namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_1", c)) break;
    }
    return true;
  }

  // DOT identifier
  private static boolean namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_NAMESPACE namespace
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    if (!nextTokenIs(b, KW_NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NAMESPACE);
    r = r && namespace(b, l + 1);
    exit_section_(b, m, NAMESPACE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // "null"
  public static boolean null_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULL, "<null $>");
    r = consumeToken(b, "null");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [SIGN] (INTEGER | DECIMAL) | [SIGN] BYTE
  static boolean num(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_0(b, l + 1);
    if (!r) r = num_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SIGN] (INTEGER | DECIMAL)
  private static boolean num_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_0_0(b, l + 1);
    r = r && num_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SIGN]
  private static boolean num_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_0_0")) return false;
    consumeToken(b, SIGN);
    return true;
  }

  // INTEGER | DECIMAL
  private static boolean num_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_0_1")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // [SIGN] BYTE
  private static boolean num_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_1_0(b, l + 1);
    r = r && consumeToken(b, BYTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SIGN]
  private static boolean num_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_1_0")) return false;
    consumeToken(b, SIGN);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block kv_pair ignore>>
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, VosParser::kv_pair, VosParser::ignore);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L <<param>> PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && _param.parse(b, l);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "schema"
  public static boolean schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA, "<schema>");
    r = consumeToken(b, "schema");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block properties_inner ignore>>
  static boolean schema_block(PsiBuilder b, int l) {
    return brace_block(b, l + 1, PROPERTIES_INNER_parser_, VosParser::ignore);
  }

  /* ********************************************************** */
  // schema identifier [type_expression] schema_block
  public static boolean schema_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_STATEMENT, "<schema statement>");
    r = schema(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && schema_statement_2(b, l + 1);
    r = r && schema_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [type_expression]
  private static boolean schema_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_statement_2")) return false;
    type_expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EQ | COLON
  public static boolean set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set")) return false;
    if (!nextTokenIs(b, "<set>", COLON, EQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET, "<set>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // schema_statement
  //   | namespace_statement
  //   | class_statement
  //   | union_statement
  //   | let_statement
  //   | annotation
  // //  | COMMENT_DOCUMENT
  //   | ignore
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = schema_statement(b, l + 1);
    if (!r) r = namespace_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = union_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = annotation(b, l + 1);
    if (!r) r = ignore(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING_SQ char* STRING_SQ | STRING_DQ char* STRING_DQ
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "<string literal>", STRING_DQ, STRING_SQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = string_literal_0(b, l + 1);
    if (!r) r = string_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SQ char* STRING_SQ
  private static boolean string_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_SQ);
    r = r && string_literal_0_1(b, l + 1);
    r = r && consumeToken(b, STRING_SQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // char*
  private static boolean string_literal_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!char_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_0_1", c)) break;
    }
    return true;
  }

  // STRING_DQ char* STRING_DQ
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_DQ);
    r = r && string_literal_1_1(b, l + 1);
    r = r && consumeToken(b, STRING_DQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // char*
  private static boolean string_literal_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!char_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // type_symbol [BRACKET_L type_number BRACKET_R]
  public static boolean type_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression")) return false;
    if (!nextTokenIs(b, "<type expression>", STRING, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
    r = type_symbol(b, l + 1);
    r = r && type_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [BRACKET_L type_number BRACKET_R]
  private static boolean type_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1")) return false;
    type_expression_1_0(b, l + 1);
    return true;
  }

  // BRACKET_L type_number BRACKET_R
  private static boolean type_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && type_number(b, l + 1);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_symbol [COMMA type_symbol]
  public static boolean type_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic")) return false;
    if (!nextTokenIs(b, "<type generic>", STRING, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_GENERIC, "<type generic>");
    r = type_symbol(b, l + 1);
    r = r && type_generic_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COMMA type_symbol]
  private static boolean type_generic_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_1")) return false;
    type_generic_1_0(b, l + 1);
    return true;
  }

  // COMMA type_symbol
  private static boolean type_generic_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // compare? num
  public static boolean type_generic_bound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_bound")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_GENERIC_BOUND, "<type generic bound>");
    r = type_generic_bound_0(b, l + 1);
    r = r && num(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // compare?
  private static boolean type_generic_bound_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_bound_0")) return false;
    compare(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // num compare SYMBOL compare num
  public static boolean type_generic_compare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_compare")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_GENERIC_COMPARE, "<type generic compare>");
    r = num(b, l + 1);
    r = r && compare(b, l + 1);
    r = r && consumeToken(b, SYMBOL);
    r = r && compare(b, l + 1);
    r = r && num(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // num (RANGE_LE|RANGE_EQ) num
  public static boolean type_generic_range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_range")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_GENERIC_RANGE, "<type generic range>");
    r = num(b, l + 1);
    r = r && type_generic_range_1(b, l + 1);
    r = r && num(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RANGE_LE|RANGE_EQ
  private static boolean type_generic_range_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_range_1")) return false;
    boolean r;
    r = consumeToken(b, RANGE_LE);
    if (!r) r = consumeToken(b, RANGE_EQ);
    return r;
  }

  /* ********************************************************** */
  // type_generic_bound | type_generic_compare | type_generic_range | type_generic
  public static boolean type_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_NUMBER, "<type number>");
    r = type_generic_bound(b, l + 1);
    if (!r) r = type_generic_compare(b, l + 1);
    if (!r) r = type_generic_range(b, l + 1);
    if (!r) r = type_generic(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | STRING
  public static boolean type_symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_symbol")) return false;
    if (!nextTokenIs(b, "<type symbol>", STRING, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_SYMBOL, "<type symbol>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L (union_inner|ignore)* BRACE_R
  public static boolean union_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && union_block_1(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, UNION_BLOCK, r);
    return r;
  }

  // (union_inner|ignore)*
  private static boolean union_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!union_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "union_block_1", c)) break;
    }
    return true;
  }

  // union_inner|ignore
  private static boolean union_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_block_1_0")) return false;
    boolean r;
    r = union_inner(b, l + 1);
    if (!r) r = ignore(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier [EQ integer_signed] [class_block] {
  // //    mixin = "vos.intellij.language.mixin.MixinClassField"
  // }
  public static boolean union_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_field")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && union_field_1(b, l + 1);
    r = r && union_field_2(b, l + 1);
    r = r && union_field_3(b, l + 1);
    exit_section_(b, m, UNION_FIELD, r);
    return r;
  }

  // [EQ integer_signed]
  private static boolean union_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_field_1")) return false;
    union_field_1_0(b, l + 1);
    return true;
  }

  // EQ integer_signed
  private static boolean union_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && integer_signed(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [class_block]
  private static boolean union_field_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_field_2")) return false;
    class_block(b, l + 1);
    return true;
  }

  // {
  // //    mixin = "vos.intellij.language.mixin.MixinClassField"
  // }
  private static boolean union_field_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // annotation|union_field|class_bound
  public static boolean union_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_inner")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_INNER, "<union inner>");
    r = annotation(b, l + 1);
    if (!r) r = union_field(b, l + 1);
    if (!r) r = class_bound(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_UNION modifiers identifier [COLON type_expression] union_block
  public static boolean union_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement")) return false;
    if (!nextTokenIs(b, KW_UNION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION_STATEMENT, null);
    r = consumeToken(b, KW_UNION);
    r = r && modifiers(b, l + 1);
    r = r && identifier(b, l + 1);
    p = r; // pin = identifier
    r = r && report_error_(b, union_statement_3(b, l + 1));
    r = p && union_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [COLON type_expression]
  private static boolean union_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement_3")) return false;
    union_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean union_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // URL
  public static boolean url_maybe_valid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_maybe_valid")) return false;
    if (!nextTokenIs(b, URL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, URL);
    exit_section_(b, m, URL_MAYBE_VALID, r);
    return r;
  }

  /* ********************************************************** */
  // null | boolean | num | array | object | string_literal | namespace | url_maybe_valid
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = null_$(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = num(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = namespace(b, l + 1);
    if (!r) r = url_maybe_valid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser PROPERTIES_INNER_parser_ = (b, l) -> consumeToken(b, PROPERTIES_INNER);
}
