plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.intelliJPlatform) apply false
    alias(libs.plugins.intelliJPlatformModule) apply false
    alias(libs.plugins.changelog) apply false
    alias(libs.plugins.qodana) apply false
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    register("ciVerify") {
        group = "verification"
        description = "CI gate: compile, compile tests, and package each Marketplace plugin separately."
        dependsOn(
            ":plugins:intellij-awsl:ciVerify",
            ":plugins:intellij-voml:ciVerify",
            ":plugins:intellij-vos:ciVerify",
            ":plugins:intellij-valkyrie:ciVerify",
        )
    }

    register("buildPlugins") {
        group = "build"
        description = "Build every Marketplace plugin zip separately for individual Marketplace upload."
        dependsOn(
            ":plugins:intellij-awsl:buildPlugin",
            ":plugins:intellij-voml:buildPlugin",
            ":plugins:intellij-vos:buildPlugin",
            ":plugins:intellij-valkyrie:buildPlugin",
        )
    }

    // Host sandbox on Valkyrie (Ultimate). Sibling plugins are injected via gradle/ide-all-plugins.gradle.kts.
    register("runIde") {
        group = "intellij"
        description = "Run IDE with every `:plugins/*` Marketplace plugin loaded together."
        dependsOn(":plugins:intellij-valkyrie:runIde")
    }

    register("publishLibrariesToMavenLocal") {
        group = "publishing"
        description = "Publish `:packages` to the local Maven repository."
        dependsOn(":packages:publishToMavenLocal")
    }
}
