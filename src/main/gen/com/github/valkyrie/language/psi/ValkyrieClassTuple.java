// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassTuple extends PsiElement {

  @NotNull
  List<ValkyrieClassItem> getClassItemList();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  //WARNING: addChildrenView(...) is skipped
  //matching addChildrenView(ValkyrieClassTuple, ...)
  //methods are not found in ASTMethods

}
