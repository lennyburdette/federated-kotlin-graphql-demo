package com.example.identitiesgraph.types

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

enum class MerchantStatus {
  ACTIVE,
  INACTIVE
}

@KeyDirective(fields = FieldSet("id"))
data class Merchant(
  @GraphQLID val id: String,
  val businessName: String?,
  val country: String,
  val languageCode: String?,
  val currency: String?,
  val status: MerchantStatus
)
