// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieMatchBodyNode extends ValkyrieElement implements ValkyrieMatchBody {

    public ValkyrieMatchBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMatchBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchCase> getMatchCaseList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchCase.class);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchElse> getMatchElseList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchElse.class);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchType> getMatchTypeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchType.class);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchWhen> getMatchWhenList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchWhen.class);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchWith> getMatchWithList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchWith.class);
    }

}
