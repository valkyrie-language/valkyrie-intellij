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

public class ValkyrieLoopUntilNotNode extends ValkyrieElement implements ValkyrieLoopUntilNot {

    public ValkyrieLoopUntilNotNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopUntilNot(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieExpressionInline getExpressionInline() {
        return findChildByClass(ValkyrieExpressionInline.class);
    }

    @Override
    @NotNull
    public ValkyrieTypePattern getTypePattern() {
        return findNotNullChildByClass(ValkyrieTypePattern.class);
    }

}
