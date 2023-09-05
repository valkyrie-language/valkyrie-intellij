// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
