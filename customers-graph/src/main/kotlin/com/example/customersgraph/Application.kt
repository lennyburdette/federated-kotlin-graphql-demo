package com.example.customersgraph

import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation
import com.example.customersgraph.loaders.CUSTOMER
import com.example.customersgraph.loaders.customerResolver
import com.example.graphcommon.hooks.CustomFederationSchemaGeneratorHooks
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
	fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf(CUSTOMER to customerResolver))

	@Bean
	fun addFederatedTracing() = FederatedTracingInstrumentation()
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
