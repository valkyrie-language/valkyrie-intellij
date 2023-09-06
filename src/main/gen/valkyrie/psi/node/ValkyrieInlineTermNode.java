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

public class ValkyrieInlineTermNode extends ValkyrieElement implements ValkyrieInlineTerm {

    public ValkyrieInlineTermNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitInlineTerm(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieInlineAtomic getInlineAtomic() {
        return findNotNullChildByClass(ValkyrieInlineAtomic.class);
    }

    @Override
    @NotNull
    public List<ValkyrieInlineSuffix> getInlineSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieInlineSuffix.class);
    }

    @Override
    @NotNull
    public List<ValkyriePrefix> getPrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyriePrefix.class);
    }

}
