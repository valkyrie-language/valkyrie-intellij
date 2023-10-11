// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.mixin.MixinTermExpression;

import java.util.List;

public class ValkyrieExpressionNode extends MixinTermExpression implements ValkyrieExpression {

    public ValkyrieExpressionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitExpression(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieInfix> getInfixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieInfix.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTerm> getTermList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTerm.class);
    }

}
