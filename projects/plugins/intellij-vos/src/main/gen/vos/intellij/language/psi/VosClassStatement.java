// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VosClassStatement extends PsiElement {

  @Nullable
  VosClassBlock getClassBlock();

  @NotNull
  VosIdentifier getIdentifier();

  @NotNull
  VosModifiers getModifiers();

  @Nullable
  VosTypeExpression getTypeExpression();

}
