# Valkyrie IntelliJ monorepo

Multi-plugin workspace for JetBrains Marketplace plugins and one shared library.

| Path | Role |
|------|------|
| [`projects/plugins/intellij-valkyrie`](projects/plugins/intellij-valkyrie) | Valkyrie language plugin (`README.md` / `CHANGELOG.md` live here) |
| [`projects/plugins/intellij-voml`](projects/plugins/intellij-voml) | VOML / VON plugin (`README.md` / `CHANGELOG.md` live here) |
| [`projects/plugins/intellij-vos`](projects/plugins/intellij-vos) | VOS / JSS plugin (`README.md` / `CHANGELOG.md` live here) |
| [`projects/packages`](projects/packages) | Shared code-only library (`:packages`) |
| [`projects/designs`](projects/designs) | Brand assets |

```bash
./gradlew runIde          # load every :plugins/* together
./gradlew buildPlugins    # separate zip per plugin
./gradlew ciVerify
```

Each plugin module owns its Marketplace text: the whole `README.md` is the description, and `CHANGELOG.md` is the release notes. The repo-root README is monorepo navigation only.
