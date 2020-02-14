package com.example.graphcommon.types

import com.expediagroup.graphql.annotations.GraphQLDescription

data class Address(
  @GraphQLDescription("""The first line of the address.

Fields that start with addressLine provide the address's most specific details, like street number, street name, and building name. They do not provide less specific details like city, state/province, or country (these details are provided in other fields).""")
  val addressLine1: String? = null,

  @GraphQLDescription("The second line of the address, if any.")
  val addressLine2: String? = null,

  @GraphQLDescription("The third line of the address, if any.")
  val addressLine3: String? = null,

  @GraphQLDescription("A civil entity within the address's country. In the US, this is the state.")
  val administrativeDistrictLevel1: String? = null,

  @GraphQLDescription("A civil entity within the address's administrativeDistrictLevel1. In the US, this is the county.")
  val administrativeDistrictLevel2: String? = null,

  @GraphQLDescription("A civil entity within the address's administrativeDistrictLevel2, if any.")
  val administrativeDistrictLevel3: String? = null,

  @GraphQLDescription("The address's country, in ISO 3166-1-alpha-2 format.")
  val country: String? = null,

  @GraphQLDescription("Optional first name when it's representing recipient.")
  val firstName: String? = null,

  @GraphQLDescription("Optional last name when it's representing recipient.")
  val lastName: String? = null,

  @GraphQLDescription("The city or town of the address.")
  val locality: String? = null,

  @GraphQLDescription("Optional organization name when it's representing recipient.")
  val organization: String? = null,

  @GraphQLDescription("The address's postal code.")
  val postalCode: String? = null,

  @GraphQLDescription("A civil region within the address's locality, if any.")
  val sublocality: String? = null,

  @GraphQLDescription("A civil region within the address's sublocality, if any.")
  val sublocality2: String? = null,

  @GraphQLDescription("A civil region within the address's sublocality2, if any.")
  val sublocality3: String? = null
)
