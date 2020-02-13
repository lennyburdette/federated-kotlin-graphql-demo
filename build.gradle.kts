import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

plugins {
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
    id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
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

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.graphql-java:graphql-java-extended-scalars:1.0")
        implementation("com.apollographql.federation:federation-graphql-java-support:0.3.2")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

configure(subprojects.filter { it.name != "graphcommon" }) {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        implementation(project(":graphcommon"))
        implementation("com.expediagroup:graphql-kotlin-spring-server:1.4.2")
        implementation("org.springframework.boot:spring-boot-starter:2.2.4.RELEASE")
    }
}
