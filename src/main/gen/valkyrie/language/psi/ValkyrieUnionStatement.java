// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieUnionStatement extends PsiElement {

  @Nullable
  ValkyrieClassEffect getClassEffect();

  @Nullable
  ValkyrieClassInherit getClassInherit();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieModified getModified();

  @Nullable
  ValkyrieUnionBlock getUnionBlock();

}
