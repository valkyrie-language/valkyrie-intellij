// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyriePrefixNode extends ValkyrieElement implements ValkyriePrefix {

    public ValkyriePrefixNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitPrefix(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyriePrefixDeref getPrefixDeref() {
        return findChildByClass(ValkyriePrefixDeref.class);
    }

    @Override
    @Nullable
    public ValkyriePrefixNot getPrefixNot() {
        return findChildByClass(ValkyriePrefixNot.class);
    }

    @Override
    @Nullable
    public ValkyriePrefixRef getPrefixRef() {
        return findChildByClass(ValkyriePrefixRef.class);
    }

}
