// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTopBlock extends PsiElement {

  @NotNull
  List<ValkyrieBitflagStatement> getBitflagStatementList();

  @NotNull
  List<ValkyrieClassStatement> getClassStatementList();

  @NotNull
  List<ValkyrieDefineStatement> getDefineStatementList();

  @NotNull
  List<ValkyrieExtendsStatement> getExtendsStatementList();

  @NotNull
  List<ValkyrieExtensionStatement> getExtensionStatementList();

  @NotNull
  List<ValkyrieImportStatement> getImportStatementList();

  @NotNull
  List<ValkyrieNamespaceStatement> getNamespaceStatementList();

  @NotNull
  List<ValkyrieTraitStatement> getTraitStatementList();

  @NotNull
  List<ValkyrieUnionStatement> getUnionStatementList();

}
