// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExtendsStatement extends PsiElement {

  @NotNull
  ValkyrieClassBlock getClassBlock();

  @Nullable
  ValkyrieExpression getExpression();

  @NotNull
  List<ValkyrieGenericType> getGenericTypeList();

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieModifiers getModifiers();

}
