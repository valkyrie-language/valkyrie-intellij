// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieLetPattern extends PsiElement {

    @Nullable
    ValkyrieBarePattern getBarePattern();

    @Nullable
    ValkyrieCasePatternDict getCasePatternDict();

    @Nullable
    ValkyrieCasePatternList getCasePatternList();

    @Nullable
    ValkyrieMatchBind getMatchBind();

}
