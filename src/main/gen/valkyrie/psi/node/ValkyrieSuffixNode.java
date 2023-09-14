// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieSuffixNode extends ValkyrieElement implements ValkyrieSuffix {

    public ValkyrieSuffixNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitSuffix(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieDotCall getDotCall() {
        return findChildByClass(ValkyrieDotCall.class);
    }

    @Override
    @Nullable
    public ValkyrieDotCallMacro getDotCallMacro() {
        return findChildByClass(ValkyrieDotCallMacro.class);
    }

    @Override
    @Nullable
    public ValkyrieDotLoopCall getDotLoopCall() {
        return findChildByClass(ValkyrieDotLoopCall.class);
    }

    @Override
    @Nullable
    public ValkyrieDotMatchCall getDotMatchCall() {
        return findChildByClass(ValkyrieDotMatchCall.class);
    }

    @Override
    @Nullable
    public ValkyrieGenericCall getGenericCall() {
        return findChildByClass(ValkyrieGenericCall.class);
    }

    @Override
    @Nullable
    public ValkyrieIsStatement getIsStatement() {
        return findChildByClass(ValkyrieIsStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieOffsetSlice getOffsetSlice() {
        return findChildByClass(ValkyrieOffsetSlice.class);
    }

    @Override
    @Nullable
    public ValkyrieOrdinalSlice getOrdinalSlice() {
        return findChildByClass(ValkyrieOrdinalSlice.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeExpression getTypeExpression() {
        return findChildByClass(ValkyrieTypeExpression.class);
    }

}
