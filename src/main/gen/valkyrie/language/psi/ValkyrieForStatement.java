// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @Nullable
  ValkyrieInlineExpression getInlineExpression();

  @Nullable
  ValkyrieMatchCase getMatchCase();

  @Nullable
  ValkyrieNormalBlock getNormalBlock();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

}
