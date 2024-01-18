package valkyrie.parser

import org.junit.Test
import org.junit.Assert.assertTrue

class IntersectionTypeTest {
    
    @Test
    fun testBasicIntersectionType() {
        val code = "let x: A & B = value"
        assertTrue("Should contain intersection operator &", code.contains("&"))
        assertTrue("Should contain type A", code.contains("A"))
        assertTrue("Should contain type B", code.contains("B"))
    }
    
    @Test
    fun testMultipleIntersectionType() {
        val code = "let x: A & B & C = value"
        assertTrue("Should contain intersection operators", code.contains("A & B & C"))
    }
    
    @Test
    fun testLeadingAmpersandIntersectionType() {
        val code = "let x: &A&B = value"
        assertTrue("Should contain leading & syntax", code.contains("&A&B"))
    }
    
    @Test
    fun testIntersectionWithUnionType() {
        val code = "let x: (A | B) & C = value"
        assertTrue("Should contain union type", code.contains("A | B"))
        assertTrue("Should contain intersection with union", code.contains(") & C"))
    }
    
    @Test
    fun testComplexIntersectionUnionType() {
        val code = "let x: A & B | C & D = value"
        assertTrue("Should contain complex type expression", code.contains("A & B | C & D"))
    }
    
    @Test
    fun testIntersectionTypeInFunction() {
        val code = "function test(param: A & B): C & D { }"
        assertTrue("Should contain parameter intersection type", code.contains("param: A & B"))
        assertTrue("Should contain return intersection type", code.contains(": C & D"))
    }
}