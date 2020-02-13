package com.example.paymentsgraph.types

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(FieldSet("id"))
data class Customer(
  @GraphQLID val id: String
)
