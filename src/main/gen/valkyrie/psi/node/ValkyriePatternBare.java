// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePatternBare extends PsiElement {

    @NotNull
    List<ValkyriePatternAtomic> getPatternAtomicList();

    @Nullable
    ValkyriePatternObject getPatternObject();

    @Nullable
    ValkyriePatternSequence getPatternSequence();

    @Nullable
    ValkyriePatternUnapply getPatternUnapply();

}
