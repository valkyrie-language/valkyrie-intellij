// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinTerm;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieInlineTermNode extends MixinTerm implements ValkyrieInlineTerm {

  public ValkyrieInlineTermNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitInlineTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieAtom getAtom() {
    return findNotNullChildByClass(ValkyrieAtom.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCallSuffix.class);
  }

  @Override
  @NotNull
  public List<ValkyrieDotCall> getDotCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDotCall.class);
  }

  @Override
  @NotNull
  public List<ValkyrieGenericType> getGenericTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieGenericType.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSlice> getSliceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSlice.class);
  }

}
