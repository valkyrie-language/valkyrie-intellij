// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieMacroCall extends PsiElement {

    @Nullable
    ValkyrieArgumentBody getArgumentBody();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieGenericCall getGenericCall();

    @Nullable
    ValkyrieMacroPath getMacroPath();

}
