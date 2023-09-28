// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieDeclareInfer extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @NotNull
    List<ValkyrieIdentifierSafe> getIdentifierSafeList();

    @Nullable
    ValkyrieInferBody getInferBody();

}
