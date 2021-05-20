// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinImportItem;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieImportItemNode extends MixinImportItem implements ValkyrieImportItem {

  public ValkyrieImportItemNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitImportItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieIdentifier getIdentifier() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieIdentifier.class);
  }

  @Override
  @Nullable
  public ValkyrieImportBlock getImportBlock() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieImportBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieNamepathFree getNamepathFree() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieNamepathFree.class));
  }

}
