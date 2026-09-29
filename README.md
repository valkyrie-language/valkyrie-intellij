# Valkyrie IntelliJ monorepo

Multi-plugin workspace for JetBrains Marketplace plugins and one shared library.

| Path | Role |
|------|------|
| [`projects/plugins/intellij-valkyrie`](projects/plugins/intellij-valkyrie) | Valkyrie language plugin (`README.md` / `CHANGELOG.md` live here) |
| [`projects/plugins/intellij-voml`](projects/plugins/intellij-voml) | VOML / VON plugin (`README.md` / `CHANGELOG.md` live here) |
| [`projects/packages`](projects/packages) | Shared code-only library (`:packages`) |
| [`projects/designs`](projects/designs) | Brand assets |

```bash
./gradlew runIde          # load every :plugins/* together
./gradlew buildPlugins    # separate zip per plugin
./gradlew ciVerify
```

Marketplace description and changelog for each plugin are **only** under that plugin directory — not at the repo root.
