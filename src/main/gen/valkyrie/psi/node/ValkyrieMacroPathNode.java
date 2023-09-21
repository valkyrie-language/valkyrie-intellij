// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ValkyrieMacroPathNode extends ValkyrieNamepathSafeNode implements ValkyrieMacroPath {

    public ValkyrieMacroPathNode(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMacroPath(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieIdentifierFree> getIdentifierFreeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierFree.class);
    }

}
