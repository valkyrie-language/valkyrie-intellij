// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieDotCall extends PsiElement {

    @Nullable
    ValkyrieArgumentBody getArgumentBody();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @NotNull
    ValkyrieNamepath getNamepath();

}
