// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieLoopEachNode extends ValkyrieElement implements ValkyrieLoopEach {

    public ValkyrieLoopEachNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopEach(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieBarePattern getBarePattern() {
        return findChildByClass(ValkyrieBarePattern.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePattern getCasePattern() {
        return findChildByClass(ValkyrieCasePattern.class);
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
    @Nullable
    public ValkyrieMatchBind getMatchBind() {
        return findChildByClass(ValkyrieMatchBind.class);
    }

}
