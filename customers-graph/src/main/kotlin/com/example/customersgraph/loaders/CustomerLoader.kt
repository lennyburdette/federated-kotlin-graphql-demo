package com.example.customersgraph.loaders

import com.example.customersgraph.types.Customer
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await
import org.dataloader.DataLoader
import java.util.concurrent.CompletableFuture

const val CUSTOMER = "Customer"

fun batchFetchCustomers(ids: List<String>) = CompletableFuture.supplyAsync {
  ids.map { id ->
    Customer(
        id = id,
        givenName = "Customer $id"
    )
  }
}

fun customerDataLoader() = DataLoader.newMappedDataLoader<String, Customer> { ids ->
  batchFetchCustomers(ids.toList())
      .thenApply { cs -> cs.map { it.id to it }.toMap() }
}

val customerResolver = object : FederatedTypeResolver<Customer> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Customer?> {
    val ids = representations.map { it["id"]?.toString() }
    val customers = batchFetchCustomers(
        ids.filterNotNull()).await().map { it.id to it }.toMap()
    return ids.map { id -> customers[id] }
  }
}