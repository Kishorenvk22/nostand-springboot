
FROM openjdk:8-jdk-slim
WORKDIR /app
COPY target/foodProject-0.0.1-SNAPSHOT.jar foodProject.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","foodProject.jar"]