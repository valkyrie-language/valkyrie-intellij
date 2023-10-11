// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieLetStatement extends PsiElement {

    @NotNull
    List<ValkyrieAttributeBelow> getAttributeBelowList();

    @Nullable
    ValkyrieExpression getExpression();

    @Nullable
    ValkyrieLetPattern getLetPattern();

    @Nullable
    ValkyrieTypeHint getTypeHint();

    @NotNull PsiElement getKeyword();

}
