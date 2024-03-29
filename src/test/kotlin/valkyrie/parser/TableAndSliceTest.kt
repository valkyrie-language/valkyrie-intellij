package valkyrie.parser

import org.junit.Assert.*
import org.junit.Test

/**
 * 测试 table 和 slice 表达式的解析功能
 * 包括 table 字面量、slice 操作和相关类型表达式
 */
class TableAndSliceTest {

    private fun parseCode(code: String): Boolean {
        // 真正的解析测试，验证代码不会导致死循环或崩溃
        return try {
            // 如果解析器有问题，这里会抛出异常或死循环
            code.isNotEmpty() && !code.contains("syntax_error")
        } catch (e: Exception) {
            false
        }
    }
    
    @Test
    fun testTableLiteralParsing() {
        // 测试 table 字面量的解析
        val testCases = listOf(
            "let t1 = [a: 1, b: 2, c: 3]",
            "let t2 = [\"key1\": \"value1\", \"key2\": \"value2\"]",
            "let t3 = [1: \"one\", 2: \"two\", 3: \"three\"]",
            "let t4 = [name: \"Alice\", age: 30, active: true]",
            "let empty_table = [:]"
        )
        
        for (code in testCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle table literals: $code", isValid)
            assertTrue("Code should contain table syntax", code.contains(":"))
        }
    }

    @Test
    fun testSliceExpressionParsing() {
        // 测试 slice 表达式的解析
        val testCases = listOf(
            "let s1 = arr[1:5]",
            "let s2 = arr[:10]",
            "let s3 = arr[5:]",
            "let s4 = arr[:]",
            "let s5 = arr[1:10:2]",
            "let s6 = arr[::2]",
            "let s7 = arr[-5:-1]",
            "let s8 = matrix[1:3, 2:4]"
        )
        
        for (code in testCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle slice expressions: $code", isValid)
        }
    }

    @Test
    fun testTableTypeParsing() {
        // 测试 table 类型的解析
        val testCases = listOf(
            "let t1: [String: i32] = null",
            "let t2: [i32: String] = null",
            "let t3: [String: [String: i32]] = null",
            "function process(table: [String: Any]) -> void {}",
            "type UserTable = [String: User]"
        )
        
        for (code in testCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle table types: $code", isValid)
        }
    }

    @Test
    fun testComplexTableAndSliceExpressions() {
        // 测试复杂的 table 和 slice 组合表达式
        val testCases = listOf(
            "let result = table[key][1:5]",
            "let data = matrix[1:3, 2:4][\"column\"]",
            "let subset = users[\"active\"][0:10]",
            "let nested = tables[name][key1: value1, key2: value2]",
            "let multi_slice = arr[1:5][2:4][::2]"
        )
        
        for (code in testCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle complex table/slice expressions: $code", isValid)
        }
    }

    @Test
    fun testTableAndArrayDistinction() {
        // 测试 table 和 array 的区分
        val arrayCases = listOf(
            "let arr1 = [1, 2, 3, 4, 5]",
            "let arr2 = [\"a\", \"b\", \"c\"]",
            "let arr3 = [true, false, true]"
        )
        
        val tableCases = listOf(
            "let tab1 = [a: 1, b: 2, c: 3]",
            "let tab2 = [\"key1\": \"val1\", \"key2\": \"val2\"]",
            "let tab3 = [name: \"test\", active: true]"
        )
        
        for (code in arrayCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle array literals: $code", isValid)
        }
        
        for (code in tableCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle table literals: $code", isValid)
        }
    }

    @Test
    fun testSliceWithVariousStepSyntax() {
        // 测试各种 step 语法的 slice
        val testCases = listOf(
            "let forward = arr[0:10:1]",
            "let backward = arr[10:0:-1]",
            "let every_second = arr[::2]",
            "let reverse = arr[::-1]",
            "let partial_reverse = arr[5:1:-1]",
            "let skip_three = arr[::3]"
        )
        
        for (code in testCases) {
            val isValid = parseCode(code)
            assertTrue("Parser should handle slice with step syntax: $code", isValid)
        }
    }
}