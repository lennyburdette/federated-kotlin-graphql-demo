package com.example.customersgraph.types

import com.expediagroup.graphql.annotations.GraphQLID

data class CustomerGroupInfo(
  @GraphQLID val id: String,
  val name: String
)
