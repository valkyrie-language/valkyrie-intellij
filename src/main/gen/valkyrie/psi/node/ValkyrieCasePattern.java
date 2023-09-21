// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieCasePattern extends PsiElement {

    @Nullable
    ValkyrieCasePatternDict getCasePatternDict();

    @Nullable
    ValkyrieCasePatternList getCasePatternList();

    @Nullable
    ValkyrieNamepathSafe getNamepathSafe();

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

}
