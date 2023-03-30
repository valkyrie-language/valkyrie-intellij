// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinUnite;
import com.intellij.codeInsight.lookup.LookupElement;
import valkyrie.ide.highlight.NodeHighlighter;

public class ValkyrieDeclareUniteNode extends MixinUnite implements ValkyrieDeclareUnite {

    public ValkyrieDeclareUniteNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareUnite(this);
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
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieUnionBody getUnionBody() {
        return findChildByClass(ValkyrieUnionBody.class);
    }

}
