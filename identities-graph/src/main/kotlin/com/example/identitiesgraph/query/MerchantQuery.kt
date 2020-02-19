package com.example.identitiesgraph.query

import com.example.identitiesgraph.loaders.MERCHANT
import com.example.identitiesgraph.types.Merchant
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class MerchantQuery : Query {
    fun merchant(@GraphQLID id: String, env: DataFetchingEnvironment) =
        env.getDataLoader<String, Merchant?>(MERCHANT).load(id)
}
