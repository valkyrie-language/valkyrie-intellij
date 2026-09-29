package valkyrie.test

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieParserDefinition
import java.nio.file.Path

abstract class ValkyrieParsingTestCase(
    dataSubdir: String,
    fileExtension: String = "valkyrie",
) : ParsingTestCase(dataSubdir, fileExtension, ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String =
        Path.of("src/test/resources").toAbsolutePath().normalize().toString()
}
