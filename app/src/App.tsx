import React from 'react';
import ApolloClient, { gql } from 'apollo-boost';
import { ApolloProvider, useQuery } from '@apollo/react-hooks';
import { AppTest } from './__generated__/AppTest';

const client = new ApolloClient({
  uri: 'https://young-plains-37812.herokuapp.com/graphql',
});

const query = gql`
  query AppTest {
    merchant(id: "m1") {
      id
      businessName
    }
  }
`;

function App() {
  return <ApolloProvider client={client}>
    <Merchant />
  </ApolloProvider>
}

function Merchant() {
  const { data, loading, error } = useQuery<AppTest>(query);

  if (error) return <>Error</>;
  if (loading || !data) return <>Loading...</>;

  return <>
    Merchant ID: {data.merchant.id}<br />
    Merchant Name: {data.merchant.businessName}
  </>;
}

export default App;
