// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieLetPatternNode extends ValkyrieElement implements ValkyrieLetPattern {

    public ValkyrieLetPatternNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLetPattern(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieBarePattern getBarePattern() {
        return findChildByClass(ValkyrieBarePattern.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternDict getCasePatternDict() {
        return findChildByClass(ValkyrieCasePatternDict.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternList getCasePatternList() {
        return findChildByClass(ValkyrieCasePatternList.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchBind getMatchBind() {
        return findChildByClass(ValkyrieMatchBind.class);
    }

}
