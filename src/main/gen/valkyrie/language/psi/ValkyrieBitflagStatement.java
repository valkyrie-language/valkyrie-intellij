// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBitflagStatement extends PsiElement {

  @NotNull
  ValkyrieBitflagBlock getBitflagBlock();

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieModifiers getModifiers();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
