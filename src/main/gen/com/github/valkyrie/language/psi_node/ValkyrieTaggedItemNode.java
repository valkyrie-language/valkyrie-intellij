// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieTaggedItemNode extends ValkyrieElement implements ValkyrieTaggedItem {

  public ValkyrieTaggedItemNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTaggedItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieClassBrace getClassBrace() {
    return findChildByClass(ValkyrieClassBrace.class);
  }

  @Override
  @Nullable
  public ValkyrieClassTuple getClassTuple() {
    return findChildByClass(ValkyrieClassTuple.class);
  }

  @Override
  @NotNull
  public ValkyrieSymbol getSymbol() {
    return findNotNullChildByClass(ValkyrieSymbol.class);
  }

}
