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

public class ValkyrieCasePatternNode extends ValkyrieElement implements ValkyrieCasePattern {

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
  @Nullable
  public ValkyrieNamespace getNamespace() {
    return findChildByClass(ValkyrieNamespace.class);
  }

  @Override
  @NotNull
  public List<ValkyriePatternPair> getPatternPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyriePatternPair.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSymbol> getSymbolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSymbol.class);
  }

}
