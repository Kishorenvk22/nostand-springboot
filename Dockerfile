FROM maven:4.0.0-openjdk-1.8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-slim
COPY --from=build /target/foodProject-0.0.1-SNAPSHOT.jar foodProject.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","foodProject.jar"]