// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import valkyrie.psi.YggdrasilElement;

public class YggdrasilClassCastNode extends YggdrasilElement implements YggdrasilClassCast {

    public YggdrasilClassCastNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YggdrasilVisitor visitor) {
        visitor.visitClassCast(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YggdrasilVisitor) accept((YggdrasilVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YggdrasilIdentifier getIdentifier() {
        return findNotNullChildByClass(YggdrasilIdentifier.class);
    }

}
