// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieAtomic extends PsiElement {

    @Nullable
    ValkyrieControlRaise getControlRaise();

    @Nullable
    ValkyrieExpressionRoot getExpressionRoot();

    @Nullable
    ValkyrieForStatement getForStatement();

    @Nullable
    ValkyrieFunctionCall getFunctionCall();

    @Nullable
    ValkyrieLambdaBlock getLambdaBlock();

    @Nullable
    ValkyrieLocalizeCall getLocalizeCall();

    @Nullable
    ValkyrieMacroCall getMacroCall();

    @Nullable
    ValkyrieMatchStatement getMatchStatement();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNewObject getNewObject();

    @Nullable
    ValkyrieNewValue getNewValue();

    @Nullable
    ValkyrieNumber getNumber();

    @Nullable
    ValkyrieOffsetRange getOffsetRange();

    @Nullable
    ValkyrieOrdinalRange getOrdinalRange();

    @Nullable
    ValkyrieSlot getSlot();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

    @Nullable
    ValkyrieTryStatement getTryStatement();

    @Nullable
    ValkyrieTuple getTuple();

    @Nullable
    ValkyrieWhileStatement getWhileStatement();

}
