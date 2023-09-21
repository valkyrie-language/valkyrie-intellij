// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieTypeAtomicNode extends ValkyrieElement implements ValkyrieTypeAtomic {

    public ValkyrieTypeAtomicNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypeAtomic(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieNamepathSafe getNamepathSafe() {
        return findChildByClass(ValkyrieNamepathSafe.class);
    }

    @Override
    @Nullable
    public ValkyrieNumberLiteral getNumberLiteral() {
        return findChildByClass(ValkyrieNumberLiteral.class);
    }

    @Override
    @Nullable
    public ValkyrieString getString() {
        return findChildByClass(ValkyrieString.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeExpression getTypeExpression() {
        return findChildByClass(ValkyrieTypeExpression.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeTuple getTypeTuple() {
        return findChildByClass(ValkyrieTypeTuple.class);
    }

}
