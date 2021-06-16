// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.ast.ValkyrieASTBase;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;
import valkyrie.ide.view.ValkyrieViewElement;

public class ValkyrieClassTupleNode extends ValkyrieASTBase implements ValkyrieClassTuple {

  public ValkyrieClassTupleNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitClassTuple(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieClassItem> getClassItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieClassItem.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroCall> getMacroCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroCall.class);
  }

  @Override
  public void addChildrenView(@NotNull List<ValkyrieViewElement> list) {
    ASTMethods.addChildrenView(this, list);
  }

}
