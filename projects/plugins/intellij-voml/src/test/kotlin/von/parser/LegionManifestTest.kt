package von.parser

import von.test.VonParsingTestCase

class LegionManifestTest : VonParsingTestCase("testData/parser/legion") {
    fun testAtlasTools() = doTest(true, true)
}
