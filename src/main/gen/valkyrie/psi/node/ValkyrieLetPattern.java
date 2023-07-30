// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetPattern extends PsiElement {

    @Nullable
    ValkyrieBarePattern getBarePattern();

    @Nullable
    ValkyrieCasePatternObject getCasePatternObject();

    @Nullable
    ValkyrieCasePatternTuple getCasePatternTuple();

    @Nullable
    ValkyrieMatchBind getMatchBind();

}
