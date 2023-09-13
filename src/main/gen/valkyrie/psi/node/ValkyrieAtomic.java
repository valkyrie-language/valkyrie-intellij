// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieAtomic extends PsiElement {

    @Nullable
    ValkyrieControlRaise getControlRaise();

    @Nullable
    ValkyrieControlYieldType getControlYieldType();

    @Nullable
    ValkyrieExpressionRoot getExpressionRoot();

    @Nullable
    ValkyrieFunctionCall getFunctionCall();

    @Nullable
    ValkyrieIfStatement getIfStatement();

    @Nullable
    ValkyrieLambdaBlock getLambdaBlock();

    @Nullable
    ValkyrieLocalizeCall getLocalizeCall();

    @Nullable
    ValkyrieLoopStatement getLoopStatement();

    @Nullable
    ValkyrieLoopTemplate getLoopTemplate();

    @Nullable
    ValkyrieMacroCall getMacroCall();

    @Nullable
    ValkyrieMatchStatement getMatchStatement();

    @Nullable
    ValkyrieMayLetStatement getMayLetStatement();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNewObject getNewObject();

    @Nullable
    ValkyrieNewValue getNewValue();

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

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
    ValkyrieTryLetStatement getTryLetStatement();

    @Nullable
    ValkyrieTryNotStatement getTryNotStatement();

    @Nullable
    ValkyrieTryStatement getTryStatement();

    @Nullable
    ValkyrieTuple getTuple();

}
