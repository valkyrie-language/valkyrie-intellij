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

public class ValkyrieBitflagLayoutNode extends ValkyrieElement implements ValkyrieBitflagLayout {

  public ValkyrieBitflagLayoutNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitBitflagLayout(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
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
  @Nullable
  public ValkyrieString getString() {
    return findChildByClass(ValkyrieString.class);
  }

  @Override
  @Nullable
  public ValkyrieTuple getTuple() {
    return findChildByClass(ValkyrieTuple.class);
  }

}
