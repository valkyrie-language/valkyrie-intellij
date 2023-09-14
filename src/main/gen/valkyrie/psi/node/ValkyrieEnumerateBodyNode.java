// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieEnumerateBodyNode extends ValkyrieElement implements ValkyrieEnumerateBody {

    public ValkyrieEnumerateBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitEnumerateBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareDomain> getDeclareDomainList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareDomain.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareMethod> getDeclareMethodList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareMethod.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareSemantic> getDeclareSemanticList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareSemantic.class);
    }

}
