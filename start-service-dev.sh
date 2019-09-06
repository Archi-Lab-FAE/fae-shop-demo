#!/usr/bin/env bash
CURRENT=$(pwd)

# pull service
docker-compose \
  -f "$CURRENT/src/main/docker/docker-compose.yml" \
  -f "$CURRENT/src/main/docker/docker-compose-dev.yml" \
  pull
  
# start service
docker-compose -p gateway \
  -f "$CURRENT/src/main/docker/docker-compose.yml" \
  -f "$CURRENT/src/main/docker/docker-compose-dev.yml" \
  up -d