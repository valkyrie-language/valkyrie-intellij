// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieLetPattern extends PsiElement {

    @Nullable
    ValkyrieBarePattern getBarePattern();

    @Nullable
    ValkyrieCasePatternDict getCasePatternDict();

    @Nullable
    ValkyrieCasePatternList getCasePatternList();

    @NotNull
    List<ValkyrieModifier> getModifierList();

}
