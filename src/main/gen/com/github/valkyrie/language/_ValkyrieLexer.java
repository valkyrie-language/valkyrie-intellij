/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Valkyrie.flex</tt>
 */
public class _ValkyrieLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int StringQuote = 2;
  public static final int Bitflag = 4;
  public static final int TextContextSpace = 6;
  public static final int CodeContext = 8;
  public static final int SelectionStart = 10;
  public static final int SelectionText = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  3,  3,  3, 3
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 17136 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\1\21\4\22\1\23\1\22\1\24\1\22\14\25\1\26\50\25\1\27\2\25\1\30\1\31\1\32"+
    "\1\33\25\25\1\34\20\22\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
    "\47\1\22\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\22\1\25\1\57\1\60\5\22\2\25"+
    "\1\61\7\22\1\25\1\62\20\22\1\25\1\63\1\22\1\64\13\25\1\65\1\25\1\66\22\22"+
    "\1\67\5\22\1\70\11\22\1\71\1\72\1\73\1\74\1\22\1\75\2\22\1\76\3\22\1\77\2"+
    "\22\1\100\10\22\123\25\1\101\7\25\1\102\1\103\12\25\1\104\24\22\1\25\1\105"+
    "\u0582\22\1\106\u017f\22");

  /* The ZZ_CMAP_Y table has 4544 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\2\0\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\3"+
    "\0\1\17\1\20\1\21\1\20\2\22\1\23\3\22\1\23\71\22\1\24\1\22\1\25\1\0\1\26\1"+
    "\27\2\0\16\30\1\31\1\32\1\33\1\34\2\22\1\35\11\22\1\36\21\22\1\37\1\40\24"+
    "\22\1\41\3\22\1\23\1\42\1\41\4\22\1\0\1\43\4\30\1\44\1\45\1\0\3\22\2\46\3"+
    "\0\1\30\1\47\5\22\1\50\3\30\1\51\1\52\13\22\1\53\1\54\1\55\1\56\1\30\1\57"+
    "\2\0\1\60\3\22\3\30\1\61\12\22\1\62\1\30\1\63\1\0\1\30\1\64\3\22\1\50\1\65"+
    "\1\20\2\22\1\62\1\66\1\67\1\70\2\0\3\22\1\71\10\0\2\22\1\31\1\72\2\0\1\73"+
    "\1\30\1\74\3\30\1\75\6\22\1\76\2\30\1\77\1\22\1\100\1\30\1\41\1\22\1\101\1"+
    "\102\1\103\2\22\1\104\1\105\1\106\1\54\1\107\1\110\1\111\1\100\1\30\1\25\1"+
    "\0\1\112\1\113\1\103\2\22\1\104\1\114\1\115\1\116\1\117\1\120\1\121\1\122"+
    "\1\30\1\123\1\0\1\112\1\36\1\35\2\22\1\104\1\124\1\106\1\44\1\125\1\126\1"+
    "\0\1\100\1\30\1\0\1\42\1\112\1\102\1\103\2\22\1\104\1\124\1\106\1\54\1\117"+
    "\1\122\1\111\1\100\1\30\1\42\1\0\1\127\1\130\1\131\1\132\1\133\1\130\1\22"+
    "\1\134\1\135\1\136\1\137\1\0\1\122\1\30\2\0\1\140\1\31\1\104\2\22\1\104\1"+
    "\22\1\141\1\142\1\136\1\143\1\46\1\100\1\30\2\0\1\101\1\31\1\104\2\22\1\104"+
    "\1\144\1\106\1\142\1\136\1\143\1\145\1\100\1\30\1\146\1\0\1\112\1\31\1\104"+
    "\4\22\1\147\1\142\1\150\1\151\1\152\1\100\1\30\1\0\1\40\1\153\1\22\1\23\1"+
    "\40\2\22\1\35\1\154\1\23\1\155\1\156\1\30\1\122\1\30\1\157\1\0\1\41\5\22\1"+
    "\160\1\47\1\161\1\162\1\30\1\163\4\0\1\164\1\165\1\166\1\41\1\167\1\170\1"+
    "\160\1\171\1\172\1\173\1\30\1\174\4\0\1\126\2\0\1\163\1\30\1\163\1\175\1\176"+
    "\1\22\1\41\3\22\1\26\1\43\1\30\1\142\1\177\1\30\1\43\3\30\1\200\1\201\7\0"+
    "\5\22\1\50\1\30\1\202\1\30\1\163\1\62\1\203\1\204\1\205\1\206\1\22\1\207\1"+
    "\210\1\30\1\173\4\22\1\36\1\211\5\22\1\212\51\22\1\131\1\23\1\131\5\22\1\131"+
    "\4\22\1\131\1\23\1\131\1\22\1\23\7\22\1\131\10\22\1\213\1\0\1\43\1\163\1\0"+
    "\2\22\2\0\12\22\2\72\1\41\114\22\1\102\2\22\1\214\2\22\1\46\11\22\1\130\1"+
    "\22\1\126\1\22\1\31\1\215\1\0\2\22\1\215\1\0\2\22\1\216\1\0\1\22\1\31\1\217"+
    "\1\0\6\22\1\220\3\30\1\221\1\222\1\30\1\163\3\0\1\223\1\30\1\163\13\22\1\0"+
    "\5\22\1\224\10\22\1\72\1\0\3\22\1\23\1\30\1\225\1\30\1\225\1\122\1\30\3\22"+
    "\1\72\1\26\1\0\5\22\1\226\3\22\1\25\1\30\1\47\4\0\2\22\1\161\1\225\6\22\1"+
    "\177\1\162\3\30\1\54\1\30\1\163\1\30\1\163\1\152\1\0\1\30\1\173\10\0\1\227"+
    "\5\22\1\220\1\30\1\227\1\226\1\30\1\163\1\0\1\230\1\225\1\0\1\231\3\22\1\77"+
    "\1\205\1\30\1\64\4\22\1\62\1\30\1\225\1\0\4\22\1\220\2\30\1\0\1\30\1\232\1"+
    "\30\1\64\3\22\1\72\1\22\1\126\10\0\1\233\2\30\1\234\1\235\1\163\30\22\6\30"+
    "\1\173\1\230\42\22\2\72\4\22\2\72\1\22\1\236\3\22\1\72\6\22\1\31\1\172\1\237"+
    "\1\26\1\240\1\226\1\22\1\26\1\237\1\26\1\241\1\242\3\0\1\243\1\0\1\110\1\244"+
    "\1\0\1\245\1\246\2\0\1\42\1\152\2\0\1\22\1\26\6\0\1\30\1\200\1\247\1\30\1"+
    "\244\1\0\1\250\1\40\1\154\1\72\1\27\1\104\1\22\1\251\1\252\1\253\2\0\5\22"+
    "\1\126\24\0\1\254\6\0\1\255\162\0\5\22\1\23\5\22\1\23\20\22\1\26\1\256\1\257"+
    "\1\0\4\22\1\36\1\211\7\22\1\152\1\0\1\110\2\22\1\23\1\0\10\23\4\30\1\260\3"+
    "\0\1\41\1\207\1\261\1\26\1\41\11\22\1\23\1\262\1\41\12\22\1\212\1\252\4\22"+
    "\1\72\1\41\12\22\1\23\2\0\3\22\1\46\6\0\170\22\1\72\11\0\72\22\1\72\5\0\21"+
    "\22\1\26\10\0\5\22\1\72\41\22\1\26\2\22\1\30\1\257\2\0\5\22\1\161\1\73\1\263"+
    "\3\22\1\62\12\22\1\163\3\0\1\152\1\22\1\40\14\22\1\103\3\22\1\23\1\22\7\0"+
    "\1\152\1\22\1\264\1\265\2\22\1\50\3\0\6\22\1\226\1\0\1\64\5\22\1\220\1\30"+
    "\1\173\1\0\1\30\1\163\2\30\1\64\1\266\1\30\1\64\2\22\1\62\1\173\2\22\1\161"+
    "\1\30\1\225\1\0\3\22\1\26\1\75\5\22\1\50\1\30\1\244\1\152\1\30\1\163\1\267"+
    "\1\22\1\30\1\270\5\22\1\77\1\162\1\0\1\265\1\271\1\30\1\163\2\22\1\23\1\272"+
    "\6\22\1\204\1\273\1\224\2\0\1\274\1\22\1\50\1\275\1\0\3\276\1\0\2\23\5\22"+
    "\1\212\1\72\1\0\16\22\1\50\1\277\1\30\1\163\64\22\1\226\1\0\2\22\1\23\1\300"+
    "\5\22\1\226\40\0\55\22\1\72\15\22\1\25\4\0\1\23\1\0\1\300\1\301\1\22\1\104"+
    "\1\23\1\172\1\302\15\22\1\25\3\0\1\300\20\22\1\72\1\166\32\22\1\72\2\0\10"+
    "\22\1\40\6\22\5\0\1\22\1\25\2\30\2\0\2\30\1\303\2\0\1\304\4\0\1\305\1\236"+
    "\17\22\1\26\2\0\1\30\1\163\1\41\2\22\1\306\1\41\2\22\1\46\1\307\6\22\1\62"+
    "\3\22\1\23\3\40\1\310\4\0\1\22\1\144\2\22\1\23\2\22\1\311\1\22\1\72\1\22\1"+
    "\72\4\0\17\22\1\46\10\0\6\22\1\26\20\0\1\312\20\0\3\22\1\26\6\22\1\126\1\0"+
    "\1\244\3\0\4\22\2\0\3\22\1\46\4\22\1\62\1\47\3\22\1\72\4\22\1\226\1\22\1\261"+
    "\5\0\23\22\1\72\1\30\1\163\4\22\1\226\4\22\1\226\5\22\1\0\6\22\1\226\23\0"+
    "\46\22\1\23\1\0\2\22\1\72\1\0\1\22\23\0\1\72\1\104\4\22\1\36\1\313\2\22\1"+
    "\72\1\0\2\22\1\23\1\0\3\22\1\23\10\0\2\22\1\314\1\0\2\22\1\72\1\0\3\22\1\25"+
    "\10\0\7\22\1\307\10\0\1\315\1\73\1\144\1\41\2\22\1\226\1\116\4\0\3\22\1\26"+
    "\3\22\1\26\4\0\1\22\1\41\2\22\1\316\3\0\6\22\1\72\1\0\2\22\1\72\1\0\2\22\1"+
    "\46\1\0\2\22\1\25\15\0\11\22\1\126\6\0\6\22\1\46\1\0\6\22\1\46\41\0\1\231"+
    "\6\22\1\30\1\162\3\0\1\122\1\30\1\0\1\110\1\231\5\22\1\30\1\47\2\0\3\22\1"+
    "\126\1\30\1\163\1\231\3\22\1\161\1\30\1\142\1\30\2\0\4\22\1\317\1\0\1\231"+
    "\5\22\1\50\1\30\1\320\1\321\1\30\1\322\4\0\2\22\1\35\2\22\1\220\1\30\1\201"+
    "\10\0\1\23\1\323\1\22\1\36\1\22\1\126\5\22\1\161\1\30\1\47\1\30\1\163\1\140"+
    "\1\102\1\103\2\22\1\104\1\124\1\106\1\54\1\117\1\137\1\252\1\100\2\200\21"+
    "\0\6\22\1\177\1\30\1\202\1\46\1\30\1\163\4\0\6\22\2\30\1\324\1\0\1\30\1\163"+
    "\24\0\5\22\1\161\1\173\1\30\1\244\2\0\1\271\4\0\6\22\2\30\1\325\1\0\1\30\1"+
    "\163\4\0\5\22\1\50\1\30\1\0\1\30\1\163\6\0\3\22\1\326\1\30\1\225\1\30\1\163"+
    "\54\0\10\22\1\30\1\163\1\0\1\152\70\0\7\22\1\126\40\0\1\22\1\104\3\22\1\161"+
    "\1\162\1\30\1\126\1\0\1\30\1\163\2\0\1\40\3\22\1\327\2\30\1\43\1\162\51\0"+
    "\63\22\1\25\14\0\15\22\1\23\2\0\30\22\1\226\27\0\5\22\1\23\72\0\10\22\1\23"+
    "\67\0\7\22\1\126\3\22\1\23\1\30\1\163\14\0\3\22\1\72\1\200\1\0\6\22\1\162"+
    "\1\0\1\226\1\0\1\30\1\163\1\300\2\22\1\252\2\22\56\0\10\22\1\26\1\0\1\77\4"+
    "\30\1\162\1\0\1\110\1\231\1\22\10\0\1\126\3\0\75\22\1\26\2\0\36\22\1\46\41"+
    "\0\1\25\77\0\15\22\1\46\1\22\1\26\1\22\1\126\1\22\1\330\130\0\1\304\1\331"+
    "\1\47\1\230\1\332\1\225\3\0\1\333\22\0\1\321\67\0\12\22\1\31\10\22\1\31\1"+
    "\334\1\335\1\22\1\336\1\144\7\22\1\36\1\337\2\31\3\22\1\340\1\172\1\40\1\104"+
    "\51\22\1\72\3\22\1\104\2\22\1\212\3\22\1\212\2\22\1\31\3\22\1\31\2\22\1\23"+
    "\3\22\1\23\3\22\1\104\3\22\1\104\2\22\1\212\1\341\14\30\1\162\1\230\5\30\1"+
    "\200\1\312\1\0\1\245\2\0\1\230\1\43\1\30\52\0\1\162\2\30\1\342\1\343\1\47"+
    "\72\0\30\22\1\26\1\0\1\162\5\0\10\22\1\220\1\47\1\30\1\163\24\0\1\144\3\22"+
    "\1\164\1\41\1\212\1\344\1\250\1\345\1\164\1\236\1\164\2\212\1\121\1\22\1\35"+
    "\1\22\1\226\1\346\1\35\1\22\1\226\50\0\32\22\1\23\5\0\106\22\1\26\1\0\33\22"+
    "\1\72\120\22\1\25\53\0\3\22\1\72\134\0\36\30\2\0");

  /* The ZZ_CMAP_A table has 1848 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\1\1\3\2\1\1\3\2\0\1\1\1\0\1\10\1\4\1\40\5\0\1\5\2\0\1\41\1\20\1\2"+
    "\1\12\11\15\1\35\1\36\1\25\1\42\1\27\2\0\1\14\1\16\3\14\1\16\10\6\1\13\5\6"+
    "\1\22\2\6\1\13\2\6\1\31\1\11\1\32\1\33\1\17\1\0\1\56\1\67\1\60\1\62\1\45\1"+
    "\44\1\65\1\54\1\43\2\6\1\46\1\55\1\52\1\50\1\64\1\6\1\51\1\47\1\57\1\21\1"+
    "\61\1\53\1\66\1\63\1\6\1\23\1\37\1\24\7\0\1\1\2\0\1\1\11\0\1\6\12\0\1\6\1"+
    "\0\1\7\17\6\1\0\2\6\4\0\4\6\6\0\5\6\7\0\1\6\1\0\1\6\1\0\10\7\5\6\1\0\2\6\3"+
    "\0\3\6\1\0\1\6\6\0\1\6\1\7\3\6\1\0\1\6\1\0\4\6\1\0\13\6\1\0\3\6\1\0\5\7\2"+
    "\0\6\6\1\0\7\6\1\0\1\6\7\0\15\7\1\0\1\7\1\0\2\7\1\0\2\7\1\0\1\7\3\6\5\0\3"+
    "\7\5\0\3\6\7\7\4\0\2\6\1\7\13\6\1\0\1\6\7\7\2\0\6\7\2\6\2\7\1\0\4\7\2\6\2"+
    "\7\3\6\2\0\2\6\1\7\6\6\3\7\2\0\11\6\3\7\1\6\6\0\2\7\6\6\4\7\2\6\2\0\2\7\1"+
    "\6\11\7\1\6\3\7\1\6\5\7\2\0\1\6\3\7\4\0\6\6\6\0\6\7\1\0\11\7\6\6\3\7\1\6\2"+
    "\7\1\6\7\7\2\6\2\7\2\0\2\7\1\6\3\7\1\0\10\6\2\0\2\6\2\0\6\6\1\0\7\6\1\0\1"+
    "\6\3\0\4\6\2\0\1\7\1\6\3\7\2\0\3\7\1\6\10\0\1\7\4\0\2\6\1\0\1\6\1\0\3\7\1"+
    "\0\6\6\4\0\2\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0\5\7\4\0\2\7\2\0\3\7\3\0"+
    "\1\7\7\0\4\6\1\0\1\6\7\0\4\7\3\6\1\7\2\0\1\6\1\0\2\6\1\0\3\6\2\7\1\0\3\7\2"+
    "\0\1\6\11\0\1\7\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0\1\6\1\0\2\6\3\0\2"+
    "\6\3\0\2\6\4\0\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\5\7\1\0\5\6\3\0\1\6\7\7\1\0"+
    "\2\7\5\0\2\7\1\0\4\6\1\0\3\6\6\0\1\6\2\0\2\6\5\0\3\6\2\0\1\6\3\7\1\0\4\7\1"+
    "\6\5\0\3\6\1\7\7\0\1\6\2\0\2\7\1\0\7\6\1\0\1\6\4\0\1\7\4\0\6\7\1\0\1\7\3\0"+
    "\2\7\4\0\1\6\1\7\1\6\5\7\7\6\10\7\1\0\2\7\7\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6"+
    "\2\0\1\6\6\0\4\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0\2\6\1\0\3\6\2\7\1\0\2\7\1\6\2"+
    "\0\5\6\1\0\1\6\1\0\6\7\2\0\2\7\2\0\4\6\5\0\1\7\1\0\1\7\1\0\1\7\4\0\2\7\5\6"+
    "\10\7\11\0\1\7\1\0\7\7\1\6\2\7\4\6\3\7\1\6\3\7\2\6\7\7\3\6\4\7\5\6\14\7\1"+
    "\6\1\7\5\0\1\6\2\0\3\6\1\0\7\6\2\0\3\7\1\1\11\6\3\7\3\0\2\6\2\7\4\0\1\6\1"+
    "\0\2\7\4\0\4\6\10\7\3\0\1\6\4\0\1\6\1\7\5\0\3\7\2\0\1\6\1\7\1\6\5\0\4\7\4"+
    "\0\4\6\4\0\5\7\3\6\3\0\10\7\5\6\2\7\3\0\3\6\3\7\1\0\5\7\4\6\1\7\4\6\3\7\2"+
    "\6\2\0\1\6\1\0\1\6\1\0\1\6\1\0\1\6\2\0\3\6\1\0\6\6\2\0\2\6\13\1\5\0\2\1\5"+
    "\0\1\1\1\7\13\0\1\7\12\0\1\1\1\0\1\7\3\0\3\7\2\0\1\6\4\0\3\6\2\0\4\6\5\0\5"+
    "\6\4\0\1\6\10\0\1\34\2\0\1\26\1\30\7\0\4\6\3\7\2\6\4\0\1\1\4\0\3\6\1\0\5\6"+
    "\3\0\2\7\2\0\3\6\6\7\1\0\3\6\1\7\3\6\1\7\4\6\1\7\4\6\3\0\1\6\1\0\1\6\2\0\5"+
    "\6\1\7\2\6\2\7\5\6\1\0\4\6\2\7\4\0\1\6\3\7\2\6\1\7\5\6\2\7\3\0\3\6\4\0\3\6"+
    "\2\7\2\0\6\6\1\0\3\7\1\0\2\7\5\0\5\6\5\0\1\6\1\7\3\6\1\0\2\6\1\0\2\6\3\0\2"+
    "\7\10\0\3\7\1\0\1\6\1\0\1\6\3\0\4\6\4\0\1\7\6\0\2\6\2\0\3\6\3\0\3\6\1\0\2"+
    "\6\1\0\1\6\5\0\1\7\2\0\1\6\3\0\1\6\2\0\4\6\1\0\2\6\2\0\1\6\3\7\1\0\2\7\1\0"+
    "\5\6\2\7\1\0\3\6\1\7\2\0\1\6\1\0\1\7\4\6\5\0\3\7\3\0\2\7\1\6\1\0\1\6\3\0\1"+
    "\6\1\0\4\6\1\0\1\6\4\7\2\6\1\0\1\6\1\7\3\0\1\6\3\0\2\6\3\0\3\7\2\0\6\7\2\6"+
    "\3\0\2\7\1\0\2\7\3\0\6\7\2\0\3\7\2\0\4\7\4\0\1\6\2\0\2\6\2\0\4\6\1\0\4\6\1"+
    "\0\1\6\1\0\6\6\2\0\5\6\1\0\4\6\1\0\4\6\2\0\3\7\2\0\7\7\1\0\2\7\1\0\2\7\1\0"+
    "\1\6\1\0\1\6\5\0\1\6\1\0\1\6\1\0\3\6\1\0\3\6\1\0\3\6");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\1\1\3\1\4\2\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\14\4\1\27\1\30\1\27\1\31\1\32\1\33\3\0"+
    "\1\34\1\35\3\4\1\36\16\4\4\37\1\40\1\0"+
    "\1\41\3\4\1\42\3\4\1\43\7\4\1\43\1\4"+
    "\2\27\1\44\1\4\1\45\1\46\1\47\6\4\1\50"+
    "\4\4\2\27\3\4\1\51\1\52\1\53\1\4\1\54"+
    "\3\4\1\27\4\4\1\55\1\4\1\55\1\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\340\0\u0118\0\u0150\0\u0188"+
    "\0\u01c0\0\u01f8\0\u0230\0\u0268\0\u0118\0\u0118\0\u0118\0\u02a0"+
    "\0\u0118\0\u02d8\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0310"+
    "\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0348\0\u0380\0\u03b8"+
    "\0\u03f0\0\u0428\0\u0460\0\u0498\0\u04d0\0\u0508\0\u0540\0\u0578"+
    "\0\u05b0\0\u05e8\0\u0118\0\u0620\0\u0118\0\u0118\0\u0118\0\u0658"+
    "\0\u0690\0\u06c8\0\u01f8\0\u0700\0\u0738\0\u0770\0\u07a8\0\u01f8"+
    "\0\u07e0\0\u0818\0\u0850\0\u0888\0\u08c0\0\u08f8\0\u0930\0\u0968"+
    "\0\u09a0\0\u09d8\0\u0a10\0\u0a48\0\u0a80\0\u0ab8\0\u05e8\0\u0118"+
    "\0\u0af0\0\u0b28\0\u0b60\0\u0b98\0\u0bd0\0\u0c08\0\u0c40\0\u0c78"+
    "\0\u01f8\0\u0cb0\0\u0ce8\0\u0d20\0\u01f8\0\u0d58\0\u0d90\0\u0dc8"+
    "\0\u0e00\0\u0e38\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u0f88"+
    "\0\u0118\0\u0fc0\0\u01f8\0\u01f8\0\u01f8\0\u0ff8\0\u1030\0\u1068"+
    "\0\u10a0\0\u10d8\0\u1110\0\u01f8\0\u1148\0\u1180\0\u11b8\0\u11f0"+
    "\0\u1228\0\u0af0\0\u1260\0\u1298\0\u12d0\0\u01f8\0\u01f8\0\u01f8"+
    "\0\u1308\0\u01f8\0\u1340\0\u1378\0\u13b0\0\u13e8\0\u1420\0\u1458"+
    "\0\u1490\0\u14c8\0\u01f8\0\u1500\0\u1538\0\u1570";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\1\10\1\7\1\11\1\6\1\12\3\6"+
    "\1\13\2\12\1\14\2\12\1\15\2\12\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\3\12\1\43\1\12\1\44\1\12"+
    "\1\45\1\46\1\47\1\50\4\12\1\51\10\52\1\53"+
    "\1\54\56\52\1\6\1\7\1\10\1\7\1\11\1\6"+
    "\1\12\3\6\1\13\2\12\1\14\2\12\1\15\2\12"+
    "\1\55\1\56\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\25\12\100\6\1\57\57\6\71\0\1\7\1\0\1\7"+
    "\66\0\1\60\2\0\1\61\62\0\3\11\1\0\64\11"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\25\12"+
    "\13\0\1\62\2\0\1\62\25\0\1\62\3\0\1\62"+
    "\15\0\2\62\12\0\1\14\2\0\1\14\1\0\1\14"+
    "\75\0\1\21\71\0\1\23\75\0\1\27\40\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\1\12\1\63\5\12"+
    "\1\64\2\12\1\65\12\12\6\0\2\12\2\0\6\12"+
    "\1\0\1\66\1\12\20\0\5\12\1\67\1\12\1\70"+
    "\15\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\3\12\1\71\3\12\1\72\13\12\1\73\1\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\2\12\1\74"+
    "\22\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\14\12\1\75\10\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\11\12\1\76\13\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\13\12\1\77\11\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\6\12\1\100"+
    "\4\12\1\101\4\12\1\102\4\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\3\12\1\103\21\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\13\12\1\104"+
    "\11\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\2\12\1\105\22\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\1\106\24\12\10\52\1\0\57\52\10\107"+
    "\1\110\10\107\1\111\1\112\45\107\2\0\1\113\65\0"+
    "\5\61\1\114\62\61\12\0\1\115\1\0\3\115\25\0"+
    "\2\115\10\0\1\115\1\0\1\115\1\0\1\115\4\0"+
    "\1\115\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\14\12\1\116\10\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\21\12\1\117\3\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\7\12\1\120\15\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\6\12\1\121"+
    "\16\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\4\12\1\122\20\12\6\0\2\12\2\0\6\12\1\0"+
    "\1\123\1\12\20\0\25\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\14\12\1\124\10\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\14\12\1\125\10\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\6\12"+
    "\1\126\16\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\1\127\24\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\14\12\1\130\10\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\13\12\1\131\11\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\22\12\1\132"+
    "\2\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\21\12\1\133\3\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\13\12\1\134\11\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\3\12\1\125\2\12\1\135"+
    "\16\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\1\12\1\70\23\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\14\12\1\136\10\12\10\52\1\0\1\52"+
    "\1\137\1\52\3\137\25\52\2\137\10\52\1\137\1\52"+
    "\1\137\1\52\1\137\4\52\1\137\10\52\1\0\1\52"+
    "\1\140\1\52\3\140\25\52\2\140\10\52\1\140\1\52"+
    "\1\140\1\52\1\140\4\52\1\140\3\113\1\0\64\113"+
    "\2\61\1\141\2\61\1\114\62\61\12\0\1\115\1\0"+
    "\4\115\24\0\2\115\10\0\1\115\1\0\1\115\1\0"+
    "\1\115\4\0\1\115\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\2\12\1\142\22\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\3\12\1\143\21\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\15\12\1\70"+
    "\7\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\2\12\1\144\22\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\12\12\1\145\12\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\2\12\1\146\22\12\6\0"+
    "\2\12\2\0\6\12\1\0\1\147\1\12\20\0\25\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\3\12"+
    "\1\150\21\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\15\12\1\151\7\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\1\152\24\12\6\0\2\12\2\0"+
    "\6\12\1\0\2\12\20\0\22\12\1\153\2\12\6\0"+
    "\2\12\2\0\6\12\1\0\2\12\20\0\2\12\1\154"+
    "\22\12\6\0\2\12\2\0\6\12\1\0\2\12\20\0"+
    "\4\12\1\155\20\12\6\0\2\12\2\0\6\12\1\0"+
    "\2\12\20\0\1\156\24\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\1\12\1\157\2\12\1\160\20\12"+
    "\10\52\1\0\1\52\1\161\1\52\3\161\25\52\2\161"+
    "\10\52\1\161\1\52\1\161\1\52\1\161\4\52\1\161"+
    "\10\52\1\0\1\52\1\162\1\52\3\162\25\52\2\162"+
    "\10\52\1\162\1\52\1\162\1\52\1\162\4\52\1\162"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\6\12"+
    "\1\163\16\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\7\12\1\164\15\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\15\12\1\165\7\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\2\12\1\166\22\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\11\12"+
    "\1\167\13\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\14\12\1\170\10\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\2\12\1\171\22\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\4\12\1\172\20\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\13\12"+
    "\1\173\11\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\3\12\1\174\21\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\2\12\1\175\22\12\10\52\1\0"+
    "\1\52\1\176\1\52\3\176\25\52\2\176\10\52\1\176"+
    "\1\52\1\176\1\52\1\176\4\52\1\176\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\1\12\1\177\23\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\17\12"+
    "\1\200\5\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\14\12\1\172\10\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\17\12\1\145\5\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\7\12\1\201\15\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\13\12"+
    "\1\202\11\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\14\12\1\203\10\12\10\52\1\0\1\52\1\107"+
    "\1\52\3\107\25\52\2\107\10\52\1\107\1\52\1\107"+
    "\1\52\1\107\4\52\1\107\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\13\12\1\204\11\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\4\12\1\143\20\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\14\12"+
    "\1\145\10\12\6\0\2\12\2\0\6\12\1\0\2\12"+
    "\20\0\22\12\1\205\2\12\6\0\2\12\2\0\6\12"+
    "\1\0\2\12\20\0\15\12\1\206\7\12\6\0\2\12"+
    "\2\0\6\12\1\0\2\12\20\0\4\12\1\203\20\12"+
    "\6\0\2\12\2\0\6\12\1\0\2\12\20\0\2\12"+
    "\1\170\22\12";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5544];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\6\1\3\11\1\1\1\11\1\1\5\11"+
    "\1\1\5\11\15\1\1\11\1\1\3\11\3\0\25\1"+
    "\1\11\3\1\1\0\24\1\1\11\45\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
private static int indent_balance = 0;
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
    this((java.io.Reader)null);
}

public void brace_replace(int state) {
    if (brace_stack.empty()) {
    }
    else {
        brace_stack.pop();
    }
    brace_stack.push(state);
    yybegin(state);
}

public void brace_block(int state) {
    brace_stack.push(state);
    yybegin(state);
}

public void brace_recover() {
    if (brace_stack.empty()) {
        yybegin(YYINITIAL);
    }
    else {
        yybegin(brace_stack.pop());
    }
}

public void count_indent() {
    // yytext().last_line.count_indent
}
public void match_indent() {
    // length may < indent_balance
    // t = yytext().length() - indent_balance - Length of Newline
    // yypushback(t);
}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _ValkyrieLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 46: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 47: break;
          case 3: 
            { return COMMENT_LINE;
            } 
            // fall through
          case 48: break;
          case 4: 
            { return SYMBOL;
            } 
            // fall through
          case 49: break;
          case 5: 
            { return INTEGER;
            } 
            // fall through
          case 50: break;
          case 6: 
            { return DOT;
            } 
            // fall through
          case 51: break;
          case 7: 
            { return BRACE_L;
            } 
            // fall through
          case 52: break;
          case 8: 
            { return BRACE_R;
            } 
            // fall through
          case 53: break;
          case 9: 
            { return ANGLE_L;
            } 
            // fall through
          case 54: break;
          case 10: 
            { return LESS;
            } 
            // fall through
          case 55: break;
          case 11: 
            { return ANGLE_R;
            } 
            // fall through
          case 56: break;
          case 12: 
            { return GREATER;
            } 
            // fall through
          case 57: break;
          case 13: 
            { return BRACKET_L;
            } 
            // fall through
          case 58: break;
          case 14: 
            { return BRACKET_R;
            } 
            // fall through
          case 59: break;
          case 15: 
            { return ACCENT;
            } 
            // fall through
          case 60: break;
          case 16: 
            { return PROPORTION;
            } 
            // fall through
          case 61: break;
          case 17: 
            { return COLON;
            } 
            // fall through
          case 62: break;
          case 18: 
            { return SEMICOLON;
            } 
            // fall through
          case 63: break;
          case 19: 
            { return VERTICAL;
            } 
            // fall through
          case 64: break;
          case 20: 
            { return DOLLAR;
            } 
            // fall through
          case 65: break;
          case 21: 
            { return HYPHEN;
            } 
            // fall through
          case 66: break;
          case 22: 
            { return EQ;
            } 
            // fall through
          case 67: break;
          case 23: 
            { return STRING_CHAR;
            } 
            // fall through
          case 68: break;
          case 24: 
            { yybegin(CodeContext);
	return STRING_QUOTE;
            } 
            // fall through
          case 69: break;
          case 25: 
            { brace_block(Bitflag);
    return BRACE_L;
            } 
            // fall through
          case 70: break;
          case 26: 
            { brace_recover();
    return BRACE_R;
            } 
            // fall through
          case 71: break;
          case 27: 
            { yybegin(StringQuote);
    return STRING_QUOTE;
            } 
            // fall through
          case 72: break;
          case 28: 
            { return IF;
            } 
            // fall through
          case 73: break;
          case 29: 
            { return IN;
            } 
            // fall through
          case 74: break;
          case 30: 
            { return DEF;
            } 
            // fall through
          case 75: break;
          case 31: 
            { return STRING_ESCAPE;
            } 
            // fall through
          case 76: break;
          case 32: 
            { return COMMENT_DOCUMENT;
            } 
            // fall through
          case 77: break;
          case 33: 
            { return BYTE;
            } 
            // fall through
          case 78: break;
          case 34: 
            { return FOR;
            } 
            // fall through
          case 79: break;
          case 35: 
            { return LET;
            } 
            // fall through
          case 80: break;
          case 36: 
            { return COMMENT_BLOCK;
            } 
            // fall through
          case 81: break;
          case 37: 
            { return EXTENDS;
            } 
            // fall through
          case 82: break;
          case 38: 
            { return ELSE;
            } 
            // fall through
          case 83: break;
          case 39: 
            { return VARIANT;
            } 
            // fall through
          case 84: break;
          case 40: 
            { return TYPE;
            } 
            // fall through
          case 85: break;
          case 41: 
            { return WHILE;
            } 
            // fall through
          case 86: break;
          case 42: 
            { return MATCH;
            } 
            // fall through
          case 87: break;
          case 43: 
            { return TRAIT;
            } 
            // fall through
          case 88: break;
          case 44: 
            { return CLASS;
            } 
            // fall through
          case 89: break;
          case 45: 
            { yybegin(Bitflag);
    return BITFLAG;
            } 
            // fall through
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
