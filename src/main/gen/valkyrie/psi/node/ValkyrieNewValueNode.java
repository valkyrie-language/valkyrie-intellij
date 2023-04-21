// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import valkyrie.psi.mixin.MixinBuilder;

public class ValkyrieNewValueNode extends MixinBuilder implements ValkyrieNewValue {

    public ValkyrieNewValueNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNewValue(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieArgumentBody getArgumentBody() {
        return findChildByClass(ValkyrieArgumentBody.class);
    }

    @Override
    @Nullable
    public ValkyrieNewBody getNewBody() {
        return findChildByClass(ValkyrieNewBody.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeExpression getTypeExpression() {
        return findChildByClass(ValkyrieTypeExpression.class);
    }

}
