package valkyrie.ide.codevision

import com.intellij.codeInsight.codeVision.*
import com.intellij.codeInsight.codeVision.ui.model.ClickableTextCodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider
import com.intellij.find.actions.ShowUsagesAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.nodes.ValkyrieUnionDeclaration

/**
 * Valkyrie Code Vision Provider
 * 为类、方法等声明显示引用数
 */
class ValkyrieCodeVisionProvider : CodeVisionProvider<Unit> {
    
    companion object {
        const val ID = "valkyrie.usages"
        const val GROUP_ID = "valkyrie.references"
    }
    
    override val defaultAnchor: CodeVisionAnchorKind = CodeVisionAnchorKind.Top
    
    override val id: String = ID
    
    override val name: String = "Valkyrie Usages"
    
    override val relativeOrderings: List<CodeVisionRelativeOrdering> = emptyList()
    
    override val groupId: String = GROUP_ID
    
    override fun precomputeOnUiThread(editor: Editor): Unit = Unit
    
    override fun computeCodeVision(editor: Editor, uiData: Unit): CodeVisionState {
        val file = editor.document.let { document ->
            com.intellij.psi.PsiDocumentManager.getInstance(editor.project ?: return CodeVisionState.READY_EMPTY)
                .getPsiFile(document)
        } ?: return CodeVisionState.READY_EMPTY
        
        val entries = computeForFile(file)
        return if (entries.isEmpty()) {
            CodeVisionState.READY_EMPTY
        } else {
            CodeVisionState.Ready(entries)
        }
    }
    
    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {
        // 点击时显示查找使用处窗口
        val file = com.intellij.psi.PsiDocumentManager.getInstance(editor.project ?: return)
            .getPsiFile(editor.document) ?: return
            
        val element = file.findElementAt(textRange.startOffset) ?: return
        val declaration = PsiTreeUtil.getParentOfType(
            element,
            ValkyrieClassDeclaration::class.java,
            ValkyrieMethodDeclaration::class.java,
            ValkyrieTraitDeclaration::class.java,
            ValkyrieUnionDeclaration::class.java
        ) ?: return
        
        // 触发查找使用处
        val dataContext = com.intellij.openapi.actionSystem.impl.SimpleDataContext.getProjectContext(editor.project!!)
        val event = com.intellij.openapi.actionSystem.AnActionEvent.createFromDataContext(
            "",
            null,
            dataContext
        )
        ShowUsagesAction().actionPerformed(event)
    }
    
    override fun preparePreview(editor: Editor, file: PsiFile): Unit = Unit
    
    private fun computeForFile(file: PsiFile): List<Pair<TextRange, CodeVisionEntry>> {
        val result = mutableListOf<Pair<TextRange, CodeVisionEntry>>()
        
        // 查找所有类声明
        PsiTreeUtil.findChildrenOfType(file, ValkyrieClassDeclaration::class.java).forEach { classDecl ->
            val usageCount = countUsages(classDecl)
            if (usageCount > 0) {
                val range = getDeclarationRange(classDecl)
                val entry = createUsageEntry(usageCount, "usage")
                result.add(range to entry)
            }
        }
        
        // 查找所有方法声明
        PsiTreeUtil.findChildrenOfType(file, ValkyrieMethodDeclaration::class.java).forEach { methodDecl ->
            val usageCount = countUsages(methodDecl)
            if (usageCount > 0) {
                val range = getDeclarationRange(methodDecl)
                val entry = createUsageEntry(usageCount, "usage")
                result.add(range to entry)
            }
        }
        
        // 查找所有trait声明
        PsiTreeUtil.findChildrenOfType(file, ValkyrieTraitDeclaration::class.java).forEach { traitDecl ->
            val usageCount = countUsages(traitDecl)
            if (usageCount > 0) {
                val range = getDeclarationRange(traitDecl)
                val entry = createUsageEntry(usageCount, "usage")
                result.add(range to entry)
            }
        }
        
        // 查找所有union声明
        PsiTreeUtil.findChildrenOfType(file, ValkyrieUnionDeclaration::class.java).forEach { unionDecl ->
            val usageCount = countUsages(unionDecl)
            if (usageCount > 0) {
                val range = getDeclarationRange(unionDecl)
                val entry = createUsageEntry(usageCount, "usage")
                result.add(range to entry)
            }
        }
        
        return result
    }
    
    private fun countUsages(element: PsiElement): Int {
        return try {
            // 使用异步搜索避免阻塞UI
            val searchScope = com.intellij.psi.search.GlobalSearchScope.projectScope(element.project)
            val query = ReferencesSearch.search(element, searchScope)
            
            // 限制搜索结果数量以提高性能
            val references = query.findAll()
            
            // 过滤掉自身声明
            references.count { reference ->
                val refElement = reference.element
                // 排除自身声明：不同文件或者同文件但不同位置
                refElement != element && (
                    refElement.containingFile != element.containingFile ||
                    refElement.textOffset != element.textOffset
                )
            }
        } catch (e: Exception) {
            // 如果搜索失败，返回0
            0
        }
    }
    
    private fun getDeclarationRange(element: PsiElement): TextRange {
        val nameIdentifier = when (element) {
            is ValkyrieClassDeclaration -> element.nameIdentifier
            is ValkyrieMethodDeclaration -> element.nameIdentifier
            is ValkyrieTraitDeclaration -> element.nameIdentifier
            is ValkyrieUnionDeclaration -> element.nameIdentifier
            else -> null
        }
        
        return nameIdentifier?.textRange ?: element.textRange
    }
    
    private fun createUsageEntry(count: Int, type: String): CodeVisionEntry {
        val text = if (count == 1) "1 $type" else "$count ${type}s"
        return ClickableTextCodeVisionEntry(
            text = text,
            providerId = id,
            onClick = { _, _ -> }
        )
    }
}

/**
 * Code Vision 设置提供者
 */
class ValkyrieCodeVisionGroupSettingProvider : CodeVisionGroupSettingProvider {
    override val groupId: String = ValkyrieCodeVisionProvider.GROUP_ID
    override val description: String = "Show usage count for Valkyrie declarations"
    override val groupName: String = "Valkyrie"
}