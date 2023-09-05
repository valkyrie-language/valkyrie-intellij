// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
