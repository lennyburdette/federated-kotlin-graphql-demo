package com.example.identitiesgraph

import com.example.identitiesgraph.hooks.CustomFederationSchemaGeneratorHooks
import com.example.identitiesgraph.loaders.LOCATION
import com.example.identitiesgraph.loaders.MERCHANT
import com.example.identitiesgraph.loaders.locationResolver
import com.example.identitiesgraph.loaders.merchantResolver
import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {
	@Bean
	fun hooks(federatedTypeRegistry: FederatedTypeRegistry) =
			CustomFederationSchemaGeneratorHooks(federatedTypeRegistry)

	@Bean
	fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf(
			MERCHANT to merchantResolver,
			LOCATION to locationResolver
	))
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
