package com.example.graphqlkotlindemo

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.annotations.GraphQLIgnore
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}

@Component
class SimpleQuery : Query {
  fun hello() = "world"
}

//@Component
//class SimpleMutation : Mutation {
//  fun hello() = "world"
//}
