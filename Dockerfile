FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/password-generator-0.0.1-SNAPSHOT.jar password-generator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/password-generator.jar"]
