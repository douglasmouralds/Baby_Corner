// build.gradle.kts (Top-Level)
plugins {
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    kotlin("jvm") version "1.9.24" apply false
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.1") // Atualize para a versão mais recente se necessário
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
