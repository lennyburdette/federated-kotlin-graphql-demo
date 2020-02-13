package com.example.paymentsgraph.loaders

import com.example.graphcommon.types.Money
import com.example.paymentsgraph.types.CardPaymentDetails
import com.example.paymentsgraph.types.Payment
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await
import org.dataloader.DataLoader
import java.time.OffsetDateTime
import java.util.concurrent.CompletableFuture

const val PAYMENT = "Payment"

fun batchFetchPayments(ids: List<String>) = CompletableFuture.supplyAsync {
  ids.map { id ->
    Payment(
        id = id,
        createdAt = OffsetDateTime.now(),
        updatedAt = OffsetDateTime.now(),
        amountMoney = Money(0, "USD"),
        tipMoney = Money(0, "USD"),
        appFeeMoney = Money(0, "USD"),
        cardDetails = CardPaymentDetails("AUTHORIZED"),
        processingFee = listOf(),
        sourceType = "CARD",
        status = "APPROVED",
        totalMoney = Money(0, "USD"),
        customerId = "customer-id",
        employeeId = "employee-id",
        locationId = "location-id"
    )
  }
}

fun paymentDataLoader() = DataLoader.newMappedDataLoader<String, Payment> { ids ->
  batchFetchPayments(ids.toList())
      .thenApply { payments -> payments.map { it.id to it }.toMap() }
}

val paymentResolver = object : FederatedTypeResolver<Payment> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Payment?> {
    val ids = representations.map { it["id"]?.toString() }
    val payments = batchFetchPayments(ids.filterNotNull()).await().map { it.id to it }.toMap()
    return ids.map { id -> payments[id] }
  }
}