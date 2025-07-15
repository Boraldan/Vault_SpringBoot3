FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
RUN mkdir -p logs
COPY --from=build /build/target/*-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


