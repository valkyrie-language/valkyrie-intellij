// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefineItem extends PsiElement {

  @NotNull
  List<ValkyrieExpression> getExpressionList();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  @Nullable
  ValkyrieModifiers getModifiers();

}
