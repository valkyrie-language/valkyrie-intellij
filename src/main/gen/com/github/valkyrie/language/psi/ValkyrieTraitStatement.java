// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTraitStatement extends PsiElement {

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @NotNull
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieTraitBlock getTraitBlock();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  @Nullable
  ValkyrieTypeGeneric getTypeGeneric();

}
