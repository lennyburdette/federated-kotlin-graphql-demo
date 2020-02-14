package com.example.graphcommon.hooks

import com.expediagroup.graphql.federation.FederatedSchemaGeneratorHooks
import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import graphql.scalars.datetime.DateTimeScalar
import graphql.schema.GraphQLType
import java.time.OffsetDateTime
import kotlin.reflect.KType

class CustomFederationSchemaGeneratorHooks(federatedTypeRegistry: FederatedTypeRegistry) : FederatedSchemaGeneratorHooks(federatedTypeRegistry) {
  override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier) {
    OffsetDateTime::class -> dateTimeScalar
    else -> super.willGenerateGraphQLType(type)
  }
}

internal val dateTimeScalar = DateTimeScalar()
