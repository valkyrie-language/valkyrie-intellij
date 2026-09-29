package vos.intellij.ide.matcher

import vos.intellij.language.psi.VosTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(VosTypes.STRING)
