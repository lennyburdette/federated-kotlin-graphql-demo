# GraphQL/Kotlin/Federation/React demo

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

* [Read the official docs](https://expediagroup.github.io/graphql-kotlin/docs/getting-started.html)
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
