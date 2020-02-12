package com.example.identitiesgraph.query

import com.example.identitiesgraph.types.Merchant
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class SimpleQuery : Query {
    fun merchant(@GraphQLID id: String) = Merchant(id)
}
