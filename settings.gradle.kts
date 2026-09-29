pluginManagement {
    repositories {
        maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/gradle-plugins/") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        gradlePluginPortal()
    }
}

rootProject.name = "Valkyrie Intellij"

include(
    "packages",
    "packages:valkyrie-icons",
    "packages:valkyrie-bundle",
    "plugins",
    "plugins:voml",
    "plugins:valkyrie",
)

project(":packages").projectDir = file("projects/packages")
project(":packages:valkyrie-icons").projectDir = file("projects/packages/valkyrie-icons")
project(":packages:valkyrie-bundle").projectDir = file("projects/packages/valkyrie-bundle")

project(":plugins").projectDir = file("projects/plugins")
project(":plugins:voml").projectDir = file("projects/plugins/voml")
project(":plugins:valkyrie").projectDir = file("projects/plugins/valkyrie")
