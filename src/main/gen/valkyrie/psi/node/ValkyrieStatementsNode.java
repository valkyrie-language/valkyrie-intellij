// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieStatementsNode extends ValkyrieElement implements ValkyrieStatements {

    public ValkyrieStatementsNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitStatements(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieAttributeAbove getAttributeAbove() {
        return findChildByClass(ValkyrieAttributeAbove.class);
    }

    @Override
    @Nullable
    public ValkyrieControlStatement getControlStatement() {
        return findChildByClass(ValkyrieControlStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareClass getDeclareClass() {
        return findChildByClass(ValkyrieDeclareClass.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareComponent getDeclareComponent() {
        return findChildByClass(ValkyrieDeclareComponent.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareEnums getDeclareEnums() {
        return findChildByClass(ValkyrieDeclareEnums.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareFlags getDeclareFlags() {
        return findChildByClass(ValkyrieDeclareFlags.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareFunction getDeclareFunction() {
        return findChildByClass(ValkyrieDeclareFunction.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareImply getDeclareImply() {
        return findChildByClass(ValkyrieDeclareImply.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareMacro getDeclareMacro() {
        return findChildByClass(ValkyrieDeclareMacro.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareMezzo getDeclareMezzo() {
        return findChildByClass(ValkyrieDeclareMezzo.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareNamespace getDeclareNamespace() {
        return findChildByClass(ValkyrieDeclareNamespace.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareNeural getDeclareNeural() {
        return findChildByClass(ValkyrieDeclareNeural.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareSingleton getDeclareSingleton() {
        return findChildByClass(ValkyrieDeclareSingleton.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareTests getDeclareTests() {
        return findChildByClass(ValkyrieDeclareTests.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareTrait getDeclareTrait() {
        return findChildByClass(ValkyrieDeclareTrait.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareType getDeclareType() {
        return findChildByClass(ValkyrieDeclareType.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareUnion getDeclareUnion() {
        return findChildByClass(ValkyrieDeclareUnion.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareUnite getDeclareUnite() {
        return findChildByClass(ValkyrieDeclareUnite.class);
    }

    @Override
    @Nullable
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findChildByClass(ValkyrieExpressionRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieLetStatement getLetStatement() {
        return findChildByClass(ValkyrieLetStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingStatement getUsingStatement() {
        return findChildByClass(ValkyrieUsingStatement.class);
    }

}
