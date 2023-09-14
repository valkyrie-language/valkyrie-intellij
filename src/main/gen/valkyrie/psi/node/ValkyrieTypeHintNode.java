// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.mixin.MixinTypeHint;

public class ValkyrieTypeHintNode extends MixinTypeHint implements ValkyrieTypeHint {

    public ValkyrieTypeHintNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypeHint(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieTypeExpression getTypeExpression() {
        return findNotNullChildByClass(ValkyrieTypeExpression.class);
    }

}
