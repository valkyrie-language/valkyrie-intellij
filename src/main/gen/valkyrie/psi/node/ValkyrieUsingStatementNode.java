// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinUsing;

public class ValkyrieUsingStatementNode extends MixinUsing implements ValkyrieUsingStatement {

    public ValkyrieUsingStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitUsingStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieAnnotations getAnnotations() {
        return findNotNullChildByClass(ValkyrieAnnotations.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingBody getUsingBody() {
        return findChildByClass(ValkyrieUsingBody.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingTerm getUsingTerm() {
        return findChildByClass(ValkyrieUsingTerm.class);
    }

}
