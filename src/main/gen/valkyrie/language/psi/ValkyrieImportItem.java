// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieImportItem extends PsiElement {

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieImportBlock getImportBlock();

  @NotNull
  ValkyrieNamepathStar getNamepathStar();

}
