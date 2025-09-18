# Valkyrie SFC (.vx) 规范

## 1. 概述

`.vx` 文件是 Valkyrie 框架的单文件 widget 格式，采用类似 XML 的标签结构组织不同功能块。

## 2. 文件结构

### 2.1 基本格式

```vx
<meta language="yaml">
# 元数据
</meta>

<template language="pug">
<!-- 模板内容 -->
</template>

<script>
// 脚本内容
</script>

<style language="sass">
/* 样式内容 */
</style>
```

### 2.2 块类型

| 块标签          | 必需性 | 数量限制 | 说明    |
| ------------ | --- | ---- | ----- |
| `<meta>`     | 可选  | 0-1  | widget 元数据 |
| `<template>` | 必需  | 1    | 模板定义 |
| `<script>`   | 可选  | 0-N  | 脚本逻辑 |
| `<style>`    | 可选  | 0-N  | 样式定义 |
| 自定义块     | 可选  | 0-N  | 扩展用途 |

## 3. 块规范

### 3.1 `<meta>` 块

用于定义 widget 级元数据。

**属性：**

| 属性         | 类型     | 默认值       | 说明        |
| ---------- | ------ | --------- | --------- |
| `language` | string | `"json5"` | 元数据格式语言   |
| `src`      | string | -         | 外部元数据文件路径 |

**支持的 language 值：**

- `"json5"` - JSON5 格式（默认）
- `"json"` - 标准 JSON
- `"yaml"` / `"yml"` - YAML 格式
- `"toml"` - TOML 格式

**示例：**

```vx
<meta>
{
  title: "组件标题",
  description: "组件描述",
  author: "作者名",
  version: "1.0.0"
}
</meta>
```

### 3.2 `<template>` 块

定义 widget 的模板结构。

**属性：**

| 属性         | 类型     | 默认值     | 说明       |
| ---------- | ------ | ------- | -------- |
| `language` | string | `"tsx"` | 模板语言     |
| `src`      | string | -       | 外部模板文件路径 |

**支持的 language 值：**

- `"tsx"` - TSX 语法（默认）
- `"html"` - 标准 HTML（等价于 `tsx`）
- `"vue"` - Vue 风格（等价于 `mustache`）
- `"mustache"` - Mustache 风格
- `"pug"` - Pug 模板引擎
- `"jade"` - Jade 模板引擎（Pug 旧名）
- `"slim"` - Slim 模板引擎
- `"haml"` - Haml 模板引擎

**语法约定：**

- **TSX/HTML**：使用 `{expression}` 插值语法
- **Vue/Mustache**：使用 `{{expression}}` 语法

**示例：**

```vx
<template>
<div class="container">
  <h1>{title}</h1>
  <p>{description}</p>
  <button @click={handleClick}>Click me</button>
</div>
</template>
```

```vx
<template language="vue">
<div class="container">
  <h1>{{ title }}</h1>
  <p>{{ description }}</p>
  <button @click="handleClick">Click me</button>
</div>
</template>
```

### 3.3 `<script>` 块

定义 widget 的脚本逻辑。

**属性：**

| 属性         | 类型     | 默认值          | 说明       |
| ---------- | ------ | ------------ | -------- |
| `language` | string | `"valkyrie"` | 脚本语言     |
| `src`      | string | -            | 外部脚本文件路径 |

**支持的 language 值：**

- `"valkyrie"` - Valkyrie 脚本语言（默认，SolidJS 风格）

**语法约定：**
Valkyrie 脚本语言采用简洁的函数式风格，无需定义 widget 类，直接在脚本块中定义变量和函数，自动与模板绑定。

**示例：**

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

### 3.4 `<style>` 块

定义 widget 的样式。

**属性：**

| 属性         | 类型             | 默认值      | 说明             |
| ---------- | -------------- | -------- | -------------- |
| `language` | string         | `"scss"` | 样式语言           |
| `scoped`   | boolean        | `false`  | 是否作用域样式        |
| `module`   | boolean/string | `false`  | CSS Modules 配置 |
| `src`      | string         | -        | 外部样式文件路径       |

**支持的 language 值：**

- `"scss"` - SCSS 语法（默认）
- `"sass"` - SASS 缩进语法
- `"css"` - 标准 CSS
- `"less"` - Less 语法
- `"stylus"` - Stylus 语法
- `"postcss"` - PostCSS

**示例：**

```vx
<style scoped>
.user-card {
  display: flex;
  gap: 16px;
  padding: 16px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  
  .avatar {
    width: 64px;
    height: 64px;
    border-radius: 50%;
    object-fit: cover;
  }
  
  .info {
    flex: 1;
    
    .name {
      margin: 0 0 8px;
      font-size: 18px;
      font-weight: 600;
    }
    
    .bio {
      margin: 0;
      color: #666;
    }
  }
}
</style>
```

## 4. 通用属性规范

### 4.1 `src` 属性

用于引用外部文件，此时块内容应为空。

```vx
<template src="./template.pug"></template>
<script src="./logic.ts"></script>
<style src="./styles.scss" scoped></style>
```

### 4.2 `language` 属性

- 值为小写字符串
- 使用标准语言标识符
- 不支持的值应触发警告

## 5. 解析规则

### 5.1 空白处理

- 块之间的空白字符忽略
- 块内容保留原始格式（由具体语言处理器处理）

### 5.2 注释

- 块外不支持注释
- 块内注释遵循该块的语言规则

### 5.3 错误处理

| 错误类型            | 处理方式       |
| --------------- | ---------- |
| 缺少 `<template>` | 解析错误       |
| 多个 `<meta>`     | 解析警告，取第一个  |
| 未知块标签           | 解析警告，保留内容  |
| 无效属性值           | 解析警告，使用默认值 |

## 6. 扩展机制

### 6.1 自定义块

允许定义框架或工具特定的自定义块。

```vx
<docs>
# 组件文档
</docs>

<i18n language="yaml">
en:
  hello: Hello
zh:
  hello: 你好
</i18n>
```

### 6.2 自定义属性

工具可以定义自己的属性前缀，以 `data-` 或 `x-` 开头。

```vx
<style x-tool-specific="value"></style>
```

## 7. 示例完整文件

```vx
<meta>
{
  title: "用户卡片组件",
  description: "显示用户信息的卡片组件",
  author: "Valkyrie Team"
}
</meta>

<template>
<article class="user-card">
  <img class="avatar" :src={user.avatar} :alt={user.name} />
  <div class="info">
    <h3 class="name">{user.name}</h3>
    <p class="bio">{user.bio}</p>
  </div>
</article>
</template>

<script>
using valkyrie::signal

// 响应式变量
let count = signal(0)

// 函数定义
fn handleClick() {
  count.set(count() + 1)
}
</script>

<style scoped>
.user-card {
  display: flex;
  gap: 16px;
  padding: 16px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  
  .avatar {
    width: 64px;
    height: 64px;
    border-radius: 50%;
    object-fit: cover;
  }
  
  .info {
    flex: 1;
    
    .name {
      margin: 0 0 8px;
      font-size: 18px;
      font-weight: 600;
    }
    
    .bio {
      margin: 0;
      color: #666;
    }
  }
}
</style>
```

## 8. 版本

规范版本：1.2.0

### 版本变更记录

**1.2.0**

- 修改 `<template>` 块默认语言为 `tsx`（原为 `html`）
- 新增 `html` 语言选项，等价于 `tsx`
- 新增 `vue` 语言选项，等价于 `mustache`
- 移除 `<script>` 块的 `setup` 参数
- 限制 `<script>` 块仅支持 `valkyrie` 语言
- 更新 Valkyrie 脚本语言采用简洁的函数式风格：
  - 使用 `using` 导入模块（如 `using valkyrie::signal`）
  - 使用 `signal()` 创建响应式变量（如 `let count = signal(0)`）
  - 使用 snake_case 命名（如 `handle_click`、`double_count`）
  - 使用 `#` 作为注释
  - 直接在脚本块中定义变量和函数
  - 无需定义 widget 类，自动与模板绑定
  - 支持计算属性（如 `let double_count = computed(() => count() * 2)`）
  - 推荐模板在前，脚本在后的结构

**1.1.0**

- 修改 `<style>` 块默认语言为 `scss`（原为 `sass`）
- 修改 `<template>` 块默认语言 `html` 采用 TSX 插值约定（`{expression}`）
- 新增 `mustache` 语言选项，使用 `{{expression}}` 语法
- 更新 `<meta>` 块默认语言为 `json5`（原为 `yaml`）
- 更新 `<script>` 块默认语言为 `valkyrie`（原为 `javascript`）

