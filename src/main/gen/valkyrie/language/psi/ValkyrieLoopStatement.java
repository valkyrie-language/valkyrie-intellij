// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLoopStatement extends PsiElement {

  @Nullable
  ValkyrieCondition getCondition();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @Nullable
  ValkyrieNormalBlock getNormalBlock();

}