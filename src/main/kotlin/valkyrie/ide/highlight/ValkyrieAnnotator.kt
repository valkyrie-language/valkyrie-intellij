package valkyrie.ide.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.*

/**
 * Valkyrie 语言注解器
 * 用于提供语法错误检查和语义分析
 */
class ValkyrieAnnotator : Annotator {
    
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieIdentifier -> checkIdentifier(element, holder)
            is ValkyrieLetStatement -> checkLetStatement(element, holder)
            is ValkyrieClassStatement -> checkClassStatement(element, holder)
            is ValkyrieUnionStatement -> checkUnionStatement(element, holder)
            is ValkyrieFunctionStatement -> checkFunctionStatement(element, holder)
            is ValkyrieMethodDeclaration -> checkMethodDeclaration(element, holder)
            is ValkyrieFieldDeclaration -> checkFieldDeclaration(element, holder)
            is ValkyrieParameter -> checkParameter(element, holder)
            is ValkyrieExpression -> checkExpression(element, holder)
        }
    }
    
    /**
     * 检查标识符
     */
    private fun checkIdentifier(identifier: ValkyrieIdentifier, holder: AnnotationHolder) {
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
     * 检查let语句
     */
    private fun checkLetStatement(letStatement: ValkyrieLetStatement, holder: AnnotationHolder) {
        // 检查是否有变量名
        val identifier = PsiTreeUtil.findChildOfType(letStatement, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "let语句缺少变量名")
                .range(letStatement)
                .create()
            return
        }
        
        // 检查是否有初始化表达式或类型注解
        val hasInitializer = PsiTreeUtil.findChildOfType(letStatement, ValkyrieExpression::class.java) != null
        val hasTypeAnnotation = letStatement.text.contains(":")
        
        if (!hasInitializer && !hasTypeAnnotation) {
            holder.newAnnotation(HighlightSeverity.ERROR, "let语句必须有初始化表达式或类型注解")
                .range(letStatement)
                .create()
        }
    }
    
    /**
     * 检查类声明
     */
    private fun checkClassStatement(classStatement: ValkyrieClassStatement, holder: AnnotationHolder) {
        // 检查类名
        val identifier = PsiTreeUtil.findChildOfType(classStatement, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "类声明缺少类名")
                .range(classStatement)
                .create()
            return
        }
        
        // 检查类名是否符合命名规范（首字母大写）
        val className = identifier.text
        if (className.isNotEmpty() && !className[0].isUpperCase()) {
            holder.newAnnotation(HighlightSeverity.WARNING, "类名应该以大写字母开头")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查联合类型声明
     */
    private fun checkUnionStatement(unionStatement: ValkyrieUnionStatement, holder: AnnotationHolder) {
        // 检查联合类型名
        val identifier = PsiTreeUtil.findChildOfType(unionStatement, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "联合类型声明缺少类型名")
                .range(unionStatement)
                .create()
            return
        }
        
        // 检查类型名是否符合命名规范（首字母大写）
        val typeName = identifier.text
        if (typeName.isNotEmpty() && !typeName[0].isUpperCase()) {
            holder.newAnnotation(HighlightSeverity.WARNING, "类型名应该以大写字母开头")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查函数声明
     */
    private fun checkFunctionStatement(functionStatement: ValkyrieFunctionStatement, holder: AnnotationHolder) {
        // 检查函数名
        val identifier = PsiTreeUtil.findChildOfType(functionStatement, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "函数声明缺少函数名")
                .range(functionStatement)
                .create()
            return
        }
        
        // 检查函数名是否符合命名规范（小写字母或下划线开头）
        val functionName = identifier.text
        if (functionName.isNotEmpty() && functionName[0].isUpperCase()) {
            holder.newAnnotation(HighlightSeverity.WARNING, "函数名应该以小写字母或下划线开头")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查方法声明
     */
    private fun checkMethodDeclaration(methodDeclaration: ValkyrieMethodDeclaration, holder: AnnotationHolder) {
        // 检查方法名
        val identifier = PsiTreeUtil.findChildOfType(methodDeclaration, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "方法声明缺少方法名")
                .range(methodDeclaration)
                .create()
            return
        }
        
        // 检查方法名是否符合命名规范
        val methodName = identifier.text
        if (methodName.isNotEmpty() && methodName[0].isUpperCase()) {
            holder.newAnnotation(HighlightSeverity.WARNING, "方法名应该以小写字母或下划线开头")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查字段声明
     */
    private fun checkFieldDeclaration(fieldDeclaration: ValkyrieFieldDeclaration, holder: AnnotationHolder) {
        // 检查字段名
        val identifier = PsiTreeUtil.findChildOfType(fieldDeclaration, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "字段声明缺少字段名")
                .range(fieldDeclaration)
                .create()
            return
        }
        
        // 检查字段名是否符合命名规范
        val fieldName = identifier.text
        if (fieldName.isNotEmpty() && fieldName[0].isUpperCase()) {
            holder.newAnnotation(HighlightSeverity.WARNING, "字段名应该以小写字母或下划线开头")
                .range(identifier)
                .create()
        }
    }
    
    /**
     * 检查参数
     */
    private fun checkParameter(parameter: ValkyrieParameter, holder: AnnotationHolder) {
        // 检查参数名
        val identifier = PsiTreeUtil.findChildOfType(parameter, ValkyrieIdentifier::class.java)
        if (identifier == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "参数缺少参数名")
                .range(parameter)
                .create()
            return
        }
        
        // 检查是否有类型注解
        if (!parameter.text.contains(":")) {
            holder.newAnnotation(HighlightSeverity.WARNING, "参数建议添加类型注解")
                .range(parameter)
                .create()
        }
    }
    
    /**
     * 检查表达式
     */
    private fun checkExpression(expression: ValkyrieExpression, holder: AnnotationHolder) {
        // 检查除零错误
        if (expression.text.contains("/") && expression.text.contains("0")) {
            val parts = expression.text.split("/")
            if (parts.size == 2 && parts[1].trim() == "0") {
                holder.newAnnotation(HighlightSeverity.ERROR, "除零错误")
                    .range(expression)
                    .create()
            }
        }
        
        // 检查未使用的变量（简单检查）
        if (expression.text.startsWith("let ") && !expression.text.contains("=")) {
            holder.newAnnotation(HighlightSeverity.WARNING, "变量声明后未使用")
                .range(expression)
                .create()
        }
    }
}