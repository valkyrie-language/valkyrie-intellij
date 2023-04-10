// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieAtomic extends PsiElement {

    @Nullable
    ValkyrieExpression getExpression();

    @Nullable
    ValkyrieFunctionCall getFunctionCall();

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

    @Nullable
    ValkyrieString getString();

}
