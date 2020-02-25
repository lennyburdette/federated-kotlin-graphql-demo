# Using GraphQL

## Writing your first operation

Visit the [Playground](https://young-plains-37812.herokuapp.com/graphql) and click around.

### Start with Autocomplete

In the editor on the left, hit `ctrl-space` to show the autocomplete menu. The choices are:

* `query`: Read operation
* `mutation`: Write/side-effect-ful operation (followed by reads)
* `subscription`: Real-time read operation
* `fragment`: A reusable partial operation
* `{`: Shorthand for "query"

Type the start of a query and hit `ctrl-space` inside the brackets:

```graphql
query {
  # ctrl-space here
}
```

This schema has four "entry point" fields, or four fields in the "root" Query type. (It also has two fields for introspection that start with `__`).

Type `merchant`. You'll get two errors:

> Field `merchant` of type `Merchant` must have a selection of subfields. Did you mean `merchant { ... }`?

> Field `merchant` argument `id` of type `ID!` is required but not provided.

You cannot query for just `merchant`: you must select the specific fields of `Merchant` that you need.

And this field requires an `id` argument to fetch a specific merchant.

Fix these two errors and trigger autocomplete inside the merchant field again:

```graphql
query {
  merchant(id: "m1") {
    # ctrl-space here
  }
}
```

Add any of the fields besides `payment` (we'll save that for later). You now have a valid query. Press the Play button or `ctrl-enter` to execute the query.

**Ta-da, you've written a GraphQL Operation!**

## Make it dynamic

```graphql
query MyUniqueOperationName($id: ID!) {
  merchant(id: $id) {
    id
    businessName
  }
}
```

In the "Query Variables" panel at the bottom of the editor, add a JSON object:

```json
{
  "id": "m1"
}
```

## Try out a Mutation

```graphql
mutation CreateCustomer($input: CreateCustomerInput!) {
  createCustomer(input: $input) {
    customer {
      id
      givenName
      familyName
    }
  }
}
```

```json
{
  "input": {
    "clientMutationId": "123456789",
    "givenName": "Joe",
    "familyName": "Blow"
  }
}
```

## Add some more stuff

```graphql
query MyUniqueOperationName($id: ID!) {
  merchant(id: $id) {
    id
    businessName
    payments {
      nodes {
        id
        amountMoney {
          amount
          currencyCode
        }
        customer {
          id
          givenName
          familyName
        }
      }
    }
  }
}
```

## Using GraphQL in a React App

The `app/` folder contains a stripped-down [create-react-app](https://create-react-app.dev) with the [Apollo Client](https://www.apollographql.com/docs/react/get-started/) integration.

To make this really awesome, you need two things:

* The [VSCode Apollo extension](https://marketplace.visualstudio.com/items?itemName=apollographql.vscode-apollo) ([Configuration docs](https://www.apollographql.com/docs/devtools/apollo-config/)).
* `.env` files with an Apollo Graph Manager API key.

To run the app:

```sh
cd app
yarn install
yarn codegen:watch # in one terminal
yarn start # in another terminal
```

### End-to-end Strong Typing

Edit the operation in src/App.tsx.

```ts
const query = gql`
  query AppTest($id: ID!) {
    merchant(id: $id) {
      id
      businessName
      payments {
        nodes {
          id
          amountMoney {
            amount
            currencyCode
          }
        }
      }
    }
  }
`;
```

Observe how `src/__generated__/appTest.ts` changes.

Import the response and variable types from the generated file.

```ts
import { AppTest, AppTestVariables } from './__generated__/AppTest';
```

Reference them in the `useQuery` hook:

```ts
const { data, loading, error } = useQuery<AppTest, AppTestVariables>(query, {
  variables: { id: "m1" }
});
```

Notice the type error that appears in `{data.merchant.id}`. Because merchant is a nullable field, you need a null check before you can reference its `id` property.
