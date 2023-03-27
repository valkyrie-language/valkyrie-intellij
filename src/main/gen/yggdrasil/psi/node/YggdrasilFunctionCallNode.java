// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import valkyrie.psi.YggdrasilElement;

public class YggdrasilFunctionCallNode extends YggdrasilElement implements YggdrasilFunctionCall {

    public YggdrasilFunctionCallNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YggdrasilVisitor visitor) {
        visitor.visitFunctionCall(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YggdrasilVisitor) accept((YggdrasilVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YggdrasilIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(YggdrasilIdentifierFree.class);
    }

    @Override
    @Nullable
    public YggdrasilTuple getTuple() {
        return findChildByClass(YggdrasilTuple.class);
    }

}
