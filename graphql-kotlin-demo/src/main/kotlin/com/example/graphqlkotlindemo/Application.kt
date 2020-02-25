package com.example.graphqlkotlindemo

import com.expediagroup.graphql.annotations.*
import com.expediagroup.graphql.spring.execution.*
import com.expediagroup.graphql.spring.operations.*
import graphql.schema.DataFetchingEnvironment
import kotlinx.coroutines.*
import kotlinx.coroutines.future.*
import org.dataloader.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.concurrent.CompletableFuture

@SpringBootApplication
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}

@Component
class MyQuery : Query {
  fun hello() = "world"
}