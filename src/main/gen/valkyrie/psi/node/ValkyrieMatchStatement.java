// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieMatchStatement extends PsiElement {

    @Nullable
    ValkyrieExpressionInline getExpressionInline();

    @Nullable
    ValkyrieMatchBind getMatchBind();

    @Nullable
    ValkyrieMatchBody getMatchBody();

    @NotNull
    ValkyrieMatchKind getMatchKind();

}
