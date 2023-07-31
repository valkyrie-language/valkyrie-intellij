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

public class ValkyrieDotCallMacroNode extends ValkyrieElement implements ValkyrieDotCallMacro {

    public ValkyrieDotCallMacroNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDotCallMacro(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieArgumentBody getArgumentBody() {
        return findChildByClass(ValkyrieArgumentBody.class);
    }

    @Override
    @Nullable
    public ValkyrieClassBody getClassBody() {
        return findChildByClass(ValkyrieClassBody.class);
    }

    @Override
    @NotNull
    public ValkyrieNamepath getNamepath() {
        return findNotNullChildByClass(ValkyrieNamepath.class);
    }

}
