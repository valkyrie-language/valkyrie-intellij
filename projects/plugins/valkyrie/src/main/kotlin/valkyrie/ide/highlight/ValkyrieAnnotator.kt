package valkyrie.ide.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.*

/**
 * Valkyrie 语言注解器
 * 用于提供语法错误检查和语义分析
 */
class ValkyrieAnnotator : Annotator {
    
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieIdentifierNode -> checkIdentifier(element, holder)
            is ValkyrieClassDeclaration -> checkClassDeclaration(element, holder)
            is ValkyrieUnionDeclaration -> checkUnionDeclaration(element, holder)
            is ValkyrieMethodDeclaration -> checkMethodDeclaration(element, holder)
            is ValkyrieFieldDeclaration -> checkFieldDeclaration(element, holder)
        }
    }
    
    /**
     * 检查标识符
     */
    private fun checkIdentifier(identifier: ValkyrieIdentifierNode, holder: AnnotationHolder) {
        val name = identifier.text
        
        // 检查标识符命名规范
        if (name.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "标识符不能为空")
                .range(identifier)
                .create()
            return
        }
        
        // 如果是raw identifier（以反引号包围），跳过字符检查
        if (identifier.isSpecialName()) {
            return
        }
        
        // 检查是否以数字开头
        if (name[0].isDigit()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "标识符不能以数字开头")
                .range(identifier)
                .create()
        }
        
        // 检查是否包含非法字符 - 支持Unicode XID字符
        if (!isValidIdentifier(name)) {
            holder.newAnnotation(HighlightSeverity.ERROR, "标识符包含非法字符")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查是否为有效的标识符（支持Unicode XID字符）
     */
    private fun isValidIdentifier(name: String): Boolean {
        if (name.isEmpty()) return false
        
        // 第一个字符必须是XID_Start字符或下划线
        val firstChar = name[0]
        if (!Character.isUnicodeIdentifierStart(firstChar) && firstChar != '_') {
            return false
        }
        
        // 其余字符必须是XID_Continue字符
        for (i in 1 until name.length) {
            val char = name[i]
            if (!Character.isUnicodeIdentifierPart(char)) {
                return false
            }
        }
        
        return true
    }
    
    /**
     * 检查类声明
     */
    private fun checkClassDeclaration(classDeclaration: ValkyrieClassDeclaration, holder: AnnotationHolder) {
        val nameIdentifier = classDeclaration.nameIdentifier
        if (nameIdentifier != null) {
            val className = nameIdentifier.text
            if (className.isNotEmpty() && !className[0].isUpperCase()) {
                holder.newAnnotation(HighlightSeverity.WARNING, "类名应该以大写字母开头")
                    .range(nameIdentifier)
                    .create()
            }
        }
    }
    
    /**
     * 检查联合类型声明
     */
    private fun checkUnionDeclaration(unionDeclaration: ValkyrieUnionDeclaration, holder: AnnotationHolder) {
        val nameIdentifier = unionDeclaration.nameIdentifier
        if (nameIdentifier != null) {
            val typeName = nameIdentifier.text
            if (typeName.isNotEmpty() && !typeName[0].isUpperCase()) {
                holder.newAnnotation(HighlightSeverity.WARNING, "类型名应该以大写字母开头")
                    .range(nameIdentifier)
                    .create()
            }
        }
    }
    
    /**
     * 检查方法声明
     */
    private fun checkMethodDeclaration(methodDeclaration: ValkyrieMethodDeclaration, holder: AnnotationHolder) {
        val nameIdentifier = methodDeclaration.nameIdentifier
        if (nameIdentifier != null) {
            val methodName = nameIdentifier.text
            if (methodName.isNotEmpty() && methodName[0].isUpperCase()) {
                holder.newAnnotation(HighlightSeverity.WARNING, "方法名应该以小写字母或下划线开头")
                    .range(nameIdentifier)
                    .create()
            }
        }
    }
    
    /**
     * 检查字段声明
     */
    private fun checkFieldDeclaration(fieldDeclaration: ValkyrieFieldDeclaration, holder: AnnotationHolder) {
        val nameIdentifier = fieldDeclaration.nameIdentifier
        if (nameIdentifier != null) {
            val fieldName = nameIdentifier.text
            if (fieldName.isNotEmpty() && fieldName[0].isUpperCase()) {
                holder.newAnnotation(HighlightSeverity.WARNING, "字段名应该以小写字母或下划线开头")
                    .range(nameIdentifier)
                    .create()
            }
        }
    }
}