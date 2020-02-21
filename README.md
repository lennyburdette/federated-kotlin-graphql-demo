# GraphQL/Kotlin/Federation/React demo

This repository contains:

* A federated GraphQL API, made up of:
    * A Node.js Apollo Server as the Gateway.
    * Three graphql-kotlin services.
    * A docker-compose config for running all four services together.
* A nearly-empty graphql-kotlin demo app.
* A React app for demonstrating code generation and querying.

<details>
  <summary>Requirements</summary>

* Docker
* Java
* Node
* Yarn

</details>

<details>
  <summary>Running services</summary>

```sh
./bin/run-all
```

Visit [localhost:4000/graphql](http://localhost:4000/graphql) to explore the entire federated graph.

Open [localhost:8081/playground](http://localhost:8081/playground), [localhost:8082/playground](http://localhost:8082/playground), or [localhost:8083/playground](http://localhost:8083/playground) to explore each service directly.
</details>

<details>
  <summary>Exploring graphql-kotlin</summary>

* [Read the official docs](gk)
* Edit `graphql-kotlin-demo/src/main/kotlin/com/example/Application.kt`.
* Run the app:
    ```sh
    ./gradlew :graphql-kotlin-demo:bootRun
    ```
    (Or import the entire project in Intellij and use the "Run" button.)
</details>

<details>
  <summary>Running the React app</summary>

```sh
cd app
yarn install
yarn codegen:watch # in one terminal
yarn start # in another terminal
```

Visit [http://localhost:3000](http://localhost:3000)
</details>

<details>
  <summary>Deploying</summary>

Deploying the services requires my heroku login, so that's not available.

Explore the graph on the Internet [here](https://young-plains-37812.herokuapp.com/graphql). (It might be slow if the dynos went to sleep).
</details>

<details>
  <summary>Using Apollo Graph Manager</summary>

Pushing new service definitions to AGM requires an API key for the `square-lunchnlearn-mar2020` graph.

Visit [go/graphql-login](https://go/graphql-login) to view service definitions, graph usage, error rates, and latency metrics.
</details>

<details>
  <summary>Resources</summary>

### Services
* [graphql-kotlin][gk]
* [graphql-java][gj]
* [graphql-java-extended-scalars][gjes]
* [federation-jvm][fj]
* [howtographql.com][htg]
* [Apollo Graph Manager][agm]

### Client
* [create-react-app][cra]
* [apollo-boost][ab]
* [@apollo/react-hooks][arh]
* [apollo codegen][ac]
</details>

[gk]:https://expediagroup.github.io/graphql-kotlin/docs/getting-started.html
[gj]:https://www.graphql-java.com
[gjes]:https://github.com/graphql-java/graphql-java-extended-scalars
[fj]:https://github.com/apollographql/federation-jvm
[htg]:https://www.howtographql.com
[agm]:https://www.apollographql.com/docs/graph-manager/
[cra]:https://create-react-app.dev
[ab]:https://www.apollographql.com/docs/react/
[arh]:https://www.apollographql.com/docs/react/api/react-hooks/
[ac]:https://github.com/apollographql/apollo-tooling#code-generation
