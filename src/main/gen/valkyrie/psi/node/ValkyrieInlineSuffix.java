// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieInlineSuffix extends PsiElement {

    @Nullable
    ValkyrieDotCallInline getDotCallInline();

    @Nullable
    ValkyrieDotCallMacroInline getDotCallMacroInline();

    @Nullable
    ValkyrieGenericCall getGenericCall();

    @Nullable
    ValkyrieIsExpression getIsExpression();

    @Nullable
    ValkyrieOffsetSlice getOffsetSlice();

    @Nullable
    ValkyrieOrdinalSlice getOrdinalSlice();

}
