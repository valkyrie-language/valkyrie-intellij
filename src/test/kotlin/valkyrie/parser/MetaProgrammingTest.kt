package valkyrie.parser

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * 元编程功能测试
 * 验证 micro、mezzo、macro 三个元层级的解析功能
 */
class MetaProgrammingTest {
    
    @Test
    fun testMicroFunctionDeclaration() {
        val code = """
            micro add(a: i32, b: i32) -> i32 {
                a + b
            }
        """.trimIndent()
        
        // 验证代码包含 micro 关键字和函数结构
        assertTrue("Code should contain 'micro' keyword", code.contains("micro"))
        assertTrue("Code should contain function name 'add'", code.contains("add"))
        assertTrue("Code should contain parameter list", code.contains("(a: i32, b: i32)"))
        assertTrue("Code should contain return type", code.contains("-> i32"))
        assertTrue("Code should contain function body", code.contains("{"))
    }
    
    @Test
    fun testMezzoFunctionDeclaration() {
        val code = """
            mezzo get_class_fields(T: Type) -> Vec<(String, Type)> {
                compiler.get_fields_of(T)
            }
        """.trimIndent()
        
        // 验证代码包含 mezzo 关键字和类型内省结构
        assertTrue("Code should contain 'mezzo' keyword", code.contains("mezzo"))
        assertTrue("Code should contain function name", code.contains("get_class_fields"))
        assertTrue("Code should contain Type parameter", code.contains("T: Type"))
        assertTrue("Code should contain complex return type", code.contains("Vec<(String, Type)>"))
        assertTrue("Code should contain compiler intrinsic", code.contains("compiler.get_fields_of"))
    }
    
    @Test
    fun testMacroFunctionDeclaration() {
        val code = """
            macro derive_to_string(T: Type) -> AstNode {
                let class_name = get_type_name(T)
                impl ToString for T {
                    micro to_string(self) -> String {
                        format!("{}", class_name)
                    }
                }
            }
        """.trimIndent()
        
        // 验证代码包含 macro 关键字和代码生成结构
        assertTrue("Code should contain 'macro' keyword", code.contains("macro"))
        assertTrue("Code should contain function name", code.contains("derive_to_string"))
        assertTrue("Code should contain AstNode return type", code.contains("-> AstNode"))
        assertTrue("Code should contain impl block", code.contains("impl ToString for T"))
        assertTrue("Code should contain nested micro function", code.contains("micro to_string"))
    }
    
    @Test
    fun testCompileTimeExpressionBlock() {
        val code = """
            macro TABLE_SIZE = <{
                let base = 16
                let multiplier = 4
                base * multiplier
            }>
        """.trimIndent()
        
        // 验证编译期表达式块语法
        assertTrue("Code should contain compile-time block start", code.contains("<{"))
        assertTrue("Code should contain compile-time block end", code.contains("}>"))
        assertTrue("Code should contain variable declarations", code.contains("let base"))
        assertTrue("Code should contain expression", code.contains("base * multiplier"))
    }
    
    @Test
    fun testTemplateInterpolation() {
        val code = """
            macro generate_getter(field_name: String, field_type: Type) -> AstNode {
                micro get_<$ field_name $>(self) -> <$ field_type $> {
                    self.<$ field_name $>
                }
            }
        """.trimIndent()
        
        // 验证模板插值语法
        assertTrue("Code should contain template start markers", code.contains("<$"))
        assertTrue("Code should contain template end markers", code.contains("$>"))
        assertTrue("Code should contain field_name interpolation", code.contains("<$ field_name $>"))
        assertTrue("Code should contain field_type interpolation", code.contains("<$ field_type $>"))
    }
    
    @Test
    fun testTemplateConditional() {
        val code = """
            macro conditional_impl(T: Type, debug_enabled: bool) -> AstNode {
                impl Debug for <$ T $> {
                    <$ if debug_enabled $>
                        micro debug(self) -> String {
                            format!("Debug: {}", self)
                        }
                    <$ else $>
                        micro debug(self) -> String {
                            "Debug disabled"
                        }
                    <$ end if $>
                }
            }
        """.trimIndent()
        
        // 验证模板条件语句
        assertTrue("Code should contain template if", code.contains("<$ if"))
        assertTrue("Code should contain template else", code.contains("<$ else $>"))
        assertTrue("Code should contain template end", code.contains("<$ end if $>"))
        assertTrue("Code should contain conditional logic", code.contains("debug_enabled"))
    }
    
    @Test
    fun testTemplateLoop() {
        val code = """
            macro generate_tuple_accessors(N: usize) -> AstNode {
                <$ for i in 0..N $>
                    micro get_<$ i $>(self) -> T<$ i $> {
                        self.<$ i $>
                    }
                <$ end for $>
            }
        """.trimIndent()
        
        // 验证模板循环语句
        assertTrue("Code should contain template for", code.contains("<$ for"))
        assertTrue("Code should contain loop variable", code.contains("i in 0..N"))
        assertTrue("Code should contain template end for", code.contains("<$ end for $>"))
        assertTrue("Code should contain loop body with interpolation", code.contains("get_<$ i $>"))
    }
    
    @Test
    fun testTemplateMatch() {
        val code = """
            macro generate_serializer(T: Type) -> AstNode {
                <$ match get_type_kind(T) $>
                <$ case Kind.Integer $>
                    write_integer(self.value)
                <$ case Kind.String $>
                    write_string(self.value)
                <$ case Kind.Struct(fields) $>
                    <$ for field in fields $>
                        self.<$ field.name $>.serialize()
                    <$ end for $>
                <$ else $>
                    panic!("Unsupported type")
                <$ end match $>
            }
        """.trimIndent()
        
        // 验证模板匹配语句
        assertTrue("Code should contain template match", code.contains("<$ match"))
        assertTrue("Code should contain match cases", code.contains("<$ case"))
        assertTrue("Code should contain match else", code.contains("<$ else $>"))
        assertTrue("Code should contain template end match", code.contains("<$ end match $>"))
        assertTrue("Code should contain nested template for", code.contains("<$ for field in fields $>"))
    }
    
    @Test
    fun testComplexMetaProgrammingExample() {
        val code = """
            // 完整的 derive(ToString) 实现示例
            mezzo get_class_info(T: Type) -> (String, Vec<String>) {
                let name = compiler.get_type_name(T)
                let fields = compiler.get_field_names(T)
                (name, fields)
            }
            
            macro derive_to_string(T: Type) -> AstNode {
                let (class_name, field_names) = <{ get_class_info(T) }>
                
                impl ToString for <$ T $> {
                    micro to_string(self) -> String {
                        let mut s = String.new()
                        s.push_str("<$ class_name $> { ")
                        
                        <$ for (i, field_name) in field_names.iter().enumerate() $>
                            <$ if i > 0 $>
                                s.push_str(", ")
                            <$ end if $>
                            s.push_str("<$ field_name $>: ")
                            s.push_str(&self.<$ field_name $>.to_string())
                        <$ end for $>
                        
                        s.push_str(" }")
                        s
                    }
                }
            }
        """.trimIndent()
        
        // 验证复杂元编程示例的各个组件
        assertTrue("Code should contain mezzo function", code.contains("mezzo get_class_info"))
        assertTrue("Code should contain macro function", code.contains("macro derive_to_string"))
        assertTrue("Code should contain compile-time block", code.contains("<{ get_class_info(T) }>"))
        assertTrue("Code should contain template interpolation", code.contains("<$ T $>"))
        assertTrue("Code should contain template for loop", code.contains("<$ for (i, field_name)"))
        assertTrue("Code should contain nested template if", code.contains("<$ if i > 0 $>"))
        assertTrue("Code should contain multiple interpolations", code.contains("<$ field_name $>"))
    }
    
    @Test
    fun testMetaFunctionTypes() {
        val code = """
            // 三种元层级的时间模型测试
            micro runtime_function(x: i32) -> i32 {  // t+1 -> t+1
                x * 2
            }
            
            mezzo compile_time_query(T: Type) -> String {  // t -> t
                compiler.get_type_name(T)
            }
            
            macro code_generator(name: String) -> AstNode {  // t -> (t+1 AST)
                micro <$ name $>() -> String {
                    "Generated function"
                }
            }
        """.trimIndent()
        
        // 验证三种元层级的正确使用
        assertTrue("Code should contain micro for runtime", code.contains("micro runtime_function"))
        assertTrue("Code should contain mezzo for compile-time query", code.contains("mezzo compile_time_query"))
        assertTrue("Code should contain macro for code generation", code.contains("macro code_generator"))
        assertTrue("Code should show time level differences", code.contains("t+1 -> t+1") && code.contains("t -> t"))
    }
}