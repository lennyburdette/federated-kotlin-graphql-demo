const { ApolloServer } = require("apollo-server");
const { ApolloGateway } = require("@apollo/gateway");

const gatewayConfig = {
  debug: true
};

if (process.env.SERVICE_LIST && process.env.SERVICE_LIST.startsWith('[')) {
  gatewayConfig.serviceList = JSON.parse(process.env.SERVICE_LIST)
}

const server = new ApolloServer({
  gateway: new ApolloGateway(gatewayConfig),
  subscriptions: false
});

server.listen({ port: process.env.PORT }).then(({ url }) => {
  console.log(`🚀 Server ready at ${url}`);
});
