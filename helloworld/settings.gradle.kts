plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
}
rootProject.name = "helloworld"

