package valkyrie.parser

import com.intellij.lang.PsiBuilder
import com.intellij.lang.impl.PsiBuilderImpl
import com.intellij.psi.tree.IElementType
import org.junit.Test
import org.junit.Assert.*
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieParser
import valkyrie.psi.ValkyrieTokenTypes

class TemplateParserTest {

    private fun createParser(text: String): PsiBuilder {
        val lexer = ValkyrieLexer()
        lexer.start(text)
        return PsiBuilderImpl(null, null, lexer, null, text)
    }

    @Test
    fun testTemplateIfElseEndStructure() {
        val templateCode = """
            <$ if a $>
            if any text
            <$ else $>
            any else text
            <$ end $>
        """.trimIndent()
        
        val builder = createParser(templateCode)
        val parser = ValkyrieParser()
        val tree = parser.parse(ValkyrieElementTypes.FILE, builder)
        
        assertNotNull("Parse tree should not be null", tree)
        
        // 验证解析结果不包含错误
        val errorElements = findErrorElements(tree)
        assertTrue("Should not contain parse errors: $errorElements", errorElements.isEmpty())
        
        // 验证包含正确的模板块
        val templateBlocks = findElementsByType(tree, ValkyrieElementTypes.TEMPLATE_BLOCK)
        assertEquals("Should have 3 template blocks (if, else, end)", 3, templateBlocks.size)
        
        // 验证包含模板文本
        val templateTexts = findElementsByType(tree, ValkyrieElementTypes.TEMPLATE_TEXT)
        assertEquals("Should have 2 template text blocks", 2, templateTexts.size)
    }

    @Test
    fun testTemplateTextWithKeywords() {
        val templateCode = """
            <$ if condition $>
            This text contains if and else keywords
            <$ end $>
        """.trimIndent()
        
        val builder = createParser(templateCode)
        val parser = ValkyrieParser()
        val tree = parser.parse(ValkyrieElementTypes.FILE, builder)
        
        assertNotNull("Parse tree should not be null", tree)
        
        // 验证模板文本中的关键字不被误识别为语法元素
        val errorElements = findErrorElements(tree)
        assertTrue("Template text with keywords should not cause parse errors: $errorElements", 
                  errorElements.isEmpty())
        
        // 验证模板文本被正确识别
        val templateTexts = findElementsByType(tree, ValkyrieElementTypes.TEMPLATE_TEXT)
        assertTrue("Should have at least one template text block", templateTexts.isNotEmpty())
    }

    @Test
    fun testNestedTemplateStructure() {
        val templateCode = """
            <$ if outer $>
                <$ if inner $>
                nested content
                <$ end $>
            <$ else $>
                else content
            <$ end $>
        """.trimIndent()
        
        val builder = createParser(templateCode)
        val parser = ValkyrieParser()
        val tree = parser.parse(ValkyrieElementTypes.FILE, builder)
        
        assertNotNull("Parse tree should not be null", tree)
        
        // 验证嵌套结构解析正确
        val errorElements = findErrorElements(tree)
        assertTrue("Nested template structure should not cause parse errors: $errorElements", 
                  errorElements.isEmpty())
    }

    @Test
    fun testTemplateWithExpressions() {
        val templateCode = """
            <$ if a > 0 $>
            Value is positive: <$ a $>
            <$ else $>
            Value is not positive
            <$ end $>
        """.trimIndent()
        
        val builder = createParser(templateCode)
        val parser = ValkyrieParser()
        val tree = parser.parse(ValkyrieElementTypes.FILE, builder)
        
        assertNotNull("Parse tree should not be null", tree)
        
        // 验证表达式和模板文本混合解析正确
        val errorElements = findErrorElements(tree)
        assertTrue("Template with expressions should not cause parse errors: $errorElements", 
                  errorElements.isEmpty())
    }

    // 辅助方法：查找错误元素
    private fun findErrorElements(node: com.intellij.lang.ASTNode): List<String> {
        val errors = mutableListOf<String>()
        
        fun traverse(n: com.intellij.lang.ASTNode) {
            if (n.elementType.toString().contains("ERROR")) {
                errors.add("${n.elementType}: ${n.text}")
            }
            for (child in n.getChildren(null)) {
                traverse(child)
            }
        }
        
        traverse(node)
        return errors
    }

    // 辅助方法：查找指定类型的元素
    private fun findElementsByType(node: com.intellij.lang.ASTNode, elementType: IElementType): List<com.intellij.lang.ASTNode> {
        val elements = mutableListOf<com.intellij.lang.ASTNode>()
        
        fun traverse(n: com.intellij.lang.ASTNode) {
            if (n.elementType == elementType) {
                elements.add(n)
            }
            for (child in n.getChildren(null)) {
                traverse(child)
            }
        }
        
        traverse(node)
        return elements
    }
}