// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinMatchStatement;

public class ValkyrieMatchStatementNode extends MixinMatchStatement implements ValkyrieMatchStatement {

    public ValkyrieMatchStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMatchStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieExpressionInline getExpressionInline() {
        return findChildByClass(ValkyrieExpressionInline.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchBind getMatchBind() {
        return findChildByClass(ValkyrieMatchBind.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchBody getMatchBody() {
        return findChildByClass(ValkyrieMatchBody.class);
    }

    @Override
    @NotNull
    public ValkyrieMatchKind getMatchKind() {
        return findNotNullChildByClass(ValkyrieMatchKind.class);
    }

}
