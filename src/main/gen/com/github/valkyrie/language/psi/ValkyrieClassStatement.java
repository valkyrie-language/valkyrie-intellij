// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassStatement extends PsiElement {

  @Nullable
  ValkyrieClassBlock getClassBlock();

  @Nullable
  ValkyrieClassInherit getClassInherit();

  @Nullable
  ValkyrieClassTuple getClassTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieModified getModified();

  //WARNING: getIdentifier(...) is skipped
  //matching getIdentifier(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

}
