const { ApolloServer } = require("apollo-server");
const { ApolloGateway } = require("@apollo/gateway");

(async () => {
  // await new Promise(r => setTimeout(r, 10000));

  const server = new ApolloServer({
    gateway: new ApolloGateway({
      debug: true,
      serviceList: [
        { name: "identities-graph", url: "http://identities-graph:8080/graphql" },
        { name: "payments-graph", url: "http://payments-graph:8081/graphql" }
      ]
    }),
    subscriptions: false
  });

  server.listen().then(({ url }) => {
    console.log(`🚀 Server ready at ${url}`);
  });
})();
