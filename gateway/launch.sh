#!/bin/bash

./wait-for-it.sh identities-graph:8080
if [ $? != 0 ]; then
  exit 1
fi

./wait-for-it.sh payments-graph:8081
if [ $? != 0 ]; then
  exit 1
fi

exec node index.js
