// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForallStatement extends PsiElement {

  @Nullable
  ValkyrieForallBlock getForallBlock();

  @NotNull
  List<ValkyrieSymbol> getSymbolList();

}