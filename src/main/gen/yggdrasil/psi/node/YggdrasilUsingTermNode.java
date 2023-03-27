// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import valkyrie.psi.YggdrasilElement;

public class YggdrasilUsingTermNode extends YggdrasilElement implements YggdrasilUsingTerm {

    public YggdrasilUsingTermNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YggdrasilVisitor visitor) {
        visitor.visitUsingTerm(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YggdrasilVisitor) accept((YggdrasilVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YggdrasilUsingAlias getUsingAlias() {
        return findChildByClass(YggdrasilUsingAlias.class);
    }

}
