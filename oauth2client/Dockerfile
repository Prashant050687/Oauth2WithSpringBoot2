FROM openjdk:8-jdk-alpine

MAINTAINER PRASHANT
LABEL description="Oauth2 Microservice Client"
ADD  ./target/oauth2client-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 7004
CMD ["java", "-Xmx1024m", "-jar", "/app/service.jar"]
