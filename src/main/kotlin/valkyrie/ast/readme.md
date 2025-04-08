


定义 type = "array" 的时候, 默认是 ValkyrieArrayNode


CST 中定义
NAME_SPACE = namespace[*!?]?
NAME_SPLIT = [⸬∷]|{:}{2}
AST 中定义

NamePath = id (NAME_SPLIT id)*

重新实现 ValkyrieAnnotationNode, annotation 语法如下

`↯name_path(args)`
`↯name_path`

定义 ValkyrieAnnotationManyNode, 定义为

`↯[name_path(args) { objectBody }, name_path(args), name_path]`

记得用 parsePaired

ValkyrieAnnotationListNode 的元素为 ValkyrieAnnotationNode 或者 ValkyrieAnnotationManyNode

