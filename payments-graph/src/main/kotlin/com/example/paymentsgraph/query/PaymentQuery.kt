package com.example.paymentsgraph.query

import com.example.paymentsgraph.loaders.PAYMENT
import com.example.paymentsgraph.loaders.batchFetchPayments
import com.example.paymentsgraph.types.Payment
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class PaymentQuery : Query {
    fun payment(@GraphQLID id: String, env: DataFetchingEnvironment) =
        env.getDataLoader<String, Payment?>(PAYMENT).load(id)
}
