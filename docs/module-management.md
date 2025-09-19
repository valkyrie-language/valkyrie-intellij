# 模块管理系统

Valkyrie 的模块管理系统采用分层结构来组织代码，支持单项目和多项目两种模式。

## 目录结构

### 单项目模式

在单项目模式下，使用 `legion.json` 作为项目根配置文件：

```
project-root/
├── legion.json
├── library/
│   ├── main.vk
│   ├── utils.vk
│   └── ...
└── vendor/
    └── ...  # 依赖包
```

### 多项目模式 (Mono Repo)

在多项目模式下，使用 `legions.json` 作为根配置文件：

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

## 配置文件

### legion.json (单项目)

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

### legions.json (多项目工作空间)

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

## 导出规则

- **`library/`**: 下面的文件作为库导出，可以被其他包引用
- **`binary/`**: 下面的文件不导出，作为可执行程序入口

## 命名空间组织

### library/ 目录

`library/` 下没有入口文件，依据 namespace 组织：

```kotlin
// library/core/main.vk
namespace package::main;  // 自动解析为命名空间

export func helper() -> Unicode {
    return "helper function";
}
```

文件路径自动映射到命名空间：
- `main.vk` → `core::main`
- `types.vk` → `core::types`
- `utils/math.vk` → `utils::math`

### binary/ 目录

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

## 模块解析

当解析模块时，系统会：

1. **查找配置文件**: 首先查找 `legion.json` 或 `legions.json`
2. **解析命名空间**: 根据文件路径自动解析命名空间
3. **加载依赖**: 从 `vendor/` 目录加载外部依赖，或从工作空间加载内部依赖
4. **验证模块**: 检查模块间的依赖关系和循环引用
5. **构建模块图**: 生成模块依赖关系图用于编译优化

## 导入语法

### 基本导入

```kotlin
// 导入整个命名空间
using core::types;

// 导入特定符号
using core::main::helper;

// 导入并重命名
using utils::math as math_utils;
```

### Mono Repo 导入

在 Mono Repo 中，使用包名导入：

```kotlin
// 在 binary/vnpm.vk 或 binary/complex/main.vk 中
using core::types::User;        // 导入 library/core 中的类型
using utils::math::add;         // 导入 library/utils 中的函数
```

### package 关键字

在代码中使用 `package` 关键字：

```kotlin
// library/core/main.vk
namespace package::main;  // 自动解析为 core::main

export func helper() -> Unicode {
    return "helper function";
}
```

## 最佳实践

1. **目录组织**: 
   - `library/` 目录下存放库代码（可重用模块）
   - `binary/` 目录下存放可执行程序入口
2. **命名空间设计**: 使用包名作为命名空间前缀
3. **模块粒度**: 保持模块职责单一，避免过大的模块
4. **依赖管理**: 明确声明依赖，避免隐式依赖
5. **导出控制**: 只导出必要的 API，隐藏内部实现