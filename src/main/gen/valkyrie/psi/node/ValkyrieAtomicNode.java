// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
    public ValkyrieControlYieldType getControlYieldType() {
        return findChildByClass(ValkyrieControlYieldType.class);
    }

    @Override
    @Nullable
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findChildByClass(ValkyrieExpressionRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieFunctionCall getFunctionCall() {
        return findChildByClass(ValkyrieFunctionCall.class);
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
    public ValkyrieLoopStatement getLoopStatement() {
        return findChildByClass(ValkyrieLoopStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopTemplate getLoopTemplate() {
        return findChildByClass(ValkyrieLoopTemplate.class);
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
    public ValkyrieMayLetStatement getMayLetStatement() {
        return findChildByClass(ValkyrieMayLetStatement.class);
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
    public ValkyrieNumberLiteral getNumberLiteral() {
        return findChildByClass(ValkyrieNumberLiteral.class);
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
    public ValkyrieTryLetStatement getTryLetStatement() {
        return findChildByClass(ValkyrieTryLetStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieTryNotStatement getTryNotStatement() {
        return findChildByClass(ValkyrieTryNotStatement.class);
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

}
