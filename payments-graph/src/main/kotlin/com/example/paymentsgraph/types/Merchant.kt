package com.example.paymentsgraph.types

import com.example.paymentsgraph.fixtures.getPaymentsForLocation
import com.example.paymentsgraph.fixtures.getPaymentsForMerchant
import com.example.paymentsgraph.loaders.batchFetchPayments
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import kotlinx.coroutines.future.await

@ExtendsDirective
@KeyDirective(FieldSet("id"))
data class Merchant(
  @GraphQLID @ExternalDirective val id: String
) {
  fun payments(first: Int?) = PaymentPaginated(nodes = getPaymentsForMerchant(id))
}

const val MERCHANT = "Merchant"

val merchantResolver = object : FederatedTypeResolver<Merchant> {
  override suspend fun resolve(representations: List<Map<String, Any>>): List<Merchant?> {
    return representations.map { it["id"]?.toString()?.let { id -> Merchant(id) } }
  }
}