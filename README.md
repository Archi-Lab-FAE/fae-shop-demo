# Fae Shop Demo
## In Docker-Umgebung ausführen
Folgende Kommandos sollten im Root-Verzeichnis der Applikation ausgeführt werden:

**Ausführbare .jar Datei bauen**

mvn clean package

**Docker Image bauen**

docker build -f "./Dockerfile" -t docker.nexus.archi-lab.io/archilab/shop-demo .

**Shop Demo Netzwerk erstellen**

docker create network fae_backend

**Applikation mitsamt Datenbank starten**

./start-service-dev.sh

**Applikation mitsamt Datenbank stoppen**

./stop-service-dev.sh
