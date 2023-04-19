// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTerm extends PsiElement {

    @NotNull
    ValkyrieLiteral getLiteral();

    @NotNull
    List<ValkyriePrefix> getPrefixList();

    @NotNull
    List<ValkyrieSuffix> getSuffixList();

}
