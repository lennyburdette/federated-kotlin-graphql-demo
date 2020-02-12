package com.example.identitiesgraph.types

import com.expediagroup.graphql.annotations.GraphQLID

data class Merchant(
  @GraphQLID val id: String
)
