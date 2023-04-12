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

public class ValkyrieInlineStatementNode extends ValkyrieElement implements ValkyrieInlineStatement {

    public ValkyrieInlineStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitInlineStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieCatchStatement getCatchStatement() {
        return findChildByClass(ValkyrieCatchStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieExpression getExpression() {
        return findChildByClass(ValkyrieExpression.class);
    }

    @Override
    @Nullable
    public ValkyrieForStatement getForStatement() {
        return findChildByClass(ValkyrieForStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieIfCaseStatement getIfCaseStatement() {
        return findChildByClass(ValkyrieIfCaseStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieIfStatement getIfStatement() {
        return findChildByClass(ValkyrieIfStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchStatement getMatchStatement() {
        return findChildByClass(ValkyrieMatchStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieNewLambda getNewLambda() {
        return findChildByClass(ValkyrieNewLambda.class);
    }

    @Override
    @Nullable
    public ValkyrieNewObject getNewObject() {
        return findChildByClass(ValkyrieNewObject.class);
    }

    @Override
    @Nullable
    public ValkyrieNewValue getNewValue() {
        return findChildByClass(ValkyrieNewValue.class);
    }

    @Override
    @Nullable
    public ValkyrieTryStatement getTryStatement() {
        return findChildByClass(ValkyrieTryStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieWhileStatement getWhileStatement() {
        return findChildByClass(ValkyrieWhileStatement.class);
    }

}
