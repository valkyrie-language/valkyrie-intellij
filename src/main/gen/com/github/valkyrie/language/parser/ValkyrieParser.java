// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import static com.github.valkyrie.language.psi.ValkyrieParserExtension.*;
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
  // range | list | object | tuple | number | string | boolean | namepath
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = range(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = namepath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block (bitflag_item | macro_call) SEMICOLON>>
  public static boolean bitflag_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::bitflag_block_0_0, SEMICOLON_parser_);
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
  // PARENTHESIS_L expression PARENTHESIS_R
  public static boolean bitflag_layout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_layout")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, BITFLAG_LAYOUT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_BITFLAG maybe_modifier [bitflag_layout] bitflag_block
  public static boolean bitflag_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement")) return false;
    if (!nextTokenIs(b, KW_BITFLAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_BITFLAG);
    r = r && maybe_modifier(b, l + 1);
    r = r && bitflag_statement_2(b, l + 1);
    r = r && bitflag_block(b, l + 1);
    exit_section_(b, m, BITFLAG_STATEMENT, r);
    return r;
  }

  // [bitflag_layout]
  private static boolean bitflag_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_2")) return false;
    bitflag_layout(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block expression SEMICOLON>>
  static boolean block(PsiBuilder b, int l) {
    return brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
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
  // CASE [identifier* [namepath]] pattern
  public static boolean case_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && case_pattern_1(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, CASE_PATTERN, r);
    return r;
  }

  // [identifier* [namepath]]
  private static boolean case_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1")) return false;
    case_pattern_1_0(b, l + 1);
    return true;
  }

  // identifier* [namepath]
  private static boolean case_pattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern_1_0_0(b, l + 1);
    r = r && case_pattern_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean case_pattern_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_pattern_1_0_0", c)) break;
    }
    return true;
  }

  // [namepath]
  private static boolean case_pattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_1")) return false;
    namepath(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_free (macro_call|class_define|class_item) (COMMA|SEMICOLON)>>
  public static boolean class_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, ValkyrieParser::class_block_0_0, ValkyrieParser::class_block_0_1);
    exit_section_(b, m, CLASS_BLOCK, r);
    return r;
  }

  // macro_call|class_define|class_item
  private static boolean class_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block_0_0")) return false;
    boolean r;
    r = macro_call(b, l + 1);
    if (!r) r = class_define(b, l + 1);
    if (!r) r = class_item(b, l + 1);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean class_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // KW_DEF? [maybe_modifier] identifier define_tuple [(COLON|OP_ARROW) expression] [define_block]
  public static boolean class_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEFINE, "<class define>");
    r = class_define_0(b, l + 1);
    r = r && class_define_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && define_tuple(b, l + 1);
    r = r && class_define_4(b, l + 1);
    r = r && class_define_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_DEF?
  private static boolean class_define_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_0")) return false;
    consumeToken(b, KW_DEF);
    return true;
  }

  // [maybe_modifier]
  private static boolean class_define_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [(COLON|OP_ARROW) expression]
  private static boolean class_define_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_4")) return false;
    class_define_4_0(b, l + 1);
    return true;
  }

  // (COLON|OP_ARROW) expression
  private static boolean class_define_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_define_4_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|OP_ARROW
  private static boolean class_define_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_4_0_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_ARROW);
    return r;
  }

  // [define_block]
  private static boolean class_define_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_define_5")) return false;
    define_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON identifier [type_generic] (OP_ADD identifier)*
  public static boolean class_inherit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && identifier(b, l + 1);
    r = r && class_inherit_2(b, l + 1);
    r = r && class_inherit_3(b, l + 1);
    exit_section_(b, m, CLASS_INHERIT, r);
    return r;
  }

  // [type_generic]
  private static boolean class_inherit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_2")) return false;
    type_generic(b, l + 1);
    return true;
  }

  // (OP_ADD identifier)*
  private static boolean class_inherit_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_inherit_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_inherit_3", c)) break;
    }
    return true;
  }

  // OP_ADD identifier
  private static boolean class_inherit_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ADD);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LET? [maybe_modifier] object_key [COLON expression] [OP_SET expression] {
  // }
  public static boolean class_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_ITEM, "<class item>");
    r = class_item_0(b, l + 1);
    r = r && class_item_1(b, l + 1);
    r = r && object_key(b, l + 1);
    r = r && class_item_3(b, l + 1);
    r = r && class_item_4(b, l + 1);
    r = r && class_item_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_LET?
  private static boolean class_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_0")) return false;
    consumeToken(b, KW_LET);
    return true;
  }

  // [maybe_modifier]
  private static boolean class_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [COLON expression]
  private static boolean class_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_3")) return false;
    class_item_3_0(b, l + 1);
    return true;
  }

  // COLON expression
  private static boolean class_item_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_SET expression]
  private static boolean class_item_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_4")) return false;
    class_item_4_0(b, l + 1);
    return true;
  }

  // OP_SET expression
  private static boolean class_item_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_item_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean class_item_5(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // KW_CLASS [maybe_modifier] identifier [generic_define] [class_inherit] [class_tuple|class_block]
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CLASS);
    r = r && class_statement_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && class_statement_3(b, l + 1);
    r = r && class_statement_4(b, l + 1);
    r = r && class_statement_5(b, l + 1);
    exit_section_(b, m, CLASS_STATEMENT, r);
    return r;
  }

  // [maybe_modifier]
  private static boolean class_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [generic_define]
  private static boolean class_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [class_inherit]
  private static boolean class_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_4")) return false;
    class_inherit(b, l + 1);
    return true;
  }

  // [class_tuple|class_block]
  private static boolean class_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_5")) return false;
    class_statement_5_0(b, l + 1);
    return true;
  }

  // class_tuple|class_block
  private static boolean class_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_5_0")) return false;
    boolean r;
    r = class_tuple(b, l + 1);
    if (!r) r = class_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis (macro_call|class_item) COMMA>>
  public static boolean class_tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::class_tuple_0_0, COMMA_parser_);
    exit_section_(b, m, CLASS_TUPLE, r);
    return r;
  }

  // macro_call|class_item
  private static boolean class_tuple_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple_0_0")) return false;
    boolean r;
    r = macro_call(b, l + 1);
    if (!r) r = class_item(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // case_pattern OP_SET expression | expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // case_pattern OP_SET expression
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block normal_statements SEMICOLON>>
  public static boolean define_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, DEFINE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // OP_POW | OP_LT | OP_GT
  //     | macro_call* [maybe_modifier] [DOT2|DOT3] identifier [COLON expression] [OP_EQ expression]
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

  // macro_call* [maybe_modifier] [DOT2|DOT3] identifier [COLON expression] [OP_EQ expression]
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

  // [maybe_modifier]
  private static boolean define_item_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [DOT2|DOT3]
  private static boolean define_item_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_2")) return false;
    define_item_3_2_0(b, l + 1);
    return true;
  }

  // DOT2|DOT3
  private static boolean define_item_3_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_2_0")) return false;
    boolean r;
    r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT3);
    return r;
  }

  // [COLON expression]
  private static boolean define_item_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4")) return false;
    define_item_3_4_0(b, l + 1);
    return true;
  }

  // COLON expression
  private static boolean define_item_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_EQ expression]
  private static boolean define_item_3_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5")) return false;
    define_item_3_5_0(b, l + 1);
    return true;
  }

  // OP_EQ expression
  private static boolean define_item_3_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DEF [maybe_modifier] namepath_free [generic_define] define_tuple [(COLON|OP_ARROW) expression] [define_block]
  public static boolean define_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement")) return false;
    if (!nextTokenIs(b, KW_DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DEF);
    r = r && define_statement_1(b, l + 1);
    r = r && namepath_free(b, l + 1);
    r = r && define_statement_3(b, l + 1);
    r = r && define_tuple(b, l + 1);
    r = r && define_statement_5(b, l + 1);
    r = r && define_statement_6(b, l + 1);
    exit_section_(b, m, DEFINE_STATEMENT, r);
    return r;
  }

  // [maybe_modifier]
  private static boolean define_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [generic_define]
  private static boolean define_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_3")) return false;
    generic_define(b, l + 1);
    return true;
  }

  // [(COLON|OP_ARROW) expression]
  private static boolean define_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5")) return false;
    define_statement_5_0(b, l + 1);
    return true;
  }

  // (COLON|OP_ARROW) expression
  private static boolean define_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = define_statement_5_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|OP_ARROW
  private static boolean define_statement_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5_0_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_ARROW);
    return r;
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
  // kw_else_if condition block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EF_STATEMENT, "<ef statement>");
    r = kw_else_if(b, l + 1);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "else" block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, "<else statement>");
    r = consumeToken(b, "else");
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON|OP_PROPORTION|SEMICOLON|
  //     BRACKET_L|BRACKET_R|PARENTHESIS_L|PARENTHESIS_R|BRACE_L|BRACE_R
  //     COMMA|OP_EQ|DOT|COMMA
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
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, COMMA);
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
  // KW_EXTENDS [type_generic] [maybe_modifier] identifier [type_generic] [COLON expression] class_block
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, KW_EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_EXTENDS);
    r = r && extends_statement_1(b, l + 1);
    r = r && extends_statement_2(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && extends_statement_4(b, l + 1);
    r = r && extends_statement_5(b, l + 1);
    r = r && class_block(b, l + 1);
    exit_section_(b, m, EXTENDS_STATEMENT, r);
    return r;
  }

  // [type_generic]
  private static boolean extends_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_1")) return false;
    type_generic(b, l + 1);
    return true;
  }

  // [maybe_modifier]
  private static boolean extends_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [type_generic]
  private static boolean extends_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_4")) return false;
    type_generic(b, l + 1);
    return true;
  }

  // [COLON expression]
  private static boolean extends_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_5")) return false;
    extends_statement_5_0(b, l + 1);
    return true;
  }

  // COLON expression
  private static boolean extends_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expression(b, l + 1);
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
  // KW_FOR (case_pattern|normal_pattern) KW_IF expression [if_guard] block [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FOR);
    r = r && for_statement_1(b, l + 1);
    r = r && consumeToken(b, KW_IF);
    r = r && expression(b, l + 1);
    r = r && for_statement_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && for_statement_6(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // case_pattern|normal_pattern
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    boolean r;
    r = case_pattern(b, l + 1);
    if (!r) r = normal_pattern(b, l + 1);
    return r;
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
  // <<brace_block (expression COLON expression) (COMMA|SEMICOLON)>>
  public static boolean forall_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::forall_block_0_0, ValkyrieParser::forall_block_0_1);
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

  // COMMA|SEMICOLON
  private static boolean forall_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // FORALL <<sequence identifier COMMA>> [forall_block]
  public static boolean forall_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_statement")) return false;
    if (!nextTokenIs(b, FORALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORALL);
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
  // <<bracket_block ([identifier COLON] expression) COMMA>>
  //   | OP_PROPORTION <<angle_block ([identifier COLON] expression) COMMA>>
  public static boolean generic_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call")) return false;
    if (!nextTokenIs(b, "<generic call>", BRACKET_L, OP_PROPORTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_CALL, "<generic call>");
    r = bracket_block(b, l + 1, ValkyrieParser::generic_call_0_0, COMMA_parser_);
    if (!r) r = generic_call_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier COLON] expression
  private static boolean generic_call_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_call_0_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean generic_call_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_0_0_0")) return false;
    generic_call_0_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean generic_call_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_PROPORTION <<angle_block ([identifier COLON] expression) COMMA>>
  private static boolean generic_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PROPORTION);
    r = r && angle_block(b, l + 1, ValkyrieParser::generic_call_1_1_0, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON] expression
  private static boolean generic_call_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_call_1_1_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean generic_call_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_1_1_0_0")) return false;
    generic_call_1_1_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean generic_call_1_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_call_1_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block ([identifier COLON] expression) COMMA>>
  //   | OP_PROPORTION? <<angle_block ([identifier COLON] expression) COMMA>>
  public static boolean generic_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_DEFINE, "<generic define>");
    r = bracket_block(b, l + 1, ValkyrieParser::generic_define_0_0, COMMA_parser_);
    if (!r) r = generic_define_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier COLON] expression
  private static boolean generic_define_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_define_0_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean generic_define_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_0_0_0")) return false;
    generic_define_0_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean generic_define_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_PROPORTION? <<angle_block ([identifier COLON] expression) COMMA>>
  private static boolean generic_define_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_define_1_0(b, l + 1);
    r = r && angle_block(b, l + 1, ValkyrieParser::generic_define_1_1_0, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_PROPORTION?
  private static boolean generic_define_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_1_0")) return false;
    consumeToken(b, OP_PROPORTION);
    return true;
  }

  // [identifier COLON] expression
  private static boolean generic_define_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_define_1_1_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean generic_define_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_1_1_0_0")) return false;
    generic_define_1_1_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean generic_define_1_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_define_1_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL_XID | SYMBOL_RAW | KW_NAMESPACE | KW_CLASS
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    if (!r) r = consumeToken(b, KW_NAMESPACE);
    if (!r) r = consumeToken(b, KW_CLASS);
    exit_section_(b, l, m, r, false, null);
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
  // (KW_IF condition block) [ef_statement* [else_statement]]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_0(b, l + 1);
    r = r && if_statement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // KW_IF condition block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ef_statement* [else_statement]]
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    if_statement_1_0(b, l + 1);
    return true;
  }

  // ef_statement* [else_statement]
  private static boolean if_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_1_0_0(b, l + 1);
    r = r && if_statement_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ef_statement*
  private static boolean if_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ef_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_1_0_0", c)) break;
    }
    return true;
  }

  // [else_statement]
  private static boolean if_statement_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_1")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block import_item COMMA>>
  public static boolean import_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::import_item, COMMA_parser_);
    exit_section_(b, m, IMPORT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // namepath_free [OP_AS identifier|(DOT|OP_PROPORTION) import_block]
  public static boolean import_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ITEM, "<import item>");
    r = namepath_free(b, l + 1);
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
  // "else" KW_IF | "ef"
  public static boolean kw_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_ELSE_IF, "<kw else if>");
    r = kw_else_if_0(b, l + 1);
    if (!r) r = consumeToken(b, "ef");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "else" KW_IF
  private static boolean kw_else_if_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && consumeToken(b, KW_IF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LET normal_pattern [let_type_hint] [OP_SET normal_statements]
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

  // KW_LET normal_pattern [let_type_hint] [OP_SET normal_statements]
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

  // [let_type_hint]
  private static boolean let_statement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_2")) return false;
    let_type_hint(b, l + 1);
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
  // COLON <<sequence expression COMMA>>
  public static boolean let_type_hint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_type_hint")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && sequence(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, LET_TYPE_HINT, r);
    return r;
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
  // AT namepath_free
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && namepath_free(b, l + 1);
    exit_section_(b, m, MACRO, r);
    return r;
  }

  /* ********************************************************** */
  // macro [macro_item]
  public static boolean macro_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro(b, l + 1);
    r = r && macro_call_1(b, l + 1);
    exit_section_(b, m, MACRO_CALL, r);
    return r;
  }

  // [macro_item]
  private static boolean macro_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_1")) return false;
    macro_item(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  //   | <<brace_block object_pair COMMA>>
  //   | <<brace_block expression SEMICOLON>>
  public static boolean macro_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_item")) return false;
    if (!nextTokenIs(b, "<macro item>", BRACE_L, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_ITEM, "<macro item>");
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::object_pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [AT|HASH] <<bracket_block (namepath macro_item) COMMA>>
  public static boolean macro_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_LIST, "<macro list>");
    r = macro_list_0(b, l + 1);
    r = r && bracket_block(b, l + 1, ValkyrieParser::macro_list_1_0, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [AT|HASH]
  private static boolean macro_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_0")) return false;
    macro_list_0_0(b, l + 1);
    return true;
  }

  // AT|HASH
  private static boolean macro_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_0_0")) return false;
    boolean r;
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, HASH);
    return r;
  }

  // namepath macro_item
  private static boolean macro_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath(b, l + 1);
    r = r && macro_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block match_expression SEMICOLON>>
  public static boolean match_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::match_expression, SEMICOLON_parser_);
    exit_section_(b, m, MATCH_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // case_pattern COLON (normal_statements [SEMICOLON])+
  public static boolean match_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && match_expression_2(b, l + 1);
    exit_section_(b, m, MATCH_EXPRESSION, r);
    return r;
  }

  // (normal_statements [SEMICOLON])+
  private static boolean match_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_expression_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expression_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // normal_statements [SEMICOLON]
  private static boolean match_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_statements(b, l + 1);
    r = r && match_expression_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SEMICOLON]
  private static boolean match_expression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // MATCH identifier* match_block
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && match_statement_1(b, l + 1);
    r = r && match_block(b, l + 1);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  // identifier*
  private static boolean match_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_statement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (identifier !end_m1)+
  public static boolean maybe_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "maybe_modifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAYBE_MODIFIER, "<maybe modifier>");
    r = maybe_modifier_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!maybe_modifier_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "maybe_modifier", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier !end_m1
  private static boolean maybe_modifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "maybe_modifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && maybe_modifier_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !end_m1
  private static boolean maybe_modifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "maybe_modifier_0_1")) return false;
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
  // KW_NEW [maybe_modifier] [identifier type_generic] class_block
  public static boolean new_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement")) return false;
    if (!nextTokenIs(b, KW_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NEW);
    r = r && new_statement_1(b, l + 1);
    r = r && new_statement_2(b, l + 1);
    r = r && class_block(b, l + 1);
    exit_section_(b, m, NEW_STATEMENT, r);
    return r;
  }

  // [maybe_modifier]
  private static boolean new_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [identifier type_generic]
  private static boolean new_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2")) return false;
    new_statement_2_0(b, l + 1);
    return true;
  }

  // identifier type_generic
  private static boolean new_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && type_generic(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [maybe_modifier] pattern | <<sequence pattern_item COMMA>>
  public static boolean normal_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NORMAL_PATTERN, "<normal pattern>");
    r = normal_pattern_0(b, l + 1);
    if (!r) r = sequence(b, l + 1, ValkyrieParser::pattern_item, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [maybe_modifier] pattern
  private static boolean normal_pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_pattern_0_0(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [maybe_modifier]
  private static boolean normal_pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_0")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // if_statement
  //   | for_statement
  //   | while_statement
  //   | match_statement
  //   | let_statement
  //   | new_statement
  //   | type_statement
  //   | forall_statement
  //   | macro_call
  //   | expression
  static boolean normal_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_statements")) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = new_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = forall_statement(b, l + 1);
    if (!r) r = macro_call(b, l + 1);
    if (!r) r = expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BYTE | INTEGER | DECIMAL) [identifier]
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

  // [identifier]
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    identifier(b, l + 1);
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
  //     | OP_GT | OP_LT | DOT_LESS | DOT_EQ | DOT2 | DOT
  //     | OP_TO
  //     | OP_AND_THEN | OP_OR_ELSE
  //     // is | is not
  //     | OP_NOT_A | OP_IS_A OP_NOT | OP_IS_A | OP_NOT OP_IS_A
  //     | OP_AS
  //     // in | not in
  //     | OP_IN | OP_NOT_IN | OP_NOT OP_IN
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
    if (!r) r = consumeToken(b, DOT_LESS);
    if (!r) r = consumeToken(b, DOT_EQ);
    if (!r) r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_TO);
    if (!r) r = consumeToken(b, OP_AND_THEN);
    if (!r) r = consumeToken(b, OP_OR_ELSE);
    if (!r) r = consumeToken(b, OP_NOT_A);
    if (!r) r = parseTokens(b, 0, OP_IS_A, OP_NOT);
    if (!r) r = consumeToken(b, OP_IS_A);
    if (!r) r = parseTokens(b, 0, OP_NOT, OP_IS_A);
    if (!r) r = consumeToken(b, OP_AS);
    if (!r) r = consumeToken(b, OP_IN);
    if (!r) r = consumeToken(b, OP_NOT_IN);
    if (!r) r = parseTokens(b, 0, OP_NOT, OP_IN);
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
  // BANG | QUESTION
  static boolean op_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_suffix")) return false;
    if (!nextTokenIs(b, "", BANG, QUESTION)) return false;
    boolean r;
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, QUESTION);
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
  // <<parenthesis   pattern_pair COMMA>>
  //   | <<bracket_block pattern_pair COMMA>>
  //   | <<brace_block   pattern_pair COMMA>>
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    if (!r) r = bracket_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_ITEM, "<pattern item>");
    r = pattern_item_0(b, l + 1);
    if (!r) r = pattern_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_item_0_0(b, l + 1);
    r = r && pattern_item_0_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_0_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
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
  // identifier | pattern
  public static boolean pattern_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_VALUE, "<pattern value>");
    r = identifier(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // <<brace_block tagged_item (COMMA|SEMICOLON)>>
  public static boolean tagged_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::tagged_item, ValkyrieParser::tagged_block_0_1);
    exit_section_(b, m, TAGGED_BLOCK, r);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean tagged_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // identifier [class_block]
  public static boolean tagged_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAGGED_ITEM, "<tagged item>");
    r = identifier(b, l + 1);
    r = r && tagged_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [class_block]
  private static boolean tagged_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_item_1")) return false;
    class_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_TAGGED maybe_modifier [[OP_PROPORTION] type_generic] tagged_block
  public static boolean tagged_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement")) return false;
    if (!nextTokenIs(b, KW_TAGGED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TAGGED);
    r = r && maybe_modifier(b, l + 1);
    r = r && tagged_statement_2(b, l + 1);
    r = r && tagged_block(b, l + 1);
    exit_section_(b, m, TAGGED_STATEMENT, r);
    return r;
  }

  // [[OP_PROPORTION] type_generic]
  private static boolean tagged_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2")) return false;
    tagged_statement_2_0(b, l + 1);
    return true;
  }

  // [OP_PROPORTION] type_generic
  private static boolean tagged_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tagged_statement_2_0_0(b, l + 1);
    r = r && type_generic(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_PROPORTION]
  private static boolean tagged_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0_0")) return false;
    consumeToken(b, OP_PROPORTION);
    return true;
  }

  /* ********************************************************** */
  // op_prefix* atom (op_suffix|call_suffix|type_generic|slice)*
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

  // (op_suffix|call_suffix|type_generic|slice)*
  private static boolean term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|type_generic|slice
  private static boolean term_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = type_generic(b, l + 1);
    if (!r) r = slice(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block top_statements SEMICOLON>>
  public static boolean top_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::top_statements, SEMICOLON_parser_);
    exit_section_(b, m, TOP_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_statement
  //   | import_statement
  //   | extension_statement
  //   | class_statement
  //   | trait_statement
  //   | tagged_statement
  //   | bitflag_statement
  //   | extends_statement
  //   | define_statement
  static boolean top_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statements")) return false;
    boolean r;
    r = namespace_statement(b, l + 1);
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = extension_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = trait_statement(b, l + 1);
    if (!r) r = tagged_statement(b, l + 1);
    if (!r) r = bitflag_statement(b, l + 1);
    if (!r) r = extends_statement(b, l + 1);
    if (!r) r = define_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_TRAIT [maybe_modifier] identifier [type_generic] [COLON expression] class_block
  public static boolean trait_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement")) return false;
    if (!nextTokenIs(b, KW_TRAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TRAIT);
    r = r && trait_statement_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && trait_statement_3(b, l + 1);
    r = r && trait_statement_4(b, l + 1);
    r = r && class_block(b, l + 1);
    exit_section_(b, m, TRAIT_STATEMENT, r);
    return r;
  }

  // [maybe_modifier]
  private static boolean trait_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_1")) return false;
    maybe_modifier(b, l + 1);
    return true;
  }

  // [type_generic]
  private static boolean trait_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_3")) return false;
    type_generic(b, l + 1);
    return true;
  }

  // [COLON expression]
  private static boolean trait_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_4")) return false;
    trait_statement_4_0(b, l + 1);
    return true;
  }

  // COLON expression
  private static boolean trait_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // <<bracket_block ([identifier COLON] expression) COMMA>>
  public static boolean type_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::type_generic_0_0, COMMA_parser_);
    exit_section_(b, m, TYPE_GENERIC, r);
    return r;
  }

  // [identifier COLON] expression
  private static boolean type_generic_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_generic_0_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean type_generic_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0_0")) return false;
    type_generic_0_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean type_generic_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_TYPE identifier [[OP_PROPORTION] type_generic] [OP_SET term]
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, KW_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TYPE);
    r = r && identifier(b, l + 1);
    r = r && type_statement_2(b, l + 1);
    r = r && type_statement_3(b, l + 1);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

  // [[OP_PROPORTION] type_generic]
  private static boolean type_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2")) return false;
    type_statement_2_0(b, l + 1);
    return true;
  }

  // [OP_PROPORTION] type_generic
  private static boolean type_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_statement_2_0_0(b, l + 1);
    r = r && type_generic(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_PROPORTION]
  private static boolean type_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0_0")) return false;
    consumeToken(b, OP_PROPORTION);
    return true;
  }

  // [OP_SET term]
  private static boolean type_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_3")) return false;
    type_statement_3_0(b, l + 1);
    return true;
  }

  // OP_SET term
  private static boolean type_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((top_statements|normal_statements) [SEMICOLON])*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!valkyrie_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

  // (top_statements|normal_statements) [SEMICOLON]
  private static boolean valkyrie_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = valkyrie_0_0(b, l + 1);
    r = r && valkyrie_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // top_statements|normal_statements
  private static boolean valkyrie_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_0")) return false;
    boolean r;
    r = top_statements(b, l + 1);
    if (!r) r = normal_statements(b, l + 1);
    return r;
  }

  // [SEMICOLON]
  private static boolean valkyrie_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // WHILE condition block
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
