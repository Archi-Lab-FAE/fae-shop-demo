# Fae Shop Demo
## In Docker-Umgebung ausführen
Folgende Kommandos sollten im Root-Verzeichnis der Applikation ausgeführt werden:

**Ausführbare .jar Datei bauen**

mvn clean package

**Docker Image bauen**

docker build -f "./src/main/docker/Dockerfile-dev" -t docker.nexus.archi-lab.io/archilab/fae-shop-demo .

**Shop Demo Netzwerk erstellen**

docker create network shop_demo_backend

**Applikation mitsamt Datenbank starten**

docker-compose -f "./src/main/docker/docker-compose.yml" up

**Applikation mitsamt Datenbank stoppen**

docker-compose -f "./src/main/docker/docker-compose.yml" down
