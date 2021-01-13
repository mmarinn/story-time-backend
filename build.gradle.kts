import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.jpa") version "1.4.10"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    application
}

group = "com.storytimebackend"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    testImplementation("io.kotest:kotest-runner-junit5:4.3.0")
    testImplementation("io.kotest:kotest-extensions-spring:4.3.0")

    testImplementation("io.mockk:mockk:1.10.0")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.4.0")

    runtimeOnly("org.postgresql:postgresql")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "com.storytimebackend.ApplicationMainKt"
}