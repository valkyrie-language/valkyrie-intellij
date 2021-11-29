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

public class ValkyrieTermNode extends MixinTerm implements ValkyrieTerm {

  public ValkyrieTermNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTerm(this);
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
  public List<ValkyrieCaseBranch> getCaseBranchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCaseBranch.class);
  }

  @Override
  @NotNull
  public List<ValkyrieDotCall> getDotCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDotCall.class);
  }

  @Override
  @NotNull
  public List<ValkyrieGeneric2> getGeneric2List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieGeneric2.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMatchBlock> getMatchBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchBlock.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNormalBlock> getNormalBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNormalBlock.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNormalPattern> getNormalPatternList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNormalPattern.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSlice> getSliceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSlice.class);
  }

}
