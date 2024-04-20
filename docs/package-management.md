# 包管理机制

Valkyrie 使用结构化的供应商系统来管理外部包。所有包都存储在以下目录结构中：

```
%LEGION_ROOT%/vendor/
└── [vendor-name@organization-name]/
    └── [package-name]@[package-version]/
        ├── package.vk
        ├── dependencies.json
        └── metadata.json
```

## 目录结构

- **`%LEGION_ROOT%`**: Valkyrie 安装的根目录
- **`vendor/`**: 包含所有外部包的主目录
- **`[vendor-name@organization-name]`**: 供应商和组织的组合，organization-name 可能不存在，也可能有多级
  - 例如：`github@voml`、`github@ygg-lang`、`crates-io@serde`
- **`[package-name]@[package-version]`**: 带版本的包名（例如：`core-utils@1.2.3`）

## 供应商类型

系统支持多种供应商：

- **`github`**: 基于 GitHub 的包
- **`crates-io`**: Rust crates.io 注册表
- **`npm`**: Node.js 包
- **`pypi`**: Python 包
- **`maven`**: Java/Maven 包
- **`custom`**: 自定义私有供应商

## 包元数据

每个包都包含元数据文件：

- **`package.vk`**: 主包定义文件
- **`dependencies.json`**: 包依赖列表
- **`metadata.json`**: 包信息（作者、许可证等）

## 示例结构

```
%LEGION_ROOT%/vendor/
├── github@voml/
│   ├── core-utils@1.2.3/
│   │   ├── package.vk
│   │   ├── dependencies.json
│   │   └── metadata.json
│   └── math-lib@2.0.1/
├── github@ygg-lang/
│   └── ygg-std@0.9.0/
├── crates-io@serde/
│   └── serde@1.0.0/
└── custom@company/
    └── internal-lib@1.0.0/
```

## 配置

可以通过环境变量配置供应商路径：

```bash
export LEGION_ROOT=/path/to/valkyrie/home
```

或者在 Valkyrie 配置文件中：

```toml
[vendor]
root = "/path/to/valkyrie/home/vendor"
default_vendor = "github"
```

## 包解析

当解析包时，系统会：

1. 首先检查本地供应商 (`%LEGION_ROOT%/vendor/`)
2. 如果未找到，尝试从配置的供应商下载
3. 使用元数据验证包完整性
4. 递归安装依赖
5. 更新供应商索引

## 缓存管理

包会被缓存到本地以提高性能。可以使用以下命令清除缓存：

```bash
valkyrie cache clean
```

或者手动删除 `vendor/` 目录。

## 项目配置文件

### legion.json (单项目)

每个 Valkyrie 项目都有一个 `legion.json` 文件作为项目根配置：

```json
{
  "name": "core",
  "version": "1.0.0"
}
```

**注意**：
- 没有 `namespace` 字段
- `name` 可以是简单名称（如 `core`）或带组织的名称（如 `@org/core`）
- 使用 `package` 关键字时，`using package` 相当于 `using core`
- 除非在工作空间中定义了 `alias`

### legions.json (多项目工作空间)

用于组织多个相关项目的 Mono Repo：

```json
{
  "packages": [
    "library/core",
    "library/utils",
    "binary/vnpm"
  ],
  "dependencies": {
    "core": {
      "path": "./library/core"
    },
    "utils": {
      "path": "./library/utils"
    },
    "vnpm": {
      "path": "./binary/vnpm"
    }
  }
}
```

## Mono Repo 支持

Valkyrie 完全支持 Mono Repo（单体仓库）模式。

### 目录结构

```
my-monorepo/
├── legions.json
├── library/
│   ├── core/
│   │   ├── legion.json
│   │   ├── main.vk
│   │   └── types.vk
│   └── utils/
│       ├── legion.json
│       └── math.vk
└── binary/
    ├── vnpm.vk          # 简单命令行工具
    └── complex/
        ├── legion.json
        ├── main.vk      # 复杂命令行工具的入口
        └── utils.vk
```

### 导出规则

- **`library/`**: 下面的文件作为库导出，可以被其他包引用
- **`binary/`**: 下面的文件不导出，作为可执行程序入口

### 命名空间组织

`library/` 下没有入口文件，依据 namespace 组织：

```kotlin
// library/core/main.vk
namespace package::main;  // 自动解析为命名空间

export func helper() -> Unicode {
    return "helper function";
}
```

### 命令行工具

在 `binary/` 目录下定义命令行工具：

```kotlin
// binary/vnpm.vk
namespace package::main;

export func main() -> Integer32 {
    // 命令行工具入口
    return 0;
}
```

或者对于复杂工具：

```kotlin
// binary/complex/main.vk
namespace package::main;

using utils::math;  // 可以引用 library/ 中的库

export func main() -> Integer32 {
    // 复杂命令行工具入口
    return 0;
}
```

### 内部依赖

在 Mono Repo 中，包间依赖使用路径引用：

```json
{
  "name": "vnpm",
  "version": "1.0.0",
  "dependencies": {
    "core": {
      "path": "../library/core"
    },
    "utils": {
      "path": "../library/utils"
    }
  }
}
```

### 引用方式

在 Mono Repo 中，导入使用包名：

```kotlin
// 在 binary/vnpm.vk 或 binary/complex/main.vk 中
using core::types::User;
using utils::math::add;
```

### 构建

使用 `v` 命令构建：

```bash
# 构建整个工作空间
v build

# 构建指定包
v build library/core
v build binary/vnpm
```

**注意**：构建工具是 `v`，不是 `vcc`。`vcc` 是编译器，不负责项目管理或包管理。