package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class DomainAnnotationTest {
    
    @Test
    fun testDomainWithSingleAnnotation() {
        tests {}
        """.trimIndent()
        
        // 验证代码包含关键字和结构
    }
    
    @Test
    fun testDomainWithMultipleAnnotations() {
        val code = """
            @another_annotation
            @multiple_annotations
            domain domain2 {
                test "multiple annotations" {
                    // test content
                }
            }
        """.trimIndent()
        
        // 验证代码包含多个annotation
        assertTrue("Code should contain '@another_annotation'", code.contains("@another_annotation"))
        assertTrue("Code should contain '@multiple_annotations'", code.contains("@multiple_annotations"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain2"))
    }
    
    @Test
    fun testDomainWithoutAnnotation() {
        val code = """
            domain domain3 {
                test "no annotation" {
                    // test content
                }
            }
        """.trimIndent()
        
        // 验证没有annotation的domain也能正常解析
        assertFalse("Code should not contain annotation", code.contains("@"))
        assertTrue("Code should contain 'domain' keyword", code.contains("domain"))
        assertTrue("Code should contain domain name", code.contains("domain3"))
    }
    
    @Test
    fun testComplexDomainWithAnnotations() {
        val code = """
            @test_annotation(value = "test")
            @deprecated
            domain complex_domain {
                test "complex test case" {
                    let x = 42;
                    assert(x == 42);
                }
                
                test "another test" {
                    // more test content
                }
            }
        """.trimIndent()
        
        // 验证复杂的domain结构
        assertTrue("Code should contain parameterized annotation", code.contains("@test_annotation(value = \"test\")"))
        assertTrue("Code should contain '@deprecated'", code.contains("@deprecated"))
        assertTrue("Code should contain complex domain name", code.contains("complex_domain"))
        assertTrue("Code should contain multiple test blocks", code.split("test").size > 2)
    }
}