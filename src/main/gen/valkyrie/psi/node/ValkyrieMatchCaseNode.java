// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.ValkyrieElement;

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
    @Nullable
    public ValkyrieCasePatternRoot getCasePatternRoot() {
        return findChildByClass(ValkyrieCasePatternRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieIfCondition getIfCondition() {
        return findChildByClass(ValkyrieIfCondition.class);
    }

}
