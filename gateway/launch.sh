#!/bin/bash

if [[ "$SLEEP" ]]; then
  sleep $SLEEP
fi

exec node index.js
