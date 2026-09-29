package valkyrie.ide.refactor

import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement
import com.intellij.refactoring.rename.RenameInputValidator
import com.intellij.util.ProcessingContext
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * Valkyrie 重命名输入验证器
 * 验证重命名时输入的新名称是否有效
 */
class ValkyrieRenameInputValidator : RenameInputValidator {
    
    override fun getPattern(): ElementPattern<out PsiElement> {
        return com.intellij.patterns.PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java)
    }
    
    override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
        // 检查新名称是否为空
        if (newName.isBlank()) {
            return false
        }
        
        // 检查是否为有效的标识符
        if (!isValidIdentifier(newName)) {
            return false
        }
        
        // 检查是否为关键字
        if (isKeyword(newName)) {
            return false
        }
        
        return true
    }
    
    /**
     * 检查是否为有效的标识符
     */
    private fun isValidIdentifier(name: String): Boolean {
        if (name.isEmpty()) return false
        
        // 第一个字符必须是字母或下划线
        if (!name[0].isLetter() && name[0] != '_') {
            return false
        }
        
        // 其余字符必须是字母、数字或下划线
        for (i in 1 until name.length) {
            val char = name[i]
            if (!char.isLetterOrDigit() && char != '_') {
                return false
            }
        }
        
        return true
    }
    
    /**
     * 检查是否为关键字
     */
    private fun isKeyword(name: String): Boolean {
        val keywords = setOf(
            "let", "const", "function", "class", "namespace", "import", "export",
            "if", "else", "match", "for", "while", "loop", "break", "continue",
            "return", "yield", "async", "await", "try", "catch", "finally",
            "true", "false", "null", "undefined", "this", "super",
            "public", "private", "protected", "static", "abstract", "final",
            "type", "interface", "trait", "enum", "struct", "union", "scope"
        )
        return keywords.contains(name)
    }
}