// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieFlagsBody extends PsiElement {

    @NotNull
    List<ValkyrieDeclareDomain> getDeclareDomainList();

    @NotNull
    List<ValkyrieDeclareMethod> getDeclareMethodList();

    @NotNull
    List<ValkyrieFlagsNumber> getFlagsNumberList();

}
