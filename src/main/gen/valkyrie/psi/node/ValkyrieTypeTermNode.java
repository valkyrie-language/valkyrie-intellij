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

public class ValkyrieTypeTermNode extends ValkyrieElement implements ValkyrieTypeTerm {

    public ValkyrieTypeTermNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypeTerm(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieTypeAtomic getTypeAtomic() {
        return findNotNullChildByClass(ValkyrieTypeAtomic.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypePrefix> getTypePrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypePrefix.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypeSuffix> getTypeSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeSuffix.class);
    }

}
