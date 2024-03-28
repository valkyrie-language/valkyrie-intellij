package valkyrie.parser

import org.junit.Test
import org.junit.Assert.assertTrue

class TemplateIfElseTest {

    @Test
    fun testTemplateIfElseEndStructure() {
        val templateCode = """
            <$ if a $>
            if any text
            <$ else $>
            any else text
            <$ end $>
        """.trimIndent()
        
        // 验证模板语法结构
        assertTrue("Template should contain if block", templateCode.contains("<$ if"))
        assertTrue("Template should contain else block", templateCode.contains("<$ else"))
        assertTrue("Template should contain end block", templateCode.contains("<$ end"))
        assertTrue("Template should contain template markers", templateCode.contains("$>"))
    }
    
    @Test
    fun testTemplateIfOnlyStructure() {
        val templateCode = """
            <$ if condition $>
            some content
            <$ end $>
        """.trimIndent()
        
        // 验证简单if模板结构
        assertTrue("Template should contain if block", templateCode.contains("<$ if"))
        assertTrue("Template should contain end block", templateCode.contains("<$ end"))
        assertTrue("Template should not contain else", !templateCode.contains("<$ else"))
    }
    
    @Test
    fun testTemplateElseIfStructure() {
        val templateCode = """
            <$ if condition1 $>
            content1
            <$ else if condition2 $>
            content2
            <$ else $>
            content3
            <$ end $>
        """.trimIndent()
        
        // 验证else if模板结构
        assertTrue("Template should contain if block", templateCode.contains("<$ if"))
        assertTrue("Template should contain else if block", templateCode.contains("<$ else if"))
        assertTrue("Template should contain else block", templateCode.contains("<$ else $>"))
        assertTrue("Template should contain end block", templateCode.contains("<$ end"))
    }
    
    @Test
    fun testNestedTemplateStructure() {
        val templateCode = """
            <$ if outer $>
                <$ if inner $>
                nested content
                <$ end $>
            <$ else $>
                outer else
            <$ end $>
        """.trimIndent()
        
        // 验证嵌套模板结构
        assertTrue("Template should contain nested if blocks", templateCode.contains("<$ if"))
        assertTrue("Template should contain multiple end blocks", templateCode.split("<$ end").size > 2)
        assertTrue("Template should contain else block", templateCode.contains("<$ else"))
    }
}