package com.example.graphqlkotlindemo

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
  fun number() = (0..10).shuffled().first()
}

@Component
class SimpleMutation : Mutation {
  fun hello() = "world"
}
