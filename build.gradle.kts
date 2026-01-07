import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)


group = properties("pluginGroup").get()
version = properties("pluginVersion").get()

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.2.21"
    alias(libs.plugins.changelog)
    id("org.jetbrains.qodana") version "2025.2.2"
    alias(libs.plugins.kover)
    id("org.jetbrains.intellij.platform")
}
repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
        jetbrainsRuntime()
    }
}

dependencies {
    intellijPlatform {
        // 使用2025.2版本，使用installer
        create(IntelliJPlatformType.IntellijIdeaUltimate, "2025.2") {
            useInstaller = true
        }
//        create(IntelliJPlatformType.IntellijIdea, "2025.3") {
//            useInstaller = true
//        }

        bundledPlugin("com.intellij.java")
        bundledPlugin("com.intellij.modules.ultimate")
        bundledPlugin("com.intellij.modules.json")
        bundledPlugin("org.toml.lang")
        bundledPlugin("org.intellij.plugins.markdown")
//        // https://plugins.jetbrains.com/plugin/227-psiviewer/versions
        plugin("PsiViewer", "252.23892.248")
//        plugin("com.github.voml.neo_theme", "0.4.3")

        testFramework(TestFrameworkType.Platform)
    }

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.opentest4j:opentest4j:1.3.0")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
// Set the JVM language level used to build the project.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    jvmToolchain(21)
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
    
    test {
        maxHeapSize = "4g"
        jvmArgs("-XX:+UseG1GC", "-XX:MaxGCPauseMillis=200")
        testLogging {
            events("passed", "skipped", "failed")
        }
        // 启用测试结果缓存
        outputs.upToDateWhen { false }
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
