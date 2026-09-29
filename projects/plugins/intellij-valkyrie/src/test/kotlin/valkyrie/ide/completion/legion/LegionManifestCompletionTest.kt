package valkyrie.editing.completion.legion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue

class VonManifestPsiContextTest : BasePlatformTestCase() {
    fun testResolveRootObjectKeySiteOnWhitespace() {
        val file = myFixture.configureByText(
            "legion.von",
            """
            {
                <caret>
            }
            """.trimIndent(),
        )
        val ctx = VonManifestPsiContext.resolve(file.findElementAt(myFixture.caretOffset)!!)
        assertNotNull(ctx)
        assertEquals(VonCompletionSiteKind.OBJECT_KEY, ctx!!.site)
        assertNotNull(ctx.objectSchema?.properties?.get("name"))
        assertNotNull(ctx.objectSchema?.properties?.get("dependencies"))
    }

    fun testResolveNestedObjectKeySite() {
        val file = myFixture.configureByText(
            "legion.von",
            """
            {
                auto_link: {
                    <caret>
                }
            }
            """.trimIndent(),
        )
        val ctx = VonManifestPsiContext.resolve(file.findElementAt(myFixture.caretOffset)!!)
        assertNotNull(ctx)
        assertEquals(VonCompletionSiteKind.OBJECT_KEY, ctx!!.site)
        assertEquals(listOf("auto_link"), ctx.keyPath)
        assertNotNull(ctx.objectSchema?.properties?.get("core"))
        assertNotNull(ctx.objectSchema?.properties?.get("std"))
    }

    fun testResolveBooleanValueSite() {
        val file = myFixture.configureByText(
            "legion.von",
            """
            {
                auto_link: {
                    core: <caret>
                }
            }
            """.trimIndent(),
        )
        val ctx = VonManifestPsiContext.resolve(file.findElementAt(myFixture.caretOffset)!!)
        assertNotNull(ctx)
        assertEquals(VonCompletionSiteKind.OBJECT_VALUE, ctx!!.site)
        assertEquals(listOf("auto_link", "core"), ctx.keyPath)
        assertEquals(VonSchemaValueKind.BOOLEAN, ctx.property?.kind)
    }

    fun testResolveEnumValueSite() {
        val file = myFixture.configureByText(
            "legion.von",
            """
            {
                type: <caret>
            }
            """.trimIndent(),
        )
        val ctx = VonManifestPsiContext.resolve(file.findElementAt(myFixture.caretOffset)!!)
        assertNotNull(ctx)
        assertEquals(VonCompletionSiteKind.OBJECT_VALUE, ctx!!.site)
        assertEquals(VonSchemaValueKind.ENUM, ctx.property?.kind)
        assertTrue(ctx.property!!.enumValues.contains("application"))
    }
}

class LegionManifestCompletionTest : BasePlatformTestCase() {
    fun testRootKeyCompletion() {
        myFixture.configureByText(
            "legion.von",
            """
            {
                <caret>
            }
            """.trimIndent(),
        )
        val variants = myFixture.completeBasic()
        assertNotNull("expected multiple root key completions", variants)
        assertTrue(variants!!.any { it.lookupString == "name" })
        assertTrue(variants.any { it.lookupString == "dependencies" })
        assertTrue(variants.any { it.lookupString == "auto_link" })
    }

    fun testNestedKeyCompletion() {
        myFixture.configureByText(
            "legion.von",
            """
            {
                auto_link: {
                    <caret>
                }
            }
            """.trimIndent(),
        )
        val variants = myFixture.completeBasic()
        assertNotNull(variants)
        assertTrue(variants!!.any { it.lookupString == "core" })
        assertTrue(variants.any { it.lookupString == "std" })
        assertFalse(variants.any { it.lookupString == "dependencies" })
    }

    fun testEnumValueCompletion() {
        myFixture.configureByText(
            "legion.von",
            """
            {
                type: <caret>
            }
            """.trimIndent(),
        )
        val variants = myFixture.completeBasic()
        assertNotNull(variants)
        assertTrue(
            variants!!.any {
                it.lookupString == "\"application\"" || it.lookupString.contains("application")
            },
        )
    }

    fun testBooleanValueCompletion() {
        myFixture.configureByText(
            "legion.von",
            """
            {
                auto_link: {
                    core: <caret>
                }
            }
            """.trimIndent(),
        )
        val variants = myFixture.completeBasic()
        assertNotNull(variants)
        assertTrue(variants!!.any { it.lookupString == "true" })
        assertTrue(variants.any { it.lookupString == "false" })
    }
}
