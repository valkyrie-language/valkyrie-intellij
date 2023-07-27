// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTypePattern extends PsiElement {

    @Nullable
    ValkyrieNumber getNumber();

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
