package com.example.customersgraph.types

import com.example.graphcommon.types.Address
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import java.time.OffsetDateTime

@KeyDirective(FieldSet("id"))
data class Customer(
  @GraphQLID val id: String,
    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime = OffsetDateTime.now(),
    val givenName: String? = null,
    val familyName: String? = null,
    val nickname: String? = null,
    val companyName: String? = null,
    val emailAddress: String? = null,
    val address: Address? = null,
    val phoneNumber: String? = null,
    val birthday: String? = null,
    val referenceId: String? = null,
    val note: String? = null,
    val creationSource: CustomerCreationSource = CustomerCreationSource.OTHER
) {
  fun cards() = listOf<Card>()
  fun preferences() = CustomerPreferences(false)
  fun groups() = listOf<CustomerGroupInfo>()
}