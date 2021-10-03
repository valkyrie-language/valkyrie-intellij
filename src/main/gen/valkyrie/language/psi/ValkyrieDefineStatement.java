// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefineStatement extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @Nullable
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @Nullable
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieNamepathFree getNamepathFree();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
