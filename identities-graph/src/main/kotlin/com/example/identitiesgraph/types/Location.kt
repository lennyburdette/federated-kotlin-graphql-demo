package com.example.identitiesgraph.types

import com.example.identitiesgraph.loaders.MERCHANT
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import graphql.schema.DataFetchingEnvironment
import java.time.OffsetDateTime

@KeyDirective(FieldSet("id"))
data class Location(
  @GraphQLID val id: String,
    val name: String,
    val address: Address? = null,
    val timezone: String? = null,
    val capabilities: List<String> = listOf(),
    val status: LocationStatus,
    val createdAt: OffsetDateTime,
    val country: String,
    val languageCode: String,
    val currency: String,
    val phoneNumber: String? = null,
    val businessName: String,
    val type: LocationType,
    val websiteUrl: String? = null,
    val businessHours: BusinessHours? = null,
    val businessEmail: String? = null,
    val description: String? = null,
    val twitterUsername: String? = null,
    val instagramUsername: String? = null,
    val facebookUrl: String? = null,
    val coordinates: Coordinates? = null,
    val logoUrl: String? = null,
    val posBackgroundUrl: String? = null,
    val mcc: String? = null,

    private val merchantId: String
) {
  fun merchant(env: DataFetchingEnvironment) = env.getDataLoader<String, Merchant>(MERCHANT).load(merchantId)
}