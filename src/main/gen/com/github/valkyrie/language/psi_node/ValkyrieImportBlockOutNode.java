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

public class ValkyrieImportBlockOutNode extends ValkyrieElement implements ValkyrieImportBlockOut {

  public ValkyrieImportBlockOutNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitImportBlockOut(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieImportBlockIn> getImportBlockInList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieImportBlockIn.class);
  }

  @Override
  @NotNull
  public List<ValkyrieImportRename> getImportRenameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieImportRename.class);
  }

}
