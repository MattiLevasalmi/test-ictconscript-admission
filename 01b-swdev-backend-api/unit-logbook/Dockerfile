# Build stage
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /build

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN ./mvnw dependency:resolve -B

COPY src ./src

RUN ./mvnw package

# Runtime
FROM eclipse-temurin:21-jre-jammy

RUN groupadd -r appuser && useradd -r -g appuser -d /app appuser

WORKDIR /app

COPY --from=builder /build/target/*jar ./app.jar

USER appuser

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]