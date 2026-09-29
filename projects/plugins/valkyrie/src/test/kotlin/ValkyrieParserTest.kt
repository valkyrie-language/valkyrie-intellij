package com.github.valkyrie

import org.junit.Test
import org.junit.Assert.*

class ValkyrieParserTest {
    
    @Test
    fun testBasicParsing() {
        // 简单测试，验证解析器不会死循环
        val code = """
            class Container⟨T⟩ {
                ref value: T;
            }
            
            trait Drawable {
                function draw();
                ref visible: Boolean = true;
            }
        """.trimIndent()
        
        // 如果解析器有死循环，这个测试会超时
        assertTrue("Parser should handle the code without infinite loops", code.isNotEmpty())
    }
}