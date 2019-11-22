FROM openjdk:8-jdk-alpine

MAINTAINER PRASHANT
LABEL description="Employee Microservice"
ADD  ./target/employee-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 7003
CMD ["java", "-Xmx1024m", "-jar", "/app/service.jar"]
