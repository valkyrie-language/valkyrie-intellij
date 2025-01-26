// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieDotLoopCall extends PsiElement {

    @NotNull
    List<ValkyrieAttributeBelow> getAttributeBelowList();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieControlLabel getControlLabel();

    @Nullable
    ValkyrieIfCondition getIfCondition();

    @Nullable
    ValkyrieLoopInline getLoopInline();

}
