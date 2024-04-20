package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Valkyrie语言注释器实现
 * 支持三种注释类型：
 * - 行注释: #
 * - 块注释: <# #> (可嵌套)
 * - 文档注释: ⍝
 */
class ValkyrieCommenter : CodeDocumentationAwareCommenter {
    
    /**
     * 行注释前缀
     */
    override fun getLineCommentPrefix(): String = "#"
    
    /**
     * 块注释开始标记
     */
    override fun getBlockCommentPrefix(): String = "<#"
    
    /**
     * 块注释结束标记
     */
    override fun getBlockCommentSuffix(): String = "#>"
    
    /**
     * 文档注释行前缀
     */
    override fun getCommentedBlockCommentPrefix(): String? = null
    
    /**
     * 文档注释行后缀
     */
    override fun getCommentedBlockCommentSuffix(): String? = null
    
    /**
     * 文档注释行前缀
     */
    override fun getDocumentationCommentPrefix(): String = "⍝"
    
    /**
     * 文档注释行后缀
     */
    override fun getDocumentationCommentSuffix(): String? = null
    
    /**
     * 文档注释行前缀
     */
    override fun getDocumentationCommentLinePrefix(): String = "⍝"
    
    /**
     * 判断是否为文档注释
     */
    override fun isDocumentationComment(element: PsiComment?): Boolean {
        return element?.tokenType == ValkyrieTypes.COMMENT_DOCUMENT
    }
    
    /**
     * 获取文档注释token类型
     */
    override fun getDocumentationCommentTokenType(): IElementType? {
        return ValkyrieTypes.COMMENT_DOCUMENT
    }
    
    override fun getLineCommentTokenType(): IElementType? {
        return ValkyrieTypes.COMMENT_LINE
    }
    
    override fun getBlockCommentTokenType(): IElementType? {
        return ValkyrieTypes.COMMENT_RANGE
    }
}