// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieImportRename extends PsiElement {

  @Nullable
  ValkyrieAs getAs();

  @NotNull
  List<ValkyrieImportDot> getImportDotList();

  @NotNull
  List<ValkyrieSymbol> getSymbolList();

}
