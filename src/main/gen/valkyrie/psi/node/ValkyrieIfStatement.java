// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
