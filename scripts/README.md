# scripts

| 目录 | 用途 |
|------|------|
| `dev/` | 本地验证，命令与 CI 对齐 |
| `migration/` | 一次性维护脚本 |
| `_lib/` | Python 脚本共享路径工具 |

## 本地 CI

需要同级目录 `../voml-intellij`（与 `settings.gradle.kts` 的 `includeBuild` 一致）。

```bash
node scripts/dev/ci-local.mjs
```

## 迁移（历史）

```bash
python scripts/migration/fix-lexer-tests.py
```
