// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassBlock extends PsiElement {

  @NotNull
  List<ValkyrieClassDefine> getClassDefineList();

  @NotNull
  List<ValkyrieClassItem> getClassItemList();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  //WARNING: addChildrenView(...) is skipped
  //matching addChildrenView(ValkyrieClassBlock, ...)
  //methods are not found in ASTMethods

}
