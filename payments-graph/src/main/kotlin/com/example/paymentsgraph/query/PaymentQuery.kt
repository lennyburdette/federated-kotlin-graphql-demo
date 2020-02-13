package com.example.paymentsgraph.query

import com.example.paymentsgraph.loaders.batchFetchPayments
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class PaymentQuery : Query {
    fun payment(@GraphQLID id: String) = batchFetchPayments(listOf(id)).thenApply { it[0] }
}
