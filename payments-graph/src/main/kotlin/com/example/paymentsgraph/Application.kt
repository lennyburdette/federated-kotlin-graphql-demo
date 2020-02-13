package com.example.paymentsgraph

import com.example.paymentsgraph.hooks.CustomFederationSchemaGeneratorHooks
import com.example.paymentsgraph.loaders.PAYMENT
import com.example.paymentsgraph.loaders.paymentResolver
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
	fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf(PAYMENT to paymentResolver))
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
