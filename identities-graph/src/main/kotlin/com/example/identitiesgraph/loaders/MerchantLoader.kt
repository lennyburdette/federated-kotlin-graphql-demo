package com.example.identitiesgraph.loaders

import com.example.identitiesgraph.types.Merchant
import com.example.identitiesgraph.types.MerchantStatus
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await
import org.dataloader.DataLoader
import java.util.concurrent.CompletableFuture

const val MERCHANT = "Merchant"

fun batchFetchMerchants(ids: List<String>): CompletableFuture<List<Merchant>> = CompletableFuture.supplyAsync {
  ids.map { id ->
    Merchant(
        id = id,
        country = "US",
        currency = "USD",
        status = MerchantStatus.ACTIVE,
        businessName = "Business $id",
        languageCode = "en-US"
    )
  }
}

fun merchantDataLoader() = DataLoader.newMappedDataLoader<String, Merchant> { ids ->
  batchFetchMerchants(ids.toList())
      .thenApply { ms -> ms.map { it.id to it }.toMap() }
}

val merchantResolver = object : FederatedTypeResolver<Merchant> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Merchant?> {
    val ids = representations.map { it["id"]?.toString() }
    val merchants = batchFetchMerchants(ids.filterNotNull()).await().map { it.id to it }.toMap()
    return ids.map { id -> merchants[id] }
  }
}