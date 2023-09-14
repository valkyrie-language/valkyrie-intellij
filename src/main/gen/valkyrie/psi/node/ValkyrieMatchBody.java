// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieMatchBody extends PsiElement {

    @NotNull
    List<ValkyrieMatchCase> getMatchCaseList();

    @NotNull
    List<ValkyrieMatchElse> getMatchElseList();

    @NotNull
    List<ValkyrieMatchType> getMatchTypeList();

    @NotNull
    List<ValkyrieMatchWhen> getMatchWhenList();

    @NotNull
    List<ValkyrieMatchWith> getMatchWithList();

}
