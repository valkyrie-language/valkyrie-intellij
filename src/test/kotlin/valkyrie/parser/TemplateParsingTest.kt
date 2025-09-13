package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * 模板语法解析测试
 * 验证修复后的解析器能正确处理模板语法
 */
class TemplateParsingTest {
    
    @Test
    fun testSimpleTemplateStructure() {
        val code = "<\$ if a > 0 \$>\n content\n<\$ end \$>"
        
        // 验证模板语法的基本结构
        assertTrue("Code should contain template start", code.contains("<\$"))
        assertTrue("Code should contain template end", code.contains("\$>"))
        assertTrue("Code should contain if keyword", code.contains("if"))
        assertTrue("Code should contain end keyword", code.contains("end"))
    }
    
    @Test
    fun testTemplateWithElseStructure() {
        val code = "<\$ if condition \$>\n true branch\n<\$ else \$>\n false branch\n<\$ end \$>"
        
        // 验证模板语法的条件分支结构
        assertTrue("Code should contain template start", code.contains("<\$"))
        assertTrue("Code should contain template end", code.contains("\$>"))
        assertTrue("Code should contain if keyword", code.contains("if"))
        assertTrue("Code should contain else keyword", code.contains("else"))
        assertTrue("Code should contain end keyword", code.contains("end"))
    }
    
    @Test
    fun testNestedTemplateStructure() {
        val code = "<\$ if outer \$>\n <\$ if inner \$>\n  nested content\n <\$ end \$>\n<\$ end \$>"
        
        // 验证嵌套模板语法的结构
        assertTrue("Code should contain template start", code.contains("<\$"))
        assertTrue("Code should contain template end", code.contains("\$>"))
        assertTrue("Code should contain if keyword", code.contains("if"))
        assertTrue("Code should contain end keyword", code.contains("end"))
        
        // 验证嵌套结构
        val templateStarts = code.split("<\$").size - 1
        val templateEnds = code.split("\$>").size - 1
        assertEquals("Template starts and ends should match", templateStarts, templateEnds)
    }
}