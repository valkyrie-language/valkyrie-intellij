// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinLambda;

public class ValkyrieNewLambdaNode extends MixinLambda implements ValkyrieNewLambda {

    public ValkyrieNewLambdaNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNewLambda(this);
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
    public ValkyrieBlockBody getBlockBody() {
        return findChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareInfer getDeclareInfer() {
        return findChildByClass(ValkyrieDeclareInfer.class);
    }

    @Override
    @NotNull
    public ValkyrieLambdaNavigate getLambdaNavigate() {
        return findNotNullChildByClass(ValkyrieLambdaNavigate.class);
    }

    @Override
    @Nullable
    public ValkyrieParameterBody getParameterBody() {
        return findChildByClass(ValkyrieParameterBody.class);
    }

    @Override
    @Nullable
    public ValkyrieReturnType getReturnType() {
        return findChildByClass(ValkyrieReturnType.class);
    }

}
