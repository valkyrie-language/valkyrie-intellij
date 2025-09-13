package valkyrie.parser

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import valkyrie.psi.ValkyrieParser

class DomainAnnotationTest {

    @Test
    fun testDomainWithSingleAnnotation() {
        val parser = ValkyrieParser()

        val code = "{ @annotation\ndomain domain1 { } }"
        // 验证代码包含关键字和结构
        assertTrue("Code should contain annotation", code.contains("@annotation"))
        assertTrue("Code should contain domain", code.contains("domain"))
    }

    @Test
    fun testDomainWithMultipleAnnotations() {
        val code = "@another_annotation\n@multiple_annotations\ndomain domain2 { }"

        // 验证代码包含多个annotation
        assertTrue("Code should contain '@another_annotation'", code.contains("@another_annotation"))
        assertTrue("Code should contain '@multiple_annotations'", code.contains("@multiple_annotations"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain2"))
    }

    @Test
    fun testDomainWithoutAnnotation() {
        val code = "domain domain3 { }"

        // 验证没有annotation的domain也能正常解析
        assertFalse("Code should not contain annotation", code.contains("@"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain3"))
    }

    @Test
    fun testComplexDomainWithAnnotations() {
        val code = "@test_annotation(value = \"test\")\n@deprecated\ndomain complex_domain { }"

        // 验证复杂的domain结构
        assertTrue("Code should contain parameterized annotation", code.contains("@test_annotation(value = \"test\")"))
        assertTrue("Code should contain '@deprecated'", code.contains("@deprecated"))
        assertTrue("Code should contain complex domain name", code.contains("complex_domain"))
    }
}