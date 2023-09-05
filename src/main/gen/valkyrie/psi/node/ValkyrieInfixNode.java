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

public class ValkyrieInfixNode extends ValkyrieElement implements ValkyrieInfix {

    public ValkyrieInfixNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitInfix(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieBadLl getBadLl() {
        return findChildByClass(ValkyrieBadLl.class);
    }

    @Override
    @Nullable
    public ValkyrieBadLll getBadLll() {
        return findChildByClass(ValkyrieBadLll.class);
    }

    @Override
    @Nullable
    public ValkyrieBadRr getBadRr() {
        return findChildByClass(ValkyrieBadRr.class);
    }

    @Override
    @Nullable
    public ValkyrieBadRrr getBadRrr() {
        return findChildByClass(ValkyrieBadRrr.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixGreater getInfixGreater() {
        return findChildByClass(ValkyrieInfixGreater.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixGreaterEqual getInfixGreaterEqual() {
        return findChildByClass(ValkyrieInfixGreaterEqual.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixLess getInfixLess() {
        return findChildByClass(ValkyrieInfixLess.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixLessEqual getInfixLessEqual() {
        return findChildByClass(ValkyrieInfixLessEqual.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixLogical getInfixLogical() {
        return findChildByClass(ValkyrieInfixLogical.class);
    }

    @Override
    @Nullable
    public ValkyrieInfixMultiple getInfixMultiple() {
        return findChildByClass(ValkyrieInfixMultiple.class);
    }

}
