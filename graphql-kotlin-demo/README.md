# GraphQL Kotlin Tutorial

## How to Go Through This Tutorial

If you have Intellij, import the whole repo (not just the graphql-kotlin-demo folder) as a Gradle project. You can use click "Run" next to `fun main` to run the app.

If you just want to hack with VSCode or another text editor, you can install a Kotlin syntax highlighter, but you're not going to have autocomplete or automatic imports. I've added all the imports necessary for this tutorial already.

To run the app from the command line:
```sh
./gradlew :graphql-kotlin-demo:bootRun
```

Then navigate to http://localhost:8080/playground.

## Why Kotlin?

* Its type system works well with GraphQL, especially null and non-null types!
* Excellent concurrency support, both with Java futures and Kotlin coroutines.
* The [graphql-kotlin](https://expediagroup.github.io/graphql-kotlin/docs/getting-started.html) and [graphql-java](https://www.graphql-java.com/) are excellent.
* It's more expressive than Java, so hopefully all the Rubyists at Square will like it better.
* Allows us to take advantage of Service Container.

## The Tiniest GraphQL Service

(Using a bit of Spring Boot "magic")

```kotlin
package com.example.graphqlkotlindemo

import com.expediagroup.graphql.spring.operations.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}

@Component
class MyQuery : Query {
  fun hello() = "world"
}
```

## Scalar Fields

https://graphql.org/learn/schema/#scalar-types

```kotlin
@Component
class MyQuery : Query {
  fun string() = "a string"
  fun int() = 1
  fun float() = 0.5
  fun bool() = true
}
```

## Field Arguments

```kotlin
// Inside `class MyQuery`
fun greet(name: String?) = "hello $name"
```

graphql-kotlin does not support default values [yet](https://github.com/ExpediaGroup/graphql-kotlin/issues/53).

## Descriptions

```kotlin
// Inside `class MyQuery`
@GraphQLDescription("it says hello")
fun greet(name: String?) = "hello $name"
```

## Nullability

```kotlin
// Inside `class MyQuery`
fun maybeInt() = listOf(1, 2, 3, null).shuffled().first()
```

## Lists

```kotlin
// Inside `class MyQuery`
fun ints() = (0..10).toList()
fun strings() = listOf("hello", "world")
```

## Composite Types

```kotlin
data class Human(
  @GraphQLID val id: String,
  val name: String
)

// Inside `class MyQuery`
fun human() = Human(UUID.randomUUID().toString(), "Alice")
```

## Concurrency

```kotlin
val HUMAN_DB = mapOf(
    "1" to Human("1", "Alice"),
    "2" to Human("2", "Bob"),
    "3" to Human("3", "Carol"),
    "4" to Human("4", "David")
)

suspend fun getHuman(id: String): Human? {
  delay(100)
  return HUMAN_DB[id]
}

// Inside `class MyQuery`, replace existing `fun human`
suspend fun human(@GraphQLID id: String) = getHuman(id)
```

## Recursion

```kotlin
data class Human(
  @GraphQLID val id: String,
  val name: String,
  @GraphQLIgnore val bestFriendId: String? = null // New
)
```

```kotlin
val HUMAN_DB = mapOf(
    "1" to Human("1", "Alice", "2"),
    "2" to Human("2", "Bob", "3"),
    "3" to Human("3", "Carol"),
    "4" to Human("4", "David", "1")
)
```

```kotlin
data class Human(
  @GraphQLID val id: String,
  val name: String,
  @GraphQLIgnore val bestFriendId: String? = null
) {
  suspend fun bestFriend() = bestFriendId?.let { getHuman(it) }
}
```

## N+1 Queries

```kotlin
val FRIENDS = mapOf(
    "1" to listOf("2", "3"),
    "2" to listOf("1", "3"),
    "3" to listOf("2", "4"),
    "4" to listOf("1", "2")
)

// Inside `data class Human`
suspend fun friends() = FRIENDS[id]?.map { getHuman(it) }

suspend fun getHuman(id: String): Human? {
  println("FETCH $id") // New
  delay(100)
  return HUMAN_DB[id]
}
```

```kotlin
suspend fun batchGetHuman(ids: List<String>): List<Human> {
  println("BATCH FETCH $ids")
  delay(100)
  return ids.mapNotNull { HUMAN_DB[it] }
}

// Inside `data class Human`, replace existing `fun friends`
suspend fun friends() = FRIENDS[id]?.let { batchGetHuman(it) }
```

## Dataloaders

https://www.youtube.com/watch?v=OQTnXNCDywA

```kotlin
@Component
class DataLoaders : DataLoaderRegistryFactory {
  override fun generate(): DataLoaderRegistry {
    return DataLoaderRegistry()
        .register("HUMAN", DataLoader.newDataLoader<String, Human?> { ids ->
          GlobalScope.async { batchGetHuman(ids) }.asCompletableFuture()
        })
  }
}

// Inside `data class Human`, replace existing `fun bestFriend`
suspend fun bestFriend(env: DataFetchingEnvironment): Human? {
  if (bestFriendId == null) return null
  return env.getDataLoader<String, Human?>("HUMAN").load(bestFriendId).await()
}
```

## Partial Data

```kotlin
// Inside `class MyQuery`
fun greet(name: String?, env: DataFetchingEnvironment): DataFetchingResult<String> {
  return DataFetcherResult.newResult<String>()
    .data("hello $name")
    .error(GraphqlErrorBuilder.newError(env).message("Whoops").build())
    .build()
}
```

## Next Steps

Explore the other apps in this repo to see:

* Mutations
* Input objects
* Enums
* Custom scalars
* Federation
