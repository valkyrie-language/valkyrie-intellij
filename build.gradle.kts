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
        description = "CI gate: compile, compile tests, and package the Valkyrie plugin."
        dependsOn(":plugins:valkyrie:ciVerify")
    }

    register("publishLibrariesToMavenLocal") {
        group = "publishing"
        description = "Publish packages/* to the local Maven repository."
        dependsOn(
            ":packages:valkyrie-icons:publishToMavenLocal",
            ":packages:valkyrie-bundle:publishToMavenLocal",
        )
    }
}
