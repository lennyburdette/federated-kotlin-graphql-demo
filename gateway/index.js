const { ApolloServer } = require("apollo-server");
const { ApolloGateway } = require("@apollo/gateway");

const server = new ApolloServer({
  gateway: new ApolloGateway({
    debug: true,
    serviceList: JSON.parse(process.env.SERVICE_LIST)
  }),
  subscriptions: false
});

server.listen({ port: process.env.PORT }).then(({ url }) => {
  console.log(`🚀 Server ready at ${url}`);
});
