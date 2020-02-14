package com.example.customersgraph.loaders

import com.expediagroup.graphql.spring.execution.DataLoaderRegistryFactory
import org.dataloader.DataLoaderRegistry
import org.springframework.stereotype.Component

@Component
class Registry : DataLoaderRegistryFactory {
  override fun generate(): DataLoaderRegistry {
    return DataLoaderRegistry()
        .register(CUSTOMER, customerDataLoader())
  }
}