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

public class ValkyrieImportRenameNode extends ValkyrieElement implements ValkyrieImportRename {

  public ValkyrieImportRenameNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitImportRename(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieAs getAs() {
    return findChildByClass(ValkyrieAs.class);
  }

  @Override
  @NotNull
  public List<ValkyrieImportDot> getImportDotList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieImportDot.class);
  }

  @Override
  @NotNull
  public List<ValkyrieImportName> getImportNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieImportName.class);
  }

}
