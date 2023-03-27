// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import valkyrie.psi.YggdrasilElement;

public class YggdrasilValueNode extends YggdrasilElement implements YggdrasilValue {

    public YggdrasilValueNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YggdrasilVisitor visitor) {
        visitor.visitValue(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YggdrasilVisitor) accept((YggdrasilVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YggdrasilExpression getExpression() {
        return findChildByClass(YggdrasilExpression.class);
    }

    @Override
    @Nullable
    public YggdrasilTuple getTuple() {
        return findChildByClass(YggdrasilTuple.class);
    }

}
