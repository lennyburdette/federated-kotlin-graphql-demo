import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.jetbrains.kotlin.plugin.spring")
	id("org.springframework.boot")
}

dependencies {
	implementation("com.expediagroup:graphql-kotlin-spring-server:1.4.2")
	implementation("org.springframework.boot:spring-boot-starter:2.2.4.RELEASE")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.graphql-java:graphql-java-extended-scalars:1.0")
}
