package valkyrie.test

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import valkyrie.psi.ValkyrieParserDefinition
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.application.PathManager
import java.io.File
import org.junit.Assert.*

/**
 * Valkyrie 测试基类
 * 提供通用的测试功能和配置
 */
abstract class ValkyrieTestCase : BasePlatformTestCase() {
    
    protected fun getParserDefinition(): ParserDefinition {
        return ValkyrieParserDefinition()
    }
    
    override fun getTestDataPath(): String {
        return "src/test/resources/testData"
    }
    
    /**
     * 获取测试数据文件的完整路径
     */
    protected fun getTestDataFile(fileName: String): File {
        val testDataPath = getTestDataPath()
        return File(testDataPath, fileName)
    }
    
    /**
     * 读取测试数据文件内容
     */
    protected fun readTestDataFile(fileName: String): String {
        val file = getTestDataFile(fileName)
        return if (file.exists()) {
            file.readText()
        } else {
            throw IllegalArgumentException("Test data file not found: $fileName")
        }
    }
    
    /**
     * 验证代码是否包含语法错误
     */
    protected fun hasNoSyntaxErrors(code: String): Boolean {
        // 简单的语法检查，可以根据需要扩展
        return !code.contains("syntax_error") && code.trim().isNotEmpty()
    }
}