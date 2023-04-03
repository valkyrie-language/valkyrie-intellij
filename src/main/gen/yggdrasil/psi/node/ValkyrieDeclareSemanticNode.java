// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinSemantic;
import valkyrie.ide.highlight.NodeHighlighter;

public class ValkyrieDeclareSemanticNode extends MixinSemantic implements ValkyrieDeclareSemantic {

    public ValkyrieDeclareSemanticNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareSemantic(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieAnnotations getAnnotations() {
        return findNotNullChildByClass(ValkyrieAnnotations.class);
    }

    @Override
    @Nullable
    public ValkyrieDefaultValue getDefaultValue() {
        return findChildByClass(ValkyrieDefaultValue.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(ValkyrieIdentifierFree.class);
    }

}
