// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTypeAtomic extends PsiElement {

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieNumberLiteral getNumberLiteral();

    @Nullable
    ValkyrieString getString();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

    @Nullable
    ValkyrieTypeTuple getTypeTuple();

}
