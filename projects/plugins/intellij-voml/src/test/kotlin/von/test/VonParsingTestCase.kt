package von.test

import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.TestTimeout
import von.language.VonParserDefinition
import java.nio.file.Path

/**
 * Parser fixtures under `src/test/resources/<dataSubdir>/`:
 * - preferred: `{Name}.code.von` + `{Name}.expects.txt`
 * - legacy: `{Name}.von` + `{Name}.txt`
 */
abstract class VonParsingTestCase(
    dataSubdir: String,
    fileExtension: String = "von",
) : ParsingTestCase(dataSubdir, fileExtension, VonParserDefinition()) {
    override fun getTestDataPath(): String =
        Path.of("src/test/resources").toAbsolutePath().normalize().toString()

    override fun doTest(checkResult: Boolean, ensureNoErrorElements: Boolean) {
        TestTimeout.run {
            super.doTest(checkResult, ensureNoErrorElements)
        }
    }
}
