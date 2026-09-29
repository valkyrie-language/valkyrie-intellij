# Script 块规范

## 概述

`<script>` 块用于定义 widget 的脚本逻辑。

## 属性

| 属性 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `language` | string | `"valkyrie"` | 脚本语言 |
| `src` | string | - | 外部脚本文件路径 |

## 默认语言

**默认语言：`valkyrie`**

## 支持的语言

| 语言标识 | 说明 |
|----------|------|
| `valkyrie` | Valkyrie 脚本语言（默认，SolidJS 风格） |

## 语法约定

Valkyrie 脚本语言采用简洁的函数式风格：
- 使用 `using` 导入模块
- 使用 `signal()` 创建响应式变量
- 直接在脚本块中定义变量和函数
- 无需定义 widget 类，自动与模板绑定
- 编译时优化

## 示例

### Valkyrie（默认语法）

```vx
<template>
<div class="user-card">
  <img src={user.avatar} alt={user.name} />
  <div class="info">
    <h3>{user.name}</h3>
    <p>{user.bio}</p>
    <button onClick={handle_click}>Clicked {count()} times</button>
    <p>Double: {double_count()}</p>
  </div>
</div>
</template>

<script>
using valkyrie::signal

# 响应式变量
let count = signal(0)

# 函数定义
fn handle_click() {
  count.set(count() + 1)
}

# 计算属性
let double_count = computed(() => count() * 2)
</script>
```

### 外部文件引用

```vx
<script src="./UserCard.valkyrie"></script>
```
