FROM maven:3.8-eclipse-temurin-21 AS base

WORKDIR /app

COPY . ./

RUN mvn install
RUN mvn clean package


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=base /app/target/serviceDiscovery-0.0.1-SNAPSHOT.jar service-discovery.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD [ "curl", "--fail", "http://localhost:8761/actuator/health" ]

ENTRYPOINT ["java", "-jar", "service-discovery.jar"]