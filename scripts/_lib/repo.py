"""Shared path helpers for maintenance scripts."""

from __future__ import annotations

from pathlib import Path


def repo_root(start: Path | None = None) -> Path:
    start = start or Path(__file__).resolve()
    for candidate in (start, *start.parents):
        if (candidate / "build.gradle.kts").is_file() and (candidate / "settings.gradle.kts").is_file():
            return candidate
    raise RuntimeError("repository root not found")


def test_kotlin_root(root: Path | None = None) -> Path:
    return (root or repo_root()) / "src" / "test" / "kotlin"


def test_resources_root(root: Path | None = None) -> Path:
    return (root or repo_root()) / "src" / "test" / "resources"
