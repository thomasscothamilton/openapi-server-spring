# ---- Build Stage ----
FROM maven:3-eclipse-temurin-20 AS build
WORKDIR /app
COPY . .
COPY openapi.yaml ./
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/openapi-spring-1.0.0.jar"]
