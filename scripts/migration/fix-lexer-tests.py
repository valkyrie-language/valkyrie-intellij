#!/usr/bin/env python3
"""One-off: migrate lexer tests to ValkyrieLexerTestCase."""

from __future__ import annotations

import re
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "_lib"))
from repo import repo_root, test_kotlin_root

lexer_dir = test_kotlin_root(repo_root(Path(__file__))) / "valkyrie" / "lexer"

for path in sorted(lexer_dir.glob("*.kt")):
    text = path.read_text(encoding="utf-8")
    match = re.search(
        r'override fun getDirPath\(\): String \{\s*return "([^"]+)"\s*\}',
        text,
    )
    if not match:
        print(f"skip {path.name}: no getDirPath")
        continue
    subdir = match.group(1)
    text = text.replace(
        "import com.intellij.testFramework.LexerTestCase\n",
        "import valkyrie.test.ValkyrieLexerTestCase\n",
    )
    text = re.sub(
        r"class (\w+) : LexerTestCase\(\)",
        rf'class \1 : ValkyrieLexerTestCase("{subdir}")',
        text,
        count=1,
    )
    text = re.sub(
        r"\n\s*override fun getDirPath\(\): String \{\s*return \"[^\"]+\"\s*\}\n",
        "\n",
        text,
        count=1,
    )
    path.write_text(text, encoding="utf-8", newline="\n")
    print(f"updated {path.name}")
