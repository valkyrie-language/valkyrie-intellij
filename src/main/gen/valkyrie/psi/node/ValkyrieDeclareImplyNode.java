// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinImply;

public class ValkyrieDeclareImplyNode extends MixinImply implements ValkyrieDeclareImply {

    public ValkyrieDeclareImplyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareImply(this);
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
    public ValkyrieClassBody getClassBody() {
        return findChildByClass(ValkyrieClassBody.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareInfer getDeclareInfer() {
        return findChildByClass(ValkyrieDeclareInfer.class);
    }

    @Override
    @Nullable
    public ValkyrieGenericCallFree getGenericCallFree() {
        return findChildByClass(ValkyrieGenericCallFree.class);
    }

    @Override
    @Nullable
    public ValkyrieNamepathSafe getNamepathSafe() {
        return findChildByClass(ValkyrieNamepathSafe.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeExpression getTypeExpression() {
        return findChildByClass(ValkyrieTypeExpression.class);
    }

}
