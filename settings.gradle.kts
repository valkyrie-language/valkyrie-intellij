rootProject.name = "Valkyrie Intellij"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("org.jetbrains.intellij.platform.settings") version "2.10.0"
}

dependencyResolutionManagement {
    repositories {
        // 优先使用国内镜像
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://mirrors.tuna.tsinghua.edu.cn/maven/")
        // JetBrains 缓存重定向器
        maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
        maven("https://cache-redirector.jetbrains.com/maven-central")
        // 最后才使用官方仓库
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")

        mavenCentral()
    }
}
