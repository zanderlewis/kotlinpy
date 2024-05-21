import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

plugins {
    kotlin("jvm") version "1.9.23"
    id("maven-publish")
    id("io.franzbecker.gradle-lombok") version "5.0.0"
}

group = "io.github.zanderlewis.kotlinpy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

// Load .env file
val env = Properties().apply {
    Files.newInputStream(Paths.get(".env")).use { load(it) }
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["kotlin"])
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/WolfTheDeveloper/kotlinpy")
            credentials {
                username = env.getProperty("GITHUB_USERNAME")
                password = env.getProperty("GITHUB_TOKEN")
            }
        }
    }
}
