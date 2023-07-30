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

public class ValkyrieClassBodyNode extends ValkyrieElement implements ValkyrieClassBody {

    public ValkyrieClassBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitClassBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieAssociatedType> getAssociatedTypeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieAssociatedType.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareDomain> getDeclareDomainList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareDomain.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareField> getDeclareFieldList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareField.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareMethod> getDeclareMethodList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareMethod.class);
    }

}
