// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VosSchemaStatement extends PsiElement {

  @NotNull
  VosBraceBlock getBraceBlock();

  @NotNull
  VosIdentifier getIdentifier();

  @NotNull
  VosSchema getSchema();

  @Nullable
  VosTypeExpression getTypeExpression();

}
