plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.nikita"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}