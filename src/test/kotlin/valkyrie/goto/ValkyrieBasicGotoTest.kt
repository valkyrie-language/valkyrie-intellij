package valkyrie.goto

import org.junit.Test
import valkyrie.test.ValkyrieTestCase
import com.intellij.codeInsight.navigation.actions.GotoDeclarationAction

/**
 * Valkyrie 基础跳转功能测试
 * 测试基本的跳转到定义功能
 */
class ValkyrieBasicGotoTest : ValkyrieTestCase() {
    
    @Test
    fun testVariableGoto() {
        // 测试变量跳转
        val code = "let x = 42\nlet y = x"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到变量使用处
        val xUsageOffset = code.indexOf("x", code.indexOf("y = "))
        myFixture.editor.caretModel.moveToOffset(xUsageOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            xUsageOffset
        )
        
        assertTrue("Should find goto target for variable x", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testFunctionGoto() {
        // 测试函数跳转
        val code = "fn hello() {}\nhello()"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到函数调用处
        val functionCallOffset = code.indexOf("hello", code.indexOf("}"))
        myFixture.editor.caretModel.moveToOffset(functionCallOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            functionCallOffset
        )
        
        assertTrue("Should find goto target for function hello", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testParameterGoto() {
        // 测试参数跳转
        val code = "fn process(data: String) { println(data) }"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到参数使用处
        val paramUsageOffset = code.indexOf("data", code.indexOf("println"))
        myFixture.editor.caretModel.moveToOffset(paramUsageOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            paramUsageOffset
        )
        
        assertTrue("Should find goto target for parameter data", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testTypeGoto() {
        // 测试类型跳转
        val code = "struct Point { x: f64, y: f64 }\nlet p: Point = Point { x: 0.0, y: 0.0 }"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到类型使用处
        val typeUsageOffset = code.indexOf("Point", code.indexOf("let p:"))
        myFixture.editor.caretModel.moveToOffset(typeUsageOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            typeUsageOffset
        )
        
        assertTrue("Should find goto target for type Point", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testFieldGoto() {
        // 测试字段跳转
        val code = "struct Point { x: f64, y: f64 }\nlet p = Point { x: 1.0, y: 2.0 }\nprintln(p.x)"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到字段访问处
        val fieldAccessOffset = code.indexOf("x", code.indexOf("p."))
        myFixture.editor.caretModel.moveToOffset(fieldAccessOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            fieldAccessOffset
        )
        
        assertTrue("Should find goto target for field x", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testMethodGoto() {
        // 测试方法跳转
        val code = "impl Point { fn distance(&self) -> f64 { 0.0 } }\nlet p = Point { x: 1.0, y: 2.0 }\np.distance()"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到方法调用处
        val methodCallOffset = code.indexOf("distance", code.indexOf("p."))
        myFixture.editor.caretModel.moveToOffset(methodCallOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            methodCallOffset
        )
        
        assertTrue("Should find goto target for method distance", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testLocalVariableGoto() {
        // 测试局部变量跳转
        val code = "fn test() { let local = 42; println(local) }"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到局部变量使用处
        val localUsageOffset = code.indexOf("local", code.indexOf("println"))
        myFixture.editor.caretModel.moveToOffset(localUsageOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            localUsageOffset
        )
        
        assertTrue("Should find goto target for local variable", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testCrossFileGoto() {
        // 测试跨文件跳转
        // 创建辅助文件
        myFixture.addFileToProject("utils.vk", "pub fn helper() {}")
        
        // 创建主文件
        val mainCode = "use utils::helper\nfn main() { helper() }"
        val psiFile = myFixture.configureByText("main.vk", mainCode)
        
        // 将光标移动到函数调用处
        val helperCallOffset = mainCode.indexOf("helper", mainCode.indexOf("main"))
        myFixture.editor.caretModel.moveToOffset(helperCallOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            helperCallOffset
        )
        
        assertTrue("Should find goto target for cross-file function", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testNoGotoTargets() {
        // 测试没有跳转目标的情况
        val code = "let x = undefined_variable"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到未定义变量处
        val undefinedOffset = code.indexOf("undefined_variable")
        myFixture.editor.caretModel.moveToOffset(undefinedOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            undefinedOffset
        )
        
        assertTrue("Should not find goto target for undefined variable", gotoTargets.isEmpty())
    }
    
    @Test
    fun testGenericTypeGoto() {
        // 测试泛型类型跳转
        val code = "struct Container<T> { value: T }\nlet c: Container<i32> = Container { value: 42 }"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到泛型类型使用处
        val containerUsageOffset = code.indexOf("Container", code.indexOf("let c:"))
        myFixture.editor.caretModel.moveToOffset(containerUsageOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            containerUsageOffset
        )
        
        assertTrue("Should find goto target for generic type", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testClosureVariableGoto() {
        // 测试闭包变量跳转
        val code = "fn test() { let x = 42; let closure = || { println(x) }; }"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到闭包中的变量使用处
        val closureVarOffset = code.indexOf("x", code.indexOf("println"))
        myFixture.editor.caretModel.moveToOffset(closureVarOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            closureVarOffset
        )
        
        assertTrue("Should find goto target for closure variable", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testComplexExpressionGoto() {
        // 测试复杂表达式中的跳转
        val code = "fn calculate(a: i32, b: i32) -> i32 { a + b }\nlet result = calculate(10, 20) + calculate(30, 40)"
        val psiFile = myFixture.configureByText("test.vk", code)
        
        // 将光标移动到第一个函数调用处
        val firstCallOffset = code.indexOf("calculate", code.indexOf("result"))
        myFixture.editor.caretModel.moveToOffset(firstCallOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            firstCallOffset
        )
        
        assertTrue("Should find goto target for function in complex expression", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testDebugGotoTargets() {
        // 测试调试相关的跳转功能
        val complexCode = """
            struct Point {
                x: f64,
                y: f64
            }
            
            impl Point {
                fn new(x: f64, y: f64) -> Point {
                    Point { x, y }
                }
            }
            
            fn main() {
                let p1 = Point::new(0.0, 0.0)
            }
        """.trimIndent()
        
        val psiFile = myFixture.configureByText("test.vk", complexCode)
        
        // 测试 Point::new 的跳转
        val newCallOffset = complexCode.indexOf("new", complexCode.indexOf("Point::"))
        myFixture.editor.caretModel.moveToOffset(newCallOffset)
        
        val gotoTargets = GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            newCallOffset
        )
        
        assertTrue("Should find goto target for method new", gotoTargets.isNotEmpty())
    }
}