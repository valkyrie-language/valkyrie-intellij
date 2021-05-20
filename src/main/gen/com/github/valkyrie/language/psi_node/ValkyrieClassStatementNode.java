// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinClass;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;
import com.github.valkyrie.language.mixin.MixinClass.ClassStub;

public class ValkyrieClassStatementNode extends MixinClass implements ValkyrieClassStatement {

  public ValkyrieClassStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitClassStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieClassBlock getClassBlock() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieClassBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieClassInherit getClassInherit() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieClassInherit.class);
  }

  @Override
  @Nullable
  public ValkyrieClassTuple getClassTuple() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieClassTuple.class);
  }

  @Override
  @Nullable
  public ValkyrieGenericDefine getGenericDefine() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieGenericDefine.class);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieIdentifier.class));
  }

  @Override
  @Nullable
  public ValkyrieMaybeModifier getMaybeModifier() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieMaybeModifier.class);
  }

}
