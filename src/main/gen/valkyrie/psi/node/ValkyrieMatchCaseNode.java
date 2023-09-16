// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieMatchCaseNode extends ValkyrieElement implements ValkyrieMatchCase {

    public ValkyrieMatchCaseNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMatchCase(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieBlockBare getBlockBare() {
        return findChildByClass(ValkyrieBlockBare.class);
    }

    @Override
    @NotNull
    public List<ValkyrieCasePatternKind> getCasePatternKindList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCasePatternKind.class);
    }

    @Override
    @NotNull
    public List<ValkyrieCasePatternTop> getCasePatternTopList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCasePatternTop.class);
    }

    @Override
    @Nullable
    public ValkyrieIfCondition getIfCondition() {
        return findChildByClass(ValkyrieIfCondition.class);
    }

}
