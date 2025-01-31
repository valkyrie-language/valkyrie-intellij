// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieSuffix extends PsiElement {

    @Nullable
    ValkyrieDotCall getDotCall();

    @Nullable
    ValkyrieDotCallFor getDotCallFor();

    @Nullable
    ValkyrieDotCallMatch getDotCallMatch();

    @Nullable
    ValkyrieGenericCall getGenericCall();

    @Nullable
    ValkyrieIsStatement getIsStatement();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
