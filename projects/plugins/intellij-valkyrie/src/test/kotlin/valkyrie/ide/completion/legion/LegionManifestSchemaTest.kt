package valkyrie.ide.completion.legion

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class LegionManifestSchemaTest {
    @Test
    fun projectRootContainsCoreFields() {
        val schema = LegionManifestSchema.rootSchema(LegionManifestKind.PROJECT)
        assertNotNull(schema.properties["name"])
        assertNotNull(schema.properties["dependencies"])
        assertNotNull(schema.properties["build"])
        assertNotNull(schema.properties["auto_link"])
    }

    @Test
    fun resolvesNestedDependencyObject() {
        val property = LegionManifestSchema.resolveValueProperty(
            LegionManifestKind.PROJECT,
            listOf("dependencies", "atlas", "version"),
        )
        assertEquals("version", property?.name)
        assertEquals(VonSchemaValueKind.STRING, property?.kind)
    }

    @Test
    fun resolvesBuildArrayItemObject() {
        val objectSchema = LegionManifestSchema.resolveObjectSchema(
            LegionManifestKind.PROJECT,
            listOf("build"),
        )
        assertNotNull(objectSchema?.properties?.get("target"))
    }

    @Test
    fun workspaceRootContainsMembersAndScripts() {
        val schema = LegionManifestSchema.rootSchema(LegionManifestKind.WORKSPACE)
        assertNotNull(schema.properties["packages"])
        assertNotNull(schema.properties["scripts"])
        assertNotNull(schema.properties["dependencies"])
    }
}
