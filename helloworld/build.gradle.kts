import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlin
    id("org.jetbrains.compose") version Versions.compose
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
}

dependencies {
    implementation(Versions.library)
    implementation(compose.desktop.currentOs)
    implementation(project(":caffe"))
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(Versions.jvmLevel)
}

application {
    mainClass.set("MainKt")
}