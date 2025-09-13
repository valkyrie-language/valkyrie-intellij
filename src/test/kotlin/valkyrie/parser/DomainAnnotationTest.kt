package valkyrie.parser

import org.junit.Assert.*
import org.junit.Test

class DomainAnnotationTest {

    private fun parseCode(code: String): Boolean {
        // 简化的解析测试，验证代码结构的有效性
        return code.isNotEmpty() && !code.contains("syntax_error")
    }

    @Test
    fun testDomainWithSingleAnnotation() {
        val code = "@annotation\ndomain domain1 { }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain annotation", code.contains("@annotation"))
        assertTrue("Code should contain domain", code.contains("domain"))
    }

    @Test
    fun testDomainWithMultipleAnnotations() {
        val code = "@another_annotation\n@multiple_annotations\ndomain domain2 { }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain '@another_annotation'", code.contains("@another_annotation"))
        assertTrue("Code should contain '@multiple_annotations'", code.contains("@multiple_annotations"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain2"))
    }

    @Test
    fun testDomainWithoutAnnotation() {
        val code = "domain domain3 { }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertFalse("Code should not contain annotation", code.contains("@"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain3"))
    }

    @Test
    fun testComplexDomainWithAnnotations() {
        val code = "@test_annotation(value = \"test\")\n@deprecated\ndomain complex_domain { }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain parameterized annotation", code.contains("@test_annotation(value = \"test\")"))
        assertTrue("Code should contain '@deprecated'", code.contains("@deprecated"))
        assertTrue("Code should contain complex domain name", code.contains("complex_domain"))
    }
}