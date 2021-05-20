// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinType;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieTypeStatementNode extends MixinType implements ValkyrieTypeStatement {

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
    return PsiTreeUtil.getChildOfType(this, ValkyrieBoolean.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCallSuffix.class);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieIdentifier.class));
  }

  @Override
  @Nullable
  public ValkyrieList getList() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieList.class);
  }

  @Override
  @Nullable
  public ValkyrieNamepath getNamepath() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieNamepath.class);
  }

  @Override
  @Nullable
  public ValkyrieNumber getNumber() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieNumber.class);
  }

  @Override
  @Nullable
  public ValkyrieRange getRange() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieRange.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSlice> getSliceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSlice.class);
  }

  @Override
  @Nullable
  public ValkyrieString getString() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieString.class);
  }

  @Override
  @Nullable
  public ValkyrieTuple getTuple() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieTuple.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeGeneric> getTypeGenericList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeGeneric.class);
  }

}
