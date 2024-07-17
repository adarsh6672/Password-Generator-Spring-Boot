FROM maven:3.8.5-opnejdk-17 AS build
COPY . .
RUN mvn clean install

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/password-generator-0.0.1-SNAPSHOT.jar password-generator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/password-generator.jar"]
