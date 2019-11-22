FROM openjdk:8-jdk-alpine

MAINTAINER PRASHANT
LABEL description="Oauth2 Microservice"
ADD  ./target/oauth-server-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 7777
CMD ["java", "-Xmx1024m", "-jar", "/app/service.jar"]
