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

public class VosTypeNumberNode extends ASTWrapperPsiElement implements VosTypeNumber {

  public VosTypeNumberNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitTypeNumber(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VosTypeGeneric getTypeGeneric() {
    return findChildByClass(VosTypeGeneric.class);
  }

  @Override
  @Nullable
  public VosTypeGenericBound getTypeGenericBound() {
    return findChildByClass(VosTypeGenericBound.class);
  }

  @Override
  @Nullable
  public VosTypeGenericCompare getTypeGenericCompare() {
    return findChildByClass(VosTypeGenericCompare.class);
  }

  @Override
  @Nullable
  public VosTypeGenericRange getTypeGenericRange() {
    return findChildByClass(VosTypeGenericRange.class);
  }

}
