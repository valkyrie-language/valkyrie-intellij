// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

public class ValkyrieNamepathFreeNode extends ValkyrieNamepathNode implements ValkyrieNamepathFree {

    public ValkyrieNamepathFreeNode(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNamepathFree(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

}
