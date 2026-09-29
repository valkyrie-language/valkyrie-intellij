package valkyrie.ide.refactor

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.*

/**
 * Valkyrie 重构支持提供器
 * 提供各种重构操作的支持
 */
class ValkyrieRefactoringProvider : RefactoringSupportProvider() {
    
    /**
     * 是否支持安全删除
     */
    override fun isSafeDeleteAvailable(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieIdentifierNode -> true
            is ValkyrieClassDeclaration -> true
            is ValkyrieMethodDeclaration -> true
            is ValkyrieLetStatementNode -> true
            else -> false
        }
    }
    
    /**
     * 是否支持内联重构
     */
    override fun isInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return when (element) {
            is ValkyrieIdentifierNode -> true
            else -> false
        }
    }
    
    /**
     * 是否支持成员内联
     */
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return when (element) {
            is ValkyrieMethodDeclaration -> true
            is ValkyrieClassDeclaration -> true
            else -> false
        }
    }
    
    /**
     * 获取变量引入器
     */
    override fun getIntroduceVariableHandler(): com.intellij.refactoring.RefactoringActionHandler? {
        return null // 暂不实现
    }
    
    /**
     * 获取提取方法处理器
     */
    override fun getExtractMethodHandler(): com.intellij.refactoring.RefactoringActionHandler? {
        return null // 暂不实现
    }
}