// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieTypePattern extends PsiElement {

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

    @Nullable
    ValkyrieTypePatternItem getTypePatternItem();

    @Nullable
    ValkyrieTypePatternObject getTypePatternObject();

    @Nullable
    ValkyrieTypePatternTuple getTypePatternTuple();

}
