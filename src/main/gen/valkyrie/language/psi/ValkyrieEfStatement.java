// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieEfStatement extends PsiElement {

  @NotNull
  ValkyrieCondition getCondition();

  @NotNull
  ValkyrieKwElseIf getKwElseIf();

  @NotNull
  ValkyrieNormalBlock getNormalBlock();

}