import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.extensions.IntelliJPlatformDependenciesExtension
import org.jetbrains.intellij.platform.gradle.extensions.IntelliJPlatformDependencyConfiguration
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.2.10"
    alias(libs.plugins.changelog)
    alias(libs.plugins.qodana)
    alias(libs.plugins.kover)
    id("org.jetbrains.intellij.platform") version "2.9.0"
//    id("org.jetbrains.intellij.platform.module") version "2.9.0"
}
repositories {
    intellijPlatform {
        defaultRepositories()
    }
}

repositories {
    mavenCentral()
}

group = properties("pluginGroup").get()
version = properties("pluginVersion").get()


dependencies {
    intellijPlatform {
        // https://youtrack.jetbrains.com/articles/IDEA-A-2100662347/IntelliJ-IDEA-2025.1-Latest-Builds
        create(IntelliJPlatformType.IntellijIdeaUltimate, "2025.2")
//        create(IntelliJPlatformType.IntellijIdea, "2025.3") { useInstaller = true }

        bundledPlugin("com.intellij.java")
        bundledPlugin("com.intellij.modules.json")
        bundledPlugin("org.toml.lang")
        bundledPlugin("org.intellij.plugins.markdown")
//        // https://plugins.jetbrains.com/plugin/227-psiviewer/versions
        plugin("PsiViewer", "252.23892.248")
//        plugin("com.github.voml.neo_theme", "0.4.3")
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
// Set the JVM language level used to build the project.
kotlin {
    jvmToolchain(21)
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    groups.empty()
    repositoryUrl = properties("pluginRepositoryUrl")
}
tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    patchPluginXml {
        sinceBuild = properties("pluginSinceBuild")
        untilBuild = properties("pluginUntilBuild")
    }

    signPlugin {
        certificateChain = environment("CERTIFICATE_CHAIN")
        privateKey = environment("PRIVATE_KEY")
        password = environment("PRIVATE_KEY_PASSWORD")
    }

    publishPlugin {
        token = environment("PUBLISH_TOKEN")
    }


}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    groups.empty()
    repositoryUrl = properties("pluginRepositoryUrl")
}
