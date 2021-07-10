// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassMethod extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @NotNull
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieModifiers getModifiers();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  //WARNING: getIdentifier(...) is skipped
  //matching getIdentifier(ValkyrieClassMethod, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieClassMethod, ...)
  //methods are not found in ASTMethods

}
