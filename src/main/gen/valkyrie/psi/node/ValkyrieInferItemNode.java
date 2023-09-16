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

public class ValkyrieInferItemNode extends ValkyrieElement implements ValkyrieInferItem {

    public ValkyrieInferItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitInferItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieDeclareWhere getDeclareWhere() {
        return findChildByClass(ValkyrieDeclareWhere.class);
    }

}