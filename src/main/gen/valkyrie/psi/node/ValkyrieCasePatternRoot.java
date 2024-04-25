// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieCasePatternRoot extends PsiElement {

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieCasePatternArray getCasePatternArray();

    @Nullable
    ValkyrieCasePatternObject getCasePatternObject();

    @Nullable
    ValkyrieCasePatternTuple getCasePatternTuple();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNumber getNumber();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

}
