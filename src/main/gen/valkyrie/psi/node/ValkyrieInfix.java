// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieInfix extends PsiElement {

    @Nullable
    ValkyrieBadLl getBadLl();

    @Nullable
    ValkyrieBadLll getBadLll();

    @Nullable
    ValkyrieBadRr getBadRr();

    @Nullable
    ValkyrieBadRrr getBadRrr();

    @Nullable
    ValkyrieInfixGreater getInfixGreater();

    @Nullable
    ValkyrieInfixGreaterEqual getInfixGreaterEqual();

    @Nullable
    ValkyrieInfixLess getInfixLess();

    @Nullable
    ValkyrieInfixLessEqual getInfixLessEqual();

    @Nullable
    ValkyrieInfixLogical getInfixLogical();

    @Nullable
    ValkyrieInfixMultiple getInfixMultiple();

}
