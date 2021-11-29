// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @Nullable
  ValkyrieCaseBranch getCaseBranch();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @Nullable
  ValkyrieInlineExpression getInlineExpression();

  @Nullable
  ValkyrieNormalBlock getNormalBlock();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

}
