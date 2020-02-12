import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

allprojects {
	buildscript {
		repositories {
			mavenLocal()
			jcenter()
			mavenCentral()
		}
	}

	repositories {
		mavenLocal()
		jcenter()
		mavenCentral()
	}
}

subprojects {
    val properties = Properties()
    properties.load(File("gradle.properties").inputStream())
    for ((key, value) in properties) {
        this.ext[key.toString()] = value
    }

    val kotlinVersion: String by project

    apply(plugin = "kotlin")
    apply(plugin = "org.springframework.boot")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVersion")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    tasks {
        jar {
            enabled = false
        }
        test {
            useJUnitPlatform()
        }
    }
}

tasks {
    jar {
        enabled = false
    }
}
