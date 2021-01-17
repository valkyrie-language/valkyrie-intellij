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

public class ValkyrieFunctionCallNode extends ValkyrieElement implements ValkyrieFunctionCall {

  public ValkyrieFunctionCallNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieFunctionCall> getFunctionCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieFunctionCall.class);
  }

  @Override
  @NotNull
  public List<ValkyrieList> getListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieList.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamespace> getNamespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamespace.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTuple> getTupleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTuple.class);
  }

}
