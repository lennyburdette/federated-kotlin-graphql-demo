package com.example.customersgraph.query

import com.example.customersgraph.loaders.CUSTOMER
import com.example.customersgraph.types.Customer
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class CustomerQuery : Query {
  fun customer(@GraphQLID id: String, env: DataFetchingEnvironment) = env.getDataLoader<String, Customer>(CUSTOMER).load(id)
}