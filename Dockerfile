FROM maven:3.8.5-opnejdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY ./target/password-generator-0.0.1-SNAPSHOT.jar password-generator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/password-generator.jar"]
