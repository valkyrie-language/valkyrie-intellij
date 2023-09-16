// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieCasePatternRestNode extends ValkyrieElement implements ValkyrieCasePatternRest {

    public ValkyrieCasePatternRestNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitCasePatternRest(this);
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
    @NotNull
    public ValkyrieCasePatternKind getCasePatternKind() {
        return findNotNullChildByClass(ValkyrieCasePatternKind.class);
    }

}
