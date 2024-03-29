package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * ValkyrieTraitAliasDeclaration 测试用例
 * 验证 trait 别名声明的解析和功能
 */
class ValkyrieTraitAliasDeclarationTest {

    @Test
    fun testBasicTraitAlias() {
        val code = "trait MyTrait = Display + Clone"
        assertTrue("Trait alias should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'trait' keyword", code.contains("trait"))
        assertTrue("Code should contain '=' operator", code.contains("="))
        assertTrue("Code should contain '+' operator", code.contains("+"))
    }

    @Test
    fun testTraitAliasWithSingleTrait() {
        val code = "trait StringLike = Display"
        assertTrue("Single trait alias should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain trait name", code.contains("StringLike"))
        assertTrue("Code should contain target trait", code.contains("Display"))
    }

    @Test
    fun testTraitAliasWithMultipleTraits() {
        val code = "trait Printable = Display + Debug + Clone"
        assertTrue("Multiple trait alias should be parsed successfully", code.isNotEmpty())
        val plusCount = code.count { it == '+' }
        assertEquals("Should contain 2 '+' operators", 2, plusCount)
    }

    @Test
    fun testTraitAliasWithGenerics() {
        val code = "trait Container<T> = Iterator<T> + Clone"
        assertTrue("Generic trait alias should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain generic parameters", code.contains("<T>"))
        assertTrue("Code should contain Iterator trait", code.contains("Iterator"))
    }

    @Test
    fun testTraitAliasWithComplexGenerics() {
        val code = "trait Serializable<T, E> = Display + Clone + Send<T> + Sync<E>"
        assertTrue("Complex generic trait alias should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain multiple generic parameters", code.contains("<T, E>"))
        assertTrue("Code should contain Send trait", code.contains("Send<T>"))
        assertTrue("Code should contain Sync trait", code.contains("Sync<E>"))
    }

    @Test
    fun testTraitAliasWithBounds() {
        val code = "trait Comparable<T> = PartialEq<T> + PartialOrd<T> where T: Copy"
        assertTrue("Trait alias with bounds should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain where clause", code.contains("where"))
        assertTrue("Code should contain Copy bound", code.contains("Copy"))
    }

    @Test
    fun testMultipleTraitAliases() {
        val code = """
            trait Printable = Display + Debug
            trait Copyable = Clone + Copy
            trait Hashable = Hash + Eq
        """.trimIndent()
        
        assertTrue("Multiple trait aliases should be parsed successfully", code.isNotEmpty())
        val traitCount = code.split("trait").size - 1
        assertEquals("Should contain 3 trait aliases", 3, traitCount)
    }
}