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
    ValkyrieLiteral getLiteral();

    @Nullable
    ValkyrieLocalizeCall getLocalizeCall();

    @Nullable
    ValkyrieMacroCall getMacroCall();

    @Nullable
    ValkyrieMatchStatement getMatchStatement();

    @Nullable
    ValkyrieNewObject getNewObject();

    @Nullable
    ValkyrieNewValue getNewValue();

    @Nullable
    ValkyrieOffsetRange getOffsetRange();

    @Nullable
    ValkyrieOrdinalRange getOrdinalRange();

    @Nullable
    ValkyrieSlot getSlot();

    @Nullable
    ValkyrieTryStatement getTryStatement();

    @Nullable
    ValkyrieTuple getTuple();

    @Nullable
    ValkyrieWhileStatement getWhileStatement();

}
