pluginManagement {
    repositories {
        maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/gradle-plugins/") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        gradlePluginPortal()
    }
}

rootProject.name = "Valkyrie Intellij"

// `:packages` is the single shared library (no nested children).
include("packages")
project(":packages").projectDir = file("projects/packages")

include(
    "plugins",
    "plugins:intellij-voml",
    "plugins:intellij-vos",
    "plugins:intellij-valkyrie",
)
project(":plugins").projectDir = file("projects/plugins")
project(":plugins:intellij-voml").projectDir = file("projects/plugins/intellij-voml")
project(":plugins:intellij-vos").projectDir = file("projects/plugins/intellij-vos")
project(":plugins:intellij-valkyrie").projectDir = file("projects/plugins/intellij-valkyrie")
