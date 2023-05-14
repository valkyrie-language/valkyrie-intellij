// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieControlStatement extends PsiElement {

    @Nullable
    ValkyrieControlBreak getControlBreak();

    @Nullable
    ValkyrieControlContinue getControlContinue();

    @Nullable
    ValkyrieControlRaise getControlRaise();

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
