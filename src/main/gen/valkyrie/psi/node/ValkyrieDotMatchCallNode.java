// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinMatchCall;

import java.util.List;

public class ValkyrieDotMatchCallNode extends MixinMatchCall implements ValkyrieDotMatchCall {

    public ValkyrieDotMatchCallNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDotMatchCall(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findChildByClass(ValkyrieIdentifierSafe.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchBody getMatchBody() {
        return findChildByClass(ValkyrieMatchBody.class);
    }

    @Override
    @NotNull
    public ValkyrieMatchKind getMatchKind() {
        return findNotNullChildByClass(ValkyrieMatchKind.class);
    }

    @Override
    @NotNull
    public List<ValkyrieModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieModifier.class);
    }

}
