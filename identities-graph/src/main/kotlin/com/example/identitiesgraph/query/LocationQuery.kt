package com.example.identitiesgraph.query

import com.example.identitiesgraph.loaders.LOCATION
import com.example.identitiesgraph.types.Location
import com.example.identitiesgraph.types.Merchant
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class LocationQuery : Query {
    fun location(@GraphQLID id: String, env: DataFetchingEnvironment) =
        env.getDataLoader<String, Location>(LOCATION).load(id)
}
