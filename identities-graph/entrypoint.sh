#!/bin/bash

exec java -XX:+UseContainerSupport -Xmx256m -jar identities-graph.jar --server.port=$PORT
