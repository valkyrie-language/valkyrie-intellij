// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieImportBlock extends PsiElement {

  @Nullable
  ValkyrieExportBlock getExportBlock();

  @NotNull
  List<ValkyrieExportDot> getExportDotList();

  @Nullable
  ValkyrieExportRename getExportRename();

  @NotNull
  List<ValkyrieSymbol> getSymbolList();

}
