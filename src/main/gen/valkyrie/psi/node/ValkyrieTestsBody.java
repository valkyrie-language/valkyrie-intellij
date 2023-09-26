// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieTestsBody extends PsiElement {

    @NotNull
    List<ValkyrieDeclareTests> getDeclareTestsList();

    @NotNull
    List<ValkyrieRunBenchmark> getRunBenchmarkList();

    @NotNull
    List<ValkyrieRunTestCast> getRunTestCastList();

}
