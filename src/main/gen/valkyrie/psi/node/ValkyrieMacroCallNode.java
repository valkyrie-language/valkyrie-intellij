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

public class ValkyrieMacroCallNode extends ValkyrieElement implements ValkyrieMacroCall {

    public ValkyrieMacroCallNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMacroCall(this);
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
    @Nullable
    public ValkyrieGenericCall getGenericCall() {
        return findChildByClass(ValkyrieGenericCall.class);
    }

    @Override
    @Nullable
    public ValkyrieMacroPath getMacroPath() {
        return findChildByClass(ValkyrieMacroPath.class);
    }

}
