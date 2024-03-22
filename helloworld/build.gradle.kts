plugins {
    kotlin("jvm") version Versions.kotlin
    id("org.jetbrains.compose") version Versions.compose
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(Versions.library)
    implementation(compose.desktop.currentOs)

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(Versions.jvmLevel)
}