package von.test

import com.intellij.testFramework.ParsingTestCase
import von.language.VonParserDefinition
import java.nio.file.Path

abstract class VonParsingTestCase(
    dataSubdir: String,
    fileExtension: String = "von",
) : ParsingTestCase(dataSubdir, fileExtension, VonParserDefinition()) {
    override fun getTestDataPath(): String =
        Path.of("src/test/resources").toAbsolutePath().normalize().toString()
}
