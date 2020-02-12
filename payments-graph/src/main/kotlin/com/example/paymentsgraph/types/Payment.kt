package com.example.paymentsgraph.types

import com.expediagroup.graphql.annotations.GraphQLID

data class Payment(
  @GraphQLID val id: String
)
