package valkyrie.test

import com.intellij.testFramework.LexerTestCase
import java.nio.file.Path

abstract class ValkyrieLexerTestCase(
    private val dataSubdir: String,
) : LexerTestCase() {
    override fun getDirPath(): String = dataSubdir

    override fun getPathToTestDataFile(extension: String): String =
        Path.of("src/test/resources")
            .resolve(dataSubdir)
            .resolve("${getTestName(true)}$extension")
            .toAbsolutePath()
            .normalize()
            .toString()
}
