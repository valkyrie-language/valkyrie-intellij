<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# intellij-awsl Changelog

## [Unreleased]

## [0.1.4] - 2026-09-30

### Fixed

- Ship `:packages` as `lib/packages-*.jar` instead of `lib/modules/*.jar` so `awsl.*` extensions load at runtime
- Stop bundling JUnit into the Marketplace plugin distribution

### Changed

- Merged from `awsl-intellij` into the Valkyrie IntelliJ monorepo (`:packages` + `:plugins:intellij-awsl`)
- Replace internal `OptionsBundle` color labels with `AwslBundle` keys
- Use `AbstractBundle` instead of deprecated `DynamicBundle(String)`
- Use non-deprecated `CreateFileFromTemplateAction` and `CreateFileAction` constructors
- Remove unresolved optional dependencies on `org.rust.lang` and `FluentLanguage`
- Register JSON script injection in the main plugin descriptor (no Fluent plugin required)
- Keep optional Sass integration for `<style>` SCSS injection only
- Replace internal `PluginManagerCore.isUnitTestMode` with `Application.isUnitTestMode` in `AnnotatorBase`
- Replace deprecated Apache `StringEscapeUtils` in `AwslFoldingVisitor`
