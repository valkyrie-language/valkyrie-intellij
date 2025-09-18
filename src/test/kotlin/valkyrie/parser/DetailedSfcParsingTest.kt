package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieSfcParserDefinition

class DetailedSfcParsingTest : ParsingTestCase("", "vkc", ValkyrieSfcParserDefinition()) {
    
    override fun getTestDataPath(): String = "src/test/resources"

    fun testDetailedSfcStructure() {
        val code = """
<template>
    <div class="container">
        <h1>{{ title }}</h1>
        <p>Hello World</p>
    </div>
</template>
<style>
    .container {
        padding: 20px;
    }
</style>
<script>

</script>
        """.trimIndent()
        
        val psiFile = createPsiFile("detailed_test.vkc", code)
        println("=== Detailed PSI Tree Structure ===")
        println(toParseTreeText(psiFile, true, true))
        
        // 验证根节点是 Valkyrie Component File
        assertEquals("Valkyrie Component File", psiFile.node.elementType.toString())
        
        // 收集并显示所有错误
        try {
            val errors = collectErrorElements(psiFile)
            println("=== Error Analysis ===")
            println("Total errors found: ${errors.size}")
            errors.forEachIndexed { index, error ->
                println("Error $index: ${error.errorDescription}")
                println("  Text: '${error.text}'")
                println("  Range: ${error.textRange}")
                println("  Parent: ${error.parent?.javaClass?.simpleName}")
            }
            
            if (errors.isNotEmpty()) {
                fail("Found ${errors.size} parsing errors - see output for details")
            }
        } catch (e: Exception) {
            println("Error collecting error elements: ${e.message}")
            e.printStackTrace()
        }
    }
    
    private fun collectErrorElements(element: com.intellij.psi.PsiElement): List<com.intellij.psi.PsiErrorElement> {
        val errors = mutableListOf<com.intellij.psi.PsiErrorElement>()
        println("Starting error collection for element: ${element.javaClass.simpleName}")

        try {
            element.accept(object : com.intellij.psi.PsiRecursiveElementVisitor() {
                override fun visitElement(element: com.intellij.psi.PsiElement) {
                    println("Visiting element: ${element.javaClass.simpleName} - ${element.node?.elementType}")
                    
                    if (element is com.intellij.psi.PsiErrorElement) {
                        println("Found error element: ${element.errorDescription}")
                        errors.add(element)
                    }
                    
                    // 安全地访问子元素
                    try {
                        val children = element.children
                        println("Element has ${children.size} children")
                        for (child in children) {
                            if (child != null) {
                                child.accept(this)
                            } else {
                                println("WARNING: Found null child in element: ${element.javaClass.simpleName}")
                            }
                        }
                    } catch (e: Exception) {
                        println("ERROR accessing children of ${element.javaClass.simpleName}: ${e.message}")
                        // 不要重新抛出异常，继续处理其他元素
                    }
                }
            })
        } catch (e: Exception) {
            println("ERROR during error collection: ${e.message}")
            e.printStackTrace()
        }

        return errors
    }
}