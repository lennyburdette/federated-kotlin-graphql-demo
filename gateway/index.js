const express = require('express');
const { ApolloServer } = require("apollo-server-express");
const { ApolloGateway } = require("@apollo/gateway");
const { express: voyager } = require('graphql-voyager/middleware')

const gatewayConfig = {
  debug: true
};

if (process.env.SERVICE_LIST && process.env.SERVICE_LIST.startsWith('[')) {
  gatewayConfig.serviceList = JSON.parse(process.env.SERVICE_LIST)
}

const app = express();

const apolloServer = new ApolloServer({
  gateway: new ApolloGateway(gatewayConfig),
  subscriptions: false
});
apolloServer.applyMiddleware({ app });

app.use('/voyager', voyager({ endpointUrl: '/graphql' }));

app.listen(process.env.PORT, () => {
  console.log(`🚀 Server ready at localhost:${process.env.PORT}`);
});
