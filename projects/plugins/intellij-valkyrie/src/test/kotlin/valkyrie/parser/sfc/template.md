# Template 块规范

## 概述

`<template>` 块用于定义 widget 的模板结构。

## 属性

| 属性 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `language` | string | `"tsx"` | 模板语言 |
| `src` | string | - | 外部模板文件路径 |

## 默认语言

**默认语言：`tsx`**

## 支持的语言及方言

| 语言标识 | 说明 | 插值语法 | 说明 |
|----------|------|----------|------|
| `tsx` | TSX 语法（默认） | `{expression}` | 支持 JSX/TSX 语法 |
| `html` | 标准 HTML | `{expression}` | 等价于 `tsx` |
| `vue` | Vue 风格 | `{{expression}}` | 等价于 `mustache` |
| `mustache` | Mustache 风格 | `{{expression}}` | 传统模板语法 |
| `pug` | Pug 模板引擎 | `#{expression}` | 缩进式模板 |
| `jade` | Jade 模板引擎（Pug 旧名） | `#{expression}` | 缩进式模板 |
| `slim` | Slim 模板引擎 | `#{expression}` | 缩进式模板 |
| `haml` | Haml 模板引擎 | `= expression` | 缩进式模板 |

## 语法约定

### TSX/HTML 风格（默认）
- **插值语法**：`{expression}`
- **动态属性**：`{attribute}` 或 `:attribute`
- **事件绑定**：`@event` 或 `onEvent`

### Vue/Mustache 风格
- **插值语法**：`{{expression}}`
- **动态属性**：`v-bind:attribute` 或 `:attribute`
- **事件绑定**：`v-on:event` 或 `@event`

## 示例

### TSX（默认）

```vx
<template>
<div class="container">
  <h1>{title}</h1>
  <p>{description}</p>
  <button @click={handleClick}>Click me</button>
  <input :value={name} />
</div>
</template>
```

### HTML（等价于 TSX）

```vx
<template language="html">
<div class="container">
  <h1>{title}</h1>
  <p>{description}</p>
  <button @click={handleClick}>Click me</button>
  <input :value={name} />
</div>
</template>
```

### Vue 风格

```vx
<template language="vue">
<div class="container">
  <h1>{{ title }}</h1>
  <p>{{ description }}</p>
  <button @click="handleClick">Click me</button>
  <input :value="name" />
</div>
</template>
```

### Pug

```vx
<template language="pug">
div.container
  h1 #{title}
  p #{description}
  button(@click="handleClick") Click me
  input(:value="name")
</template>
```

### 外部文件引用

```vx
<template src="./template.tsx"></template>
```
