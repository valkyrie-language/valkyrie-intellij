// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieEnumerateBody extends PsiElement {

    @NotNull
    List<ValkyrieDeclareDomain> getDeclareDomainList();

    @NotNull
    List<ValkyrieDeclareMethod> getDeclareMethodList();

    @NotNull
    List<ValkyrieDeclareSemantic> getDeclareSemanticList();

}
