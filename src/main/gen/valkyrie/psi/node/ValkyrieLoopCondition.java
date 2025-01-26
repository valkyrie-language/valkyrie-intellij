// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieLoopCondition extends PsiElement {

    @Nullable
    ValkyrieLoopEach getLoopEach();

    @Nullable
    ValkyrieLoopMatch getLoopMatch();

    @Nullable
    ValkyrieLoopUntil getLoopUntil();

    @Nullable
    ValkyrieLoopUntilNot getLoopUntilNot();

    @Nullable
    ValkyrieLoopWhile getLoopWhile();

    @Nullable
    ValkyrieLoopWhileLet getLoopWhileLet();

}
