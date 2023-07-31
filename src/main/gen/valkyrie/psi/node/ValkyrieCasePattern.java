// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieCasePattern extends PsiElement {

    @Nullable
    ValkyrieCasePatternItem getCasePatternItem();

    @Nullable
    ValkyrieCasePatternObject getCasePatternObject();

    @Nullable
    ValkyrieCasePatternTuple getCasePatternTuple();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

}
