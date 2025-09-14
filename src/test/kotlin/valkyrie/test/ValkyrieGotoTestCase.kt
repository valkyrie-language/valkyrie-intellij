package valkyrie.test

import com.intellij.codeInsight.navigation.actions.GotoDeclarationAction
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import com.intellij.util.containers.toArray

/**
 * Valkyrie 跳转功能测试基类
 * 基于 JetBrains Goto 测试模式实现
 */
abstract class ValkyrieGotoTestCase : LightJavaCodeInsightFixtureTestCase() {
    
    override fun getTestDataPath(): String {
        return "src/test/resources/testData/goto"
    }
    
    /**
     * 测试 Go to Declaration 功能
     * @param fileName 测试文件名
     * @param caretMarker 光标位置标记（通常是 <caret>）
     * @param expectedTargetText 期望跳转到的目标文本
     */
    protected fun doGotoDeclarationTest(fileName: String, caretMarker: String = "<caret>", expectedTargetText: String? = null) {
        val psiFile = myFixture.configureByFile(fileName)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            myFixture.caretOffset
        )
        
        if (expectedTargetText != null) {
            assertTrue("Should find at least one target", targets.isNotEmpty())
            
            val targetFound = targets.any { target ->
                target.text?.contains(expectedTargetText) == true
            }
            
            assertTrue(
                "Should find target containing '$expectedTargetText'",
                targetFound
            )
        }
    }
    
    /**
     * 测试代码片段的 Go to Declaration
     * @param code 代码内容
     * @param caretOffset 光标位置偏移
     * @param expectedTargetCount 期望的目标数量
     */
    protected fun testGotoDeclaration(code: String, caretOffset: Int, expectedTargetCount: Int = 1) {
        val psiFile = myFixture.configureByText("test.vk", code)
        myFixture.editor.caretModel.moveToOffset(caretOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            caretOffset
        )
        
        assertEquals(
            "Should find $expectedTargetCount target(s) at offset $caretOffset",
            expectedTargetCount,
            targets.size
        )
    }
    
    /**
     * 测试变量声明跳转
     * @param declarationCode 包含变量声明的代码
     * @param usageCode 包含变量使用的代码
     * @param variableName 变量名
     */
    protected fun testVariableGoto(declarationCode: String, usageCode: String, variableName: String) {
        val fullCode = "$declarationCode\n$usageCode"
        val psiFile = myFixture.configureByText("test.vk", fullCode)
        
        // 找到变量使用位置
        val usageOffset = fullCode.indexOf(variableName, declarationCode.length)
        assertTrue("Variable usage should be found", usageOffset >= 0)
        
        myFixture.editor.caretModel.moveToOffset(usageOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            usageOffset
        )
        
        assertTrue("Should find declaration target", targets.isNotEmpty())
        
        // 验证目标是声明位置
        val declarationOffset = fullCode.indexOf(variableName)
        val targetFound = targets.any { target ->
            target.textOffset <= declarationOffset && 
            target.textOffset + target.textLength > declarationOffset
        }
        
        assertTrue("Should find declaration at correct position", targetFound)
    }
    
    /**
     * 测试函数声明跳转
     * @param declarationCode 包含函数声明的代码
     * @param callCode 包含函数调用的代码
     * @param functionName 函数名
     */
    protected fun testFunctionGoto(declarationCode: String, callCode: String, functionName: String) {
        val fullCode = "$declarationCode\n$callCode"
        val psiFile = myFixture.configureByText("test.vk", fullCode)
        
        // 找到函数调用位置
        val callOffset = fullCode.indexOf(functionName, declarationCode.length)
        assertTrue("Function call should be found", callOffset >= 0)
        
        myFixture.editor.caretModel.moveToOffset(callOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            callOffset
        )
        
        assertTrue("Should find function declaration target", targets.isNotEmpty())
        
        // 验证目标是函数声明位置
        val declarationOffset = fullCode.indexOf(functionName)
        val targetFound = targets.any { target ->
            target.textOffset <= declarationOffset && 
            target.textOffset + target.textLength > declarationOffset
        }
        
        assertTrue("Should find function declaration at correct position", targetFound)
    }
    
    /**
     * 测试类型声明跳转
     * @param declarationCode 包含类型声明的代码
     * @param usageCode 包含类型使用的代码
     * @param typeName 类型名
     */
    protected fun testTypeGoto(declarationCode: String, usageCode: String, typeName: String) {
        val fullCode = "$declarationCode\n$usageCode"
        val psiFile = myFixture.configureByText("test.vk", fullCode)
        
        // 找到类型使用位置
        val usageOffset = fullCode.indexOf(typeName, declarationCode.length)
        assertTrue("Type usage should be found", usageOffset >= 0)
        
        myFixture.editor.caretModel.moveToOffset(usageOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            usageOffset
        )
        
        assertTrue("Should find type declaration target", targets.isNotEmpty())
        
        // 验证目标是类型声明位置
        val declarationOffset = fullCode.indexOf(typeName)
        val targetFound = targets.any { target ->
            target.textOffset <= declarationOffset && 
            target.textOffset + target.textLength > declarationOffset
        }
        
        assertTrue("Should find type declaration at correct position", targetFound)
    }
    
    /**
     * 测试跨文件跳转
     * @param sourceFileName 源文件名
     * @param targetFileName 目标文件名
     * @param symbolName 符号名
     */
    protected fun testCrossFileGoto(sourceFileName: String, targetFileName: String, symbolName: String) {
        // 配置多个文件
        myFixture.configureByFiles(sourceFileName, targetFileName)
        
        // 在源文件中找到符号使用位置
        val sourceFile = myFixture.findFileInTempDir(sourceFileName)
        val sourceText = String(sourceFile.contentsToByteArray())
        val symbolOffset = sourceText.indexOf(symbolName)
        
        assertTrue("Symbol should be found in source file", symbolOffset >= 0)
        
        myFixture.openFileInEditor(sourceFile)
        myFixture.editor.caretModel.moveToOffset(symbolOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            symbolOffset
        )
        
        assertTrue("Should find cross-file target", targets.isNotEmpty())
        
        // 验证目标在正确的文件中
        val targetFound = targets.any { target ->
            target.containingFile?.name == targetFileName
        }
        
        assertTrue("Should find target in $targetFileName", targetFound)
    }
    
    /**
     * 测试无法跳转的情况
     * @param code 代码内容
     * @param caretOffset 光标位置
     */
    protected fun testNoGotoTarget(code: String, caretOffset: Int) {
        val psiFile = myFixture.configureByText("test.vk", code)
        myFixture.editor.caretModel.moveToOffset(caretOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            caretOffset
        )
        
        assertTrue(
            "Should not find any targets at offset $caretOffset",
            targets.isEmpty()
        )
    }
    
    /**
     * 打印跳转目标信息（用于调试）
     */
    protected fun printGotoTargets(code: String, caretOffset: Int) {
        val psiFile = myFixture.configureByText("test.vk", code)
        myFixture.editor.caretModel.moveToOffset(caretOffset)
        
        val targets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            caretOffset
        )
        
        println("Goto targets at offset $caretOffset:")
        for ((index, target) in targets.withIndex()) {
            println("  [$index] ${target.javaClass.simpleName} '${target.text}' in ${target.containingFile?.name}")
        }
    }
    
    /**
     * 辅助方法：在代码中查找标记位置
     * @param code 代码内容
     * @param marker 标记（如 <caret>）
     * @return 标记位置的偏移量
     */
    protected fun findMarkerOffset(code: String, marker: String = "<caret>"): Int {
        val offset = code.indexOf(marker)
        assertTrue("Marker '$marker' should be found in code", offset >= 0)
        return offset
    }
    
    /**
     * 辅助方法：移除代码中的标记
     * @param code 包含标记的代码
     * @param marker 要移除的标记
     * @return 移除标记后的代码
     */
    protected fun removeMarker(code: String, marker: String = "<caret>"): String {
        return code.replace(marker, "")
    }
}