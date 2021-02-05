// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.psi.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieForStatementNode extends ValkyrieElement implements ValkyrieForStatement {

  public ValkyrieForStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitForStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieBlock getBlock() {
    return findNotNullChildByClass(ValkyrieBlock.class);
  }

  @Override
  @NotNull
  public List<ValkyrieBoolean> getBooleanList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieBoolean.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCallSuffix.class);
  }

  @Override
  @Nullable
  public ValkyrieElseStatement getElseStatement() {
    return findChildByClass(ValkyrieElseStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieIfGuard getIfGuard() {
    return findChildByClass(ValkyrieIfGuard.class);
  }

  @Override
  @NotNull
  public List<ValkyrieList> getListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieList.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamespace> getNamespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamespace.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNumber> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNumber.class);
  }

  @Override
  @NotNull
  public ValkyriePattern getPattern() {
    return findNotNullChildByClass(ValkyriePattern.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSliceSuffix> getSliceSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSliceSuffix.class);
  }

  @Override
  @NotNull
  public List<ValkyrieString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieString.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTuple> getTupleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTuple.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTurboSuffix> getTurboSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTurboSuffix.class);
  }

}
