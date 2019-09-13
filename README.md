# Fae Shop Demo
## Run in Docker-Environment
The following commands should be executed in the root directory of the application:

**Build runnable .jar**

mvn clean package

**Build Docker Image**

docker build -f "./Dockerfile" -t docker.nexus.archi-lab.io/archilab/shop-demo .

**Create docker network**

docker network create fae_backend

**Start application with database**

./start-service-dev.sh

**Stop application with database**

./stop-service-dev.sh
