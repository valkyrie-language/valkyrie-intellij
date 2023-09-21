// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieFunctionCallInlineNode extends ValkyrieElement implements ValkyrieFunctionCallInline {

    public ValkyrieFunctionCallInlineNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitFunctionCallInline(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieArgumentBody getArgumentBody() {
        return findNotNullChildByClass(ValkyrieArgumentBody.class);
    }

    @Override
    @NotNull
    public ValkyrieNamepathSafe getNamepathSafe() {
        return findNotNullChildByClass(ValkyrieNamepathSafe.class);
    }

}
