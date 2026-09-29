// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static vos.intellij.language.psi.VosTypes.*;
import vos.intellij.language.mixin.MixinKey;
import vos.intellij.language.psi.*;
import vos.intellij.language.mixin.NodeExtension;


public class VosKeyNode extends MixinKey implements VosKey {

  public VosKeyNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitKey(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VosIdentifier getIdentifier() {
    return findChildByClass(VosIdentifier.class);
  }

  @Override
  @Nullable
  public VosStringLiteral getStringLiteral() {
    return findChildByClass(VosStringLiteral.class);
  }

}
