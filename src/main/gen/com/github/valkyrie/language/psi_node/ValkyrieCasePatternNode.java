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
  public ValkyrieModifiers getModifiers() {
    return findChildByClass(ValkyrieModifiers.class);
  }

  @Override
  @Nullable
  public ValkyrieNamespace getNamespace() {
    return findChildByClass(ValkyrieNamespace.class);
  }

  @Override
  @Nullable
  public ValkyriePatternBrace getPatternBrace() {
    return findChildByClass(ValkyriePatternBrace.class);
  }

  @Override
  @Nullable
  public ValkyriePatternBracket getPatternBracket() {
    return findChildByClass(ValkyriePatternBracket.class);
  }

  @Override
  @Nullable
  public ValkyriePatternTuple getPatternTuple() {
    return findChildByClass(ValkyriePatternTuple.class);
  }

}
