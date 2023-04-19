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

public class ValkyrieTermNode extends ValkyrieElement implements ValkyrieTerm {

    public ValkyrieTermNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTerm(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieLiteral getLiteral() {
        return findNotNullChildByClass(ValkyrieLiteral.class);
    }

    @Override
    @NotNull
    public List<ValkyriePrefix> getPrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyriePrefix.class);
    }

    @Override
    @NotNull
    public List<ValkyrieSuffix> getSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSuffix.class);
    }

}
