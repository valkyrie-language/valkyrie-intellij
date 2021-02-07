// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePattern extends PsiElement {

  @Nullable
  ValkyrieModifiers getModifiers();

  @Nullable
  ValkyriePatternBrace getPatternBrace();

  @Nullable
  ValkyriePatternBracket getPatternBracket();

  @Nullable
  ValkyriePatternSequence getPatternSequence();

  @Nullable
  ValkyriePatternTuple getPatternTuple();

}
