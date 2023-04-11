// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMatchItem extends PsiElement {

    @Nullable
    ValkyrieMatchCase getMatchCase();

    @Nullable
    ValkyrieMatchElse getMatchElse();

    @Nullable
    ValkyrieMatchWhen getMatchWhen();

    @Nullable
    ValkyrieMatchWith getMatchWith();

}
