package com.example.paymentsgraph.query

import com.example.paymentsgraph.types.Payment
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class SimpleQuery : Query {
    fun payment(@GraphQLID id: String) = Payment(id)
}
