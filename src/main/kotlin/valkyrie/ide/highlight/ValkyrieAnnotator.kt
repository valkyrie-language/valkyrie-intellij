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
        
        // 检查是否以数字开头
        if (name[0].isDigit()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "标识符不能以数字开头")
                .range(identifier)
                .create()
        }
        
        // 检查是否包含非法字符
        if (!name.matches(Regex("[a-zA-Z_][a-zA-Z0-9_]*"))) {
            holder.newAnnotation(HighlightSeverity.ERROR, "标识符包含非法字符")
                .range(identifier)
                .create()
        }
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