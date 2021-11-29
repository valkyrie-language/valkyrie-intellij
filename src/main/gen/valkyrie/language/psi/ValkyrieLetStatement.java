// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetStatement extends PsiElement {

  @Nullable
  ValkyrieCatchStatement getCatchStatement();

  @Nullable
  ValkyrieControlStatement getControlStatement();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieExtractor getExtractor();

  @Nullable
  ValkyrieForStatement getForStatement();

  @Nullable
  ValkyrieForallStatement getForallStatement();

  @Nullable
  ValkyrieLetStatement getLetStatement();

  @Nullable
  ValkyrieLoopStatement getLoopStatement();

  @Nullable
  ValkyrieMacroCall getMacroCall();

  @Nullable
  ValkyrieMacroList getMacroList();

  @Nullable
  ValkyrieMatchStatement getMatchStatement();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

  @NotNull
  List<ValkyrieTypeExpression> getTypeExpressionList();

  @Nullable
  ValkyrieTypeStatement getTypeStatement();

}
