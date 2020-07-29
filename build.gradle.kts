plugins {
    kotlin("jvm") version "1.3.72"
    id("org.openjfx.javafxplugin") version "0.0.9"
}

group = "me.duncte123"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:1.7.20")
    implementation("org.jmdns:jmdns:3.5.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("com.squareup.okhttp3:okhttp:4.8.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")


}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}