// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

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
