package valkyrie.ide.intention

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieIfStatementNode
import valkyrie.psi.nodes.ValkyrieIfLetStatementNode
import valkyrie.psi.parsers.ValkyrieFactory

/**
 * 将 if 语句转换为 match 表达式的意图动作
 */
class ConvertIfToMatchIntention : PsiElementBaseIntentionAction(), IntentionAction {
    
    override fun getText(): String = "Convert if statement to match expression"
    
    override fun getFamilyName(): String = "Valkyrie refactoring"
    
    override fun isAvailable(project: Project, editor: Editor?, element: PsiElement): Boolean {
        // 检查当前元素是否在 if 语句中
        val ifStatement = PsiTreeUtil.getParentOfType(element, ValkyrieIfStatementNode::class.java)
        val ifLetStatement = PsiTreeUtil.getParentOfType(element, ValkyrieIfLetStatementNode::class.java)
        
        return ifStatement != null || ifLetStatement != null
    }
    
    override fun invoke(project: Project, editor: Editor?, element: PsiElement) {
        val ifStatement = PsiTreeUtil.getParentOfType(element, ValkyrieIfStatementNode::class.java)
        val ifLetStatement = PsiTreeUtil.getParentOfType(element, ValkyrieIfLetStatementNode::class.java)
        
        when {
            ifStatement != null -> convertIfStatement(project, ifStatement)
            ifLetStatement != null -> convertIfLetStatement(project, ifLetStatement)
        }
    }
    
    /**
     * 转换普通 if 语句为 match 表达式
     */
    private fun convertIfStatement(project: Project, ifStatement: ValkyrieIfStatementNode) {
        val condition = ifStatement.getCondition()?.text ?: "condition"
        val thenBlock = ifStatement.getThenBlock()?.text ?: "{ }"
        val elseClause = ifStatement.getFinalElseClause()
        
        val matchText = if (elseClause != null) {
            val elseBlock = elseClause.getBlock()?.text ?: "{ }"
            "match $condition {\n    true => $thenBlock,\n    false => $elseBlock\n}"
        } else {
            "match $condition {\n    true => $thenBlock,\n    false => { }\n}"
        }
        
        val factory = ValkyrieFactory.getInstance(project)
        val matchExpression = factory.createExpressionFromText(matchText, project)
        
        if (matchExpression != null) {
            ifStatement.replace(matchExpression)
        }
    }
    
    /**
     * 转换 if let 语句为 match 表达式
     */
    private fun convertIfLetStatement(project: Project, ifLetStatement: ValkyrieIfLetStatementNode) {
        val pattern = ifLetStatement.getPattern()?.text ?: "pattern"
        val expression = ifLetStatement.getMatchExpression()?.text ?: "expression"
        val thenBlock = ifLetStatement.getThenBlock()?.text ?: "{ }"
        val elseClause = ifLetStatement.getElseClause()
        
        val matchText = if (elseClause != null) {
            val elseBlock = elseClause.getBlock()?.text ?: "{ }"
            "match $expression {\n    $pattern => $thenBlock,\n    _ => $elseBlock\n}"
        } else {
            "match $expression {\n    $pattern => $thenBlock,\n    _ => { }\n}"
        }
        
        val factory = ValkyrieFactory.getInstance(project)
        val matchExpression = factory.createExpressionFromText(matchText, project)
        
        if (matchExpression != null) {
            ifLetStatement.replace(matchExpression)
        }
    }
}