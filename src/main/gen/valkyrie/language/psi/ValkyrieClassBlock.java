// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.view.ValkyrieViewElement;

public interface ValkyrieClassBlock extends PsiElement {

  @NotNull
  List<ValkyrieClassField> getClassFieldList();

  @NotNull
  List<ValkyrieClassMethod> getClassMethodList();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  @NotNull
  List<ValkyrieTypeStatement> getTypeStatementList();

  void addChildrenView(@NotNull List<ValkyrieViewElement> list);

}
