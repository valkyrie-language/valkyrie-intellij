// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieIfStatement extends PsiElement {

    @NotNull
    ValkyrieBlockBody getBlockBody();

    @NotNull
    List<ValkyrieElseIfStatement> getElseIfStatementList();

    @Nullable
    ValkyrieElseStatement getElseStatement();

    @NotNull
    ValkyrieIfCondition getIfCondition();

}
