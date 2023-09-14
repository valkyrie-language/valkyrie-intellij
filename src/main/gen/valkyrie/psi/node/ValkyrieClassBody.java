// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieClassBody extends PsiElement {

    @NotNull
    List<ValkyrieAssociatedType> getAssociatedTypeList();

    @NotNull
    List<ValkyrieDeclareDomain> getDeclareDomainList();

    @NotNull
    List<ValkyrieDeclareField> getDeclareFieldList();

    @NotNull
    List<ValkyrieDeclareMethod> getDeclareMethodList();

}
