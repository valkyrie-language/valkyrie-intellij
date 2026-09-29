# Meta 块规范

## 概述

`<meta>` 块用于定义 widget 级元数据。

## 属性

| 属性 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `language` | string | `"json5"` | 元数据格式语言 |
| `src` | string | - | 外部元数据文件路径 |

## 默认语言

**默认语言：`json5`**

## 支持的语言及方言

| 语言标识 | 说明 |
|----------|------|
| `json5` | JSON5 格式（默认） |
| `json` | 标准 JSON |
| `yaml` / `yml` | YAML 格式 |
| `toml` | TOML 格式 |

## 示例

### JSON5（默认）

```vx
<meta>
{
  // 组件标题
  title: "用户卡片组件",
  description: "显示用户信息的卡片组件",
  author: "Valkyrie Team",
  version: "1.0.0",
  keywords: ["user", "card", "profile"],
}
</meta>
```

### JSON

```vx
<meta language="json">
{
  "title": "用户卡片组件",
  "description": "显示用户信息的卡片组件",
  "author": "Valkyrie Team",
  "version": "1.0.0"
}
</meta>
```

### YAML

```vx
<meta language="yaml">
title: 用户卡片组件
description: 显示用户信息的卡片组件
author: Valkyrie Team
version: 1.0.0
keywords:
  - user
  - card
  - profile
</meta>
```

### TOML

```vx
<meta language="toml">
title = "用户卡片组件"
description = "显示用户信息的卡片组件"
author = "Valkyrie Team"
version = "1.0.0"
keywords = ["user", "card", "profile"]
</meta>
```

### 外部文件引用

```vx
<meta src="./meta.yaml" language="yaml"></meta>
```

## 标准元数据字段

| 字段 | 类型 | 说明 |
|------|------|------|
| `title` | string | 组件标题 |
| `description` | string | 组件描述 |
| `author` | string | 作者 |
| `version` | string | 版本号 |
| `keywords` | string[] | 关键词 |
| `category` | string | 分类 |
| `icon` | string | 图标 |
| `preview` | string | 预览图路径 |
