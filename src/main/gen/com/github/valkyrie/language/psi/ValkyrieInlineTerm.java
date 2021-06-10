// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieInlineTerm extends PsiElement {

  @NotNull
  ValkyrieAtom getAtom();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @NotNull
  List<ValkyrieDotCall> getDotCallList();

  @NotNull
  List<ValkyrieGenericType> getGenericTypeList();

  @NotNull
  List<ValkyrieSlice> getSliceList();

}
