// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieGenericArgumentNode extends ValkyrieElement implements ValkyrieGenericArgument {

    public ValkyrieGenericArgumentNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitGenericArgument(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieAnnotations getAnnotations() {
        return findChildByClass(ValkyrieAnnotations.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findChildByClass(ValkyrieIdentifierSafe.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypeExpression> getTypeExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeExpression.class);
    }

}
