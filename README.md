# GraphQL/Kotlin/Federation/React demo

* This repo: [**go/graphql-lnl-2020-code**](https://go/graphql-lnl-2020-code)
* Live API: [**go/graphql-lnl-2020**](https://go/graphql-lnl-2020)

This repository contains:

* A federated GraphQL API, made up of:
    * A [Node.js Apollo Server](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/gateway) as the Gateway.
    * Three graphql-kotlin services ([1](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/customers-graph), [2](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/identities-graph), [3](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/payments-graph)).
    * A [docker-compose config](https://github.com/lennyburdette/federated-kotlin-graphql-demo/blob/master/docker-compose.yml) for running all four services together.
* A nearly-empty [graphql-kotlin demo app](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/graphql-kotlin-demo).
* A [React app](https://github.com/lennyburdette/federated-kotlin-graphql-demo/tree/master/app) for demonstrating code generation and querying.

### Tutorials

* [Using GraphQL](https://github.com/lennyburdette/federated-kotlin-graphql-demo/blob/master/app/README.md)
* [Writing a GraphQL Service](https://github.com/lennyburdette/federated-kotlin-graphql-demo/blob/master/graphql-kotlin-demo/README.md)

***

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
* [Follow the tutorial](https://github.com/lennyburdette/federated-kotlin-graphql-demo/blob/master/graphql-kotlin-demo/README.md)
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
