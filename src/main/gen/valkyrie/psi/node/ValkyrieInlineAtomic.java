// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieInlineAtomic extends PsiElement {

    @Nullable
    ValkyrieExpressionRoot getExpressionRoot();

    @Nullable
    ValkyrieFunctionCallInline getFunctionCallInline();

    @Nullable
    ValkyrieMacroCallInline getMacroCallInline();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

    @Nullable
    ValkyrieOffsetRange getOffsetRange();

    @Nullable
    ValkyrieOrdinalRange getOrdinalRange();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

    @Nullable
    ValkyrieTuple getTuple();

}
