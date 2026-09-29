# scripts

| 目录 | 用途 |
|------|------|
| `dev/` | 本地验证，命令与 CI 对齐 |
| `migration/` | 一次性维护脚本 |
| `_lib/` | Python 脚本共享路径工具 |

## 仓库布局

- `projects/plugins/valkyrie` — Valkyrie Marketplace 插件
- `projects/plugins/voml` — VOML/VON Marketplace 插件
- `projects/packages/*` — 可 `publishToMavenLocal` 的库模块
- `projects/designs` — 品牌/设计素材（与 packages、plugins 平级，不进插件 classpath）

## 本地 CI

```bash
node scripts/dev/ci-local.mjs
```

等价于根目录：

```bash
./gradlew ciVerify
```

库模块写入本地 Maven：

```bash
./gradlew publishLibrariesToMavenLocal
```

## 迁移（历史）

```bash
python scripts/migration/fix-lexer-tests.py
```
