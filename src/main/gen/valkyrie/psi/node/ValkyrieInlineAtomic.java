// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieInlineAtomic extends PsiElement {

    @Nullable
    ValkyrieExpressionRoot getExpressionRoot();

    @Nullable
    ValkyrieFunctionCallInline getFunctionCallInline();

    @Nullable
    ValkyrieMacroCall getMacroCall();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNumber getNumber();

    @Nullable
    ValkyrieOffsetRange getOffsetRange();

    @Nullable
    ValkyrieOrdinalRange getOrdinalRange();

    @Nullable
    ValkyrieSpecial getSpecial();

}
