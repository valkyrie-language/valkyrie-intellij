# Valkyrie 模块管理系统

## 🎯 功能概述

本目录实现了完整的 Valkyrie 模块管理系统，支持：

- **单项目管理**：基于 `legion.json` 的包配置
- **多项目组织**：基于 `legions.json` 的工作空间
- **命名空间系统**：包级命名空间和模块组织
- **跨包解析**：完整的符号解析和导入系统
- **动态重命名**：包别名和导入重命名支持

## 📁 文件结构

### 核心数据结构
- `ValkyriePackageInfo.kt` - 扩展包信息（命名空间、导出、别名）
- `ValkyriePackageDependency.kt` - 依赖管理（多源支持）
- `ValkyrieWorkspace.kt` - 工作空间（包别名映射）

### 解析器
- `ValkyrieProjectParser.kt` - 解析 `legion.json`
- `ValkyrieWorkspaceParser.kt` - 解析 `legions.json` 和依赖

### 服务
- `ValkyriePackageManager.kt` - 包管理服务
- `ValkyrieEnhancedSymbolIndex.kt` - 增强符号索引
- `ValkyriePackageValidator.kt` - 配置验证

## 🔧 关键特性

### 1. 配置文件格式

**legion.json**：
```json
{
  "name": "core",
  "version": "1.0.0",
  "namespace": "com.valkyrie.core",
  "exports": ["types", "utils"],
  "dependencies": {
    "utils": "1.0.0"
  }
}
```

**legions.json**：
```json
{
  "packages": ["packages/core", "packages/utils"],
  "dependencies": {
    "core": {
      "path": "./packages/core",
      "alias": "core_lib"
    }
  }
}
```

### 2. 命名空间系统

```kotlin
// legion.json 中定义
{
  "name": "core",
  "namespace": "com.valkyrie.core"
}

// 代码中使用 package 关键字
namespace package::types;  // 实际解析为 com.valkyrie.core.types
```

### 3. 跨包导入

```kotlin
// 基本导入
using core::types::User;

// 别名导入（使用 legions.json 中的别名）
using core_lib::types::User;

// 重命名导入
using core::types::User as CoreUser;
```

### 4. 符号解析流程

1. **当前包优先**：在当前文件和包中查找
2. **命名空间匹配**：相同命名空间的其他文件
3. **导入解析**：通过 `using` 语句导入的符号
4. **包限定**：支持 `package::symbol` 语法

## 🚀 使用示例

### 创建工作空间

```bash
mkdir my-project
cd my-project
mkdir -p packages/{core,utils,web}
```

### 配置工作空间

**legions.json**：
```json
{
  "packages": ["packages/core", "packages/utils", "packages/web"],
  "dependencies": {
    "core": {"path": "./packages/core", "alias": "core_lib"},
    "utils": {"path": "./packages/utils", "alias": "util"}
  }
}
```

### 配置包

**packages/core/legion.json**：
```json
{
  "name": "core",
  "version": "1.0.0",
  "namespace": "com.myproject.core",
  "exports": ["types"]
}
```

### 编写代码

**packages/core/types.vk**：
```kotlin
namespace package::types;

export class User {
    id: Integer32;
    name: Unicode;
}
```

**packages/web/app.vk**：
```kotlin
namespace package::app;

using core_lib::types::User;
using util::math::add;

export func create_user(name: Unicode) -> User {
    let id = add(1, 1000);
    return User(id: id, name: name);
}
```

## 🛠️ 实现细节

### 包管理服务 (ValkyriePackageManager)

- **依赖解析**：支持本地、外部、Git 依赖源
- **包查找**：通过名称或别名查找包目录
- **命名空间解析**：获取包的命名空间
- **符号路径解析**：解析 `package::module::symbol` 语法

### 增强符号索引 (ValkyrieEnhancedSymbolIndex)

- **跨包索引**：索引所有工作空间和依赖包
- **别名处理**：支持包别名和导入重命名
- **导出控制**：只允许访问导出的符号
- **缓存优化**：高效的符号查找和引用解析

### 验证系统 (ValkyriePackageValidator)

- **格式验证**：包名、版本、命名空间格式检查
- **依赖验证**：冲突检测和循环依赖检查
- **命名空间验证**：冲突检测
- **错误报告**：详细的错误和警告信息

## 📋 任务完成状态

- ✅ 扩展数据结构支持命名空间和导出
- ✅ 增强解析器支持新配置格式
- ✅ 创建包管理服务
- ✅ 重构符号索引支持跨包解析
- ✅ 实现包重命名和别名支持
- ✅ 添加错误处理和验证
- ✅ 创建测试和示例
- ✅ 更新文档

## 🔍 与现有系统的集成

本系统与现有 Valkyrie 插件完全兼容：

- **向后兼容**：现有项目无需修改即可工作
- **渐进式采用**：可以逐步迁移到新系统
- **统一接口**：增强现有服务而不破坏 API
- **性能优化**：使用缓存和增量索引

## 📝 配置说明

### 环境变量

- `VALKYRIE_HOME` - Valkyrie 安装目录，用于查找外部包

### 文件格式验证

系统会自动验证：
- 包名格式（小写字母、数字、连字符）
- 版本号格式（语义化版本）
- 命名空间格式（点分隔标识符）
- 依赖冲突和循环依赖

## 🎯 最佳实践

1. **命名空间设计**：使用反向域名格式 `com.company.project`
2. **模块划分**：按功能划分模块，避免单一大文件
3. **导出策略**：只导出必要的 API，隐藏内部实现
4. **版本管理**：遵循语义化版本规范
5. **别名使用**：为长包名提供简短别名，提高可读性