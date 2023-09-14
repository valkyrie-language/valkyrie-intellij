// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieSuffix extends PsiElement {

    @Nullable
    ValkyrieDotCall getDotCall();

    @Nullable
    ValkyrieDotCallMacro getDotCallMacro();

    @Nullable
    ValkyrieDotLoopCall getDotLoopCall();

    @Nullable
    ValkyrieDotMatchCall getDotMatchCall();

    @Nullable
    ValkyrieGenericCall getGenericCall();

    @Nullable
    ValkyrieIsStatement getIsStatement();

    @Nullable
    ValkyrieOffsetSlice getOffsetSlice();

    @Nullable
    ValkyrieOrdinalSlice getOrdinalSlice();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
