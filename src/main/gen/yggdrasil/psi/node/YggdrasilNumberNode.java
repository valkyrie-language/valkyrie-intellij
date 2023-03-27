// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import valkyrie.psi.YggdrasilElement;

public class YggdrasilNumberNode extends YggdrasilElement implements YggdrasilNumber {

    public YggdrasilNumberNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YggdrasilVisitor visitor) {
        visitor.visitNumber(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YggdrasilVisitor) accept((YggdrasilVisitor) visitor);
        else super.accept(visitor);
    }

}
