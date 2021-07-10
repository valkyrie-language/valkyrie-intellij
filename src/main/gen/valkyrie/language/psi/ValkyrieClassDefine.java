// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.language.psi_node.ValkyrieIdentifierNode;

public interface ValkyrieClassDefine extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @Nullable
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieModified getModified();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  @NotNull
  ValkyrieIdentifierNode getIdentifier();

  @NotNull
  ValkyrieIdentifierNode[] getModifiers();

}
