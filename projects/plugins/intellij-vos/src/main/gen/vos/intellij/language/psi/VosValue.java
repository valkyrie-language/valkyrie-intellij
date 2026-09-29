// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VosValue extends PsiElement {

  @Nullable
  VosArray getArray();

  @Nullable
  VosBoolean getBoolean();

  @Nullable
  VosNamespace getNamespace();

  @Nullable
  VosNull getNull();

  @Nullable
  VosObject getObject();

  @Nullable
  VosStringLiteral getStringLiteral();

  @Nullable
  VosUrlMaybeValid getUrlMaybeValid();

}
