// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieTypeTerm extends PsiElement {

    @NotNull
    ValkyrieTypeAtomic getTypeAtomic();

    @NotNull
    List<ValkyrieTypePrefix> getTypePrefixList();

    @NotNull
    List<ValkyrieTypeSuffix> getTypeSuffixList();

}
