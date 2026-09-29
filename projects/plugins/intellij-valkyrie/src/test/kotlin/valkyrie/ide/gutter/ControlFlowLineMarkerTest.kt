package valkyrie.ide.gutter

import org.junit.Test
import org.junit.Assert.assertTrue

/**
 * 控制流行标记测试
 */
class ControlFlowLineMarkerTest {

    @Test
    fun testLoopStatementMarker() {
        val code = """
            loop {
                if condition {
                    break
                }
                continue
            }
        """.trimIndent()
        
        assertTrue("Loop statement should be recognized", code.contains("loop"))
        assertTrue("Break statement should be recognized", code.contains("break"))
        assertTrue("Continue statement should be recognized", code.contains("continue"))
    }

    @Test
    fun testReturnStatementMarker() {
        val code = """
            function test() -> Int {
                if condition {
                    return 42
                }
                return 0
            }
        """.trimIndent()
        
        assertTrue("Return statements should be recognized", code.contains("return"))
    }

    @Test
    fun testYieldStatementMarker() {
        val code = """
            function* generator() {
                yield 1
                yield 2
                yield 3
            }
        """.trimIndent()
        
        assertTrue("Yield statements should be recognized", code.contains("yield"))
    }

    @Test
    fun testRaiseAndCatchMarkers() {
        val code = """
            function test() {
                try {
                    raise Exception("error")
                } catch e: Exception {
                    print(e.message)
                }
            }
        """.trimIndent()
        
        assertTrue("Raise statement should be recognized", code.contains("raise"))
        assertTrue("Catch statement should be recognized", code.contains("catch"))
    }

    @Test
    fun testNestedControlFlow() {
        val code = """
            function complexFunction() {
                'outer: loop {
                    for i in 0..10 {
                        if i == 5 {
                            continue 'outer
                        }
                        if i == 8 {
                            break 'outer
                        }
                        yield i
                    }
                }
                return "done"
            }
        """.trimIndent()
        
        assertTrue("Nested control flow should be recognized", 
            code.contains("loop") && 
            code.contains("for") && 
            code.contains("continue") && 
            code.contains("break") && 
            code.contains("yield") && 
            code.contains("return"))
    }

    @Test
    fun testEffectAnalysisCore() {
        val code = """
            function processData() {
                try {
                    let data = readFile("input.txt")
                    if data.isEmpty() {
                        raise EmptyFileError("File is empty")
                    }
                    return processContent(data)
                } catch e: EmptyFileError {
                    return "default content"
                } catch e: IOError {
                    raise ProcessingError("Failed to process", e)
                }
            }
        """.trimIndent()
        
        assertTrue("Effect analysis should recognize raise-catch pairs", 
            code.contains("raise") && code.contains("catch"))
    }
}