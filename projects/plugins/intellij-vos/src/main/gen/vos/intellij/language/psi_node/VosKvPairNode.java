// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static vos.intellij.language.psi.VosTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import vos.intellij.language.psi.*;
import vos.intellij.language.mixin.NodeExtension;

public class VosKvPairNode extends ASTWrapperPsiElement implements VosKvPair {

  public VosKvPairNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitKvPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VosKey getKey() {
    return findNotNullChildByClass(VosKey.class);
  }

  @Override
  @NotNull
  public VosSet getSet() {
    return findNotNullChildByClass(VosSet.class);
  }

  @Override
  @NotNull
  public VosValue getValue() {
    return findNotNullChildByClass(VosValue.class);
  }

}
