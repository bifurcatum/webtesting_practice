plugins {
    kotlin("jvm") version "1.9.21"
    id("io.qameta.allure") version "2.9.6"
    }

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    implementation("com.codeborne:selenide:7.0.4")
    implementation("io.qameta.allure:allure-junit5:2.25.0")
    implementation("io.qameta.allure:allure-selenide:2.25.0")
    implementation("com.codeborne:selenide:7.0.4")
    implementation("com.codeborne:xls-test:1.7.0")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("org.apache.commons:commons-csv:1.10.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}