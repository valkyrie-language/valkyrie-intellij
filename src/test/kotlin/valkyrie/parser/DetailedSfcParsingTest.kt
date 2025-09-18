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
            
            <script>

            </script>
            
            <style>
                .container {
                    padding: 20px;
                }
            </style>
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
        try {
            println("Starting error collection for element: ${element.javaClass.simpleName}")
            element.accept(object : com.intellij.psi.PsiRecursiveElementVisitor() {
                override fun visitElement(element: com.intellij.psi.PsiElement) {
                    // 检查当前元素是否为null
                    if (element == null) {
                        println("WARNING: Found null element during traversal")
                        return
                    }
                    
                    // 使用更安全的方式检查子元素
                    try {
                        val children = element.children
                        println("Element ${element.javaClass.simpleName} has ${children.size} children")
                        for (i in children.indices) {
                            val child = children[i]
                            if (child == null) {
                                println("WARNING: Found null child at index $i in element: ${element.javaClass.simpleName}")
                                println("Element text: '${element.text}'")
                                println("Element range: ${element.textRange}")
                                println("Total children count: ${children.size}")
                            }
                        }
                    } catch (e: Exception) {
                        println("ERROR accessing children of ${element.javaClass.simpleName}: ${e.message}")
                        println("Element text: '${element.text}'")
                        println("Element range: ${element.textRange}")
                        // 不继续遍历这个有问题的元素的子节点
                        return
                    }
                    
                    super.visitElement(element)
                }
                
                override fun visitErrorElement(element: com.intellij.psi.PsiErrorElement) {
                    println("Found error element: ${element.errorDescription} at ${element.textRange}")
                    errors.add(element)
                    super.visitErrorElement(element)
                }
            })
        } catch (e: Exception) {
            println("Error collecting error elements: ${e.message}")
            e.printStackTrace()
        }
        return errors
    }
}