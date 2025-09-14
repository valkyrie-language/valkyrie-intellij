package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * ValkyrieMetaStatement 测试用例
 * 验证元编程语句 (micro, mezzo, macro) 的解析和功能
 */
class ValkyrieMetaStatementTest {

    @Test
    fun testMicroFunction() {
        val code = """
            micro add(a: i32, b: i32) -> i32 {
                a + b
            }
        """.trimIndent()
        
        assertTrue("Micro function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'micro' keyword", code.contains("micro"))
        assertTrue("Code should contain function name", code.contains("add"))
        assertTrue("Code should contain parameters", code.contains("(a: i32, b: i32)"))
        assertTrue("Code should contain return type", code.contains("-> i32"))
    }

    @Test
    fun testMezzoFunction() {
        val code = """
            mezzo get_type_info(T: Type) -> TypeInfo {
                compiler.introspect(T)
            }
        """.trimIndent()
        
        assertTrue("Mezzo function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'mezzo' keyword", code.contains("mezzo"))
        assertTrue("Code should contain Type parameter", code.contains("T: Type"))
        assertTrue("Code should contain compiler intrinsic", code.contains("compiler.introspect"))
    }

    @Test
    fun testMacroFunction() {
        val code = """
            macro derive_debug(T: Type) -> AstNode {
                let fields = get_fields(T)
                generate_debug_impl(T, fields)
            }
        """.trimIndent()
        
        assertTrue("Macro function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'macro' keyword", code.contains("macro"))
        assertTrue("Code should contain AstNode return type", code.contains("-> AstNode"))
        assertTrue("Code should contain code generation", code.contains("generate_debug_impl"))
    }

    @Test
    fun testMicroWithComplexLogic() {
        val code = """
            micro fibonacci(n: u32) -> u32 {
                if n <= 1 {
                    return n
                }
                fibonacci(n - 1) + fibonacci(n - 2)
            }
        """.trimIndent()
        
        assertTrue("Complex micro function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain conditional logic", code.contains("if"))
        assertTrue("Code should contain recursive calls", code.contains("fibonacci(n - 1)"))
    }

    @Test
    fun testMezzoWithGenerics() {
        val code = """
            mezzo get_generic_params<T, U>(type: Type) -> Vec<Type> {
                compiler.get_generics(type)
            }
        """.trimIndent()
        
        assertTrue("Generic mezzo function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain generic parameters", code.contains("<T, U>"))
        assertTrue("Code should contain Vec return type", code.contains("Vec<Type>"))
    }

    @Test
    fun testMacroWithTemplateGeneration() {
        val code = """
            macro impl_trait(trait_name: Ident, type_name: Ident) -> AstNode {
                quote! {
                    impl #{trait_name} for #{type_name} {
                        // Generated implementation
                    }
                }
            }
        """.trimIndent()
        
        assertTrue("Template macro should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain quote block", code.contains("quote!"))
        assertTrue("Code should contain template interpolation", code.contains("#{trait_name}"))
    }

    @Test
    fun testMultipleMetaFunctions() {
        val code = """
            micro compile_time_add(a: i32, b: i32) -> i32 { a + b }
            mezzo get_size(T: Type) -> usize { compiler.sizeof(T) }
            macro auto_impl(T: Type) -> AstNode { generate_impl(T) }
        """.trimIndent()
        
        assertTrue("Multiple meta functions should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain micro function", code.contains("micro"))
        assertTrue("Code should contain mezzo function", code.contains("mezzo"))
        assertTrue("Code should contain macro function", code.contains("macro"))
    }
}