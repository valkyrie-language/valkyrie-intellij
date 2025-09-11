package valkyrie.ide.gutter

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*

/**
 * Valkyrie 效果分析器
 * 专门处理 raise 和 catch-case 的配对分析，这是 effect 分析的核心
 */
class ValkyrieEffectAnalyzer {

    /**
     * 效果类型定义
     */
    data class EffectType(
        val name: String,
        val hierarchy: List<String> = emptyList()
    )

    /**
     * 效果配对信息
     */
    data class EffectPair(
        val raiseElement: ValkyrieRaiseStatement,
        val catchElements: List<ValkyrieCatchCase>,
        val effectType: EffectType
    )

    /**
     * 分析函数中的所有效果配对
     */
    fun analyzeEffects(functionElement: PsiElement): List<EffectPair> {
        val effectPairs = mutableListOf<EffectPair>()
        
        // 查找所有 raise 语句
        val raiseStatements = PsiTreeUtil.findChildrenOfType(functionElement, ValkyrieRaiseStatement::class.java)
        
        for (raiseStatement in raiseStatements) {
            val effectType = extractEffectType(raiseStatement)
            val matchingCatches = findMatchingCatchCases(raiseStatement, effectType)
            
            if (matchingCatches.isNotEmpty()) {
                effectPairs.add(EffectPair(raiseStatement, matchingCatches, effectType))
            }
        }
        
        return effectPairs
    }

    /**
     * 从 raise 语句中提取效果类型
     */
    private fun extractEffectType(raiseStatement: ValkyrieRaiseStatement): EffectType {
        val expression = raiseStatement.getExpression()
        if (expression != null) {
            // 简化实现：从表达式文本中提取类型名
            val text = expression.text
            val typeName = extractTypeNameFromExpression(text)
            return EffectType(typeName)
        }
        return EffectType("UnknownEffect")
    }

    /**
     * 从表达式文本中提取类型名
     */
    private fun extractTypeNameFromExpression(expressionText: String): String {
        // 匹配构造函数调用模式，如 "IOException(\"message\")"
        val constructorPattern = Regex("(\\w+)\\s*\\(")
        val match = constructorPattern.find(expressionText)
        return match?.groupValues?.get(1) ?: "UnknownEffect"
    }

    /**
     * 查找与指定效果类型匹配的 catch case
     */
    private fun findMatchingCatchCases(raiseStatement: ValkyrieRaiseStatement, effectType: EffectType): List<ValkyrieCatchCase> {
        val matchingCatches = mutableListOf<ValkyrieCatchCase>()
        
        // 查找包含当前 raise 的函数或 try 块
        val containingScope = findContainingEffectScope(raiseStatement)
        if (containingScope != null) {
            val catchCases = PsiTreeUtil.findChildrenOfType(containingScope, ValkyrieCatchCase::class.java)
            
            for (catchCase in catchCases) {
                if (isMatchingCatch(catchCase, effectType)) {
                    matchingCatches.add(catchCase)
                }
            }
        }
        
        return matchingCatches
    }

    /**
     * 查找包含效果处理的作用域（函数或 try 块）
     */
    private fun findContainingEffectScope(element: PsiElement): PsiElement? {
        // 首先查找最近的 try 块
        var parent = element.parent
        while (parent != null) {
            if (parent.text.contains("try")) {
                return parent
            }
            parent = parent.parent
        }
        
        // 如果没有找到 try 块，查找包含的函数
        return PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
    }

    /**
     * 检查 catch case 是否匹配指定的效果类型
     */
    private fun isMatchingCatch(catchCase: ValkyrieCatchCase, effectType: EffectType): Boolean {
        val pattern = catchCase.getPattern()
        if (pattern != null) {
            val patternText = pattern.text
            
            // 检查是否是精确匹配
            if (patternText.contains(effectType.name)) {
                return true
            }
            
            // 检查是否是父类型匹配（简化实现）
            if (isParentTypeMatch(patternText, effectType)) {
                return true
            }
        }
        
        return false
    }

    /**
     * 检查是否是父类型匹配
     */
    private fun isParentTypeMatch(patternText: String, effectType: EffectType): Boolean {
        // 简化实现：检查常见的异常层次结构
        val commonParents = mapOf(
            "IOException" to listOf("Exception", "Error"),
            "FileNotFoundException" to listOf("IOException", "Exception", "Error"),
            "NetworkException" to listOf("IOException", "Exception", "Error"),
            "ValidationError" to listOf("Exception", "Error")
        )
        
        val parents = commonParents[effectType.name] ?: emptyList()
        return parents.any { parent -> patternText.contains(parent) }
    }

    /**
     * 查找与指定 catch case 相关的所有 raise 语句
     */
    fun findRelatedRaiseStatements(catchCase: ValkyrieCatchCase): List<ValkyrieRaiseStatement> {
        val relatedRaises = mutableListOf<ValkyrieRaiseStatement>()
        val catchEffectType = extractCatchEffectType(catchCase)
        
        // 查找包含当前 catch 的作用域
        val containingScope = findContainingEffectScope(catchCase)
        if (containingScope != null) {
            val raiseStatements = PsiTreeUtil.findChildrenOfType(containingScope, ValkyrieRaiseStatement::class.java)
            
            for (raiseStatement in raiseStatements) {
                val raiseEffectType = extractEffectType(raiseStatement)
                if (isEffectTypeCompatible(raiseEffectType, catchEffectType)) {
                    relatedRaises.add(raiseStatement)
                }
            }
        }
        
        return relatedRaises
    }

    /**
     * 从 catch case 中提取效果类型
     */
    private fun extractCatchEffectType(catchCase: ValkyrieCatchCase): EffectType {
        val pattern = catchCase.getPattern()
        if (pattern != null) {
            val patternText = pattern.text
            // 匹配模式如 "e: IOException" 或 "IOException"
            val typePattern = Regex("(?::\\s*)?(\\w+)")
            val match = typePattern.find(patternText)
            val typeName = match?.groupValues?.get(1) ?: "UnknownEffect"
            return EffectType(typeName)
        }
        return EffectType("UnknownEffect")
    }

    /**
     * 检查两个效果类型是否兼容
     */
    private fun isEffectTypeCompatible(raiseType: EffectType, catchType: EffectType): Boolean {
        // 精确匹配
        if (raiseType.name == catchType.name) {
            return true
        }
        
        // 父类型匹配
        return isParentTypeMatch(catchType.name, raiseType)
    }

    /**
     * 获取效果分析报告
     */
    fun generateEffectReport(functionElement: PsiElement): String {
        val effectPairs = analyzeEffects(functionElement)
        val report = StringBuilder()
        
        report.appendLine("Effect Analysis Report:")
        report.appendLine("=======================")
        
        if (effectPairs.isEmpty()) {
            report.appendLine("No effects found in this function.")
        } else {
            for ((index, pair) in effectPairs.withIndex()) {
                report.appendLine("Effect ${index + 1}:")
                report.appendLine("  Type: ${pair.effectType.name}")
                report.appendLine("  Raise at: line ${getLineNumber(pair.raiseElement)}")
                report.appendLine("  Caught by: ${pair.catchElements.size} catch case(s)")
                
                for (catchCase in pair.catchElements) {
                    report.appendLine("    - line ${getLineNumber(catchCase)}")
                }
                report.appendLine()
            }
        }
        
        return report.toString()
    }

    /**
     * 获取元素的行号（简化实现）
     */
    private fun getLineNumber(element: PsiElement): Int {
        // 简化实现：返回文本偏移量作为行号的近似值
        return element.textOffset / 50 + 1
    }
}