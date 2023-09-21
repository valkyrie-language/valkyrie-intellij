// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieUsingAliasNode extends ValkyrieElement implements ValkyrieUsingAlias {

    public ValkyrieUsingAliasNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitUsingAlias(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieIdentifierSafe> getIdentifierSafeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierSafe.class);
    }

}
