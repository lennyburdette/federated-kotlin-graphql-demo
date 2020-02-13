package com.example.identitiesgraph.loaders

import com.example.identitiesgraph.types.Location
import com.example.identitiesgraph.types.LocationStatus
import com.example.identitiesgraph.types.LocationType
import com.example.identitiesgraph.types.Merchant
import com.example.identitiesgraph.types.MerchantStatus
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await
import org.dataloader.DataLoader
import java.time.OffsetDateTime
import java.util.concurrent.CompletableFuture

const val LOCATION = "Location"

fun batchFetchLocations(ids: List<String>): CompletableFuture<List<Location>> = CompletableFuture.supplyAsync {
  ids.map { id ->
    Location(
        id = id,
        country = "US",
        currency = "USD",
        status = LocationStatus.ACTIVE,
        type = LocationType.PHYSICAL,
        name = "Location $id",
        businessName = "Location $id",
        languageCode = "en-US",
        createdAt = OffsetDateTime.now(),
        merchantId = "merchant-id"
    )
  }
}

fun locationDataLoader() = DataLoader.newMappedDataLoader<String, Location> { ids ->
  batchFetchLocations(ids.toList())
      .thenApply { ms -> ms.map { it.id to it }.toMap() }
}

val locationResolver = object : FederatedTypeResolver<Location> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Location?> {
    val ids = representations.map { it["id"]?.toString() }
    val locations = batchFetchLocations(ids.filterNotNull()).await().map { it.id to it }.toMap()
    return ids.map { id -> locations[id] }
  }
}