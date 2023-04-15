// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieWhileStatement extends PsiElement {

    @NotNull
    List<ValkyrieAttribute> getAttributeList();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieInlineExpression getInlineExpression();

}
