// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieWhileStatement extends PsiElement {

    @NotNull
    List<ValkyrieAttributeBelow> getAttributeBelowList();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieExpressionInline getExpressionInline();

}
