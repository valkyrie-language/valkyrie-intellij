// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinMacroList;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieMacroListNode extends MixinMacroList implements ValkyrieMacroList {

  public ValkyrieMacroListNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitMacroList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroBlock> getMacroBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroBlock.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamepathFree> getNamepathFreeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamepathFree.class);
  }

}
