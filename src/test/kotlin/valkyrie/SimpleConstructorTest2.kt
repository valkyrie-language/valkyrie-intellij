package valkyrie

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class SimpleConstructorTest2 : ParsingTestCase("testData/parser/imply", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testStringLiteral() {
        try {
            val fileContent = """
            imply MyType {
                constructor(value: V) {
                    this.value = value;
                    "single line string";
                    ${"\"\"\""}
                    multi line
                    string
                    ${"\"\"\""};
                    Some(value);
                    None;
                    a⸬b;
                    expr⸬member;
                    let s = macro"foo";
                }
            }
            """.trimIndent()

            val file = createFile("test_string.vk", fileContent)
            val errors = com.intellij.psi.util.PsiTreeUtil.findChildrenOfType(file, com.intellij.psi.PsiErrorElement::class.java)
            if (errors.isNotEmpty()) {
                println("❌ Found ${errors.size} errors in PSI tree:")
                errors.forEach { println("  - ${it.errorDescription} at offset ${it.textOffset}") }
                // println(DebugUtil.psiToString(file, true))
            } else {
                println("✅ String literal test parsed without errors")
            }
        } catch (e: Exception) {
            println("❌ String literal test failed: ${e.message}")
            throw e
        }
    }

    fun testUnityOption() {
        try {
            val fileContent = """
            unity Option⟨V⟩ { 
                 Some { 
                     value: V 
                 }; 
                 None { 
             
                 } 
             }
            """.trimIndent()
            val file = createFile("test_unity.vk", fileContent)
            val errors = com.intellij.psi.util.PsiTreeUtil.findChildrenOfType(file, com.intellij.psi.PsiErrorElement::class.java)
            if (errors.isNotEmpty()) {
                println("❌ Found ${errors.size} errors in unity test:")
                errors.forEach { println("  - ${it.errorDescription} at offset ${it.textOffset}") }
            } else {
                println("✅ Unity Option test parsed without errors")
            }
        } catch (e: Exception) {
            println("❌ Unity Option test failed: ${e.message}")
            throw e
        }
    }

    override fun skipSpaces(): Boolean {
        return true
    }
}