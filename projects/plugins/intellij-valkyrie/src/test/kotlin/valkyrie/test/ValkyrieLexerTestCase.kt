package valkyrie.test

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import com.intellij.testFramework.TestTimeout
import java.nio.file.Path

/**
 * Lexer expects under `src/test/resources/<dataSubdir>/`:
 * - preferred: `{Name}.expects.txt`
 * - legacy: `{Name}.txt`
 *
 * Code may be inlined via `doTest("…")`, or provided as `{Name}.code.valkyrie` for file-driven cases.
 */
abstract class ValkyrieLexerTestCase(
    private val dataSubdir: String,
) : LexerTestCase() {
    override fun getDirPath(): String = dataSubdir

    override fun getPathToTestDataFile(extension: String): String {
        val suite = Path.of("src/test/resources").resolve(dataSubdir)
        val testName = getTestName(true)
        val preferred = suite.resolve("$testName.expects.txt")
        val legacy = suite.resolve("$testName$extension")
        val target = when {
            preferred.toFile().isFile -> preferred
            else -> legacy
        }
        return target.toAbsolutePath().normalize().toString()
    }

    override fun doTest(text: String, expected: String?, lexer: Lexer) {
        TestTimeout.run {
            super.doTest(text, expected, lexer)
        }
    }
}
