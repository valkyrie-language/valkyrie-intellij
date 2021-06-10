// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTerm extends PsiElement {

  @NotNull
  ValkyrieAtom getAtom();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @NotNull
  List<ValkyrieCatchStatement> getCatchStatementList();

  @NotNull
  List<ValkyrieDotCall> getDotCallList();

  @NotNull
  List<ValkyrieGenericType> getGenericTypeList();

  @NotNull
  List<ValkyrieMatchStatement> getMatchStatementList();

  @NotNull
  List<ValkyrieNormalBlock> getNormalBlockList();

  @NotNull
  List<ValkyrieSlice> getSliceList();

}
