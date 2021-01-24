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
  // "as"
  public static boolean AS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AS, "<as>");
    r = consumeToken(b, "as");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] ANGLE_R
  static boolean angle_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_L);
    r = r && angle_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, ANGLE_R);
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
  // BYTE | INTEGER | DECIMAL | namespace
  static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    boolean r;
    r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = namespace(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // COLON <<sequence ([BANG] namespace) PLUS>>
  public static boolean auto_derive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "auto_derive")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && sequence(b, l + 1, ValkyrieParser::auto_derive_1_0, PLUS_parser_);
    exit_section_(b, m, AUTO_DERIVE, r);
    return r;
  }

  // [BANG] namespace
  private static boolean auto_derive_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "auto_derive_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = auto_derive_1_0_0(b, l + 1);
    r = r && namespace(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [BANG]
  private static boolean auto_derive_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "auto_derive_1_0_0")) return false;
    consumeToken(b, BANG);
    return true;
  }

  /* ********************************************************** */
  // VERTICAL | LESS | GREATER | UNTIL
  static boolean binary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_op")) return false;
    boolean r;
    r = consumeToken(b, VERTICAL);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, UNTIL);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block (bitflag_item|macro_call) SEMICOLON>>
  public static boolean bitflag_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::bitflag_block_0_0, SEMICOLON_parser_);
    exit_section_(b, m, BITFLAG_BLOCK, r);
    return r;
  }

  // bitflag_item|macro_call
  private static boolean bitflag_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block_0_0")) return false;
    boolean r;
    r = bitflag_item(b, l + 1);
    if (!r) r = macro_call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // symbol EQ expression
  public static boolean bitflag_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_item")) return false;
    if (!nextTokenIs(b, "<bitflag item>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITFLAG_ITEM, "<bitflag item>");
    r = symbol(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L type_expression PARENTHESIS_R
  public static boolean bitflag_layout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_layout")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && type_expression(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, BITFLAG_LAYOUT, r);
    return r;
  }

  /* ********************************************************** */
  // BITFLAG modifiers [bitflag_layout] [auto_derive] bitflag_block
  public static boolean bitflag_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement")) return false;
    if (!nextTokenIs(b, BITFLAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITFLAG);
    r = r && modifiers(b, l + 1);
    r = r && bitflag_statement_2(b, l + 1);
    r = r && bitflag_statement_3(b, l + 1);
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

  // [auto_derive]
  private static boolean bitflag_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_3")) return false;
    auto_derive(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block expression SEMICOLON>>
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
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
  // CASE function_call
  public static boolean case_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && function_call(b, l + 1);
    exit_section_(b, m, CASE_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS symbol [auto_derive] block
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && symbol(b, l + 1);
    r = r && class_statement_2(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, CLASS_STATEMENT, r);
    return r;
  }

  // [auto_derive]
  private static boolean class_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2")) return false;
    auto_derive(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DEF expression block
  public static boolean def_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement")) return false;
    if (!nextTokenIs(b, DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEF);
    r = r && expression(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, DEF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE IF condition block
  public static boolean else_if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_IF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // EXPORT [<<sequence namespace COMMA>>] import_block_out
  public static boolean export_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_statement")) return false;
    if (!nextTokenIs(b, EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPORT);
    r = r && export_statement_1(b, l + 1);
    r = r && import_block_out(b, l + 1);
    exit_section_(b, m, EXPORT_STATEMENT, r);
    return r;
  }

  // [<<sequence namespace COMMA>>]
  private static boolean export_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_statement_1")) return false;
    sequence(b, l + 1, ValkyrieParser::namespace, COMMA_parser_);
    return true;
  }

  /* ********************************************************** */
  // term (binary_op term)*
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = term(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (binary_op term)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // binary_op term
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_op(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENDS namespace block
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && namespace(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, EXTENDS_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FOR pattern IN expression [if_guard] block [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expression(b, l + 1);
    r = r && for_statement_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && for_statement_6(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
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
  // namespace [<<parenthesis expression COMMA>>]
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = namespace(b, l + 1);
    r = r && function_call_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [<<parenthesis expression COMMA>>]
  private static boolean function_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_1")) return false;
    parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    return true;
  }

  /* ********************************************************** */
  // IF condition
  public static boolean if_guard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_guard")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    exit_section_(b, m, IF_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // (IF condition block) [else_if_statement* [else_statement]]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_0(b, l + 1);
    r = r && if_statement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // IF condition block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [else_if_statement* [else_statement]]
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    if_statement_1_0(b, l + 1);
    return true;
  }

  // else_if_statement* [else_statement]
  private static boolean if_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_1_0_0(b, l + 1);
    r = r && if_statement_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // else_if_statement*
  private static boolean if_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!else_if_statement(b, l + 1)) break;
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
  // (import_name import_dot)* import_block_out
  public static boolean import_block_in(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_in")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_BLOCK_IN, "<import block in>");
    r = import_block_in_0(b, l + 1);
    r = r && import_block_out(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (import_name import_dot)*
  private static boolean import_block_in_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_in_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_block_in_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_block_in_0", c)) break;
    }
    return true;
  }

  // import_name import_dot
  private static boolean import_block_in_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_in_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_name(b, l + 1);
    r = r && import_dot(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block (import_rename|import_block_in) COMMA>>
  public static boolean import_block_out(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_out")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::import_block_out_0_0, COMMA_parser_);
    exit_section_(b, m, IMPORT_BLOCK_OUT, r);
    return r;
  }

  // import_rename|import_block_in
  private static boolean import_block_out_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block_out_0_0")) return false;
    boolean r;
    r = import_rename(b, l + 1);
    if (!r) r = import_block_in(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PROPORTION|DOT
  public static boolean import_dot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_dot")) return false;
    if (!nextTokenIs(b, "<import dot>", DOT, PROPORTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DOT, "<import dot>");
    r = consumeToken(b, PROPORTION);
    if (!r) r = consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [AT|HASH] symbol
  public static boolean import_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_NAME, "<import name>");
    r = import_name_0(b, l + 1);
    r = r && symbol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [AT|HASH]
  private static boolean import_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_name_0")) return false;
    import_name_0_0(b, l + 1);
    return true;
  }

  // AT|HASH
  private static boolean import_name_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_name_0_0")) return false;
    boolean r;
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, HASH);
    return r;
  }

  /* ********************************************************** */
  // import_name (import_dot import_name)* [AS import_name]
  public static boolean import_rename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_RENAME, "<import rename>");
    r = import_name(b, l + 1);
    r = r && import_rename_1(b, l + 1);
    r = r && import_rename_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (import_dot import_name)*
  private static boolean import_rename_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_rename_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_rename_1", c)) break;
    }
    return true;
  }

  // import_dot import_name
  private static boolean import_rename_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_dot(b, l + 1);
    r = r && import_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AS import_name]
  private static boolean import_rename_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_2")) return false;
    import_rename_2_0(b, l + 1);
    return true;
  }

  // AS import_name
  private static boolean import_rename_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AS(b, l + 1);
    r = r && import_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT import_block_in | IMPORT import_rename
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_statement_0(b, l + 1);
    if (!r) r = import_statement_1(b, l + 1);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  // IMPORT import_block_in
  private static boolean import_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && import_block_in(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IMPORT import_rename
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && import_rename(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET pattern EQ expression
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, LET_STATEMENT, r);
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
  // AT namespace
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && namespace(b, l + 1);
    exit_section_(b, m, MACRO, r);
    return r;
  }

  /* ********************************************************** */
  // macro [
  //     <<parenthesis expression COMMA>>
  //   | <<brace_block pair COMMA>>
  //   | <<brace_block expression SEMICOLON>>
  // ]
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

  // [
  //     <<parenthesis expression COMMA>>
  //   | <<brace_block pair COMMA>>
  //   | <<brace_block expression SEMICOLON>>
  // ]
  private static boolean macro_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_1")) return false;
    macro_call_1_0(b, l + 1);
    return true;
  }

  // <<parenthesis expression COMMA>>
  //   | <<brace_block pair COMMA>>
  //   | <<brace_block expression SEMICOLON>>
  private static boolean macro_call_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MATCH expression block
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && expression(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // namespace*
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERS, "<modifiers>");
    while (true) {
      int c = current_position_(b);
      if (!namespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifiers", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // MODULE IDENTIFIER
  public static boolean module_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_statement")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MODULE, IDENTIFIER);
    exit_section_(b, m, MODULE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // [PROPORTION] symbol (PROPORTION symbol)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE, "<namespace>");
    r = namespace_0(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && namespace_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [PROPORTION]
  private static boolean namespace_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // (PROPORTION symbol)*
  private static boolean namespace_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_2", c)) break;
    }
    return true;
  }

  // PROPORTION symbol
  private static boolean namespace_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPORTION);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atoms COLON expression
  public static boolean pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
    r = atoms(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // [modifiers] case_pattern
  //   | [modifiers] <<parenthesis modifiers COMMA>>
  //   | [modifiers] <<bracket_block modifiers COMMA>>
  //   | <<sequence modifiers COMMA>>
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    if (!r) r = pattern_1(b, l + 1);
    if (!r) r = pattern_2(b, l + 1);
    if (!r) r = sequence(b, l + 1, ValkyrieParser::modifiers, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers] case_pattern
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_0_0(b, l + 1);
    r = r && case_pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [modifiers]
  private static boolean pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_0")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [modifiers] <<parenthesis modifiers COMMA>>
  private static boolean pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_1_0(b, l + 1);
    r = r && parenthesis(b, l + 1, ValkyrieParser::modifiers, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // [modifiers]
  private static boolean pattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_1_0")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [modifiers] <<bracket_block modifiers COMMA>>
  private static boolean pattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_2_0(b, l + 1);
    r = r && bracket_block(b, l + 1, ValkyrieParser::modifiers, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // [modifiers]
  private static boolean pattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_2_0")) return false;
    modifiers(b, l + 1);
    return true;
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
  // module_statement
  //   | import_statement
  //   | export_statement
  //   | if_statement
  //   | for_statement
  //   | while_statement
  //   | match_statement
  //   | let_statement
  //   | def_statement
  //   | type_statement
  //   | class_statement
  //   | trait_statement
  //   | variant_statement
  //   | bitflag_statement
  //   | extends_statement
  //   | SEMICOLON
  static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    r = module_statement(b, l + 1);
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = export_statement(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = def_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = trait_statement(b, l + 1);
    if (!r) r = variant_statement(b, l + 1);
    if (!r) r = bitflag_statement(b, l + 1);
    if (!r) r = extends_statement(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL_XID | SYMBOL_RAW
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    if (!nextTokenIs(b, "<symbol>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYMBOL, "<symbol>");
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // function_call | list | tuple | atoms
  static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    r = function_call(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = atoms(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TRAIT symbol block
  public static boolean trait_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement")) return false;
    if (!nextTokenIs(b, TRAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRAIT);
    r = r && symbol(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, TRAIT_STATEMENT, r);
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
  // list | tuple | atoms
  static boolean type_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = atoms(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TYPE symbol EQ block
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && block(b, l + 1);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (statements [SEMICOLON])*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!valkyrie_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

  // statements [SEMICOLON]
  private static boolean valkyrie_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements(b, l + 1);
    r = r && valkyrie_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SEMICOLON]
  private static boolean valkyrie_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // VARIANT expression block
  public static boolean variant_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_statement")) return false;
    if (!nextTokenIs(b, VARIANT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIANT);
    r = r && expression(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, VARIANT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression block
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser PLUS_parser_ = (b, l) -> consumeToken(b, PLUS);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
