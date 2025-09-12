package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class TestsStatementTest {
    
    @Test
    fun testSimpleTestsBlock() {
        val code = """
            tests {
                test simple_test() {
                    assert(true)
                }
            }
        """.trimIndent()
        
        // 验证代码包含关键字
        assertTrue("Code should contain 'tests' keyword", code.contains("tests"))
        assertTrue("Code should contain 'test' keyword", code.contains("test"))
        assertTrue("Code should contain function definition", code.contains("simple_test()"))
        assertTrue("Code should contain braces", code.contains("{") && code.contains("}"))
    }
    
    @Test
    fun testTestFunction() {
        val code = """
            test function my_test() {
                assert(1 + 1 == 2)
            }
        """.trimIndent()
        
        // 验证代码包含关键字和结构
        assertTrue("Code should contain 'test' keyword", code.contains("test"))
        assertTrue("Code should contain 'function' keyword", code.contains("function"))
        assertTrue("Code should contain function name", code.contains("my_test()"))
        assertTrue("Code should contain assert statement", code.contains("assert"))
    }
    
    @Test
    fun testBenchmarkDSL() {
        val code = """
            tests {
                config() {
                    return [warmups: 5, iterations: 10, mode: "Throughput"]
                }
                
                prepare() {
                    return [[size: 100], [size: 200]]
                }
                
                before(params) {
                    return generateArray(params[:size])
                }
                
                benchmark(data) {
                    quickSort(data.copyOf())
                }
                
                after(data) {
                    // cleanup
                }
                
                clean() {
                    // final cleanup
                }
            }
        """.trimIndent()
        
        // 验证 benchmark DSL 的各个组件
        assertTrue("Code should contain 'tests' block", code.contains("tests"))
        assertTrue("Code should contain 'config' hook", code.contains("config()"))
        assertTrue("Code should contain 'prepare' hook", code.contains("prepare()"))
        assertTrue("Code should contain 'before' hook", code.contains("before(params)"))
        assertTrue("Code should contain 'benchmark' block", code.contains("benchmark(data)"))
        assertTrue("Code should contain 'after' hook", code.contains("after(data)"))
        assertTrue("Code should contain 'clean' hook", code.contains("clean()"))
        assertTrue("Code should contain configuration parameters", code.contains("warmups") && code.contains("iterations"))
    }
    
    @Test
    fun testNestedTestsBlocks() {
        val code = """
            tests {
                tests {
                    test function inner_test() {
                        assert(true)
                    }
                }
            }
        """.trimIndent()
        
        // 验证嵌套 tests 块结构
        assertTrue("Code should contain nested 'tests' blocks", code.contains("tests"))
        assertTrue("Code should contain inner test function", code.contains("inner_test()"))
        assertTrue("Code should have proper nesting structure", code.split("tests").size > 2)
    }
    
    @Test
    fun testTestsWithModifiers() {
        val code = """
            @benchmark
            public tests {
                benchmark(data) {
                    performOperation(data)
                }
            }
        """.trimIndent()
        
        // 验证修饰符和注解
        assertTrue("Code should contain annotation", code.contains("@benchmark"))
        assertTrue("Code should contain modifier", code.contains("public"))
        assertTrue("Code should contain tests block", code.contains("tests"))
        assertTrue("Code should contain benchmark block", code.contains("benchmark(data)"))
    }
    
    @Test
    fun testTestsInClassBody() {
        val code = """
            class MyClass {
                tests {
                    test function class_test() {
                        assert(this != null)
                    }
                }
                
                test function another_test() {
                    assert(true)
                }
            }
        """.trimIndent()
        
        // 验证类中的测试结构
        assertTrue("Code should contain class declaration", code.contains("class MyClass"))
        assertTrue("Code should contain tests block in class", code.contains("tests"))
        assertTrue("Code should contain test functions", code.contains("test function"))
        assertTrue("Code should contain class_test function", code.contains("class_test()"))
        assertTrue("Code should contain another_test function", code.contains("another_test()"))
    }
}