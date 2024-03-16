package valkyrie.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.*

/**
 * Valkyrie 代码折叠构建器
 * 支持折叠 union body, object body 等代码块
 */
class ValkyrieFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        
        // 遍历所有可折叠的元素
        PsiTreeUtil.processElements(root) { element ->
            when (element) {
                is ValkyrieUnionDeclaration -> {
                    // 折叠 union body
                    addUnionBodyFolding(element, descriptors)
                }
                is ValkyrieClassDeclaration -> {
                    // 折叠 class body (object body)
                    addClassBodyFolding(element, descriptors)
                }
                is ValkyrieTraitDeclaration -> {
                    // 折叠 trait body
                    addTraitBodyFolding(element, descriptors)
                }
                is ValkyrieDomainDeclaration -> {
                    // 折叠 domain body
                    addDomainBodyFolding(element, descriptors)
                }
                is ValkyrieMethodDeclaration -> {
                    // 折叠方法体
                    addMethodBodyFolding(element, descriptors)
                }
                is ValkyrieBlockStatementNode -> {
                    // 折叠代码块
                    addBlockFolding(element, descriptors)
                }
            }
            true
        }
        
        return descriptors.toTypedArray()
    }

    private fun addUnionBodyFolding(union: ValkyrieUnionDeclaration, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(union, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(union, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) { // 只有当内容不为空时才折叠
                descriptors.add(FoldingDescriptor(union.node, range))
            }
        }
    }

    private fun addClassBodyFolding(clazz: ValkyrieClassDeclaration, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(clazz, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(clazz, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(clazz.node, range))
            }
        }
    }

    private fun addTraitBodyFolding(trait: ValkyrieTraitDeclaration, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(trait, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(trait, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(trait.node, range))
            }
        }
    }

    private fun addDomainBodyFolding(domain: ValkyrieDomainDeclaration, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(domain, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(domain, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(domain.node, range))
            }
        }
    }

    private fun addMethodBodyFolding(method: ValkyrieMethodDeclaration, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(method, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(method, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(method.node, range))
            }
        }
    }

    private fun addBlockFolding(block: ValkyrieBlockStatementNode, descriptors: MutableList<FoldingDescriptor>) {
        val lbrace = findChildOfType(block, ValkyrieTokenTypes.BRACE_L)
        val rbrace = findChildOfType(block, ValkyrieTokenTypes.BRACE_R)
        
        if (lbrace != null && rbrace != null) {
            val range = TextRange(lbrace.textRange.startOffset, rbrace.textRange.endOffset)
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(block.node, range))
            }
        }
    }

    private fun findChildOfType(element: PsiElement, tokenType: com.intellij.psi.tree.IElementType): PsiElement? {
        return element.children.find { it.node.elementType == tokenType }
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        return when (node.elementType) {
            ValkyrieElementTypes.UNION_STATEMENT -> "{...}"
            ValkyrieElementTypes.CLASS_STATEMENT -> "{...}"
            ValkyrieElementTypes.TRAIT_STATEMENT -> "{...}"
            ValkyrieElementTypes.DOMAIN_DECLARATION -> "{...}"
            ValkyrieElementTypes.METHOD_DECLARATION -> "{...}"
            ValkyrieElementTypes.BLOCK_STATEMENT -> "{...}"
            else -> "{...}"
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        // 默认不折叠
        return false
    }
}