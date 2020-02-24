import React from 'react';
import ApolloClient, { gql } from 'apollo-boost';
import { ApolloProvider, useQuery } from '@apollo/react-hooks';

const client = new ApolloClient({
  uri: 'https://young-plains-37812.herokuapp.com/graphql',
});

const query = gql`
  query AppTest($id: ID!) {
    merchant(id: $id) {
      id
    }
  }
`;

function App() {
  return <ApolloProvider client={client}>
    <Merchant />
  </ApolloProvider>
}

function Merchant() {
  const { data, loading, error } = useQuery(query, {
    variables: { id: "m1" }
  });

  if (error) return <>Error</>;
  if (loading || !data) return <>Loading...</>;

  return <>
    Merchant ID: {data.merchant.id}<br />
  </>;
}

export default App;
