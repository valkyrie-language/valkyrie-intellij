// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetPattern extends PsiElement {

    @Nullable
    ValkyriePatternBare getPatternBare();

    @Nullable
    ValkyriePatternObject getPatternObject();

    @Nullable
    ValkyriePatternSequence getPatternSequence();

    @Nullable
    ValkyriePatternUnapply getPatternUnapply();

}
