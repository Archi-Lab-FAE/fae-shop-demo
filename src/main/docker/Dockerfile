FROM openjdk:8-slim

CMD apt update
CMD apt install -y curl

EXPOSE 8080
COPY target/shop-demo-0.0.1-SNAPSHOT.jar app-shop-demo.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app-shop-demo.jar" ]
