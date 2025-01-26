// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieTerm extends PsiElement {

    @NotNull
    ValkyrieAtomic getAtomic();

    @NotNull
    List<ValkyriePrefix> getPrefixList();

    @NotNull
    List<ValkyrieSuffix> getSuffixList();

}
