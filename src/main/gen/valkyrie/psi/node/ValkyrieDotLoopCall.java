// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
