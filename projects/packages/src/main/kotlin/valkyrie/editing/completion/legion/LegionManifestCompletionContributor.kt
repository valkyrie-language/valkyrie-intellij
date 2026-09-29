package valkyrie.editing.completion.legion

import von.surface.file.VonLanguage
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

/**
 * Schema-driven completion for `legion.von` / `legions.von` using VON PSI.
 */
class LegionManifestCompletionContributor : CompletionContributor() {
    init {
        val legionManifestFile = PlatformPatterns.or(
            PlatformPatterns.psiFile().withName("legion.von"),
            PlatformPatterns.psiFile().withName("legions.von"),
        )
        // Caret usually lands on leaf tokens (`SYMBOL`, `STRING`, whitespace), not composite `KEY_SYMBOL`.
        val vonInLegionManifest = PlatformPatterns.psiElement()
            .withLanguage(VonLanguage.INSTANCE)
            .inFile(legionManifestFile)

        extend(
            CompletionType.BASIC,
            vonInLegionManifest,
            ManifestSchemaCompletionProvider(),
        )
    }

    private class ManifestSchemaCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet,
        ) {
            // Completion inserts a dummy identifier at the caret; resolve against the
            // pre-dummy PSI so `key: <caret>` stays a value site instead of a new key.
            val ctx = VonManifestPsiContext.resolve(parameters.originalPosition ?: parameters.position)
                ?: VonManifestPsiContext.resolve(parameters.position)
                ?: return
            when (ctx.site) {
                VonCompletionSiteKind.OBJECT_KEY,
                VonCompletionSiteKind.MAP_KEY,
                -> ManifestKeyCompletionProvider.addKeyCompletions(ctx, result)

                VonCompletionSiteKind.OBJECT_VALUE,
                VonCompletionSiteKind.ARRAY_ITEM,
                -> {
                    // Dummy text must not filter boolean/enum literals.
                    ManifestValueCompletionProvider.addValueCompletions(ctx, result.withPrefixMatcher(""))
                }
            }
        }
    }

    private object ManifestKeyCompletionProvider {
        fun addKeyCompletions(
            ctx: VonManifestCompletionContext,
            result: CompletionResultSet,
        ) {
            val schema = ctx.objectSchema ?: return
            val prefix = result.prefixMatcher
            schema.properties.values
                .filter { property ->
                    ctx.site == VonCompletionSiteKind.MAP_KEY || property.name !in ctx.existingKeys
                }
                .forEach { property ->
                    if (!prefix.prefixMatches(property.name)) {
                        return@forEach
                    }
                    result.addElement(
                        LookupElementBuilder.create(property.name)
                            .withTypeText(property.kind.name.lowercase())
                            .withTailText(property.description?.let { " — $it" } ?: "", true)
                            .withInsertHandler { insertContext, _ ->
                                val document = insertContext.document
                                val tail = insertContext.tailOffset
                                if (tail < document.textLength && document.text[tail] == ':') {
                                    insertContext.editor.caretModel.moveToOffset(tail + 1)
                                } else {
                                    document.insertString(tail, ": ")
                                    insertContext.editor.caretModel.moveToOffset(tail + 2)
                                }
                            },
                    )
                }
        }
    }

    private object ManifestValueCompletionProvider {
        fun addValueCompletions(
            ctx: VonManifestCompletionContext,
            result: CompletionResultSet,
        ) {
            val property = ctx.property ?: return
            when (property.kind) {
                VonSchemaValueKind.BOOLEAN -> {
                    listOf("true", "false").forEach { value ->
                        result.addElement(
                            LookupElementBuilder.create(value).withTypeText("boolean"),
                        )
                    }
                }

                VonSchemaValueKind.ENUM -> {
                    property.enumValues.forEach { value ->
                        result.addElement(
                            LookupElementBuilder.create("\"$value\"")
                                .withPresentableText(value)
                                .withTypeText("enum"),
                        )
                    }
                }

                VonSchemaValueKind.STRING -> {
                    if (property.name == "version") {
                        listOf("\"workspace\"", "\"latest\"", "\"0.1.0\"").forEach { sample ->
                            result.addElement(
                                LookupElementBuilder.create(sample).withTypeText("version"),
                            )
                        }
                    }
                }

                VonSchemaValueKind.OBJECT -> {
                    result.addElement(
                        LookupElementBuilder.create("{ }")
                            .withPresentableText("{}")
                            .withTypeText("object")
                            .withInsertHandler { insertContext, _ ->
                                val start = insertContext.tailOffset - 3
                                insertContext.document.insertString(start + 2, "\n    \n")
                                insertContext.editor.caretModel.moveToOffset(start + 6)
                            },
                    )
                }

                VonSchemaValueKind.ARRAY -> {
                    result.addElement(
                        LookupElementBuilder.create("[ ]")
                            .withPresentableText("[]")
                            .withTypeText("array")
                            .withInsertHandler { insertContext, _ ->
                                val start = insertContext.tailOffset - 3
                                insertContext.document.insertString(start + 1, "\n    \n")
                                insertContext.editor.caretModel.moveToOffset(start + 6)
                            },
                    )
                }

                VonSchemaValueKind.UNION -> {
                    property.unionSchemas.forEach { branch ->
                        when (branch.kind) {
                            VonSchemaValueKind.STRING -> {
                                result.addElement(
                                    LookupElementBuilder.create("\"workspace\"")
                                        .withPresentableText("workspace")
                                        .withTypeText("version"),
                                )
                            }
                            VonSchemaValueKind.OBJECT -> {
                                result.addElement(
                                    LookupElementBuilder.create("{ }")
                                        .withPresentableText("{}")
                                        .withTypeText("dependency table"),
                                )
                            }
                            else -> Unit
                        }
                    }
                }

                VonSchemaValueKind.MAP,
                VonSchemaValueKind.NUMBER,
                -> Unit
            }

            if (ctx.site == VonCompletionSiteKind.ARRAY_ITEM && property.objectSchema != null) {
                result.addElement(
                    LookupElementBuilder.create("{ }")
                        .withPresentableText("{}")
                        .withTypeText("object item"),
                )
            }
        }
    }
}
