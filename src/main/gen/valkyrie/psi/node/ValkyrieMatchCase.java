// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieMatchCase extends PsiElement {

    @Nullable
    ValkyrieBlockBare getBlockBare();

    @NotNull
    List<ValkyrieCasePatternKind> getCasePatternKindList();

    @NotNull
    List<ValkyrieCasePatternTop> getCasePatternTopList();

    @Nullable
    ValkyrieIfCondition getIfCondition();

}
