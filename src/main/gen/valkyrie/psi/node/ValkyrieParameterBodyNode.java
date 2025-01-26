// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieParameterBodyNode extends ValkyrieElement implements ValkyrieParameterBody {

    public ValkyrieParameterBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitParameterBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieParameterDict> getParameterDictList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieParameterDict.class);
    }

    @Override
    @NotNull
    public List<ValkyrieParameterItem> getParameterItemList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieParameterItem.class);
    }

    @Override
    @NotNull
    public List<ValkyrieParameterList> getParameterListList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieParameterList.class);
    }

}
