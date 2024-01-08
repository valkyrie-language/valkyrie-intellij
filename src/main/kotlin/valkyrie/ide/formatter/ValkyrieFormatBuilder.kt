package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 代码格式化构建器
 */
class ValkyrieFormatBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val element = formattingContext.psiElement
        val settings = formattingContext.codeStyleSettings
        val containingFile = formattingContext.containingFile
        
        val spacingBuilder = createSpacingBuilder(settings)
        val block = ValkyrieBlock(
            element.node,
            null,
            Indent.getNoneIndent(),
            null,
            spacingBuilder
        )
        
        return FormattingModelProvider.createFormattingModelForPsiFile(
            containingFile,
            block,
            settings
        )
    }
    
    private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
        return SpacingBuilder(settings, ValkyrieLanguage.INSTANCE)
            // 大括号前后的空格
            .before(ValkyrieTokenTypes.LBRACE).spaces(1)
            .after(ValkyrieTokenTypes.LBRACE).lineBreakInCode()
            .before(ValkyrieTokenTypes.RBRACE).lineBreakInCode()
            .after(ValkyrieTokenTypes.RBRACE).lineBreakInCode()
            
            // 冒号前后的空格
            .before(ValkyrieTokenTypes.COLON).spaces(0)
            .after(ValkyrieTokenTypes.COLON).spaces(1)
            
            // 逗号后的空格
            .after(ValkyrieTokenTypes.COMMA).spaces(1)
            
            // 操作符前后的空格
            .around(ValkyrieTokenTypes.ASSIGN).spaces(1)
            .around(ValkyrieTokenTypes.PLUS).spaces(1)
            .around(ValkyrieTokenTypes.MINUS).spaces(1)
            .around(ValkyrieTokenTypes.MULTIPLY).spaces(1)
            .around(ValkyrieTokenTypes.DIVIDE).spaces(1)
    }
    
    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }
}

/**
 * Valkyrie 格式化块
 */
class ValkyrieBlock(
    private val node: ASTNode,
    private val alignment: Alignment?,
    private val indent: Indent,
    private val wrap: Wrap?,
    private val spacingBuilder: SpacingBuilder
) : ASTBlock {
    
    override fun getNode(): ASTNode = node
    
    override fun getTextRange(): TextRange = node.textRange
    
    override fun getSubBlocks(): List<Block> {
        val blocks = mutableListOf<Block>()
        
        var child = node.firstChildNode
        while (child != null) {
            if (child.textLength > 0) {
                val childIndent = getChildIndent(child)
                val childAlignment = getChildAlignment(child)
                val childWrap = getChildWrap(child)
                
                blocks.add(
                    ValkyrieBlock(
                        child,
                        childAlignment,
                        childIndent,
                        childWrap,
                        spacingBuilder
                    )
                )
            }
            child = child.treeNext
        }
        
        return blocks
    }
    
    private fun getChildIndent(child: ASTNode): Indent {
        return when (child.elementType) {
            ValkyrieTokenTypes.LBRACE, ValkyrieTokenTypes.RBRACE -> Indent.getNoneIndent()
            else -> {
                when (node.elementType) {
                    ValkyrieElementTypes.OBJECT_BODY,
                    ValkyrieElementTypes.UNION_BODY,
                    ValkyrieElementTypes.VARIANT_BODY,
                    ValkyrieElementTypes.BLOCK_BODY,
                    ValkyrieElementTypes.DOMAIN_BODY -> Indent.getNormalIndent()
                    else -> Indent.getNoneIndent()
                }
            }
        }
    }
    
    private fun getChildAlignment(child: ASTNode): Alignment? {
        return when (node.elementType) {
            ValkyrieElementTypes.OBJECT_BODY -> {
                when (child.elementType) {
                    ValkyrieElementTypes.FIELD_DECLARATION,
                    ValkyrieElementTypes.METHOD_DECLARATION -> Alignment.createAlignment()
                    else -> null
                }
            }
            else -> null
        }
    }
    
    private fun getChildWrap(child: ASTNode): Wrap? {
        return null
    }
    
    override fun getWrap(): Wrap? = wrap
    
    override fun getIndent(): Indent = indent
    
    override fun getAlignment(): Alignment? = alignment
    
    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }
    
    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return when (node.elementType) {
            ValkyrieElementTypes.OBJECT_BODY,
            ValkyrieElementTypes.UNION_BODY,
            ValkyrieElementTypes.VARIANT_BODY,
            ValkyrieElementTypes.BLOCK_BODY,
            ValkyrieElementTypes.DOMAIN_BODY -> ChildAttributes(Indent.getNormalIndent(), null)
            else -> ChildAttributes(Indent.getNoneIndent(), null)
        }
    }
    
    override fun isIncomplete(): Boolean = false
    
    override fun isLeaf(): Boolean = node.firstChildNode == null
}