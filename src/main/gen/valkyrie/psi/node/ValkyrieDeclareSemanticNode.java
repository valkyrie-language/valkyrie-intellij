// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinSemantic;

public class ValkyrieDeclareSemanticNode extends MixinSemantic implements ValkyrieDeclareSemantic {

    public ValkyrieDeclareSemanticNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareSemantic(this);
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
    public ValkyrieExpression getExpression() {
        return findChildByClass(ValkyrieExpression.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findNotNullChildByClass(ValkyrieIdentifierSafe.class);
    }

}
