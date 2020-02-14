package com.example.paymentsgraph.types

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@ExtendsDirective
@KeyDirective(FieldSet("id"))
data class Customer(
  @GraphQLID @ExternalDirective val id: String
)
