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

public class ValkyrieSuffixNode extends ValkyrieElement implements ValkyrieSuffix {

    public ValkyrieSuffixNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitSuffix(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieDotCall getDotCall() {
        return findChildByClass(ValkyrieDotCall.class);
    }

    @Override
    @Nullable
    public ValkyrieDotCallMatch getDotCallMatch() {
        return findChildByClass(ValkyrieDotCallMatch.class);
    }

    @Override
    @Nullable
    public ValkyrieGenericCall getGenericCall() {
        return findChildByClass(ValkyrieGenericCall.class);
    }

}
