// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.ValkyrieTypeMixin;
import com.github.valkyrie.language.psi.*;

public class ValkyrieTypeStatementNode extends ValkyrieTypeMixin implements ValkyrieTypeStatement {

  public ValkyrieTypeStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTypeStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieBoolean getBoolean() {
    return findChildByClass(ValkyrieBoolean.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCallSuffix.class);
  }

  @Override
  @Nullable
  public ValkyrieList getList() {
    return findChildByClass(ValkyrieList.class);
  }

  @Override
  @Nullable
  public ValkyrieNamespace getNamespace() {
    return findChildByClass(ValkyrieNamespace.class);
  }

  @Override
  @Nullable
  public ValkyrieNumber getNumber() {
    return findChildByClass(ValkyrieNumber.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSliceSuffix> getSliceSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSliceSuffix.class);
  }

  @Override
  @Nullable
  public ValkyrieString getString() {
    return findChildByClass(ValkyrieString.class);
  }

  @Override
  @NotNull
  public ValkyrieSymbol getSymbol() {
    return findNotNullChildByClass(ValkyrieSymbol.class);
  }

  @Override
  @Nullable
  public ValkyrieTuple getTuple() {
    return findChildByClass(ValkyrieTuple.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeAngle> getTypeAngleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeAngle.class);
  }

}
