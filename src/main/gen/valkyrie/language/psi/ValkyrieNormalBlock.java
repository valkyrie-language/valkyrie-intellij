// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieNormalBlock extends PsiElement {

  @NotNull
  List<ValkyrieCatchStatement> getCatchStatementList();

  @NotNull
  List<ValkyrieControlStatement> getControlStatementList();

  @NotNull
  List<ValkyrieExpression> getExpressionList();

  @NotNull
  List<ValkyrieForStatement> getForStatementList();

  @NotNull
  List<ValkyrieForallStatement> getForallStatementList();

  @NotNull
  List<ValkyrieLetStatement> getLetStatementList();

  @NotNull
  List<ValkyrieLoopStatement> getLoopStatementList();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  @NotNull
  List<ValkyrieMacroList> getMacroListList();

  @NotNull
  List<ValkyrieMatchStatement> getMatchStatementList();

  @NotNull
  List<ValkyrieTypeStatement> getTypeStatementList();

}
