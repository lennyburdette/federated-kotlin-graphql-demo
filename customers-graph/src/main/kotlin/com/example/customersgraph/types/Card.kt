package com.example.customersgraph.types

import com.example.graphcommon.types.Address
import com.expediagroup.graphql.annotations.GraphQLID

data class Card(
  @GraphQLID val id: String,
  val billingAddress: Address? = null,
  val bin: String? = null,
  val cardBrand: CardBrand? = null,
  val cardholderName: String? = null,
  val expMonth: Int? = null,
  val expYear: Int? = null,
  val fingerprint: String? = null,
  val last4: String? = null
)
