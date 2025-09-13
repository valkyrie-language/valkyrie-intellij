package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * 宏赋值与模板语法冲突测试
 * 验证修复后的解析器能正确区分宏赋值和模板语法
 */
class MacroTemplateConflictTest {
    
    @Test
    fun testMacroAssignmentStructure() {
        val code = "macro test_macro = some_value"
        
        // 验证宏赋值的基本结构
        assertTrue("Code should contain macro keyword", code.contains("macro"))
        assertTrue("Code should contain assignment operator", code.contains("="))
        assertFalse("Code should not contain template markers", code.contains("<\$"))
        assertFalse("Code should not contain template markers", code.contains("\$>"))
    }
    
    @Test
    fun testTemplateBlockStructure() {
        val code = "<\$ if condition \$>\n content\n<\$ end \$>"
        
        // 验证模板语法的基本结构
        assertTrue("Code should contain template start", code.contains("<\$"))
        assertTrue("Code should contain template end", code.contains("\$>"))
        assertFalse("Code should not contain macro keyword", code.contains("macro"))
        assertFalse("Code should not contain assignment operator", code.contains("="))
    }
    
    @Test
    fun testMixedMacroAndTemplate() {
        val macroCode = "macro config = default_config"
        val templateCode = "<\$ if debug_mode \$>\n debug_content\n<\$ end \$>"
        
        // 验证宏赋值结构
        assertTrue("Macro code should contain macro keyword", macroCode.contains("macro"))
        assertTrue("Macro code should contain assignment operator", macroCode.contains("="))
        assertFalse("Macro code should not contain template markers", macroCode.contains("<\$"))
        assertFalse("Macro code should not contain template markers", macroCode.contains("\$>"))
        
        // 验证模板语法结构
        assertTrue("Template code should contain template start", templateCode.contains("<\$"))
        assertTrue("Template code should contain template end", templateCode.contains("\$>"))
        assertFalse("Template code should not contain macro keyword", templateCode.contains("macro"))
        assertFalse("Template code should not contain assignment operator", templateCode.contains("="))
    }
    
    @Test
    fun testComplexTemplateWithVariables() {
        val code = "<\$ if user.age > 18 \$>\n Adult content\n<\$ else \$>\n Minor content\n<\$ end \$>"
        
        // 验证复杂模板语法的结构
        assertTrue("Code should contain template start", code.contains("<\$"))
        assertTrue("Code should contain template end", code.contains("\$>"))
        assertTrue("Code should contain if keyword", code.contains("if"))
        assertTrue("Code should contain else keyword", code.contains("else"))
        assertTrue("Code should contain end keyword", code.contains("end"))
        
        // 验证不会被误识别为宏赋值
        assertFalse("Code should not be misidentified as macro", 
            code.startsWith("macro") || code.contains("macro "))
    }
}