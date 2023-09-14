// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieControlStatement extends PsiElement {

    @Nullable
    ValkyrieControlBreak getControlBreak();

    @Nullable
    ValkyrieControlContinue getControlContinue();

    @Nullable
    ValkyrieControlResume getControlResume();

    @Nullable
    ValkyrieControlReturn getControlReturn();

    @Nullable
    ValkyrieControlThrough getControlThrough();

    @Nullable
    ValkyrieControlYieldFrom getControlYieldFrom();

    @Nullable
    ValkyrieControlYieldSend getControlYieldSend();

    @Nullable
    ValkyrieControlYieldStop getControlYieldStop();

}
