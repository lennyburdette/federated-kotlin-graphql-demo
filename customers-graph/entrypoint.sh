#!/bin/bash

exec java -XX:+UseContainerSupport -Xmx256m -jar customers-graph.jar --server.port=$PORT
