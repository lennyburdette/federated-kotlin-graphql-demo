package com.example.paymentsgraph.loaders

import com.example.graphcommon.types.Money
import com.example.paymentsgraph.fixtures.getPayment
import com.example.paymentsgraph.types.CardPaymentDetails
import com.example.paymentsgraph.types.Payment
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await
import org.dataloader.DataLoader
import java.time.OffsetDateTime
import java.util.concurrent.CompletableFuture

const val PAYMENT = "Payment"

fun batchFetchPayments(ids: List<String>): CompletableFuture<List<Payment?>> = CompletableFuture.supplyAsync {
  ids.map { getPayment(it) }
}

fun paymentDataLoader(): DataLoader<String, Payment?> = DataLoader.newMappedDataLoader<String, Payment?> { ids ->
  batchFetchPayments(ids.toList())
      .thenApply { payments -> payments.filterNotNull().map { it.id to it }.toMap() }
}

val paymentResolver = object : FederatedTypeResolver<Payment> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Payment?> {
    val ids = representations.map { it["id"]?.toString() }
    val payments = batchFetchPayments(ids.filterNotNull()).await().filterNotNull().map { it.id to it }.toMap()
    return ids.map { payments[it] }
  }
}