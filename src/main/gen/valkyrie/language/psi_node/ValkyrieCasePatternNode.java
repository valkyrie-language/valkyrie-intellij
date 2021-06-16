// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinCasePattern;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieCasePatternNode extends MixinCasePattern implements ValkyrieCasePattern {

  public ValkyrieCasePatternNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitCasePattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifier.class);
  }

  @Override
  @Nullable
  public ValkyrieNamepath getNamepath() {
    return findChildByClass(ValkyrieNamepath.class);
  }

  @Override
  @NotNull
  public List<ValkyriePatternPair> getPatternPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyriePatternPair.class);
  }

}
