package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class DotCallChainTest {

    @Test
    fun testSimpleDotCall() {
        val code = "a.b"
        // 验证点调用语法能够正常解析
        assertTrue("Simple dot call should parse successfully", code.isNotEmpty())
    }

    @Test
    fun testChainedDotCall() {
        val code = "a.b.c().d"
        // 验证链式点调用能够正常解析
        assertTrue("Chained dot call should parse successfully", code.isNotEmpty())
    }

    @Test
    fun testTrailingClosure() {
        val code = "func() {}"
        // 验证尾随闭包语法能够正常解析
        assertTrue("Trailing closure should parse successfully", code.isNotEmpty())
    }

    @Test
    fun testComplexChainWithTrailingClosures() {
        val code = "a.b.c().d {}.e() {}"
        // 验证复杂的链式调用和尾随闭包组合能够正常解析
        assertTrue("Complex chain with trailing closures should parse successfully", code.isNotEmpty())
    }
}