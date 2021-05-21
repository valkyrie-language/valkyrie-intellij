// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.ast.ValkyrieASTBase;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieAtomNode extends ValkyrieASTBase implements ValkyrieAtom {

  public ValkyrieAtomNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitAtom(this);
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
  @Nullable
  public ValkyrieList getList() {
    return findChildByClass(ValkyrieList.class);
  }

  @Override
  @Nullable
  public ValkyrieNamepath getNamepath() {
    return findChildByClass(ValkyrieNamepath.class);
  }

  @Override
  @Nullable
  public ValkyrieNumber getNumber() {
    return findChildByClass(ValkyrieNumber.class);
  }

  @Override
  @Nullable
  public ValkyrieObject getObject() {
    return findChildByClass(ValkyrieObject.class);
  }

  @Override
  @Nullable
  public ValkyrieRange getRange() {
    return findChildByClass(ValkyrieRange.class);
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
