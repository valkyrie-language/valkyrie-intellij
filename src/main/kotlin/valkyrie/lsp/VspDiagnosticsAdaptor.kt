package valkyrie.lsp

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.platform.lsp.api.customization.LspDiagnosticsSupport
import org.eclipse.lsp4j.Diagnostic

class VspDiagnosticsAdaptor : LspDiagnosticsSupport() {
    override fun getHighlightSeverity(diagnostic: Diagnostic): HighlightSeverity? {
        return super.getHighlightSeverity(diagnostic)
    }

    override fun getSpecialHighlightType(diagnostic: Diagnostic): ProblemHighlightType? {
        return super.getSpecialHighlightType(diagnostic)
    }

    override fun getTooltip(diagnostic: Diagnostic): String {
        return super.getTooltip(diagnostic)
    }

    override fun createAnnotation(holder: AnnotationHolder, diagnostic: Diagnostic, textRange: TextRange, quickFixes: List<IntentionAction>) {
        super.createAnnotation(holder, diagnostic, textRange, quickFixes)
    }

    override fun getMessage(diagnostic: Diagnostic): String {
        return super.getMessage(diagnostic)
    }
}