// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePatternAtomic extends PsiElement {

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieNumber getNumber();

    @Nullable
    ValkyriePatternType getPatternType();

    @Nullable
    ValkyrieSpecial getSpecial();

    @Nullable
    ValkyrieString getString();

}
