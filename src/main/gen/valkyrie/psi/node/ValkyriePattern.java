// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyriePattern extends PsiElement {

    @Nullable
    ValkyriePatternLiteral getPatternLiteral();

    @Nullable
    ValkyriePatternObject getPatternObject();

    @Nullable
    ValkyriePatternSequence getPatternSequence();

    @Nullable
    ValkyriePatternUnapply getPatternUnapply();

}
