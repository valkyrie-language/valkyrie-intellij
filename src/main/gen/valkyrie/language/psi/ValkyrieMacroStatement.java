// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMacroStatement extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @Nullable
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieModifiers getModifiers();

}
