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

public class ValkyrieAtomicNode extends ValkyrieElement implements ValkyrieAtomic {

    public ValkyrieAtomicNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitAtomic(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieControlRaise getControlRaise() {
        return findChildByClass(ValkyrieControlRaise.class);
    }

    @Override
    @Nullable
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findChildByClass(ValkyrieExpressionRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieForStatement getForStatement() {
        return findChildByClass(ValkyrieForStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieFunctionCall getFunctionCall() {
        return findChildByClass(ValkyrieFunctionCall.class);
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
    public ValkyrieLambdaBlock getLambdaBlock() {
        return findChildByClass(ValkyrieLambdaBlock.class);
    }

    @Override
    @Nullable
    public ValkyrieLocalizeCall getLocalizeCall() {
        return findChildByClass(ValkyrieLocalizeCall.class);
    }

    @Override
    @Nullable
    public ValkyrieMacroCall getMacroCall() {
        return findChildByClass(ValkyrieMacroCall.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchStatement getMatchStatement() {
        return findChildByClass(ValkyrieMatchStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieNamepath getNamepath() {
        return findChildByClass(ValkyrieNamepath.class);
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
    public ValkyrieNumber getNumber() {
        return findChildByClass(ValkyrieNumber.class);
    }

    @Override
    @Nullable
    public ValkyrieOffsetRange getOffsetRange() {
        return findChildByClass(ValkyrieOffsetRange.class);
    }

    @Override
    @Nullable
    public ValkyrieOrdinalRange getOrdinalRange() {
        return findChildByClass(ValkyrieOrdinalRange.class);
    }

    @Override
    @Nullable
    public ValkyrieSlot getSlot() {
        return findChildByClass(ValkyrieSlot.class);
    }

    @Override
    @Nullable
    public ValkyrieSpecial getSpecial() {
        return findChildByClass(ValkyrieSpecial.class);
    }

    @Override
    @Nullable
    public ValkyrieString getString() {
        return findChildByClass(ValkyrieString.class);
    }

    @Override
    @Nullable
    public ValkyrieTryStatement getTryStatement() {
        return findChildByClass(ValkyrieTryStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieTuple getTuple() {
        return findChildByClass(ValkyrieTuple.class);
    }

    @Override
    @Nullable
    public ValkyrieWhileStatement getWhileStatement() {
        return findChildByClass(ValkyrieWhileStatement.class);
    }

}
