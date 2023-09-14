// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieCasePatternMainNode extends ValkyrieElement implements ValkyrieCasePatternMain {

    public ValkyrieCasePatternMainNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitCasePatternMain(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieCasePatternItem getCasePatternItem() {
        return findNotNullChildByClass(ValkyrieCasePatternItem.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternKind getCasePatternKind() {
        return findChildByClass(ValkyrieCasePatternKind.class);
    }

    @Override
    @NotNull
    public List<ValkyrieCasePatternRest> getCasePatternRestList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCasePatternRest.class);
    }

}
