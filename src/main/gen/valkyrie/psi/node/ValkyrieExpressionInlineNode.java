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

public class ValkyrieExpressionInlineNode extends ValkyrieElement implements ValkyrieExpressionInline {

    public ValkyrieExpressionInlineNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitExpressionInline(this);
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
    public List<ValkyrieInlineTerm> getInlineTermList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieInlineTerm.class);
    }

}
