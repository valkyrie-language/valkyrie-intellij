// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.github.valkyrie.language.mixin.MixinClass.ClassStub;

public interface ValkyrieClassStatement extends PsiElement, StubBasedPsiElement<ClassStub> {

  @Nullable
  ValkyrieClassBlock getClassBlock();

  @Nullable
  ValkyrieClassInherit getClassInherit();

  @Nullable
  ValkyrieClassTuple getClassTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieMaybeModifier getMaybeModifier();

}
