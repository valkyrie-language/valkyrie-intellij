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

public class ValkyrieInlineAtomicNode extends ValkyrieElement implements ValkyrieInlineAtomic {

    public ValkyrieInlineAtomicNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitInlineAtomic(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findChildByClass(ValkyrieExpressionRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieFunctionCallInline getFunctionCallInline() {
        return findChildByClass(ValkyrieFunctionCallInline.class);
    }

    @Override
    @Nullable
    public ValkyrieMacroCallInline getMacroCallInline() {
        return findChildByClass(ValkyrieMacroCallInline.class);
    }

    @Override
    @Nullable
    public ValkyrieNamepath getNamepath() {
        return findChildByClass(ValkyrieNamepath.class);
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
    public ValkyrieTuple getTuple() {
        return findChildByClass(ValkyrieTuple.class);
    }

}
