#!/bin/bash

exec java -XX:+UseContainerSupport -Xmx256m -jar payments-graph.jar --server.port=$PORT
