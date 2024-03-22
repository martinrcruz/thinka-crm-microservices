#!/bin/bash

for microservice in client-microservice sale-microservice project-microservice; do
  docker login -u martinignacioriosc -p Martin212.365
  echo "Building $microservice..."
  docker build -t martinignacioriosc/thinka-crm:$microservice ./$microservice

  echo "Pushing $microservice to Docker Hub..."
  docker push martinignacioriosc/thinka-crm:$microservice
done
