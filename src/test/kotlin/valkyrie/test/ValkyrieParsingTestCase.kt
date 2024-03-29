package valkyrie.test

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieParser
import java.io.File
import org.junit.Assert.*
import kotlin.test.fail

/**
 * Valkyrie 解析测试基类
 * 基于 JetBrains ParsingTestCase 模式实现 <mcreference link="https://plugins.jetbrains.com/docs/intellij/parsing-test.html" index="1">1</mcreference>
 */
abstract class ValkyrieParsingTestCase(
    testDataSubPath: String = "",
    fileExtension: String = "vk"
) : ParsingTestCase(testDataSubPath, fileExtension, ValkyrieParserDefinition()) {
    
    override fun getTestDataPath(): String {
        return "src/test/resources/testData"
    }
    
    /**
     * 执行解析测试
     * @param checkResult 是否检查解析结果
     */
    protected fun doParsingTest(checkResult: Boolean = true) {
        doTest(checkResult)
    }
    
    /**
     * 测试代码片段的解析
     * @param code 要解析的代码
     * @param expectedNoErrors 是否期望没有解析错误
     */
    protected fun testCodeParsing(code: String, expectedNoErrors: Boolean = true) {
        // 创建临时测试文件
        val testFile = createTempFile("test", ".vk")
        testFile.writeText(code)
        
        try {
            // 使用 doTest 方法进行解析测试
            doTest(true)
        } catch (e: Exception) {
            if (expectedNoErrors) {
                fail("Parsing failed for code: $code. Error: ${e.message}")
            }
        } finally {
            testFile.delete()
        }
    }
    
    /**
     * 检查 PSI 文件中是否有错误元素
     */
    private fun assertNoErrorElements(psiFile: PsiFile) {
        val errorElements = mutableListOf<PsiElement>()
        collectErrorElements(psiFile, errorElements)
        
        if (errorElements.isNotEmpty()) {
            val errorMessages = errorElements.map { "Error at ${it.textRange}: ${it.text}" }
            fail("Found ${errorElements.size} error elements:\n${errorMessages.joinToString("\n")}")
        }
    }
    
    /**
     * 递归收集错误元素
     */
    private fun collectErrorElements(element: PsiElement, errorElements: MutableList<PsiElement>) {
        if (element.node?.elementType?.toString()?.contains("ERROR") == true) {
            errorElements.add(element)
        }
        
        for (child in element.children) {
            collectErrorElements(child, errorElements)
        }
    }
    
    /**
     * 打印 PSI 树结构（用于调试）
     */
    protected fun printPsiTree(element: PsiElement, indent: String = "") {
        println("$indent${element.javaClass.simpleName}: '${element.text.replace("\n", "\\n")}'")
        for (child in element.children) {
            printPsiTree(child, "$indent  ")
        }
    }
    
    /**
     * 验证特定的 PSI 元素类型存在
     */
    protected fun assertContainsPsiElementType(psiFile: PsiFile, elementClass: Class<out PsiElement>) {
        val found = findPsiElementsOfType(psiFile, elementClass)
        assertTrue(
            "Should contain at least one element of type ${elementClass.simpleName}",
            found.isNotEmpty()
        )
    }
    
    /**
     * 查找指定类型的 PSI 元素
     */
    private fun <T : PsiElement> findPsiElementsOfType(element: PsiElement, elementClass: Class<T>): List<T> {
        val result = mutableListOf<T>()
        
        if (elementClass.isInstance(element)) {
            @Suppress("UNCHECKED_CAST")
            result.add(element as T)
        }
        
        for (child in element.children) {
            result.addAll(findPsiElementsOfType(child, elementClass))
        }
        
        return result
    }
}