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

public class ValkyrieIfCaseStatementNode extends ValkyrieElement implements ValkyrieIfCaseStatement {

    public ValkyrieIfCaseStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitIfCaseStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieBlockBody getBlockBody() {
        return findNotNullChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePattern getCasePattern() {
        return findChildByClass(ValkyrieCasePattern.class);
    }

    @Override
    @Nullable
    public ValkyrieElseStatement getElseStatement() {
        return findChildByClass(ValkyrieElseStatement.class);
    }

    @Override
    @NotNull
    public ValkyrieExpressionInline getExpressionInline() {
        return findNotNullChildByClass(ValkyrieExpressionInline.class);
    }

    @Override
    @Nullable
    public ValkyrieTypePattern getTypePattern() {
        return findChildByClass(ValkyrieTypePattern.class);
    }

}
