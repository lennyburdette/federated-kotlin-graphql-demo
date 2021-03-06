package com.example.paymentsgraph

import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation
import com.example.graphcommon.hooks.CustomFederationSchemaGeneratorHooks
import com.example.paymentsgraph.loaders.PAYMENT
import com.example.paymentsgraph.loaders.paymentResolver
import com.example.paymentsgraph.types.LOCATION
import com.example.paymentsgraph.types.MERCHANT
import com.example.paymentsgraph.types.locationResolver
import com.example.paymentsgraph.types.merchantResolver
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
			PAYMENT to paymentResolver,
			LOCATION to locationResolver,
			MERCHANT to merchantResolver
	))

	@Bean
	fun addFederatedTracing() = FederatedTracingInstrumentation()
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
