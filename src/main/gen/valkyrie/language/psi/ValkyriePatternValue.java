// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePatternValue extends PsiElement {

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieNumber getNumber();

  @NotNull
  List<ValkyriePatternPair> getPatternPairList();

  @NotNull
  List<ValkyriePatternValue> getPatternValueList();

  @Nullable
  ValkyrieString getString();

}
