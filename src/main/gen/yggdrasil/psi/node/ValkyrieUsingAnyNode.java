// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.ValkyrieElement;

public class ValkyrieUsingAnyNode extends ValkyrieElement implements ValkyrieUsingAny {

    public ValkyrieUsingAnyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitUsingAny(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieNamepathFree getNamepathFree() {
        return findNotNullChildByClass(ValkyrieNamepathFree.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingExclude getUsingExclude() {
        return findChildByClass(ValkyrieUsingExclude.class);
    }

}
