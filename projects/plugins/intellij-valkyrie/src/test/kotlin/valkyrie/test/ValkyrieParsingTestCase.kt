package valkyrie.test

import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.TestTimeout
import valkyrie.psi.parsers.ValkyrieParserDefinition
import java.nio.file.Path

/**
 * Parser fixtures under `src/test/resources/<dataSubdir>/`:
 * - preferred: `{Name}.code.valkyrie` + `{Name}.expects.txt`
 * - legacy: `{Name}.valkyrie` + `{Name}.txt`
 */
abstract class ValkyrieParsingTestCase(
    dataSubdir: String,
    fileExtension: String = "valkyrie",
) : ParsingTestCase(dataSubdir, fileExtension, ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String =
        Path.of("src/test/resources").toAbsolutePath().normalize().toString()

    override fun doTest(checkResult: Boolean, ensureNoErrorElements: Boolean) {
        TestTimeout.run {
            super.doTest(checkResult, ensureNoErrorElements)
        }
    }
}
