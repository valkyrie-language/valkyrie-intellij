// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMatchBody extends PsiElement {

    @NotNull
    List<ValkyrieMatchCase> getMatchCaseList();

    @NotNull
    List<ValkyrieMatchElse> getMatchElseList();

    @NotNull
    List<ValkyrieMatchWhen> getMatchWhenList();

    @NotNull
    List<ValkyrieMatchWith> getMatchWithList();

}
