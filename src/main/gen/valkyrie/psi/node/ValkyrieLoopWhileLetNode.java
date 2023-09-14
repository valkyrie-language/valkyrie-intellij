// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieLoopWhileLetNode extends ValkyrieElement implements ValkyrieLoopWhileLet {

    public ValkyrieLoopWhileLetNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopWhileLet(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieExpressionInline getExpressionInline() {
        return findChildByClass(ValkyrieExpressionInline.class);
    }

    @Override
    @Nullable
    public ValkyrieIfCondition getIfCondition() {
        return findChildByClass(ValkyrieIfCondition.class);
    }

    @Override
    @NotNull
    public ValkyrieLetPattern getLetPattern() {
        return findNotNullChildByClass(ValkyrieLetPattern.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeHint getTypeHint() {
        return findChildByClass(ValkyrieTypeHint.class);
    }

}
