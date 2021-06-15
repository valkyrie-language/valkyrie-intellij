// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.view.ValkyrieViewElement;

public interface ValkyrieClassBlock extends PsiElement {

  @NotNull
  List<ValkyrieClassDefine> getClassDefineList();

  @NotNull
  List<ValkyrieClassItem> getClassItemList();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  void addChildrenView(@NotNull List<ValkyrieViewElement> list);

}
