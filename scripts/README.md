# scripts

| 目录 | 用途 |
|------|------|
| `dev/` | 本地验证，命令与 CI 对齐 |
| `migration/` | 一次性维护脚本 |
| `_lib/` | Python 脚本共享路径工具 |

## 仓库布局

- `projects/plugins/intellij-valkyrie` — Valkyrie Marketplace 插件
- `projects/plugins/intellij-voml` — VOML/VON Marketplace 插件
- `projects/packages` — 唯一共享库（代码 only，无 `resources`，工程名 `:packages`）
- `projects/designs` — 品牌/设计素材（与 packages、plugins 平级）

## 本地 CI

```bash
node scripts/dev/ci-local.mjs
```

等价于根目录：

```bash
./gradlew ciVerify
```

## Run vs Build

| 任务 | 行为 |
|------|------|
| `./gradlew runIde` | 一次拉起 IDE，加载全部 `:plugins/*`（共用 sandbox） |
| `./gradlew buildPlugins` | 分别打出每个插件自己的 zip，互不合并 |
| `:plugins:intellij-voml:publishPlugin` / `:plugins:intellij-valkyrie:publishPlugin` | 各自上传与审核 |

库模块写入本地 Maven：

```bash
./gradlew publishLibrariesToMavenLocal
```

## 迁移（历史）

```bash
python scripts/migration/fix-lexer-tests.py
```
